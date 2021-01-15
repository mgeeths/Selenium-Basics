import com.base.qa.DriverFactory;
import com.base.qa.ElemUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;

public class WebdriverBasics {

    public static void main(String[] args) throws InterruptedException {
        //class variables
        By searchFieldLoc = By.id("search_query_top");
        By searchSelectionListLoc = By.xpath("//div[@class='ac_results']/ul/li");
        By productHeader = By.tagName("h1");
        By addOnLoc = By.linkText("ADD-ONS");
        By studDiscountLoc = By.xpath("//a[contains(text(),'Student')]");
        By studDiscountHeader = By.tagName("h1");

        String frameId1 = "PGFq";
        By frameId = By.id("fsQa");
        By startLoc = By.xpath("(//div[contains(@id,'origin-airport-display-multi-container')])[1]");
        By fromLoc = By.xpath("//input[contains(@id,'origin-airport')]");
        By destFieldLoc = By.xpath("(//div[contains(@id,'destination-input')]/div[contains(@id,'destination-airport-display')])[1]");
        By destLoc = By.xpath("//input[contains(@id,'destination-airport')]");
        By sfoLoc = By.xpath("//div[@class='item-info']//div[contains(text(),'San Francisco')]");
        By laLoc = By.xpath("//div[@class='item-info']//div[contains(text(),'Los Angeles')]");
        By originFieldClose = By.xpath("(//div[contains(@class,'_iac _irF')]/button)[1]");

        By allFooterLoc = By.xpath("//span[@id='fsl']/a|//span[@id='fsr']/a|//span[@jscontroller='GPhFgf']|//a[@class='ITBbvb']");
        By allFooterLinksLoc = By.xpath("//ul[@class='footer-nav']/li");

        By multiSelectField1Loc = By.id("justAnInputBox1");
        By allOptionsLoc = By.xpath("//li//span[@class = 'comboTreeItemTitle']");

        By Loc = By.linkText("Live Scores");
        By weekViewLoc = By.linkText("Week view");

        By mainFooterLinksLoc = By.xpath("//ul[@class='footer-nav']");


        WebDriver driver;
        String url = "https://www.freshworks.com/";
        String dressType = "Evening Dresses > Printed Dress";
        DriverFactory df = new DriverFactory();
        driver = df.launchBrowser("chrome");
        df.visitSite(url);
        df.maxWindow();
        Thread.sleep(2000);

        ElemUtils elemUtils = new ElemUtils(driver);
        /*
        elemUtils.doSendKeys(searchFieldLoc, "dresses");
        Thread.sleep(2000);

        elemUtils.selectFromSelectionList(elemUtils.getAllElements(searchSelectionListLoc),dressType);
        if(elemUtils.doGetTextOfElement(productHeader).equals("Printed Dress")){
            System.out.println("You have the right selection");
        }
        else {
            System.out.println("You have the wrong selection");
        }


        String[] myFooterArr = elemUtils.getLinkTextOfASectionInStaticArray(elemUtils.getAllElements(allFooterLoc));
        System.out.println(Arrays.toString(myFooterArr));

        elemUtils.hoverOver(addOnLoc);
        //WebElement studDiscount = driver.findElement(studDiscountLoc);
        elemUtils.hoverOver(studDiscountLoc);
        elemUtils.doClick(studDiscountLoc);
        Thread.sleep(3000);
        String text = elemUtils.doGetTextOfElement(studDiscountHeader);
        System.out.println(text);

        int size = driver.findElements(By.tagName("iframe")).size();
        System.out.println(size);
        elemUtils.doSwitchToFrameByIndex(0);
        //elemUtils.goToFrame(frameId1);
        //elemUtils.doSwitchToFrameById(frameId1);
        //elemUtils.doSwitchToFrame(frameId1);


        System.out.println(elemUtils.doGetText(startLoc));
        elemUtils.doClick(originFieldClose);
        //elemUtils.doActionClick(startLoc);
        Thread.sleep(2000);

        elemUtils.doSendKeys(fromLoc,"SFO");
        Thread.sleep(2000);

        elemUtils.doClick(sfoLoc);
        Thread.sleep(3000);

        elemUtils.doActionClick(destFieldLoc);
        elemUtils.doSendKeys(destLoc,"Los Angeles");
        Thread.sleep(2000);

        elemUtils.doClick(laLoc);
        Thread.sleep(2000);


        elemUtils.doClick(multiSelectField1Loc);
        elemUtils.jQueryCascadeSelect(elemUtils.getAllElements(allOptionsLoc), "choice 2");
        elemUtils.getRowValuesOf("Washington Sundar");

 */
        List<WebElement> mainFooterLinks = elemUtils.getAllElements(mainFooterLinksLoc);
        for(WebElement e:mainFooterLinks){
            WebElement firstLink = e.findElement(By.xpath("./li"));
            String text  = firstLink.getText();
            System.out.println("First link in each footer section is : " + text);
        }
        elemUtils.quitBrowser();

    }
}
