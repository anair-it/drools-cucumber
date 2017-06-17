package playlist;

import static org.junit.Assert.*;

import java.util.List;

import org.anair.drools.model.FiredRulesReturnValues;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import cucumber.api.DataTable;
import cucumber.api.Scenario;
import cucumber.api.java8.En;
import playlist.Song.Genre;
import rulesengine.RulesEngineExecution;

public class PlaylistStepDefinition extends RulesEngineExecution implements En{
	
	private Scenario scenario;
	private Response response;
	private Playlist playlist;
	private FiredRulesReturnValues firedRulesReturnValues;
	
	public PlaylistStepDefinition(){
		
		Before((Scenario scn) -> {
            this.scenario = scn;
            this.response = new Response();
		});
		
		Given("a playlist called '(\\w+)' exists",(String playlistName) -> {
            if(StringUtils.isNotEmpty(playlistName)){
            	this.playlist = new Playlist(playlistName);
            }
		});
		
		And("the following songs exist in the playlist",(DataTable dataTable) -> {
			List<List<String>> songTable = dataTable.raw();
			if(CollectionUtils.isNotEmpty(songTable)){
				songTable.forEach(songRow-> {
					if(! songRow.get(0).equalsIgnoreCase("title")){
						Song song = new Song(songRow.get(0), Genre.valueOf(songRow.get(1)), Integer.valueOf(songRow.get(3)).intValue());
						song.setArtist(new Artist(songRow.get(2)));
						playlist.addSong(song);
					}
				});
			}
		});
		
		When("rules get fired", () ->{
			firedRulesReturnValues = fireRules(response, playlist);
		});
		
		Then("atleast '(\\d+)' rule is executed", (Integer count) ->{
			assertTrue(firedRulesReturnValues.getNumberOfRulesFired() >= count);
			if(firedRulesReturnValues.getNumberOfRulesFired() != null && firedRulesReturnValues.getNumberOfRulesFired() > 0){
				scenario.write("Executed rules: "+firedRulesReturnValues.getExecutedRules().toString());
			}
		});
		
		And("response says '([\\w\\s\\:]+)'", (String responseMessage) ->{
			assertEquals(responseMessage, response.get(0));
		});
		
		And("response says Not Found", () ->{
			assertTrue(response.isEmpty());
		});
	}
}
