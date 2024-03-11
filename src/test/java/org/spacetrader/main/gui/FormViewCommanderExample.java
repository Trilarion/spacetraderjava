package org.spacetrader.main.gui;

import org.spacetrader.ui.FormViewCommander;

public class FormViewCommanderExample {

    private FormViewCommanderExample() {}

    public static void main(String[] args) throws Exception {
        FormViewCommander form = new FormViewCommander();
        form.ShowDialog(null);
    }
}
