package rulesengine;

import org.anair.drools.fluent.api.RulesExecution;
import org.anair.drools.model.FiredRulesReturnValues;
import org.anair.drools.test.annotation.StatelessKSession;
import org.anair.drools.test.listener.DroolsTestExecutionListener;
import org.junit.Assert;
import org.kie.api.cdi.KReleaseId;
import org.kie.api.runtime.StatelessKieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;

import com.joestelmach.natty.Parser;

import playlist.Response;

@ContextConfiguration(locations = { "/spring-test-context.xml" })
@TestExecutionListeners({ DroolsTestExecutionListener.class })
@KReleaseId(groupId = "org.anair", artifactId = "drools-cucumber", version = "RELEASE")
public class RulesEngineExecution {
	
	public Parser nattyDateParser = new Parser();
	
	@Autowired
	@Qualifier("playlist.stateless.session")
	@StatelessKSession("playlist.stateless.session")
	private StatelessKieSession statelessKieSession;
	
	
	protected FiredRulesReturnValues fireRules(Response response, Object... facts) {
		try {
			FiredRulesReturnValues firedRulesReturnValues = new RulesExecution(statelessKieSession)
																.addFacts(facts)
																.addGlobal("response", response)
																.fireRules();
			return firedRulesReturnValues;
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
		return null;
	}
}
