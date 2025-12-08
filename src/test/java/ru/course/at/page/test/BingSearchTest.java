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
    public static final String SELENIUM = "Selenium";
    private WebDriver driver;
    private MainPage mp;
    private PageResults rp;

    @BeforeEach
    public void setUP() {
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50L));
        this.driver.get("https://www.google.com/");
        mp = new MainPage(driver);
        rp = new PageResults(driver);
    }

    @AfterEach
    public void tearDown() {
        this.driver.quit();
    }

    @Test
    public void searchResultsTest() {
        mp.sendText(SELENIUM);
        rp.clickElement(0);
        assertEquals("https://www.selenium.dev/", driver.getCurrentUrl(), "Сайт ненайден");
    }

    @Test
    public void searchFieldTest() {
        mp.sendText(SELENIUM);
        assertEquals(SELENIUM, rp.getTextFromSearchField(), "Неверное значение");
    }
}