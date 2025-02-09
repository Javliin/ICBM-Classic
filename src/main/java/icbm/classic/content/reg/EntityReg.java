package icbm.classic.content.reg;

import icbm.classic.ICBMConstants;
import icbm.classic.api.refs.ICBMEntities;
import icbm.classic.content.blast.redmatter.EntityRedmatter;
import icbm.classic.content.entity.EntityBombCart;
import icbm.classic.content.entity.EntityExplosion;
import icbm.classic.content.entity.EntityExplosive;
import icbm.classic.content.entity.EntityFlyingBlock;
import icbm.classic.content.entity.EntityFragments;
import icbm.classic.content.entity.EntityGrenade;
import icbm.classic.content.entity.EntityLightBeam;
import icbm.classic.content.entity.EntityPlayerSeat;
import icbm.classic.content.entity.missile.EntityMissile;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;

/**
 * Created by Dark(DarkGuardsman, Robert) on 1/7/19.
 */
@Mod.EventBusSubscriber(modid = ICBMConstants.DOMAIN)
public final class EntityReg
{

    private static int nextEntityID = 0;

    @SubscribeEvent
    public static void registerEntity(RegistryEvent.Register<EntityEntry> event)
    {
        event.getRegistry().register(buildEntityEntry(EntityFlyingBlock.class, ICBMEntities.BLOCK_GRAVITY, 128, 15));
        event.getRegistry().register(buildEntityEntry(EntityFragments.class, ICBMEntities.BLOCK_FRAGMENT, 40, 8));
        event.getRegistry().register(buildEntityEntry(EntityExplosive.class, ICBMEntities.BLOCK_EXPLOSIVE, 50, 5));
        event.getRegistry().register(buildEntityEntry(EntityMissile.class, ICBMEntities.MISSILE, 500, 1));
        event.getRegistry().register(buildEntityEntry(EntityExplosion.class, ICBMEntities.EXPLOSION, 100, 5));
        event.getRegistry().register(buildEntityEntry(EntityLightBeam.class, ICBMEntities.BEAM, 80, 5));
        event.getRegistry().register(buildEntityEntry(EntityGrenade.class, ICBMEntities.GRENADE, 50, 5));
        event.getRegistry().register(buildEntityEntry(EntityBombCart.class, ICBMEntities.BOMB_CART, 50, 2));
        event.getRegistry().register(buildEntityEntry(EntityPlayerSeat.class, ICBMEntities.MISSILE_SEAT, 50, 2));
        event.getRegistry().register(buildEntityEntry(EntityRedmatter.class, ICBMEntities.REDMATTER, 500, 1));

        /*
        //Green team
        event.getRegistry().register(buildMobEntry(EntityXmasSkeleton.class, "skeleton.xmas.elf", Color.GREEN, Color.CYAN));
        event.getRegistry().register(buildMobEntry(EntityXmasSkeletonBoss.class, "skeleton.xmas.boss", Color.GREEN, Color.CYAN));
        event.getRegistry().register(buildMobEntry(EntityXmasSnowman.class, "skeleton.xmas.snowman", Color.BLACK, Color.CYAN));

        //Red team
        event.getRegistry().register(buildMobEntry(EntityXmasZombie.class, "zombie.xmas.elf", Color.RED, Color.CYAN));
        event.getRegistry().register(buildMobEntry(EntityXmasZombieBoss.class, "zombie.xmas.boss", Color.RED, Color.CYAN));
        event.getRegistry().register(buildMobEntry(EntityXmasCreeper.class, "zombie.xmas.creeper", Color.RED, Color.CYAN));


        event.getRegistry().register(buildEntityEntry(EntityXmasRPG.class, "skeleton.snowman.rocket", 64, 1)); */
    }

    private static EntityEntry buildEntityEntry(Class<? extends Entity> entityClass, ResourceLocation name, int trackingRange, int updateFrequency)
    {
        EntityEntryBuilder builder = EntityEntryBuilder.create();
        builder.name(name.toString());
        builder.id(name, nextEntityID++);
        builder.tracker(trackingRange, updateFrequency, true);
        builder.entity(entityClass);
        return builder.build();
    }
}
