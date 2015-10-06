
public enum Directions {
	NORTH ('N'),
	 EAST ('E'),
	SOUTH ('S'), 
	 WEST ('W')
  ; 
  
  private final char shortCode;
	  
  Directions(char code) {
      this.shortCode = code;
  }	  
  public char getDirectionCode() {
      return this.shortCode;
  }
  public static Directions getDirectionForCode(final char code)
  {
      for (Directions type : Directions.values())
          if (type.shortCode == code)
              return type;

      return null;
  }
  public Directions getNext() {
	  return values()[(ordinal()+1) % values().length];
  }
  public Directions getPrevious() {	  
	  return values()[( (ordinal()-1 < 0 ? values().length-1 : ordinal()-1 )) % values().length];
  }
}
