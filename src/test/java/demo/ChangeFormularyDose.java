package demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChangeFormularyDose extends PageObject {
    public ChangeFormularyDose(WebDriver driver) {
        super(driver);
    }

    @FindBy(id ="doseInput")
    private WebElement doseInput;

    public void enterData(Integer doseInput){
        this.doseInput.clear();
        this.doseInput.sendKeys(String.valueOf(doseInput));
    }

    @FindBy(id="spanMessage")
    private WebElement span;

    public WebElement span(){
        return span;
    }

    public String spanMessage(){
        return span.getText();
    }

    @FindBy(tagName = "input")
    private WebElement submitButton;

    public void submit(){
        this.submitButton.submit();
    }
}
