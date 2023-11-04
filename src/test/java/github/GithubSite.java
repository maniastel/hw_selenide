package github;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.*;

public class GithubSite {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void openEnterprisePageTest() {
        open("https://github.com");
        $(byTagAndText("button","Solutions")).hover();
        $(byTagAndText("a", "Enterprise")).click();
        $("body").shouldHave(text("The enterprise-ready platform"));

    }

}
