package APTests;

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
    public String targetPage;
    @Parameter(1)
    public String targetPageTitle;

    @Parameters(name = "{index}: Open social link for {0} and expect title with {1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"facebook", "facebook"},
                {"twitter", "twitter"},
                {"youtube", "youtube"},
                {"google-plus", "google+"}
        });
    }

    @Test
    public void SocialLinkTest(){
        String pageTitle = mainPage.Footer.clickSocialLink(targetPage).getPageTitle();

        Assert.assertTrue("Wrong page. Is " + pageTitle + " but expected title should contains "+ targetPageTitle,
                pageTitle.toLowerCase().contains(targetPageTitle));
    }
}
