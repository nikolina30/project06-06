import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AppointmentTest extends BasePage {
    private String url = "https://katalon-demo-cura.herokuapp.com/";
    public AppointmentTest(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }
    public String getUrl() {
        return url;
    }
    public void makeAppointment() {
        WebElement makeAppointmentButton = driver.findElement(By.id("btn-make-appointment"));
        makeAppointmentButton.click();
    }
}
