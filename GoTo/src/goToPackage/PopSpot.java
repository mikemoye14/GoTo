package goToPackage;

public class PopSpot {
	
	private String id;
	private String name;
	private String description;
	private String hours;

	public PopSpot(){
				
	}
	
	public PopSpot(String id, String name, String desc, String hrs){
		
		this.id = id;
		this.name = name;
		this.description = desc;
		this.hours = hrs;
		
	}
	
	public void setPopspotId(String id){
		
		this.id = id;
		
	}

	public void setPopspotName(String name){
		
		this.name = name;
		
	}
	
	
	public void setPopspotDescription(String desc){
		
		this.description = desc;
		
	}
	
	public void setPopSpothours(String hrs){
		
		this.hours = hrs;
		
	}	
	
	public String getPopspotId(){
		
		return this.id;
		
	}

	public String getPopspotName(){
		
		return this.name;
		
	}
	
	
	public String getPopspotDescription(){
		
		return this.description;
		
	}
	
	public String getPopSpothours(){
		
		return this.hours;
		
	}
	
	
}
