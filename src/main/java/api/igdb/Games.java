package api.igdb;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class Games {

    private String id;
    private String name;
    private String slug;
    private String summary;
    private String themes;

    public String getId() {
    return id;
    }
    public String getName() {
        return name;
    }
    public String getSlug() {
        return slug;
    }
    public String getSummary() {
        return summary;
    }
//    public String getThemes() {
//        return themes;
//    }


    @Override
    public String toString() {
        return "Game{" +
                "id=" + ' ' + id +
                ", name=" + ' ' + name +
                ", slug=" + ' ' + slug +
                ", summary=" + ' ' + summary +
//                ", themes=" + ' ' + themes +
                "}";
    }
}

