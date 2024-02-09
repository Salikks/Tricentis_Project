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
	
	@FindBy(xpath="//*[@id=\"insurance-form\"]/div/section[1]/div[1]/i")
	WebElement mandatorySignForMake;
	
	@FindBy(xpath="//*[@id=\"insurance-form\"]/div/section[1]/div[1]/span")
	WebElement textOfMandatorySignForMake;
	
	@FindBy(xpath="//*[@id=\"make\"]/option[1]")
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
	
	@FindBy(id="numberofseats")
	WebElement numberOfSeats;
	
	@FindBy(id="fuel")
	WebElement fuelType;

	@FindBy(id="listprice")
	WebElement listPrice;

	@FindBy(id="licenseplatenumber")
	WebElement licensePlateNumber;
	
	@FindBy(id="annualmileage")
	WebElement annualMileage;

	@FindBy(id="nextenterinsurantdata")
	WebElement nextButton;

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
		enginePerformance.sendKeys("");
		return textOfMandatorySignForEP.getText();
	}
	
	public String verifyErrMsgEP(String value) {
		enginePerformance.sendKeys(value);
		return errorMessageEP.getText();
	}
	
	public boolean verifyEleEP(String value) {
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
		dateOfManufacture.sendKeys(date);
		return invalidErrMsg.getText();
	}
	
	public boolean verifyTrueDate() {
		dateOfManufacture.sendKeys("1/1/2023");
		return invalidErrMsg.isDisplayed();
	}
}













