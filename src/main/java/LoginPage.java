import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }
    public void login() {
        List<WebElement> inputFields = driver.findElements(By.tagName("input"));
        inputFields.get(2).sendKeys(inputFields.get(0).getAttribute("value"));
        inputFields.get(3).sendKeys(inputFields.get(1).getAttribute("value"));

        WebElement loginButton = driver.findElement(By.id("btn-login"));
        loginButton.click();
    }
}
