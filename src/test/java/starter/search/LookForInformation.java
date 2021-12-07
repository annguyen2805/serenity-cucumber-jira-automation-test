package starter.search;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.Keys;

public class LookForInformation implements Task {
    String searchTerm;
    public LookForInformation(String searchTerm){
        this.searchTerm = searchTerm;
    }
//    public static Performable about(String searchTerm) {
//        return Task.where("{0} searches for '" + searchTerm + "'",
//                Enter.theValue(searchTerm)
//                        .into(SearchForm.SEARCH_FIELD)
//                        .thenHit(Keys.ENTER)
//        );
//    }

    public static LookForInformation about(String searchTerm){
        return Tasks.instrumented(LookForInformation.class,searchTerm);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(searchTerm)
                        .into(SearchForm.SEARCH_FIELD)
                        .thenHit(Keys.ENTER)
        );
    }
}
