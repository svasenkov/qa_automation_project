import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Tag("facebook")
public class FacebookTests {

    @Test
    @DisplayName("Positive test")
    void positiveTest() {


        open("http://facbook.com");

        $(by("data-testid", "royal_email")).setValue("devday2019.test@gmail.com");
        $(by("data-testid", "royal_pass")).setValue("devday2019");
        $(by("data-testid", "royal_login_button")).click();

        $("html").shouldHave(text("Devday"), text("Baku"));
    }
}