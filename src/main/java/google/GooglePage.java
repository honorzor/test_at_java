package google;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class GooglePage {

    @FindBy(how = How.NAME, using = "q")
    private SelenideElement search;

    public GoogleSearchResult search(String msg) {
        search.setValue(msg).pressEnter();
        return page(GoogleSearchResult.class);
    }

    public static GooglePage openBrowser(String url) {
        return open(url, GooglePage.class);
    }
}
