package demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FormularyPage extends PageObject {
    public FormularyPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id ="doseInput")
    private WebElement doseInput;

    public void enterData(Integer doseInput){
        this.doseInput.clear();
        this.doseInput.sendKeys(String.valueOf(doseInput));
    }

    @FindBy(tagName = "input")
    private WebElement submitButton;

    public void submit(){
        this.submitButton.submit();
    }
}