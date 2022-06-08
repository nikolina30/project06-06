import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
public class AppointmentPage extends BasePage {

    private Select facilitySelect;
    private WebElement applyCheckBox;
    private WebElement radioButton;
    private WebElement visitDate;
    private WebElement commentInput;
    private WebElement bookAppointmentButton;

    public AppointmentPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }
    public void setupFields() {
        this.facilitySelect = new Select(driver.findElement(By.id("combo_facility")));
        this.applyCheckBox = driver.findElement(By.id("chk_hospotal_readmission"));
        this.radioButton = driver.findElement(By.id("radio_program_medicaid"));
        this.visitDate = driver.findElement(By.id("txt_visit_date"));
        this.commentInput = driver.findElement(By.id("txt_comment"));
        this.bookAppointmentButton = driver.findElement(By.id("btn-book-appointment"));
    }
    public String isFormPresented() {
        return driver.findElement(By.tagName("h2")).getText();
    }
    public Select getFacilitySelect() {
        return this.facilitySelect;
    }
    public WebElement getApplyCheckBox() {
        return applyCheckBox;
    }
    public WebElement getRadioButton() {
        return radioButton;
    }
    public WebElement getVisitDate() {
        return visitDate;
    }
    public WebElement getCommentInput() {
        return commentInput;
    }
    public WebElement getBookAppointmentButton() {
        return bookAppointmentButton;
    }
}
