package demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ActualDrugPage extends PageObject {
    public ActualDrugPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(linkText="Modify")
    private WebElement link;

    @FindBy(xpath = "//table//tbody//tr//td[2]")
    private WebElement firstDrugName;

    @FindBy(xpath = "//table//tbody//tr//td[7]")
    private WebElement firstDrugDose;

    @FindBy(xpath = "(//table//tbody//tr)[last()]//td[2]")
    private WebElement lastDrugName;

    @FindBy(xpath = "(//table//tbody//tr)[last()]//td[7]")
    private WebElement lastDrugDose;

    public String firstDrugName(){
        return firstDrugName.getText();
    }
    public String firstDrugDose(){
        return firstDrugDose.getText();
    }
    public String lastDrugName(){
        return lastDrugName.getText();
    }
    public String lastDrugDose(){
        return lastDrugDose.getText();
    }
    public void submit(){
        this.link.click();
        new DoseModifyPage(driver);
    }

}
