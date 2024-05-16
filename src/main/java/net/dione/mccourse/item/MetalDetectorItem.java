package net.dione.mccourse.item;

import net.dione.mccourse.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;

import java.util.function.Consumer;

public class MetalDetectorItem extends Item {

    public MetalDetectorItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        if(!context.getWorld().isClient()){
            BlockPos positionClicked = context.getBlockPos();
            PlayerEntity player = context.getPlayer();
            boolean foundBlock = false;

            for(int i = 0; i <= positionClicked.getY() + 64; i++){
                Block block = context.getWorld().getBlockState(positionClicked.down(i)).getBlock();
                if(isValuableBlock(block)){
                    player.sendMessage(Text.literal("found valuable item " + block.getName().getString() +
                            " at (" + positionClicked.down(i).getX() + " " + positionClicked.down(i).getY() + " " + positionClicked.down(i).getZ()));
                    foundBlock = true;
                    break;
                }
            }
            if(!foundBlock){
                player.sendMessage(Text.translatable("item.dionemod.metal_detector.no_valuable"));
            }
        }
        context.getStack().damage(1, context.getPlayer(), EquipmentSlot.MAINHAND);

        return ActionResult.SUCCESS;
    }
    private boolean isValuableBlock(Block block){
        return  block == Blocks.IRON_ORE ||
                block == Blocks.DIAMOND_ORE ||
                block == Blocks.GOLD_ORE ||
                block == Blocks.REDSTONE_ORE ||
                block == ModBlocks.PINK_GARNET_ORE;
    }
}
