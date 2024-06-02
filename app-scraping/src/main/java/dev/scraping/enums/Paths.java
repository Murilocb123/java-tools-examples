package dev.scraping.enums;

public enum Paths {
    ITUPORANGA_CIVIL_DEFENSE("https://ituporanga.sc.gov.br/nivel-do-rio.html");

    private final String path;

    Paths(String path) {
        this.path = path;
    }

    public String get() {
        return path;
    }
}
