package org.spacetrader.ui;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;


/**
 * @author Gregory
 */
public class MonsterQuestCellRenderer extends JPanel implements ListCellRenderer<MonsterQuestData> {
    private static final long serialVersionUID = 1L;
    private JLabel jLabel1;
    private JLabel jLabel2;

    /**
     * Creates new form MonsterQuestCellRenderer
     */
    public MonsterQuestCellRenderer() {

        jLabel1 = new JLabel();
        jLabel2 = new JLabel();

        setBorder(BorderFactory.createEtchedBorder());
        setFont(getFont().deriveFont(getFont().getSize() - 1f));

        jLabel1.setFont(getFont());
        jLabel1.setText("<unknown>");
        jLabel1.setToolTipText("The solar system where this quest can be encountered.");

        jLabel2.setFont(getFont());
        jLabel2.setText("<untitled quest>");
        jLabel2.setToolTipText("The name of the quest.");

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                .addComponent(jLabel2, GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(jLabel2))
        );
    }

    @Override
    public MonsterQuestCellRenderer getListCellRendererComponent(
            JList<? extends MonsterQuestData> list, MonsterQuestData value,
            int index, boolean isSelected, boolean cellHasFocus) {
        setBackground((isSelected) ? list.getSelectionBackground() : list.getBackground());
        setForeground((isSelected) ? list.getSelectionForeground() : list.getForeground());
        jLabel1.setText(value.system);
        jLabel2.setText(String.format("{0}. {1}", index, value.quest));
        return this;
    }

}
