package sorryGame;

/**
 * CS Program: Pawn Programmer: Al Moataz Hassan Date: 3/23/12
 */
public class Pawn {
	private int num;
	private String id, positionID, color;
	private int location;
    PlayableSquare[] array;
	
	public Pawn(String color, String positionID, int number, int location, PlayableSquare[] array){
		this.color = color;
		this.num = number;
        this.location = location;
        setArray(array);
		this.setID(number);
	}
    public Pawn(){

    }
	
	public void setColor(String color){
		this.color = color;
        this.setID(this.num);
	}
	
	public String getColor(){
		return this.color;
	}
	
	public void setNum(int num){
		this.num = num;
		this.setID(num);
	}
	
	public int getNum(){
		return this.num;
	}
	
	public void setID(int number){
		this.id = this.color.toCharArray()[0] + Integer.toString(number);
	}
	
	public String getID(){
		return this.id;
	}

    public PlayableSquare[] getArray(){
        return this.array;
    }

    public void setArray(PlayableSquare[] array){
        this.array = array;
    }
	public void setLocation(int l){
		this.location = l;
	}
	
	public int getLocation(){
		return this.location;
	}
}
