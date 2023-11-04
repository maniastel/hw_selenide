import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.itemWithText;
import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.*;

public class SelenideRepozitorySearch {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://github.com";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void searchJunitCodeOnSoftAssertsPageTest() {
        String exampleJunit5 = String.join (
                "\n"+ "@ExtendWith({SoftAssertsExtension.class})\n"
                + "class Tests {\n"
                + "@Test\n" + "void test() {\n"
                + "Configuration.assertionMode = SOFT;\n"
                + "open(\"page.html\");\n"
                +"\n"
                + "$(\"#first\").should(visible).click();\n"
                + "$(\"#second\").should(visible).click();\n"
                + "}\n"
                + "}");

        //Откройте страницу Selenide в Github
        open("/selenide/selenide");
        //Перейдите в раздел Wiki проекта
        $("#wiki-tab").click();
        //Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions
        $$(".js-wiki-sidebar-toggle-display li").shouldHave(itemWithText("SoftAssertions"));
        $(".js-wiki-sidebar-toggle-display li button").click();
        //Откройте страницу SoftAssertions
        //$x("//a[text()='SoftAssertions']").click();
        $(byTagAndText("a","SoftAssertions")).click();
        //проверьте что внутри есть пример кода для JUnit5
        $$("#user-content-1-using-testng-just-register-listener-bypass-annotation-for-test-class").shouldHave(texts(exampleJunit5));
    }


}
