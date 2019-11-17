package com.travian.qa.UserData;

public class UserInput {

    Login Login;
    BaseVillage VillageToClickFarmList;
    String[] VillagesForWhichFarmListHasToBeClicked;


    public UserInput(com.travian.qa.UserData.Login login, BaseVillage villageToClickFarmList, String[] villagesForWhichFarmListHasToBeClicked) {
        Login = login;
        VillageToClickFarmList = villageToClickFarmList;
        VillagesForWhichFarmListHasToBeClicked = villagesForWhichFarmListHasToBeClicked;
    }

    public com.travian.qa.UserData.Login getLogin() {
        return Login;
    }

    public void setLogin(com.travian.qa.UserData.Login login) {
        Login = login;
    }

    public BaseVillage getVillageToClickFarmList() {
        return VillageToClickFarmList;
    }

    public void setVillageToClickFarmList(BaseVillage villageToClickFarmList) {
        VillageToClickFarmList = villageToClickFarmList;
    }

    public String[] getVillagesForWhichFarmListHasToBeClicked() {
        return VillagesForWhichFarmListHasToBeClicked;
    }

    public void setVillagesForWhichFarmListHasToBeClicked(String[] villagesForWhichFarmListHasToBeClicked) {
        VillagesForWhichFarmListHasToBeClicked = villagesForWhichFarmListHasToBeClicked;
    }
}
