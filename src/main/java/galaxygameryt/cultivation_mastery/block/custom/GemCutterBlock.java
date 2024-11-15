package galaxygameryt.cultivation_mastery.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.stat.Stats;
import net.minecraft.state.property.Properties;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.stream.Stream;

public class GemCutterBlock extends TallPlantBlock {
    public static final MapCodec<TallFlowerBlock> CODEC = TallFlowerBlock.createCodec(TallFlowerBlock::new);

    public MapCodec<TallFlowerBlock> getCodec() { return CODEC; }

    public GemCutterBlock(Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        VoxelShape shape = VoxelShapes.empty();
        switch (state.get(Properties.DOUBLE_BLOCK_HALF)) {
            case UPPER -> {
                shape = Stream.of(
                        Block.createCuboidShape(0, 0, 0, 2, 16, 2),
                        Block.createCuboidShape(14, 0, 0, 16, 16, 2),
                        Block.createCuboidShape(2, 6, 0, 14, 8, 2),
                        Block.createCuboidShape(2, 14, 0, 14, 16, 2)
                ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();
            }
            case LOWER -> {
                shape = Stream.of(
                        Block.createCuboidShape(0, 0, 0, 16, 7, 16),
                        Block.createCuboidShape(0, 9, 0, 16, 16, 16),
                        Stream.of(
                                Block.createCuboidShape(0, 7, 0, 4, 9, 16),
                                Block.createCuboidShape(12, 7, 0, 16, 9, 16),
                                Block.createCuboidShape(4, 7, 0, 12, 9, 10)
                        ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get()
                ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();
            }
        }
        return shape;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable BlockView world, List<Text> tooltip, TooltipContext options) {
        tooltip.add(Text.literal("Cut Your Gems!!!!"));
        super.appendTooltip(stack, world, tooltip, options);
    }

//    @Override
//    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
//        if (world.isClient) {
//            return ActionResult.SUCCESS;
//        } else {
//            player.openHandledScreen(state.createScreenHandlerFactory(world, pos));
//            return ActionResult.CONSUME;
//        }
//    }

    @Nullable
    @Override
    public NamedScreenHandlerFactory createScreenHandlerFactory(BlockState state, World world, BlockPos pos) {
        return null;
    }

}
