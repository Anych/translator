package learn.words;

import learn.words.view.window.AbstractWindowBuilder;
import learn.words.view.window.MainWindow;

public class App {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            AbstractWindowBuilder mainWindow = new MainWindow();
            mainWindow.createWindow();
        });
    }
}
