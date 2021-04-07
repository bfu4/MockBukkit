package be.seeseemelk.mockbukkit.world;

import be.seeseemelk.mockbukkit.ServerMock;
import org.bukkit.generator.ChunkGenerator;

import java.beans.ConstructorProperties;

/**
 * WorldServerMock
 *
 * @author bfu4
 * @since 4/7/2021 @ 12:06 AM
 */
public class WorldServerMock extends ServerMock {

	private final ServerMock parent;
	private final String name;
	private final MockChunkProvider provider;

	/**
	 * Create a mock of a Minecraft WorldServer
	 *
	 * @param parent parent server
	 * @param name name of the WorldServer
	 */
	@ConstructorProperties({ "name" })
	public WorldServerMock(final ServerMock parent, final String name) {
		this.parent = parent;
		this.name = name;
		this.provider = new MockChunkProvider(this);
	}

}
