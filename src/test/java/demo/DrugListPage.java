package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class DrugListPage extends PageObject {
    public DrugListPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(tagName = "input")
    private WebElement submitButton;

    public void submit(){
        this.submitButton.submit();
        new DrugsInfoPage(driver);
    }
}
