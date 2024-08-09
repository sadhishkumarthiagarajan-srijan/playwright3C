package com.parent_package.utils;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class BrowserFactory {

    public Page openBrowser(String Browser) throws Exception {
        Playwright playwright=Playwright.create();
        Browser browser;
        Page page;
        switch (Browser){
            case "chrome":
                browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(100));
                break;
            case "firefox":
                browser=playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(100));
                break;
            case "webkit":
                browser=playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(100));
                break;
            default:
                throw new Exception("Browser Type did not match::"+Browser);
        }
         page= browser.newPage();
         return page;
    }
}
