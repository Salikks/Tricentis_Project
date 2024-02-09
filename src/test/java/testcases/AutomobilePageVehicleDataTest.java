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
		automobileVehicleData.enterVehicleDataTab.click();
	}
	
	@Test(priority = 0, groups = {"Automobile_Link"})
	public void verifyAutomobileLinkTest() {
		String insuranceName = automobileVehicleData.verifyAutomobileLink();
		Assert.assertEquals(insuranceName, "Automobile Insurance", "Insurance name did not match");
	}
	
	@Test(priority = 1, groups = {"Make_Dropdown"})
	public void verifyManSignMakeTest() {
		boolean mandatorySignForMake = automobileVehicleData.verifyManSignMake();
		Assert.assertTrue(mandatorySignForMake);
	}
	
	@Test(priority = 2, groups = {"Make_Dropdown"})
	public void verifyHovErrMsgMakeTest() {
		String textOfMandatorySignForMake = automobileVehicleData.verifyHovErrMsgMake();
		Assert.assertEquals(textOfMandatorySignForMake, "Select an option");
	}
	
	@Test(priority = 3, groups = {"Make_Dropdown"})
	public void verifyDropdownMakeTest() {
		boolean makeDropdown = automobileVehicleData.verifyDropdownMake();
		Assert.assertTrue(makeDropdown);
	}
	
	@Test(priority=4, groups = {"Make_Dropdown"})
	public void verifyManMsgMakeTest() {
		String textOfMandatorySignForMake = automobileVehicleData.verifyManMsgMake();
		Assert.assertEquals(textOfMandatorySignForMake, "Select an option");
	}

	@DataProvider
	public Object[] getMakeData() {
		Object makeData[] = TestUtil.getTestData("Sheet1");
		return makeData;
	}
	
	@Test(priority = 5, dataProvider="getMakeData", groups = {"Make_Dropdown"})
	public void verifyListMakeTest(String dropdownValue) {
		String selectedValue = automobileVehicleData.verifyListMake(dropdownValue);
		Assert.assertEquals(selectedValue, dropdownValue);
	}
	
	@Test(priority=6, groups = {"Engine_Performance_Textbox"})
	public void verifyManSignEPTest() {
		boolean signForEP = automobileVehicleData.verifyManSignEP();
		Assert.assertTrue(signForEP);
	}
	
	@Test(priority=7, groups = {"Engine_Performance_Textbox"})
	public void verifyHovErrMsgEPTest() {
		String textForEP = automobileVehicleData.verifyHovErrMsgEP();
		Assert.assertEquals(textForEP, "This field is mandatory");
	}
	
	@Test(priority=8, groups = {"Engine_Performance_Textbox"})
	public void verifyManMsgEPTest() {
		String textForEP = automobileVehicleData.verifyManMsgEP();
		Assert.assertEquals(textForEP, "This field is mandatory");
	}
	
	@Test(priority=9, groups = {"Engine_Performance_Textbox"})
	public void alphaErrMsgEPTest() {
		String errorMessage = automobileVehicleData.verifyErrMsgEP("ABCD");
		Assert.assertEquals(errorMessage, "Must be a number between 1 and 2000");
	}
	
	@Test(priority=10, groups = {"Engine_Performance_Textbox"})
	public void speErrMsgEPTest() {
		String errorMessage = automobileVehicleData.verifyErrMsgEP("@#$%");
		Assert.assertEquals(errorMessage, "Must be a number between 1 and 2000");
	}
	
	@Test(priority=11, groups = {"Engine_Performance_Textbox"})
	public void spaceErrMsgEPTest() {
		String errorMessage = automobileVehicleData.verifyErrMsgEP("2 2");
		Assert.assertEquals(errorMessage, "Must be a number between 1 and 2000");
	}

	@Test(priority=12, groups = {"Engine_Performance_Textbox"})
	public void lowErrMsgEPTest() {
		String errorMessage = automobileVehicleData.verifyErrMsgEP("0000");
		Assert.assertEquals(errorMessage, "Must be a number between 1 and 2000");
	}

	@Test(priority=13, groups = {"Engine_Performance_Textbox"})
	public void highErrMsgEPTest() {
		String errorMessage = automobileVehicleData.verifyErrMsgEP("2001");
		Assert.assertEquals(errorMessage, "Must be a number between 1 and 2000");
	}
	
	@Test(priority=14, groups = {"Engine_Performance_Textbox"})
	public void trueValueEPTest() {
		boolean errorMessage = automobileVehicleData.verifyEleEP("63");
		Assert.assertFalse(errorMessage);
	}
	
	@Test(priority=15, groups = {"Date_Of_Manufacture_Field"})
	public void verifyHovErrMsgDoMTest() {
		String errMsg = automobileVehicleData.verifyHovErrMsgDoM();
		Assert.assertEquals(errMsg, "This field is mandatory");
	}

	@Test(priority=16, groups = {"Date_Of_Manufacture_Field"})
	public void verifyDatePickerTest() {
		boolean datePicker = automobileVehicleData.verifyDatePicker();
		Assert.assertTrue(datePicker);
	}
	
	@Test(priority=17, groups = {"Date_Of_Manufacture_Field"})
	public void verifyCurMonthTest() {
		String curMonth = automobileVehicleData.verifyCurMonth();
		Assert.assertEquals(curMonth, TestUtil.currentMonth());
	}
	
	@Test(priority=18, groups = {"Date_Of_Manufacture_Field"})
	public void verifyFwdPrevButtonTest() {
		boolean months = automobileVehicleData.verifyFwdPrevButton();
		Assert.assertTrue(months);
	}
	
	@Test(priority=19, groups = {"Date_Of_Manufacture_Field"})
	public void verifyFutureErrMsgTest() {
		String futErrMsg = automobileVehicleData.verifyFutureErrMsg();
		Assert.assertEquals(futErrMsg, "Must be today or somewhere in the past");
	}
	
	@Test(priority=20, groups = {"Date_Of_Manufacture_Field"})
	public void verifyInvalidErrMsgTest() {
		String errMsg = automobileVehicleData.verifyInvalidErrMsg("23/10/2023");
		Assert.assertEquals(errMsg, "Must be a valid date");
	}
	
	@Test(priority=21, groups = {"Date_Of_Manufacture_Field"})
	public void verifyTrueDateTest() {
		boolean errDisplayed = automobileVehicleData.verifyTrueDate();
		Assert.assertFalse(errDisplayed);
	}
	
	@Test(priority = 22, groups = {"Number_of_Seats_Dropdown"})
	public void verifyManSignNoSTest() {
		boolean signDisplayed = automobileVehicleData.verifyManSignNoS();
		Assert.assertTrue(signDisplayed);
	}
	
	@Test(priority = 23, groups = {"Number_of_Seats_Dropdown"})
	public void verifyHovErrMsgNoSTest() {
		String hvrText = automobileVehicleData.verifyHovErrMsgNoS();
		Assert.assertEquals(hvrText, "Select an option");
	}
	
	@Test(priority = 24, groups = {"Number_of_Seats_Dropdown"})
	public void verifyManMsgNoSTest() {
		String manMsg = automobileVehicleData.verifyManMsgNoS();
		Assert.assertEquals(manMsg, "Select an option");
	}
	
	@DataProvider
	public Object[] getNoSData() {
		Object NoSData[] = TestUtil.getTestData("Sheet2");
		return NoSData;
	}
	
	@Test(priority = 25, dataProvider="getNoSData", groups = {"Number_of_Seats_Dropdown"})
	public void verifyListNoSTest(String dropdownValue) {
		String selectedValue = automobileVehicleData.verifyListNoS(dropdownValue);
		Assert.assertEquals(selectedValue, dropdownValue);
	}

	@Test(priority = 26, groups = {"Number_of_Seats_Dropdown"})
	public void verifyDropdownNoSTest() {
		boolean signDisplayed = automobileVehicleData.verifyDropdownNoS();
		Assert.assertFalse(signDisplayed);
	}
	
	@Test(priority = 27, groups = {"Fuel_Type_Dropdown"})
	public void verifyManSignFTTest() {
		boolean signDisplayed = automobileVehicleData.verifyManSignFT();
		Assert.assertTrue(signDisplayed);
	}
	
	@Test(priority = 28, groups = {"Fuel_Type_Dropdown"})
	public void verifyHovErrMsgFTTest() {
		String hvrText = automobileVehicleData.verifyHovErrMsgFT();
		Assert.assertEquals(hvrText, "Select an option");
	}
	
	@Test(priority = 29, groups = {"Fuel_Type_Dropdown"})
	public void verifyManMsgFTTest() {
		String manMsg = automobileVehicleData.verifyManMsgFT();
		Assert.assertEquals(manMsg, "Select an option");
	}
	
	@DataProvider
	public Object[] getFTData() {
		Object FTData[] = TestUtil.getTestData("Sheet3");
		return FTData;
	}
	
	@Test(priority = 30, dataProvider="getFTData", groups = {"Fuel_Type_Dropdown"})
	public void verifyListFTTest(String dropdownValue) {
		String selectedValue = automobileVehicleData.verifyListFT(dropdownValue);
		Assert.assertEquals(selectedValue, dropdownValue);
	}

	@Test(priority = 31, groups = {"Fuel_Type_Dropdown"})
	public void verifyDropdownFTTest() {
		boolean signDisplayed = automobileVehicleData.verifyDropdownFT();
		Assert.assertFalse(signDisplayed);
	}

	@Test(priority=32, groups = {"List_Price_Textbox"})
	public void verifyManSignLPTest() {
		boolean signForLP = automobileVehicleData.verifyManSignLP();
		Assert.assertTrue(signForLP);
	}
	
	@Test(priority=33, groups = {"List_Price_Textbox"})
	public void verifyHovErrMsgLPTest() {
		String textForLP = automobileVehicleData.verifyHovErrMsgLP();
		Assert.assertEquals(textForLP, "This field is mandatory");
	}
	
	@Test(priority=34, groups = {"List_Price_Textbox"})
	public void verifyManMsgLPTest() {
		String textForLP = automobileVehicleData.verifyManMsgLP();
		Assert.assertEquals(textForLP, "This field is mandatory");
	}
	
	@Test(priority=35, groups = {"List_Price_Textbox"})
	public void alphaErrMsgLPTest() {
		String errorMessage = automobileVehicleData.verifyErrMsgLP("ABCD");
		Assert.assertEquals(errorMessage, "Must be a number between 500 and 100000");
	}
	
	@Test(priority=36, groups = {"List_Price_Textbox"})
	public void speErrMsgLPTest() {
		String errorMessage = automobileVehicleData.verifyErrMsgLP("@#$%");
		Assert.assertEquals(errorMessage, "Must be a number between 500 and 100000");
	}
	
	@Test(priority=37, groups = {"List_Price_Textbox"})
	public void spaceErrMsgLPTest() {
		String errorMessage = automobileVehicleData.verifyErrMsgLP("2 2");
		Assert.assertEquals(errorMessage, "Must be a number between 500 and 100000");
	}

	@Test(priority=38, groups = {"List_Price_Textbox"})
	public void lowErrMsgLPTest() {
		String errorMessage = automobileVehicleData.verifyErrMsgLP("499");
		Assert.assertEquals(errorMessage, "Must be a number between 500 and 100000");
	}

	@Test(priority = 39, groups = {"List_Price_Textbox"})
	public void highErrMsgLPTest() {
		String errorMessage = automobileVehicleData.verifyErrMsgLP("100001");
		Assert.assertEquals(errorMessage, "Must be a number between 500 and 100000");
	}
	
	@Test(priority = 40, groups = {"List_Price_Textbox"})
	public void trueValueLPTest() {
		boolean errorMessage = automobileVehicleData.verifyEleLP("5000");
		Assert.assertFalse(errorMessage);
	}
	
	@Test(priority = 41, groups = {"License_Plate_Textbox"})
	public void verifyErrMsgLicPNTest() {
		String errorMessage = automobileVehicleData.verifyErrMsgLicPN();
		Assert.assertEquals(errorMessage, "Must be under 10 characters");
	}
	
	@Test(priority = 42, groups = {"License_Plate_Textbox"})
	public void verifyTrueLicPNTest() {
		boolean errorDisplayed = automobileVehicleData.verifytrueValueLicPN();
		Assert.assertFalse(errorDisplayed);
	}
	
	@Test(priority=43, groups = {"Annual_Mileage_Textbox"})
	public void verifyManSignAMTest() {
		boolean signForAM = automobileVehicleData.verifyManSignAM();
		Assert.assertTrue(signForAM);
	}
	
	@Test(priority=44, groups = {"Annual_Mileage_Textbox"})
	public void verifyHovErrMsgAMTest() {
		String textForAM = automobileVehicleData.verifyHovErrMsgAM();
		Assert.assertEquals(textForAM, "This field is mandatory");
	}
	
	@Test(priority=45, groups = {"Annual_Mileage_Textbox"})
	public void verifyManMsgAMTest() {
		String textForAM = automobileVehicleData.verifyManMsgAM();
		Assert.assertEquals(textForAM, "This field is mandatory");
	}
	
	@Test(priority=46, groups = {"Annual_Mileage_Textbox"})
	public void alphaErrMsgAMTest() {
		String errorMessage = automobileVehicleData.verifyErrMsgAM("ABCD");
		Assert.assertEquals(errorMessage, "Must be a number between 100 and 100000");
	}
	
	@Test(priority=47, groups = {"Annual_Mileage_Textbox"})
	public void speErrMsgAMTest() {
		String errorMessage = automobileVehicleData.verifyErrMsgAM("@#$%");
		Assert.assertEquals(errorMessage, "Must be a number between 100 and 100000");
	}
	
	@Test(priority=48, groups = {"Annual_Mileage_Textbox"})
	public void spaceErrMsgAMTest() {
		String errorMessage = automobileVehicleData.verifyErrMsgAM("2 2");
		Assert.assertEquals(errorMessage, "Must be a number between 100 and 100000");
	}

	@Test(priority=49, groups = {"Annual_Mileage_Textbox"})
	public void lowErrMsgAMTest() {
		String errorMessage = automobileVehicleData.verifyErrMsgAM("99");
		Assert.assertEquals(errorMessage, "Must be a number between 100 and 100000");
	}

	@Test(priority = 50, groups = {"Annual_Mileage_Textbox"})
	public void highErrMsgAMTest() {
		String errorMessage = automobileVehicleData.verifyErrMsgAM("100001");
		Assert.assertEquals(errorMessage, "Must be a number between 100 and 100000");
	}
	
	@Test(priority = 51, groups = {"Annual_Mileage_Textbox"})
	public void trueValueAMTest() {
		boolean errorMessage = automobileVehicleData.verifyEleAM("5000");
		Assert.assertFalse(errorMessage);
	}
	
	@Test(priority = 52, groups = {"Next_Button"})
	public void verifyNextButtonTest() {
		boolean nextPageDisplayed = automobileVehicleData.verifyNextButton();
		Assert.assertTrue(nextPageDisplayed);
	}

}
















