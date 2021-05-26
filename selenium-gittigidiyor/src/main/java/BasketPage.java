import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasketPage extends BasePage {

    By productPriceLocator = new By.ByXPath("/html/body/div[1]/header/div[3]/div/div/div/div[3]/div/div[2]/div/div/div/div/div[3]/div/div[2]/p[3]/span[2]/strong/text()[1]");
    By productCount = new By.ByXPath("/html/body/div[1]/header/div[3]/div/div/div/div[3]/div/div[2]/a/div/div[1]/span");

    public BasketPage(WebDriver driver) {
        super(driver);
    }

    public  void deleteProduct(){
        By deleteclick = new By.ByXPath("/html/body/div[3]/div[3]/div/div[4]/div[3]/div/div/div/div[2]/div[2]/ul/li/a/i");
        click(deleteclick);
    }
    public String nullBasket(){
        By text=new By.ByXPath("/html/body/div[3]/div[3]/div/div[4]/div[3]/div/div/div/div[2]/div[5]/p");

        return text.toString();
    }

}
