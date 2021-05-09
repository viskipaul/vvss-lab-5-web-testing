package web_tests_lab5.pages;

import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import net.serenitybdd.core.pages.WebElementFacade;

import java.util.ArrayList;
import java.util.stream.Collectors;

import net.serenitybdd.core.annotations.findby.FindBy;

import net.thucydides.core.pages.PageObject;

import java.util.List;

@DefaultUrl("https://www.saucedemo.com/")
public class WebPage extends PageObject {

    @FindBy(id="user-name")
    private WebElementFacade usernameField;

    @FindBy(id="password")
    private WebElementFacade passwordField;

    @FindBy(id="react-burger-menu-btn")
    private WebElementFacade sideMenuButton;

    @FindBy(id="login-button")
    private WebElementFacade loginButton;

    @FindBy(id="add-to-cart-sauce-labs-bolt-t-shirt")
    private WebElementFacade addTShirtToCartButton;

    @FindBy(id="checkout")
    private WebElementFacade checkoutButton;

    @FindBy(id="last-name")
    private WebElementFacade lastNameField;

    @FindBy(id="first-name")
    private WebElementFacade firstNameField;

    @FindBy(id="postal-code")
    private WebElementFacade postalCodeField;

    @FindBy(id="continue")
    private WebElementFacade continueButton;

    @FindBy(id="finish")
    private WebElementFacade finishButton;

    @FindBy(id="back-to-products")
    private WebElementFacade backToProductsButton;

    @FindBy(id="logout_sidebar_link")
    private WebElementFacade logoutButton;

    public void fillUsername(String username) {
        usernameField.type(username);
    }

    public void fillPassword(String password){
        passwordField.type(password);
    }

    public void clickLoginButton(){
        loginButton.click();
    }

    public void completeCheckoutInfo(String firstName, String lastName, String postalCode){
        lastNameField.type(lastName);
        firstNameField.type(firstName);
        postalCodeField.type(postalCode);
    }

    public void clickAddToCart(){
        addTShirtToCartButton.click();
    }

    public void clickCheckout(){
        checkoutButton.click();
    }

    public void clickContinue(){
        continueButton.click();
    }

    public void clickFinish(){
        finishButton.click();
    }

    public void clickBackHome(){
        backToProductsButton.click();
    }

    public void clickSideMenuButton(){
        sideMenuButton.click();
    }

    public void clickLogout(){
        logoutButton.click();
    }

}