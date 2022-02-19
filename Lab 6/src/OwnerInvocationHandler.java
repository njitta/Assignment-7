import java.lang.reflect.*;
 
public class OwnerInvocationHandler implements InvocationHandler { 
	DoorProxy door;
 
	public OwnerInvocationHandler(DoorProxy door) {
		this.door = door;
	}
 
	public Object invoke(Object proxy, Method method, Object[] args) 
			throws IllegalAccessException {
  
		try {
			if (method.getName().startsWith("get")) {
				return method.invoke(door, args);
   			} else if (method.getName().equals("setSellingPrice")) {
				throw new IllegalAccessException();
			} else if (method.getName().startsWith("set")) {
				return method.invoke(door, args);
			} 
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } 
		return null;
	}
}