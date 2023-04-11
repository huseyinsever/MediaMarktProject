package StepDefinitions;

import Pages.DialogContent;
import Pages.Parent;
import Utilities.GWD;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.ht.Le;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.Key;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class MediaMarktSteps {
    DialogContent dc=new DialogContent();
    Parent pm=new Parent();

    @And("Kategorideki tüm seçenekleri doğrulayın")
    public void kategoridekiTümSeçenekleriDoğrulayın() {
        JavascriptExecutor js=(JavascriptExecutor) GWD.getDriver();
        js.executeScript("arguments[0].scrollIntoView();",dc.scrollDown);

        List<String>expectedList=new ArrayList<>();
        expectedList.add("Cep Telefonu");
        expectedList.add("Notebooklar");
        expectedList.add("Ev Aletleri");
        expectedList.add("Kişisel Bakım");
        expectedList.add("Beyaz Eşyalar");
        expectedList.add("Süpürgeler");
        expectedList.add("Televizyonlar");
        expectedList.add("Aksesuarlar");
        expectedList.add("Isıtma & Soğutma");

        for (int i = 0; i < expectedList.size(); i++) {
            Assert.assertEquals(expectedList.get(i),dc.categoriesList.get(i).getText());
        }

    }

    @And("Arama bölümüne Monitör yazıp aratın")
    public void aramaBölümüneMonitörYazıpAratın() {
        dc.findAndSend("searchInput","Monitör");
        Actions actions=new Actions(GWD.getDriver());
        actions.keyDown(Keys.ENTER).click().build().perform();
    }

    @And("Marka'dan Samsung seçin")
    public void markaDanSamsungSeçin() {
        WebDriverWait wait=new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("label[for='brand0']")));
        WebElement samsungIcon=GWD.getDriver().findElement(By.cssSelector("label[for='brand0']"));
        Actions actions=new Actions(GWD.getDriver());
        actions.moveToElement(samsungIcon).click().build().perform();
    }

    @And("Vesa Standartı olarak Evet seçin")
    public void vesaStandartıOlarakEvetSeçin() {
        WebElement vesaEvet = GWD.getDriver().findElement(By.cssSelector("div[data-value='Evet']>label"));
        JavascriptExecutor js = (JavascriptExecutor) GWD.getDriver();
        js.executeScript("arguments[0].scrollIntoView();", vesaEvet);
        GWD.Bekle();
        vesaEvet.click();
        GWD.Bekle();
    }

    @And("Çözünürlük olarak dörtK UHD seçin")
    public void çözünürlükOlarakDörtKUHDSeçin() {
        WebElement çözünürlükOrani = GWD.getDriver().findElement(By.cssSelector("div[data-value='4K UHD 3,840 x 2,160']>label"));
        JavascriptExecutor js = (JavascriptExecutor) GWD.getDriver();
        js.executeScript("arguments[0].scrollIntoView();", çözünürlükOrani);
        js.executeScript("arguments[0].click();", çözünürlükOrani);
        GWD.Bekle();
    }

    @And("Ekran boyutu olarak yirmiüç-sekiz seçin")
    public void ekranBoyutuOlarakYirmiüçSekizSeçin() {
        WebElement ekranBoyutu = GWD.getDriver().findElement(By.cssSelector("div[data-value='23.8 inç']>label"));
        JavascriptExecutor js = (JavascriptExecutor) GWD.getDriver();
        js.executeScript("arguments[0].scrollIntoView();", ekranBoyutu);
        js.executeScript("arguments[0].click();", ekranBoyutu);
        GWD.Bekle();
    }

    @And("Çıkan sonuçlardan Lenovo Siyah Monitör'e tıklayın")
    public void çıkanSonuçlardanLenovoSiyahMonitörETıklayın() {
        int scrollingPrecision=0;
        String doubleCevirilmisHali=String.valueOf(scrollingPrecision).replace(".",",");

        JavascriptExecutor js = (JavascriptExecutor) GWD.getDriver();

        String scrollElementIntoMiddle = "var viewPortHeight = Math.max(document.documentElement.clientHeight, window.innerHeight || 0);"
                + "var elementTop = arguments[0].getBoundingClientRect().top;"
                + "window.scrollBy(0, elementTop-(viewPortHeight/"+doubleCevirilmisHali+"));";

        js.executeScript(scrollElementIntoMiddle,dc.blackMonitor);
        WebElement LenovoMonitor=GWD.getDriver().findElement(By.cssSelector("p[title='Lenovo 66E5Gac3Tk L29W-30 29']"));
        LenovoMonitor.click();
    }

    @And("Sepete ekle'ye tıklayın ve  alışverişe devam edin")
    public void sepeteEkleYeTıklayınVeAlışverişeDevamEdin() throws InterruptedException {
        WebDriverWait wait=new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(30));
        int scrollingPrecision=0;
        String doubleCevirilmisHali=String.valueOf(scrollingPrecision).replace(".",",");

        JavascriptExecutor js = (JavascriptExecutor) GWD.getDriver();

        String scrollElementIntoMiddle = "var viewPortHeight = Math.max(document.documentElement.clientHeight, window.innerHeight || 0);"
                + "var elementTop = arguments[0].getBoundingClientRect().top;"
                + "window.scrollBy(0, elementTop-(viewPortHeight/"+doubleCevirilmisHali+"));";

        js.executeScript(scrollElementIntoMiddle,dc.addToCart);
        js.executeScript("arguments[0].click();",dc.addToCart);
        Thread.sleep(1500);
        dc.findAndClick("addToCart2");
        Thread.sleep(3500);
        Assert.assertTrue(dc.cartText.getText().contains("Sepetim"));
        dc.findAndClick("mediaMarktLogo");
        wait.until(ExpectedConditions.urlContains("https://www.mediamarkt.com.tr/"));
    }


    @And("Arama bölümüne Klavye yazıp aratın")
    public void aramaBölümüneKlavyeYazıpAratın() {
        dc.findAndSend("searchInput","Klavye");
        dc.findAndClick("searchClick");
    }

    @And("Marka'dan Logitech seçin")
    public void markaDanLogitechSeçin() {
        WebDriverWait wait=new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("label[for='brand0']")));
        Actions actions=new Actions(GWD.getDriver());
        actions.moveToElement(dc.logitechIcon).click().build().perform();
    }

    @And("Ürün Tipi'ni Kablosuz klavye seçin")
    public void ürünTipiNiKablosuzKlavyeSeçin() {
        JavascriptExecutor js=(JavascriptExecutor)GWD.getDriver();
        js.executeScript("arguments[0].scrollIntoView();",dc.kablosuzKlavye);
        js.executeScript("arguments[0].click();",dc.kablosuzKlavye);
        GWD.Bekle();
    }

    @And("Rating'i beş sıfır seçin")
    public void ratingIBeşSıfırSeçin() throws InterruptedException {
        JavascriptExecutor js=(JavascriptExecutor)GWD.getDriver();
        js.executeScript("arguments[0].scrollIntoView();",dc.rating);
        js.executeScript("arguments[0].click();",dc.rating);
        Thread.sleep(3500);
    }

    @And("Çıkan sonuçlardan ilk ürünü seçin")
    public void çıkanSonuçlardanIlkÜrünüSeçin() {
        JavascriptExecutor js=(JavascriptExecutor)GWD.getDriver();
        js.executeScript("arguments[0].click();",dc.blackKlavye);
    }

    @And("Sepete ekle'ye tıklayın ve sepete gidin")
    public void sepeteEkleYeTıklayınVeSepeteGidin() throws InterruptedException {
        int scrollingPrecision=0;
        String doubleCevirilmisHali=String.valueOf(scrollingPrecision).replace(".",",");

        JavascriptExecutor js = (JavascriptExecutor) GWD.getDriver();

        String scrollElementIntoMiddle = "var viewPortHeight = Math.max(document.documentElement.clientHeight, window.innerHeight || 0);"
                + "var elementTop = arguments[0].getBoundingClientRect().top;"
                + "window.scrollBy(0, elementTop-(viewPortHeight/"+doubleCevirilmisHali+"));";

        js.executeScript(scrollElementIntoMiddle,dc.addToCart);
        js.executeScript("arguments[0].click();",dc.addToCart);
        dc.findAndClick("addToCart2");
        WebDriverWait wait=new WebDriverWait(GWD.getDriver(),Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(dc.addToCartVerifyText));
        dc.findAndClick("addToCartClick");
    }

    @And("Ürünlerin geldiğini doğrulayın")
    public void ürünlerinGeldiğiniDoğrulayın() {
        dc.verifyText("lenovoProductVerify","LENOVO 66E5GAC3TK L29w-30 29\" 4ms 90Hz IPS Monitör Siyah");
        dc.verifyText("logitechProductVerify","LOGITECH MX Keys Mini Kablosuz Klavye Siyah");
    }

    @And("Özet bölümündeki tüm kalemleri doğrulayın")
    public void özetBölümündekiTümKalemleriDoğrulayın() {
        JavascriptExecutor js=(JavascriptExecutor)GWD.getDriver();
        js.executeScript("arguments[0].scrollIntoView();",dc.scrollBox);
        dc.verifyText("basketTotal","7.818,00 TL");
        dc.verifyText("cargoPrice","0,00 TL");
        dc.verifyText("grandTotal","7.818,00 TL");
    }

    @When("Bütün ürünleri silin ve sepetin boş olduğunu doğrulayın")
    public void bütünÜrünleriSilinVeSepetinBoşOlduğunuDoğrulayın() throws InterruptedException {
        JavascriptExecutor js=(JavascriptExecutor)GWD.getDriver();
        js.executeScript("arguments[0].scrollIntoView();",dc.deleteProduct2);
        js.executeScript("arguments[0].click();",dc.deleteProduct2);
        Thread.sleep(1500);

        js.executeScript("arguments[0].scrollIntoView();",dc.deleteProduct1);
        js.executeScript("arguments[0].click();",dc.deleteProduct1);
        Thread.sleep(1500);

        dc.verifyText("basketIsEmptyVerify","Sepetinizde ürün bulunmuyor");
    }

    @Then("Ana sayfaya dönün")
    public void anaSayfayaDönün() {
        JavascriptExecutor js= (JavascriptExecutor)GWD.getDriver();
        js.executeScript("window.scrollTo(document.body.scrollHeight, 0)");
        dc.findAndClick("mediaMarktLogo");
    }


    @Then("Hesabınızdan çıkış yapın ve çıktığınızı doğrulayın")
    public void hesabınızdanÇıkışYapınVeÇıktığınızıDoğrulayın() {
        WebDriverWait wait=new WebDriverWait(GWD.getDriver(),Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span[class='ms-logo__brand-name']")));

        dc.findAndClick("accountIcon");
        dc.findAndClick("logOutClick");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span[class='ms-logo__brand-name']")));
        dc.findAndClick("accountIcon");
        dc.verifyText("logOutVerify","Merhaba\n" +
                "Lütfen Giriş Yapın");

    }
}
