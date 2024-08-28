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

import com.google.common.collect.Lists;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.SuspiciousStewItem;

import net.minecraft.potion.PotionUtil;
import net.minecraft.text.Style;
//#if MC <= 11601
//$$ import net.minecraft.nbt.CompoundTag;
//$$ import net.minecraft.nbt.ListTag;
//#else
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtList;
//#endif
//#if MC <= 11402
//$$ import net.minecraft.network.chat.Component;
//$$ import net.minecraft.network.chat.Style;
//$$ import net.minecraft.network.chat.TextComponent;
//$$ import net.minecraft.network.chat.TranslatableComponent;
//#endif
//#if MC > 11402
import net.minecraft.text.*;
//#endif
import net.minecraft.util.Formatting;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Mixin(SuspiciousStewItem.class)
public class SuspiciousStewItemMixin extends Item
{

    public SuspiciousStewItemMixin(Settings settings)
    {
        super(settings);
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
        MinecraftClient client = MinecraftClient.getInstance();
        if (client.player != null && client.player.isCreative())
        {
            //#if MC <= 11402
            //$$ List<Component> list = this.setEffect(stack).getTooltip(client.player, client.options.advancedItemTooltips ? TooltipContext.Default.ADVANCED : TooltipContext.Default.NORMAL);
            //$$ List<Component> list2 = Lists.newArrayList(list);
            //#else
            List<Text> list = this.setEffect(stack).getTooltip(client.player, client.options.advancedItemTooltips ? TooltipContext.Default.ADVANCED : TooltipContext.Default.NORMAL);
            List<Text> list2 = Lists.newArrayList(list);
            //#endif

            int row = this.getItemNameRow(list2);
            if (row == -1)
            {
                return;
            }
            list2.remove(row);
            list2.add(row,
                    //#if MC <= 11402
                    //$$ (new TranslatableComponent(Items.SUSPICIOUS_STEW.getTranslationKey())).copy()
                    //#elseif MC <= 11802
                    //$$ (new TranslatableText(Items.SUSPICIOUS_STEW.getTranslationKey())).copy()
                    //#elseif MC <= 11902
                    (Text.translatable(Items.SUSPICIOUS_STEW.getTranslationKey())).copy()
                    //#endif
                            .setStyle(
                                    //#if MC <= 11502
                                    //$$ new Style()
                                    //#else
                                    Style.EMPTY
                                    //#endif
                            )
                            //#if MC <= 11402
                            //$$ .applyFormat(ChatFormat.WHITE));
                            //#else
                            .formatted(Formatting.WHITE));
                            //#endif
            int row2 = this.getItemIdRow(list2);
            if (client.options.advancedItemTooltips && list2.size() - 1 > row2)
            {
                list2.remove(row2);
                list2.remove(row2);
            }
            tooltip.clear();
            tooltip.addAll(list2);
        }

    }

    private ItemStack setEffect(ItemStack stack)
    {
        ItemStack itemStack2 = new ItemStack(Items.POTION);
        Collection<StatusEffectInstance> list = new ArrayList<>();
        //#if MC <= 11601
        //$$ CompoundTag nbtCompound = stack.getTag();
        //#else
        NbtCompound nbtCompound = stack.getNbt();
        //#endif

        if (nbtCompound != null && nbtCompound.contains("Effects", 9))
        {
            //#if MC <= 11601
            //$$ ListTag nbtList = nbtCompound.getList("Effects", 10);
            //#else
            NbtList nbtList = nbtCompound.getList("Effects", 10);
            //#endif
            for (int i = 0; i < nbtList.size(); ++i)
            {
                int j = 160;
                //#if MC <= 11601
                //$$ CompoundTag nbtCompound2 = nbtList.getCompound(i);
                //#else
                NbtCompound nbtCompound2 = nbtList.getCompound(i);
                //#endif
                if (nbtCompound2.contains("EffectDuration", 3))
                {
                    j = nbtCompound2.getInt("EffectDuration");
                }

                StatusEffect statusEffect = StatusEffect.byRawId(nbtCompound2.getByte("EffectId"));
                if (statusEffect != null)
                {
                    list.add(new StatusEffectInstance(statusEffect, j));
                }
            }
        }
        PotionUtil.setCustomPotionEffects(itemStack2, list);
        return itemStack2;
    }

    //#if MC <= 11402
    //$$ private int getItemNameRow(List<Component> list)
    //#else
    private int getItemNameRow(List<Text> list)
    //#endif
    {
        for (int i = 0; i < list.size(); i++)
        {
            //#if MC <= 11402
            //$$ Component text = list.get(i);
            //#else
            Text text = list.get(i);
            //#endif
            if (text.getString().equals(
                    //#if MC <= 11402
                    //$$ new TranslatableComponent("item.minecraft.potion.effect.empty").getString())
                    //#elseif MC <= 11802
                    //$$ new TranslatableText("item.minecraft.potion.effect.empty").getString())
                    //#elseif MC <= 11902
                    Text.translatable("item.minecraft.potion.effect.empty").getString())
                    //#endif
            )
            {
                return i;
            }
        }
        return -1;
    }

    //#if MC <= 11402
    //$$ private int getItemIdRow(List<Component> list)
    //#else
    private int getItemIdRow(List<Text> list)
    //#endif
    {
        return list.indexOf(
                //#if MC <= 11402
                //$$ new TextComponent(Registry.ITEM.getId(Items.POTION).toString())
                //#elseif MC <= 11601
                //$$ new LiteralText(Registry.ITEM.getId(Items.POTION).toString())
                //#else
                Text.of(Registry.ITEM.getId(Items.POTION).toString())
                //#endif
                    //#if MC <= 11502
                    //$$ .copy()
                    //#elseif MC <= 11802
                    //$$ .shallowCopy()
                    //#else
                    .copy()
                    //#endif
                    //#if MC <= 11402
                    //$$ .applyFormat(ChatFormat.DARK_GRAY));
                    //#else
                    .formatted(Formatting.DARK_GRAY));
                    //#endif
    }
}
