package test;

import org.junit.Assert;
import org.testng.annotations.Test;

public class Dummy_For_Listener {
	
	@Test
	public void step01() {
		System.out.println("This is dummy step01");
	}
	
	@Test
	public void step02() {
		System.out.println("This is dummy step02");
		Assert.assertTrue(false);
	}

}
