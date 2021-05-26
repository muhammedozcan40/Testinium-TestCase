import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductsPage extends BasePage {

    By productNameLocator = new By.ByXPath("/html/body/div[5]/div[1]/div/div[2]/div[4]/div[2]/ul/li[1]/a/div/div/div[1]/div[1]/h3");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }


    public String selectProduct(int i) {
        WebElement t=driver.findElement(By.xpath("/html/body/div[5]/div[1]/div/div[2]/div[3]/div[2]/ul/li["+i+"]/a"));
        // get src attribute with getAttribute()
        WebElement price=driver.findElement(By.xpath("/html/body/div[5]/div[1]/div/div[2]/div[4]/div[2]/ul/li[\"+i+\"]/a/div/div/div[1]/div[2]/div/div[1]/div[2]/div[2]/p"));
        StaticValue.productPrice=price.getAttribute("innerHTML");
        String href = t.getAttribute("href");
        return  href;
    }

    private List<WebElement> getAllProducts(){
        return findAll(productNameLocator);
    }

    public void goToProductDetail(String ProductHref){
        driver.get((ProductHref));
        driver.manage().window().maximize();
    }
}
