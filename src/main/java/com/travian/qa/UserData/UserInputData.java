package com.travian.qa.UserData;

public class UserInputData {
    UserInput UserInput;

    public UserInputData(com.travian.qa.UserData.UserInput userInput) {
        UserInput = userInput;
    }

    public com.travian.qa.UserData.UserInput getUserInput() {
        return UserInput;
    }

    public void setUserInput(com.travian.qa.UserData.UserInput userInput) {
        UserInput = userInput;
    }
}
