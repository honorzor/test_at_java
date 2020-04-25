package google;

import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class GoogleSearchResult {
    @FindBy(how = How.CSS, using = "#res .g")
    private ElementsCollection results;

    public ElementsCollection results() {
        return results;
    }
}
