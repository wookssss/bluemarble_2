package itschool.bluemarble.goldenKey;

import itschool.bluemarble.goldenKey.ifs.Function;
import lombok.Getter;

@Getter
public class GoldenKey {
    private String title;

    private String description;

    private Function function;


    public GoldenKey(String title, String description, Function function) {
        this.title = title;
        this.description = description;
        this.function = function;
    }
}
