package demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ModifyUserPage extends PageObject {
    public ModifyUserPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name="age")
    private WebElement age;
    @FindBy(name ="weight")
    private WebElement weight;
    @FindBy(name ="height")
    private WebElement height;

    public void enterData(Integer age, Float weight, Float height){
        this.age.clear();
        this.age.sendKeys(String.valueOf(age));
        this.weight.clear();
        this.weight.sendKeys(String.valueOf(weight));
        this.height.clear();
        this.height.sendKeys(String.valueOf(height));
    }

    @FindBy(tagName = "input")
    private WebElement submitButton;

    public void submit(){
        this.submitButton.submit();
    }
}