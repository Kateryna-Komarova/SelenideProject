package com.sconto.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Map;

import static com.codeborne.selenide.Condition.or;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {


    @FindBy(css = ".existingAccount__headline")
    WebElement loginTitle;

    public SelenideElement verifyLoginTitle() {
        return $(loginTitle).shouldHave(text("Anmelden"));
    }

    @FindBy(id = "loginEmail")
    WebElement emailField;
    @FindBy(id = "loginPassword")
    WebElement passwordField;

    public LoginPage enterData(String email, String password) {
        $(emailField).val(email);
        $(passwordField).val(password);
        return Selenide.page(this);
    }

    @FindBy(id = "login-submit")
    WebElement loginButton;

    public HomePage clickOnAnmelden() {
        $(loginButton).click();
        return Selenide.page(HomePage.class);
    }

    @FindBy(id = "loginEmail-error")
    WebElement errorMessage;

    public LoginPage verifyErrorMessage() {
        $(errorMessage).shouldBe(
                or("Bitte geben Sie eine gültige E-Mail-Adresse ein",
                        text("Bitte geben Sie eine gültige E-Mail-Adresse ein"),
                        text("Benutzername nicht gefunden oder Passwort falsch.")

                )
        );
        return Selenide.page(LoginPage.class);
    }

    public LoginPage enterWrongData(DataTable table) {
        List<Map<String, String>> dataTable = table.asMaps();
        String email = dataTable.get(0).get("email");
        String password = dataTable.get(0).get("password");
        enterData(email, password);
        return Selenide.page(LoginPage.class);
    }
}
