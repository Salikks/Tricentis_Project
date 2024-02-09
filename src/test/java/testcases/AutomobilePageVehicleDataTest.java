package testcases;

import org.testng.Assert;
import org.testng.annotations.*;
import base.TestBase;
import pages.AutomobilePageVehicleData;
import utility.TestUtil;

public class AutomobilePageVehicleDataTest extends TestBase{
	AutomobilePageVehicleData automobileVehicleData;
	
	public AutomobilePageVehicleDataTest() {
		super();
	}
	
	@BeforeMethod
	public void pageClassInitialization() {
		automobileVehicleData = new AutomobilePageVehicleData();
		automobileVehicleData.verifyAutomobileLink();
	}
	
	@Test(priority = 0)
	public void verifyAutomobileLinkTest() {
		String insuranceName = automobileVehicleData.verifyAutomobileLink();
		Assert.assertEquals(insuranceName, "Automobile Insurance", "Insurance name did not match");
	}
	
	@Test(priority = 1)
	public void verifyManSignMakeTest() {
		boolean mandatorySignForMake = automobileVehicleData.verifyManSignMake();
		Assert.assertTrue(mandatorySignForMake);
	}
	
	@Test(priority = 2)
	public void verifyHovErrMsgMakeTest() {
		String textOfMandatorySignForMake = automobileVehicleData.verifyHovErrMsgMake();
		Assert.assertEquals(textOfMandatorySignForMake, "Select an option");
	}
	
	@Test(priority = 3)
	public void verifyDropdownMakeTest() {
		boolean makeDropdown = automobileVehicleData.verifyDropdownMake();
		Assert.assertTrue(makeDropdown);
	}
	
	@Test(priority=4)
	public void verifyManMsgMakeTest() {
		String textOfMandatorySignForMake = automobileVehicleData.verifyManMsgMake();
		Assert.assertEquals(textOfMandatorySignForMake, "Select an option");
	}

	@DataProvider
	public Object[] getMakeData() {
		Object makeData[] = TestUtil.getTestData("Sheet1");
		return makeData;
	}
	
	@Test(priority = 5, dataProvider="getMakeData")
	public void verifyListMakeTest(String dropdownValue) {
		String selectedValue = automobileVehicleData.verifyListMake(dropdownValue);
		Assert.assertEquals(selectedValue, dropdownValue);
	}
	
	
	@Test(priority=6)
	public void verifyManSignEPTest() {
		boolean signForEP = automobileVehicleData.verifyManSignEP();
		Assert.assertTrue(signForEP);
	}
	
	@Test(priority=7)
	public void verifyHovErrMsgEPTest() {
		String textForEP = automobileVehicleData.verifyHovErrMsgEP();
		Assert.assertEquals(textForEP, "This field is mandatory");
	}
	
	@Test(priority=8)
	public void verifyManMsgEPTest() {
		String textForEP = automobileVehicleData.verifyManMsgEP();
		Assert.assertEquals(textForEP, "This field is mandatory");
	}
	
	@Test(priority=9)
	public void alphaErrMsgEPTest() {
		String errorMessage = automobileVehicleData.verifyErrMsgEP("ABCD");
		Assert.assertEquals(errorMessage, "Must be a number between 1 and 2000");
	}
	
	@Test(priority=10)
	public void speErrMsgEPTest() {
		String errorMessage = automobileVehicleData.verifyErrMsgEP("@#$%");
		Assert.assertEquals(errorMessage, "Must be a number between 1 and 2000");
	}
	
	@Test(priority=11)
	public void spaceErrMsgEPTest() {
		String errorMessage = automobileVehicleData.verifyErrMsgEP("2 2");
		Assert.assertEquals(errorMessage, "Must be a number between 1 and 2000");
	}

	@Test(priority=12)
	public void lowErrMsgEPTest() {
		String errorMessage = automobileVehicleData.verifyErrMsgEP("0000");
		Assert.assertEquals(errorMessage, "Must be a number between 1 and 2000");
	}

	@Test(priority=13)
	public void highErrMsgEPTest() {
		String errorMessage = automobileVehicleData.verifyErrMsgEP("2001");
		Assert.assertEquals(errorMessage, "Must be a number between 1 and 2000");
	}
	
	@Test(priority=14)
	public void trueValueEPTest() {
		boolean errorMessage = automobileVehicleData.verifyEleEP("63");
		Assert.assertFalse(errorMessage);
	}
	
	@Test(priority=15)
	public void verifyHovErrMsgDoMTest() {
		String errMsg = automobileVehicleData.verifyHovErrMsgDoM();
		Assert.assertEquals(errMsg, "This field is mandatory");
	}

	@Test(priority=16)
	public void verifyDatePickerTest() {
		boolean datePicker = automobileVehicleData.verifyDatePicker();
		Assert.assertTrue(datePicker);
	}
	
	@Test(priority=17)
	public void verifyCurMonthTest() {
		String curMonth = automobileVehicleData.verifyCurMonth();
		Assert.assertEquals(curMonth, TestUtil.currentMonth());
	}
	
	@Test(priority=18)
	public void verifyFwdPrevButtonTest() {
		boolean months = automobileVehicleData.verifyFwdPrevButton();
		Assert.assertTrue(months);
	}
	
	@Test(priority=19)
	public void verifyFutureErrMsgTest() {
		String futErrMsg = automobileVehicleData.verifyFutureErrMsg();
		Assert.assertEquals(futErrMsg, "Must be today or somewhere in the past");
	}
	
	@Test(priority=20)
	public void verifyInvalidErrMsgTest() {
		String errMsg = automobileVehicleData.verifyInvalidErrMsg("23/10/2023");
		Assert.assertEquals(errMsg, "Must be a valid date");
	}
	
	@Test(priority=21)
	public void verifyTrueDateTest() {
		boolean errDisplayed = automobileVehicleData.verifyTrueDate();
		Assert.assertFalse(errDisplayed);
	}
}
