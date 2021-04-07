package be.seeseemelk.mockbukkit.world;

import be.seeseemelk.mockbukkit.ChunkMock;
import be.seeseemelk.mockbukkit.ServerMock;
import org.bukkit.WorldCreator;
import org.bukkit.WorldType;
import org.bukkit.generator.ChunkGenerator;

import java.beans.ConstructorProperties;

/**
 * MockWorldCreator
 *
 * @author bfu4
 * @since 4/6/2021 @ 11:30 PM
 */
public class MockWorldCreator {

	private final ServerMock mock;
	private final String name;
	private final WorldType type;

	private final WorldCreator creator;

	/**
	 * Create a mock world creator for the server
	 *
	 * @param mock server instance
	 * @param name name of the world
	 * @param type type of the world
	 */
	@ConstructorProperties({"mock", "name", "type"})
	public MockWorldCreator(final ServerMock mock, String name, WorldType type) {
		this.mock = mock;
		this.name = name;
		this.type = type;
		this.creator = new WorldCreator(name);
	}

	/**
	 * Get a chunk generator
	 *
	 * @return chunk generator
	 */
	public ChunkGenerator getGenerator() {
		return this.creator.generator();
	}


	/**
	 * Get the name
	 *
	 * @return name
	 */
	public final String getName() {
		return name;
	}

	public final ServerMock getNewWorldInstance() {
		return new ServerMock();
	}

	/* public World createWorld(WorldCreator creator) {
		ChunkGenerator generator = creator.generator();
			boolean hardcore = creator.hardcore();
			RegistryReadOps<NBTBase> registryreadops = RegistryReadOps.a(DynamicOpsNBT.a, this.console.dataPackResources.h(), this.console.customRegistry);
			WorldDataServer worlddata = (WorldDataServer)worldSession.a(registryreadops, this.console.datapackconfiguration);
			if (worlddata == null) {
				Properties properties = new Properties();
				properties.put("generator-settings", Objects.toString(creator.generatorSettings()));
				properties.put("level-seed", Objects.toString(creator.seed()));
				properties.put("generate-structures", Objects.toString(creator.generateStructures()));
				properties.put("level-type", Objects.toString(creator.type().getName()));
				GeneratorSettings generatorsettings = GeneratorSettings.a(this.console.getCustomRegistry(), properties);
				WorldSettings worldSettings = new WorldSettings(name, EnumGamemode.getById(this.getDefaultGameMode().getValue()), hardcore, EnumDifficulty.EASY, false, new GameRules(), this.console.datapackconfiguration);
				worlddata = new WorldDataServer(worldSettings, generatorsettings, Lifecycle.stable());
			}

			worlddata.checkName(name);
			worlddata.a(this.console.getServerModName(), this.console.getModded().isPresent());
			if (this.console.options.has("forceUpgrade")) {
				net.minecraft.server.v1_16_R3.Main.convertWorld(worldSession, DataConverterRegistry.a(), this.console.options.has("eraseCache"), () -> {
					return true;
				}, (ImmutableSet)worlddata.getGeneratorSettings().d().d().stream().map((entry) -> {
					return ResourceKey.a(IRegistry.K, ((ResourceKey)entry.getKey()).a());
				}).collect(ImmutableSet.toImmutableSet()));
			}

			long j = BiomeManager.a(creator.seed());
			List<MobSpawner> list = ImmutableList.of(new MobSpawnerPhantom(), new MobSpawnerPatrol(), new MobSpawnerCat(), new VillageSiege(), new MobSpawnerTrader(worlddata));
			RegistryMaterials<WorldDimension> registrymaterials = worlddata.getGeneratorSettings().d();
			WorldDimension worlddimension = (WorldDimension)registrymaterials.a(actualDimension);
			DimensionManager dimensionmanager;
			Object chunkgenerator;
			if (worlddimension == null) {
				dimensionmanager = (DimensionManager)this.console.customRegistry.a().d(DimensionManager.OVERWORLD);
				chunkgenerator = GeneratorSettings.a(this.console.customRegistry.b(IRegistry.ay), this.console.customRegistry.b(IRegistry.ar), (new Random()).nextLong());
			} else {
				dimensionmanager = worlddimension.b();
				chunkgenerator = worlddimension.c();
			}

			ResourceKey<net.minecraft.server.v1_16_R3.World> worldKey = ResourceKey.a(IRegistry.L, new MinecraftKey(name.toLowerCase(Locale.ENGLISH)));
			WorldServer internal = new WorldServer(this.console, this.console.executorService, worldSession, worlddata, worldKey, dimensionmanager, this.getServer().worldLoadListenerFactory.create(11), (net.minecraft.server.v1_16_R3.ChunkGenerator)chunkgenerator, worlddata.getGeneratorSettings().isDebugWorld(), j, creator.environment() == World.Environment.NORMAL ? list : ImmutableList.of(), true, creator.environment(), generator);
			if (!this.worlds.containsKey(name.toLowerCase(Locale.ENGLISH))) {
				return null;
			} else {
				this.console.initWorld(internal, worlddata, worlddata, worlddata.getGeneratorSettings());
				internal.setSpawnFlags(true, true);
				this.console.worldServer.put(internal.getDimensionKey(), internal);
				this.pluginManager.callEvent(new WorldInitEvent(internal.getWorld()));
				this.getServer().loadSpawn(internal.getChunkProvider().playerChunkMap.worldLoadListener, internal);
				this.pluginManager.callEvent(new WorldLoadEvent(internal.getWorld()));
				return internal.getWorld();
			}
		}
	}*/
}
