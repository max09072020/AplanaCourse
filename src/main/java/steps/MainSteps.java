package steps;

import pages.MainPage;
import ru.yandex.qatools.allure.annotations.Step;

public class MainSteps extends BaseSteps {

    @Step("пользователь выбирает пункт {0}")
    public void selectMainMenuStep (String menuItem){
        new MainPage(mydriver).selectMainMenu(menuItem);
    }

    @Step("пользователь выбирает вид Страхования - {0}")
    public void selectSubMainMenuStep (String subMenuItem){
        new MainPage(mydriver).selectSubMainMenu(subMenuItem);
    }

    @Step("пользователь нажимает кнопку - Заполнить Online")
    public void onLineFormPushStep (){
        new MainPage(mydriver).onlineForm.click();
    }
}
