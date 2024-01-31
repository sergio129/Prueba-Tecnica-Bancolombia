package Runner;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(

        features = "@target/rerunFailed",
        glue = "Stepsdefinitions",
        plugin = {"rerun:target/rerunFailed/fallidos.txt"},
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        tags = "@Ciclos",
        monochrome = true

)

public class rerunFailed {

}
