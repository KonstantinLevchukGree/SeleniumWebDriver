package utils.variablesBy;

import org.openqa.selenium.By;

public class VariablesBy {
    private static final By LOGIN_INPUT = By.id("passp-field-login");
    private static final By LOGIN_BUTTON = By.xpath("//button[contains(@class,'Login')]");
    private static final By CLASS_LEFT_BOX = By.cssSelector(".PSHeader-Left");
    private static final By LINK = By.linkText("Attention! Please switch to the light mail interface to use a computer screen reader.");
    private static final By META_NAME = By.name("google");
    private static final By LEFT_BOX = By.className("PSHeader-Left");
    private static final By INPUTS = By.tagName("input");
    private static final By LINKS = By.partialLinkText("ttention");
}
