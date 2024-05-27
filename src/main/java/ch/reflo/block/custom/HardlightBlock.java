package ch.reflo.block.custom;


import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class HardlightBlock extends Block {
    public static final BooleanProperty PERMANENT = BooleanProperty.of("permanent");

    public HardlightBlock(Settings settings) {
        super(settings.copy(Blocks.GLOWSTONE).luminance(value -> 20).sounds(BlockSoundGroup.AMETHYST_BLOCK));
        setDefaultState(getStateManager().getDefaultState().with(PERMANENT, false));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(PERMANENT);
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(PERMANENT, true); // Blocks placed by players are permanent
    }
    @Override
    public BlockState onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        if (!state.get(PERMANENT)) {
            super.onBreak(world, pos, state, player);
            // Blocks are not dropped if not permanent
            world.setBlockState(pos, Blocks.AIR.getDefaultState(), 3);
        }
        return state;
    }
}