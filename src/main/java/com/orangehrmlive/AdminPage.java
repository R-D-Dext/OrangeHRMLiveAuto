package com.orangehrmlive;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Optional;

public class AdminPage {

    private WebDriver chromeDriver;
    private WebElement addUserButton;
    private List<WebElement> listUsers;

    AdminPage(WebDriver chromeDriver) {
        this.chromeDriver = chromeDriver;
        listUsers = chromeDriver.findElements(By.xpath("//div[@class='oxd-table-body']//div[@class='oxd-table-card']"));
        addUserButton = chromeDriver.findElement(By.xpath("//button[text()=' Add ']"));
    }

    public void clickAddUserButton() {
        addUserButton.click();
    }

    public void checkAnddeleteUserByName() {
        String targetUsername = "DenTest";
        List<WebElement> listUsers = chromeDriver.findElements(By.xpath("//div[@class='oxd-table-body']//div[@class='oxd-table-card']"));
        for(WebElement user: listUsers) {
            if(user.getText().contains(targetUsername)) {
                WebElement deleteButton = user.findElement(By.xpath(".//i[@class='oxd-icon bi-trash']/ancestor::button[@class='oxd-icon-button oxd-table-cell-action-space']"));
                deleteButton.click();
            }
        }
        WebElement yesDelete = chromeDriver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--label-danger orangehrm-button-margin']"));
        yesDelete.click();
    }
}
