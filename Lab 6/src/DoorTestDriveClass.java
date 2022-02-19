import java.lang.reflect.*;
import java.util.*;

public class DoorTestDriveClass {
	HashMap<String, DoorProxy> datingDB = new HashMap<String, DoorProxy>();
 	
	public static void main(String[] args) {
		DoorTestDriveClass door = new DoorTestDriveClass();
		door.drive();
	}
 
	public DoorTestDriveClass() {
		initializeDatabase();
	}

	public void drive() {
		DoorProxy door = getDoorProxyFromDatabase("Wooden Door"); 
		DoorProxy ownerProxy = getOwnerProxy(door);
		System.out.println(" :: Door type ==> " + ownerProxy.getDoorType());
		ownerProxy.setDoorDesign("Classic");
		System.out.println("\n :: Door Design set from owner proxy");
		
		DoorProxy nonOwnerProxy = getNonOwnerProxy(door);
		System.out.println("\n :: Door Type ==> " + nonOwnerProxy.getDoorType());
		try {
			nonOwnerProxy.setDoorSize("Room Size");
		} catch (Exception e) {
			System.out.println("\n :: Can't set Door Size from non owner proxy");
		}
		
	}

	DoorProxy getOwnerProxy(DoorProxy door) {
 		
        return (DoorProxy) Proxy.newProxyInstance( 
            	door.getClass().getClassLoader(),
            	door.getClass().getInterfaces(),
                new OwnerInvocationHandler(door));
	}

	DoorProxy getNonOwnerProxy(DoorProxy door) {
		
        return (DoorProxy) Proxy.newProxyInstance(
            	door.getClass().getClassLoader(),
            	door.getClass().getInterfaces(),
                new NonOwnerInvocationHandler(door));
	}

	DoorProxy getDoorProxyFromDatabase(String name) {
		return (DoorProxy)datingDB.get(name);
	}

	void initializeDatabase() {
		DoorProxy woodendoor = new Door();
		woodendoor.setDoorType("Wooden Door");
		woodendoor.setDoorSize("Room Size");
		woodendoor.setDoorDesign("Classic");
		datingDB.put(woodendoor.getDoorType(), woodendoor);

		DoorProxy aluminiumdoor = new Door();
		aluminiumdoor.setDoorType("Aluminium Door");
		aluminiumdoor.setDoorSize("Main Door");
		aluminiumdoor.setDoorDesign("Modern");
		datingDB.put(aluminiumdoor.getDoorType(), aluminiumdoor);
	}
}