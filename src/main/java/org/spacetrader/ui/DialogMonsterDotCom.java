package org.spacetrader.ui;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;


/**
 * A public dialog form to display details of currently-available mercenaries, quests, and shipyards.
 *
 * @author Gregory
 */
public class DialogMonsterDotCom extends JDialog {
    private static final long serialVersionUID = 1L;

    /**
     * Creates new form DialogMonsterDotCom
     */
    public DialogMonsterDotCom(Frame parent, boolean modal) {
        super(parent, modal);

        JPanel panel1 = new JPanel();
        JScrollPane scrollPane1 = new JScrollPane();
        JList<String> list1 = new JList<>();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("The Monster-Dot-Com Jobs Board");
        setAlwaysOnTop(true);

        panel1.setBorder(BorderFactory.createTitledBorder(null, "Available Quests", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION, null, new Color(0, 0, 255)));

        scrollPane1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        list1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        scrollPane1.setViewportView(list1);

        GroupLayout panel1Layout = new GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(panel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                                .addContainerGap())
        );
        panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(panel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                                .addContainerGap())
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(397, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(181, Short.MAX_VALUE))
        );
        pack();
    }

}
