package net.draycia.minetinkersponge.modifiers.impls.enchantments;

import com.google.common.collect.ImmutableList;
import net.draycia.minetinkersponge.modifiers.Modifier;
import net.draycia.minetinkersponge.utils.ItemTypeUtils;
import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.item.ItemTypes;
import org.spongepowered.api.item.enchantment.EnchantmentType;
import org.spongepowered.api.item.enchantment.EnchantmentTypes;
import org.spongepowered.api.item.recipe.crafting.CraftingRecipe;
import org.spongepowered.api.item.recipe.crafting.Ingredient;
import org.spongepowered.api.item.recipe.crafting.ShapedCraftingRecipe;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FireProtection extends Modifier {

    private static List<Class<? extends Modifier>> incompatibleTypes = new ArrayList<>();
    private static List<ItemType> compatibleTypes;

    static {
        incompatibleTypes.add(Protection.class);
        incompatibleTypes.add(ProjectileProtection.class);
        incompatibleTypes.add(BlastProtection.class);

        compatibleTypes = ImmutableList.<ItemType>builder()
                .addAll(ItemTypeUtils.HELMETS)
                .addAll(ItemTypeUtils.CHESTPLATES)
                .addAll(ItemTypeUtils.LEGGINGS)
                .addAll(ItemTypeUtils.BOOTS)
                .build();
    }

    @Override
    public List<ItemType> getCompatibleItems() {
        return compatibleTypes;
    }

    @Override
    public List<Class<? extends Modifier>> getIncompatibleModifiers() {
        return incompatibleTypes;
    }

    @Override
    public String getName() {
        return getName("Fire Protection");
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
        return getModifierItemType(ItemTypes.IRON_BLOCK);
    }

    @Override
    public EnchantmentType getAppliedEnchantment() {
        return EnchantmentTypes.FIRE_PROTECTION;
    }

    @Override
    public Optional<CraftingRecipe> getRecipe() {
        ShapedCraftingRecipe recipe = ShapedCraftingRecipe.builder()
                .aisle("IMI", "MDM", "IMI")
                .where('I', Ingredient.of(ItemTypes.IRON_BLOCK))
                .where('M', Ingredient.of(ItemTypes.MAGMA))
                .where('D', Ingredient.of(ItemTypes.DIAMOND))
                .result(getModifierItem())
                .id(getKey())
                .build();

        return Optional.of(getCraftingRecipe(recipe));
    }

}
