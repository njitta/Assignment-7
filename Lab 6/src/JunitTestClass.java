import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class JunitTestClass {

	@Test
	void test() {
		DoorTestDriveClass door = new DoorTestDriveClass();
		assertTrue(door != null);
		door.drive();
		assertTrue(door != null);
	
	}

}
