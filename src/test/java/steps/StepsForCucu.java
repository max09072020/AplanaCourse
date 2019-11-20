package steps;

import cucumber.api.DataTable;
import cucumber.api.java.ru.Тогда;

import java.util.Set;

public class StepsForCucu {

    MainSteps mainSteps= new MainSteps();
    FormSteps formSteps = new FormSteps();

    @Тогда("^пользователь выбирает пункт \"(.*)\"$")
    public void selectMainMenu (String menuTab){
        mainSteps.selectMainMenuStep(menuTab);
    }

    @Тогда("^пользователь выбирает вид Страхования - \"(.*)\"$")
    public void selectSubMenu (String tab){
        mainSteps.selectSubMainMenuStep(tab);
    }

    @Тогда("^пользователь проверяет заголовок \"(.*)\" текущей страницы")
    public void checkTitle(String title){
        mainSteps.checkTheTitleStep(title);
    }

    @Тогда("^пользователь нажимает - Оформить Online")
    public void registerOnline(){
        String oldTab = BaseSteps.getMydriver().getWindowHandle();
        mainSteps.onLineFormPushStep();
        Set<String> tabs = BaseSteps.getMydriver().getWindowHandles();
        for (String tab : tabs){
            if (!tab.equalsIgnoreCase(oldTab)){
                BaseSteps.getMydriver().switchTo().window(tab);
            }
        }
    }

    @Тогда("^пользователь проверяет свою вкладку \"(.*)\"$")
    public void checkingTab(String nameTaba){
        formSteps.checkMyTabStep(nameTaba);
    }

    @Тогда("^пользователь выбирает Минимальный тип покрытия")
    public void minChoice(){
        formSteps.coverChoiseStep();
    }

    @Тогда("^пользователь нажимает кнопку - Оформить")
    public void registerForm(){
        formSteps.registerStep();
    }

    @Тогда("^пользователь заполняет требуемые поля:$")
    public void fillTheForm(DataTable table){
        table.asMap(String.class, String.class).forEach((key,value) -> formSteps.fillFieldStep(key,value));
    }

    @Тогда("^пользователь проверяет правильность заполненных полей$")
    public void checkTheForm(DataTable table){
        table.asMap(String.class, String.class).forEach((key,value) -> formSteps.checkFieldStep(key,value));
    }

    @Тогда("^пользователь нажимает кнопку - Продолжить")
    public void next(){
        formSteps.continueStep();
    }

    @Тогда("^пользователь проверяет сообщение об ошибке \"(.*)\"$")
    public void error(String error){
        formSteps.checkErrorStep(error);
    }
}
