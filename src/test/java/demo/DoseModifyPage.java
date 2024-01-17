package demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DoseModifyPage extends PageObject {
    public DoseModifyPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id ="dose")
    private WebElement dose;

    public void enterData(Integer dose){
        this.dose.clear();
        this.dose.sendKeys(String.valueOf(dose));
    }

    @FindBy(id = "changeDoseButton")
    private WebElement submitButton;

    public void submit(){
        this.submitButton.submit();
    }
}
