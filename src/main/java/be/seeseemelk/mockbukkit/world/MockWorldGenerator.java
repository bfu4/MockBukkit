package be.seeseemelk.mockbukkit.world;

import be.seeseemelk.mockbukkit.WorldMock;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.WorldCreator;

import java.beans.ConstructorProperties;

/**
 * MockWorldGenerator
 *
 * A generator used for mock tests to be ensure invocation of Minecraft
 * native world generation functions.
 *
 * @author bfu4
 * @since 4/7/2021 @ 00:44 AM
 */
public class MockWorldGenerator {

	private final WorldCreator creator;
	private final WorldMock worldMock;
	private final Material defaultBlock;
	private final int height;
	private final int grassHeight;

	/**
	 * Create a generator for a {@link WorldMock }
	 *
	 * @param worldMock mock to create a generator for
	 */
	@ConstructorProperties({ "worldMock" })
	public MockWorldGenerator(final WorldMock worldMock) {
		this.worldMock = worldMock;
		this.defaultBlock = worldMock.getDefaultBlock();
		this.height = worldMock.getHeight();
		this.grassHeight = worldMock.getGrassHeight();
		this.creator = new WorldCreator(worldMock.getName());
	}

	/**
	 * Create a new MockWorld generator
	 *
	 * @param defaultBlock the default block type
	 * @param height height of the world
	 * @param grassHeight height of grass
	 */
	@ConstructorProperties({ "defaultBlock", "height", "grassHeight" })
	public MockWorldGenerator(Material defaultBlock, int height, int grassHeight) {
		this(new WorldMock(defaultBlock, height, grassHeight));
	}

	/**
	 * Get the default block
	 *
	 * @return default block
	 */
	public Material getDefaultBlock() {
		return defaultBlock;
	}

	/**
	 * Get the height
	 *
	 * @return height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * Get the grass height
	 *
	 * @return grass height
	 */
	public int getGrassHeight() {
		return grassHeight;
	}

	/**
	 * Get the world mock instance
	 *
	 * @return world mock
	 */
	public WorldMock getWorldMock() {
		return worldMock;
	}

	/**
	 * Create the world
	 *
	 * @return world
	 */
	public World createWorld() {
		return creator.createWorld();
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof MockWorldGenerator)) return false;
		return ((MockWorldGenerator) o).worldMock.equals(this.worldMock);
	}


}
