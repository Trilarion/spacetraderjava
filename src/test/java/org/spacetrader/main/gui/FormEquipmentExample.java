package org.spacetrader.main.gui;

import org.spacetrader.Main;
import org.spacetrader.ui.FormEquipment;

public class FormEquipmentExample {

    private FormEquipmentExample() {}

    public static void main(String[] args) throws Exception {
        FormEquipment fe = new FormEquipment();
        Main.runForm(fe);
    }
}
