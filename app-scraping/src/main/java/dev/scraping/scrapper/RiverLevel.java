package dev.scraping.scrapper;

import dev.scraping.http.ItuporangaCivilDefense;
import org.jsoup.Jsoup;

public class RiverLevel {
    private ItuporangaCivilDefense httpService;

    public RiverLevel() {
        this.httpService = new ItuporangaCivilDefense();
    }

    public String getRiverLevel() {
        var document = Jsoup.parse(httpService.getData());
        var value = document.selectFirst("#page-content > div > div > div > div > div > div > div:nth-child(3) > h4:nth-child(2) > b > span");

        return value.text();
    }

    public void printRiverLevel() {
        System.out.println(getRiverLevel());
    }
}
