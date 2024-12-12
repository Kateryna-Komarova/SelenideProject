package com.sconto.stepDefinitions;

import com.codeborne.selenide.Selenide;
import com.sconto.pages.HomePage;
import com.sconto.pages.LoginPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class LoginSteps {

    HomePage home;
    LoginPage login;

    @And("User enters valid data")
    public void enter_valid_data() {
        login = Selenide.page(LoginPage.class);
        login.enterData();
    }

    @And("User clicks on Anmelden button")
    public void click_Anmelden_button() {
        login.clickOnAnmelden();
    }

    @And("User clicks on User icon")
    public void click_User_icon(){
        home = Selenide.page(HomePage.class);
        home.clickOnStatusLogin();
    }
    @Then("User verifies his name")
    public void verify_name(){
        login.verifyName();
    }

    @Then("User verifies Error message is displayed")
    public void verify_Error_message() {
        login.verifyErrorMessage();

    }

//    @And("User enter wrong email and valid password")
//    public void enter_wrong_email(DataTable table) {
//        login = Selenide.page(LoginPage.class);
//        login.enterWrongData(table);
//    }
}
