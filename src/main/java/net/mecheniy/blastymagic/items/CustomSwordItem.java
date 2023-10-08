package net.mecheniy.blastymagic.items;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.ClipContext;

public class CustomSwordItem extends SwordItem {
    public CustomSwordItem(Tier tier, int attackDamage, float attackSpeed, Properties properties) {
        super(tier, attackDamage, attackSpeed, properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        // Проверка на стороне сервера, чтобы избежать дублирования действий на клиенте
        if (!world.isClientSide()) {
            // Получаем позицию, в которую хотим телепортировать игрока
            BlockHitResult ray = rayTrace(world, player);
            BlockPos targetPos = ray.getBlockPos();

            // Выполняем телепортацию игрока
            player.teleportTo(targetPos.getX() + 0.5, targetPos.getY(), targetPos.getZ() + 0.5);

            // Воспроизводим звук телепортации
            world.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.ENDERMAN_TELEPORT, SoundSource.PLAYERS, 1.0F, 1.0F);

            // Устанавливаем время перезарядки (в данном случае, 60 тиков, что примерно равно 3 секундам)
            player.getCooldowns().addCooldown(this, 0);

            // Обнуляем fallDistance игрока, чтобы избежать урона от падения
            player.fallDistance = 0.0F;

            // Уменьшаем прочность меча на 1
            ItemStack stack = player.getItemInHand(hand);
            stack.hurtAndBreak(1, player, (entity) -> entity.broadcastBreakEvent(hand));
        }

        // Возвращаем результат использования меча
        return super.use(world, player, hand);
    }

    // Метод для выполнения лучевой трассировки (ray trace)
    private BlockHitResult rayTrace(Level world, Player player) {
        double range = 100.0; // Максимальная дистанция телепортации

        float pitch = player.getXRot();
        float yaw = player.getYRot();

        // Вычисляем направление луча для трассировки
        double x = player.getX() + Math.sin(Math.toRadians(-yaw)) * Math.cos(Math.toRadians(pitch)) * range;
        double y = player.getY() + Math.sin(Math.toRadians(-pitch)) * range;
        double z = player.getZ() + Math.cos(Math.toRadians(-yaw)) * Math.cos(Math.toRadians(pitch)) * range;

        return world.clip(new ClipContext(player.getEyePosition(1.0F), new Vec3(x, y, z), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, player));
    }
}
