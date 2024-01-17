package demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RepDescriptionPage extends PageObject {
    public RepDescriptionPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(tagName = "h1")
    private WebElement personNameAndLastname;

    @FindBy(tagName="h3")
    private WebElement drugName;
    public String selectedNameAndLastname(){
        return personNameAndLastname.getText();
    }
    public String selectedDrugName(){
        return drugName.getText();
    }
}
