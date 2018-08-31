package APTests;

import org.junit.Assert;
import org.junit.Test;

public class APLinkTests extends APBaseTest{
    @Test
    public void FacebookLinkTest(){
        String expectedTitle = "facebook";
        String pageTitle = mainPage.Footer.clickFacebookLink().getPageTitle();

        Assert.assertTrue("Wrong page. Is " + pageTitle + " but expected title should contains "+ expectedTitle,
                pageTitle.toLowerCase().contains(expectedTitle));
    }
    @Test
    public void TwitterLinkTest(){
        String expectedTitle = "twitter";
        String pageTitle = mainPage.Footer.clickTwitterLink().getPageTitle();
        Assert.assertTrue("Wrong page. Is " + pageTitle + " but expected title should contains "+ expectedTitle,
                pageTitle.toLowerCase().contains(expectedTitle));
    }
    @Test
    public void YoutubeLinkTest(){
        String expectedTitle = "youtube";
        String pageTitle = mainPage.Footer.clickYoutubeLink().getPageTitle();

        Assert.assertTrue("Wrong page. Is " + pageTitle + " but expected title should contains "+ expectedTitle,
                pageTitle.toLowerCase().contains(expectedTitle));
    }
    @Test
    public void GooglePlusLinkTest(){
        String expectedTitle = "google";
        String pageTitle = mainPage.Footer.clickGooglePlusLink().getPageTitle();

        Assert.assertTrue("Wrong page. Is " + pageTitle + " but expected title should contains "+ expectedTitle,
                pageTitle.toLowerCase().contains(expectedTitle));
    }
}
