package learn.words.models.tables;

public class NewWord {
    int id;
    private String english_word;
    private String russian_word;

    public int getId() {
        return id;
    }

    public String getEnglish_word() {
        return english_word;
    }

    public void setEnglish_word(String english_word) {
        this.english_word = english_word;
    }

    public String getRussian_word() {
        return russian_word;
    }

    public void setRussian_word(String russian_word) {
        this.russian_word = russian_word;
    }

    @Override
    public String toString() {
        return "Words{" +
                "id=" + id +
                ", english_word='" + english_word + '\'' +
                ", russian_word='" + russian_word + '\'' +
                '}';
    }
}
