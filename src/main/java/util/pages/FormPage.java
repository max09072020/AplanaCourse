package util.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.concurrent.TimeUnit;

public class FormPage {

    @FindBy(xpath = "//input[@name = 'insured0_surname']")
    public WebElement insLastName;

    @FindBy(xpath = "//input[@name = 'insured0_name']")
    public WebElement insName;

    @FindBy(xpath = "//input[@name = 'insured0_birthDate']")
    public WebElement insBirthDate;

    // Страхователь
    @FindBy(xpath = "//input[@name = 'surname']")
    public WebElement lastName;

    @FindBy(xpath = "//input[@name = 'name']")
    public WebElement name;

    @FindBy(xpath = "//input[@name = 'middlename']")
    public WebElement middlename;

    @FindBy(xpath = "//input[@name = 'birthDate']")
    public WebElement birthDate;

    // данные паспорта РФ
    @FindBy(xpath = "//input[@name = 'passport_series']")
    public WebElement passSeries;

    @FindBy(xpath = "//input[@name = 'passport_number']")
    public WebElement passNumber;

    @FindBy(xpath = "//input[@name = 'issueDate']")
    public WebElement issueDate;

    @FindBy(xpath = "//textarea[@name = 'issuePlace']")
    public WebElement issuePlace;

    @FindBy(xpath = "//span[@ng-click = 'save()'][text()='Продолжить']")
    public WebElement saveButton;

    @FindBy(xpath = "//span[@ng-click = 'save()'][text()='Оформить']")
    public WebElement registerButton;

    @FindBy(xpath = "//span[@class='b-heading-tabset-title ng-binding'][text()='Выбор полиса']//..//span")
    WebElement tabChoice;

    @FindBy(xpath = "//span[@class='b-heading-tabset-title ng-binding'][text()='Оформление']//..//span")
    WebElement tabRegister;

    @FindBy(xpath = "//div[@class='b-heading-tabset']")
    public WebElement header;

    @FindBy(xpath = "//div[@ng-click='setProdProg(prodProg)']//div[text()='Минимальная']/parent::*")
    public WebElement coverChoice;

    @FindBy(xpath = "//div[@ng-show = 'tryNext && myForm.$invalid']")
    public WebElement error;

    public FormPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    }

    public String tabIsActiveOrNot(String tabName) {
        WebElement headerItem = this.header.findElement(By.xpath("//span[@class='b-heading-tabset-title ng-binding'][text()='" + tabName + "']//..//span"));
        if (headerItem.getAttribute("class").contains("active")) {
            return "active";
        } else return "not active";
    }

    public void fillField(WebElement element, String value) {
        element.clear();
        element.sendKeys(value);
    }
}

