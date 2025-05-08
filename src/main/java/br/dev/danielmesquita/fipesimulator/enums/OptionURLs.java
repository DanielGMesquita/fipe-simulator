package br.dev.danielmesquita.fipesimulator.enums;

public enum OptionURLs {
    CAR("carros/marcas"),
    MOTORCYCLE("motos/marcas"),
    TRUCK("truck");

    private final String url;

    OptionURLs(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public static OptionURLs fromString(String url) {
        for (OptionURLs option : OptionURLs.values()) {
            if (option.url.equalsIgnoreCase(url)) {
                return option;
            }
        }
        throw new IllegalArgumentException("No constant with text " + url + " found");
    }
}
