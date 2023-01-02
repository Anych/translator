package learn.words;

import learn.words.windows.AbstractWindow;
import learn.words.windows.MainWindow;

public class App {

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            AbstractWindow mainWindow = new MainWindow();
            mainWindow.renderWindow();
            mainWindow.createElements();
        });
    }
}
