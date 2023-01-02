package learn.words.buttons;

import learn.words.dialogs.AbstractDialog;

public record GridButtonOptions(AbstractDialog dialog, String buttonName, int gridX, int gridY) {
}
