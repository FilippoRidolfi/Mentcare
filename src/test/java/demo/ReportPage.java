package demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ReportPage extends PageObject {
    public ReportPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(linkText="Show")
    private WebElement link;

    @FindBy(tagName = "h1")
    private WebElement personInfo;

    @FindBy(xpath = "//table//tbody//tr//td[2]")
    private WebElement drugName;

    public String selectedPersonInfo(){
        return personInfo.getText();
    }
    public String selectedDrugName(){
        return drugName.getText();
    }

    public void submit(){
        this.link.click();
        new RepDescriptionPage(driver);
    }

}
