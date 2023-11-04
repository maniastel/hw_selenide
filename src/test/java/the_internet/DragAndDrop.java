package the_internet;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.DragAndDropOptions.to;
import static com.codeborne.selenide.Selenide.*;

public class DragAndDrop {

    @BeforeEach
    void beforeEach() {
        Configuration.baseUrl = "https://the-internet.herokuapp.com";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void dragAndDropwWithActionsTest() {
        open("/drag_and_drop");
        actions().moveToElement($("#column-a")).clickAndHold().moveByOffset(140, 0).release().perform();
        $$("div .column").first().shouldHave(text("B"));
    }

    @Test
    void dragAndDropwWithCommandTest() {
        open("/drag_and_drop");
        $("#column-a").dragAndDrop(to("#column-b"));
        $$("div .column").first().shouldHave(text("B"));
    }
}
