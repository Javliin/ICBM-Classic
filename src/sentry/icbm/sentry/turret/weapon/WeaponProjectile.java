package icbm.sentry.turret.weapon;

import com.builtbroken.ai.combat.IWeaponPlatform;

import net.minecraft.inventory.IInventory;

public class WeaponProjectile extends WeaponSystem
{
    public WeaponProjectile(IWeaponPlatform shooter, IInventory inv)
    {
        super(shooter, inv);
    }
}
