import java.lang.reflect.*;
 
public class NonOwnerInvocationHandler implements InvocationHandler { 
	DoorProxy door;
 
	public NonOwnerInvocationHandler(DoorProxy door) {
		this.door = door;
	}
 
	public Object invoke(Object proxy, Method method, Object[] args) 
			throws IllegalAccessException {
  
		try {
			if (method.getName().startsWith("get")) {
				return method.invoke(door, args);
   			} else if (method.getName().equals("setSellingPrice")) {
				return method.invoke(door, args);
			} else if (method.getName().startsWith("set")) {
				throw new IllegalAccessException();
			} 
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } 
		return null;
	}
}