package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ReadPage extends PageObject{
    public ReadPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(tagName="h1")
    private WebElement message;
    @FindBy(id = "drug")
    private WebElement link;

    @FindBy(id = "sanityCard")
    private WebElement sanityCard;
    @FindBy(id = "firstname")
    private WebElement firstName;
    @FindBy(id = "lastname")
    private WebElement lastName;
    @FindBy(id = "description")
    private WebElement description;
    @FindBy(id = "age")
    private WebElement age;

    public String age(){
        return age.getText();
    }

    public String sanityCart(){
        return sanityCard.getText();
    }

    public boolean checkData(){
        return sanityCard.getText().isEmpty()
                && firstName.getText().isEmpty()
                && lastName.getText().isEmpty()
                && age.getText().isEmpty()
                && height.getText().isEmpty()
                && weight.getText().isEmpty()
                && description.getText().isEmpty();
    }

    @FindBy(id = "weight")
    private WebElement weight;

    public String weight(){
        return weight.getText();
    }
    @FindBy(id = "height")
    private WebElement height;

    public String height(){
        return height.getText();
    }

    @FindBy(linkText="Show the list")
    private WebElement linkShowList;

    public void submit(){
        this.link.click();
        new DrugPage(driver);
    }
}
