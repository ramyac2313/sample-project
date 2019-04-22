package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Filters_NewUserPage extends  BasePage {

    public Filters_NewUserPage(WebDriver driver) {
        super(driver);
    }

    //baser url
    String baseURL = "http://ec2-54-84-52-184.compute-1.amazonaws.com:8080/admin";


    @FindBy(how=How.XPATH, using = "//a[@href='/admin/users']")
    private WebElement menuusers;

    @FindBy(how=How.XPATH, using = "//html/head/title")
    private WebElement gettitles;

    @FindBy(how=How.XPATH, using = "//div[@id='filters_sidebar_section']/h3")
    private WebElement lblfilter;
    @FindBy(how=How.XPATH, using = "//label[@for='q_username']")
    private WebElement lblusername;
    @FindBy(how=How.XPATH, using = "//label[@for='q_email']")
    private WebElement lblemail;
    @FindBy(how=How.XPATH, using = "//label[contains(text(),'Created at')]")
    private WebElement lblcreated;
    @FindBy(how=How.XPATH, using = "//label[@for='q_username']/..//select")
    private WebElement selusername;
    @FindBy(how=How.XPATH, using = "//input[@id='q_username']")
    private WebElement inputusername;
    @FindBy(how=How.XPATH, using = "//label[@for='q_email']/parent::div//select")
    private WebElement selectemail;
    @FindBy(how=How.XPATH, using = "//input[@id='q_email']")
    private WebElement inputemail;
    @FindBy(how=How.XPATH, using = "//input[@id='q_created_at_gteq_datetime']")
    private WebElement inputfromdate;
    @FindBy(how=How.XPATH, using = "//input[@id='q_created_at_lteq_datetime']")
    private WebElement inputtodate;

    @FindBy(how=How.XPATH, using = "//input[@name='commit']")
    private WebElement btnfilter;

    @FindBy(how=How.XPATH, using = "//a[@class='clear_filters_btn']")
    private WebElement btnclearfilter;


    public WebElement getMenuusers() {
        return menuusers;
    }

    public WebElement getGettitles() {
        return gettitles;
    }

    public WebElement getLblfilter() {
        return lblfilter;
    }

    public WebElement getLblusername() {
        return lblusername;
    }

    public WebElement getLblemail() {
        return lblemail;
    }

    public WebElement getLblcreated() {
        return lblcreated;
    }

    public WebElement getSelusername() {
        return selusername;
    }

    public WebElement getInputusername() {
        return inputusername;
    }

    public WebElement getSelectemail() {
        return selectemail;
    }

    public WebElement getInputemail() {
        return inputemail;
    }

    public WebElement getInputfromdate() {
        return inputfromdate;
    }

    public WebElement getInputtodate() {
        return inputtodate;
    }

    public WebElement getBtnfilter() {
        return btnfilter;
    }

    public WebElement getBtnclearfilter() {
        return btnclearfilter;
    }

    public WebElement getLblsearchresult() {
        return lblsearchresult;
    }

    public WebElement getLblsearchstatuusername() {
        return lblsearchstatuusername;
    }

    public WebElement getLblsearchstatuemail() {
        return lblsearchstatuemail;
    }

    public WebElement getLblsearchstatufromdt() {
        return lblsearchstatufromdt;
    }

    public WebElement getLblsearchstatutodt() {
        return lblsearchstatutodt;
    }

    public WebElement getLblsearchstusnodatafound() {
        return lblsearchstusnodatafound;
    }

    @FindBy(how=How.XPATH, using = "//div[@id='search-status-_sidebar_section']/h3")
    private WebElement lblsearchresult;

    @FindBy(how=How.XPATH, using = "//div[@id='search-status-_sidebar_section']//ul//li[contains(@class,'username')]/b")
    private WebElement lblsearchstatuusername;

    @FindBy(how=How.XPATH, using = "//div[@id='search-status-_sidebar_section']//ul//li[contains(@class,'email')]/b")
    private WebElement lblsearchstatuemail;
    @FindBy(how=How.XPATH, using = "//div[@id='search-status-_sidebar_section']//ul//li[contains(@class,'gteq')]/b")
    private WebElement lblsearchstatufromdt;
    @FindBy(how=How.XPATH, using = "//div[@id='search-status-_sidebar_section']//ul//li[contains(@class,'lteq')]/b")
    private WebElement lblsearchstatutodt;

    @FindBy(how=How.XPATH, using = "//span[contains(text(),'No Users found')]")
    private WebElement lblsearchstusnodatafound;

    public WebElement getlblsearchstusnodatafound() {
        return lblsearchstusnodatafound;
    }

    @FindBy(how=How.XPATH, using = "//span[contains(text(),'Created at greater or equal to')]")
    private WebElement lblsearchstusdate;

    public WebElement getLblsearchstusdate() {
        return lblsearchstusdate;
    }

    public void Openhomepage(){
        driver.get(baseURL);
    }




    @FindBy(how=How.XPATH, using = "//a[@href='/admin/users/new']")
    private WebElement btnNewUsers;

    @FindBy(how=How.XPATH, using = "//input[@id='user_username']")
    private WebElement inputUsersname;

    @FindBy(how=How.XPATH, using = "//input[@id='user_password']")
    private WebElement inputPassword;

    @FindBy(how=How.XPATH, using = "//input[@id='user_email']")
    private WebElement inputemailnewuser;

    @FindBy(how=How.XPATH, using = "//input[@name='commit']")
    private WebElement btncreateuser;


    @FindBy(how=How.XPATH, using = "//div[@class='flash flash_notice']")
    private WebElement lblSaveed;





    public String getBaseURL() {
        return baseURL;
    }

    public WebElement getBtnNewUsers() {
        return btnNewUsers;
    }

    public WebElement getInputUsersname() {
        return inputUsersname;
    }

    public WebElement getInputPassword() {
        return inputPassword;
    }

    public WebElement getinputemailnewuser() {
        return inputemailnewuser;
    }

    public WebElement getBtncreateuser() {
        return btncreateuser;
    }

    public WebElement getLblSaveed() {
        return lblSaveed;
    }





}
