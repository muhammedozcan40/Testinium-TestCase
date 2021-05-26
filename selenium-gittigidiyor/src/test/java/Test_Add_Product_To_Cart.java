import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.SessionId;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class Test_Add_Product_To_Cart extends BaseTest {

    HomePage homePage;
    ProductsPage productsPage;
    ProductDetailPage productDetailPage;
    CartPage cartPage;
    LoginPage loginPage;

    @Test
    @Order(1)
    public void loginToSite() throws InterruptedException {
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        homePage.goToLogin();
        loginPage.loginMethod("muhammedaliozcan40@gmail.com","sylavanas1998");

        SessionId session = ((ChromeDriver)driver).getSessionId();
        String sessionx = session.toString();
        String url = driver.getCurrentUrl();
        homePage.goToHome();
        WebDriverWait wait = new WebDriverWait(driver, 10); // seconds
        wait.until(ExpectedConditions.visibilityOfElementLocated(homePage.searchBox.searchBoxLocator));


    }
    @Test
    @Order(2)
    public void search_a_product() throws InterruptedException {
        homePage = new HomePage(driver);
      //  homePage.acceptCookies();
        String keyword = "bilgisayar";
        homePage.searchBox().search(keyword);

        homePage.goToSecondPage(keyword);
        String url = driver.getCurrentUrl().toString();
        String[] split = url.split("&sf=");
        Integer pageNumber = Integer.parseInt(split[1]);
        Boolean isSecondPage = homePage.searchBox.isSecondPage(pageNumber);
        if(isSecondPage){
            System.out.println("Evet 2. Sayfa");
        }else{
            //quit
        }


    }

    @Test
    @Order(3)
    public void select_a_product(){
        productsPage = new ProductsPage(driver);
        String ProductLink = productsPage.selectProduct(2);
        productsPage.goToProductDetail(ProductLink);
    }

    @Test
    @Order(4)
    public void add_product_to_cart(){
        productDetailPage = new ProductDetailPage(driver);
        System.out.println("asd");
        productDetailPage.addToCart();
        driver.get("https://www.gittigidiyor.com/sepetim");
        System.out.println(driver.getCurrentUrl());
    }

    @Test
    @Order(5)
    public void go_to_cart(){
        cartPage = new CartPage(driver);
        homePage.goToCart();
        Assertions.assertTrue(cartPage.checkIfProductAdded() ,
                "Product was not added to cart!");
    }

    @Test
    @Order(6)
    public void comparisionProductPrice(){
        ComparisionPage comparision= new ComparisionPage(driver);
        Assertions.assertEquals(comparision.productPriceLocator.toString(),StaticValue.productPrice.toString());

    }
    @Test
    @Order(7)
    public void comparisionProductCount(){
        ComparisionPage co = new ComparisionPage(driver);
        String c=StaticValue.proCount;
        Assertions.assertNotEquals(c,"2");
    }
    @Test
    @Order(8)
    public void nullBasketControl(){
    BasketPage basketPage= new BasketPage(driver);
    Assertions.assertEquals(basketPage.nullBasket(),"Sepetinizde ürün bulunmamaktadır.");

    }
}
