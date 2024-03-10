package org.spacetrader.ui;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;


/**
 * @author Gregory
 */
public class MonsterQuestCellRenderer extends JPanel implements ListCellRenderer<MonsterQuestData> {
    private static final long serialVersionUID = 1L;
    private JLabel label1;
    private JLabel label2;

    /**
     * Creates new form MonsterQuestCellRenderer
     */
    public MonsterQuestCellRenderer() {

        label1 = new JLabel();
        label2 = new JLabel();

        setBorder(BorderFactory.createEtchedBorder());
        setFont(getFont().deriveFont(getFont().getSize() - 1f));

        label1.setFont(getFont());
        label1.setText("<unknown>");
        label1.setToolTipText("The solar system where this quest can be encountered.");

        label2.setFont(getFont());
        label2.setText("<untitled quest>");
        label2.setToolTipText("The name of the quest.");

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(label1)
                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                .addComponent(label2, GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(Alignment.BASELINE)
                                .addComponent(label1)
                                .addComponent(label2))
        );
    }

    @Override
    public MonsterQuestCellRenderer getListCellRendererComponent(
            JList<? extends MonsterQuestData> list, MonsterQuestData value,
            int index, boolean isSelected, boolean cellHasFocus) {
        setBackground((isSelected) ? list.getSelectionBackground() : list.getBackground());
        setForeground((isSelected) ? list.getSelectionForeground() : list.getForeground());
        label1.setText(value.system);
        label2.setText(String.format("{0}. {1}", index, value.quest));
        return this;
    }

}
