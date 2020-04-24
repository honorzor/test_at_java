package ru.honorzor;

import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class EuroDollar {
    private static final String URL = "https://www.google.com";
    private static final String EXCEPTEDLINK = "https://www.open.ru/";

    @BeforeMethod
    public void signUp() {
        open(URL);
    }

    @Test(priority = 2)
    public void checkUsdUero() {
        element(By.name("q")).setValue("открытие").pressEnter();
        ElementsCollection elements = elements("#search .g");
        elements.first().find(".r>a").click();
        String bUSD = element(By.xpath("//*[@id=\"main\"]/div/div/div[8]/section/div/div/div[1]/div/div/div" +
                "/div/div[2]/table/tbody/tr[2]/td[2]/div/span")).getText().replace(",", ".");
        String sUSD = element(By.xpath("//*[@id=\"main\"]/div/div/div[8]/section/div/div/div[1]/div/div/div" +
                "/div/div[2]/table/tbody/tr[2]/td[4]/div/span")).getText().replace(",", ".");
        String bEURO = element(By.xpath("//*[@id=\"main\"]/div/div/div[8]/section/div/div/div[1]/div/div/div" +
                "/div/div[2]/table/tbody/tr[3]/td[2]/div/span")).getText().replace(",", ".");
        String sEURO = element(By.xpath("//*[@id=\"main\"]/div/div/div[8]/section/div/div/div[1]/div/div/" +
                "div/div/div[2]/table/tbody/tr[3]/td[4]/div/span")).getText().replace(",", ".");


        double buyUSD = Double.parseDouble(bUSD);
        double saleUSD = Double.parseDouble(sUSD);
        double buyEURO = Double.parseDouble(bEURO);
        double saleEURO = Double.parseDouble(sEURO);

        Assert.assertTrue(saleUSD > buyUSD);
        Assert.assertTrue(saleEURO > buyEURO);
    }

    @Test(priority = 1)
    public void checkSearcd() {
        element(By.name("q")).setValue("открытие").pressEnter();
        Assert.assertEquals((element(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div[1]/a")).getAttribute("href")),
                EXCEPTEDLINK);
    }
}
