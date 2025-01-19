package com.orangehrmlive;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AddUserPage {
    private WebElement userRole;
    private WebElement userStatus;
    private WebElement userEmployeeName;
    private WebElement userName;
    private WebElement userPassword;
    private WebElement userConfirmPassword;
    private WebElement buttonSave;
    //private WebElement choiseRole;
    WebDriver chromeDriver;

    AddUserPage(WebDriver chromeDriver) {
        this.chromeDriver = chromeDriver;
        userRole = chromeDriver.findElement(By.xpath("//label[text()='User Role']/ancestor::div[contains(@class, 'oxd-grid-item')]//div[text()='-- Select --']"));
        userStatus = chromeDriver.findElement(By.xpath("//label[text()='Status']/ancestor::div[contains(@class, 'oxd-grid-item')]//div[text()='-- Select --']"));
        userEmployeeName = chromeDriver.findElement(By.xpath("//input[@placeholder='Type for hints...']"));
        userName = chromeDriver.findElement(By.xpath("//label[text()='Username']/ancestor::div[contains(@class, 'oxd-grid-item oxd-grid-item--gutters')]//input[@class='oxd-input oxd-input--active']"));
        userPassword = chromeDriver.findElement(By.xpath("//label[text()='Password']/ancestor::div[contains(@class, 'oxd-grid-item oxd-grid-item--gutters')]//input[@class='oxd-input oxd-input--active']"));
        userConfirmPassword = chromeDriver.findElement(By.xpath("//label[text()='Confirm Password']/ancestor::div[contains(@class, 'oxd-grid-item oxd-grid-item--gutters')]//input[@class='oxd-input oxd-input--active']"));
        buttonSave = chromeDriver.findElement(By.xpath("//button[text()=' Save ']"));
    }

    public void choiseAdminRole(String role, String status) {
        userRole.click();
        //WebElement roleOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@role='option' and normalize-space()='" + role + "']")));
        WebElement roleOption = chromeDriver.findElement(By.xpath("//div[@role='option' and normalize-space()='" + role + "']"));
        roleOption.click();
        userStatus.click();
        WebElement statusOption = chromeDriver.findElement(By.xpath("//div[@role='option' and normalize-space()='" + status + "']"));
        statusOption.click();
        userEmployeeName.sendKeys("test1  test1");
        WebElement employeeListBox = chromeDriver.findElement(By.xpath("//div[@role='listbox']//span[text()='test1  test1']"));
        employeeListBox.click();
        userName.sendKeys("DenTest");
        userPassword.sendKeys("a234567");
        userConfirmPassword.sendKeys("a234567");
        buttonSave.click();
    }
}
