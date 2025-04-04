package usantatecla.movies.v22;

public class MovieBuilder {
    private String title;
    private String type;

    public MovieBuilder() {
        title = "movieName";
    }

    public MovieBuilder title(String title) {
        this.title = title;
        return this;
    }

    public MovieBuilder childrens() {
        this.type = "children";
        return this;
    }

    public MovieBuilder regular() {
        this.type = "regular";
        return this;
    }

    public MovieBuilder newRelease() {
        this.type = "newRelease";
        return this;
    }

    public Movie build() {
        switch(type) {
            case "children":
                return Movie.children(title);
            case "regular":
                return Movie.regular(title);
            case "newRelease":
                return Movie.newRelease(title);
            default:
                throw new IllegalArgumentException("Unknown movie type");
        }
    }
}
