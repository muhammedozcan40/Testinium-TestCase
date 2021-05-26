import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchBox extends BasePage{

    By searchBoxLocator = By.xpath("/html/body/div[1]/header/div[3]/div/div/div/div[2]/form/div/div[1]/div[2]/input");
    By submitButtonLocator = By.xpath("//button[@data-cy=\"search-find-button\"]");


    public SearchBox(WebDriver driver) {
        super(driver);
    }

    public void search(String text) {
        type(searchBoxLocator , text);
        click(submitButtonLocator);
    }

    public boolean isSecondPage(Integer pageNumber){
        if(pageNumber == 2){
            return true;
        }else{
            return  false;
        }
    }
}
