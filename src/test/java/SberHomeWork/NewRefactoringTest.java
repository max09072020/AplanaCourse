package SberHomeWork;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Keys;
import util.pages.FormPage;
import util.pages.MainPage;

import java.util.ArrayList;
import java.util.Set;

public class NewRefactoringTest extends BaseTest {
    private MainPage mainPage;
    private FormPage formPage;

    @Test
    public void mainTest (){

        // step 1 - 4
        mainPage = new MainPage(mydriver);
        mainPage.selectMainMenu("Меню Страхование");
        mainPage.selectSubMainMenu("Страхование путешественников");
        Assert.assertEquals(mydriver.getTitle(),"«Сбербанк» - Страхование путешественников");

        // step 5
        String oldTab = mydriver.getWindowHandle();
        mainPage.onlineForm.click();
        Set<String> tabs = mydriver.getWindowHandles();
        for (String tab : tabs){
            if (!tab.equalsIgnoreCase(oldTab)){
                mydriver.switchTo().window(tab);
            }
        }

        // step 6
        formPage = new FormPage(mydriver);
        Assert.assertEquals("active", formPage.tabIsActiveOrNot("Выбор полиса"));
        formPage.coverChoice.click();

        // step 7
        formPage.registerButton.click();

        // step 8

        formPage.fillField(formPage.insLastName,"PETROV");
        formPage.fillField(formPage.insName,"Ivan");
        formPage.fillField(formPage.insBirthDate,"09.07.1982");
        formPage.insBirthDate.sendKeys(Keys.TAB);

        formPage.fillField(formPage.lastName, "БАШИРОВ");
        formPage.fillField(formPage.name, "ИВАН");
        formPage.fillField(formPage.middlename, "АЛЕКСОВИЧ");
        formPage.fillField(formPage.birthDate, "09.07.1999");

        formPage.fillField(formPage.passSeries,"2009");
        formPage.fillField(formPage.passNumber,"200900");
        formPage.fillField(formPage.issueDate,"12.12.2012");
        formPage.issueDate.sendKeys(Keys.TAB);
        formPage.fillField(formPage.issuePlace,"УВД Черный лебедь");


        Assert.assertEquals("PETROV", formPage.insLastName.getAttribute("value"));
        Assert.assertEquals("Ivan", formPage.insName.getAttribute("value"));
        Assert.assertEquals("09.07.1982", formPage.insBirthDate.getAttribute("value"));

        Assert.assertEquals("БАШИРОВ", formPage.lastName.getAttribute("value"));
        Assert.assertEquals("ИВАН", formPage.name.getAttribute("value"));
        Assert.assertEquals("АЛЕКСОВИЧ", formPage.middlename.getAttribute("value"));
        Assert.assertEquals("09.07.1999", formPage.birthDate.getAttribute("value"));

        Assert.assertEquals("2009", formPage.passSeries.getAttribute("value"));
        Assert.assertEquals("200900", formPage.passNumber.getAttribute("value"));
        Assert.assertEquals("12.12.2012", formPage.issueDate.getAttribute("value"));
        Assert.assertEquals("УВД Черный лебедь", formPage.issuePlace.getAttribute("value"));

        // step 10
        formPage.saveButton.click();

        // step 11
        Assert.assertEquals("Заполнены не все обязательные поля", formPage.error.getText());
    }
}
