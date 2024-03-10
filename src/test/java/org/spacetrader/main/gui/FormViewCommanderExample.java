package org.spacetrader.main.gui;

import org.spacetrader.Main;
import org.spacetrader.ui.FormViewCommander;

public class FormViewCommanderExample {

    private FormViewCommanderExample() {}

    public static void main(String[] args) throws Exception {
        FormViewCommander form = new FormViewCommander();
        Main.runForm(form);
    }
}
