package demo;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.*;

public class SystemTest extends BaseTest{

    @Test
    public void firstCheckUserInformation(){
        System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver-v0.33.0-win64/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();

        ReadPage readPage = new ReadPage(driver);

        driver.get("http://localhost:8080/");

        assertFalse("Patient information is correct insert", readPage.checkData());
    }

    @Test
    public void modifyUserInformation() {

        System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver-v0.33.0-win64/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();

        ReadPage readPage = new ReadPage(driver);
        ModifyUserPage muPage = new ModifyUserPage(driver);

        driver.get("http://localhost:8080/");

        readPage.submitUserModify();

        muPage.enterData(25, (float)80.21, (float)1.85);

        muPage.submit();

        driver.switchTo().alert().accept();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.urlContains("read"));

        assertFalse("Patient information is correct insert", readPage.checkData());
        assertEquals("Patient age message expected", "Age: 25", readPage.age());
        assertEquals("Patient weight message expected", "Weight: 80.21 in kg", readPage.weight());
        assertEquals("Patient height message expected", "Height: 1.85 in cm", readPage.height());
    }

    @Test
    public void modifyUserDismissInformation() {

        System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver-v0.33.0-win64/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();

        ReadPage readPage = new ReadPage(driver);
        ModifyUserPage muPage = new ModifyUserPage(driver);

        driver.get("http://localhost:8080/");

        assertFalse("Patient information is correct insert", readPage.checkData());

        String previousAge = readPage.age();
        String previousWeight = readPage.weight();
        String previousHeight = readPage.height();

        readPage.submitUserModify();

        muPage.enterData(25, (float)80.21, (float)1.85);

        muPage.submit();

        driver.switchTo().alert().dismiss();

        muPage.backClinicFolder();

        assertFalse("Patient information is correct insert", readPage.checkData());
        assertEquals("The age correctly remained the same", readPage.age(), previousAge);
        assertEquals("The weight correctly remained the same", readPage.weight(), previousWeight);
        assertEquals("The height correctly remained the same", readPage.height(), previousHeight);
    }

    @Test
    public void actualDrugDoseModify() {

        System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver-v0.33.0-win64/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();

        ReadPage readPage = new ReadPage(driver);
        DrugPage drugPage = new DrugPage(driver);
        ActualDrugPage drugActual = new ActualDrugPage(driver);
        DoseModifyPage doseModifyPage = new DoseModifyPage(driver);

        driver.get("http://localhost:8080/");

        readPage.submit();

        drugPage.actualDrug();

        String drugNameModify = drugActual.firstDrugName();

        drugActual.submit();

        int changeDose = 4;

        doseModifyPage.enterData(changeDose);

        doseModifyPage.submit();

        driver.switchTo().alert().dismiss();

        changeDose = 3;

        doseModifyPage.enterData(changeDose);

        doseModifyPage.submit();

        driver.switchTo().alert().accept();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.urlContains("actualDrugs"));

        assertEquals("Correct drug", drugNameModify, drugActual.lastDrugName());
        assertEquals("Dose change correctly", Integer.toString(changeDose), drugActual.lastDrugDose());
    }

    @Test
    public void newDrugTest() {

        System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver-v0.33.0-win64/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();

        ReadPage readPage = new ReadPage(driver);
        DrugPage drugPage = new DrugPage(driver);
        DrugListPage drugListPage = new DrugListPage(driver);
        DrugsInfoPage drugsInfoPage = new DrugsInfoPage(driver);
        ActualDrugPage drugActual = new ActualDrugPage(driver);

        driver.get("http://localhost:8080/");

        readPage.submit();

        drugPage.newDrug();

        drugListPage.submit();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.urlContains("drugsInfo"));

        int changeDose = 17;
        drugsInfoPage.enterData(changeDose);

        drugsInfoPage.submit();

        wait.until(ExpectedConditions.textToBePresentInElement(drugsInfoPage.span(), "Dose is outside the safe range. Is too high"));

        assertEquals("Message send correctly", "Dose is outside the safe range. Is too high", drugsInfoPage.spanMessage());

        changeDose = 3;
        drugsInfoPage.enterData(changeDose);

        drugsInfoPage.submit();

        driver.switchTo().alert().accept();

        wait.until(ExpectedConditions.urlContains("actualDrugs"));

        assertEquals("Dose change correctly", Integer.toString(changeDose), drugActual.lastDrugDose());
    }

    @Test
    public void formularyTest() {

        System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver-v0.33.0-win64/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();

        ReadPage readPage = new ReadPage(driver);
        DrugPage drugPage = new DrugPage(driver);
        FormularyPage formularyPage = new FormularyPage(driver);
        ActualDrugPage actualDrugPage = new ActualDrugPage(driver);
        MedicationInformation medInfo = new MedicationInformation(driver);
        ChangeFormularyDose changeFormularyDose = new ChangeFormularyDose(driver);
        ConfirmPrescription confirmPrescription = new ConfirmPrescription(driver);

        driver.get("http://localhost:8080/");

        readPage.submit();

        drugPage.formulary();

        formularyPage.submit();

        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.urlContains("medicationVerify"));

        medInfo.submit();

        wait.until(ExpectedConditions.urlContains("changeFormularyDose"));

        Integer changeDose = 3;
        changeFormularyDose.enterData(changeDose);

        changeFormularyDose.submit();

        driver.switchTo().alert().accept();

        wait.until(ExpectedConditions.urlContains("confirmPrescription"));

        confirmPrescription.submitOK();

        wait.until(ExpectedConditions.urlContains("actualDrugs"));

        assertEquals("Dose change correctly", changeDose.toString(), actualDrugPage.lastDrugDose());
    }

    @Test
    public void formularyTestRefuseDrugChange() {

        System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver-v0.33.0-win64/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();

        ReadPage readPage = new ReadPage(driver);
        DrugPage drugPage = new DrugPage(driver);
        FormularyPage formularyPage = new FormularyPage(driver);
        MedicationInformation medInfo = new MedicationInformation(driver);
        ChangeFormularyDose changeFormularyDose = new ChangeFormularyDose(driver);

        driver.get("http://localhost:8080/");

        readPage.submit();

        drugPage.formulary();

        formularyPage.submit();

        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.urlContains("medicationVerify"));

        medInfo.submit();

        wait.until(ExpectedConditions.urlContains("changeFormularyDose"));

        Integer changeDose = 3;
        changeFormularyDose.enterData(changeDose);

        changeFormularyDose.submit();

        driver.switchTo().alert().dismiss();

        wait.until(ExpectedConditions.urlContains("changeFormularyDose"));
    }

    @Test
    public void reportTest() {

        System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver-v0.33.0-win64/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();

        ReadPage readPage = new ReadPage(driver);
        DrugPage drugPage = new DrugPage(driver);
        ReportPage reportPage = new ReportPage(driver);
        RepDescriptionPage repDescriptionPage = new RepDescriptionPage(driver);

        driver.get("http://localhost:8080/");

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
