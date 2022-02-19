public interface DoorProxy {
 
	String getDoorType();
	String getDoorSize();
	String getDoorDesign();
	String getSellingPrice();
 
    void setDoorType(String type);
    void setDoorSize(String size);
    void setDoorDesign(String design);
    void setSellingPrice(String price); 
 
}