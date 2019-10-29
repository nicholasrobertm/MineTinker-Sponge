package net.draycia.minetinkersponge.modifiers.impls.enchantments;

import net.draycia.minetinkersponge.modifiers.Modifier;
import net.draycia.minetinkersponge.utils.ItemTypeUtils;
import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.item.ItemTypes;
import org.spongepowered.api.item.enchantment.EnchantmentType;
import org.spongepowered.api.item.enchantment.EnchantmentTypes;
import org.spongepowered.api.item.recipe.crafting.CraftingRecipe;
import org.spongepowered.api.item.recipe.crafting.Ingredient;
import org.spongepowered.api.item.recipe.crafting.ShapedCraftingRecipe;

import java.util.List;
import java.util.Optional;

public class FireAspect extends Modifier {

    @Override
    public String getName() {
        return "Fire Aspect";
    }

    @Override
    public int getMaxLevel() {
        return 2;
    }

    @Override
    public int getLevelWeight() {
        return 1;
    }

    @Override
    public ItemType getModifierItemType() {
        return ItemTypes.BLAZE_POWDER;
    }

    @Override
    public List<ItemType> getCompatibleItems() {
        return ItemTypeUtils.getSwordTypes();
    }

    @Override
    public EnchantmentType getAppliedEnchantment() {
        return EnchantmentTypes.FIRE_ASPECT;
    }

    @Override
    public Optional<CraftingRecipe> getRecipe() {
        ShapedCraftingRecipe recipe = ShapedCraftingRecipe.builder()
                .aisle("PBP", "PDP", "PBP")
                .where('P', Ingredient.of(ItemTypes.BLAZE_POWDER))
                .where('B', Ingredient.of(ItemTypes.BLAZE_ROD))
                .where('D', Ingredient.of(ItemTypes.DIAMOND))
                .result(getModifierItem())
                .id(getKey())
                .build();

        return Optional.of(recipe);
    }

}
