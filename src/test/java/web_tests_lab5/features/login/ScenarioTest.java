package web_tests_lab5.features.login;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;

import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import web_tests_lab5.steps.serenity.EndUserSteps;

import java.util.List;

@UseTestDataFrom("valid_login.csv")
@RunWith(SerenityParameterizedRunner.class)
public class ScenarioTest {
    private String username;
    private String password;
    private String lastName;
    private String firstName;
    private String postalCode;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    public EndUserSteps endUserSteps;

    @Test
    public void buy_scenario(){
        webdriver.manage().window().maximize();
        endUserSteps.visitHomePage();

        endUserSteps.login(this.username, this.password);
        List<WebElement> sideMenuButton = webdriver.findElements(By.id("react-burger-menu-btn"));
        endUserSteps.should_see_elements(sideMenuButton);

        endUserSteps.addToCart();
        List<WebElement> removeButton = webdriver.findElements(By.id("remove-sauce-labs-bolt-t-shirt"));
        endUserSteps.should_see_elements(removeButton);

        WebElement addToCartButton = webdriver.findElement(By.className("shopping_cart_badge"));
        addToCartButton.click();

        List<WebElement> yourCartText = webdriver.findElements(By.xpath("//*[text()='Your Cart']"));
        endUserSteps.should_see_elements(yourCartText);

        endUserSteps.clickCheckout();
        List<WebElement> checkoutInformationText = webdriver.findElements(By.xpath("//*[text()='Checkout: " +
                "Your Information']"));
        endUserSteps.should_see_elements(checkoutInformationText);

        endUserSteps.fillCheckoutInfo(lastName, firstName, postalCode);
        endUserSteps.clickContinue();
        List<WebElement> checkoutOverviewText = webdriver.findElements(By.xpath("//*[text()='Checkout: Overview']"));
        endUserSteps.should_see_elements(checkoutOverviewText);

        endUserSteps.clickFinish();
        List<WebElement> checkoutCompleteText = webdriver.findElements(By.xpath("//*[text()='Checkout: Complete!']"));
        endUserSteps.should_see_elements(checkoutCompleteText);

        endUserSteps.clickBackHome();
        endUserSteps.clickSideMenuButton();
        endUserSteps.clickLogout();

        List<WebElement> usernameInput = webdriver.findElements(By.id("user-name"));
        endUserSteps.should_see_elements(usernameInput);
        List<WebElement> loginButton = webdriver.findElements(By.id("login-button"));
        endUserSteps.should_see_elements(loginButton);
    }
}
