import java.util.*;
/*TODO
 * 1) Improve INPUT parsing
 * 2) Add handling of map size
 * */
public class MarsMission {
	public static void main( String[] args){
		Vector<Rover> rovers = new Vector<Rover>();
		rovers.add(new Rover(1,2,Directions.NORTH));
		rovers.lastElement().setMission("LMLMLMLMM");
		rovers.add(new Rover(3,3,Directions.EAST));
		rovers.lastElement().setMission("MMRMMRMRRM");
		
		Iterator<Rover> it = rovers.iterator();
		while( it.hasNext() ){
			Rover obj=it.next();
			if(obj.run())
				obj.endMission();
		}
	}
}
