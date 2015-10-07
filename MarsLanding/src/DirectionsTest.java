import static org.junit.Assert.*;

import org.junit.Test;


public class DirectionsTest {
	Directions direction = Directions.NORTH;
	int times = 10,shift = 1,iterations= (4*times)+shift;
	@Test
	public void testBasicFunctions() {
		assertEquals(Directions.NORTH,Directions.getDirectionForCode(direction.getDirectionCode()));
	}
	@Test
	public void testGetNext() {
		direction = (direction != Directions.NORTH ? Directions.NORTH : direction);
		for(int i=0;i<iterations;i++){
			direction = direction.getNext();
		}
		assertEquals(Directions.EAST,direction);
	}
	@Test
	public void testGetPrevious() {
		direction = (direction != Directions.NORTH ? Directions.NORTH : direction);
		for(int i=0;i<iterations;i++){
			direction = direction.getPrevious();
		}
		assertEquals(Directions.WEST,direction);
	}

}
