package StepDefinitions;

import Pages.DialogContent;
import Utilities.GWD;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MediaMarktLoginSteps {
    DialogContent dc=new DialogContent();
    @Given("MediaMarkt web uygulamasına git")
    public void mediamarktWebUygulamasınaGit() {
        GWD.getDriver().get("https://www.mediamarkt.com.tr/");
        GWD.getDriver().manage().window().maximize();
        WebElement cookiesAccept=GWD.getDriver().findElement(By.cssSelector("a[class='cookie-info-accept-button js-cookie-info-accept-button button']"));
        cookiesAccept.click();
    }

    @When("MediaMarkt hesabına giriş yap")
    public void mediamarktHesabınaGirişYap() {
        dc.findAndClick("accountIcon");
        dc.findAndClick("entry");
        dc.findAndSend("email","huseyinsever514@gmail.com");
        dc.password.sendKeys("husnu4235");
        GWD.Bekle();
        Actions action=new Actions(GWD.getDriver());
        action.moveToElement(dc.entryButton).click().build().perform();
    }

    @Then("Login olduğunu doğrula")
    public void loginOlduğunuDoğrula() {
        WebDriverWait wait=new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.urlContains("https://www.mediamarkt.com.tr/"));
        dc.findAndClick("accountIcon");
        GWD.Bekle();
        dc.verifyText("loginVerify","emre gunan");
    }
}
