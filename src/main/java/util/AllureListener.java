package util;

import org.junit.runner.notification.Failure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import ru.yandex.qatools.allure.annotations.Attachment;
import steps.BaseSteps;

public class AllureListener extends ru.yandex.qatools.allure.junit.AllureRunListener {

    @Override
    public void testFailure(Failure failure){
        takeScreenshot();
        super.testFailure(failure);

    }

    @Attachment(type = "img/png",value = "Screen on error")
    public byte[] takeScreenshot(){
        return ((TakesScreenshot) BaseSteps.getMydriver()).getScreenshotAs(OutputType.BYTES);
    }
}
