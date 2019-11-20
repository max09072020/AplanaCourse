package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;

public class MainPage {

    @FindBy(xpath = "//ul[@class ='lg-menu__list']")
    WebElement mainMenu;

    @FindBy(xpath = "//ul[@class ='lg-menu__list']//ul[@aria-label ='Подменю']")
    WebElement subMenu;

    @FindBy(xpath = "//a[@target='_blank']//img[contains(@src, 'content/person/travel/banner')]")
    public WebElement onlineForm;

    public MainPage (){
        PageFactory.initElements(BaseSteps.getMydriver(),this);
    }

    public void selectMainMenu (String menuItem){
        mainMenu.findElement(By.xpath("//button[@aria-label= '" + menuItem + "']")).click();
    }

    public void selectSubMainMenu (String subMenuItem){
         mainMenu.findElement(By.xpath("//ul[@aria-label ='Подменю']/..//a[@class = 'lg-menu__sub-link'][text()='" + subMenuItem + "']")).click();
    }
}
