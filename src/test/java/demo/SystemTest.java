package demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.*;

public class SystemTest extends BaseTest{

    @org.junit.Test
    public void modifyUserInformation() {

        System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver-v0.33.0-win64/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();

        ListPage listPage = new ListPage(driver);
        ReadPage readPage = new ReadPage(driver);
        DrugPage drugPage = new DrugPage(driver);
        ModifyUserPage muPage = new ModifyUserPage(driver);

        driver.get("http://localhost:8080/");

        listPage.submit();

        assertFalse("Patient information is correct insert", readPage.checkData());

        readPage.submit();

        drugPage.submitUserModify();

        muPage.enterData(25, (float)50.20, (float)40.30);

        muPage.submit();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.urlContains("drugs"));

        drugPage.submitClinicFolder();

        assertFalse("Patient information is correct insert", readPage.checkData());
        assertEquals("Patient age message expected", "Age: 25", readPage.age());
        assertEquals("Patient weight message expected", "Weight: 50.2", readPage.weight());
        assertEquals("Patient height message expected", "Height: 40.3", readPage.height());
    }

    @org.junit.Test
    public void actualDrugDoseModify() {

        System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver-v0.33.0-win64/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();

        ListPage listPage = new ListPage(driver);
        ReadPage readPage = new ReadPage(driver);
        DrugPage drugPage = new DrugPage(driver);
        ActualDrugPage drugActual = new ActualDrugPage(driver);
        DoseModifyPage doseModifyPage = new DoseModifyPage(driver);

        driver.get("http://localhost:8080/");

        listPage.submit();

        readPage.submit();

        drugPage.actualDrug();

        String drugNameModify = drugActual.firstDrugName();

        drugActual.submit();

        Integer changeDose = 5;

        doseModifyPage.enterData(changeDose);

        doseModifyPage.submit();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.urlContains("actualDrugs"));

        assertEquals("Correct drug", drugNameModify, drugActual.lastDrugName());
        assertEquals("Dose change correctly", changeDose.toString(), drugActual.lastDrugDose());
    }

    @org.junit.Test
    public void newDrugTest() {

        System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver-v0.33.0-win64/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();

        ListPage listPage = new ListPage(driver);
        ReadPage readPage = new ReadPage(driver);
        DrugPage drugPage = new DrugPage(driver);
        DrugListPage drugListPage = new DrugListPage(driver);
        DrugsInfoPage drugsInfoPage = new DrugsInfoPage(driver);
        ActualDrugPage drugActual = new ActualDrugPage(driver);

        driver.get("http://localhost:8080/");

        listPage.submit();

        readPage.submit();

        drugPage.newDrug();

        drugListPage.submit();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.urlContains("drugsInfo"));

        Integer changeDose = 7;
        drugsInfoPage.enterData(changeDose);

        drugsInfoPage.submit();

        wait.until(ExpectedConditions.urlContains("actualDrugs"));

        assertEquals("Dose change correctly", changeDose.toString(), drugActual.lastDrugDose());
    }

    @org.junit.Test
    public void formularyTest() {

        System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver-v0.33.0-win64/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();

        ListPage listPage = new ListPage(driver);
        ReadPage readPage = new ReadPage(driver);
        DrugPage drugPage = new DrugPage(driver);
        FormularyPage formularyPage = new FormularyPage(driver);
        DrugsInfoPage drugsInfoPage = new DrugsInfoPage(driver);
        ActualDrugPage drugActual = new ActualDrugPage(driver);

        driver.get("http://localhost:8080/");

        listPage.submit();

        readPage.submit();

        drugPage.formulary();

        formularyPage.submit();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.urlContains("drugsInfo"));

        Integer changeDose = 3;
        drugsInfoPage.enterData(changeDose);

        drugsInfoPage.submit();

        wait.until(ExpectedConditions.urlContains("actualDrugs"));

        assertEquals("Dose change correctly", changeDose.toString(), drugActual.lastDrugDose());
    }

    @org.junit.Test
    public void reportTest() {

        System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver-v0.33.0-win64/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();

        ListPage listPage = new ListPage(driver);
        ReadPage readPage = new ReadPage(driver);
        DrugPage drugPage = new DrugPage(driver);
        ReportPage reportPage = new ReportPage(driver);
        RepDescriptionPage repDescriptionPage = new RepDescriptionPage(driver);

        driver.get("http://localhost:8080/");

        listPage.submit();

        readPage.submit();

        drugPage.report();

        String drugNameFirst = reportPage.selectedDrugName();
        String personInfo = reportPage.selectedPersonInfo();
        reportPage.submit();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.urlContains("reportDescription"));

        String nameAndLastname = repDescriptionPage.selectedNameAndLastname();
        String drugName = repDescriptionPage.selectedDrugName();

        assertEquals("Correct result person information", personInfo, nameAndLastname);
        assertEquals("Correct result drugname", "Report about " + drugNameFirst, drugName);
    }
}
