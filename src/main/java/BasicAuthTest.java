import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BasicAuthTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");

        WebDriver driver = new FirefoxDriver();

        driver.get("https://the-internet.herokuapp.com/basic_auth");

        try {
            Thread.sleep(5000);
            driver.switchTo().alert().dismiss();
        } catch (Exception e) {

        }

        String username = "admin";
        String password = "admin";

        String urlWithCredentials = "https://" + username + ":" + password + "@the-internet.herokuapp.com/basic_auth";

        driver.get(urlWithCredentials);

        WebElement congratsMessage = driver.findElement(By.xpath("//div[@class='example']/p[contains(text(),'Congratulations! You must have the proper credentials.')]\n"));

        if (congratsMessage.isDisplayed()) {
            System.out.println("Вход выполнен успешно. Сообщение с поздравлением проверено.");
        } else {
            System.out.println("Ошибка входа или не найдено сообщение с поздравлением.");
        }

        driver.quit();
    }
}
