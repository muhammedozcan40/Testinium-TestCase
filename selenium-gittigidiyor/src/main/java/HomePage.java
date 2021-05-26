import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class HomePage extends BasePage {

     SearchBox searchBox ;
     By cartCountLocator = By.id("nav-cart-count");
     By cartContainerLocator = By.id("nav-cart-count-container");
     By loginHover = By.className("gekhq4-5");
     By loginButton = By.cssSelector(".sc-1bydi5r-0[data-cy='header-login-button']");
   // By acceptCookiesLocator = By.id("sp-cc-accept");

    public HomePage(WebDriver driver) {
        super(driver);
        searchBox = new SearchBox(driver);
    }

    public SearchBox searchBox(){
        return this.searchBox;
    }

    public boolean isProductCountUp() {
        return getCartCount() > 0 ;
    }

    public void goToCart() {
        click(cartContainerLocator);
    }

    private int getCartCount(){
        String count = find(cartCountLocator).getText();
        return Integer.parseInt(count);
    }
    public void goToLogin(){

        driver.get("https://www.gittigidiyor.com/uye-girisi?s=1");
        driver.manage().window().maximize();
    }
    public void goToSecondPage(String Keyword){

        driver.get("https://www.gittigidiyor.com/arama/?k="+Keyword+"&sf=2");
        driver.manage().window().maximize();
    }
    public void goToHome(){
        driver.get(("https://www.gittigidiyor.com"));
        driver.manage().window().maximize();
    }
   /* public void acceptCookies(){
     //   if (isDisplayed(acceptCookiesLocator)){
       //     click(acceptCookiesLocator);
        }*/
    }

