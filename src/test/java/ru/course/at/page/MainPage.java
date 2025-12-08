package ru.course.at.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    @FindBy(css = "textarea[class='gLFyf']")
    private WebElement searchField;

    public void sendText(String text) {
        searchField.sendKeys(text);
        searchField.submit();
        System.out.println("Введе текст: " + text);
    }

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}