package icbm.classic.content.blocks.launcher.screen;

import dan200.computercraft.api.lua.ILuaContext;
import dan200.computercraft.api.lua.LuaException;
import dan200.computercraft.api.peripheral.IComputerAccess;
import dan200.computercraft.api.peripheral.IPeripheral;
import icbm.classic.api.EnumTier;
import icbm.classic.lib.transform.vector.Pos;
import org.apache.commons.lang3.ArrayUtils;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Locale;

public class ScreenPeripheral implements IPeripheral {
    private static final String CC_TYPE = "missilecontrol";
    private static final String[][] CC_METHODS = new String[][]{
            //T1
            new String[]
                    {
                            "launchMissile",
                            "getTarget",
                            "setTarget",
                    },
            //T2
            new String[]
                    {
                            "getLockHeight",
                            "setLockHeight"
                    },
            //T3
            new String[]
                    {
                            "getFrequency",
                            "setFrequency"
                    }
    };

    private final TileLauncherScreen screen;

    static {
        //inherit methods from preceding tiers
        for (int index = 1; index < CC_METHODS.length; index++) {
            for (int prevIndex = index - 1; prevIndex > -1; prevIndex--) {
                CC_METHODS[index] = ArrayUtils.addAll(CC_METHODS[index], CC_METHODS[prevIndex]);
            }
        }
    }

    ScreenPeripheral(TileLauncherScreen screen)
    {
        this.screen = screen;
    }

    @Nonnull
    @Override
    public String getType()
    {
        return CC_TYPE;
    }

    @Nonnull
    @Override
    public String[] getMethodNames()
    {
        return CC_METHODS[Math.min(screen.getTier().ordinal(), 2)];
    }

    @Nullable
    @Override
    public Object[] callMethod(@Nonnull IComputerAccess computer, @Nonnull ILuaContext context, int method, @Nonnull Object[] args) throws LuaException {
        if (method < 0 || method >= getMethodNames().length) {
            throw new LuaException(String.format(Locale.ROOT, "Method index '%d' is out of bounds. This %s only has '%d' methods.", method, CC_TYPE,
                    CC_METHODS.length));
        }

        String methodName = getMethodNames()[method];

        switch (methodName) {
            case "launchMissile":
                validateLength(args, 0);

                return new Object[]{screen.launch()};
            case "getTarget":
                validateLength(args, 0);

                return new Object[]{screen.getTarget().getX(), screen.getTarget().getY(), screen.getTarget().getZ()};
            case "getLockHeight":
                validateLength(args, 0);

                return new Object[]{screen.lockHeight};
            case "getFrequency":
                validateLength(args, 0);

                return new Object[]{screen.getFrequency()};
            case "setTarget":
                validateLength(args, screen.getTier() == EnumTier.ONE ? 2 : 3);

                int[] pos = new int[3];

                for (int index = 0; index < args.length; index++)
                {
                    validateDouble(args, index);

                    if (index == 1)
                    {
                        if (screen.getTier() == EnumTier.ONE) {
                            pos[2] = minMax(-99999, 999999, (double) args[index]);
                            break;
                        }

                        pos[1] = minMax0(999, (double) args[index]);
                    }

                    pos[index] = minMax(-99999, 999999, (double) args[index]);
                }

                screen.setTarget(new Pos(pos[0], pos[1], pos[2]));
                break;
            case "setLockHeight":
                validateLength(args, 1);
                validateDouble(args, 0);

                screen.lockHeight = (short) minMax(3, 999, (double) args[0]);
                break;
            case "setFrequency":
                validateLength(args,  1);
                validateDouble(args, 0);

                screen.setFrequency(minMax0(9999, (double) args[0]));
                break;
        }

        return new Object[0];
    }

    @Override
    public boolean equals(@Nullable IPeripheral other)
    {
        if (!(other instanceof ScreenPeripheral))
        {
            return false;
        }

        ScreenPeripheral otherScreen = (ScreenPeripheral) other;

        return screen.equals(otherScreen.screen);
    }

    private static void validateLength(Object[] args, int length) throws LuaException
    {
        if (args.length != length)
        {
            throw new LuaException(String.format("Expected %d arguments, received %d.", length, args.length));
        }
    }

    private static void validateDouble(Object[] args, int index) throws LuaException
    {
        if (!(args[index] instanceof Double))
        {
            throw new LuaException(String.format("Invalid argument type for argument %d, expected double but received %s.", index, args[index].getClass().getSimpleName()));
        }
    }

    private static int minMax0(int max, double value)
    {
        return minMax(0, max, value);
    }

    private static int minMax(int min, int max, double value)
    {
        return (int) Math.round(Math.max(Math.min(value, max), min));
    }
}
