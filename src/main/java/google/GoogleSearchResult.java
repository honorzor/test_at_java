package google;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class GoogleSearchResult {
    @FindBy(how = How.CSS, using = "#res .g")
    private ElementsCollection results;

    @FindBy(how = How.CSS, using = ".r >a")
    private SelenideElement linkToBank;

    public ElementsCollection results() {
        return results;
    }

    public void click() {
        linkToBank.click();
    }
}
