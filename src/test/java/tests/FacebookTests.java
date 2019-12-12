package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.*;
import pages.FacebookPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selenide.*;

@Epic("QA automation course")
@Feature("Difference between testid and PageObject strategies")
@Tag("facebook")
class FacebookTests extends TestBase {

    @Test
    @DisplayName("Positive test with testid")
    void positiveTestWithTestId() {
        open("http://facbook.com");

        $(by("data-testid", "royal_email")).setValue("devday2019.test@gmail.com");
        $(by("data-testid", "royal_pass")).setValue("devday2019");
        $(by("data-testid", "royal_login_button")).click();

        $("html").shouldHave(text("Devday"), text("Baku"));
    }

    @Test
    @DisplayName("Positive test with PageObject")
    void positiveTestWithPageObject() {
        FacebookPage facebookPage = new FacebookPage();

        open("http://facbook.com");

        facebookPage.typeEmail("devday2019.test@gmail.com");
        facebookPage.typePassword("devday2019");
        facebookPage.clickSubmit();

        facebookPage.verifyLoggedInAsUser("Devday", "Baku");
    }
}