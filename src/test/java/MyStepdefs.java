import cucumber.api.PendingException;
import cucumber.api.java8.En;

public class MyStepdefs implements En {
    public MyStepdefs() {
        And("^xdkfhfgslfk$", () -> {
            // Write code here that turns the phrase above into concrete actions
            System.out.println("in end");
        });
        When("^kzdfugsdu$", () -> {
            // Write code here that turns the phrase above into concrete actions
            System.out.println("when");
        });
        Then("^sdfgjd$", () -> {
            // Write code here that turns the phrase above into concrete actions
            System.out.println("in then");
        });
        Given("^(\\d+)sdf$", (Integer arg0) -> {
            // Write code here that turns the phrase above into concrete actions
            System.out.println("in given");
        });
    }
}
