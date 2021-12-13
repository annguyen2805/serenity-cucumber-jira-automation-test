package starter.navigation;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class NavigateTo {
    public static Performable theWikipediaHomePage() {
        System.out.println("---------------------- " + System.getProperty("language"));
        return Task.where("{0} opens the Wikipedia home page",
                Open.browserOn().the(WikipediaHomePage.class));
    }

    public static Performable theBookingHomePage() {
        return Task.where("{0} open booking login",
            Open.browserOn().the(BookingPage.class));
    }
}
