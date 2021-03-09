package pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Issue implements Serializable {

    private int number;
    private String title;

    public long getNumber() {
        return number;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Issue{" +
                "number=" + number +
                ", title='" + title + '\'' +
                '}';
    }
}
