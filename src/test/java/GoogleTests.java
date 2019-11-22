import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

@Tag("google")
@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class GoogleTests {

    @BeforeAll
    static void beforeOurTests() {
        System.out.println("text before all");
    }

    @BeforeEach
    void beforeOurEachTests() {
        System.out.println("text before each");
    }


    @Test
    @DisplayName("Positive test")
    void positiveTest() {
        open("http://google.com");

        $("#text").val("lepra").pressEnter();

        $(byText("leprosorium.ru")).should(exist);
    }

    @Test
    @DisplayName("Positive test")
    void negativeTest() {
        open("http://google.com");

        $("#text").val("lepra").pressEnter();

        $(byText("lepro1sorium.ru")).shouldNot(exist);
    }
}