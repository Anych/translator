package learn.words.buttons.gridButton;

import learn.words.windows.AbstractWindow;

import javax.swing.*;

public record GridButtonOptions(AbstractWindow newWindow, JFrame frame, String buttonName, int gridX, int gridY) {}
