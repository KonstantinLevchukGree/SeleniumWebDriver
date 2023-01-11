package variablesBy;

import org.openqa.selenium.By;

public class VariablesBy {

    private static final By loginInput = By.id("passp-field-login");
    private static final By loginButton = By.xpath("//button[contains(@class,'Login')]");
    private static final By classLeftBox=By.cssSelector(".PSHeader-Left");
    private static final By link=By.linkText("Attention! Please switch to the light mail interface to use a computer screen reader.");
    private static final By metaName=By.name("google");
    private static final By leftBox= By.className("PSHeader-Left");
    private static final By inputs=By.tagName("input");
    private static final By links=By.partialLinkText("ttention");

    //https://saucelabs.com/resources/articles/selenium-tips-css-selectors
}
