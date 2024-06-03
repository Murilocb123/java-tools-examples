package dev.scraping.http;

import dev.scraping.enums.Paths;
import kong.unirest.Unirest;

public class ItuporangaCivilDefense {
    private String url;
    private Unirest unirest;

    public ItuporangaCivilDefense() {
        this.url = Paths.ITUPORANGA_CIVIL_DEFENSE.get();
        this.unirest = new Unirest();
    }

    public String getData() {
        return unirest.get(url).asString().getBody();
    }
}
