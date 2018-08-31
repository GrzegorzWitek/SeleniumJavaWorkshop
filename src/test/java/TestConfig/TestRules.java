package TestConfig;

import Driver.Driver;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import ru.yandex.qatools.allure.annotations.Attachment;

public class TestRules extends TestWatcher {

    @Override
    protected void failed(Throwable e, Description description) {
        takePageSource();
        makeScreenshot();
    }

    @Override
    protected void finished(Description description) {
        Driver.quit();
    }

    @Attachment("Screenshot on failure")
    private byte[] makeScreenshot() {
        return ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment("Page Source")
    private String takePageSource() {
        return (Driver.getDriver()).getPageSource();
    }
}
