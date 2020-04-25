package ru.honorzor;


import google.BankSite;
import google.GooglePage;
import google.GoogleSearchResult;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class EuroDollar {
    private static final String URL = "https://www.google.com";
    private static final String EXCEPTEDLINK = "www.open.ru";

    @Test
    public void ratesUsdEuro() {
        GooglePage googlePage = GooglePage.openBrowser(URL);

        GoogleSearchResult list = googlePage.search("открытие");

        Assert.assertTrue(list.results().toString().contains(EXCEPTEDLINK));

        $(".r > a").click();

        BankSite page = page(BankSite.class);

        Assert.assertTrue(page.infoBuyUSD() < page.infoSellUSD());
        Assert.assertTrue(page.infoBuyEURO() < page.infoSellEURO());


    }


}
