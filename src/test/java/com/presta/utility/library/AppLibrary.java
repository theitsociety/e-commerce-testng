package com.presta.utility.library;

public class AppLibrary {
    private PageLibrary page;
    private FlowLibrary flowLibrary;

    public AppLibrary() {
       page = new PageLibrary();
       flowLibrary = new FlowLibrary();
    }

    public PageLibrary getPage() {
        return page;
    }

    public FlowLibrary getFlowLibrary() {
        return flowLibrary;
    }
}
