package com.orangehrmlive;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AdminPage {

    private WebElement addUserButton;
    private List<WebElement> listUsers;

    AdminPage(WebDriver chromeDriver) {
        listUsers = chromeDriver.findElements(By.xpath("//div[@class='oxd-table-body']//div[@class='oxd-table-card']"));
        addUserButton = chromeDriver.findElement(By.xpath("//button[text()=' Add ']"));
    }

    public void clickAddUserButton() {
        addUserButton.click();
    }

    public void checkUsers() {
        System.out.println(addUserButton.getText());
    }
}
