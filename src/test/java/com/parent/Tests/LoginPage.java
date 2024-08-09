package com.parent.Tests;

import com.microsoft.playwright.Page;
import com.parent_package.utils.BrowserFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginPage extends BrowserFactory {
    Page page;


@BeforeTest
    public void initBrowser() throws Exception {
    page= openBrowser("chrome");


}
@Test
    public void launchLogin(){

    page.navigate("https://www.saucedemo.com/");
    page.locator("#user-name").fill("standard_user");
    page.locator("#password").fill("secret_sauce");
    page.locator("#login-button").click();
    String header=page.locator("//div[@class=\"header_label\"]/div").textContent();
    Assert.assertEquals("Swag Labs",header);
}

@AfterTest
    public void tearDown(){
    page.close();

}
}
