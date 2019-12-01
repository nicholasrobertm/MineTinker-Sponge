package net.draycia.minetinkersponge.utils;

import com.google.common.collect.ImmutableList;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.item.ItemType;

import java.util.ArrayList;
import java.util.List;

public class ItemTypeUtils {

    public static List<ItemType> getItemsByPattern(String pattern) {
        List<ItemType> itemTypeList = new ArrayList<>();

        for (ItemType itemType : Sponge.getGame().getRegistry().getAllOf(ItemType.class)) {
            // TODO: Blacklist in config
            // TODO: Allow additional entries to be made in each modifier's config
            // TODO: Check to make sure objects aren't being created each time compatibility is being checked.
            //           Note: The ImmutableList could be passed into (Later: Implement) setters
            if (itemType.getId().split(":")[1].matches(pattern)) {
                itemTypeList.add(itemType);
            }
        }

        return itemTypeList;
    }

    public static List<ItemType> getItemsByConfig(String pattern) {
        List<ItemType> itemTypeList = new ArrayList<>();
        // TODO: Stub, implement
        return itemTypeList;
    }

    private static ImmutableList<ItemType> getItems(String pattern) {
        return ImmutableList.<ItemType>builder()
                .addAll(getItemsByPattern(pattern))
                .addAll(getItemsByConfig(pattern))
                .build();
    }

    // Tools
    public static final ImmutableList<ItemType> PICKAXES = getItems("pickaxe");
    public static final ImmutableList<ItemType> AXES = getItems("axe");
    public static final ImmutableList<ItemType> SHOVELS = getItems("shovel");
    public static final ImmutableList<ItemType> HOES = getItems("hoe");
    public static final ImmutableList<ItemType> FISHING_RODS = getItems("fishing_rod");

    // Weapons
    public static final ImmutableList<ItemType> SWORDS = getItems("sword");
    public static final ImmutableList<ItemType> BOWS = getItems("bow");

    // Armor
    public static final ImmutableList<ItemType> HELMETS = getItems("helmet");
    public static final ImmutableList<ItemType> CHESTPLATES = getItems("chestplate");
    public static final ImmutableList<ItemType> LEGGINGS = getItems("legging");
    public static final ImmutableList<ItemType> BOOTS = getItems("boot");
    public static final ImmutableList<ItemType> SHIELDS = getItems("shield");

    // All
    public static final ImmutableList<ItemType> ALL_TYPES = ImmutableList.<ItemType>builder()
            .addAll(PICKAXES).addAll(AXES).addAll(SHOVELS).addAll(HOES).addAll(FISHING_RODS)
            .addAll(SWORDS).addAll(BOWS).addAll(HELMETS).addAll(CHESTPLATES).addAll(LEGGINGS)
            .addAll(BOOTS).addAll(SHIELDS)
            .build();
}
