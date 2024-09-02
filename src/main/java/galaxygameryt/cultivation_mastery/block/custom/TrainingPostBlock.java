package galaxygameryt.cultivation_mastery.block.custom;

import com.mojang.serialization.MapCodec;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import galaxygameryt.cultivation_mastery.networking.ModMessages;
import galaxygameryt.cultivation_mastery.util.BodyData;
import galaxygameryt.cultivation_mastery.util.IEntityDataSaver;
import net.minecraft.block.*;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.property.Properties;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class TrainingPostBlock extends TallPlantBlock {
    public static final MapCodec<TallFlowerBlock> CODEC = TallFlowerBlock.createCodec(TallFlowerBlock::new);
    public static float TRAININGMULTIPLIER;

    public MapCodec<TallFlowerBlock> getCodec() {
        return CODEC;
    }

    public TrainingPostBlock(Settings settings, float trainingMultiplier) {
        super(settings);
        TRAININGMULTIPLIER = trainingMultiplier;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        VoxelShape shape = VoxelShapes.empty();
        switch (state.get(Properties.DOUBLE_BLOCK_HALF)) {
            case UPPER -> {
                shape = Stream.of(
                        Block.createCuboidShape(4, 0, 4, 12, 16, 12),
                        Block.createCuboidShape(4, 16, 4, 12, 16, 12),
                        Block.createCuboidShape(4, 0, 4, 12, 0, 12)
                ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();
            }
            case LOWER -> {
                shape = Stream.of(
                        Block.createCuboidShape(0, 0, 0, 16, 2, 16),
                        Block.createCuboidShape(2, 2, 2, 14, 4, 14),
                        Block.createCuboidShape(4, 4, 4, 12, 16, 12),
                        Block.createCuboidShape(4, 16, 4, 12, 16, 12)
                ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();
            }
        }
        return shape;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable BlockView world, List<Text> tooltip, TooltipContext options) {
        tooltip.add(Text.translatable("tooltip.cultivation_mastery.training_post.1"));
        tooltip.add(Text.translatable("tooltip.cultivation_mastery.training_post.2"));
        super.appendTooltip(stack, world, tooltip, options);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (!world.isClient()) {
            if (player.isSneaking() && player.getStackInHand(hand).isEmpty()) {
                world.breakBlock(pos, true);
            } else {
                player.sendMessage(Text.literal("Shift Right Click to break or punch with an empty hand to train")
                        .fillStyle(Style.EMPTY.withColor(Formatting.RED)), false);
            }
        }

        return ActionResult.SUCCESS;
    }

    @Override
    public void onBlockBreakStart(BlockState state, World world, BlockPos pos, PlayerEntity player) {
        super.onBlockBreakStart(state, world, pos, player);
        if (world.isClient()) {
            Random rand = new Random();
            float data = rand.nextFloat(0.2f,0.5f) * TRAININGMULTIPLIER;
            BodyData.addBody((IEntityDataSaver) player, data);
            world.playSound(null, player.getBlockPos(), SoundEvents.BLOCK_WOOD_BREAK, SoundCategory.PLAYERS,
                    0.5F, world.random.nextFloat() * 0.1F + 0.9F);
            player.sendMessage(Text.literal(String.format("Body: %.2f", ((IEntityDataSaver) player).getBodyLevel()))
                    .fillStyle(Style.EMPTY.withColor(Formatting.AQUA)), false);
        }
    }
}
