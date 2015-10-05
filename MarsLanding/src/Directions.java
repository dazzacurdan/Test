
public enum Directions {
	NORTH ('N'),
	EAST ('E'),
	SOUTH ('S'), 
	WEST ('W')
  ; 
  /* Important Note: Must have semicolon at
   * the end when there is a enum field or method
   */
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
}
