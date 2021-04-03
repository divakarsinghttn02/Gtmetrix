import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class gtmetrix {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://gtmetrix.com");
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//input[@type='url']")).sendKeys("https://www.tothenew.com/");
        WebElement button=driver.findElement(By.xpath("//button[contains(text(),'Test your site')]"));
        button.click();
        WebDriverWait exWait=new WebDriverWait(driver,50);
        WebElement report;
        report=exWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'report-score') and contains(@class,'report-score-grade-gtmetrix')]/i")));
        System.out.println(report.getAttribute("class"));
        String grade=report.getAttribute("class");
        int len=grade.length();
        char gradeChar=grade.charAt(len-1);
        System.out.println("GTmetrix Grade: "+gradeChar);

        switch (gradeChar)
        {
            case'A':
                System.out.println("Score is between 90-100");
                break;
            case'B':
                System.out.println("Score is between 80-90");
                break;
            case'C':
                System.out.println("Score is between 70-80");
                break;
            case'D':
                System.out.println("Score is between 60-70");
                break;
            case 'E':
                System.out.println("Score is between 50-60");
                break;
            case'F':
                System.out.println("Score is between 40-50");
                break;
            case'G':
                System.out.println("Score is between 30-40");
                break;
            case'H':
                System.out.println("Score is between 20-30");
                break;
            case'I':
                System.out.println("Score is between 10-20");
                break;
                default:
                    System.out.println("Score is between 0-10");
        }

        //Performance
        WebElement performanceScore= driver.findElement(By.xpath("(//span[@class='report-score-percent'])[1]"));
        String perScore=performanceScore.getText();
        perScore=perScore.substring(0,perScore.length()-1);
        int n=Integer.parseInt(perScore);
        System.out.println("Performance Score: "+n);
        if(n<=100&&n>=90)
            System.out.println("Performance grade: A");
        else if(n<90&&n>=80)
            System.out.println("Performance grade: B");
        else if(n<80&&n>=70)
            System.out.println("Performance grade: C");
        else if(n<70&&n>=60)
            System.out.println("Performance grade: D");
        else if(n<60&&n>=50)
            System.out.println("Performance grade: E");
        else if(n<50&&n>=40)
            System.out.println("Performance grade: G");
        else if(n<40&&n>=30)
            System.out.println("Performance grade: H");
        else if(n<30&&n>=20)
            System.out.println("Performance grade: I");
        else if(n<20&&n>=10)
            System.out.println("Performance grade: J");
        else
            System.out.println("Performance grade: K");

        //Structure
        WebElement structureScore= driver.findElement(By.xpath("(//span[@class='report-score-percent'])[2]"));
        String structScore=structureScore.getText();
        structScore=structScore.substring(0,structScore.length()-1);
        int m=Integer.parseInt(structScore);
        System.out.println("Structure Score: "+m);
        if(m<=100&&m>=90)
            System.out.println("Structure grade: A");
        else if(m<90&&m>=80)
            System.out.println("Structure grade: B");
        else if(m<80&&m>=70)
            System.out.println("Structure grade: C");
        else if(m<70&&m>=60)
            System.out.println("Structure grade: D");
        else if(m<60&&m>=50)
            System.out.println("Structure grade: E");
        else if(m<50&&m>=40)
            System.out.println("Structure grade: G");
        else if(m<40&&m>=30)
            System.out.println("Structure grade: H");
        else if(m<30&&m>=20)
            System.out.println("Structure grade: I");
        else if(m<20&&m>=10)
            System.out.println("Structure grade: J");
        else
            System.out.println("Structure grade: K");

    }
}
