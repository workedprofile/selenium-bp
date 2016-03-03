import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

//import com.wp.basis.wpBasis;

public class Login {
    private static org.apache.log4j.Logger Log = Logger.getLogger(Login.class);
    
    static {
        DOMConfigurator.configure("log4j.xml");
    }    
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/Users/wp/Downloads/chromedriver");
		
//		Basis.driver.get(Basis.baseUrl);
//		Basis.HighlightMyElement(Basis.driver.findElement(By.xpath(Basis.login_link)));
		//Basis.driver.findElement(By.xpath(Basis.login_link)).click();
		Log.info("Testing Login with wrong account in WP");    
		loginTC("teamwp@gmail.com","password",false);
		Log.info("Testing Login with wrong password");
        loginTC("sansuardy@gmail.com","12345678",false);
        Log.info("Testing Login with format email yang salah");
		loginTC("@gmail.com","password",false);
		Log.info("Testing Login with aacount dan password yang betul");
        loginTC("sansuardy@gmail.com","password",true);
    	//String alertMessage =wpBasis.driver.switchTo().alert().getText();
        
        //Log.info(alertMessage); 
        /*
    Log.info("Testing Login with wrong account in WP");    
    loginOpenPage();
    loginTC("ahmad111@gmail.com","qwer5678");
//    checkingMsgLogin();
    
    Log.info("Testing Login with wrong password");    
    loginOpenPage();
    loginTC(wpBasis.userId,"qwe345678");
 //   checkingMsgLogin();
    
    Log.info("Testing Login with new account (not verify)");    
    loginOpenPage();
    loginTC(wpBasis.newUser,"qwer5678");
  //  checkingMsgLogin();
    
    Log.info("Testing Login with password yang betul");    
    loginOpenPage();
    loginTC(wpBasis.userId,"12345678");
 //   checkingMsgLogin();
*/	}

	   
    public static void  loginTC(String email,String password,boolean lanjut) {
    	 try {
    		 Basis.driver.get(Basis.baseUrl);
    		 Basis.HighlightMyElement(Basis.driver.findElement(By.xpath(Basis.login_link)),true);
    		// Basis.driver.findElement(By.xpath(Basis.login_link)).click();
    		 Basis.HighlightMyElement(Basis.driver.findElement(By.xpath(Basis.login_email_input)),false);
    		 Basis.driver.findElement(By.xpath(Basis.login_email_input)).clear();
        
    		 Log.info("email :"+email);
    		 
    		 Basis.HighlightMyElement(Basis.driver.findElement(By.xpath(Basis.login_email_input)),false);
    		 Basis.driver.findElement(By.xpath(Basis.login_email_input)).sendKeys(email);
        
    		 Basis.HighlightMyElement(Basis.driver.findElement(By.xpath(Basis.login_password_input)),false);
    		 Basis.driver.findElement(By.xpath(Basis.login_password_input)).clear();
        
    		 Log.info("password :"+password);
        
    		 Basis.HighlightMyElement(Basis.driver.findElement(By.xpath(Basis.login_password_input)),false);
    		 Basis.driver.findElement(By.xpath(Basis.login_password_input)).sendKeys(password);
        
    		 Basis.HighlightMyElement(Basis.driver.findElement(By.xpath(Basis.login_submit)),true);
    		 Thread.sleep(3000);
    		 Log.info("Bert message : "+ Basis.checkMessageList(Basis.bert2_msg) );    		 
    		 
    		 Log.info("Email login message : "+ Basis.checkMessageList(Basis.email_login_msg) );    		 
    		 Log.info("Password login message : "+ Basis.checkMessageList(Basis.password_login_msg) );

    		 Thread.sleep(5000);
    		 if (lanjut) {
    			Log.info("Bert message : "+ Basis.checkMessageList(Basis.bert2_msg) ); 
    		    //Basis.HighlightMyElement(Basis.driver.findElement(By.xpath(Basis.setting_account_link)),true);
    		    Basis.signout();
    		    Thread.sleep(3000);
    			Log.info("Bert message : "+ Basis.checkMessageList(Basis.bert_msg) ); 
    		 }
    	 } catch (InterruptedException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
         
    }
    	
	
	
}
