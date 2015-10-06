import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.util.*;

public class MarsMission {
	public static void main( String[] args){
		
		if( args.length != 1 ){
			help();
		}else{
			
			Vector<String> missionInformation = parseMissionFile(args[0]);
			if( missionInformation != null ){
				
				Iterator<String> mission_it = missionInformation.iterator();
				String[] mapSize = mission_it.next().split(" ");
				Vector<Rover> rovers = new Vector<Rover>();
				
				int roverID=0;
				while( mission_it.hasNext() ){
					String[] initialPose = mission_it.next().split(" ");
					if (initialPose.length == 3){
						rovers.add(new Rover( roverID,
											  Integer.parseInt(initialPose[0]),
											  Integer.parseInt(initialPose[1]),
											  Directions.getDirectionForCode(initialPose[2].charAt(0)),
											  Integer.parseInt(mapSize[0]),
											  Integer.parseInt(mapSize[1])
											  ));
						
						rovers.lastElement().setMission(mission_it.next());
						
					}else{
						System.out.println(".:Rover "+roverID+" aborted the exploration:.");
						System.out.println("\t\tInvalid initial Pose, commands skipped");
						
						if( mission_it.hasNext() )
							mission_it.next();
					}
					roverID++;
				}
								
				Iterator<Rover> it = rovers.iterator();
				while( it.hasNext() ){
					Rover obj=it.next();
					if(obj.run())
						obj.endMission();
				}
			}else{
				System.out.println("\t\t\t.:Invalid mission:.");
				help();
			}
		}
	}

	private static void help() {
		// TODO Auto-generated method stub
		System.out.println("Please provide information for the new mission ");
		System.out.println("Organize a misson file like: mission.txt ");
		
		System.out.println("\n5 5");
		System.out.println("1 2 N");
		System.out.println("LMLMLMLMM");
		System.out.println("3 3 E");
		System.out.println("MMRMMRMRRM \n");
		
		System.out.println("The first line of input is the upper-right coordinates of the plateau, the lower-left coordinates are assumed to be 0,0");
		System.out.println("The rest of the input is information pertaining to the rovers that have been deployed.\nEach rover has two lines of input.\nThe first line gives the rover’s position, and the second line is a series of instructions telling the rover how to explore the plateau.");
		System.out.println("Finally call MarsMission.java mission.txt");
	}
	private static Vector<String> parseMissionFile(String fileName){
		Vector<String> missionInformation = new Vector<String>();
		try {
			InputStream in = new FileInputStream(fileName);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			//Read File Line By Line
			while ((strLine = br.readLine()) != null)   {
				missionInformation.add(strLine);
			}
			//Close the input stream
			in.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		if( missionInformation.size() % 2 == 0  ){
			missionInformation.clear();
			return null;
		}
		return missionInformation;
	}
}