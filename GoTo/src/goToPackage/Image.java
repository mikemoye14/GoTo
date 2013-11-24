package goToPackage;

public class Image {
	
	private String id;
	private String name;
	private String url;
	private String type;

	public Image(){	
				
	}
	
	public Image(String id, String name, String url, String type){
		
		this.id = id;
		this.name = name;
		this.url = url;
		this. type = type;
		
	}
	
	public void setImageId(String id){
		
		this.id = id;
		
	}
	
	public void setImageName(String name){
		
		this.name = name;
		
	}
	
	public void setImageURL(String url){
		
		this.url = url;
		
	}
	
	public void setImageType(String type){
		
		this.type = type;
		
	}
	
	public String getImageId(){
		
		return this.id;
		
	}
	
	public String getImageName(){
		
		return this.name;
		
	}
	
	public String getImageURL(){
		
		return this.url;
		
	}
	
	public String getImageType(){
		
		return this.type;
		
	}
	
}
