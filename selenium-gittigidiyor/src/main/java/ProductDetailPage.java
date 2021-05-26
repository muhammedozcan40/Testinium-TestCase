import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ProductDetailPage extends BasePage{


    By addToCartButtonLocator = By.xpath("/html/body/div[3]/div[2]/div/div[1]/div[1]/div[2]/div[2]/div[1]/div/div[3]/div[3]/section/div/div/div[2]/form/button");

    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOnProductDetailPage() {
        return isDisplayed(addToCartButtonLocator);
    }

    public void addToCart() {
        WebElement element = driver.findElement(By.id("add-to-basket"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();

        driver.get("https://www.gittigidiyor.com/sepetim");

    }
}
