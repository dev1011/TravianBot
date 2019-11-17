package com.travian.qa.pages;

import com.travian.qa.base.TestBase;
import net.bytebuddy.utility.RandomString;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Random;

public class FarmListPage extends TestBase {

    public FarmListPage() {
        PageFactory.initElements(driver, this);
        WaitTillElementLoads(driver, userNameInputBox);
    }


    @FindBy(xpath = "//input[@name='name']")
    WebElement userNameInputBox;

    @FindBy(xpath = "//input[@name='password']")
    WebElement passwordInputBox;


    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginButton;

    public void login(String userName, String password) {
        userNameInputBox.clear();
        userNameInputBox.sendKeys(userName);

        passwordInputBox.clear();
        passwordInputBox.sendKeys(password);

        loginButton.click();
        waitRandom();
    }


    @FindBy(xpath = "//li[@class='villageBuildings']")
    WebElement villageBuildings;

    public void gotoBuildings() {

        villageBuildings.click();
    }

    @FindBy(xpath = "//li[@class='villageResources']")
    WebElement villageResources;

    public void gotovillageResources() {
        waitRandom();
        villageResources.click();
    }

    public void OpenRandomBuildings() {

        try {
            waitRandom();
            gotoBuildings();
            waitRandom();
            List<WebElement> allBuildings = driver.findElements(By.xpath("//div[contains(@class,'buildingSlot') and contains(@class,'aid')]//preceding-sibling::div/div[@class='labelLayer']"));
            int buildingCount = allBuildings.size();

            System.out.println("buildingCount " + buildingCount);
            Random random = new Random();
            int n = random.ints(1, 1, buildingCount).findFirst().getAsInt();

            int randomize = buildingCount;
            if (buildingCount > n)
                randomize = buildingCount / n;

            for (int i = 1; i <= randomize; i = i++) {
                int waitTime = random.ints(1, 2000, 7000).findFirst().getAsInt();
                try {
                    Thread.sleep(waitTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                int buildingToClick = random.ints(1, 0, buildingCount).findFirst().getAsInt();

                allBuildings = driver.findElements(By.xpath("//div[contains(@class,'buildingSlot') and contains(@class,'aid')]//preceding-sibling::div/div[@class='labelLayer']"));
                allBuildings.get(buildingToClick).click();

                waitTime = random.ints(1, 2000, 7000).findFirst().getAsInt();
                try {
                    Thread.sleep(waitTime);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                gotoBuildings();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void OpenRandomNavigationTabs() {

        try {
            List<WebElement> allTabs = driver.findElements(By.xpath("//ul[@id='navigation']/li[not(contains(@class,'gold')) and not(contains(@class,'clear'))]"));

            int tabCount = allTabs.size();

            Random random = new Random();
            int n = random.ints(1, 3, 6).findFirst().getAsInt();

            int randomize = tabCount;
            if (tabCount > n)
                randomize = tabCount / n;

            for (int i = 1; i <= randomize; i++) {
                int waitTime = random.ints(1, 2000, 7000).findFirst().getAsInt();
                try {
                    Thread.sleep(waitTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


                int tabToClick = random.ints(1, 0, tabCount).findFirst().getAsInt();


                allTabs = driver.findElements(By.xpath("//ul[@id='navigation']/li[not(contains(@class,'gold')) and not(contains(@class,'clear'))]"));
                allTabs.get(tabToClick).click();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static void getStreamOfRandomIntsWithRange(int num, int min, int max) {
        Random random = new Random();
        random.ints(num, min, max).sorted().forEach(System.out::println);
    }


    public void selectVillage() {
        waitRandom();
        String villageName = userInputData.getUserInput().getVillageToClickFarmList().getVillageName();
        driver.findElement(By.xpath("//div[@id='sidebarBoxVillagelist']//div[@class='name' and contains(.,'" + villageName + "')]")).click();
    }

    @FindBy(xpath = "//img[@class='building g16']//preceding-sibling::div/div[@class='labelLayer']")
    WebElement rallyPointBuilding;

    @FindBy(xpath = "//img[contains(@class,'unit')][1]")
    WebElement UnitsOnResourcesPage;

    public void gotoRallyPoint() {
        waitRandom();
        UnitsOnResourcesPage.click();
    }


    @FindBy(xpath = "//a[@class='tabItem' and contains(.,'Farm List')]")
    WebElement farmListTab;

    public void gotoFarmListTab() {
        waitRandom();
        farmListTab.click();
    }

    public void sendFarmList() throws InterruptedException {

        gotovillageResources();
        gotoRallyPoint();
        gotoFarmListTab();

        String[] villageNames = userInputData.getUserInput().getVillagesForWhichFarmListHasToBeClicked();

        for (String villageName: villageNames
             ) {

            waitRandom();
            String xPath_CheckAll = "//div[@class='listTitleText' and contains(.,'" + villageName + "')]//parent::div//following-sibling::div[contains(@class,'listContent')]//input[@class='markAll check']";

            driver.findElement(By.xpath(xPath_CheckAll)).click();
            waitRandom();

            String xPath_StartRaidButton = "//div[@class='listTitleText' and contains(.,'" + villageName + "')]//parent::div//following-sibling::div[contains(@class,'listContent')]//button[@type='submit']";
//            driver.findElement(By.xpath(xPath_StartRaidButton)).click();

        }


    }

    public void waitRandom(){
        Random random = new Random();
        int waitTime = random.ints(1, 3000, 10000).findFirst().getAsInt();
        System.out.println("waitTime  :  " + waitTime);
        try {
            Thread.sleep(waitTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}

