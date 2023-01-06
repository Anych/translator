package learn.words.models.json;

import java.util.List;

public class TranslateResponse {
    public List<Translations> translations;

    @Override
    public String toString() {
        return "TranslateResponse{" +
                "translations=" + translations +
                '}';
    }
}
