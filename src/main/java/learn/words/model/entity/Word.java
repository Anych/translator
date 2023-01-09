package learn.words.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "words")
public class Word {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, unique = true)
    private String english;
    @Column(nullable = false)
    private String russian;

    public int getId() {
        return id;
    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english_word) {
        this.english = english_word;
    }

    public String getRussian() {
        return russian;
    }

    public void setRussian(String russian_word) {
        this.russian = russian_word;
    }

    @Override
    public String toString() {
        return "Words{" +
                "id=" + id +
                ", english_word='" + english + '\'' +
                ", russian_word='" + russian + '\'' +
                '}';
    }
}
