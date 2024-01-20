package demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ConfirmPrescription extends PageObject {
    public ConfirmPrescription(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "doseInput")
    private WebElement doseInput;

    @FindBy(id = "spanMessage")
    private WebElement span;

    public WebElement span() {
        return span;
    }

    public String spanMessage() {
        return span.getText();
    }

    @FindBy(id = "changeDoseButton")
    private WebElement submitButton;

    public void submitOK() {
        this.submitButton.submit();
    }
}