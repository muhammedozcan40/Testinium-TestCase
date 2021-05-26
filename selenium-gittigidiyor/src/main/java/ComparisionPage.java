import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ComparisionPage extends BasePage {

    By productPriceLocator = new By.ByXPath("/html/body/div[1]/header/div[3]/div/div/div/div[3]/div/div[2]/div/div/div/div/div[3]/div/div[2]/p[3]/span[2]/strong/text()[1]");
    By productCount = new By.ByXPath("/html/body/div[1]/header/div[3]/div/div/div/div[3]/div/div[2]/a/div/div[1]/span");
    public ComparisionPage(WebDriver driver) {
        super(driver);
    }

    public void  countbasket2(){
        StaticValue.proCount=productCount.toString();
    }


}
