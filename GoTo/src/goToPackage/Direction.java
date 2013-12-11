package goToPackage;

public class Direction {
	
	private String id;
	private String sequenceNumber;
	private String beginning;
	private String destination;
	private int image;
	private String directionTxt;

	public Direction(){
		
	}
	
	public Direction(String id, String directionTxt, int image){
		
		this.id = id;
		this.directionTxt = directionTxt;
		this.image = image;
		
	}
	
	public Direction(String id, String sequenceNumber, String beginning, String destination, int image){
		
		this.id = id;
		this.sequenceNumber = sequenceNumber;
		this.beginning = beginning;
		this.destination = destination;
		this.image = image;
		
	}
	
	public void setDirectionId(String id){
		
		this.id = id;
		
	}
	
	public void setDirectionSequenceNumber(String sequenceNumber){
		
		this.sequenceNumber = sequenceNumber;
		
	}
	
	public void setDirectionBeginning(String beginning){
		
		this.beginning = beginning;
		
	}
	
	public void setDirectionDestination(String destination){
		
		this.destination = destination;
		
	}
	
	public void setDirectionImageId(int image){
		
		this.image = image;
		
	}
	
	public void setDirectionTxt(String directionTxt){
		
		this.directionTxt = directionTxt;
		
	}
	
	
	public String getDirectionId(){
		
		return this.id;
		
	}
	
	public String getDirectionSequenceNumber(){
		
		return this.sequenceNumber;
		
	}
	
	public String getDirectionBeginning(){
		
		return this.beginning;
		
	}
	
	public String getDirectionDestination(){
		
		return this.destination;
		
	}
	
	public int getDirectionImage(){
		
		return this.image;
		
	}
	
	public String getDirectionTxt(){
		
		return this.directionTxt;
		
	}

}
