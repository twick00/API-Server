package controllers;

import api.igdb.APIParser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {

    @GetMapping("/")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "index";
    }
    @GetMapping("/games")
    public String games(@RequestParam(name="id", required = false, defaultValue = "1942") String name, Model model) {
        APIParser parser = new APIParser();
        model.addAttribute("game",parser.Game(name));
        return "game";
    }
    @GetMapping("/games/search")
    public String search(@RequestParam(name="search") String searchString, Model model){

        APIParser parser = new APIParser();
        model.addAttribute("games", parser.SearchGames(searchString));
        return "games";
    }
}


