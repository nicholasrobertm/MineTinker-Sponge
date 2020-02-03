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

public class FrostWalker extends Modifier {

    @Override
    public List<ItemType> getCompatibleItems() {
        return ItemTypeUtils.BOOTS;
    }

    @Override
    public String getCompatibilityString() {
        return "Boots.";
    }

    @Override
    public String getName() {
        return getName("Frost Walker");
    }

    @Override
    public int getMaxLevel() {
        return getMaxLevel(2);
    }

    @Override
    public int getLevelWeight() {
        return getLevelWeight(1);
    }

    @Override
    public ItemType getModifierItemType() {
        return getModifierItemType(ItemTypes.ICE);
    }

    @Override
    public EnchantmentType getAppliedEnchantment() {
        return EnchantmentTypes.FROST_WALKER;
    }

    @Override
    public Optional<CraftingRecipe> getRecipe() {
        ShapedCraftingRecipe recipe = ShapedCraftingRecipe.builder()
                .aisle("PIP", "ICI", "PIP")
                .where('I', Ingredient.of(ItemTypes.PACKED_ICE))
                .where('C', Ingredient.of(ItemTypes.REDSTONE))
                .where('P', Ingredient.of(ItemTypes.PRISMARINE_SHARD))
                .result(getModifierItem())
                .id(getKey())
                .build();

        return Optional.of(getCraftingRecipe(recipe));
    }

}
