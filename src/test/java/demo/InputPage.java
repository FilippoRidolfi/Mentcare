package demo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;

public class InputPage extends PageObject {

    public InputPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(tagName="h1")
    private WebElement message;

    @FindBy(name="firstname")
    private WebElement firstName;
    @FindBy(name ="lastname")
    private WebElement lastName;

    @FindBy(tagName = "input")
    private WebElement submitButton;

    public void enterName(String firstName, String lastName){
        this.firstName.clear();
        this.firstName.sendKeys(firstName);
        this.lastName.clear();
        this.lastName.sendKeys(lastName);
    }

    public String message(){
        return message.getText();
    }

    public void submit(){
        this.submitButton.submit();
    }
}
