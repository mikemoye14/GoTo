package goToPackage;

public class PopSpot {
	
	private String id;
	private String name;
	private String location;
	private String description;
	private String hours;

	public PopSpot(){
				
	}
	
	public PopSpot(String id, String name, String location, String desc, String hrs){
		
		this.id = id;
		this.name = name;
		this.location = location;
		this.description = desc;
		this.hours = hrs;
		
	}
	
	public void setPopSpotId(String id){
		
		this.id = id;
		
	}

	public void setPopSpotName(String name){
		
		this.name = name;
		
	}
	
	public void setPopSpotLocation(String location){
		
		this.location = location;
		
	}
	
	
	public void setPopSpotDescription(String desc){
		
		this.description = desc;
		
	}
	
	public void setPopSpothours(String hrs){
		
		this.hours = hrs;
		
	}	
	
	public String getPopSpotId(){
		
		return this.id;
		
	}

	public String getPopSpotName(){
		
		return this.name;
		
	}
	
	public String getPopSpotLocation(){
		
		return this.location;
		
	}
	
	
	public String getPopSpotDescription(){
		
		return this.description;
		
	}
	
	public String getPopSpothours(){
		
		return this.hours;
		
	}
	
	
}
