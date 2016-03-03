import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.http.client.ClientProtocolException;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class TestBPNG {
		private static org.apache.log4j.Logger Log = Logger.getLogger(TestBPNG.class);
    
    static {
        DOMConfigurator.configure("log4j.xml");
    }    
	
	@BeforeTest
	 public void before(){
		System.setProperty("webdriver.chrome.driver", "/Users/wp/Downloads/chromedriver");	
		Basis.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Basis.driver.manage().window().maximize();
	}	
	
	@Test(priority=1)
	 public void viewnologin() throws InterruptedException, ClientProtocolException, IOException{
		Basis.delCookies();
	    Log.info("****************************************************************************************");
	    Log.info("****************************************************************************************"); 
	    Log.info("$$$$$$$$$$$$$$$$$$$$$        Testing viewnologin         $$$$$$$$$$$$$$$$$$$$$$$$$");
	    Log.info("****************************************************************************************"); 
	    Log.info("****************************************************************************************"); 
	 
		Basis.driver.get(Basis.baseUrl);
		Basis.HighlightMyElement(Basis.driver.findElement(By.xpath(Basis.login_link)),true);
		Basis.HighlightMyElement(Basis.driver.findElement(By.xpath(Basis.header_main_link)),true);
		Basis.HighlightMyElement(Basis.driver.findElement(By.xpath(Basis.header_signup_link)),true);
		Basis.HighlightMyElement(Basis.driver.findElement(By.xpath(Basis.header_main_link)),true);
		Thread.sleep(Basis.standardTimeout);
	 //   Log.info("Nr list message : "+ Basis.checkMessageList(Basis.list_count_msg) );
	    Log.info("Nr Biz list : "+ Basis.checkCardList(Basis.list_card_view));
	    checkbizcard(Basis.checkCardList(Basis.list_card_view));
	    Thread.sleep(Basis.standardTimeout);
		Basis.validateInvalidImages();
	    bizsearch("");
	    Thread.sleep(Basis.standardTimeout);
	    bizsearch(Basis.findBiz);
	    Thread.sleep(Basis.standardTimeout);
	    Basis.validateInvalidImages();
	}
	
	@Test(priority=2)
	 public void register(){
		Basis.delCookies();
	    Log.info("****************************************************************************************");
	    Log.info("****************************************************************************************"); 
	    Log.info("$$$$$$$$$$$$$$$$$$$$$        Testing register         $$$$$$$$$$$$$$$$$$$$$$$$$");
	    Log.info("****************************************************************************************"); 
	    Log.info("****************************************************************************************"); 
 		childregister("","","","",false);
		childregister(Basis.newUserName,Basis.newUserId,Basis.passwordNewUser,"wrongpassword",false);
		childregister(Basis.newUserName,Basis.newUserId,Basis.passwordNewUser,Basis.verifiedPasswordNewUser,true);
		
	}
	
	@Test(priority=3)
	 public void forgotpassword() throws InterruptedException, ClientProtocolException, IOException{
		Basis.delCookies();
	    Log.info("****************************************************************************************");
	    Log.info("****************************************************************************************"); 
	    Log.info("$$$$$$$$$$$$$$$$$$$$$        Testing forgotpassword         $$$$$$$$$$$$$$$$$$$$$$$$$");
	    Log.info("****************************************************************************************"); 
	    Log.info("****************************************************************************************"); 
	 	
	    Basis.driver.get(Basis.baseUrl);
		
		Basis.HighlightMyElement(Basis.driver.findElement(By.xpath(Basis.login_link)),true);
		Basis.HighlightMyElement(Basis.driver.findElement(By.xpath(Basis.forgot_password_link)),true);
		Basis.inputData(Basis.forgot_email_input,"");
		Basis.HighlightMyElement(Basis.driver.findElement(By.xpath(Basis.forgot_password_button)),true);
	    Log.info("forgot password message : "+ Basis.checkMessageList(Basis.forgot_password_msg) );
	    Log.info("forgot password Bert message : "+ Basis.checkMessageList(Basis.bert_msg) );
	    
	    Basis.inputData(Basis.forgot_email_input,"wpemail");
	    Basis.HighlightMyElement(Basis.driver.findElement(By.xpath(Basis.forgot_password_button)),true);
	    Log.info("forgot password message : "+ Basis.checkMessageList(Basis.forgot_password_msg) );
	    Log.info("forgot password Bert message : "+ Basis.checkMessageList(Basis.bert_msg) );
	    
	    Basis.inputData(Basis.forgot_email_input,"wpemail@");
	    Basis.HighlightMyElement(Basis.driver.findElement(By.xpath(Basis.forgot_password_button)),true);
	    Log.info("forgot password message : "+ Basis.checkMessageList(Basis.forgot_password_msg) );
	    Log.info("forgot password Bert message : "+ Basis.checkMessageList(Basis.bert_msg) );
	    
	    Basis.inputData(Basis.forgot_email_input,"wpemail@wp");
	    Basis.HighlightMyElement(Basis.driver.findElement(By.xpath(Basis.forgot_password_button)),true);
	    Log.info("forgot password message : "+ Basis.checkMessageList(Basis.forgot_password_msg) );
		Thread.sleep(Basis.standardTimeout);
		
	    Basis.inputData(Basis.forgot_email_input,Basis.newUserId);
	    Basis.HighlightMyElement(Basis.driver.findElement(By.xpath(Basis.forgot_password_button)),true);
	    Log.info("forgot password message : "+ Basis.checkMessageList(Basis.forgot_password_msg) );
		Thread.sleep(Basis.standardTimeout);
		Basis.validateInvalidImages();
		Log.info("forgot password Bert message : "+ Basis.checkMessageList(Basis.bert2_msg) );	
		
	}
	
	@Test(priority=4)
	 public void login(){
		Basis.delCookies();
		try {

	    Log.info("****************************************************************************************");
	    Log.info("****************************************************************************************"); 
	    Log.info("$$$$$$$$$$$$$$$$$$$$$        Testing login         $$$$$$$$$$$$$$$$$$$$$$$$$");
	    Log.info("****************************************************************************************"); 
	    Log.info("****************************************************************************************"); 
	 	Log.info("Testing Login with wrong account in WP");    
		loginTC("teamwp@gmail.com","password",false);
		Log.info("Testing Login with wrong password");
        loginTC("sansuardy@gmail.com","12345678",false);
        Log.info("Testing Login with format email yang salah");
		loginTC("@gmail.com","password",false);
		Log.info("Testing Login with account dan password yang betul");
		loginTC(Basis.userId,Basis.passwordUser,true);	

        Basis.signout();
	    Thread.sleep(Basis.standardTimeout);
		Log.info("Bert message : "+ Basis.checkMessageList(Basis.bert_msg) );
		
		} catch (InterruptedException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
	}

	
@Test(priority=5)
	public void checkSettingDetail() throws InterruptedException{
	headerFunction("checkSettingDetail");
	Basis.bisnisListToAccountSetting();

	Basis.HighlightMyElement(Basis.driver.findElement(By.linkText("Undang Teman")),true);
	Basis.inputData(Basis.invite_email_input,"wpemail");
	Basis.HighlightMyElement(Basis.driver.findElement(By.cssSelector(Basis.invite_submit)),true);
	Log.info("invite message : "+ Basis.checkMessageList(Basis.invite_msg) );
	Log.info("Bert message : "+ Basis.checkMessageList(Basis.bert_msg) );
	  
	Basis.inputData(Basis.invite_email_input,"wpemail@");
	Basis.HighlightMyElement(Basis.driver.findElement(By.cssSelector(Basis.invite_submit)),true);
	Log.info("invite message : "+ Basis.checkMessageList(Basis.invite_msg) );
	Log.info("Bert message : "+ Basis.checkMessageList(Basis.bert_msg) );	
	  
	Basis.inputData(Basis.invite_email_input,Basis.inviteFriend);
	Basis.HighlightMyElement(Basis.driver.findElement(By.cssSelector(Basis.invite_submit)),true);
	Log.info("invite message : "+ Basis.checkMessageList(Basis.invite_msg) );
	Thread.sleep(Basis.standardTimeout);

	Log.info("invite Bert message : "+ Basis.checkMessageList(Basis.bert_msg) );	
	Thread.sleep(Basis.standardTimeout);
	if (Basis.driver.findElements(By.cssSelector(Basis.invite_back_link)).size() > 0 ){
    Basis.HighlightMyElement(Basis.driver.findElement(By.cssSelector(Basis.invite_back_link)),true);
	}
    reportproblem("Profil");
    reportproblem("Bisnis");
    reportproblem("User");
    reportproblem("Bookmark");
    reportproblem("Pengaturan");
    reportproblem("Lainnya");

	Thread.sleep(Basis.standardTimeout);
	Basis.HighlightMyElement(Basis.driver.findElement(By.linkText("Syarat dan Ketentuan")),true);
	Thread.sleep(Basis.standardTimeout); 
	Log.info("Term message : "+ Basis.checkMessageList(Basis.term_msg) );
	Basis.HighlightMyElement(Basis.driver.findElement(By.xpath(Basis.term_back_link)),true);
	Thread.sleep(Basis.standardTimeout);
	Basis.HighlightMyElement(Basis.driver.findElement(By.linkText("Kebijakan Kerahasiaan")),true);
	Thread.sleep(Basis.standardTimeout); 
	Log.info("Privacy message : "+ Basis.checkMessageList(Basis.privacy_msg) );
	Basis.HighlightMyElement(Basis.driver.findElement(By.xpath(Basis.privacy_back_link)),true);     
	  		
	}		
	
		
	@Test(priority=6)
	 public void checkAccountDetail() throws InterruptedException{
		headerFunction("checkAccountDetail");
		Basis.bisnisListToAccountSetting();
	      Thread.sleep(Basis.mediumTimeout);


	      Basis.HighlightMyElement(Basis.driver.findElement(By.linkText("Account")),true);
		  Log.info("Fullname : "+ Basis.checkTAMessageList(Basis.setting_name_view) );
		  Log.info("Email : "+ Basis.checkTAMessageList(Basis.setting_email_view) );
		  Basis.validateInvalidImages();

		  changePassword(Basis.oldpassword,"password0","password1");
	      Basis.HighlightMyElement(Basis.driver.findElement(By.xpath(Basis.change_password_back_link)),true);
		  changePassword(Basis.oldpassword,"","password1");
	      Basis.HighlightMyElement(Basis.driver.findElement(By.xpath(Basis.change_password_back_link)),true);

		  changePassword(Basis.oldpassword,Basis.newpassword,Basis.verifiedNewPassword);
		  changePassword(Basis.oldpassword1,Basis.newpassword1,Basis.verifiedNewPassword1);

	      Basis.HighlightMyElement(Basis.driver.findElement(By.xpath(Basis.verify_link)),true);
	      Thread.sleep(Basis.standardTimeout); 
	      Basis.HighlightMyElement(Basis.driver.findElement(By.cssSelector(Basis.verifycancel_submit)),true);
          Thread.sleep(Basis.standardTimeout);
	      Basis.HighlightMyElement(Basis.driver.findElement(By.xpath(Basis.verify_link)),true);
	      Thread.sleep(Basis.standardTimeout); 
	      Basis.HighlightMyElement(Basis.driver.findElement(By.cssSelector(Basis.verify_submit)),true);
 
//	      Basis.HighlightMyElement(Basis.driver.findElement(By.xpath(Basis.deactivate_link)),true);
//	      Basis.HighlightMyElement(Basis.driver.findElement(By.xpath(Basis.deactivate_back_link)),true);
	      
	
	}	
	
	@Test(priority=7)
	 public void updateName() throws InterruptedException{
		headerFunction("updateName");
	      Basis.bisnisListToAccountSetting();
	      Thread.sleep(Basis.shortTimeout);
	      Basis.HighlightMyElement(Basis.driver.findElement(By.linkText("Account")),true);
	      
		  Log.info("Fullname : "+ Basis.checkTAMessageList(Basis.setting_name_view) );
 	      Basis.inputData(Basis.setting_name_view,"New Kojak 2");
 	      Basis.HighlightMyElement(Basis.driver.findElement(By.xpath(Basis.setting_email_view)),true);
 	      Thread.sleep(Basis.standardTimeout);
 	      Log.info("Update Fullname : "+ Basis.checkMessageList(Basis.setting_account_link) );
	      
	}		
	
	@Test(priority=8)
	 public void uploadBgImg() throws InterruptedException{
	  headerFunction("uploadBgImg");
      Basis.bisnisListToAccountSetting();
      Thread.sleep(Basis.shortTimeout);
      Basis.HighlightMyElement(Basis.driver.findElement(By.linkText("Account")),true);
      Thread.sleep(Basis.standardTimeout);
      Basis.HighlightMyElement(Basis.driver.findElement(By.xpath(Basis.edit_bgimg_link)),true);
      Thread.sleep(Basis.standardTimeout);
      uploadImage("//input[@id='inputImageBg']",Basis.profileBackground,true);
      Thread.sleep(Basis.longTimeout);
	      
	}	
	
	@Test(priority=9)
	 public void uploadProfileImg() throws InterruptedException{
		headerFunction("uploadProfileImg");
        Basis.bisnisListToAccountSetting();
        Thread.sleep(Basis.standardTimeout);
	    Basis.HighlightMyElement(Basis.driver.findElement(By.linkText("Account")),true);
        Thread.sleep(Basis.standardTimeout);
        Basis.HighlightMyElement(Basis.driver.findElement(By.xpath(Basis.edit_profile_link)),true);
        Thread.sleep(Basis.standardTimeout);
        uploadImage("//input[@id='inputImageLogo']",Basis.profilePicture,true);
        Thread.sleep(Basis.longTimeout);
    	
	    
	}	
	
	@Test(priority=10)
	 public void createBisnis() throws InterruptedException{
		headerFunction("createBisnis");
	    Basis.bisnisListToAccountSetting();
	   	Thread.sleep(Basis.standardTimeout);
	   	if (Basis.driver.findElements(By.cssSelector(Basis.bizcard_profile_view)).size() > 0 ) {
	   		Log.info("Sudah Ada biz");  
		   }
	   else
		   {
		   Log.info("Belum Ada biz");
		   Basis.HighlightMyElement(Basis.driver.findElement(By.linkText("Create New Bisnis Page")),true);
		   
    		Basis.inputData(Basis.bisnisname_input,"5");
	   		Basis.inputData(Basis.headlinebisnis_input,"5");
	   		Basis.HighlightMyElement(Basis.driver.findElement(By.cssSelector(Basis.createbisnis_submit)),true);
		   }	
	   	}	
	
	@Test(priority=11)
	 public void updateBisnis() throws InterruptedException{
		headerFunction("updateBisnis");    
	    Basis.bisnisListToAccountSetting();
	   	Thread.sleep(Basis.standardTimeout);
		if (Basis.driver.findElements(By.cssSelector(Basis.bizcard_profile_view)).size() > 0 ) {
    		Log.info("Sudah Ada biz");  		
    		Basis.HighlightMyElement(Basis.driver.findElement(By.cssSelector(Basis.bizcard_profile_view)),true);
    		Basis.inputData(Basis.bisnisname_input,"Pemilik "+Basis.userId);
    		Basis.inputData(Basis.editheadlinebisnis_input,"Headline "+Basis.userId);
    		Thread.sleep(Basis.standardTimeout);
    	}else{
    		Log.info("Belum Ada biz");
    	}
	   
	}	
		
	@Test(priority=12)
	 public void uploadBisnisBgImg() throws InterruptedException{
	  headerFunction("uploadBisnisBgImg");
      Basis.bisnisListToAccountSetting();
      Thread.sleep(Basis.shortTimeout);
      if (Basis.driver.findElements(By.cssSelector(Basis.bizcard_profile_view)).size() > 0 ) {
    		Log.info("Sudah Ada biz");  		
    		Basis.HighlightMyElement(Basis.driver.findElement(By.cssSelector(Basis.bizcard_profile_view)),true);
    		Basis.HighlightMyElement(Basis.driver.findElement(By.xpath(Basis.edit_bgimg_link)),true);
    		uploadImage("//input[@id='inputImageBg']",Basis.bisnisBackground,true);
    		Thread.sleep(Basis.longTimeout);
    	}else{
    		Log.info("Belum Ada biz");
    	} 	  	
      
	}	
	
	@Test(priority=13)
	 public void uploadBisnisLogoImg() throws InterruptedException{
	  headerFunction("uploadBisnisLogoImg");
      Basis.bisnisListToAccountSetting();
      Thread.sleep(Basis.shortTimeout);
      if (Basis.driver.findElements(By.cssSelector(Basis.bizcard_profile_view)).size() > 0 ) {
    		Log.info("Sudah Ada biz");  		
    		Basis.HighlightMyElement(Basis.driver.findElement(By.cssSelector(Basis.bizcard_profile_view)),true);
            Basis.HighlightMyElement(Basis.driver.findElement(By.xpath(Basis.edit_profile_link)),true);
    		uploadImage("//input[@id='inputImageLogo']",Basis.logoPicture,true);
    		Thread.sleep(Basis.longTimeout);
    	}else{
    		Log.info("Belum Ada biz");
    	} 	  	
      
	}	
	
@Test(priority=14)
	public void deleteMedia() throws InterruptedException{
	headerFunction("deleteMedia");

    Basis.bisnisListToAccountSetting();
	   	Thread.sleep(Basis.standardTimeout);
		if (Basis.driver.findElements(By.cssSelector(Basis.bizcard_profile_view)).size() > 0 ) {
			Log.info("Sudah Ada biz");  		
			Basis.HighlightMyElement(Basis.driver.findElement(By.cssSelector(Basis.bizcard_profile_view)),true);
			if (Basis.driver.findElements(By.xpath(Basis.check_media)).size() < 2 ) {
	  			Log.info("Belum Ada Media"); 
	  		}else{
	  	   		Log.info("Sudah Ada Media");
	  	   		Basis.HighlightMyElement(Basis.driver.findElement(By.xpath(Basis.first_media)),true);
	  	  	    Thread.sleep(Basis.standardTimeout);
	  	   		Basis.HighlightMyElement(Basis.driver.findElement(By.xpath(Basis.delete_media_button)),true);
	  	   		Thread.sleep(Basis.standardTimeout);
	  	   		Basis.HighlightMyElement(Basis.driver.findElement(By.xpath(Basis.confirm_delete_media_button)),true);
	  	   		//Thread.sleep(Basis.standardTimeout);
	  	   		Basis.HighlightMyElement(Basis.driver.findElement(By.xpath(Basis.close_media_button)),true);
	  		}
			
		}else{
			Log.info("Belum Ada biz");
		}   	   
	}			
	
	@Test(priority=15)
	 public void addMedia() throws InterruptedException{
		headerFunction("addMedia");
	
	    Basis.bisnisListToAccountSetting();
	   	Thread.sleep(Basis.standardTimeout);
		if (Basis.driver.findElements(By.cssSelector(Basis.bizcard_profile_view)).size() > 0 ) {
			Log.info("Sudah Ada biz");  		
			Basis.HighlightMyElement(Basis.driver.findElement(By.cssSelector(Basis.bizcard_profile_view)),true);
			//Basis.HighlightMyElement(Basis.driver.findElement(By.cssSelector(Basis.addmedia_link)),true);
			uploadImage("//input[@id='chooseFile']",Basis.product1_img,false);
			Thread.sleep(Basis.longTimeout);
		}else{
			Log.info("Belum Ada biz");
		}   
	    
	}		

	@Test(priority=16)
	 public void updateMedia() throws InterruptedException{
		headerFunction("updateMedia");
	    
	    Basis.bisnisListToAccountSetting();
	   	Thread.sleep(Basis.standardTimeout);
		if (Basis.driver.findElements(By.cssSelector(Basis.bizcard_profile_view)).size() > 0 ) {
			Log.info("Sudah Ada biz");  		
			Basis.HighlightMyElement(Basis.driver.findElement(By.cssSelector(Basis.bizcard_profile_view)),true);
			Thread.sleep(Basis.standardTimeout);
			if (Basis.driver.findElements(By.xpath(Basis.check_media)).size() < 2 ) {
	  			Log.info("Belum Ada Media"); 
	  		}else{
	  	   		Log.info("Sudah Ada Media");
	  	   		Basis.HighlightMyElement(Basis.driver.findElement(By.xpath(Basis.first_media)),true);
		  	   	Basis.inputData(Basis.mediaTitle_input,"Judul "+Basis.userId);	
		  	   	Basis.inputData(Basis.mediaDesc_input,"Keterangan "+Basis.userId);
	  	   		Basis.HighlightMyElement(Basis.driver.findElement(By.xpath(Basis.update_media_button)),true);
	  		}
			
		}else{
			Log.info("Belum Ada biz");
		}   
	    
	}	
	
		
	@Test(priority=17)
	public void addbookmark() throws InterruptedException, ClientProtocolException, IOException{
	headerFunction("addbookmark");
    Basis.HighlightMyElement(Basis.driver.findElement(By.xpath(Basis.biz_bgimg_list_card_view1+"1"+Basis.biz_bgimg_list_card_view2)),true);
    Thread.sleep(Basis.standardTimeout);  
    Basis.HighlightMyElement(Basis.driver.findElement(By.xpath(Basis.addbookmark_link)),true);
	Basis.validateInvalidImages();
	
	}
	
	
	@Test(priority=18)
	public void bookmark() throws InterruptedException, ClientProtocolException, IOException{
	headerFunction("bookmark");
    Basis.HighlightMyElement(Basis.driver.findElement(By.xpath(Basis.header_bookmark_link)),true);

	Thread.sleep(Basis.standardTimeout);
    Log.info("Nr Biz list : "+ Basis.checkCardList(Basis.list_card_view));
    checkbizcard(Basis.checkCardList(Basis.list_card_view));
    Thread.sleep(Basis.standardTimeout);  
	Basis.validateInvalidImages();
	
	}	

	
	@Test(priority=19)
	public void chat() throws InterruptedException, ClientProtocolException, IOException{
	headerFunction("chat");

    bizsearch(Basis.findBiz);
    Thread.sleep(Basis.standardTimeout);
    Basis.HighlightMyElement(Basis.driver.findElement(By.xpath(Basis.biz_bgimg_list_card_view1+"1"+Basis.biz_bgimg_list_card_view2)),true);
    Thread.sleep(Basis.standardTimeout);  
    Basis.HighlightMyElement(Basis.driver.findElement(By.cssSelector(Basis.chat_link)),true);
	Thread.sleep(Basis.standardTimeout);
	 for (int i = 1; i <= 10; i++) {	
		// Basis.inputDataCss(Basis.chatMessage_input,"Ini chatting ke ======== :"+i);
		
		Basis.inputDataCss(Basis.chatMessage_input,Basis.randomString(Basis.randInt(2,10))+ " " + Basis.randomString(Basis.randInt(2,10))+ " " + Basis.randomString(Basis.randInt(2,10)));
	    Basis.HighlightMyElement(Basis.driver.findElement(By.cssSelector(Basis.sendMessage_button)),true);
	 }
	}	
	
	@Test(priority=20)
	public void listchat() throws InterruptedException, ClientProtocolException, IOException{
	headerFunction("listchat");
    Basis.HighlightMyElement(Basis.driver.findElement(By.cssSelector(Basis.header_chat_link)),true);
	Thread.sleep(Basis.standardTimeout);
	    if (Basis.driver.findElements(By.cssSelector(Basis.chat_title)).size() > 0){	   	
	    	Basis.HighlightMyElement(Basis.driver.findElement(By.cssSelector(Basis.chat_title)),true);  
	    	Thread.sleep(Basis.standardTimeout);
		   	 for (int i = 1; i <= 10; i++) {	
		   		// Basis.inputDataCss(Basis.chatMessage_input,"Ini chatting ke ======== :"+i);
		   		
		   		Basis.inputDataCss(Basis.chatMessage_input,Basis.randomString(Basis.randInt(2,10))+ " " + Basis.randomString(Basis.randInt(2,10))+ " " + Basis.randomString(Basis.randInt(2,10)));
		   	    Basis.HighlightMyElement(Basis.driver.findElement(By.cssSelector(Basis.sendMessage_button)),true);
		   	 }
	    }
	// Basis.signout();   
	} 		
/*	
	@Test(priority=30)
	 public void closeAccount() throws InterruptedException, ClientProtocolException, IOException{
	   headerFunction("closeAccount");	
	   Basis.bisnisListToAccountSetting();
	   Thread.sleep(Basis.standardTimeout);
	   Basis.HighlightMyElement(Basis.driver.findElement(By.linkText("Account")),true);
	   Thread.sleep(Basis.standardTimeout);
	   Basis.HighlightMyElement(Basis.driver.findElement(By.xpath(Basis.deactivate_link)),true);
	   
	   Basis.inputData(Basis.deactivate_email_input,"abalabal@");
	   Basis.inputData(Basis.deactivate_password_input,"password");
	   Log.info("closeAccount email message : "+ Basis.checkMessageList(Basis.email_deactivate_msg) );
	   Log.info("closeAccount password message : "+ Basis.checkMessageList(Basis.password_deactivate_msg) );
	   Thread.sleep(Basis.mediumTimeout);
	
	   
	   Basis.inputData(Basis.deactivate_email_input,Basis.userId);
	   Basis.inputData(Basis.deactivate_password_input,"wrong");
	   Thread.sleep(Basis.mediumTimeout);
	   Log.info("closeAccount email message : "+ Basis.checkMessageList(Basis.email_deactivate_msg) );
	   Log.info("closeAccount password message : "+ Basis.checkMessageList(Basis.password_deactivate_msg) );
	
	   Basis.inputData(Basis.deactivate_email_input,"abalabal@yahoo.com");
	   Basis.inputData(Basis.deactivate_password_input,"password");
	   Thread.sleep(Basis.mediumTimeout);
	   Log.info("closeAccount email message : "+ Basis.checkMessageList(Basis.email_deactivate_msg) );
	   Log.info("closeAccount password message : "+ Basis.checkMessageList(Basis.password_deactivate_msg) );
	   Basis.HighlightMyElement(Basis.driver.findElement(By.xpath(Basis.deactivate_submit)),true);
	   Thread.sleep(Basis.mediumTimeout);
	   Log.info("closeAccount Bert message : "+ Basis.checkMessageList(Basis.bert_msg) );	
	   
	
	   Basis.inputData(Basis.deactivate_email_input,Basis.userId);
	   Basis.inputData(Basis.deactivate_password_input,Basis.passwordUser);
	   Thread.sleep(Basis.mediumTimeout);
	   Log.info("closeAccount email message : "+ Basis.checkMessageList(Basis.email_deactivate_msg) );
	   Log.info("closeAccount password message : "+ Basis.checkMessageList(Basis.password_deactivate_msg) );
	   Basis.HighlightMyElement(Basis.driver.findElement(By.xpath(Basis.deactivate_submit)),true);
	   Thread.sleep(Basis.shortTimeout);
	   Log.info("closeAccount Bert message : "+ Basis.checkMessageList(Basis.bert_msg) );	   
}
	*/
	@AfterMethod
	 public void tearDown(ITestResult result){
		 
		if(ITestResult.FAILURE==result.getStatus()){
			Basis.captureScreenshot(Basis.driver, result.getName());
		}
	}
	
	public static void  headerFunction(String function) throws InterruptedException
	  {
		Basis.delCookies();
	   Log.info("****************************************************************************************");
	   Log.info("****************************************************************************************"); 
	   Log.info("$$$$$$$$$$$$$$$$$$$$$        Testing "+function+"         $$$$$$$$$$$$$$$$$$$$$$$$$");
	   Log.info("****************************************************************************************"); 
	   Log.info("****************************************************************************************"); 
	   Log.info("Testing Login with account dan password yang betul");
	   loginTC(Basis.userId,Basis.passwordUser,true);
	   Thread.sleep(Basis.mediumTimeout);
	  }
	
	 public void changePassword(String pwd,String newPwd, String newPwdConfirm){
       Basis.HighlightMyElement(Basis.driver.findElement(By.xpath(Basis.change_password_link)),true);
       Basis.inputData(Basis.cp_password_input,pwd);
       Basis.inputData(Basis.cp_new_password_input,newPwd);
       Basis.inputData(Basis.cp_verifypassword_input,newPwdConfirm);
       Basis.HighlightMyElement(Basis.driver.findElement(By.xpath(Basis.cp_change_link)),true);
       Log.info("Old pwd message : "+ Basis.checkMessageList(Basis.cp_oldpassword_msg) );
       Log.info("New pwd message : "+ Basis.checkMessageList(Basis.cp_newpassword_msg) );
       Log.info("Repeat pwd message : "+ Basis.checkMessageList(Basis.cp_repeatnewpassword_msg) );
	 }
		
	
	public static void  reportproblem(String reportType) throws InterruptedException
	  {

	      Basis.HighlightMyElement(Basis.driver.findElement(By.linkText("Laporkan Masalah")),true);
	      Thread.sleep(Basis.standardTimeout);
		  Select se=new Select(Basis.driver.findElement(By.xpath(Basis.report_combo)));
		  se.selectByVisibleText(reportType);
	      
	      Basis.inputData(Basis.report_input,"ini report problem "+reportType);
		  Log.info("Report Problem message : "+ Basis.checkMessageList(Basis.report_msg) );
		  
		  Basis.HighlightMyElement(Basis.driver.findElement(By.xpath(Basis.report_submit)),true);
		  Log.info("Bert Report Problem message : "+ Basis.checkMessageList(Basis.bert_msg) );	
	  }
	
   public static void  loginTC(String email,String password,boolean lanjut) {
	 try {
		 Basis.driver.get(Basis.baseUrl);
		 Basis.HighlightMyElement(Basis.driver.findElement(By.xpath(Basis.login_link)),true);
		 Basis.inputData(Basis.login_email_input,email);
		 Basis.inputData(Basis.login_password_input,password);
		 
		 Basis.HighlightMyElement(Basis.driver.findElement(By.xpath(Basis.login_submit)),true);
		 //Thread.sleep(Basis.standardTimeout);
		 Log.info("Failed Login Bert message : "+ Basis.checkMessageList(Basis.bert_msg) );    		 
		 
		 Log.info("Email login message : "+ Basis.checkMessageList(Basis.email_login_msg) );    		 
		 Log.info("Password login message : "+ Basis.checkMessageList(Basis.password_login_msg) );


		 Thread.sleep(Basis.mediumTimeout);
		 if (lanjut) {
			Log.info("After success Login Bert message : "+ Basis.checkMessageList(Basis.bert_msg) ); 
			if (Basis.driver.findElements(By.xpath(Basis.login_link)).size() == 0){
				Log.info("Login Failed");
			}
		//	Basis.validateInvalidImages();
		    //Basis.HighlightMyElement(Basis.driver.findElement(By.xpath(Basis.setting_account_link)),true);
		  }
		 } catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         
    }	
 
	 public void bizsearch(String Data1) throws InterruptedException{

		    Log.info("Searching : "+Data1);
		    Basis.inputData(Basis.main_search_input,Data1);
			Basis.HighlightMyElement(Basis.driver.findElement(By.xpath(Basis.main_search_button)),true);
			Thread.sleep(Basis.standardTimeout);
		   // Log.info("Nr list message : "+ Basis.checkMessageList(Basis.list_count_msg) );
		    Log.info("Nr Biz list : "+ Basis.checkCardList(Basis.list_card_view));
		    checkbizcard(Basis.checkCardList(Basis.list_card_view));
	}			
		
	 public void checkbizcard(int Data1){
		 if (Data1>0){
			 for (int i = 1; i <= Data1; i++) {	
				 if (Basis.checkMessageList(Basis.biz_title_list_card_view1+i+Basis.biz_title_list_card_view2).equals(null) )
				 {
					 Log.info("No TitleBiz  ");
				 }
				 if (Basis.checkMessageList(Basis.biz_headline_list_card_view1+i+Basis.biz_headline_list_card_view2).equals(null) )
				 {
					 Log.info("No HeadlineBiz  ");
				 }
		     //Log.info("TitleBiz : "+ Basis.checkMessageList(Basis.biz_title_list_card_view1+i+Basis.biz_title_list_card_view2) );
		     //Log.info("HeadlineBiz : "+ Basis.checkMessageList(Basis.biz_headline_list_card_view1+i+Basis.biz_headline_list_card_view2) );
			 }		 
		}
	}			
	

	
	 public void childregister(String Data1,String Data2,String Data3,String Data4,boolean lanjut){
		try {
			Basis.driver.get(Basis.baseUrl);
	   		Basis.HighlightMyElement(Basis.driver.findElement(By.xpath(Basis.header_signup_link)),true);
		    Thread.sleep(Basis.shortTimeout);
		    Basis.inputData(Basis.reg_fullname_input,Data1);
		    Basis.inputData(Basis.reg_email_input,Data2);
		    Basis.inputData(Basis.reg_password_input,Data3);
		    Basis.inputData(Basis.reg_ver_password_input,Data4);
		    Log.info("Fullname message : "+ Basis.checkMessageList(Basis.reg_fullname_msg) );
		    Log.info("Email message : "+ Basis.checkMessageList(Basis.reg_email_msg) );
		    Log.info("Password message : "+ Basis.checkMessageList(Basis.reg_password_msg) );
		    Log.info("Confirm Password message : "+ Basis.checkMessageList(Basis.reg_confirm_password_msg) );
		    if (lanjut) {
		    Basis.HighlightMyElement(Basis.driver.findElement(By.cssSelector(Basis.signup_submit)),true);
		    }
		    //Log.info("Bert message : "+ Basis.checkMessageList(Basis.bert_msg) );
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	 
	public static void  uploadImage(String inputfile,String uploadFile,boolean resize) throws InterruptedException
	  {
		JavascriptExecutor js = (JavascriptExecutor) Basis.driver;		    
	    WebElement browse = Basis.driver.findElement(By.xpath(inputfile));
    	js.executeScript("arguments[0].parentNode.removeAttribute('style')", browse);
    	browse.sendKeys(uploadFile);
    	Thread.sleep(Basis.standardTimeout);
    	if (resize){ 
    	Basis.HighlightMyElement(Basis.driver.findElement(By.xpath(Basis.upload_submit)),true);	
    	}
    	Thread.sleep(Basis.longTimeout);
	  }
			   
	
}
