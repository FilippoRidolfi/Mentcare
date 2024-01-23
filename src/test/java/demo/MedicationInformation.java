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

    @FindBy(id = "name")
    private WebElement name;
    @FindBy(id = "atc")
    private WebElement atc;
    @FindBy(id = "company")
    private WebElement company;
    @FindBy(id = "type")
    private WebElement type;
    @FindBy(id = "description")
    private WebElement description;
    @FindBy(id = "maxDose")
    private WebElement maxDose;
    @FindBy(id = "minDose")
    private WebElement minDose;

    public boolean checkMedicationInformation(){
        return name.getText().isEmpty() &&
                atc.getText().isEmpty() &&
                company.getText().isEmpty() &&
                type.getText().isEmpty() &&
                description.getText().isEmpty() &&
                maxDose.getText().isEmpty() &&
                minDose.getText().isEmpty();
    }

    public void submit(){
        this.submitButton.submit();
    }
}