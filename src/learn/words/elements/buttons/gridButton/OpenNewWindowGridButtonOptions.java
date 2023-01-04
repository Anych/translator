package learn.words.elements.buttons.gridButton;

import learn.words.windows.AbstractWindow;

import javax.swing.*;

public record OpenNewWindowGridButtonOptions(AbstractWindow newWindow, JFrame frame,
                                             String buttonName, int gridX, int gridY) {}
