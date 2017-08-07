package com.automationpractice.core;

import cucumber.runtime.java.picocontainer.PicoFactory;

public class PicoDependencyInjector extends PicoFactory {

    public PicoDependencyInjector() {
        addClass(PageContainer.class);
    }
}
