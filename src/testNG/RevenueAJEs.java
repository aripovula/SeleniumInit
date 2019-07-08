package testNG;

import org.testng.annotations.Test;

public class RevenueAJEs {

	@Test(groups= {"smoke"})
	public void Test1() {
		System.out.println("TEST");
	}

	@Test
	public void Test2() {
		System.out.println("TEST TWO");
	}

}
