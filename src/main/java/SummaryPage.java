import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
public class SummaryPage extends BasePage {
    private WebElement facilityResult;
    private WebElement applyCheckBoxResult;
    private WebElement radioButtonResult;
    private WebElement visitDateResult;
    private WebElement commentInputResult;
    private WebElement goToHomePageButton;

    private String facilityOption;
    private boolean checkBoxValue;
    private String radioButtonValue;
    private String dateValue;
    private String commentValue;

    public SummaryPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }
    public void setupFields() {
        this.facilityResult = driver.findElement(By.id("facility"));
        this.applyCheckBoxResult = driver.findElement(By.id("hospital_readmission"));
        this.radioButtonResult = driver.findElement(By.id("program"));
        this.visitDateResult = driver.findElement(By.id("visit_date"));
        this.commentInputResult = driver.findElement(By.id("comment"));
        this.goToHomePageButton = driver.findElement(By.xpath("//*[@id=\"summary\"]/div/div/div[7]/p/a"));
        this.facilityOption = this.facilityResult.getText();
        this.checkBoxValue = this.applyCheckBoxResult.getText().equals("Yes");
        this.radioButtonValue = this.radioButtonResult.getText();
        this.dateValue = this.visitDateResult.getText();
        this.commentValue = this.commentInputResult.getText();
    }

    public void goToHomePage() {
        this.goToHomePageButton.click();
    }

    public WebElement getFacilityResult() {
        return facilityResult;
    }

    public WebElement getApplyCheckBoxResult() {
        return applyCheckBoxResult;
    }

    public WebElement getRadioButtonResult() {
        return radioButtonResult;
    }

    public WebElement getVisitDateResult() {
        return visitDateResult;
    }

    public WebElement getCommentInputResult() {
        return commentInputResult;
    }

    public WebElement getGoToHomePageButton() {
        return goToHomePageButton;
    }

    public String getFacilityOption() {
        return facilityOption;
    }

    public boolean isCheckBoxValue() {
        return checkBoxValue;
    }

    public String getRadioButtonValue() {
        return radioButtonValue;
    }

    public String getDateValue() {
        return dateValue;
    }

    public String getCommentValue() {
        return commentValue;
    }
}

