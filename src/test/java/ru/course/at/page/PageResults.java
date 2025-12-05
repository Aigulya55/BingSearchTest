package ru.course.at.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PageResults {
    @FindBy(id = "APjFqb")
    private WebElement searchField;

    @FindBy(css = ":not(.tjvcx)>cite")
    private List<WebElement> result;

    public void clickElement(int num) {
        result.get(num).click();
    }

    public String getTextFromSearchField(){
       String val = searchField.getAttribute("value");
       System.out.println("Текст не совпал " + val);
       return val;
    }

    public  PageResults(WebDriver driver){
        PageFactory.initElements(driver, this);

    }
}
