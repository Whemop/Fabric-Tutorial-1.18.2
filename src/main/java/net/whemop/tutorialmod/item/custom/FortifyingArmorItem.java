package net.whemop.tutorialmod.item.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class FortifyingArmorItem extends ArmorItem {
    public FortifyingArmorItem(ArmorMaterial material, EquipmentSlot slot, Settings settings) {
        super(material, slot, settings);
    }

    StatusEffectInstance Slowness = new StatusEffectInstance(StatusEffects.SLOWNESS, 10, 3);
    StatusEffectInstance Resistance = new StatusEffectInstance(StatusEffects.RESISTANCE, 10, 3);

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if(world.isClient()) {
            if(entity instanceof PlayerEntity) {
                PlayerEntity player = (PlayerEntity)entity;
                if(player.isSneaking()) {
                    if(hasFullSuitOfArmorOn(player)) {
                        if(hasCorrectArmorOn(ModArmorMaterials.FORTIFY, player)) {
                            addStatusEffectTo(player, ModArmorMaterials.FORTIFY, Slowness);
                            addStatusEffectTo(player, ModArmorMaterials.FORTIFY, Resistance);
                        }
                    }
                }
            }
        }
    }

    private void addStatusEffectTo(PlayerEntity player, ArmorMaterial ArmorMaterial, StatusEffectInstance StatusEffect) {
        boolean hasPlayerEffect = player.hasStatusEffect(StatusEffect.getEffectType());

        if(hasCorrectArmorOn(ArmorMaterial, player) && !hasPlayerEffect) {
            player.addStatusEffect(new StatusEffectInstance(StatusEffect.getEffectType(),
                    StatusEffect.getDuration(), StatusEffect.getAmplifier()));
        }
    }

    private boolean hasFullSuitOfArmorOn(PlayerEntity player) {
        ItemStack boots = player.getInventory().getArmorStack(0);
        ItemStack leggings = player.getInventory().getArmorStack(1);
        ItemStack breastplate = player.getInventory().getArmorStack(2);
        ItemStack helmet = player.getInventory().getArmorStack(3);

        return !helmet.isEmpty() && !breastplate.isEmpty()
                && !leggings.isEmpty() && !boots.isEmpty();
    }

    private boolean hasCorrectArmorOn(ArmorMaterial material, PlayerEntity player) {
        ArmorItem boots = ((ArmorItem)player.getInventory().getArmorStack(0).getItem());
        ArmorItem leggings = ((ArmorItem)player.getInventory().getArmorStack(1).getItem());
        ArmorItem breastplate = ((ArmorItem)player.getInventory().getArmorStack(2).getItem());
        ArmorItem helmet = ((ArmorItem)player.getInventory().getArmorStack(3).getItem());

        return helmet.getMaterial() == material && breastplate.getMaterial() == material &&
                leggings.getMaterial() == material && boots.getMaterial() == material;
    }
}
