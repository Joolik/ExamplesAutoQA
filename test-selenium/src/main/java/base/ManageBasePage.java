package base;

import org.openqa.selenium.WebDriver;
import elements.MenuTabsElement;
import enums.ManageTabItems;

public abstract class ManageBasePage extends BasePage {

    private MenuTabsElement menuTabs;

    protected ManageBasePage(WebDriver driver) {
        super(driver);
        menuTabs = new MenuTabsElement(driver);
    }

    public void selectMenuTabsItem(ManageTabItems tabName) {
        menuTabs.clickTabByName(tabName);
    }
}
