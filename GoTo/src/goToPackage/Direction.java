package goToPackage;

public class Direction {
	
	private String id;
	private String sequenceNumber;
	private String beginning;
	private String destination;
	private String imageId;

	public Direction(){
		
	}
	
	public Direction(String id, String sequenceNumber, String beginning, String destination, String imageId){
		
		this.id = id;
		this.sequenceNumber = sequenceNumber;
		this.beginning = beginning;
		this.destination = destination;
		this.imageId = imageId;
		
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
	
	public void setDirectionImageId(String imageId){
		
		this.imageId = imageId;
		
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
	
	public String getDirectionImageId(){
		
		return this.imageId;
		
	}

}
