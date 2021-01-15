package com.base.qa;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

public class ElemUtils {

    //class variables
    private WebDriver driver;

    //Constructor taking the driver as the param
    public ElemUtils(WebDriver driver) {
        this.driver = driver;
    }

    //Other methods for ElemUtils class
    public WebElement getElement(By loc) {
        return driver.findElement(loc);
    }

    public List<WebElement> getAllElements(By loc) {
        return driver.findElements(loc);
    }

    public void doSendKeys(By loc, String data) {
        driver.findElement(loc).sendKeys(data);
    }

    public void doClick(By loc) {
        driver.findElement(loc).click();
    }

    public String doGetText(By loc) {
        return driver.findElement(loc).getText();
    }

    public void doClear(By loc) {
        driver.findElement(loc).clear();
    }

    public WebDriver doSwitchToFrameById(String id) {
        return driver.switchTo().frame(id);

    }

    public WebDriver doSwitchToFrameByIndex(int index) {
        return driver.switchTo().frame(index);

    }


    public WebDriver doSwitchToFrameWE(String id) {
        String frameElementXpath = String.format("//iframe[@name='%1$s' or @id='%1$s']", id);
        WebElement f1 = getElement(By.xpath(frameElementXpath));
        //WebElement f = driver.findElement(By.xpath(frameElementXpath));
        return driver.switchTo().frame(f1);
    }

    public void selectDrpDwnByIndex(By loc, int index) {
        Select select = new Select(getElement(loc));
        select.selectByIndex(index);
    }

    public void selectDrpDwnByText(By loc, String text) {
        Select select = new Select(getElement(loc));
        select.selectByVisibleText(text);
    }

    public void selectDrpDwnByValue(By loc, String value) {
        Select select = new Select(getElement(loc));
        select.selectByValue(value);
    }

    public void selectFromSelectionList(List<WebElement> selectionList, String value) throws InterruptedException {
        //System.out.println(selectionList.size());
        for (WebElement e : selectionList) {
            //System.out.println(e.getText());
            if (e.getText().equals(value)) {
                e.click();
                Thread.sleep(2000);
                break;
            }
        }
    }

    public List<String> getLinkTextOfASection(List<WebElement> allLinks) {
        List<String> allLinksText = new ArrayList<String>();
        for (WebElement e : allLinks) {
            System.out.println(e.getText());
            allLinksText.add(e.getText());
        }
        System.out.println(allLinks.size());
        return allLinksText;
    }

    public String[] getLinkTextOfASectionInStaticArray(List<WebElement> allLinks) {
        //List<WebElement> allFooterLinks = elemUtils.getAllElements(allFooterLoc);
        String[] allLinksText = new String[allLinks.size()];

        int i = 0;
        for (WebElement e : allLinks) {
            System.out.println(e.getText());
            allLinksText[i++] = e.getText();
        }
        System.out.println(allLinks.size());

        return allLinksText;

    }

    public void hoverOver(By loc) {
        Actions actions = new Actions(driver);
        actions.moveToElement(getElement(loc)).perform();
    }

    public void doActionClick(By loc) {
        Actions actions = new Actions(driver);
        actions.click(getElement(loc)).perform();
    }

    public void jquerySelect(List<WebElement> allOptions, String... value) {
        System.out.println(allOptions.size());

        for (WebElement e : allOptions) {
            String optText = e.getText();
            for (String s : value) {
                if (optText.equals(s)) {
                    e.click();
                    break;// break the loop--- very important
                }
            }
        }
    }

    /**
     * Enter one string for selecting one option
     * Enter multiple string values for selecting multiple options
     * Enter 'All' for selecting all the available options---- Have to use int i in the
     * for loop for iterating through static array , inorder to access the first item
     * to check if it is the 'All' option, get value of [0] index
     *
     * @param allOptions - list of webelements
     * @param value      - Static array of String values--- option text
     */
    public void jQuerySelectOption(List<WebElement> allOptions, String... value) throws InterruptedException {
        System.out.println(allOptions.size());
        if (!value[0].equalsIgnoreCase("All")) {

            for (WebElement ele : allOptions) {
                String optText = ele.getText();
                System.out.println(optText);

                for (int i = 0; i < value.length; i++) {
                    if (optText.equals(value[i])) {
                        ele.click();
                        Thread.sleep(2000);
                        break;
                    }

                }

            }

        } else {
            try {
                for (WebElement e : allOptions) {
                    List<WebElement> subChkBoxes = e.findElements(By.xpath("./input[@type='checkbox']"));
                    for (WebElement sub : subChkBoxes) {
                        sub.click();
                        //Thread.sleep(2000);
                    }
                }
            } catch (Exception e) {

            }

        }
    }

    public void jQueryCascadeSelect(List<WebElement> allOptions, String... value){
        if(!value[0].equalsIgnoreCase("all")){
        for(WebElement ele:allOptions){
            String text = ele.getText();
            for(int i=0; i<value.length; i++){
            if(text.equals(value[i])){
                ele.click();
                break;
            }
            }
        }
    }else {
            for(WebElement el:allOptions){
                if(!el.getText().isEmpty()) {
                    el.click();
                }
            }
        }
    }

    /**
     * Takes the String name and returns all the column values relating to that name in the table
     * @param name
     */
    public void getRowValuesOf(String name){
        List<WebElement> allColsList = driver.findElements(By.xpath
                ("(//table[@class='table bowler'])[2]//a[text()='"+name+"']//parent::td//following-sibling::td"));
        System.out.println(name +"'s Score card is");
        for(int i=0; i<allColsList.size(); i++){

            System.out.println(allColsList.get(i).getText());
        }
    }

    public WebElement customWaits(By loc){
        WebElement element = null;
        int attempts = 0;

            while (attempts <= 20) {
                try {
                    element = driver.findElement(loc);
                    break;
                } catch (NoSuchElementException | StaleElementReferenceException e) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException interruptedException) {
                        interruptedException.printStackTrace();
                    }
                }
                System.out.println("Element found in attempt no. :" + attempts);
                attempts++;
            }
        return element;

    }

    public WebElement fluentWaitVisibilityOfEle(By loc){
        Wait<WebDriver> fWait = new FluentWait<>(driver)
                                    .withTimeout(Duration.ofSeconds(10))
                                    .pollingEvery(Duration.ofSeconds(2))
                                    .ignoring(NoSuchElementException.class)
                                    .ignoring(StaleElementReferenceException.class);
        return fWait.until(ExpectedConditions.visibilityOf(getElement(loc)));
    }

    public void closeBrowser() {
        driver.close();
    }

    public void quitBrowser() {
        driver.quit();
    }
}
