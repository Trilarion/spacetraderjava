package org.spacetrader.main.gui;

import org.spacetrader.ui.DialogViewCommander;

public class FormViewCommanderExample {

    private FormViewCommanderExample() {}

    public static void main(String[] args) throws Exception {
        DialogViewCommander form = new DialogViewCommander();
        form.ShowDialog(null);
    }
}
