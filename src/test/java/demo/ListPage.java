package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ListPage extends PageObject {
    public ListPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(tagName="h1")
    private WebElement message;
    @FindBy(linkText="Show")
    private WebElement link;

    @FindBy(tagName = "table")
    private WebElement table;

    public String message(){
        return message.getText();
    }

    public int tableSize(){
        return table.findElements(By.tagName("tr")).size();
    }

    public void submit(){
        this.link.click();
        new ReadPage(driver);
    }

}
