import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Vector;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class MarsMissionTest extends MarsMission{
	MarsMission mission = new MarsMission();
	String fileInexistent = "mission.txt";
	String file = "/home/pasteris/Test1/MarsLanding/src/mission.txt";
		
	/*@Before
	public void setUpStreams() {
	    System.setOut(new PrintStream(outContent));
	    System.setErr(new PrintStream(errContent));
	}

	@After
	public void cleanUpStreams() {
	    System.setOut(null);
	    System.setErr(null);
	}*/
	
	/*@Test
	public void testApp() {
		MarsMission.main(new String[]{});
		String mainOut = outContent.toString();
		System.out.println(mainOut);
		
		MarsMission.help();
		String helpOut=outContent.toString();
		
		assertEquals(helpOut,mainOut);
	}*/
	@Test
	public void testParseMissionFile() {
		Vector<String> validMission = new Vector<String>();
		validMission.add("5 5");
		validMission.add("1 2 N");
		validMission.add("LMLMLMLMM");
		validMission.add("3 3 E");
		validMission.add("MMRMMRMRRM");
		assertEquals(validMission,MarsMission.parseMissionFile(file));
		assertNull(MarsMission.parseMissionFile(fileInexistent));
	}

}
