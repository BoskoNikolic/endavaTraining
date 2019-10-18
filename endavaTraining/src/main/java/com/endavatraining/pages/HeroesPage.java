package com.endavatraining.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class HeroesPage extends BasePage {


    private List<WebElement> rows;


    private By heroTableBody = By.xpath("//table[@id=\"heroes-table\"]/tbody/tr");

    public HeroesPage(WebDriver driver) {
        super(driver);
    }

    /*
     *This method returns element from the page
     * @author Srboljub.Todorovic
     * @param
     * @return
     */

    public WebElement getElement(By locator) {
        return driver.findElement(locator);
    }

    /*
     *This method checks if in table already exists hero with given name
     * @author Srboljub.Todorovic
     * @param
     * @return
     */

    public boolean isHeroInTable(String heroName) {
        rows = driver.findElements(heroTableBody);
        System.out.println(rows.size());
        for (int i = 0; i < rows.size(); i++) {
            if (heroName.equals(driver.findElement(By.xpath("//table[@id=\"heroes-table\"]/tbody/tr[" + (i + 1) + "]/td[1]")).getText())) {
                return true;
            }
        }
        return false;
    }

}
