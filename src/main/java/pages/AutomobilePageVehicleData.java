package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import base.TestBase;
import utility.TestUtil;

public class AutomobilePageVehicleData extends TestBase{

	// Page Factory - OR:
	@FindBy(id="nav_automobile")
	public WebElement automobileLink;
	
	@FindBy(id="selectedinsurance")
	WebElement selectedInsurance;
	
	@FindBy(xpath="//*[@id=\"insurance-form\"]//i")
	WebElement mandatorySignForMake;
	
	@FindBy(xpath="//*[@id=\"insurance-form\"]//span")
	WebElement textOfMandatorySignForMake;
	
	@FindBy(xpath="//*[@id=\"make\"]/option")
	WebElement defaultMakeValue;
	
	@FindBy(id="entervehicledata")
	public WebElement enterVehicleDataTab;
	
	@FindBy(id="make")
	WebElement makeDropdown;
	
	@FindBy(xpath="//*[@id=\"insurance-form\"]/div/section[1]/div[2]/i")
	WebElement mandatorySignForEP;
	
	@FindBy(xpath="//*[@id=\"insurance-form\"]/div/section[1]/div[2]/span") 
	WebElement textOfMandatorySignForEP;
	
	@FindBy(xpath="//*[@id=\"insurance-form\"]/div/section[1]/div[2]/span")
	WebElement errorMessageEP;
	
	@FindBy(id="engineperformance")
	WebElement enginePerformance;
	
	@FindBy(id="dateofmanufacture")
	WebElement dateOfManufacture;
	
	@FindBy(xpath="//*[@id=\"insurance-form\"]/div/section[1]/div[3]/i")
	WebElement mandatorySignForDoM;
	
	@FindBy(xpath="//*[@id=\"insurance-form\"]/div/section[1]/div[3]/span")
	WebElement textOfMandatorySignForDoM;
	
	@FindBy(className="ui-datepicker-trigger")
	WebElement datePicker;
	
	@FindBy(xpath="//*[@id=\"ui-datepicker-div\"]/div/a[2]")
	WebElement forwardDate;
	
	@FindBy(xpath="//*[@id=\"ui-datepicker-div\"]/div/a[1]")
	WebElement prevDate;
	
	@FindBy(xpath="//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[1]/td[6]/a")
	WebElement futDate;
	
	@FindBy(xpath="//*[@id=\"insurance-form\"]/div/section[1]/div[3]/span")
	WebElement futureErrMsg;
	
	@FindBy(xpath="//*[@id=\"insurance-form\"]/div/section[1]/div[3]/span")
	WebElement invalidErrMsg;
	
	@FindBy(className="ui-datepicker-month")
	WebElement curMonth;
	
	@FindBy(xpath="//*[@id=\"insurance-form\"]/div/section[1]/div[4]/i")
	WebElement mandatorySignForNoS;

	@FindBy(xpath="//*[@id=\"insurance-form\"]/div/section[1]/div[4]/span")
	WebElement textOfMandatorySignForNoS;

	@FindBy(id="numberofseats")
	WebElement NoSDropDown;
	
	@FindBy(id="fuel")
	WebElement FTDropDown;
	
	@FindBy(xpath="//*[@id=\"insurance-form\"]/div/section[1]/div[5]/i")
	WebElement mandatorySignForFT;

	@FindBy(xpath="//*[@id=\"insurance-form\"]/div/section[1]/div[5]/span")
	WebElement textOfMandatorySignForFT;
	
	@FindBy(xpath="//*[@id=\"insurance-form\"]/div/section[1]/div[6]/i")
	WebElement mandatorySignForLP;
	
	@FindBy(xpath="//*[@id=\"insurance-form\"]/div/section[1]/div[6]/span") 
	WebElement textOfMandatorySignForLP;
	
	@FindBy(xpath="//*[@id=\"insurance-form\"]/div/section[1]/div[6]/span")
	WebElement errorMessageLP;
	
	@FindBy(id="listprice")
	WebElement listPrice;
	
	@FindBy(xpath="//*[@id=\"insurance-form\"]/div/section[1]/div[7]/span")
	WebElement ErrMsgLicPN;

	@FindBy(id="licenseplatenumber")
	WebElement licensePlateNumber;
	
	@FindBy(xpath="//*[@id=\"insurance-form\"]/div/section[1]/div[8]/i")
	WebElement mandatorySignForAM;
	
	@FindBy(xpath="//*[@id=\"insurance-form\"]/div/section[1]/div[8]/span") 
	WebElement textOfMandatorySignForAM;
	
	@FindBy(xpath="//*[@id=\"insurance-form\"]/div/section[1]/div[8]/span")
	WebElement errorMessageAM;

	@FindBy(id="annualmileage")
	WebElement annualMileage;

	@FindBy(id="nextenterinsurantdata")
	WebElement nextButton;
	
	@FindBy(id="firstname")
	WebElement firstName;

	// Initializing Page Objects:
	public AutomobilePageVehicleData() {
		PageFactory.initElements(driver, this);
	}
	
	// Actions:
	public String verifyAutomobileLink() {
		automobileLink.click();
		TestUtil.waits(500);
		return selectedInsurance.getText();
	}
	
	public boolean verifyManSignMake() {
		return mandatorySignForMake.isDisplayed();
	}
	
	public String verifyHovErrMsgMake() {
		enterVehicleDataTab.click();
		TestUtil.hoverOverElement(mandatorySignForMake);
		return textOfMandatorySignForMake.getText();
	}
	
	public boolean verifyDropdownMake() {
		makeDropdown.click();
		return defaultMakeValue.isDisplayed();
	}
	
	public String verifyManMsgMake() {
		makeDropdown.click();
		Select dropdown = new Select(makeDropdown);
		dropdown.selectByVisibleText("– please select –");
		return textOfMandatorySignForMake.getText();
	}

	public String verifyListMake(String dropdownValue) {
		makeDropdown.click();
		Select dropdown = new Select(makeDropdown);
		dropdown.selectByVisibleText(dropdownValue);
		WebElement selectedOption =  dropdown.getFirstSelectedOption();
		String selectedText = selectedOption.getText();
		return selectedText;
	}
	
	public boolean verifyManSignEP() {
		return mandatorySignForEP.isDisplayed();
	}
	
	public String verifyHovErrMsgEP() {
		TestUtil.hoverOverElement(mandatorySignForEP);
		return textOfMandatorySignForEP.getText();
	}
	
	public String verifyManMsgEP() {
		enginePerformance.clear();
		enginePerformance.sendKeys("");
		return textOfMandatorySignForEP.getText();
	}
	
	public String verifyErrMsgEP(String value) {
		enginePerformance.clear();
		enginePerformance.sendKeys(value);
		return errorMessageEP.getText();
	}
	
	public boolean verifyEleEP(String value) {
		enginePerformance.clear();
		enginePerformance.sendKeys(value);
		return errorMessageEP.isDisplayed();
	}
	
	public String verifyHovErrMsgDoM() {
		TestUtil.hoverOverElement(mandatorySignForDoM);
		return textOfMandatorySignForDoM.getText();
	}
	
	public boolean verifyDatePicker() {
		return datePicker.isDisplayed();
	}
		
	public String verifyCurMonth() {
		datePicker.click();
		return curMonth.getText();
	}
	
	public boolean verifyFwdPrevButton() {
		datePicker.click();
		prevDate.click();
		boolean prevMonth =  curMonth.getText().equals(TestUtil.prevMonth());
		forwardDate.click();
		forwardDate.click();
		boolean nextMonth =  curMonth.getText().equals(TestUtil.nextMonth());
		return (nextMonth && prevMonth);
	}

	public String verifyFutureErrMsg() {
		datePicker.click();
		forwardDate.click();
		futDate.click();
		return futureErrMsg.getText();
	}

	public String verifyInvalidErrMsg(String date) {
		dateOfManufacture.clear();
		dateOfManufacture.sendKeys(date);
		return invalidErrMsg.getText();
	}
	
	public boolean verifyTrueDate() {
		dateOfManufacture.clear();
		dateOfManufacture.sendKeys("1/1/2023");
		return invalidErrMsg.isDisplayed();
	}
	
	public boolean verifyManSignNoS() {
		return mandatorySignForNoS.isDisplayed();
	}
	
	public String verifyHovErrMsgNoS() {
		TestUtil.hoverOverElement(mandatorySignForNoS);
		return textOfMandatorySignForNoS.getText();
	}
	
	public String verifyManMsgNoS() {
		NoSDropDown.click();
		Select dropdown = new Select(NoSDropDown);
		dropdown.selectByVisibleText("– please select –");
		return textOfMandatorySignForNoS.getText();
	}
	
	public String verifyListNoS(String dropdownValue) {
		NoSDropDown.click();
		Select dropdown = new Select(NoSDropDown);
		dropdown.selectByVisibleText(dropdownValue);
		WebElement selectedOption =  dropdown.getFirstSelectedOption();
		String selectedText = selectedOption.getText();
		return selectedText;
	}

	public boolean verifyDropdownNoS() {
		NoSDropDown.click();
		Select dropdown = new Select(NoSDropDown);
		dropdown.selectByVisibleText("1");
		return textOfMandatorySignForNoS.isDisplayed();
	}
	
	public boolean verifyManSignFT() {
		return mandatorySignForFT.isDisplayed();
	}
	
	public String verifyHovErrMsgFT() {
		TestUtil.hoverOverElement(mandatorySignForFT);
		return textOfMandatorySignForFT.getText();
	}
	
	public String verifyManMsgFT() {
		FTDropDown.click();
		Select dropdown = new Select(FTDropDown);
		dropdown.selectByVisibleText("– please select –");
		return textOfMandatorySignForFT.getText();
	}
	
	public String verifyListFT(String dropdownValue) {
		FTDropDown.click();
		Select dropdown = new Select(FTDropDown);
		dropdown.selectByVisibleText(dropdownValue);
		WebElement selectedOption =  dropdown.getFirstSelectedOption();
		String selectedText = selectedOption.getText();
		return selectedText;
	}

	public boolean verifyDropdownFT() {
		FTDropDown.click();
		Select dropdown = new Select(FTDropDown);
		dropdown.selectByVisibleText("Petrol");
		return textOfMandatorySignForFT.isDisplayed();
	}

	public boolean verifyManSignLP() {
		return mandatorySignForLP.isDisplayed();
	}
	
	public String verifyHovErrMsgLP() {
		TestUtil.hoverOverElement(mandatorySignForLP);
		return textOfMandatorySignForLP.getText();
	}
	
	public String verifyManMsgLP() {
		listPrice.clear();
		listPrice.sendKeys("");
		return textOfMandatorySignForLP.getText();
	}
	
	public String verifyErrMsgLP(String value) {
		listPrice.clear();
		listPrice.sendKeys(value);
		return errorMessageLP.getText();
	}
	
	public boolean verifyEleLP(String value) {
		listPrice.clear();
		listPrice.sendKeys(value);
		return errorMessageLP.isDisplayed();
	}
	
	public String verifyErrMsgLicPN() {
		licensePlateNumber.clear();
		licensePlateNumber.sendKeys("00112233445566");
		return ErrMsgLicPN.getText();
	}
	
	public boolean verifytrueValueLicPN() {
		licensePlateNumber.clear();
		licensePlateNumber.sendKeys("001122");
		return ErrMsgLicPN.isDisplayed();
	}
	
	public boolean verifyManSignAM() {
		return mandatorySignForAM.isDisplayed();
	}
	
	public String verifyHovErrMsgAM() {
		TestUtil.hoverOverElement(mandatorySignForAM);
		return textOfMandatorySignForAM.getText();
	}
	
	public String verifyManMsgAM() {
		annualMileage.clear();
		annualMileage.sendKeys("");
		return textOfMandatorySignForAM.getText();
	}
	
	public String verifyErrMsgAM(String value) {
		annualMileage.clear();
		annualMileage.sendKeys(value);
		return errorMessageAM.getText();
	}
	
	public boolean verifyEleAM(String value) {
		annualMileage.clear();
		annualMileage.sendKeys(value);
		return errorMessageAM.isDisplayed();
	}
	
	public boolean verifyNextButton() {
		nextButton.click();
		return firstName.isDisplayed();
	}
}













