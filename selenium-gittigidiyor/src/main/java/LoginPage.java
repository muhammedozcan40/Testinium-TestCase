import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends HomePage{
    By eMailLocator = By.xpath("/html/body/div[1]/div[3]/div[2]/div/div/div[2]/form/div[1]/div[1]/div[1]/div[2]/input");
    By passwordLocator = By.xpath("/html/body/div[1]/div[3]/div[2]/div/div/div[2]/form/div[1]/div[2]/div/div[2]/input");
    By loginLocator = By.xpath("/html/body/div[1]/div[3]/div[2]/div/div/div[2]/form/div[2]/div/div[2]/div[1]/input[13]");
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    public void loginMethod(String email,String password) {
        type(eMailLocator , email);
        type(passwordLocator,password);
        click(loginLocator);

    }





}
