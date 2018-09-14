package APTests;

import TestData.TestDataReader;
import TestData.TestObject;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

@RunWith(value = Parameterized.class)
public class APLinkTest extends APBaseTest{

    @Parameter(0)
    public String fileName;

    @Parameters(name = "{index}: Open social link for {0}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"facebook"},
                {"twitter"},
                {"youtube"},
                {"google"}
        });
    }

    @Test
    public void SocialLinkTest(){
        TestObject to = TestDataReader.readTestData(fileName);
        String pageTitle = mainPage.Footer.clickSocialLink(to.portalLocator).getPageTitle();

        Assert.assertTrue("Wrong page. Is " + pageTitle + " but expected title should contains "+ to.portalLink,
                pageTitle.toLowerCase().contains(to.portalLink));
    }
}
