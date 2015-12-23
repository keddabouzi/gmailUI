import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;
/**
 * Created by khalid on 20/12/2015.
 */
public class GmailLoginTest {
    @Test
    public void gmailLoginShouldBeSuccefulTest(){
        WebDriver driver = new FirefoxDriver();
        //    - Go to Gmail website
        driver.get("http://www.gmail.com");
//    - Fill in username
        WebElement email = driver.findElement(By.id("Email"));
        email.clear();
        email.sendKeys("eddabouzi@gmail.com");
        WebElement buttonNext = driver.findElement(By.id("next"));
        buttonNext.click();
//    - Fill in password
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        WebDriverWait wait= new WebDriverWait(driver,60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Sign in")));
        WebElement password = driver.findElement(By.id("Passwd"));
        password.clear();
        password.sendKeys("Pula3475pula");
        //  - click sign in
        WebElement buttonSignIn = driver.findElement(By.id("signIn"));
        buttonSignIn.click();
//    - verify user did sign in
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Inbox")));
        Assert.assertTrue("Inbox should exist",driver.findElements(By.partialLinkText("Inbox")).size()>0);
//    - verified user did sign out
        // Click on the image icon present in the top right navigational Bar
        WebElement googleAccount = driver.findElement(By.cssSelector("span[class='gb_Wa gbii']"));
        //Click on 'Logout' Button
        googleAccount.click();
        WebElement signOut = driver.findElement(By.id("gb_71"));
        signOut.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Sign in")));
        Assert.assertTrue("Inbox should exist",driver.findElements(By.partialLinkText("Sign in")).size()>0);
    }
}
