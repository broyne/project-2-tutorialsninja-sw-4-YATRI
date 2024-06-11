package com.tutorialsninja.demo.testbase;


import com.tutorialsninja.demo.propertyreader.PropertyReader;
import com.tutorialsninja.demo.utilities.Utility;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

/**
 * Project-2 tutorialsninja-sw-4
 * baseUrl: http://tutorialsninja.com/demo/index.php?
 * Requirement:
 * Create the package ‘browserfactory’ and create the class with the name ‘Managebrowser’
 * inside the ‘browserfactory’ package. And write the browser setup code inside the class
 * ‘Managebrowser’.
 * Create the package utilities and create the class with the name ‘Utility’ inside the ‘utilities’
 * package. And write the all the utility methods in it’.
 * Create the package pages and create all pages classes init.
 * Create the package propertyreader and create the PropertyReader class init.
 * ● Create testbase package and create TestBase class init.
 * ● Create the testsuite package and create followin classes init
 */
public class BaseTest extends Utility {

    String browser = PropertyReader.getInstance().getProperty("browser");

    @BeforeMethod
    public void setUp(){
        selectBrowser(browser);
    }

    @AfterMethod
    public void tearDown(){
        closeBrowser();
    }
}
