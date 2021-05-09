package web_tests_lab5.steps.serenity;

import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import web_tests_lab5.pages.WebPage;
import net.thucydides.core.annotations.Step;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class EndUserSteps {
    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    public WebPage WebPage;

    @Step
    public void login(String username, String password){
        WebPage.fillUsername(username);
        WebPage.fillPassword(password);
        WebPage.clickLoginButton();
    }

    @Step
    public void addToCart(){
        WebPage.clickAddToCart();
    }

    @Step
    public void should_see_elements(List<WebElement> webElements){
        assertThat(webElements.size(), greaterThan(0));
    }

    @Step
    public void should_not_see_elements(List<WebElement> webElements){
        assertThat(webElements.size(), equalTo(0));
    }

    @Step
    public void visitHomePage() {
        WebPage.open();
    }

    @Step
    public void clickCheckout(){
        WebPage.clickCheckout();
    }

    @Step
    public void fillCheckoutInfo(String lastName, String firstName, String postalCode){
        WebPage.completeCheckoutInfo(firstName, lastName, postalCode);
    }

    @Step
    public void clickContinue(){
        WebPage.clickContinue();
    }

    @Step
    public void clickFinish(){
        WebPage.clickFinish();
    }

    @Step
    public void clickBackHome(){
        WebPage.clickBackHome();
    }

    @Step
    public void clickSideMenuButton(){
        WebPage.clickSideMenuButton();
    }

    @Step
    public void clickLogout(){
        WebPage.clickLogout();
    }
}