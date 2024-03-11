package org.spacetrader.ui;

import org.spacetrader.controller.Constants;
import org.spacetrader.model.events.SpecialEvent;
import org.spacetrader.model.enums.AlertType;
import org.spacetrader.model.events.SpecialEventType;
import org.winforms.Button;
import org.winforms.Label;
import org.winforms.*;
import org.winforms.enums.*;

import java.awt.*;
import java.util.Arrays;


public class FormTest extends wfForm {
    private final ComboBox selAlertType;
    private final ComboBox selSpecialEvent;
    private final TextBox txtValue1;
    private final TextBox txtValue2;
    private final TextBox txtValue3;

    public FormTest() {
        Label labelAlertType = new Label();
        GroupBox boxAlert = new GroupBox();
        Button buttonTestAlert = new Button();
        txtValue3 = new TextBox();
        txtValue2 = new TextBox();
        txtValue1 = new TextBox();
        selAlertType = new ComboBox();
        Label labelValue3 = new Label();
        Label labelValue1 = new Label();
        Label labelValue2 = new Label();
        GroupBox groupBox1 = new GroupBox();
        Button buttonTestSpecialEvent = new Button();
        selSpecialEvent = new ComboBox();
        Label labelSpecialEvent = new Label();
        boxAlert.SuspendLayout();
        groupBox1.SuspendLayout();
        SuspendLayout();
        // labelAlertType
        labelAlertType.setAutoSize(true);
        labelAlertType.setLocation(new Point(8, 19));
        labelAlertType.setName("labelAlertType");
        labelAlertType.setSize(new FormSize(56, 13));
        labelAlertType.setTabIndex(0);
        labelAlertType.setText("Alert Type");
        // boxAlert
        boxAlert.Controls.addAll(buttonTestAlert, txtValue3, txtValue2, txtValue1, selAlertType, labelValue3, labelValue1, labelValue2, labelAlertType);
        boxAlert.setLocation(new Point(8, 8));
        boxAlert.setName("boxAlert");
        boxAlert.setSize(new FormSize(200, 152));
        boxAlert.setTabIndex(1);
        boxAlert.setTabStop(false);
        boxAlert.setText("Test Alert");
        // buttonTestAlert
        buttonTestAlert.setFlatStyle(FlatStyle.Flat);
        buttonTestAlert.setLocation(new Point(80, 120));
        buttonTestAlert.setName("buttonTestAlert");
        buttonTestAlert.setSize(new FormSize(41, 22));
        buttonTestAlert.setTabIndex(8);
        buttonTestAlert.setText("Test");
        buttonTestAlert.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData e) {
                buttonTestAlert_Click();
            }
        });
        // txtValue3
        txtValue3.setLocation(new Point(72, 88));
        txtValue3.setName("txtValue3");
        txtValue3.setSize(new FormSize(120, 20));
        txtValue3.setTabIndex(7);
        txtValue3.setText("");
        // txtValue2
        txtValue2.setLocation(new Point(72, 64));
        txtValue2.setName("txtValue2");
        txtValue2.setSize(new FormSize(120, 20));
        txtValue2.setTabIndex(6);
        txtValue2.setText("");
        // txtValue1
        txtValue1.setLocation(new Point(72, 40));
        txtValue1.setName("txtValue1");
        txtValue1.setSize(new FormSize(120, 20));
        txtValue1.setTabIndex(5);
        txtValue1.setText("");
        // selAlertType
        selAlertType.DropDownStyle = ComboBoxStyle.DropDownList;
        selAlertType.setLocation(new Point(72, 16));
        selAlertType.setName("selAlertType");
        selAlertType.setSize(new FormSize(120, 21));
        selAlertType.setTabIndex(4);
        // labelValue3
        labelValue3.setAutoSize(true);
        labelValue3.setLocation(new Point(8, 91));
        labelValue3.setName("labelValue3");
        labelValue3.setSize(new FormSize(43, 13));
        labelValue3.setTabIndex(3);
        labelValue3.setText("Value 3");
        // labelValue1
        labelValue1.setAutoSize(true);
        labelValue1.setLocation(new Point(8, 43));
        labelValue1.setName("labelValue1");
        labelValue1.setSize(new FormSize(43, 13));
        labelValue1.setTabIndex(2);
        labelValue1.setText("Value 1");
        // labelValue2
        labelValue2.setAutoSize(true);
        labelValue2.setLocation(new Point(8, 67));
        labelValue2.setName("labelValue2");
        labelValue2.setSize(new FormSize(43, 13));
        labelValue2.setTabIndex(1);
        labelValue2.setText("Value 2");
        // groupBox1
        groupBox1.Controls.addAll(buttonTestSpecialEvent, selSpecialEvent, labelSpecialEvent);
        groupBox1.setLocation(new Point(8, 168));
        groupBox1.setName("groupBox1");
        groupBox1.setSize(new FormSize(200, 80));
        groupBox1.setTabIndex(2);
        groupBox1.setTabStop(false);
        groupBox1.setText("Test Special Alert");
        // buttonTestSpecialEvent
        buttonTestSpecialEvent.setFlatStyle(FlatStyle.Flat);
        buttonTestSpecialEvent.setLocation(new Point(80, 48));
        buttonTestSpecialEvent.setName("buttonTestSpecialEvent");
        buttonTestSpecialEvent.setSize(new FormSize(41, 22));
        buttonTestSpecialEvent.setTabIndex(8);
        buttonTestSpecialEvent.setText("Test");
        buttonTestSpecialEvent.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData e) {
                buttonTestSpecialEvent_Click();
            }
        });
        // selSpecialEvent
        selSpecialEvent.DropDownStyle = ComboBoxStyle.DropDownList;
        selSpecialEvent.setLocation(new Point(88, 16));
        selSpecialEvent.setName("selSpecialEvent");
        selSpecialEvent.setSize(new FormSize(104, 21));
        selSpecialEvent.setTabIndex(4);
        // labelSpecialEvent
        labelSpecialEvent.setAutoSize(true);
        labelSpecialEvent.setLocation(new Point(8, 19));
        labelSpecialEvent.setName("labelSpecialEvent");
        labelSpecialEvent.setSize(new FormSize(73, 13));
        labelSpecialEvent.setTabIndex(0);
        labelSpecialEvent.setText("Special Event");
        // FormTest
        setAutoScaleBaseSize(new FormSize(5, 13));
        setClientSize(new FormSize(370, 255));
        Controls.addAll(Arrays.asList(groupBox1, boxAlert));
        setFormBorderStyle(FormBorderStyle.FixedDialog);
        setMaximizeBox(false);
        setMinimizeBox(false);
        setName("FormTest");
        setShowInTaskbar(false);
        setStartPosition(FormStartPosition.CenterParent);
        setText("Test");
        boxAlert.ResumeLayout(false);
        groupBox1.ResumeLayout(false);
        ResumeLayout(false);
        AlertType[] alerts = Arrays.copyOfRange(AlertType.values(), AlertType.Alert.ordinal(), AlertType.WildWontStayAboardReactor.ordinal());
        for (AlertType type : alerts) {
            selAlertType.Items.add(type);
        }
        selAlertType.setSelectedIndex(0);
        SpecialEventType[] events = Arrays.copyOfRange(SpecialEventType.values(), SpecialEventType.Artifact.ordinal(), SpecialEventType.WildGetsOut.ordinal());
        for (SpecialEventType type : events) {
            selSpecialEvent.Items.add(type);
        }
        selSpecialEvent.setSelectedIndex(0);
    }


    private void buttonTestAlert_Click() {
        FormAlert.Alert(AlertType.Alert, this, "Result", "The result was " + FormAlert.Alert((AlertType) selAlertType.getSelectedItem(),
                this, txtValue1.getText(), txtValue2.getText(), txtValue3.getText()).toString());
    }

    private void buttonTestSpecialEvent_Click() {
        SpecialEvent se = Constants.SpecialEvents[((SpecialEventType) selSpecialEvent.getSelectedItem()).getId()];
        String button1, button2;
        DialogResult res1, res2;
        if (se.MessageOnly()) {
            button1 = "Ok";
            button2 = null;
            res1 = DialogResult.OK;
            res2 = DialogResult.None;
        } else {
            button1 = "Yes";
            button2 = "No";
            res1 = DialogResult.Yes;
            res2 = DialogResult.No;
        }
        (new FormAlert(se.Title(), se.String(), button1, res1, button2, res2, null)).ShowDialog(this);
    }
}
