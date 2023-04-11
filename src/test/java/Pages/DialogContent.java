package Pages;

import Utilities.GWD;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.text.BreakIterator;
import java.util.List;

public class DialogContent extends Parent {
    public DialogContent() {
        PageFactory.initElements(GWD.getDriver(),this);
    }

    @FindBy(css = "button[data-identifier='MyProfile-button']")
    private WebElement accountIcon;

    @FindBy(css = "a[data-tracking='LOGON']")
    private WebElement entry;

    @FindBy(css = "input[name='logonId']")
    private WebElement email;

    @FindBy(css = "input[name='password']")
    public WebElement password;

    @FindBy(xpath = "(//span[text()='Giriş'])[2]")
    public WebElement entryButton;

    @FindBy(css = "b[data-identifier='myprofile_salutation_line2']")
    private WebElement loginVerify;

    @FindBy(css = "ul[style='height:36px; line-height:36px;']")
    public WebElement scrollDown;

    @FindBy(css = "ul[class='mmse-ga mmse-ga-click-par']>li")
    public List<WebElement> categoriesList;

    @FindBy(css = "input[class='ms-textfield ms-textfield--search ms-autosugestions__search-input']")
    private WebElement searchInput;

    @FindBy(xpath = "(//a[@data-gtm-event-ext='product1222418'])[2]//img")
    public WebElement blackMonitor;

    @FindBy(xpath = "(//div[@class='button-green-pdp'])[2]")
    public WebElement addToCart;

    @FindBy(css = "button[class='button-green-pdp']")
    private WebElement addToCart2;

    @FindBy(css = "div[class='button-white']")
    public WebElement shoppingContinued;

    @FindBy(css = "a[href='//www.mediamarkt.com.tr?ref=logo_rh']")
    private WebElement mediaMarktIcon;

    @FindBy(xpath = "(//a[@href='https://www.mediamarkt.com.tr/'])[1]")
    private WebElement mediaMarktLogo;

    @FindBy(css = "div[class='ctable']")
    public WebElement cartText;

    @FindBy(xpath = "//label[text()='LOGITECH ']")
    public WebElement logitechIcon;

    @FindBy(css = "label[title='Kablosuz Klavye']")
    public WebElement kablosuzKlavye;

    @FindBy(css = "label[title='5.0']")
    public WebElement rating;

    @FindBy(css = "p[title='Logitech Mx Keys Mini Kablosuz Klavye Siyah']")
    public WebElement blackKlavye;

    @FindBy(xpath = "(//h2[@class='cproduct-heading'])[1]")
    private WebElement lenovoProductVerify;

    @FindBy(xpath = "(//h2[@class='cproduct-heading'])[2]")
    private WebElement logitechProductVerify;

    @FindBy(css = "span[class='ms-icon ms-icon--type_search ms-button2__only-icon']")
    private WebElement searchClick;

    @FindBy(xpath = "//h3[text()='Ürün Sepetinize Eklenmiştir!']")
    public WebElement addToCartVerifyText;

    @FindBy(xpath = "//button[text()='Sepete Git']")
    public WebElement addToCartClick;

    @FindBy(css = "div[class='cototals js-totals copanel']")
    public WebElement scrollBox;

    @FindBy(xpath = "(//li[@ng-class='partialPrice.type'])[1]")
    public WebElement basketTotal;

    @FindBy(xpath = "(//li[@ng-class='partialPrice.type'])[2]")
    public WebElement cargoPrice;

    @FindBy(css = "li[class='cototals-value cototals-grandtotal']")
    public WebElement grandTotal;

    @FindBy(xpath = "(//button[@class='cproduct-actions-remove'])[2]")
    public WebElement deleteProduct2;

    @FindBy(xpath = "(//button[@class='cproduct-actions-remove'])[1]")
    public WebElement deleteProduct1;

    @FindBy(xpath = "//h3[text()='Sepetinizde ürün bulunmuyor']")
    private WebElement basketIsEmptyVerify;

    @FindBy(css = "span[data-identifier='log_in_out_label']")
    private WebElement logOutClick;

    @FindBy(css = "span[class='ms-login-logout__greet-text']")
    private WebElement logOutVerify;




















    WebElement myElement;

    public void findAndClick(String element){
        switch (element){
            case "accountIcon":myElement=accountIcon;break;
            case "entry":myElement=entry;break;
            case "entryButton":myElement=entryButton;break;
            case "blackMonitor":myElement=blackMonitor;break;
            case "addToCart":myElement=addToCart;break;
            case "addToCart2":myElement=addToCart2;break;
            case "shoppingContinued":myElement=shoppingContinued;break;
            case "mediaMarktIcon":myElement=mediaMarktIcon;break;
            case "mediaMarktLogo":myElement=mediaMarktLogo;break;
            case "blackKlavye":myElement=blackKlavye;break;
            case "searchClick":myElement=searchClick;break;
            case "addToCartClick":myElement=addToCartClick;break;
            case "logOutClick":myElement=logOutClick;break;

        }
        clickFunction(myElement);
    }

    public void findAndSend(String element, String value){
        switch (element){
            case "email":myElement=email;break;
            case "password":myElement=password;break;
            case "searchInput":myElement=searchInput;break;
        }
        sendKeysFunction(myElement,value);
    }

    public void verifyText(String element, String text){
        switch (element){
            case "loginVerify":myElement=loginVerify;break;
            case "logitechProductVerify":myElement=logitechProductVerify;break;
            case "lenovoProductVerify":myElement=lenovoProductVerify;break;
            case "basketTotal":myElement=basketTotal;break;
            case "cargoPrice":myElement=cargoPrice;break;
            case "grandTotal":myElement=grandTotal;break;
            case "basketIsEmptyVerify":myElement=basketIsEmptyVerify;break;
            case "logOutVerify":myElement=logOutVerify;break;

        }
        verifyContainsText(myElement,text);
    }









}
