import org.apache.commons.io.FileUtils;
import org.apache.http.client.ClientProtocolException;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import java.io.File;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;


import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

public class Basis {
	private static org.apache.log4j.Logger Log = Logger.getLogger(Basis.class);
    static {
        DOMConfigurator.configure("log4j.xml");
    }  
    static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	static SecureRandom rnd = new SecureRandom();

	private int invalidImageCount;	
//	public static WebDriver driver=new FirefoxDriver();
	public static WebDriver driver=new ChromeDriver();
///////////////////////////////////////////
	public static String baseUrl = "http://www.profilbiz.com";
	//public static String baseUrl = "http://www.bisnispages.com";
//////////////////////////////////////////	
//link
	public static String header_main_link = "//*[@id='__blaze-root']/div[2]/nav/div/div[1]/a";
	//public static String header_main_link = "//*[@id='__blaze-root']/div[2]/div/nav/div/div[1]/a/span";
	public static String header_bookmark_link = "//*[@id='navbar']/ul[2]/li[1]/a";
	public static String header_chat_link = "li:nth-child(2)>a";
	public static String header_newbiz_link = "//*[@id='navbar-collapse']/ul[2]/li/ul/li[1]/a";
	
	public static String header_login_link = "//*[@id='navbar']/ul/li[1]/a";
	public static String header_signup_link = "//*[@id='navbar']/ul/li[2]/a";
	public static String button_search_link = "//*[@id='__blaze-root']/div[3]/div[2]/div/div[2]/p[1]/a";
	
	public static String main_search_input = "//*[@id='searchParams']";
	public static String main_search_link = "//*[@id='__blaze-root']/div[3]/div[1]/div/div[2]/form/div/span/button";
	public static String main_search_button = "//*[@id='__blaze-root']/div[3]/div/div/div[1]/div/div[2]/form/div/span/button";
	
//	public static String login_link = "//*[@id='__blaze-root']/div[3]/div[2]/div/div[2]/p[2]/a[1]";
	public static String login_link = "//*[@id='navbar']/ul/li[1]/a";
	public static String signup_link = "//*[@id='__blaze-root']/div[3]/div[2]/div/div[2]/p[2]/a[2]";
	public static String search_link = "//*[@id='__blaze-root']/div[3]/div[2]/div/div[2]/p[1]/a";
//	public static String setting_account_link = "//*[@id='navbar-collapse']/ul[2]/li/a";
	
	public static String setting_account_link = "//*[@id='navbar']/ul[2]/li[3]/a";
	public static String setting_link = "//*[@id='navbar']/ul[2]/li[3]/ul/li[1]/a";
	                                    
	public static String account_link = "//*[@id='__blaze-root']/div[3]/div/div/div/div[2]/div[2]/ul/li[1]/a";
	public static String invite_link  = "//*[@id='__blaze-root']/div[3]/div/div/div/div[2]/div/ul/li[2]/a";
	public static String report_link  = "//*[@id='__blaze-root']/div[3]/div/div/div/div[2]/div/ul/li[3]/a";
	
	public static String account_biz_link = "//*[@id='navbar-collapse']/ul[2]/li/ul/li[5]/a";
	public static String create_biz_link = ".list-unstyled > li:nth-child(1) > a";
	public static String biz_bucket_view = ".bucket>p";
	public static String bizcard_profile_view = ".biz-card";
//	#__blaze-root > div.content > div > div > div > div.col-sm-8 > div > ul > li:nth-child(1) > a 
	public static String edit_bgimg_link = "//*[@id='__blaze-root']/div[3]/div/div/div/div[1]/div/div[1]/span";
	public static String edit_profile_link = "//*[@id='__blaze-root']/div[3]/div/div/div/div[1]/div/div[2]/div/span";
	//public static String edit_profile_link = "//*[@id='__blaze-root']/div[3]/div/div[1]/div/div[2]/div/span";
	public static String choose_profile_link = "//*[@id='__blaze-root']/div[3]/div/div[1]/div/div/div[2]/div/div/label";
	public static String cancel_profile_link = "//*[@id='__blaze-root']/div[3]/div/div[1]/div/div/div[2]/div/div/button[1]";
	
	public static String change_password_link = "//*[@id='__blaze-root']/div[3]/div/div/div/div[2]/div/ul/li[1]/a";
	public static String change_password_back_link = "//*[@id='changePassword']/div[4]/div[1]/a";
	public static String verify_link = "//*[@id='__blaze-root']/div[3]/div/div/div/div[2]/div/ul/li[2]/a";
	public static String invite_back_link = ".btn.btn-block.btn-black-outline";
	public static String report_back_link = "//*[@id='report-problem']/div[3]/div[1]/a";
	public static String term_link = "//*[@id='__blaze-root']/div[3]/div/div/div/div[2]/div/ul/li[4]/a";
	public static String term_back_link = "//*[@id='__blaze-root']/div[3]/div[2]/div/div/div[2]/a";
	public static String privacy_link = "//*[@id='__blaze-root']/div[3]/div/div/div/div[2]/div/ul/li[5]/a";
	public static String privacy_back_link = "//*[@id='__blaze-root']/div[3]/div[2]/div/div/div[2]/a";
	public static String deactivate_link = "//*[@id='__blaze-root']/div[3]/div/div/div/div[2]/div/ul/li[3]/a";
	public static String deactivate_back_link = "//*[@id='deactivateAccount']/div[3]/div[1]/a";
	                                         
	public static String logout_link = "//*[@id='navbar']/ul[2]/li[3]/ul/li[3]/a";
	public static String logout_back_link = "//*[@id='__blaze-root']/div[3]/div/div[2]/div/div/div/input";
	
	public static String cp_change_link = "//*[@id='changePassword']/div[4]/div[2]/button";
	public static String addbookmark_link = "//*[@id='__blaze-root']/div[3]/div/div/div/div[1]/div[2]/div/div[2]/a";
	
	public static String forgot_password_link = "//*[@id='__blaze-root']/div[3]/div/div/div/div[2]/div/div[2]/p[1]/a";

	public static String chat_link = ".btn.btn-black.btn-block.chat";
	public static String chat_title = ".media-heading";
	//public static String forgot_password_link = "//*[@id='__blaze-root']/div[3]/div/div[2]/div/div[2]/p[1]/a";
	/*public static String forgot_email_input = "//*[@id='recover-password']/div[1]/input";
	public static String forgot_password_button = "//*[@id='recover-password']/div[2]/button";*/
	public static String forgot_email_input = "//*[@id='recoverPassword']/div[1]/input";
	public static String forgot_password_button = "//*[@id='recoverPassword']/div[2]/button";

	public static String forgot_password_msg = "//*[@id='emailAddress-error']";
	
	public static String report_combo = "//*[@id='module']";
	public static String report_input = "//*[@id='problem']";
	public static String report_submit = "//*[@id='report-problem']/div[3]/div[2]/button";
	public static String report_msg = "//*[@id='problem-error']";
	
	public static String addmedia_link = ".btn.btn-black-outline.btn-add.chooseFile";
//	public static String addmedia_link = "//*[@id='__blaze-root']/div[3]/div/div[2]/div[1]/button";	
	public static String check_media = "//*[@id='grid-gallery']/section[1]/ul/li";
	public static String first_media = "//*[@id='grid-gallery']/section[1]/ul/li[2]/figure/img";
	public static String delete_media_button = "//*[@id='grid-gallery']/section[2]/ul/li[1]/figure/figcaption/button[1]";
	                                           
	public static String confirm_delete_media_button = "html/body/div[4]/button[2]";
	public static String close_media_button = "//*[@id='grid-gallery']/section[2]/nav/span[3]";
	
	public static String mediaTitle_input = "//*[@id='mediaTitle']";
	public static String mediaDesc_input = "//*[@id='mediaDesc']";
	public static String update_media_button = "//*[@id='grid-gallery']/section[2]/ul/li/figure/figcaption/button[2]";
	
	//*[@id='grid-gallery']/section[1]/ul/li[3]/figure/img
//input	
	public static String login_email_input = "//*[@id='login']/div[1]/input";
	public static String login_password_input = "//*[@id='login']/div[2]/input";
	public static String verifypassword_input = "";
	
	public static String cp_password_input = "//*[@id='changePassword']/div[1]/input";
	public static String cp_new_password_input = "//*[@id='changePassword']/div[2]/input";
	public static String cp_verifypassword_input = "//*[@id='changePassword']/div[3]/input";
	
	
	public static String reg_fullname_input = "//*[@id='signup']/div[1]/input";
	public static String reg_email_input = "//*[@id='signup']/div[2]/input";
	public static String reg_password_input = "//*[@id='password']";
	public static String reg_ver_password_input = "//*[@id='confirm-password']";
	public static String reg_submit_link = "//*[@id='signup']/div[5]/input";
	
	public static String invite_email_input = "//*[@id='emailAddress']";

	public static String bisnisname_input = "//*[@id='bizName']";
	public static String headlinebisnis_input = "//*[@id='headline']";
	public static String editheadlinebisnis_input = "//*[@id='bizHeadline']";
	
	public static String deactivate_email_input = "//*[@id='deactivateAccount']/div[1]/input";
	public static String deactivate_password_input = "//*[@id='deactivateAccount']/div[2]/input";
	
	public static String chatMessage_input = "#chatMessage";
	public static String sendMessage_button = ".btn.btn-lg.btn-black-outline";
//submit
	public static String login_submit="//*[@id='login']/div[3]/button";
//	public static String login_submit="//*[@id='login']/div[3]/input";
	public static String invite_submit=".btn.btn-block.btn-black.btn-loading";
	public static String signup_submit=".btn.btn-black.btn-loading";
	public static String createbisnis_submit="#bizForm > div:nth-child(3) > button";
//	public static String createbisnis_submit="//*[@id='bizForm']/div[3]/input";
	public static String profile_logo_submit="//*[@id='__blaze-root']/div[3]/div/div/div/div[1]/div/div/div[2]/div/div/button[3]";	
	public static String profile_bg_submit  ="//*[@id='__blaze-root']/div[3]/div/div/div/div[1]/div/div/div[2]/div/div/button[3]";
	public static String upload_submit="//*[@id='__blaze-root']/div[3]/div/div/div/div[1]/div/div/div[2]/div/div/button[3]";
	
	public static String verify_submit=".btn.btn-block.btn-black.btn-loading";
	public static String verifycancel_submit=".btn.btn-block.btn-black-outline";

	public static String deactivate_submit="//*[@id='deactivateAccount']/div[3]/div[2]/button";
	public static String deactivatecancel_submit="//*[@id='deactivateAccount']/div[3]/div[1]/a";
	//message	
	public static String email_login_msg="//*[@id='emailAddress-error']";
	public static String password_login_msg="//*[@id='password-error']";

	public static String bert_msg="//*[@id='__blaze-root']/div[1]/div/div[2]/p";
	public static String bert2_msg="html/body/div[1]/div/div[2]";

	public static String reg_fullname_msg="//*[@id='fullname-error']";
	public static String reg_email_msg="//*[@id='emailAddress-error']";
	public static String reg_password_msg="//*[@id='password-error']";
	public static String reg_confirm_password_msg="//*[@id='confirm-password-error']";

	public static String list_count_msg="//*[@id='__blaze-root']/div[3]/p";
	
	public static String term_msg="//*[@id='__blaze-root']/div[3]/div[1]/div/div";
	public static String privacy_msg="//*[@id='__blaze-root']/div[3]/div[1]/div/div";
	
	public static String cp_oldpassword_msg="//*[@id='oldPassword-error']";
	public static String cp_newpassword_msg="//*[@id='newPassword-error']";
	public static String cp_repeatnewpassword_msg="//*[@id='repeatNewPassword-error']";
	
	public static String invite_msg="//*[@id='emailAddress-error']";
	
	public static String email_deactivate_msg="//*[@id='email-error']";
	public static String password_deactivate_msg="//*[@id='password-error']";
/////////////////view/////////////////////////
	//public static String list_card_view="//*[@id='__blaze-root']/div[3]/div[2]/div/div[1]/div";
//	public static String list_card_view="//*[@id='__blaze-root']/div[3]/div[2]/div/div";
	public static String list_card_view="//*[@id='__blaze-root']/div[3]/div/div/div[2]/div/div";

	
	public static String biz_bgimg_list_card_view1="//*[@id='__blaze-root']/div[3]/div/div/div[2]/div/div[";
	public static String biz_bgimg_list_card_view2="]/div";
	public static String biz_primg_list_card_view1="//*[@id='__blaze-root']/div[3]/div[2]/div/div[";
	public static String biz_primg_list_card_view2="]/div/div[2]/div[1]/img";
	/*
	public static String biz_title_list_card_view1="//*[@id='__blaze-root']/div[3]/div[2]/div/div[";
	public static String biz_title_list_card_view2="]/div/div[3]/h4";
	public static String biz_headline_list_card_view1="//*[@id='__blaze-root']/div[3]/div[2]/div/div[";
	public static String biz_headline_list_card_view2="]/div/div[3]/p";
*/
	//*[@id='__blaze-root']/div[3]/div/div/div[2]/div/div[1]/div/div[3]/h4
	//*[@id='__blaze-root']/div[3]/div/div/div[2]/div/div[1]/div/div[3]/p
	public static String biz_title_list_card_view1="//*[@id='__blaze-root']/div[3]/div/div/div[2]/div/div[";
	public static String biz_title_list_card_view2="]/div/div[3]/h4";
	public static String biz_headline_list_card_view1="//*[@id='__blaze-root']/div[3]/div/div/div[2]/div/div[";
	public static String biz_headline_list_card_view2="]/div/div[3]/p";

	
	public static String setting_bgimg_view="//*[@id='__blaze-root']/div[3]/div/div[1]/div/div[1]/img";
	public static String setting_profil_view="//*[@id='__blaze-root']/div[3]/div/div[1]/div/div[2]/div/img";
	public static String setting_name_view="//*[@id='fullName']";
	public static String setting_email_view="//*[@id='bizHeadline']";		
	///*[@id='__blaze-root']/div[3]/div[2]/div/div[ 2 ]/div/div[3]/p
	///*[@id='__blaze-root']/div[3]/div[2]/div/div[ 3 ]/div/div[3]/p
	
	
	
	
/////////////////VARIABLE/////////////////////////
	
//////////////////////////////////////////
	
/////////////////DATA/////////////////////////

	public static int shortTimeout=1000;
	public static int standardTimeout=3000;
	public static int mediumTimeout=5000;
	public static int longTimeout=10000;	
	
//	public static String newUserName="demo0";
// public static String newUserId="demo0@workedprofile.com";
///	public static String newUserName="demo1";
//	public static String newUserId="demo1@workedprofile.com";
	public static String newUserName="eprofilebiz";
    public static String newUserId="eprofilebiz@gmail.com";
	public static String passwordNewUser="password";
	public static String verifiedPasswordNewUser="password";
	
	public static String userId=newUserId;

//	public static String userId="teamwp911@gmail.com";
	public static String passwordUser="password";

	
	public static String oldpassword="password";
	public static String newpassword="newpassword";
	public static String verifiedNewPassword="newpassword";

	public static String oldpassword1="newpassword";
	public static String newpassword1="password";
	public static String verifiedNewPassword1="password";
	//public static String verifiedPasswordNewUser="password";

	//public static String newUserId="demo@workedprofile.com";
	
	//public static String inviteFriend="eprofilebiz@gmail.com";
	//public static String inviteFriend="teamwp911@gmail.com";
	public static String inviteFriend="sansuardy@yahoo.com";
	
	public static String findBiz="sansuardy";
//	public static String findBiz="amari";
	
    public static String profilePicture = "/Users/wp/Desktop/selenium/brantas.jpg";
    public static String profileBackground = "/Users/wp/Desktop/selenium/background.jpg";
    public static String logoPicture = "/Users/wp/Desktop/selenium/wp.jpg";
    public static String bisnisBackground = "/Users/wp/Desktop/selenium/kartunis.jpg";
    

    public static String product1_img = "/Users/wp/Desktop/selenium/product1.jpg";

    public static String product2_img = "/Users/wp/Desktop/selenium/product2.jpg";
//////////////////////////////////////////
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	System.setProperty("webdriver.chrome.driver", "/Users/wp/Downloads/chromedriver");
	
	String browser="Chrome";
	//String browser="Mozilla";
	
	WebDriver driver=null;
	if(browser.equals("Mozilla"))
		driver=new FirefoxDriver();
	else if (browser.equals("Chrome"))
	    driver = new ChromeDriver();
	driver.get("https://www.profilbiz.com");
	//new FirefoxDriver();	
	}
	
	 public static void HighlightMyElement(WebElement findElement,boolean klik) {
	    	
	    //	Log.info(findElement);
		// findElement.replace("Basis.driver.findElement","");
		for (int i = 0; i < 10; i++) 
		  { 
		   JavascriptExecutor javascript = (JavascriptExecutor) driver;
		   javascript.executeScript("arguments[0].setAttribute('style', arguments[1]);", findElement, "color: orange; border: 4px solid orange;");
		   } 
		if (klik){
			
			findElement.click();	
		}
	 
	 }

	 public static String checkMessageList(String Xpath) {
	    String mesg="";	   
	  //  Log.info(Xpath);
		 if (driver.findElements(By.xpath(Xpath)).size() >0 ) {	
			 mesg= driver.findElement(By.xpath(Xpath)).getText();	
		}
		 return mesg;
	 }
	 
	 public static String checkCssMessageList(String Css) {
		    String mesg="";	   
		  //  Log.info(Css);
			 if (driver.findElements(By.cssSelector(Css)).size() >0 ) {	
				 mesg= driver.findElement(By.cssSelector(Css)).getText();	
			}
			 return mesg;
		 }	 
	 public static String checkTAMessageList(String Xpath) {
		    String mesg="";	   
		  //  Log.info(Xpath);
			 if (driver.findElements(By.xpath(Xpath)).size() >0 ) {	
				 mesg= driver.findElement(By.xpath(Xpath)).getAttribute("value");;	
			}
			 return mesg;
		 }	 
	 public static int checkCardList(String Xpath) {
		    int mesg=0;	   
			 if (driver.findElements(By.xpath(Xpath)).size() >0 ) {	
				 mesg= driver.findElements(By.xpath(Xpath)).size();	
			}
			 return mesg;
		 }

	 public static void inputData(String Xpath,String Data) {
		     Log.info("Data yang di input : "+Data); 
			 if (driver.findElements(By.xpath(Xpath)).size() >0 ) {	
				 Basis.HighlightMyElement(Basis.driver.findElement(By.xpath(Xpath)),false);	
				 Basis.driver.findElement(By.xpath(Xpath)).clear();	
				 Basis.driver.findElement(By.xpath(Xpath)).sendKeys(Data);
			 }
		 }
	 public static void inputDataCss(String Css,String Data) {
	     Log.info("Data yang di input : "+Data); 
		 if (driver.findElements(By.cssSelector(Css)).size() >0 ) {	
			 Basis.HighlightMyElement(Basis.driver.findElement(By.cssSelector(Css)),false);	
			 Basis.driver.findElement(By.cssSelector(Css)).clear();	
			 Basis.driver.findElement(By.cssSelector(Css)).sendKeys(Data);
		 }
	 }			 	 
		 	 
	 public static void signout() {
	    	try {
	    		
		    	HighlightMyElement(driver.findElement(By.xpath(Basis.setting_account_link)),true);   		       	

    		    Thread.sleep(Basis.standardTimeout);
		    	HighlightMyElement(driver.findElement(By.xpath(Basis.logout_link)),true);
	    	} catch(Exception e) {    		
				//Log.error("link error !");
				}
	    }
	 
	 public static void bisnisListToAccountSetting() {
	    	try {
	    		Log.info("in bisnisListToAccountSetting function");
		    	HighlightMyElement(driver.findElement(By.xpath(Basis.setting_account_link)),true);
		    	Thread.sleep(Basis.standardTimeout);
	    		HighlightMyElement(driver.findElement(By.xpath(Basis.setting_link)),true);
		    	/*Thread.sleep(Basis.standardTimeout);
		    	if (driver.findElements(By.xpath(Basis.account_biz_link)).size() >0 ) {
		    		Log.info("User sudah Ada biz");
		    		HighlightMyElement(driver.findElement(By.xpath(Basis.account_biz_link)),true);
		    	}else{
		    		Log.info("User belum Ada biz");
		    		HighlightMyElement(driver.findElement(By.xpath(Basis.account_link)),true);
		    	}*/

	    	} catch(Exception e) {    		
				//Log.error("link error !");
				}
	    }

	 public static void captureScreenshot(WebDriver driver,String screenshotName) {
	    try {
	    	TakesScreenshot ts=(TakesScreenshot)driver;
	    	File source=ts.getScreenshotAs(OutputType.FILE);
	    	FileUtils.copyFile(source, new File("./Screenshots/"+screenshotName+".png") );
	    	Log.info("Screenshot taken !");	

	    } catch(Exception e) {    		
	    	Log.info("Exception while Screenshot taken !");	
		}
	}

	   public static void delCookies(){
		      Basis.driver.navigate().to(Basis.baseUrl);
		      Basis.driver.manage().deleteAllCookies();
	   }
	  
    public static void checkingImage() throws ClientProtocolException, IOException {
    	
    	EventFiringWebDriver eventFiringWebDriver = new EventFiringWebDriver (driver);

    	// Storing all the image elemt  in the variable allImages
    	List<WebElement> allImages =  eventFiringWebDriver.findElements(By.tagName("img"));
    	int countBrokenImages = 0;

    	// Declaring a dynamic  string of array which will store src of all the broken images
    	List<String> BrokenimageUrl = new ArrayList<String>();

    	String script = "return (typeof arguments[0].naturalWidth!=\"undefined\" &&  arguments[0].naturalWidth>0)";

    	for (WebElement image : allImages) 
    	{   
    	    Object imgStatus = eventFiringWebDriver.executeScript(script, image);          
    		if(imgStatus.equals(false)){
    			
    			String  currentImageUrl = image.getAttribute("src");
    			String imageUrl = currentImageUrl ;
    	                BrokenimageUrl.add(imageUrl);
    	                countBrokenImages++;
    	      }
    	}
    	//String url = driver.getCurrentUrl();
    	// Printing the src of the broken images if any
    	if (countBrokenImages>0){
    	Log.error("Number of broken images found in the page "+ driver.getCurrentUrl() + " : " +countBrokenImages);
    	}
    	else{
    	Log.info("images found in the page or no broken images.");	
    	}
    	for (String z : BrokenimageUrl) 
    	{
    	    Log.error(z);
    	}

    }
	     
	public static void validateInvalidImages() {
		try {
			int invalidImageCount = 0;
			List<WebElement> imagesList = driver.findElements(By.tagName("img"));
			System.out.println("Total no. of images are " + imagesList.size());
			for (WebElement imgElement : imagesList) {
				if (imgElement != null) {
					//verifyimageActive(imgElement);
					HttpClient client = HttpClientBuilder.create().build();
					HttpGet request = new HttpGet(imgElement.getAttribute("src"));
					String requestSrc=imgElement.getAttribute("src");
					//Log.info("request   "+requestSrc);
					if (requestSrc.contains("data:")){
						Log.info("not yet uploaded images");
					}else{					
					HttpResponse response = client.execute(request);
					Log.info("already uploaded images");
					if (response.getStatusLine().getStatusCode() != 200)
						invalidImageCount++;
						
					}
				}
			}
			System.out.println("Total no. of invalid images are "	+ invalidImageCount);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
	public static void verifyimageActive(WebElement imgElement) {
		try {
			HttpClient client = HttpClientBuilder.create().build();
			HttpGet request = new HttpGet(imgElement.getAttribute("src"));
			//Log.info("request   "+request);
			HttpResponse response = client.execute(request);
			// verifying response code he HttpStatus should be 200 if not,
			// increment as invalid images count
		//	if (response.getStatusLine().getStatusCode() != 200)
		//		invalidImageCount++;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	

	public static 	String randomString( int len ){
		
	   StringBuilder sb = new StringBuilder( len );
	   for( int i = 0; i < len; i++ ) 
	      sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
	   return sb.toString();
	}
	
	public static int randInt(int min, int max) {

	    int randomNum =ThreadLocalRandom.current().nextInt(min, max + 1);
	    return randomNum;
	}
}
