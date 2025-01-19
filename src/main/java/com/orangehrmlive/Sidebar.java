package com.orangehrmlive;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Sidebar {
    private WebDriver chromeDriver;
    private WebElement adminHref;

    public Sidebar(WebDriver chromeDriver) {
        adminHref = chromeDriver.findElement(By.cssSelector("aside a[href*='viewAdminModule']"));
    }

    public void clickAdminHref() {
        adminHref.click();
    }
}
