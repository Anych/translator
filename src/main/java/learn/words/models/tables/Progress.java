package learn.words.models.tables;

public class Progress {
    private int id;
    private boolean from_russian;
    private boolean from_english;
    private int word_id;

    public int getId() {
        return id;
    }

    public boolean isFrom_russian() {
        return from_russian;
    }

    public void setFrom_russian(boolean from_russian) {
        this.from_russian = from_russian;
    }

    public boolean isFrom_english() {
        return from_english;
    }

    public void setFrom_english(boolean from_english) {
        this.from_english = from_english;
    }

    public int getWord_id() {
        return word_id;
    }

    public void setWord_id(int word_id) {
        this.word_id = word_id;
    }

    @Override
    public String toString() {
        return "Progress{" +
                "id=" + id +
                ", from_russian=" + from_russian +
                ", from_english=" + from_english +
                ", word_id=" + word_id +
                '}';
    }
}
