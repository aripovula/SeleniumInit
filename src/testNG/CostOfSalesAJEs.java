package testNG;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CostOfSalesAJEs {

	@Test(dataProvider="provideData")
	public void Test1(String first, String second) {
		System.out.println("3 TEST 2");
		System.out.println(first);
		System.out.println(second);
	}

	@Test(groups= {"smoke"})
	public void BTest2() {
		System.out.println("2 TEST 2 TWO B");
	}
	
	@Test(dependsOnMethods= {"BTest2", "Test1"})
	public void ATest2() {
		System.out.println("1 TEST 2 TWO");
		Assert.assertTrue(false);
	}
	
	@DataProvider
	public Object[][] provideData() {
		Object[][] data = new Object[3][2];
		data[0][0] = "1-1";
		data[0][1] = "1-2";
		data[1][0] = "2-1";
		data[1][1] = "2-2";
		data[2][0] = "3-1";
		data[2][1] = "3-2";
		return data;
	}
	

}
