package learn.words.models.tables;

public class Progress {
    private int id;
    private boolean fromRussian;
    private boolean fromEnglish;
    private int wordId;

    public int getId() {
        return id;
    }

    public boolean isFromRussian() {
        return fromRussian;
    }

    public void setFromRussian(boolean fromRussian) {
        this.fromRussian = fromRussian;
    }

    public boolean isFromEnglish() {
        return fromEnglish;
    }

    public void setFromEnglish(boolean fromEnglish) {
        this.fromEnglish = fromEnglish;
    }

    public int getWordId() {
        return wordId;
    }

    public void setWordId(int wordId) {
        this.wordId = wordId;
    }

    @Override
    public String toString() {
        return "Progress{" +
                "id=" + id +
                ", from_russian=" + fromRussian +
                ", from_english=" + fromEnglish +
                ", word_id=" + wordId +
                '}';
    }
}
