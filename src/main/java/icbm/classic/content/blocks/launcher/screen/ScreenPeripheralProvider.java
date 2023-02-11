package icbm.classic.content.blocks.launcher.screen;

import dan200.computercraft.api.peripheral.IPeripheral;
import dan200.computercraft.api.peripheral.IPeripheralProvider;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class ScreenPeripheralProvider implements IPeripheralProvider
{
    @Nullable
    @Override
    public IPeripheral getPeripheral(@Nonnull World world, @Nonnull BlockPos pos, @Nonnull EnumFacing side)
    {
        TileEntity tile = world.getTileEntity(pos);
        if (tile instanceof TileLauncherScreen)
        {
            return new ScreenPeripheral((TileLauncherScreen) tile);
        }

        return null;
    }
}
