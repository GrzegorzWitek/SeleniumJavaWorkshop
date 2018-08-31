package Pages.APPages;

import Pages.APPages.Parts.APFooterPage;
import Pages.APPages.Parts.APHeaderPage;
import Pages.BasePage;

public class APBasePage extends BasePage {

    public APHeaderPage Header;
    public APFooterPage Footer;

    public APBasePage() {
        Header=new APHeaderPage();
        Footer = new APFooterPage();
    }
}
