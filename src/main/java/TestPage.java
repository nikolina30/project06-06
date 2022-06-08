import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;

public class TestPage {
    private WebDriver driver;
    private WebDriverWait driverWait;
    private AppointmentPage appointmentPage;
    private AppointmentTest appointmentTest;
    private SummaryPage summaryPage;
    private LoginPage loginPage;

    public String facilityOption;
    public boolean checkBoxValue;
    public String radioButtonValue;
    public String dateValue;
    public String commentValue;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @BeforeMethod
    public void beforeMethod() throws InterruptedException {

        driverWait = new WebDriverWait(driver, Duration.ofSeconds(15));
        appointmentPage = new AppointmentPage(driver, driverWait);
        appointmentTest = new AppointmentTest(driver, driverWait);
        summaryPage = new SummaryPage(driver, driverWait);
        loginPage = new LoginPage(driver, driverWait);
        Thread.sleep(2000);
    }

    @Test (priority = 1)
    public void navigateToAppointment() {
        try {
            driver.navigate().to(appointmentTest.getUrl());
            driver.manage().window().maximize();
            Thread.sleep(2000);
            appointmentTest.makeAppointment();
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test (priority = 2)
    public void login() throws InterruptedException {
        loginPage.login();
        Thread.sleep(2000);
    }

    @Test (priority = 3)
    public void fillAppointment() {
        try {
            String makeAppointmentPageTitle = "Make Appointment";
            Assert.assertEquals(makeAppointmentPageTitle, appointmentPage.isFormPresented());
            appointmentPage.setupFields();
            appointmentPage.getFacilitySelect().selectByVisibleText("Hongkong CURA Healthcare Center");
            facilityOption = appointmentPage.getFacilitySelect().getFirstSelectedOption().getText();
            Thread.sleep(1000);
            appointmentPage.getApplyCheckBox().click();
            checkBoxValue = appointmentPage.getApplyCheckBox().isSelected();
            Thread.sleep(1000);
            appointmentPage.getRadioButton().click();
            this.radioButtonValue = appointmentPage.getRadioButton().getAttribute("value");
            Thread.sleep(1000);
            appointmentPage.getVisitDate().sendKeys("06/07/2022");
            dateValue = appointmentPage.getVisitDate().getAttribute("value");
            Thread.sleep(1000);
            appointmentPage.getCommentInput().sendKeys("I wish to make an appointment as quickly as possible.");
            commentValue = appointmentPage.getCommentInput().getAttribute("value");
            Thread.sleep(1000);
            appointmentPage.getBookAppointmentButton().click();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test (priority = 4)
    public void assertAppointmentFields() throws InterruptedException {
        summaryPage.setupFields();
        Assert.assertEquals(facilityOption, summaryPage.getFacilityOption());
        Assert.assertEquals(checkBoxValue, summaryPage.isCheckBoxValue());
        Assert.assertEquals(radioButtonValue, summaryPage.getRadioButtonValue());
        Assert.assertEquals(dateValue, summaryPage.getDateValue());
        Assert.assertEquals(commentValue, summaryPage.getCommentValue());
        summaryPage.goToHomePage();
        Thread.sleep(2000);
    }

    @Test (priority = 5)
    public void assertUserIsLoggedIn() {
        String makeAppointmentPageTitle = "Make Appointment";
        Assert.assertEquals(makeAppointmentPageTitle, driver.findElement(By.tagName("h2")).getText());
    }

    @AfterClass
    public void afterMethod () throws InterruptedException {
        Thread.sleep(5000);
        driver.close();
    }
}

