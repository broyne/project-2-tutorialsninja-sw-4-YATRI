package com.tutorialsninja.demo.testsuite;

import com.tutorialsninja.demo.pages.DesktopsPage;
import com.tutorialsninja.demo.pages.HomePage;
import com.tutorialsninja.demo.pages.LaptopsAndNotebooksPage;
import com.tutorialsninja.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Create the class LaptopsAndNotebooksTest
 * Write the following test
 * 1. Test name verifyProductsPriceDisplayHighToLowSuccessfully()
 * 1.1 Mouse hover on Laptops & Notebooks Tab.and click
 * 1.2 Click on “Show All Laptops & Notebooks”
 * 1.3 Select Sort By "Price (High > Low)"
 * 1.4 Verify the Product price will arrange in High to Low order.
 * 2. Test name verifyThatUserPlaceOrderSuccessfully()
 * 2.1 Mouse hover on Laptops & Notebooks Tab and click
 * 2.2 Click on “Show All Laptops & Notebooks”
 * 2.3 Select Sort By "Price (High > Low)"
 * 2.4 Select Product “MacBook”
 * 2.5 Verify the text “MacBook”
 * 2.6 Click on ‘Add To Cart’ button
 * 2.7 Verify the message “Success: You have added MacBook to your shopping cart!”
 * 2.8 Click on link “shopping cart” display into success message
 * 2.9 Verify the text "Shopping Cart"
 * 2.10 Verify the Product name "MacBook"
 * 2.11 Change Quantity "2"
 * 2.12 Click on “Update” Tab
 * 2.13 Verify the message “Success: You have modified your shopping cart!”
 * 2.14 Verify the Total £737.45
 * 2.15 Click on “Checkout” button
 * 2.16 Verify the text “Checkout”
 * 2.17 Verify the Text “New Customer”
 * 2.18 Click on “Guest Checkout” radio button
 * 2.19 Click on “Continue” tab
 * 2.20 Fill the mandatory fields
 * 2.21 Click on “Continue” Button
 * 2.22 Add Comments About your order into text area
 * 2.23 Check the Terms & Conditions check box
 * 2.24 Click on “Continue” button
 * 2.25 Verify the message “Warning: Payment method required!”
 */

public class LaptopsAndNotebooksTest extends BaseTest {
    DesktopsPage desktopsPage = new DesktopsPage();
    HomePage homePage = new HomePage();
    LaptopsAndNotebooksPage laptopAndNotebooksPage = new LaptopsAndNotebooksPage();

    @Test
    public void verifyProductsPriceDisplayHighToLowSuccessfully() throws InterruptedException{
        //1.1 Mouse hover on Laptops & Notebooks Tab.and click
        String menuName = laptopAndNotebooksPage.laptopMenu;
        //1.2 Click on “Show All Laptops & Notebooks”
        homePage.clickOnMenu(menuName);
        homePage.clickOnElement(desktopsPage.currencyDropdown);
        //1.2 Click on “Show All Laptops & Notebooks”
        homePage.clickOnElement(desktopsPage.£Pound);
        //1.3 Select Sort By "Price (High > Low)"
        homePage.mouseHoverToElementAndClick(laptopAndNotebooksPage.laptopAndNoteBookTable);
        //1.4 Verify the Product price will arrange in High to Low order.
        homePage.clickOnElement(desktopsPage.showAllLaptopAndNotebook);

        //Verify the Product will arrange in Descending order.
        List<Double> actualText = laptopAndNotebooksPage.getProductPricesInDefaultFilterAndSortByDescendingOrder();
        //Select Sort By position "Price high to low"
        laptopAndNotebooksPage.select(laptopAndNotebooksPage.selectFilter, "https://tutorialsninja.com/demo/index.php?route=product/category&path=18&sort=p.price&order=DESC");
        Thread.sleep(2000);
        List<Double> expectedText = laptopAndNotebooksPage.getProductPriceAfterFilterHighToLow();
        Assert.assertEquals(actualText, expectedText, "Product not in descending order");
    }

    @Test
    public void verifyThatUserPlaceOrderSuccessfully() throws InterruptedException {

        //Mouse hover on Currency Dropdown and click
        homePage.clickOnElement(desktopsPage.currencyDropdown);

        //Mouse hover on £Pound Sterling and click
        homePage.clickOnElement(desktopsPage.£Pound);

        //Mouse hover on Laptops & Notebooks Tab.and click
        homePage.mouseHoverToElementAndClick(laptopAndNotebooksPage.laptopAndNoteBookTable);

        //Click on “Show All Laptops & Notebooks”
        homePage.clickOnElement(desktopsPage.showAllLaptopAndNotebook);

        //Select Sort By "Price (High > Low)"
        laptopAndNotebooksPage.select(laptopAndNotebooksPage.selectFilter, "https://tutorialsninja.com/demo/index.php?route=product/category&path=18&sort=p.price&order=DESC");

        //Select Product “Sony VAIO”
        homePage.clickOnElement(laptopAndNotebooksPage.sonyVAIO);

        //Verify the text “Sony VAIO”
        String expectedText = "Sony VAIO";
        String actualText = desktopsPage.getVerificationText(laptopAndNotebooksPage.sonyVAIOText);
        Assert.assertEquals(actualText, expectedText, "Text not match sony vaio");

        //Click on ‘Add To Cart’ button
        homePage.clickOnElement(laptopAndNotebooksPage.addToCartButton);

        //Verify the message “Success: You have added Sony VAIO to your shopping cart!”
        expectedText = "Success: You have added Sony VAIO to your shopping cart!";
        actualText = desktopsPage.getVerificationText(laptopAndNotebooksPage.successText).substring(0, 56);
        Assert.assertEquals(actualText, expectedText, "Not success");

        //Click on link “shopping cart” display into success message
        homePage.clickOnElement(laptopAndNotebooksPage.shoppingCartButton);

        //Verify the text "Shopping Cart"
        expectedText = "Shopping Cart";
        actualText = desktopsPage.getVerificationText(laptopAndNotebooksPage.shoppingCartText).substring(0, 13);
        Assert.assertEquals(actualText, expectedText, "Shopping Cart does not match");

        //Verify the Product name "Sony VAIO"
        expectedText = "Sony VAIO";
        actualText = laptopAndNotebooksPage.setVerifyTheTextSonyVIAO();
        Assert.assertEquals(actualText, expectedText, "Sony VAIO not matched");

        //Change Quantity "2"
        laptopAndNotebooksPage.changeTheQty2();

        //Click on “Update” Tab
        laptopAndNotebooksPage.clickOnUpdateButton();

        //Verify the message “Success: You have modified your shopping cart!”
        expectedText = "Success: You have modified your shopping cart!";
        actualText = laptopAndNotebooksPage.verifyUpdatedCart();
        Assert.assertEquals(actualText, expectedText, "Shopping cart does not match");

        //Verify the Total £1,472.45
        expectedText = "£1,472.45";
        actualText = laptopAndNotebooksPage.verifyTheTotal();
        Assert.assertEquals(actualText, expectedText, "Total does not match");

        //Click on “Checkout” button
        laptopAndNotebooksPage.clickOnCheckout();

        //Verify the text “Checkout”
        expectedText = "Checkout";
        actualText = laptopAndNotebooksPage.verifyTheTextCheckout();
        Assert.assertEquals(actualText, expectedText, "Checkout does not match");

        //Verify the Text “New Customer”
        expectedText = "New Customer";
        actualText = laptopAndNotebooksPage.verifyTheTextNewCustomer();
        Assert.assertEquals(actualText, expectedText, "Text does not match");

        //Click on “Guest Checkout” radio button
        laptopAndNotebooksPage.clickOnGuestCheckout();

        //Click on “Continue” tab
        laptopAndNotebooksPage.clickOnContinue();

        //Fill the mandatory fields
        laptopAndNotebooksPage.enterFirstName();
        laptopAndNotebooksPage.enterLastName();
        laptopAndNotebooksPage.enterEmail();
        laptopAndNotebooksPage.enterTelephone();
        laptopAndNotebooksPage.enterAddress1();
        laptopAndNotebooksPage.enterCity();
        laptopAndNotebooksPage.enterPostcode();
        laptopAndNotebooksPage.enterState();

        //Click on “Continue” Button
        laptopAndNotebooksPage.clickOnContinueButton();

        //Add Comments About your order into text area
        laptopAndNotebooksPage.enterComment();
        laptopAndNotebooksPage.clickOnContinueAfterComment();

        //Check the Terms & Conditions check box
        laptopAndNotebooksPage.clickCheckBox();
        Thread.sleep(1000);
        laptopAndNotebooksPage.setContinueClicking();
        laptopAndNotebooksPage.clickOnConfirmButton();

        //Verify the message “Your order has been placed!”
        expectedText = "Your order has been placed!";
        actualText = laptopAndNotebooksPage.verifyOrderPlaced();
        Assert.assertEquals(actualText, expectedText, "Order does not placed");
    }

}
