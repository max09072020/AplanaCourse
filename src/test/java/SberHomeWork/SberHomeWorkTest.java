package SberHomeWork;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.concurrent.TimeUnit;

public class SberHomeWorkTest extends BaseTest {

    @Test
    @Ignore
    public void test_1(){
        // step 2 - 3
        mydriver.get(baseURL);
        mydriver.findElement(By.xpath("//li[@class = 'lg-menu__item']//button[@aria-label= 'Меню Страхование']")).click();
        mydriver.findElement(By.xpath("//ul[@aria-label ='Подменю']//a[contains(@href, 'insuranceprogram/life/travel')]")).click();

        // step 4
        Assert.assertEquals(mydriver.getTitle(),"«Сбербанк» - Страхование путешественников");

        // step 5 - 6
        mydriver.getWindowHandle();
        mydriver.findElement(By.xpath("//a[@href='https://sberbankinsru.page.link/aN35']//img[contains(@src, 'content/person/travel/banner')]")).click();
        for(String winHandle : mydriver.getWindowHandles()){
            mydriver.switchTo().window(winHandle);
        }
        mydriver.manage().timeouts().pageLoadTimeout(15,TimeUnit.SECONDS);
        // проверка, что мы на вкладке Выбор полиса
        WebElement tabChoice = mydriver.findElement(By.xpath("//span[@class='b-heading-tabset-title ng-binding'][text()='Выбор полиса']//..//span"));
        Assert.assertTrue(tabChoice.getAttribute("class").contains("active"));
        mydriver.findElement(By.xpath("//div[@ng-click='setProdProg(prodProg)']//div[text()='Минимальная']/parent::*")).click();

        // step 7 нажать оформить
        mydriver.findElement(By.xpath("//a[@ng-click = 'save()'][text()='Оформить']")).click();
        // проверка, что мы на вкладке Оформление
        WebElement tabRegister = mydriver.findElement(By.xpath("//span[@class='b-heading-tabset-title ng-binding'][text()='Оформление']//..//span"));
        Assert.assertTrue(tabRegister.getAttribute("class").contains("active"));

        // step 8
        // Застрахованные
        WebElement insLastName = mydriver.findElement(By.xpath("//input[@name = 'insured0_surname']"));
        insLastName.clear();
        insLastName.sendKeys("PETROV");
        WebElement insName = mydriver.findElement(By.xpath("//input[@name = 'insured0_name']"));
        insName.clear();
        insName.sendKeys("Ivan");
        WebElement insBirthDate = mydriver.findElement(By.xpath("//input[@name = 'insured0_birthDate']"));
        insBirthDate.clear();
        insBirthDate.sendKeys("09.07.1982");
        // Страхователь
        WebElement lastName = mydriver.findElement(By.xpath("//input[@name = 'surname']"));
        lastName.clear();
        lastName.sendKeys("БАШИРОВ");
        WebElement name = mydriver.findElement(By.xpath("//input[@name = 'name']"));
        name.clear();
        name.sendKeys("ИВАН");
        WebElement middlename = mydriver.findElement(By.xpath("//input[@name = 'middlename']"));
        middlename.clear();
        middlename.sendKeys("АЛЕКСОВИЧ");
        WebElement birthDate = mydriver.findElement(By.xpath("//input[@name = 'birthDate']"));
        birthDate.clear();
        birthDate.sendKeys("09.07.1999");
        // данные паспорта РФ
        WebElement passSeries = mydriver.findElement(By.xpath("//input[@name = 'passport_series']"));
        passSeries.clear();
        passSeries.sendKeys("2009");
        WebElement passNumber = mydriver.findElement(By.xpath("//input[@name = 'passport_number']"));
        passNumber.clear();
        passNumber.sendKeys("200900");
        WebElement issueDate = mydriver.findElement(By.xpath("//input[@name = 'issueDate']"));
        issueDate.clear();
        issueDate.sendKeys("12.12.2012");
        WebElement issuePlace = mydriver.findElement(By.xpath("//textarea[@name = 'issuePlace']"));
        issuePlace.clear();
        issuePlace.sendKeys("УВД Черный лебедь");

        // step 9
        Assert.assertEquals("PETROV", insLastName.getAttribute("value"));
        Assert.assertEquals("Ivan", insName.getAttribute("value"));
        Assert.assertEquals("09.07.1982", insBirthDate.getAttribute("value"));

        Assert.assertEquals("БАШИРОВ", lastName.getAttribute("value"));
        Assert.assertEquals("ИВАН", name.getAttribute("value"));
        Assert.assertEquals("АЛЕКСОВИЧ", middlename.getAttribute("value"));
        Assert.assertEquals("09.07.1999", birthDate.getAttribute("value"));

        Assert.assertEquals("2009", passSeries.getAttribute("value"));
        Assert.assertEquals("200900", passNumber.getAttribute("value"));
        Assert.assertEquals("12.12.2012", issueDate.getAttribute("value"));
        Assert.assertEquals("УВД Черный лебедь", issuePlace.getAttribute("value"));

        // step 10
        WebElement saveButton = mydriver.findElement(By.xpath("//a[@ng-click = 'save()'][text()='Продолжить']"));
        saveButton.click();

        // step 11
        WebElement error = mydriver.findElement(By.xpath("//div[@ng-show = 'tryNext && myForm.$invalid']"));
        Assert.assertEquals("Заполнены не все обязательные поля", error.getText());

    }

}
