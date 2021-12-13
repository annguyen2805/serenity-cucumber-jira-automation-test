package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.ensure.Ensure;
import starter.navigation.NavigateTo;
import starter.booking.BookingPage;

import static starter.jira.helper.ConfigResourceBundle.CONFIG_RESOURCE;

public class TestLanguageStepDefinitions {
    @Given("{actor} open booking login")
    public void anOpenBookingLogin(Actor actor) {
        actor.wasAbleTo(NavigateTo.theBookingHomePage());
    }

    @Then("{actor} should see information screen")
    public void heShouldSeeInformationScreen(Actor actor) {
        actor.attemptsTo(
        Ensure.that(BookingPage.LABLE_USER_NAME).hasText(CONFIG_RESOURCE.getValue("label_username")),
        Ensure.that(BookingPage.LABLE_PASSWORD).hasText(CONFIG_RESOURCE.getValue("label_password")),
        Ensure.that(BookingPage.LABLE_TEN_GIAN_HANG).hasText(CONFIG_RESOURCE.getValue("label_ten_gian_hang"))
        );
    }
}
