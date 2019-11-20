package steps;

import org.junit.Assert;
import pages.MainPage;
import ru.yandex.qatools.allure.annotations.Step;

public class MainSteps {

    @Step("пользователь выбирает вкладку - {0}")
    public void selectMainMenuStep (String menuItem){
        new MainPage().selectMainMenu(menuItem);

    }
    @Step("пользователь выбирает вид Страхования - {0}")
    public void selectSubMainMenuStep (String subMenuItem){
        new MainPage().selectSubMainMenu(subMenuItem);
    }

    @Step("пользователь нажимает кнопку - Заполнить Online")
    public void onLineFormPushStep (){
        new MainPage().onlineForm.click();
    }


    @Step("пользователь проверяет {0} текущей странице")
    public void checkTheTitleStep (String title) {
        Assert.assertEquals(BaseSteps.getMydriver().getTitle(), title);
    }

}
