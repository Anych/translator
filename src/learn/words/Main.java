package learn.words;

public class Main {

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            Dialog mainDialog = new MainDialog("Слова бегом");
            mainDialog.renderWindow();
        });
    }
}
