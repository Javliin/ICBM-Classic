package icbm.sentry.turret.sentries;

import icbm.core.ICBMCore;
import icbm.sentry.ICBMSentry;
import net.minecraft.util.AxisAlignedBB;
import universalelectricity.api.vector.Vector3;

/** AA Turret, shoots down missiles and planes.
 * 
 * @author DarkGaurdsman */
public class TileEntityAAGun extends TileEntityAutoTurret
{
    public TileEntityAAGun()
    {
        this.targetAir = true;

        this.baseTargetRange = 80;
        this.maxTargetRange = 120;

        this.rotationSpeed = 9;

        this.minFiringDelay = 8;
        this.baseFiringDelay = 15;
        this.getPitchServo().setLimits(90, 40);
        this.allowFreePitch = true;
    }

    @Override
    public AxisAlignedBB getTargetingBox()
    {
        return AxisAlignedBB.getBoundingBox(xCoord - this.getDetectRange(), yCoord - this.getDetectRange(), zCoord - this.getDetectRange(), xCoord + this.getDetectRange(), yCoord + this.getDetectRange(), zCoord + this.getDetectRange());
    }

    @Override
    public int getMaxHealth()
    {
        return 180;
    }

 
    public void playFiringSound()
    {
        this.worldObj.playSoundEffect(this.xCoord, this.yCoord, this.zCoord, ICBMCore.PREFIX + "aagun", 5F, 1F);
    }

    @Override
    public Vector3 getCenter()
    {
        return new Vector3(this).add(new Vector3(0.5, 0.75, 0.5));
    }

}
