package com.orangehrmlive;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AuthorizationPage {

    private WebDriver chromeDriver;
    private WebElement userNameField;
    private WebElement passwordField;
    private WebElement loginButton;

    AuthorizationPage(WebDriver chromeDriver) {
        userNameField = chromeDriver.findElement(By.xpath("//input[@name='username']"));
        passwordField = chromeDriver.findElement(By.xpath("//input[@name='password']"));
        loginButton = chromeDriver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']"));
    }

    public void authLogin(String login, String password) {
        userNameField.sendKeys(login);
        passwordField.sendKeys(password);
        loginButton.click();
    }
}