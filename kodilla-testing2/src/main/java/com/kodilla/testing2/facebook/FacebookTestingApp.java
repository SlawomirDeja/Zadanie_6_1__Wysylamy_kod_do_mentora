package com.kodilla.testing2.facebook;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FacebookTestingApp {

    public static final String XPATH1 = "//*[contains(@aria-label, " +
            "\"l na wszystkie pliki cookie\") and @role=\"button\" and " +
            "@tabindex=\"0\"]";

    public static void main(String[] args) {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get("https://www.facebook.com");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath(XPATH1))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
                "//*[contains(@aria-label, \"rz nowe konto\") " +
                "and @href=\"/reg/?entry_point=login\" and @role=\"link\"]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath(XPATH1))).click();
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id=\"_r_6_\" and @type=\"text\"]")))
                .sendKeys("firstname1");
        driver.findElement(By.xpath("//*[@id=\"_r_9_\" and " +
                "@type=\"text\"]")).sendKeys("lastname1");
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id=\"_r_d_\"]"))).click();
        Actions keyDown = new Actions(driver);
        keyDown.sendKeys(Keys.chord(Keys.DOWN, Keys.DOWN, Keys.ENTER)).perform();
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id=\"_r_j_\"]"))).click();
        keyDown.sendKeys(Keys.chord(Keys.DOWN, Keys.DOWN, Keys.ENTER)).perform();
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id=\"_r_p_\"]"))).click();
        keyDown.sendKeys(Keys.chord(Keys.DOWN, Keys.DOWN, Keys.ENTER)).perform();
    }
}