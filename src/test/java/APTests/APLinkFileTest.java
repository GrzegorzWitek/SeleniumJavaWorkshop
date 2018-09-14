package APTests;

import Pages.APPages.APMainPage;
import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class APLinkFileTest extends APBaseTest{

    @FileParameters("src/test/resources/linkParameters.csv")
    @Test
    public void SocialLinkTest(String targetPage, String targetPageTitle){
        String pageTitle = new APMainPage().Footer.clickSocialLink(targetPage).getPageTitle();

        Assert.assertTrue("Wrong page. Is " + pageTitle + " but expected title should contains "+ targetPageTitle,
                pageTitle.toLowerCase().contains(targetPageTitle));
    }
}
