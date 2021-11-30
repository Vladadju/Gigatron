package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ProductsPage extends BasePage {
    WebDriver driver;
    WebDriverWait wdWait;

    public ProductsPage(WebDriver driver, WebDriverWait wdWait) {
        super(driver, wdWait);
        this.driver = driver;
        this.wdWait = wdWait;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "[name = 'sort']")
    WebElement sortBy;

    String productPriceXpath = "//div[contains(@class,'product-items-main')]/div[$]//span[@class='ppra_price-number']";
    String productNameXpath = "//div[contains(@class,'product-items-main')]/div[$]//a[@class='product-item-name']";

    public void sortBy(String sortingMethod) throws InterruptedException {
        selectByValue(sortBy, sortingMethod);
        Thread.sleep(5000);


    }
//    public  void assertNameAlphabetic(String args[]) {
//        String name1 = driver.findElement(By.xpath(productNameXpath.replace("$", "1"))).getText().replace("4", "");
//        String name2 = driver.findElement(By.xpath(productNameXpath.replace("$", "2"))).getText().replace("4", "");
//        compareStrings(name1, name2);
//
//
//    }

    public  void assertNameAlphabetic() {
        String name1 = driver.findElement(By.xpath(productNameXpath.replace("$", "1"))).getText().replace("4", "");
        String name2 = driver.findElement(By.xpath(productNameXpath.replace("$", "2"))).getText().replace("4", "");


        int comparedResult = name1.compareTo(name2);

        if (comparedResult > 0) {
            System.out.println(name1 + " comes after " + name2);
        } else if (comparedResult < 0) {
            System.out.println(name1 + " comes before " + name2);
        } else {
            System.out.println(name1 + " is equal to " + name2);
        }


    }

    public void assertPriceAppending() {
        int cena1 = Integer.parseInt(driver.findElement(By.xpath(productPriceXpath.replace("$", "1"))).getText().replace(".", ""));
        int cena2 = Integer.parseInt(driver.findElement(By.xpath(productPriceXpath.replace("$", "2"))).getText().replace(".", ""));
        Assert.assertTrue(cena1 <= cena2);

    }
    public void assertPriceDescending() {
        int cena1 = Integer.parseInt(driver.findElement(By.xpath(productPriceXpath.replace("$", "1"))).getText().replace(".", ""));
        int cena2 = Integer.parseInt(driver.findElement(By.xpath(productPriceXpath.replace("$", "2"))).getText().replace(".", ""));
        Assert.assertTrue(cena1 >= cena2);

    }

    public void verifyItemsAreSorted(String sortingMethod) throws Exception {
        switch (sortingMethod) {
            case "rastuci": {
                assertPriceAppending();
            }
            break;
            case "opadajuci": {
                assertPriceDescending();

            }
            break;
            case "naziv": {
                assertNameAlphabetic();

            }
            break;
            case "rejting": {

            }
            break;
            case "score": {

            }
            break;
            default: throw new Exception("Sorting option not supported");

        }

    }
}