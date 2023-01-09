package learn.words.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "progress")
public class Progress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "from_russian", nullable = false)
    private boolean fromRussian;
    @Column(name = "from_english", nullable = false)
    private boolean fromEnglish;
    @ManyToOne
    @JoinColumn(name = "word_id")
    private Word wordId;

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

    public Word getWordId() {
        return wordId;
    }

    public void setWordId(Word wordId) {
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
