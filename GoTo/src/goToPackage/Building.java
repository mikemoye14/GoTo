package goToPackage;

public class Building {
	
	private String id;
	private String name;
	private String info;
	private Image image;
	private Direction directions;

	public Building(){
		
	}
	
	
	public Building(String id, String name, String info){
				
		this.id = id;
		this.name = name;
		this.info = info;
		
	}
	
	public Building(String id, String name, Image img, Direction dir){
		
		this.id = id;
		this.name = name;;
		this.image = img;
		this.directions = dir;
		
	}
	
	public void setbuildingId(String id){
		
		this.id = id;
		
	}
	
	public void setbuildingName(String name){
		
		this.name = name;
		
	}
	
	public void setBuildingInfo(String info){
		
		this.info = info;
		
	}
	
	public void setBuildingImage(Image img){
				
		this.image = img;
		
	}
	
	public void setBuildingDirections(Direction dir){
		
		this.directions = dir;
		
	}
	
	public String getBuildingId(){
		
		return this.id;
		
	}
	
	public String getBuildingName(){
		
		return this.name;
		
	}
	
	
	public String getBuildingInfo(){
		
		return this.info;
		
	}
	
	public Image getBuildingImage(){
		
		return this.image;
		
	}
	
	public Direction getBuildingDirections(){
		
		return this.directions;
		
	}

}


