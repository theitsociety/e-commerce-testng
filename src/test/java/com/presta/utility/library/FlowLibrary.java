package com.presta.utility.library;

import com.presta.utility.Driver;

public class FlowLibrary {
    public void navigateToUrl(String url){
        Driver.getDriver().get(url);
    }

    public String getCurrentPageTitle(){
        return Driver.getDriver().getTitle();
    }

    public String getCurrentPageUrl(){
        return Driver.getDriver().getCurrentUrl();
    }
}
