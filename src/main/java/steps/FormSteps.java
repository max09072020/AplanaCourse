package steps;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.FormPage;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.HashMap;

public class FormSteps extends BaseSteps{

    @Step("пользователь заполняет поле {0} значением {1}")
    public void fillFieldStep (String field, String value) {
        FormPage form = new FormPage(mydriver);
        switch (field) {
            case "LastName":
                form.insLastName.sendKeys(value);
                break;
            case "Name":
                form.insName.sendKeys(value);
                break;
            case "DOB":
                form.insBirthDate.sendKeys(value);
                form.insBirthDate.sendKeys(Keys.TAB);
                break;
            case "Фамилия":
                form.lastName.sendKeys(value);
                break;
            case "Имя":
                form.name.sendKeys(value);
                break;
            case "Отчество":
                form.middlename.sendKeys(value);
                break;
            case "Дата рождения":
                form.birthDate.sendKeys(value);
                break;
            case "Серия паспорта":
                form.passSeries.sendKeys(value);
                break;
            case "Номер паспорта":
                form.passNumber.sendKeys(value);
                break;
            case "Дата Выдачи":
                form.issueDate.sendKeys(value);
                break;
            case "Место Выдачи":
                form.issuePlace.sendKeys(value);
                break;
            default:  throw new AssertionError("Поле '" + field + "' не объявлено на странице");
        }
    }

    @Step("пользователь заполняет все поля:")
    public void fillAllFieldsStep (HashMap<String , String > fields){
       fields.forEach(this::fillFieldStep);
    }

    @Step("пользователь проверяет вкладку {0} на которой находится")
    public void checkMyTabStep(String tabName){
        Assert.assertEquals("active", new FormPage(mydriver).tabIsActiveOrNot(tabName));
    }

    @Step("пользователь выбирает тип покрытия Минимальный ")
    public void coverChoiseStep (){
       new FormPage(mydriver).coverChoice.click();
    }

    @Step("пользователь нажимает кнопку - Оформить")
    public void registerStep (){
        new FormPage(mydriver).registerButton.click();
    }

    @Step("пользователь нажимает кнопку - Продолжить")
    public void continueStep (){
        new FormPage(mydriver).saveButton.click();
    }

    public String getFieldValue(String field){
        FormPage form = new FormPage(mydriver);
        switch (field){
            case "LastName":
                return form.insLastName.getAttribute("value");
            case "Name":
                return form.insName.getAttribute("value");
            case "DOB":
                return form.insBirthDate.getAttribute("value");
            case  "Фамилия":
                return form.lastName.getAttribute("value");
            case  "Имя":
                return form.name.getAttribute("value");
            case  "Отчество":
                return form.middlename.getAttribute("value");
            case  "Дата рождения":
                return form.birthDate.getAttribute("value");
            case  "Серия паспорта":
                return form.passSeries.getAttribute("value");
            case  "Номер паспорта":
                return form.passNumber.getAttribute("value");
            case  "Дата Выдачи":
                return form.issueDate.getAttribute("value");
            case  "Место Выдачи":
                return form.issuePlace.getAttribute("value");
        }
        throw new AssertionError("Поле не объявлено на странице");
    }

    @Step("пользователь проверяет поле {0} заполненое значением {1}")
    public void checkFieldStep(String field, String value){
        String actual = this.getFieldValue(field);
        Assert.assertTrue(String.format("Значение поля [%s] равно [%s]. Ожидалось - [%s]", field, actual, value),
                actual.equals(value));
    }

    @Step("пользователь проверяет, что поля заполнены верно")
    public void checkAllFieldsStep(HashMap<String, String> fields){
        fields.forEach((k, v)-> checkFieldStep(k,v));
    }

    @Step("пользователь проверяет ошибку")
    public void checkErrorStep(String error){
        Assert.assertEquals(error, new FormPage(mydriver).error.getText());
    }
}
