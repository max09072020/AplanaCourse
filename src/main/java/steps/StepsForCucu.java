package steps;


import cucumber.api.DataTable;
import cucumber.api.java.en.When;

public class StepsForCucu {

    MainSteps mainSteps= new MainSteps();
    FormSteps formSteps = new FormSteps();

    @When("^пользователь выбирает пункт \"(.*)\"$")
    public void selectMainMenu (String menuTab){
        mainSteps.selectMainMenuStep(menuTab);
    }

    @When("^пользователь выбирает вид Страхования - \"(.*)\"$")
    public void selectSubMenu (String tab){
        mainSteps.selectSubMainMenuStep(tab);
    }

    @When("^пользователь нажимает кнопку - Заполнить Online")
    public void registerOnline(){
        mainSteps.onLineFormPushStep();
    }
    @When("пользователь заполняет требуемые поля")
    public void fillTheForm(DataTable table){
        table.asMap(String.class, String.class).forEach((key,value) -> formSteps.fillFieldStep(key,value));

    }
}
