package demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MedicationInformation extends PageObject {
    public MedicationInformation (WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "changeDoseButton")
    private WebElement submitButton;

    public void submit(){
        this.submitButton.submit();
    }
}