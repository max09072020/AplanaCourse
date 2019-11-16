package SberHomeWork;

import org.junit.Assert;
import org.junit.Test;
import ru.yandex.qatools.allure.annotations.Title;
import steps.BaseSteps;
import steps.FormSteps;
import steps.MainSteps;

import java.util.HashMap;
import java.util.Set;

public class AllureRecordTest extends BaseSteps {

    @Test
    @Title("Страхование путешественника")
    public void mainTest (){

        MainSteps mainSteps = new MainSteps();
        FormSteps formSteps = new FormSteps();

        HashMap<String, String> data = new HashMap<>();
        data.put("LastName", "PETROV");
        data.put("Name", "IVAN");
        data.put("DOB", "09.07.1982");

        data.put("Фамилия", "БАШИРОВ");
        data.put("Имя", "ИВАН");
        data.put("Отчество", "АЛЕКСОВИЧ");
        data.put("Дата рождения", "09.07.1999");
        data.put("Серия паспорта", "2009");
        data.put("Номер паспорта","200900");
        data.put("Дата Выдачи","12.12.2012");
        data.put("Место Выдачи","УВД Черный лебедь");

        mainSteps.selectMainMenuStep("Меню Страхование");
        mainSteps.selectSubMainMenuStep("Страхование путешественников");
        Assert.assertEquals(mydriver.getTitle(),"«Сбербанк» - Страхование путешественников");

        String oldTab = mydriver.getWindowHandle();
        mainSteps.onLineFormPushStep();
        Set<String> tabs = mydriver.getWindowHandles();
        for (String tab : tabs){
            if (!tab.equalsIgnoreCase(oldTab)){
                mydriver.switchTo().window(tab);
            }
        }
        formSteps.checkMyTabStep("Выбор полиса");
        formSteps.coverChoiseStep();
        formSteps.registerStep();
        formSteps.fillAllFieldsStep(data);
        formSteps.checkAllFieldsStep(data);

        formSteps.continueStep();
        formSteps.checkErrorStep("Заполнены не все обязательные поля");

    }
}
