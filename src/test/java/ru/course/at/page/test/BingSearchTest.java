package ru.course.at.page.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.course.at.page.MainPage;
import ru.course.at.page.PageResults;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BingSearchTest {
    private WebDriver driver;

    @BeforeEach
    public void setUP() {
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50L));
        this.driver.get("https://www.google.com/");
    }

    @AfterEach
    public void tearDown() {
        this.driver.quit();
    }

    @Test
    public void searchResultsTest() {
        String input = "Selenium";
        MainPage mp = new MainPage(driver);
        mp.sendText(input);

        PageResults rp = new PageResults(driver);
        rp.clickElement(0);

        assertEquals("https://www.selenium.dev/", driver.getCurrentUrl(), "Сайт ненайден");
    }

    @Test
    public void searchFieldTest() {
        String input = "Selenium";
        MainPage mp = new MainPage(driver);
        mp.sendText(input);

        PageResults rp = new PageResults(driver);
        assertEquals(input,rp.getTextFromSearchField(), "Неверное значение");
    }
}


