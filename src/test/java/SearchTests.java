
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SearchTests {


    @AfterEach
    void teardown() {
        closeWebDriver();
    }

    @Test
    void successfulLogin() {
        open("https://auth.niffler.qa.guru/login");
        $("[name=username]").setValue("Alina");
        $("[name=password]").setValue("kovralina");
        $("[type=submit]").click();

        $("[id=spendings]").shouldHave(text("History of Spendings"));

    }

    @Test
    void unsuccessfulLogin() {
        open("https://auth.niffler.qa.guru/login");
        $("[name=username]").setValue("Alina");
        $("[name=password]").setValue("kovrala").pressEnter();
        $("[class=form__error]").shouldHave(text("Неверные учетные данные пользователя"));
    }

    @Test
    void successfulLoginWithPressEnter() {
        open("https://auth.niffler.qa.guru/login");
        sleep(30_000);
        $("[name=username]").setValue("Alina");
        $("[name=password]").setValue("kovralina").pressEnter();
        sleep(30_000);

        $("[id=spendings]").shouldHave(text("History of Spendings"));


    }

    @Test
    void successfulLogout() {
        open("https://auth.niffler.qa.guru/login");
        $("[name=username]").setValue("Alina");
        $("[name=password]").setValue("kovralina").pressEnter();
        $("[id=spendings]").shouldHave(text("History of Spendings"));
        $("[aria-label=Menu]").click();
//        $("[role=menu]").$(byText()).click();


    }


    @Test
    void successfulLogout22() {
        open("https://auth.niffler.qa.guru/login");
        $("[name=username]").setValue("Alina");
        $("[name=password]").setValue("5555").pressEnter();
        $("[id=spendings]").shouldHave(text("History of Spendings"));
        $("[aria-label=Menu]").click();
//        $("[role=menu]").$(byText()).click();


    }
}

