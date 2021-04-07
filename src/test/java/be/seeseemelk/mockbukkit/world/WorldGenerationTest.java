package be.seeseemelk.mockbukkit.world;

import be.seeseemelk.mockbukkit.MockBukkit;
import be.seeseemelk.mockbukkit.ServerMock;
import be.seeseemelk.mockbukkit.WorldMock;
import org.bukkit.Material;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * WorldGenerationTest
 *
 * @author bfu4
 * @since 4/6/2021 @ 10:00 PM
 */
public class WorldGenerationTest {

	private ServerMock server;
	private WorldMock world;

	@Before
	public void setUp() {
		server = MockBukkit.mock();
		world = server.addSimpleWorld("world");
	}

	@Test
	public void testGeneratorProperties() {
		MockWorldGenerator generator = world.createGenerator();

		Assert.assertEquals(generator.getHeight(), 128);
		Assert.assertEquals(generator.getDefaultBlock(), Material.GRASS);
	}

	@Test
	public void testNotchProperties() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {

		// TODO: cry
		MockWorldGenerator generator = world.createGenerator();

		Assert.assertNotNull(generator);

		// MockWorldGenerator generator = world.createGenerator();
		// World world = generator.createWorld();
	}


	@After
	public void tearDown()
	{
		MockBukkit.unmock();
	}

}
