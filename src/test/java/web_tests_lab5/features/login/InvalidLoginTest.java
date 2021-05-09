package web_tests_lab5.features.login;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
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

@UseTestDataFrom("invalid_login.csv")
@RunWith(SerenityParameterizedRunner.class)
public class InvalidLoginTest {
    private String username;
    private String password;

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

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    public EndUserSteps endUserSteps;

    @Test
    public void invalid_login(){
        webdriver.manage().window().maximize();
        endUserSteps.visitHomePage();
        endUserSteps.login(this.username, this.password);

        List<WebElement> sideMenuButton = webdriver.findElements(By.id("react-burger-menu-btn"));
        endUserSteps.should_not_see_elements(sideMenuButton);

        List<WebElement> loginError = webdriver.findElements(By.xpath("//*[text()='Username and password do " +
                "not match any user in this service']"));
        endUserSteps.should_not_see_elements(loginError);
    }
}
