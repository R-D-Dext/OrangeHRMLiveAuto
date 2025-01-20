package com.orangehrmlive;

import io.qameta.allure.Feature;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Tests extends BaseTest {

    @Feature("Проверка входа в систему")
    @DisplayName("Проверка авторизации в системе под Admin")
    @Test
    public void authorizationTest() {
        chromeDriver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        String titleName = chromeDriver.getTitle();
        Assertions.assertEquals(titleName, "OrangeHRM");
        AuthorizationPage authorizationPage = new AuthorizationPage(chromeDriver);
        authorizationPage.authLogin("Admin", "admin123");
    }

    @Feature("Проверка переходов")
    @DisplayName("Проверка перехода на вкладку Админ")
    @Test
    public void sideBarCheck() {
        authorizationTest();
        Sidebar sidebar = new Sidebar(chromeDriver);
        sidebar.clickAdminHref();
    }

    @DisplayName("Проверка добавления нового юзера")
    @Test
    public void addUser() {
        sideBarCheck();
        AdminPage adminPage = new AdminPage(chromeDriver);
        adminPage.clickAddUserButton();
        AddUserPage addUserPage = new AddUserPage(chromeDriver);
        addUserPage.choiseAdminRole("Admin", "Enabled");
        //adminPage.checkUsers();
    }

//    @ParameterizedTest(name="{displayName} {arguments")
//    @CsvSource({"123, 321", "567, 765"})
//    public void AuthorizationTestParam(String keyWord, String result) {
//        chromeDriver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
//        String titleName = chromeDriver.getTitle();
//        Assertions.assertEquals(titleName, "OrangeHRM");
//        AuthorizationPage authorizationPage = new AuthorizationPage(chromeDriver);
//        authorizationPage.authLogin("Admin", "admin123");
//    }
}