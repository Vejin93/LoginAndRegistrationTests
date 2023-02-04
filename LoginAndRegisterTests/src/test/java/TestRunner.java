import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {".//src/test/java/Feature/Login.feature"},
        glue = "step",
        plugin = {"pretty",
                "html:reports/myReport.html",
                "html:reports/myReport.html",
                "rerun:target/rerun.txt",
        },
        dryRun = false,
        monochrome = true
)
public class TestRunner {
}
