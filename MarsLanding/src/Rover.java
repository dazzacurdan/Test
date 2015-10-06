public class Rover {
	private int x,y;//Actual position of the rover
	Directions orientation;//Actual orientation of the rover
	
	private int mapW=5,mapH=5;//Map Size
	private String missionCommands;
	/*Default constructor: set the rover in the origin of the landing area*/
	Rover(){
		this.x = 0;
		this.y = 0;
		this.orientation = Directions.NORTH;
	}
	Rover(int x,int y,Directions orientation){
		this.x = x;
		this.y = y;
		this.orientation = orientation;
	}
	Rover(String initialState){
		String[] tokens = initialState.split(" ");
		if (tokens.length == 3){
			this.x = Integer.parseInt(tokens[0]);
			this.y = Integer.parseInt(tokens[1]);
			this.orientation = Directions.getDirectionForCode( tokens[2].charAt(0) );
		}else{
			//this();
		}
		
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
			if(y<mapW){
				y++;
				state=true;
			}
			break;
		case EAST:
			x++;state=true;
			break;
		case SOUTH:
			y--;state=true;
			break;
		case WEST:
			x--;state=true;
			break;
		default:
			System.out.println("Invalid Movement: "+orientation.getDirectionCode());
			break;
		}
		return state;
	}
	public void endMission(){
		System.out.println("Mission complete:");
		System.out.println(x+" "+y+" "+orientation.getDirectionCode());
	}
}
