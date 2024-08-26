package com.NinjaOne.pages;

import com.NinjaOne.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage extends BasePage{

    public LogInPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath="//*[@id='root']/div/div/div/form/div[1]/label")
    public WebElement email;

    @FindBy(xpath="//input[@autocomplete='username']")
    public WebElement emailInputBox;

    @FindBy(xpath="//*[@id='root']/div/div/div/form/div[2]/div/label")
    public  WebElement password;

    @FindBy(xpath="//*[@id='root']/div/div/div/form/div[2]/div/input")
    public  WebElement passwordInputBox;

    @FindBy(xpath="//*[@id='root']/div/div/div/form/button")
    public WebElement sinInButton;

    @FindBy(xpath= "//div[@class='alert alert-danger css-xlp8fa e1vjstjx0']")
    public WebElement errorMessage;


}




