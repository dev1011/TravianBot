package com.travian.qa.tests;

import com.travian.qa.base.TestBase;
import com.travian.qa.pages.*;
import org.testng.annotations.Test;

import java.util.Random;

public class FarmList extends TestBase {

    FarmListPage farmListPage;
    HomePage homePage;
    ProductListPage productListPage;
    ProductDescriptionPage productDescriptionPage;
    CheckOutPage checkOutPage;

    public FarmList() {
        super();


    }

    @Test
    public void test() throws InterruptedException {

        System.out.println("Test Started...!!!");
        Random random = new Random();


        farmListPage = new FarmListPage();
        farmListPage.login(userInputData.getUserInput().getLogin().getName(), userInputData.getUserInput().getLogin().getPassword());

        farmListPage.waitRandom();
        farmListPage.selectVillage();
        int n = random.ints(1, 3, 10).findFirst().getAsInt();
        
        if (n % 2 == 0)
            farmListPage.OpenRandomBuildings();
        else
            farmListPage.OpenRandomNavigationTabs();


        farmListPage.waitRandom();
        farmListPage.sendFarmList();
        farmListPage.waitRandom();


        driver.close();
        driver.quit();
        System.out.println("Test Finished...!!!");
    }


}
