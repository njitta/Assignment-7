public class Door implements DoorProxy {
	String type;
	String design;
	String size;
	String price;
	
  
	public String getDoorType() {
		return type;	
	} 
  
	public String getDoorDesign() {
		return design;
	}
  
	public String getSellingPrice() {
		return price;
	}
   
	public String getDoorSize() {
		return size;
	}
  
 
	public void setDoorSize(String size) {
		this.size = size;
	}
 
	public void setDoorDesign(String design) {
		this.design = design;
	} 
  
	public void setSellingPrice(String price) {
		this.price = price;
	} 
  
	public void setDoorType(String type) {
		this.type = type;
	}

}