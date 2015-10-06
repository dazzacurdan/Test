/*TODO
 * 1) Improve Doxygen Documentation
 * 3) Add tests in particular for:
 * 		run()
 *      stress map limits, sequnce of command,  
 * */
public class Rover {
	private int id;
	private final int defaultMapW=5,defaultMapH=5;//Default Map Size
	private int x,y;//Actual position of the rover
	private int mapW,mapH;//Default Map Size
	Directions orientation;//Actual orientation of the rover
	
	private String missionCommands;
	
	/*Default constructor: set the rover in the origin of the landing area*/
	Rover(){
		this.id = 0;
		this.x = 0;
		this.y = 0;
		this.orientation = Directions.NORTH;
		this.mapW=this.defaultMapW;
		this.mapH=this.defaultMapH;
	}
	Rover(int id, int x,int y,Directions orientation, int mapW, int mapH ){
		this.id = id;
		this.x = x;
		this.y = y;
		this.orientation = orientation;
		this.mapW=mapW;
		this.mapH=mapH;
	}
	
	public void setMission(String missionCommands){ 
		this.missionCommands = missionCommands;
	}
	public boolean run(){
		boolean state=true;char command;
		for(int i=0;i < missionCommands.length();i++){
			command = missionCommands.charAt(i);
			switch( command ){
				case 'M':
					if(!move()){
						state = false;
						break;
					}
				break;
				case 'L':
					orientation=orientation.getPrevious();
				break;
				case 'R':
					orientation=orientation.getNext();
				break;
				default:
					state = false;
				break;
			}
		}
		return state;
	}
	private boolean move(){
		boolean state=false;
		switch(orientation){
		case NORTH:
			if(y < mapH){
				y++;
				state=true;
			}
			break;
		case EAST:
			if(x < mapW){
				x++;
				state=true;
			}
			break;
		case SOUTH:
			if(y >= 0){
				y--;
				state=true;
			}
			break;
		case WEST:
			if(x >= 0){
				x--;
				state=true;
			}
			break;
		default:
			System.out.println("Invalid Movement: "+orientation.getDirectionCode());
			System.out.println(".:Mission Aborted:. ");
			break;
		}
		return state;
	}
	public void endMission(){
		System.out.println(".:Rover "+id+" complete the exploration:.");
		System.out.println("\t\t"+x+" "+y+" "+orientation.getDirectionCode());
	}
	public int getID(){
		return id;
	}
}
