import static org.junit.Assert.*;

import org.junit.Test;

public class RoverTest {
	Rover rover = new Rover(0,1,2,Directions.NORTH,5,5);
	@Test
	public void testMission1() {
	   rover.setMission("LMLMLMLMM");
	   assertEquals(true,rover.run());
	   assertEquals("1 3 N",rover.getState());
	}
	@Test
	public void testMission2() {
	   rover.changeStartingPoint(3, 3, Directions.EAST);
	   rover.setMission("MMRMMRMRRM");
	   assertEquals(true,rover.run());
	   assertEquals("5 1 E",rover.getState());
	}

}


