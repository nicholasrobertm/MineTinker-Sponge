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

public class VanishingCurse extends Modifier {

    @Override
    public List<ItemType> getCompatibleItems() {
        return ItemTypeUtils.ALL_TYPES;
    }

    @Override
    public String getName() {
        return getName("Curse of Vanishing");
    }

    @Override
    public int getMaxLevel() {
        return getMaxLevel(4);
    }

    @Override
    public int getLevelWeight() {
        return getLevelWeight(1);
    }

    @Override
    public ItemType getModifierItemType() {
        return getModifierItemType(ItemTypes.ENDER_EYE);
    }

    @Override
    public EnchantmentType getAppliedEnchantment() {
        return EnchantmentTypes.VANISHING_CURSE;
    }

    @Override
    public Optional<CraftingRecipe> getRecipe() {
        ShapedCraftingRecipe recipe = ShapedCraftingRecipe.builder()
                .aisle("PEP", "ECE", "PEP")
                .where('E', Ingredient.of(ItemTypes.COAL))
                .where('C', Ingredient.of(ItemTypes.DIAMOND))
                .where('P', Ingredient.of(ItemTypes.ENDER_PEARL))
                .result(getModifierItem())
                .id(getKey())
                .build();

        return Optional.of(getCraftingRecipe(recipe));
    }

}
