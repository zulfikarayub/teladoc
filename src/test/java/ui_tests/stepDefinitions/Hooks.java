package ui_tests.stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utilities.BaseClass;

import java.io.IOException;

public class Hooks extends BaseClass {


    @Before()
    public void beforeScenario(Scenario scenario) {


    }

    @AfterStep
    public void getScrShot(Scenario scenario) throws Exception {
        getScreenShot(scenario);


    }

    @After
    public void tearDown(Scenario scenario) throws IOException {

        driver.close();
        System.out.println("Driver is closed");

    }
}