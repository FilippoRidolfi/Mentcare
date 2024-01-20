package demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DrugPage extends PageObject {
    public DrugPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id="newDrug")
    private WebElement linkNewDrug;

    @FindBy(id="clinicFolderLink")
    private WebElement linkClinicFolder;

    @FindBy(id="actualDrug")
    private WebElement linkActualDrug;

    @FindBy(id="formulary")
    private WebElement linkFormulary;

    @FindBy(id="report")
    private WebElement linkReport;

    public void actualDrug(){
        this.linkActualDrug.click();
        new ActualDrugPage(driver);
    }

    public void formulary(){
        this.linkFormulary.click();
        new FormularyPage(driver);
    }

    public void report(){
        this.linkReport.click();
        new ReadPage(driver);
    }

    public void newDrug(){
        this.linkNewDrug.click();
        new DrugListPage(driver);
    }

    public void submitClinicFolder(){
        this.linkClinicFolder.click();
        new ReadPage(driver);
    }
}
