package api.igdb;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class APIParser {
    private HttpEntity entity;
    private RestTemplate restTemplate;

    public APIParser() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("user-key", "IGDB API KEY GOES HERE");
        this.entity = new HttpEntity(headers);
        this.restTemplate = new RestTemplate();
    }

    public Games Game(String gameId) {
        ResponseEntity<Games[]> response = this.restTemplate.exchange("https://api-2445582011268.apicast.io/games/" + gameId + "?fields=id,name,slug,summary,themes", HttpMethod.GET, entity, Games[].class);
        Games[] games = response.getBody();
        return games[0];
    }
    public Games[] SearchGames(String searchName) {
        String url = "https://api-2445582011268.apicast.io/games/?search=" + searchName + "&order=popularity:desc&fields=id,name,slug,summary,themes";
        ResponseEntity<Games[]> response = this.restTemplate.exchange(url, HttpMethod.GET, entity, Games[].class);
        Games[] games = response.getBody();
        return games;
    }
    public Games[] SeacrhGames(String searchName, String platform){
        String url = "https://api-2445582011268.apicast.io/games/?search=" + searchName + "&filter[platforms][eq]="+ platform +"&order=popularity:desc&fields=id,name,slug,summary,themes";
        ResponseEntity<Games[]> response = this.restTemplate.exchange(url, HttpMethod.GET, entity, Games[].class);
        Games[] games = response.getBody();
        return games;
    }
}
