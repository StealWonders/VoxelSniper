/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thevoxelbox.voxelsniper.brush.perform;

import com.thevoxelbox.voxelsniper.Message;
import org.bukkit.Material;

import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;

/**
 * @author Voxel
 */
public class pComboMatNoPhysics extends vPerformer {

    private BlockData voxelSubstance;
    private Material targetMaterial;

    public pComboMatNoPhysics() {
        name = "Combo-Mat, No Physics";
    }

    @Override
    public void init(com.thevoxelbox.voxelsniper.SnipeData v) {
        w = v.getWorld();
        voxelSubstance = v.getVoxelSubstance();
        targetMaterial = v.getTargetMaterial();
    }

    @Override
    public void info(Message vm) {
        vm.performerName(name);
        vm.voxel();
        vm.replace();
        vm.data();
    }

    @SuppressWarnings("deprecation")
    @Override
    public void perform(Block b) {
        if (b.getType() == targetMaterial) {
            h.put(b);
            b.setBlockData(voxelSubstance, false);
        }
    }

    @Override
    public boolean isUsingReplaceMaterial() {
        return true;
    }
}
