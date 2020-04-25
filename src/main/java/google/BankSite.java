package google;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class BankSite {
    @FindBy(how = How.XPATH, using = "//*[@id=\"main\"]/div/div/div[8]/section/div/div/div[1]/div/div/div/div/div[2]" +
            "/table/tbody/tr[2]/td[2]/div/span")
    private SelenideElement bUSD;
    @FindBy(how = How.XPATH, using = "//*[@id=\"main\"]/div/div/div[8]/section/div/div/div[1]/div/div/div/div/div[2]" +
            "/table/tbody/tr[2]/td[4]/div/span")
    private SelenideElement sUSD;
    @FindBy(how = How.XPATH, using = "//*[@id=\"main\"]/div/div/div[8]/section/div/div/div[1]/div/div/div/div/div[2]" +
            "/table/tbody/tr[3]/td[2]/div/span")
    private SelenideElement bEUR;
    @FindBy(how = How.XPATH, using = "//*[@id=\"main\"]/div/div/div[8]/section/div/div/div[1]/div/div/div/div/div[2]" +
            "/table/tbody/tr[3]/td[4]/div/span")
    private SelenideElement sEUR;

    public double infoBuyUSD() {
        return Double.parseDouble(bUSD.getText().replace(",", "."));
    }

    public Double infoSellUSD() {
        return Double.parseDouble(sUSD.getText().replace(",", "."));
    }

    public Double infoBuyEURO() {
        return Double.parseDouble(bEUR.getText().replace(",", "."));
    }

    public Double infoSellEURO() {
        return Double.parseDouble(sEUR.getText().replace(",", "."));
    }

}
