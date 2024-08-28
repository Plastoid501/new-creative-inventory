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

//#if MC <= 11402
//$$ import net.minecraft.ChatFormat;
//#endif
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.decoration.AbstractDecorationEntity;
//#if MC <= 11802
//$$ import net.minecraft.entity.decoration.painting.PaintingMotive;
//#else
import net.minecraft.entity.decoration.painting.PaintingVariant;
//#endif
import net.minecraft.item.DecorationItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
//#if MC <= 11601
//$$ import net.minecraft.nbt.CompoundTag;
//#else
import net.minecraft.nbt.NbtCompound;
//#endif
//#if MC <= 11402
//$$ import net.minecraft.network.chat.Component;
//$$ import net.minecraft.network.chat.Style;
//$$ import net.minecraft.network.chat.TranslatableComponent;
//#endif
//#if MC <= 11402
//$$ import net.minecraft.network.chat.TranslatableComponent;
//#elseif MC <= 11802
//$$ import net.minecraft.text.TranslatableText;
//#endif
//#if MC > 11402
import net.minecraft.text.Text;
//#endif
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;

import java.util.List;

@Mixin(DecorationItem.class)
public class DecorationItemMixin extends Item
{
    private final EntityType<? extends AbstractDecorationEntity> entityType;

    public DecorationItemMixin(EntityType<? extends AbstractDecorationEntity> type, Settings settings)
    {
        super(settings);
        this.entityType = type;
    }

    @Override
    public void appendTooltip(ItemStack stack,
                              @Nullable World world,
                              //#if MC <= 11402
                              //$$ List<Component> tooltip,
                              //#else
                              List<Text> tooltip,
                              //#endif
                              TooltipContext context
    )
    {
        super.appendTooltip(stack, world, tooltip, context);
        //#if MC <= 11601
        //$$ CompoundTag nbtCompound = stack.getTag();
        //#else
        NbtCompound nbtCompound = stack.getNbt();
        //#endif

        if (nbtCompound != null && nbtCompound.contains("EntityTag", 10))
        {
            //#if MC <= 11601
            //$$ CompoundTag nbtCompound2 = nbtCompound.getCompound("EntityTag");
            //#else
            NbtCompound nbtCompound2 = nbtCompound.getCompound("EntityTag");
            //#endif
            if (nbtCompound2 != null &&
                    nbtCompound2.contains(
                            //#if MC >= 11900
                            "variant",
                            //#else
                            //$$ "Motive",
                            //#endif
                            8
                    )
            )
            {
                String title = nbtCompound2.getString(
                        //#if MC >= 11900
                        "variant"
                        //#else
                        //$$ "Motive"
                        //#endif
                );
                //#if MC  >= 11900
                PaintingVariant paintingMotive = Registry.PAINTING_VARIANT.get(new Identifier(title));
                //#elseif MC <= 11402
                //$$ PaintingMotive paintingMotive = Registry.MOTIVE.get(new Identifier(title));
                //#else
                //$$ PaintingMotive paintingMotive = Registry.PAINTING_MOTIVE.get(new Identifier(title));
                //#endif
                title = title.replace(":", ".");
                tooltip.add(
                        //#if MC <= 11402
                        //$$ (new TranslatableComponent("painting." + title + ".title")).applyFormat(ChatFormat.YELLOW)
                        //#elseif MC <= 11802
                        //$$ (new TranslatableText("painting." + title + ".title")).formatted(Formatting.YELLOW)
                        //#elseif MC <= 11902
                        (Text.translatable("painting." + title + ".title")).formatted(Formatting.YELLOW)
                        //#endif
                );
                tooltip.add(
                        //#if MC <= 11402
                        //$$ (new TranslatableComponent("painting." + title + ".author")).applyFormat(ChatFormat.GRAY)
                        //#elseif MC <= 11802
                        //$$ (new TranslatableText("painting." + title + ".author")).formatted(Formatting.GRAY)
                        //#elseif MC <= 11902
                        (Text.translatable("painting." + title + ".author")).formatted(Formatting.GRAY)
                        //#endif
                );
                tooltip.add(
                        //#if MC <= 11402
                        //$$ new TranslatableComponent("painting.dimensions", Math.floorDiv(paintingMotive.getWidth(), 16),Math.floorDiv(paintingMotive.getHeight(), 16))
                        //#elseif MC <= 11802
                        //$$ new TranslatableText("painting.dimensions", Math.floorDiv(paintingMotive.getWidth(), 16),Math.floorDiv(paintingMotive.getHeight(), 16))
                        //#elseif MC <= 11902
                        Text.translatable("painting.dimensions", Math.floorDiv(paintingMotive.getWidth(), 16),Math.floorDiv(paintingMotive.getHeight(), 16))
                        //#endif
                );
            } else
            {
                MinecraftClient client = MinecraftClient.getInstance();
                if (client.player != null && client.player.isCreative())
                {
                    tooltip.add(
                            //#if MC <= 11402
                            //$$ (new TranslatableComponent("painting.random")).applyFormat(ChatFormat.GRAY)
                            //#elseif MC <= 11802
                            //$$ (new TranslatableText("painting.random")).formatted(Formatting.GRAY)
                            //#elseif MC <= 11902
                            (Text.translatable("painting.random")).formatted(Formatting.GRAY)
                            //#endif
                    );
                }
            }
        } else {
            MinecraftClient client = MinecraftClient.getInstance();
            if (client.player != null && client.player.isCreative())
            {
                tooltip.add(
                        //#if MC <= 11402
                        //$$ (new TranslatableComponent("painting.random")).applyFormat(ChatFormat.GRAY)
                        //#elseif MC <= 11802
                        //$$ (new TranslatableText("painting.random")).formatted(Formatting.GRAY)
                        //#elseif MC <= 11902
                        (Text.translatable("painting.random")).formatted(Formatting.GRAY)
                        //#endif
                );
            }
        }
    }

}
