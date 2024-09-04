/*
 * This file is part of the New Creative Inventory project, licensed under the
 * GNU Lesser General Public License v3.0
 *
 * Copyright (C) 2024  Plastoid501 and contributors
 *
 * New Creative Inventory is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * New Creative Inventory is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with New Creative Inventory.  If not, see <https://www.gnu.org/licenses/>.
 */

package net.plastoid501.nci.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import com.llamalad7.mixinextras.sugar.ref.LocalIntRef;
import com.llamalad7.mixinextras.sugar.ref.LocalRef;
//#if MC <= 11404
//$$ import com.mojang.blaze3d.platform.GlStateManager;
//#else
import com.mojang.blaze3d.systems.RenderSystem;
//#endif
//#if MC <= 11402
//$$ import net.minecraft.ChatFormat;
//#endif
import net.minecraft.block.Blocks;
import net.minecraft.client.gui.screen.ingame.AbstractInventoryScreen;
import net.minecraft.client.gui.screen.ingame.CreativeInventoryScreen;
import net.minecraft.client.gui.screen.ingame.InventoryScreen;
import net.minecraft.client.gui.widget.TextFieldWidget;
//#if MC <= 11402
//$$ import net.minecraft.client.render.GuiLighting;
//#elseif MC <= 11404
//$$ import net.minecraft.client.render.DiffuseLighting;
//#endif
//#if MC <= 11502
//$$ import net.minecraft.client.resource.language.I18n;
//#endif
import net.minecraft.client.render.GameRenderer;
//#if MC >= 11600
import net.minecraft.client.util.math.MatrixStack;
//#endif
//#if MC <= 11402
//$$ import net.minecraft.entity.player.PlayerEntity;
//#else
import net.minecraft.entity.player.PlayerInventory;
//#endif

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
//#if MC <= 11502
//$$ import net.minecraft.container.Slot;
//$$ import net.minecraft.container.SlotActionType;
//#else
import net.minecraft.screen.slot.Slot;
import net.minecraft.screen.slot.SlotActionType;
//#endif

//#if MC <= 11402
//$$ import net.minecraft.network.chat.TextComponent;
//$$ import net.minecraft.network.chat.TranslatableComponent;
//#elseif MC <= 11802
//$$ import net.minecraft.text.TranslatableText;
//#endif
//#if MC > 11402
import net.minecraft.text.Text;
//#endif
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
//#if MC <= 11502
//$$ import net.minecraft.util.DefaultedList;
//#else
import net.minecraft.util.collection.DefaultedList;
//#endif
import net.plastoid501.nci.item.NewItemGroup;
import net.plastoid501.nci.item.NewItemGroups;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Mixin(value = CreativeInventoryScreen.class, priority = 900)
//#if MC <= 11502
//$$ public abstract class CreativeInventoryScreenMixin extends AbstractInventoryScreen<CreativeInventoryScreen.CreativeContainer>
//#else
public abstract class CreativeInventoryScreenMixin extends AbstractInventoryScreen<CreativeInventoryScreen.CreativeScreenHandler>
//#endif
{
    @Shadow private static int selectedTab;
    @Shadow private float scrollPosition;
    @Shadow private TextFieldWidget searchBox;
    //#if MC <= 11402
    //$$ @Shadow public abstract boolean doRenderScrollBar();
    //#else
    @Shadow public abstract boolean hasScrollbar();
    //#endif
    //#if MC <= 11404
    //$$ @Shadow protected abstract void method_2468(ItemGroup group);
    //#elseif MC <= 11502
    //$$ @Shadow protected abstract void renderTabIcon(ItemGroup group);
    //#else
    @Shadow protected abstract void renderTabIcon(MatrixStack matrices, ItemGroup group);
    //#endif

    @Unique private static final Identifier TEXTURE = new Identifier("textures/gui/container/creative_inventory/tabs.png");
    @Unique private static final int TAB_WIDTH = 26;
    @Unique private static final int TAB_HEIGHT = 32;
    @Unique private static final ItemGroup[] GROUPS;
    @Unique private static final ItemGroup BUILDING_BLOCKS;
    @Unique private static final ItemGroup COLORED_BLOCKS;
    @Unique private static final ItemGroup NATURAL;
    @Unique private static final ItemGroup FUNCTIONAL;
    @Unique private static final ItemGroup REDSTONE;
    @Unique private static final ItemGroup HOTBAR;
    @Unique private static final ItemGroup SEARCH;
    @Unique private static final ItemGroup TOOLS;
    @Unique private static final ItemGroup COMBAT;
    @Unique private static final ItemGroup FOOD_AND_DRINK;
    @Unique private static final ItemGroup INGREDIENTS;
    @Unique private static final ItemGroup SPAWN_EGGS;
    @Unique private static final ItemGroup OPERATOR;
    @Unique private static final ItemGroup INVENTORY2;
    @Unique private static int postSelectedTab = 0;

    public CreativeInventoryScreenMixin(
            //#if MC <= 11402
            //$$ PlayerEntity playerEntity
            //#else
            //#if MC <= 11502
            //$$ CreativeInventoryScreen.CreativeContainer screenHandler,
            //#else
            CreativeInventoryScreen.CreativeScreenHandler screenHandler,
            //#endif
            PlayerInventory playerInventory,
            Text text
            //#endif
    )
    {
        //#if MC <= 11402
        //$$ super(new CreativeInventoryScreen.CreativeContainer(playerEntity), playerEntity.inventory, new TextComponent(""));
        //#else
        super(screenHandler, playerInventory, text);
        //#endif
    }

    @Redirect(method = "onMouseClick", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemGroup;getIndex()I"))
    protected int modifyOnMouseClick1(ItemGroup instance)
    {
        return NewItemGroups.INVENTORY.getIndex();
    }

    @Inject(
            method = "onMouseClick",
            at = @At(
                    value = "INVOKE",
                    //#if MC <= 11502
                    //$$ target = "Lnet/minecraft/container/PlayerContainer;getStacks()Lnet/minecraft/util/DefaultedList;"
                    //#else
                    target = "Lnet/minecraft/screen/PlayerScreenHandler;getStacks()Lnet/minecraft/util/collection/DefaultedList;"
                    //#endif
            )
    )
    private void modifyOnMouseClick2(Slot slot, int slotId, int button, SlotActionType actionType, CallbackInfo ci)
    {
        //#if MC <= 11502
        //$$ if (this.minecraft == null || this.minecraft.player == null)
        //$$ {
        //$$     return;
        //$$ }
        //$$ this.minecraft.player.inventory.clear();
        //#else
        if (this.client == null || this.client.player == null)
        {
            return;
        }
        //#if MC <= 11605
        //$$ this.client.player.inventory.clear();
        //#else
        this.client.player.getInventory().clear();
        //#endif
        //#endif
    }

    @Redirect(method = "init()V", at = @At(value = "FIELD", target = "Lnet/minecraft/item/ItemGroup;GROUPS:[Lnet/minecraft/item/ItemGroup;"))
    protected ItemGroup[] modifyInit()
    {
        return GROUPS;
    }

    @Redirect(method = "charTyped", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemGroup;getIndex()I"))
    private int modifyCharTyped(ItemGroup instance)
    {
        return NewItemGroups.SEARCH.getIndex();
    }

    @Redirect(method = "keyPressed", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemGroup;getIndex()I"))
    private int modifyKeyPressed1(ItemGroup instance)
    {
        return NewItemGroups.SEARCH.getIndex();
    }

    @Redirect(method = "keyPressed", at = @At(value = "FIELD", target = "Lnet/minecraft/item/ItemGroup;SEARCH:Lnet/minecraft/item/ItemGroup;"))
    private ItemGroup modifyKeyPressed2()
    {
        return SEARCH;
    }

    @Redirect(
            //#if MC <= 11404
            //$$ method = "method_2464",
            //#else
            method = "search",
            //#endif
            at = @At(value = "INVOKE", target = "Ljava/util/Iterator;hasNext()Z"))
    private boolean modifySearch(Iterator<Item> instance)
    {
        for (NewItemGroup itemGroup : NewItemGroups.GROUPS)
        {
            for (ItemStack itemStack : itemGroup.getItems())
            {
                itemGroup.appendStacksWithoutSameItemStack(
                        //#if MC <= 11502
                        //$$ this.container.itemList,
                        //#else
                        this.handler.itemList,
                        //#endif
                        itemStack
                );
            }
        }
        return false;
    }

    @Redirect(method = "drawForeground", at = @At(value = "FIELD", target = "Lnet/minecraft/item/ItemGroup;GROUPS:[Lnet/minecraft/item/ItemGroup;"))
    protected ItemGroup[] modifyDrawForeground1()
    {
        return GROUPS;
    }

    @Redirect(
            method = "drawForeground",
            at = @At(
                    value = "INVOKE",
                    //#if MC <= 11601
                    //$$ target = "Lnet/minecraft/item/ItemGroup;hasTooltip()Z"
                    //#else
                    target = "Lnet/minecraft/item/ItemGroup;shouldRenderName()Z"
                    //#endif
            )
    )
    protected boolean modifyDrawForeground2(ItemGroup instance)
    {
        return instance != INVENTORY2;
    }

    @Redirect(
            method = "drawForeground",
            at = @At(
                    value = "INVOKE",
                    //#if MC <= 11601
                    //$$ target = "Lnet/minecraft/item/ItemGroup;getTranslationKey()Ljava/lang/String;"
                    //#elseif MC <= 11701
                    //$$ target = "Lnet/minecraft/item/ItemGroup;getTranslationKey()Lnet/minecraft/text/Text;"
                    //#else
                    target = "Lnet/minecraft/item/ItemGroup;getDisplayName()Lnet/minecraft/text/Text;"
                    //#endif
            )
    )
    //#if MC <= 11601
    //$$ protected String modifyDrawForeground3(ItemGroup instance)
    //$$ {
    //$$     return this.getNewItemGroup(instance).getTranslationKey();
    //$$ }
    //#else
    protected Text modifyDrawForeground3(ItemGroup instance)
    {
        postSelectedTab = selectedTab;
        selectedTab = 0;
        return this.getNewItemGroup(instance).getDisplayName();
    }
    //#endif

    @Inject(method = "drawForeground", at = @At(value = "RETURN"))
    protected void modifyDrawForeground4(
            //#if MC >= 11600
            MatrixStack matrices,
            //#endif
            int mouseX, int mouseY, CallbackInfo ci
    )
    {
        if (postSelectedTab != 0) {
            selectedTab = postSelectedTab;
            postSelectedTab = 0;
        }
    }

    @Redirect(method = "mouseClicked", at = @At(value = "FIELD", target = "Lnet/minecraft/item/ItemGroup;GROUPS:[Lnet/minecraft/item/ItemGroup;"))
    public ItemGroup[] modifyMouseClicked1()
    {
        return GROUPS;
    }

    @Redirect(method = "mouseClicked", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemGroup;getIndex()I"))
    public int modifyMouseClicked2(ItemGroup instance)
    {
        return NewItemGroups.INVENTORY.getIndex();
    }

    @Redirect(method = "mouseReleased", at = @At(value = "FIELD", target = "Lnet/minecraft/item/ItemGroup;GROUPS:[Lnet/minecraft/item/ItemGroup;"))
    public ItemGroup[] modifyMouseReleased1()
    {
        return GROUPS;
    }

    @Inject(method = "hasScrollbar", at = @At("HEAD"), cancellable = true)
    private void modifyHasScrollbar(CallbackInfoReturnable<Boolean> cir)
    {
        cir.setReturnValue(
                selectedTab != NewItemGroups.INVENTORY.getIndex() &&
                        //#if MC <= 11404
                        //$$ this.container.method_2474()
                        //#elseif MC <= 11502
                        //$$ this.container.shouldShowScrollbar()
                        //#else
                        this.handler.shouldShowScrollbar()
                        //#endif
        );
        cir.cancel();
    }

    @Redirect(method = "setSelectedTab", at = @At(value = "FIELD", target = "Lnet/minecraft/item/ItemGroup;HOTBAR:Lnet/minecraft/item/ItemGroup;"))
    private ItemGroup modifySetSelectedTab1()
    {
        return HOTBAR;
    }

    @Redirect(method = "setSelectedTab", at = @At(value = "FIELD", target = "Lnet/minecraft/item/ItemGroup;SEARCH:Lnet/minecraft/item/ItemGroup;"))
    private ItemGroup modifySetSelectedTab2()
    {
        return SEARCH;
    }

    @Redirect(
            method = "setSelectedTab",
            at = @At(
                    value = "INVOKE",
                    //#if MC <= 11502
                    //$$ target = "Lnet/minecraft/item/ItemGroup;appendStacks(Lnet/minecraft/util/DefaultedList;)V"
                    //#else
                    target = "Lnet/minecraft/item/ItemGroup;appendStacks(Lnet/minecraft/util/collection/DefaultedList;)V"
                    //#endif
            )
    )
    private void modifySetSelectedTab3(ItemGroup instance, DefaultedList<ItemStack> stacks)
    {
        this.getNewItemGroup(instance).appendStacks(stacks);
    }

    @Redirect(method = "setSelectedTab", at = @At(value = "FIELD", target = "Lnet/minecraft/item/ItemGroup;INVENTORY:Lnet/minecraft/item/ItemGroup;"))
    private ItemGroup modifySetSelectedTab4()
    {
        return INVENTORY2;
    }

    @ModifyConstant(method = "setSelectedTab", constant = @Constant(intValue = 6))
    private int modifySetSelectedTab5(int constant)
    {
        return 7;
    }

    @Redirect(method = "setSelectedTab", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemGroup;getIndex()I"))
    private int modifySetSelectedTab6(ItemGroup instance)
    {
        return this.getIndex(instance);
    }

    @Redirect(method = "isClickOutsideBounds", at = @At(value = "FIELD", target = "Lnet/minecraft/item/ItemGroup;GROUPS:[Lnet/minecraft/item/ItemGroup;"))
    protected ItemGroup[] modifyIsClickInTab()
    {
        return GROUPS;
    }

    @Redirect(method = "render", at = @At(value = "FIELD", target = "Lnet/minecraft/item/ItemGroup;GROUPS:[Lnet/minecraft/item/ItemGroup;"))
    public ItemGroup[] modifyRender1()
    {
        return GROUPS;
    }

    @Redirect(method = "render", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemGroup;getIndex()I"))
    public int modifyRender2(ItemGroup instance)
    {
        return NewItemGroups.INVENTORY.getIndex();
    }

    @Redirect(method = "renderTooltip", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemGroup;getIndex()I"))
    private int modifyRenderTooltip1(ItemGroup instance)
    {
        if (selectedTab == NewItemGroups.SEARCH.getIndex() || selectedTab == NewItemGroups.INVENTORY.getIndex() || (this.focusedSlot != null && this.focusedSlot.id >= 45))
        {
            return selectedTab;
        }
        return -1;
    }

    @Redirect(method = "renderTooltip", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/Item;getGroup()Lnet/minecraft/item/ItemGroup;"))
    private ItemGroup modifyRenderTooltip2(Item instance)
    {
        return null;
    }


    @Redirect(method = "renderTooltip", at = @At(value = "FIELD", target = "Lnet/minecraft/item/Items;ENCHANTED_BOOK:Lnet/minecraft/item/Item;"))
    private Item modifyRenderTooltip3()
    {
        return ItemStack.EMPTY.getItem();
    }

    @Inject(
            method = "renderTooltip",
            at = @At(
                    value = "INVOKE",
                    //#if MC <= 11502
                    //$$ target = "Lnet/minecraft/client/gui/screen/ingame/CreativeInventoryScreen;renderTooltip(Ljava/util/List;II)V"
                    //#elseif MC <= 11605
                    //$$ target = "Lnet/minecraft/client/gui/screen/ingame/CreativeInventoryScreen;renderTooltip(Lnet/minecraft/client/util/math/MatrixStack;Ljava/util/List;II)V"
                    //#else
                    target = "Lnet/minecraft/client/gui/screen/ingame/CreativeInventoryScreen;renderTooltip(Lnet/minecraft/client/util/math/MatrixStack;Ljava/util/List;Ljava/util/Optional;II)V"
                    //#endif
            )
    )
    private void modifyRenderTooltip4(
            //#if MC >= 11600
            MatrixStack matrices,
            //#endif
            ItemStack stack,
            int x,
            int y,
            CallbackInfo ci,
            //#if MC <= 11502
            //$$ @Local(ordinal = 1) LocalRef<List<String>> localRef
            //#else
            @Local(ordinal = 1) LocalRef<List<Text>> localRef
            //#endif
    )
    {
        //#if MC <= 11502
        //$$ List<String> newItemGroup = this.getNewItemGroups(stack);
        //$$ List<String> list2 = localRef.get();
        //#else
        List<Text> newItemGroup = this.getNewItemGroups(stack);
        List<Text> list2 = localRef.get();
        //#endif

        //#if MC <= 11502
        //$$ for (String text : newItemGroup)
        //#else
        for (Text text : newItemGroup)
        //#endif
        {
            list2.add(
                    1,
                    //#if MC <= 11402
                    //$$ "" + ChatFormat.BOLD + ChatFormat.BLUE + text
                    //#elseif MC <= 11502
                    //$$ "" + Formatting.BOLD + Formatting.BLUE + text
                    //#elseif MC <= 11802
                    //$$ text.shallowCopy().formatted(Formatting.BLUE)
                    //#else
                    text.copy().formatted(Formatting.BLUE)
                    //#endif
            );
        }
        localRef.set(list2);
    }

    @Unique
    //#if MC <= 11502
    //$$ private List<String> getNewItemGroups(ItemStack itemStack)
    //#else
    private List<Text> getNewItemGroups(ItemStack itemStack)
    //#endif
    {
        //#if MC <= 11502
        //$$ List<String> groups = new ArrayList<>();
        //#else
        List<Text> groups = new ArrayList<>();
        //#endif
        if (itemStack.getItem() == Items.ENCHANTED_BOOK)
        {
            groups.add(
                    //#if MC <= 11502
                    //$$ I18n.translate(NewItemGroups.INGREDIENTS.getTranslationKey())
                    //#else
                    NewItemGroups.INGREDIENTS.getDisplayName()
                    //#endif
            );
            return groups;
        }

        for (int i = NewItemGroups.GROUPS.length - 1; 0 <= i; i--)
        {
            NewItemGroup itemGroup = NewItemGroups.GROUPS[i];
            if (itemGroup.containsItemStack(itemGroup.getItems(), itemStack))
            {
                groups.add(
                        //#if MC <= 11502
                        //$$ I18n.translate(itemGroup.getTranslationKey())
                        //#else
                        itemGroup.getDisplayName()
                        //#endif
                );
            }
        }
        return groups;
    }

    @Override
    public void drawBackground(
            //#if MC >= 11600
            MatrixStack matrices,
            //#endif
            float delta,
            int mouseX,
            int mouseY
    )
    {
        postSelectedTab = selectedTab;
        selectedTab = 0;
        //#if MC <= 11402
        //$$ GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        //$$ GuiLighting.enableForItems();
        //#elseif MC <= 11404
        //$$ GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        //$$ DiffuseLighting.enableForItems();
        //#elseif MC <= 11605
        //$$ RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        //#else
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        //#endif
        ItemGroup itemGroup = GROUPS[postSelectedTab];
        NewItemGroup itemGroup2 = NewItemGroups.GROUPS[postSelectedTab];

        int k;
        for (ItemGroup itemGroup3 : GROUPS)
        {
            //#if MC <= 11502
            //$$ this.minecraft.getTextureManager().bindTexture(TEXTURE);
            //#elseif MC <= 11605
            //$$ this.client.getTextureManager().bindTexture(TEXTURE);
            //#else
            RenderSystem.setShader(GameRenderer::getPositionTexShader);
            RenderSystem.setShaderTexture(0, TEXTURE);
            //#endif

            if (itemGroup3.getIcon().getCount() - 1 != postSelectedTab)
            {
                //#if MC <= 11404
                //$$ this.method_2468(itemGroup3);
                //#else
                this.renderTabIcon(
                        //#if MC >= 11600
                        matrices,
                        //#endif
                        itemGroup3
                );
                //#endif
            }
        }

        //#if MC <= 11502
        //$$ this.minecraft.getTextureManager().bindTexture(new Identifier("textures/gui/container/creative_inventory/tab_" + itemGroup2.getTexture()));
        //#elseif MC <= 11605
        //$$ this.client.getTextureManager().bindTexture(new Identifier("textures/gui/container/creative_inventory/tab_" + itemGroup2.getTexture()));
        //#else
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderTexture(0, new Identifier("textures/gui/container/creative_inventory/tab_" + itemGroup2.getTexture()));
        //#endif
        //#if MC <= 11502
        //$$ this.blit(this.x, this.y, 0, 0, this.containerWidth, this.containerHeight);
        //#else
        this.drawTexture(matrices, this.x, this.y, 0, 0, this.backgroundWidth, this.backgroundHeight);
        //#endif
        this.searchBox.render(
                //#if MC > 11502
                matrices,
                //#endif
                mouseX,
                mouseY,
                delta
        );
        //#if MC <= 11404
        //$$ GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        //#elseif MC <= 11605
        //$$ RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        //#else
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        //#endif
        //#if MC <= 11402
        //$$ int i = this.left + 175;
        //$$ int y = this.top + 18;
        //#else
        int i = this.x + 175;
        int y = this.y + 18;
        //#endif
        k = y + 112;

        //#if MC <= 11502
        //$$ this.minecraft.getTextureManager().bindTexture(TEXTURE);
        //#elseif MC <= 11605
        //$$ this.client.getTextureManager().bindTexture(TEXTURE);
        //#else
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderTexture(0, TEXTURE);
        //#endif
        if (itemGroup != INVENTORY2) {
            //#if MC <= 11402
            //$$ this.blit(i, y + (int)((float)(k - y - 17) * this.scrollPosition), 232 + (this.doRenderScrollBar() ? 0 : 12), 0, 12, 15);
            //#elseif MC <= 11502
            //$$ this.blit(i, y + (int)((float)(k - y - 17) * this.scrollPosition), 232 + (this.hasScrollbar() ? 0 : 12), 0, 12, 15);
            //#else
            this.drawTexture(matrices, i, y + (int)((float)(k - y - 17) * this.scrollPosition), 232 + (this.hasScrollbar() ? 0 : 12), 0, 12, 15);
            //#endif
        }

        //#if MC <= 11404
        //$$ this.method_2468(itemGroup);
        //#else
        this.renderTabIcon(
                //#if MC >= 11600
                matrices,
                //#endif
                itemGroup);
        //#endif
        if (itemGroup == INVENTORY2)
        {
            InventoryScreen.drawEntity(
                    //#if MC <= 11402
                    //$$ this.left + 88,
                    //$$ this.top + 45,
                    //$$ 20,
                    //$$ (float)(this.left + 88 - mouseX),
                    //$$ (float)(this.top + 45 - 30 - mouseY),
                    //#if MC <= 11502
                    //$$ this.minecraft.player
                    //#else
                    //$$ this.client.player
                    //#endif

                    //#else
                    this.x + 88,
                    this.y + 45,
                    20,
                    (float)(this.x + 88 - mouseX),
                    (float)(this.y + 45 - 30 - mouseY),
                    //#if MC <= 11502
                    //$$ this.minecraft.player
                    //#else
                    this.client.player
                    //#endif
                    //#endif
            );
        }

        selectedTab = postSelectedTab;
        postSelectedTab = 0;
    }

    @ModifyConstant(
            method = "isClickInTab",
            constant = @Constant(intValue = 28),
            slice = @Slice(
                    from = @At(value = "HEAD"),
                    to = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemGroup;isTopRow()Z")
            )
    )
    private int modifyIsClickInTab1(int constant)
    {
        return TAB_WIDTH + 1;
    }

    @ModifyConstant(method = "isClickInTab", constant = @Constant(intValue = 28, ordinal = 2))
    private int modifyIsClickInTab2(int constant)
    {
        return TAB_WIDTH;
    }

    @ModifyConstant(method = "isClickInTab", constant = @Constant(intValue = 6))
    private int modifyIsClickInTab3(int constant)
    {
        return 7;
    }

    @ModifyConstant(method = "isClickInTab", constant = @Constant(intValue = 2))
    private int modifyIsClickInTab4(int constant)
    {
        return 1;
    }

    @Redirect(method = "isClickInTab", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemGroup;getColumn()I"))
    private int modifyIsClickInTab5(ItemGroup instance)
    {
        return this.getNewItemGroup(instance).getColumn();
    }

    @Redirect(method = "isClickInTab", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemGroup;isSpecial()Z"))
    private boolean modifyIsClickInTab6(ItemGroup instance)
    {
        return this.getNewItemGroup(instance).isSpecial();
    }

    @Redirect(method = "isClickInTab", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemGroup;isTopRow()Z"))
    private boolean modifyIsClickInTab7(ItemGroup instance)
    {
        return this.getNewItemGroup(instance).isTopRow();
    }

    @Inject(method = "isClickInTab", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemGroup;isSpecial()Z"))
    private void modifyIsClickInTab8(ItemGroup group, double mouseX, double mouseY, CallbackInfoReturnable<Boolean> cir, @Local(ordinal = 1) LocalIntRef j)
    {
        NewItemGroup newItemGroup = this.getNewItemGroup(group);
        if (!newItemGroup.isSpecial() && newItemGroup.getColumn() > 0)
        {
            j.set(j.get() - newItemGroup.getColumn());
        }
    }

    @ModifyConstant(
            //#if MC <= 11404
            //$$ method = "method_2471",
            //#else
            method = "renderTabTooltipIfHovered",
            //#endif
            constant = @Constant(intValue = 28)
    )
    private int modifyRenderTabTooltipIfHovered1(int constant)
    {
        return TAB_WIDTH + 1;
    }

    @ModifyConstant(
            //#if MC <= 11404
            //$$ method = "method_2471",
            //#else
            method = "renderTabTooltipIfHovered",
            //#endif
            constant = @Constant(intValue = 6)
    )
    private int modifyRenderTabTooltipIfHovered2(int constant)
    {
        return 7;
    }

    @ModifyConstant(
            //#if MC <= 11404
            //$$ method = "method_2471",
            //#else
            method = "renderTabTooltipIfHovered",
            //#endif
            constant = @Constant(intValue = 2)
    )
    private int modifyRenderTabTooltipIfHovered3(int constant)
    {
        return 1;
    }

    @ModifyConstant(
            //#if MC <= 11404
            //$$ method = "method_2471",
            //#else
            method = "renderTabTooltipIfHovered",
            //#endif
            constant = @Constant(intValue = 23)
    )
    private int modifyRenderTabTooltipIfHovered4(int constant)
    {
        return 21;
    }

    @Redirect(
            //#if MC <= 11404
            //$$ method = "method_2471",
            //#else
            method = "renderTabTooltipIfHovered",
            //#endif
            at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemGroup;getColumn()I")
    )
    private int modifyRenderTabTooltipIfHovered5(ItemGroup instance)
    {
        return this.getNewItemGroup(instance).getColumn();
    }

    @Redirect(
            //#if MC <= 11404
            //$$ method = "method_2471",
            //#else
            method = "renderTabTooltipIfHovered",
            //#endif
            at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemGroup;isSpecial()Z")
    )
    private boolean modifyRenderTabTooltipIfHovered6(ItemGroup instance)
    {
        return this.getNewItemGroup(instance).isSpecial();
    }

    @Redirect(
            //#if MC <= 11404
            //$$ method = "method_2471",
            //#else
            method = "renderTabTooltipIfHovered",
            //#endif
            at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemGroup;isTopRow()Z")
    )
    private boolean modifyRenderTabTooltipIfHovered7(ItemGroup instance)
    {
        return this.getNewItemGroup(instance).isTopRow();
    }

    @Redirect(
            //#if MC <= 11404
            //$$ method = "method_2471",
            //#else
            method = "renderTabTooltipIfHovered",
            //#endif
            at = @At(
                    value = "INVOKE",
                    //#if MC <= 11601
                    //$$ target = "Lnet/minecraft/item/ItemGroup;getTranslationKey()Ljava/lang/String;"
                    //#elseif MC <= 11701
                    //$$ target = "Lnet/minecraft/item/ItemGroup;getTranslationKey()Lnet/minecraft/text/Text;"
                    //#else
                    target = "Lnet/minecraft/item/ItemGroup;getDisplayName()Lnet/minecraft/text/Text;"
                    //#endif
            )
    )
    //#if MC <= 11601
    //$$ private String modifyRenderTabTooltipIfHovered8(ItemGroup instance)
    //$$ {
    //$$     return this.getNewItemGroup(instance).getTranslationKey();
    //$$ }
    //#else
    private Text modifyRenderTabTooltipIfHovered8(ItemGroup instance)
    {
        return this.getNewItemGroup(instance).getDisplayName();
    }
    //#endif

    @Inject(
            //#if MC <= 11404
            //$$ method = "method_2471",
            //#else
            method = "renderTabTooltipIfHovered",
            //#endif
            at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemGroup;isSpecial()Z")
    )
    private void modifyRenderTabTooltipIfHovered9(
            //#if MC >= 11600
            MatrixStack matrices,
            //#endif
            ItemGroup group,
            int mouseX, int mouseY,
            CallbackInfoReturnable<Boolean> cir,
            @Local(ordinal = 3) LocalIntRef j
    )
    {
        NewItemGroup newItemGroup = this.getNewItemGroup(group);
        if (!newItemGroup.isSpecial() && newItemGroup.getColumn() > 0)
        {
            j.set(j.get() - newItemGroup.getColumn());
        }
    }

    @Redirect(
            //#if MC <= 11404
            //$$ method = "method_2468",
            //#else
            method = "renderTabIcon",
            //#endif
            at = @At(value = "FIELD", target = "Lnet/minecraft/client/gui/screen/ingame/CreativeInventoryScreen;selectedTab:I")
    )
    private int modifyRenderTabIcon0()
    {
        return postSelectedTab;
    }

    @Redirect(
            //#if MC <= 11404
            //$$ method = "method_2468",
            //#else
            method = "renderTabIcon",
            //#endif
            at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemGroup;getIndex()I")
    )
    private int modifyRenderTabIcon1(ItemGroup instance)
    {
        return this.getIndex(instance);
    }

    @Redirect(
            //#if MC <= 11404
            //$$ method = "method_2468",
            //#else
            method = "renderTabIcon",
            //#endif
            at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemGroup;isTopRow()Z")
    )
    private boolean modifyRenderTabIcon2(ItemGroup instance)
    {
        return this.getNewItemGroup(instance).isTopRow();
    }

    @Redirect(
            //#if MC <= 11404
            //$$ method = "method_2468",
            //#else
            method = "renderTabIcon",
            //#endif
            at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemGroup;getColumn()I")
    )
    private int modifyRenderTabIcon3(ItemGroup instance)
    {
        return this.getIndex(instance);
    }

    @Redirect(
            //#if MC <= 11404
            //$$ method = "method_2468",
            //#else
            method = "renderTabIcon",
            //#endif
            at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemGroup;isSpecial()Z")
    )
    private boolean modifyRenderTabIcon4(ItemGroup instance)
    {
        return false;
    }

    @ModifyVariable(
            //#if MC <= 11404
            //$$ method = "method_2468",
            //#else
            method = "renderTabIcon",
            //#endif
            at = @At("STORE"),
            ordinal = 3
    )
    private int modifyRenderTabIcon5(int x)
    {
        return 0;
    }

    @Redirect(
            //#if MC <= 11404
            //$$ method = "method_2468",
            //#else
            method = "renderTabIcon",
            //#endif
            at = @At(
                    value = "INVOKE",
                    //#if MC <= 11502
                    //$$ target = "Lnet/minecraft/client/gui/screen/ingame/CreativeInventoryScreen;blit(IIIIII)V"
                    //#else
                    target = "Lnet/minecraft/client/gui/screen/ingame/CreativeInventoryScreen;drawTexture(Lnet/minecraft/client/util/math/MatrixStack;IIIIII)V"
                    //#endif
            )
    )
    private void modifyRenderTabIcon6(CreativeInventoryScreen instance,
                                      //#if MC >= 11600
                                      MatrixStack matrixStack,
                                      //#endif
                                      int x, int y, int u, int v, int width, int height)
    {
        int index = u / 28;
        NewItemGroup group = NewItemGroups.GROUPS[index];
        //#if MC <= 11402
        //$$ x = this.left + this.getTabX(group);
        //#else
        x = this.x + this.getTabX(group);
        //#endif
        int j = (u / 28) % 7;
        this.renderTab(
                //#if MC >= 11600
                matrixStack,
                //#endif
                x, y, j == 6 ? 5 * 28 : j * 28, v
        );
    }

    @ModifyArg(
            //#if MC <= 11404
            //$$ method = "method_2468",
            //#else
            method = "renderTabIcon",
            //#endif
            at = @At(
                    value = "INVOKE",
                    //#if MC <= 11502
                    //$$ target = "Lnet/minecraft/client/render/item/ItemRenderer;renderGuiItem(Lnet/minecraft/item/ItemStack;II)V"
                    //#else
                    target = "Lnet/minecraft/client/render/item/ItemRenderer;renderInGuiWithOverrides(Lnet/minecraft/item/ItemStack;II)V"
                    //#endif
            ),
            index = 1
    )
    private int modifyRenderTabIcon7(int x, @Local(ordinal = 1) int u)
    {
        NewItemGroup group = NewItemGroups.GROUPS[u / 28];
        //#if MC <= 11402
        //$$ return this.left + this.getTabX(group) + 5;
        //#else
        return this.x + this.getTabX(group) + 5;
        //#endif
    }

    @ModifyArg(
            //#if MC <= 11404
            //$$ method = "method_2468",
            //#else
            method = "renderTabIcon",
            //#endif
            at = @At(value = "INVOKE", target = "Lnet/minecraft/client/render/item/ItemRenderer;renderGuiItemOverlay(Lnet/minecraft/client/font/TextRenderer;Lnet/minecraft/item/ItemStack;II)V"),
            index = 2
    )
    private int modifyRenderTabIcon8(int x, @Local(ordinal = 1) int u)
    {
        NewItemGroup group = NewItemGroups.GROUPS[u / 28];
        return this.x + this.getTabX(group) + 5;
    }

    @Redirect(
            //#if MC <= 11404
            //$$ method = "method_2468",
            //#else
            method = "renderTabIcon",
            //#endif
            at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemGroup;getIcon()Lnet/minecraft/item/ItemStack;")
    )
    private ItemStack modifyRenderTabIcon9(ItemGroup instance)
    {
        ItemStack stack = instance.getIcon().copy();
        stack.setCount(1);
        return stack;
    }

    @Unique
    private int getIndex(ItemGroup itemGroup)
    {
        return itemGroup.getIcon().getCount() - 1;
    }

    @Unique
    private NewItemGroup getNewItemGroup(ItemGroup itemGroup)
    {
        return NewItemGroups.GROUPS[this.getIndex(itemGroup)];
    }

    @Unique
    private int getTabX(NewItemGroup group)
    {
        int i = group.getColumn();
        int k = (TAB_WIDTH + 1) * i;
        if (group.isSpecial()) {
            k = this.backgroundWidth - (TAB_WIDTH + 1) * (7 - i) + 1;
        }
        return k;
    }

    @Unique
    private void renderTab(
            //#if MC >= 11600
            MatrixStack matrices,
            //#endif
            int x, int y, int u, int v
    )
    {
        //#if MC <= 11502
        //$$ this.blit(x, y, u, v, 5, TAB_HEIGHT);
        //$$ this.blit(x + 5, y, u + 7, v, TAB_WIDTH - 5, TAB_HEIGHT);
        //#else
        this.drawTexture(matrices, x, y, u, v, 5, TAB_HEIGHT);
        this.drawTexture(matrices, x + 5, y, u + 7, v, TAB_WIDTH - 5, TAB_HEIGHT);
        //#endif
    }

    @Redirect(method = "<clinit>", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemGroup;getIndex()I"))
    private static int modifySelectedTab(ItemGroup instance)
    {
        return NewItemGroups.BUILDING_BLOCKS.getIndex();
    }

    static
    {
        BUILDING_BLOCKS = new ItemGroup(0, "building_blocks")
        {
            @Override
            public ItemStack createIcon()
            {
                ItemStack stack = new ItemStack(Blocks.BRICKS);
                stack.setCount(1);
                return stack;
            }
        };

        COLORED_BLOCKS = new ItemGroup(0, "colored_blocks")
        {
            @Override
            public ItemStack createIcon()
            {
                ItemStack stack = new ItemStack(Blocks.CYAN_WOOL);
                stack.setCount(2);
                return stack;
            }
        };

        NATURAL = new ItemGroup(0, "natural_blocks")
        {
            @Override
            public ItemStack createIcon()
            {
                ItemStack stack = new ItemStack(Blocks.GRASS_BLOCK);
                stack.setCount(3);
                return stack;
            }
        };

        FUNCTIONAL = new ItemGroup(0, "functional_blocks")
        {
            @Override
            public ItemStack createIcon()
            {
                ItemStack stack = new ItemStack(Items.OAK_SIGN);
                stack.setCount(4);
                return stack;
            }
        };

        REDSTONE = new ItemGroup(0, "redstone_blocks")
        {
            @Override
            public ItemStack createIcon()
            {
                ItemStack stack = new ItemStack(Items.REDSTONE);
                stack.setCount(5);
                return stack;
            }
        };

        HOTBAR = new ItemGroup(0, "hotbar")
        {
            @Override
            public ItemStack createIcon()
            {
                ItemStack stack = new ItemStack(Blocks.BOOKSHELF);
                stack.setCount(6);
                return stack;
            }
        };

        SEARCH = new ItemGroup(0, "search")
        {
            @Override
            public ItemStack createIcon()
            {
                ItemStack stack = new ItemStack(Items.COMPASS);
                stack.setCount(7);
                return stack;
            }
        };

        TOOLS = new ItemGroup(0, "tools_and_utilities")
        {
            @Override
            public ItemStack createIcon()
            {
                ItemStack stack = new ItemStack(Items.DIAMOND_PICKAXE);
                stack.setCount(8);
                return stack;
            }
        };

        COMBAT = new ItemGroup(0, "combat")
        {
            @Override
            public ItemStack createIcon()
            {
                ItemStack stack = new ItemStack(
                        //#if MC <= 11502
                        //$$ Items.DIAMOND_SWORD
                        //#else
                        Items.NETHERITE_SWORD
                        //#endif
                );
                stack.setCount(9);
                return stack;
            }
        };

        FOOD_AND_DRINK = new ItemGroup(0, "food_and_drinks")
        {
            @Override
            public ItemStack createIcon()
            {
                ItemStack stack = new ItemStack(Items.GOLDEN_APPLE);
                stack.setCount(10);
                return stack;
            }
        };

        INGREDIENTS = new ItemGroup(0, "ingredients")
        {
            @Override
            public ItemStack createIcon() {
                ItemStack stack = new ItemStack(Items.IRON_INGOT);
                stack.setCount(11);
                return stack;
            }
        };

        SPAWN_EGGS = new ItemGroup(0, "spawn_eggs")
        {
            @Override
            public ItemStack createIcon()
            {
                ItemStack stack = new ItemStack(Items.PIG_SPAWN_EGG);
                stack.setCount(12);
                return stack;
            }
        };

        OPERATOR = new ItemGroup(0, "op_blocks")
        {
            @Override
            public ItemStack createIcon()
            {
                ItemStack stack = new ItemStack(Items.COMMAND_BLOCK);
                stack.setCount(13);
                return stack;
            }
        };

        INVENTORY2 = new ItemGroup(0, "inventory")
        {
            @Override
            public ItemStack createIcon()
            {
                ItemStack stack = new ItemStack(Blocks.CHEST);
                stack.setCount(14);
                return stack;
            }
        };

        GROUPS = new ItemGroup[]
                {
                        BUILDING_BLOCKS,
                        COLORED_BLOCKS,
                        NATURAL,
                        FUNCTIONAL,
                        REDSTONE,
                        HOTBAR,
                        SEARCH,
                        TOOLS,
                        COMBAT,
                        FOOD_AND_DRINK,
                        INGREDIENTS,
                        SPAWN_EGGS,
                        OPERATOR,
                        INVENTORY2
                };

    }
}
