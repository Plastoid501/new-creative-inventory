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

package net.plastoid501.nci.item;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
//#if MC <= 11502
//$$ import net.minecraft.enchantment.InfoEnchantment;
//#else
import net.minecraft.enchantment.EnchantmentLevelEntry;
//#endif
//#if MC <= 11802
//$$ import net.minecraft.entity.decoration.painting.PaintingMotive;
//#else
import net.minecraft.entity.decoration.painting.PaintingVariant;
import net.minecraft.entity.decoration.painting.PaintingVariants;
//#endif
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
//#if MC <= 11601
//$$ import net.minecraft.nbt.CompoundTag;
//#else
import net.minecraft.nbt.NbtCompound;
//#endif
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionUtil;
import net.minecraft.potion.Potions;
//#if MC <= 11402
//$$ import net.minecraft.network.chat.TranslatableComponent;
//#elseif MC <= 11802
//$$ import net.minecraft.text.TranslatableText;
//#elseif MC <= 11902
import net.minecraft.text.Text;
//#endif
//#if MC <= 11502
//$$ import net.minecraft.util.DefaultedList;
//#else
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DefaultedList;
//#endif
import net.minecraft.util.registry.Registry;
//#if MC >= 11900
import net.minecraft.util.registry.RegistryEntry;
//#endif

import java.util.*;
import java.util.function.Consumer;

//#if MC >= 11700
import static net.minecraft.block.LightBlock.LEVEL_15;
//#endif

public class NewItemGroup
{
    private final String id;
    private final int index;
    private final String translationKey;
    //#if MC <= 11402
    //$$ private final TranslatableComponent displayName;
    //#elseif MC <= 11802
    //$$ private final TranslatableText displayName;
    //#elseif MC <= 11902
    private final Text displayName;
    //#endif
    private final ItemStack icon;
    private final Collection<ItemStack> items;
    private final Entry entry;

    public NewItemGroup(String id,
                        int index,
                        String translationKey,
                        ItemStack icon)
    {
        this.id = id;
        this.index = index;
        this.translationKey = translationKey;
        //#if MC <= 11402
        //$$ this.displayName = new TranslatableComponent(this.translationKey);
        //#elseif MC <= 11802
        //$$ this.displayName = new TranslatableText(this.translationKey);
        //#else
        this.displayName = Text.translatable(this.translationKey);
        //#endif
        this.icon = icon;
        this.items = new LinkedHashSet<>();
        this.entry = new Entry();
    }

    public String getId()
    {
        return id;
    }

    public int getIndex()
    {
        return index;
    }

    public String getTranslationKey()
    {
        return translationKey;
    }

    //#if MC <= 11402
    //$$ public TranslatableComponent getDisplayName()
    //#elseif MC <= 11802
    //$$ public TranslatableText getDisplayName()
    //#elseif MC <= 11902
    public Text getDisplayName()
    //#endif
    {
        return displayName;
    }

    public ItemStack getIcon()
    {
        return icon;
    }

    public Collection<ItemStack> getItems()
    {
        return items;
    }

    public String getTexture()
    {
        switch (this.id)
        {
            case("inventory"):
                return "inventory.png";
            case("search"):
                return "item_search.png";
            default:
                return "items.png";
        }
    }

    public int getColumn()
    {
        return this.index % 7;
    }

    public boolean isTopRow()
    {
        return this.index < 7;
    }

    public boolean isSpecial()
    {
        return this.getColumn() >= 5;
    }

    public void appendStacks(DefaultedList<ItemStack> list)
    {
        list.addAll(this.items);
    }

    public void appendStacksWithoutSameItemStack(DefaultedList<ItemStack> list, ItemStack stack) {
        //#if MC <= 11605
        //$$ if (stack.getItem() == Items.ENCHANTED_BOOK)
        //#else
        if (stack.isOf(Items.ENCHANTED_BOOK))
        //#endif
        {
            Map<Enchantment, Integer> enchantments = EnchantmentHelper.get(stack);
            if (enchantments.keySet().size() != 1) {
                return;
            }
            for (Enchantment enchantment : enchantments.keySet())
            {
                //#if MC <= 11502
                //$$ for (int lvl = enchantment.getMinimumLevel(); lvl <= enchantment.getMaximumLevel(); lvl++)
                //#else
                for (int lvl = enchantment.getMinLevel(); lvl <= enchantment.getMaxLevel(); lvl++)
                //#endif
                {
                    list.add(EnchantedBookItem.forEnchantment(
                            //#if MC <= 11502
                            //$$ new InfoEnchantment(enchantment, lvl)
                            //#else
                            new EnchantmentLevelEntry(enchantment, lvl)
                            //#endif
                    ));
                }
            }
        } else if (!this.containsItemStack(list, stack))
        {
            list.add(stack);
        }
    }

    private boolean containsItemStack(DefaultedList<ItemStack> list, ItemStack stack)
    {
        for (ItemStack stack2 : list)
        {
            //#if MC <= 11502
            //$$ if (ItemStack.areEqualIgnoreDamage(stack, stack2))
            //#else
            if (ItemStack.areEqual(stack, stack2))
            //#endif
            {
                return true;
            }
        }
        return false;
    }

    public boolean containsItemStack(Collection<ItemStack> list, ItemStack stack)
    {
        for (ItemStack stack2 : list)
        {
            if (ItemStack.areItemsEqual(stack, stack2)) {
                return true;
            }
        }
        return false;
    }

    public void setItems(Consumer<Entry> entry) {
        entry.accept(this.entry);
    }

    public class Entry
    {
        public void add(Item item)
        {
            this.add(new ItemStack(item));
        }

        public void add(ItemStack stack)
        {
            NewItemGroup.this.items.add(stack);
        }

        public void addPaintings()
        {
            //#if MC <= 11402
            //$$ for (PaintingMotive paintingMotive : Registry.MOTIVE)
            //#elseif MC <= 11802
            //$$ for (PaintingMotive paintingMotive : Registry.PAINTING_MOTIVE)
            //#else
            for (PaintingVariant paintingMotive : Registry.PAINTING_VARIANT)
            //#endif
            {
                ItemStack stack = new ItemStack(Items.PAINTING);
                //#if MC <= 11601
                //$$ CompoundTag nbt = stack.getOrCreateSubTag("EntityTag");
                //#else
                NbtCompound nbt = stack.getOrCreateSubNbt("EntityTag");
                //#endif
                
                //#if MC <= 11402
                //$$ String title = Registry.MOTIVE.getId(paintingMotive).toString();
                //#elseif MC <= 11802
                //$$ String title = Registry.PAINTING_MOTIVE.getId(paintingMotive).toString();
                //#else
                Identifier variant = Registry.PAINTING_VARIANT.getId(paintingMotive);
                String title = variant.toString();
                //#endif
                //#if MC <= 11802
                //$$ nbt.putString("Motive", title);
                //$$ this.add(stack);
                //#else
                boolean bl = NewItemGroup.this.index == NewItemGroups.SEARCH.getIndex();
                boolean bl2 = NewItemGroup.this.index == NewItemGroups.OPERATOR.getIndex();
                boolean bl3 = PaintingVariants.EARTH.getValue().equals(variant) ||
                        PaintingVariants.WIND.getValue().equals(variant) ||
                        PaintingVariants.WATER.getValue().equals(variant) ||
                        PaintingVariants.FIRE.getValue().equals(variant);
                if (bl || bl2 && bl3 || !bl2 && !bl3)
                {
                    nbt.putString("variant", title);
                    this.add(stack);
                }
                //#endif
            }
        }

        public void addFireworkRockets()
        {
            byte[] flight_level = new byte[]{1, 2, 3};

            for (byte level : flight_level)
            {
                ItemStack stack = new ItemStack(Items.FIREWORK_ROCKET);
                //#if MC <= 11601
                //$$ stack.getOrCreateSubTag("Fireworks").putByte("Flight", level);
                //#else
                stack.getOrCreateSubNbt("Fireworks").putByte("Flight", level);
                //#endif
                this.add(stack);
            }

        }

        public void addTippedArrow()
        {
            this.addPotions(Items.TIPPED_ARROW);
        }

        public void addInstruments()
        {
            //#if MC >= 11900
            for (RegistryEntry<Instrument> instrument : Registry.INSTRUMENT.getIndexedEntries())
            {
                ItemStack stack = GoatHornItem.getStackForInstrument(Items.GOAT_HORN, instrument);
                this.add(stack);
            }
            //#endif
        }

        public void addSuspiciousStews()
        {
            this.add(createSuspiciousStew(StatusEffects.SATURATION, 7));
            this.add(createSuspiciousStew(StatusEffects.NIGHT_VISION, 100));
            this.add(createSuspiciousStew(StatusEffects.FIRE_RESISTANCE, 80));
            this.add(createSuspiciousStew(StatusEffects.BLINDNESS, 160));
            this.add(createSuspiciousStew(StatusEffects.WEAKNESS, 180));
            this.add(createSuspiciousStew(StatusEffects.RESISTANCE, 160));
            this.add(createSuspiciousStew(StatusEffects.JUMP_BOOST, 120));
            this.add(createSuspiciousStew(StatusEffects.POISON, 240));
            this.add(createSuspiciousStew(StatusEffects.WITHER, 160));
        }

        private ItemStack createSuspiciousStew(StatusEffect effect, int duration)
        {
            ItemStack stack = new ItemStack(Items.SUSPICIOUS_STEW);
            SuspiciousStewItem.addEffectToStew(stack, effect, duration);
            return stack;
        }

        public void addPotions(Item item)
        {
            for (Potion potion : Registry.POTION)
            {
                if (potion == Potions.EMPTY)
                {
                    continue;
                }
                this.add(PotionUtil.setPotion(new ItemStack(item), potion));
            }
        }

        public void addMaxLevelEnchantedBooks()
        {
            for (Enchantment enchantment : Registry.ENCHANTMENT)
            {
                this.add(EnchantedBookItem.forEnchantment(
                        //#if MC <= 11502
                        //$$ new InfoEnchantment(enchantment, enchantment.getMaximumLevel())
                        //#else
                        new EnchantmentLevelEntry(enchantment, enchantment.getMaxLevel())
                        //#endif
                ));
            }
        }

        public void addAllLevelEnchantedBooks()
        {
            for (Enchantment enchantment : Registry.ENCHANTMENT)
            {
                //#if MC <= 11502
                //$$ for (int lvl = enchantment.getMinimumLevel(); lvl <= enchantment.getMaximumLevel(); lvl++)
                //#else
                for (int lvl = enchantment.getMinLevel(); lvl <= enchantment.getMaxLevel(); lvl++)
                //#endif
                {
                    this.add(EnchantedBookItem.forEnchantment(
                            //#if MC <= 11502
                            //$$ new InfoEnchantment(enchantment, lvl)
                            //#else
                            new EnchantmentLevelEntry(enchantment, lvl)
                            //#endif
                    ));
                }
            }
        }

        public void addLightBlocks()
        {
            //#if MC >= 11700
            for(int i = 15; i >= 0; --i)
            {
                ItemStack stack = new ItemStack(Items.LIGHT);
                if (i != 15)
                {
                    NbtCompound nbtCompound = new NbtCompound();
                    nbtCompound.putString(LEVEL_15.getName(), String.valueOf(i));
                    stack.setSubNbt("BlockStateTag", nbtCompound);
                }
                this.add(stack);
            }
            //#endif
        }
    }



}
