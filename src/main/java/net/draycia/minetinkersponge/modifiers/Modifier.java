package net.draycia.minetinkersponge.modifiers;

import net.draycia.minetinkersponge.data.MTKeys;
import net.draycia.minetinkersponge.data.impl.ModifierIdentifierData;
import net.draycia.minetinkersponge.managers.ModManager;
import net.draycia.minetinkersponge.utils.StringUtils;
import ninja.leaping.configurate.ConfigurationNode;
import org.mariuszgromada.math.mxparser.Expression;
import org.mariuszgromada.math.mxparser.Function;
import org.spongepowered.api.CatalogType;
import org.spongepowered.api.data.key.Keys;
import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.item.enchantment.EnchantmentType;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.item.recipe.crafting.CraftingRecipe;
import org.spongepowered.api.text.Text;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public abstract class Modifier implements CatalogType {
    @Override
    public String getName() {
        return getDisplayName().toPlain();
    }

    /**
     *
     * @return The display friendly name of this modifier
     */
    public abstract Text getDisplayName();

    private Text displayerName = null;

    protected Text getName(Text name) {
        if (this.displayerName == null) {
            return name;
        } else {
            return this.displayerName;
        }
    }

    public void setDisplayerName(Text displayerName) {
        this.displayerName = displayerName;
    }

    // Sets if the modifier is enabled/disabled
    private boolean isEnabled = true;

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    /**
     *
     * @return The highest level this modifier can be on items
     */
    public abstract int getMaxLevel();

    private int maxLevel = -1;

    protected int getMaxLevel(int maxLevel) {
        if (this.maxLevel == -1) {
            return maxLevel;
        } else {
            return this.maxLevel;
        }
    }

    public void setMaxLevel(int maxLevel) {
        this.maxLevel = maxLevel;
    }

    /**
     *
     * @return An int describing the value of the modifier, used to determine effective level and combat level
     */
    public abstract int getLevelWeight();

    private int levelWeight = -1;

    protected int getLevelWeight(int levelWeight) {
        if (this.levelWeight == -1) {
            return levelWeight;
        } else {
            return this.levelWeight;
        }
    }

    public void setLevelWeight(int levelWeight) {
        this.levelWeight = levelWeight;
    }

    private String expression = "1";
    private Function slotCostExpression = new Function("determineCost(level, modifierLevelCount) = " + expression);

    public void setSlotCostExpression(String expression) {
        this.expression = expression;
        this.slotCostExpression = new Function("determineCost(level, modifierLevelCount) = " + expression);
    }

    public String getSlotCostExpression() {
        return expression;
    }

    /**
     * Returns the number of slots the item must have and will be reduced by when the modifier is applied.
     * May return different slot costs depending on the modifier level, may also return the same cost for all levels.
     * @return The number of slots the modifier costs at the given level.
     */
    public int getModifierSlotCost(int modifierLevel, int modifierLevelCount) {
        Expression expression = new Expression("determineCost(" + modifierLevel + ", " + modifierLevelCount + ")", slotCostExpression);

        return ((Double)expression.calculate()).intValue();
    }

    /**
     *
     * @return The chance that the modifier will successfully apply, in a range of 0-100.
     */
    public int getApplicationChance() {
        return getApplicationChance(100);
    }

    private int applicationChance = -1;

    protected int getApplicationChance(int applicationChance) {
        if (this.applicationChance == -1) {
            return applicationChance;
        } else {
            return this.applicationChance;
        }
    }

    public void setApplicationChance(int applicationChance) {
        this.applicationChance = applicationChance;
    }

    /**
     *
     * @return A string describing the modifier
     */
    public String getDescription() {
        return getDescription("");
    }

    private String description = "";

    protected String getDescription(String description) {
        if (this.description.isEmpty()) {
            return description;
        } else {
            return this.description;
        }
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     *
     * @return A string able to be used to obtain the modifier in commands and in the API
     */
    public String getId() {
        return getDisplayName().toPlain().replace(" ", "-").replace("'", "").toLowerCase();
    }

    /**
     * A list of {@link ItemType ItemTypes} that the modifier can be applied to.
     * @return A list of compatible ItemTypes. Or null if the modifier can go on any item.
     */
    public abstract List<ItemType> getCompatibleItems();

    public boolean isCompatibleWithItem(ItemType itemType) {
        return getCompatibleItems().contains(itemType);
    }

    public Text getCompatibilityString() {
        return Text.of(StringUtils.splitString("Everything", 30, "\n"));
    }

    /**
     * @return The item type used for creation of the modifier item.
     */
    public abstract ItemType getModifierItemType();

    private ItemType modifierItemType = null;

    protected ItemType getModifierItemType(ItemType modifierItemType) {
        if (this.modifierItemType == null) {
            return modifierItemType;
        } else {
            return this.modifierItemType;
        }
    }

    public void setModifierItemType(ItemType itemType) {
        this.modifierItemType = itemType;
    }

    /**
     * @return The list of modifiers that this one is incompatible with.
     */
    public List<Class<? extends Modifier>> getIncompatibleModifiers() {
        return Collections.emptyList();
    }

    /**
     * Called when the modifier is applied to an item
     * @param itemStack The item the modifier is being applied to
     * @param level The new level of the modifier
     * @return The new item stack after the modifier is applied and changes are made.
     */
    public ItemStack onModifierApplication(ItemStack itemStack, int level) {
        return itemStack;
    }

    /**
     * Called when the configuration for the modifier is being created and/or saved.
     * @param modifierNode The ConfigurationNode that extra options should be saved to
     */
    public void onConfigurationSave(ConfigurationNode modifierNode) {}

    /**
     * Called when the configuration for the modifier is being loaded and read from.
     * @param modifierNode The ConfigurationNode that extra options should be obtained from
     */
    public void onConfigurationLoad(ConfigurationNode modifierNode) {}

    /**
     * Called when the {@link ModManager} successfully registers the modifier.
     * This should be used for registering event listeners instead of in the constructor.
     * @param plugin The instance of the plugin that owns the modifier that's being registered.
     */
    public void onModifierRegister(Object plugin) {}

    /**
     * Gets the CraftingRecipe for the modifier
     * @return Empty optional by default, a CraftingRecipe if the modifier has one
     */
    public Optional<CraftingRecipe> getRecipe() {
        return Optional.empty();
    }

    private CraftingRecipe craftingRecipe = null;

    protected CraftingRecipe getCraftingRecipe(CraftingRecipe craftingRecipe) {
        if (this.craftingRecipe == null) {
            return craftingRecipe;
        } else {
            return this.craftingRecipe;
        }
    }

    public void setRecipe(CraftingRecipe recipe) {
        this.craftingRecipe = recipe;
    }

    /**
     * @return The enchantment the modifier applies to items. Null if one isn't applied.
     */
    public EnchantmentType getAppliedEnchantment() {
        return null;
    }

    /**
     *
     * @return An item with a stack size of 1 used to apply the modifier to items
     */
    public ItemStack getModifierItem() {
        return getModifierItem(1);
    }

    /**
     *
     * @param amount The stack size (amount of the item) to return
     * @return An item used to apply the modifier to items
     */
    public ItemStack getModifierItem(int amount) {
        ItemStack itemStack = ItemStack.builder()
                .itemType(getModifierItemType())
                .quantity(amount)
                .build();

        itemStack.offer(itemStack.getOrCreate(ModifierIdentifierData.class).get());
        itemStack.offer(MTKeys.MODIFIER_ID, getId());

        itemStack.offer(Keys.DISPLAY_NAME, Text.of(getName(), " Modifier"));

        return itemStack;
    }
}
