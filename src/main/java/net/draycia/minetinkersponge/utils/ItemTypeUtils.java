package net.draycia.minetinkersponge.utils;

import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.item.ItemTypes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ItemTypeUtils {

    private static List<ItemType> axeTypes = new ArrayList<>();
    private static List<ItemType> swordTypes = new ArrayList<>();
    private static List<ItemType> bowTypes = new ArrayList<>(Collections.singletonList(ItemTypes.BOW));

    private static List<ItemType> weaponTypes = new ArrayList<>();

    private static List<ItemType> hoeTypes = new ArrayList<>();
    private static List<ItemType> shovelTypes = new ArrayList<>();
    private static List<ItemType> pickaxeTypes = new ArrayList<>();

    private static List<ItemType> toolTypes = new ArrayList<>();

    private static List<ItemType> fishingRodTypes = Collections.singletonList(ItemTypes.FISHING_ROD);

    private static List<ItemType> bootTypes = new ArrayList<>();
    private static List<ItemType> leggingTypes = new ArrayList<>();
    private static List<ItemType> chestplateTypes = new ArrayList<>();
    private static List<ItemType> helmetTypes = new ArrayList<>();

    private static List<ItemType> shieldTypes = Collections.singletonList(ItemTypes.SHIELD);

    private static List<ItemType> miscArmorTypes = new ArrayList<>();

    private static List<ItemType> armorTypes = new ArrayList<>();
    private static List<ItemType> allTypes = new ArrayList<>();

    static {
        axeTypes.add(ItemTypes.WOODEN_AXE);
        axeTypes.add(ItemTypes.IRON_AXE);
        axeTypes.add(ItemTypes.GOLDEN_AXE);
        axeTypes.add(ItemTypes.DIAMOND_AXE);

        hoeTypes.add(ItemTypes.WOODEN_HOE);
        hoeTypes.add(ItemTypes.IRON_HOE);
        hoeTypes.add(ItemTypes.GOLDEN_HOE);
        hoeTypes.add(ItemTypes.DIAMOND_HOE);

        swordTypes.add(ItemTypes.WOODEN_SWORD);
        swordTypes.add(ItemTypes.IRON_SWORD);
        swordTypes.add(ItemTypes.GOLDEN_SWORD);
        swordTypes.add(ItemTypes.DIAMOND_SWORD);

        shovelTypes.add(ItemTypes.WOODEN_SHOVEL);
        shovelTypes.add(ItemTypes.IRON_SHOVEL);
        shovelTypes.add(ItemTypes.GOLDEN_SHOVEL);
        shovelTypes.add(ItemTypes.DIAMOND_SHOVEL);

        pickaxeTypes.add(ItemTypes.WOODEN_PICKAXE);
        pickaxeTypes.add(ItemTypes.IRON_PICKAXE);
        pickaxeTypes.add(ItemTypes.GOLDEN_PICKAXE);
        pickaxeTypes.add(ItemTypes.DIAMOND_PICKAXE);

        bootTypes.add(ItemTypes.LEATHER_BOOTS);
        bootTypes.add(ItemTypes.CHAINMAIL_BOOTS);
        bootTypes.add(ItemTypes.IRON_BOOTS);
        bootTypes.add(ItemTypes.GOLDEN_BOOTS);
        bootTypes.add(ItemTypes.DIAMOND_BOOTS);

        leggingTypes.add(ItemTypes.LEATHER_LEGGINGS);
        leggingTypes.add(ItemTypes.CHAINMAIL_LEGGINGS);
        leggingTypes.add(ItemTypes.IRON_LEGGINGS);
        leggingTypes.add(ItemTypes.GOLDEN_LEGGINGS);
        leggingTypes.add(ItemTypes.DIAMOND_LEGGINGS);

        chestplateTypes.add(ItemTypes.LEATHER_CHESTPLATE);
        chestplateTypes.add(ItemTypes.CHAINMAIL_CHESTPLATE);
        chestplateTypes.add(ItemTypes.IRON_CHESTPLATE);
        chestplateTypes.add(ItemTypes.GOLDEN_CHESTPLATE);
        chestplateTypes.add(ItemTypes.DIAMOND_CHESTPLATE);

        helmetTypes.add(ItemTypes.LEATHER_HELMET);
        helmetTypes.add(ItemTypes.CHAINMAIL_HELMET);
        helmetTypes.add(ItemTypes.IRON_HELMET);
        helmetTypes.add(ItemTypes.GOLDEN_HELMET);
        helmetTypes.add(ItemTypes.DIAMOND_HELMET);

        miscArmorTypes.add(ItemTypes.ELYTRA);
        miscArmorTypes.add(ItemTypes.PUMPKIN);
        miscArmorTypes.add(ItemTypes.LIT_PUMPKIN);

        weaponTypes.addAll(axeTypes);
        weaponTypes.addAll(swordTypes);
        weaponTypes.addAll(bowTypes);

        toolTypes.addAll(axeTypes);
        toolTypes.addAll(pickaxeTypes);
        toolTypes.addAll(hoeTypes);
        toolTypes.addAll(shovelTypes);

        armorTypes.addAll(bootTypes);
        armorTypes.addAll(leggingTypes);
        armorTypes.addAll(chestplateTypes);
        armorTypes.addAll(helmetTypes);

        allTypes.addAll(axeTypes);
        allTypes.addAll(hoeTypes);
        allTypes.addAll(swordTypes);
        allTypes.addAll(shovelTypes);
        allTypes.addAll(pickaxeTypes);

        allTypes.addAll(bootTypes);
        allTypes.addAll(leggingTypes);
        allTypes.addAll(chestplateTypes);
        allTypes.addAll(helmetTypes);

        allTypes.addAll(shieldTypes);

        allTypes.addAll(miscArmorTypes);

        allTypes.add(ItemTypes.BOW);
        allTypes.add(ItemTypes.FISHING_ROD);
    }

    public static List<ItemType> getAxeTypes() {
        return axeTypes;
    }

    public static List<ItemType> getHoeTypes() {
        return hoeTypes;
    }

    public static List<ItemType> getSwordTypes() {
        return swordTypes;
    }

    public static List<ItemType> getBowTypes() {
        return bowTypes;
    }

    public static List<ItemType> getFishingRodTypes() {
        return fishingRodTypes;
    }

    public static List<ItemType> getShovelTypes() {
        return shovelTypes;
    }

    public static List<ItemType> getPickaxeTypes() {
        return pickaxeTypes;
    }

    public static List<ItemType> getBootTypes() {
        return bootTypes;
    }

    public static List<ItemType> getLeggingTypes() {
        return leggingTypes;
    }

    public static List<ItemType> getChestplateTypes() {
        return chestplateTypes;
    }

    public static List<ItemType> getHelmetTypes() {
        return helmetTypes;
    }

    public static List<ItemType> getMiscArmorTypes() {
        return miscArmorTypes;
    }

    public static List<ItemType> getArmorTypes() {
        return armorTypes;
    }

    public static List<ItemType> getShieldTypes() {
        return shieldTypes;
    }

    public static List<ItemType> getToolTypes() {
        return toolTypes;
    }

    public static List<ItemType> getWeaponTypes() {
        return weaponTypes;
    }

    public static List<ItemType> getAllTypes() {
        return allTypes;
    }

}
