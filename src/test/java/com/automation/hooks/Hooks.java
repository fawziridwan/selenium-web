package com.automation.hooks;

import com.automation.config.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    private BaseTest baseTest;

    public Hooks(BaseTest baseTest) {
        this.baseTest = baseTest;
    }

    @Before
    public void setUp() {
        baseTest.setUp();
    }

    @After
    public void tearDown() {
        baseTest.tearDown();
    }
}