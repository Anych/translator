package learn.words.views.elements.buttons.gridButton;

import learn.words.views.windows.AbstractWindow;

import javax.swing.*;

public record OpenNewWindowGridButtonOptions(AbstractWindow newWindow, JFrame frame,
                                             String buttonName, int gridX, int gridY) {}
