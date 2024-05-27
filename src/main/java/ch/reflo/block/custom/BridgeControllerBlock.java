package ch.reflo.block.custom;

import ch.reflo.Illumineer;
import ch.reflo.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

public class BridgeControllerBlock extends Block {
    Direction bridgeDirection = null;
    public BridgeControllerBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void neighborUpdate(BlockState state, World world, BlockPos pos, Block block, BlockPos fromPos, boolean notify) {
        if (!world.isClient) {
            boolean powered = world.isReceivingRedstonePower(pos);
            if (powered) {
                bridgeDirection = getOppositeRedstoneSignalDirection(world, pos);
                if (bridgeDirection != null) {
                    extendBridge(world, pos.offset(bridgeDirection), bridgeDirection);
                }
            } else {
                if (bridgeDirection != null) {
                    retractBridge(world, pos.offset(bridgeDirection), bridgeDirection);
                }
            }
        }
    }

    private Direction getOppositeRedstoneSignalDirection(World world, BlockPos pos) {
        int maxPower = 0;
        Direction directionOfMaxPower = null;

        for (Direction dir : Direction.values()) {
            BlockPos neighborPos = pos.offset(dir);
            int powerLevel = world.getEmittedRedstonePower(neighborPos, dir);
            if (powerLevel > maxPower) {
                maxPower = powerLevel;
                directionOfMaxPower = dir;
            }
        }

        return directionOfMaxPower == null ? null : directionOfMaxPower.getOpposite();
    }

    private void extendBridge(World world, BlockPos start, Direction direction) {
        for (int i = 0; i < 16; i++) {
            if (!world.getBlockState(start).isAir() || i == 15) {
                break;
            }
            world.setBlockState(start, ModBlocks.HARDLIGHT_BLOCK.getDefaultState().with(HardlightBlock.PERMANENT, false), 3);
            start = start.offset(direction);
        }
    }

    private void retractBridge(World world, BlockPos start, Direction direction) {
        for (int i = 0; i < 16; i++) {
            BlockState state = world.getBlockState(start);
            if (state.getBlock() instanceof HardlightBlock && !state.get(HardlightBlock.PERMANENT)) {
                world.setBlockState(start, Blocks.AIR.getDefaultState(), 3);
            } else {
                break; // Stop retracting if we hit a non-Hardlight block or a permanent block
            }
            start = start.offset(direction);
        }
    }
}