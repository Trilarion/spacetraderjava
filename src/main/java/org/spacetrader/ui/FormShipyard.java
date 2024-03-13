package org.spacetrader.ui;

import org.spacetrader.controller.*;
import org.spacetrader.model.crew.Commander;
import org.spacetrader.model.enums.AlertType;
import org.spacetrader.model.events.SpecialEvent;
import org.spacetrader.model.ship.*;
import org.spacetrader.util.Directory;
import org.spacetrader.util.Path;
import org.winforms.Button;
import org.winforms.Font;
import org.winforms.Label;
import org.winforms.*;
import org.winforms.enums.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Hashtable;


public class FormShipyard extends wfForm {
    private final Game game = Game.getCurrentGame();
    private final Commander commander = game.Commander();
    private final Shipyard yard = commander.CurrentSystem().Shipyard();
    private final ShipType[] imgTypes = new ShipType[]{
            ShipType.Flea, ShipType.Gnat, ShipType.Firefly, ShipType.Mosquito, ShipType.Bumblebee, ShipType.Beetle,
            ShipType.Hornet, ShipType.Grasshopper, ShipType.Termite, ShipType.Wasp, ShipType.Custom
    };
    private final Button buttonConstruct;
    private final Button buttonSave;
    private final ComboBox selSize;
    private final ComboBox selTemplate;
    private final Label labelDesignFee;
    private final Label labelShipCost;
    private final Label labelTotalCost;
    private final Label labelImage;
    private final Label labelPctLabel;
    private final Label labelPct;
    private final Label labelPenalty;
    private final Label labelSkillLabel;
    private final Label labelTradeIn;
    private final Label labelUnitsUsed;
    private final Label labelDisabledPct;
    private final Label labelDisabledName;
    private final NumericUpDown numHullStrength;
    private final NumericUpDown numCargoBays;
    private final NumericUpDown numCrewQuarters;
    private final NumericUpDown numFuelTanks;
    private final NumericUpDown numShieldSlots;
    private final NumericUpDown numGadgetSlots;
    private final NumericUpDown numWeaponSlots;
    private final OpenFileDialog dlgOpen;
    private final PictureBox pictureShip;
    private final SaveFileDialog dlgSave;
    private final TextBox txtName;
    private ArrayList<ShipSize> sizes = null;
    private wfImage[] customImages = new wfImage[Constants.ImagesPerShip];
    private boolean loading = false;
    private int imgIndex = 0;

    public FormShipyard() {
        ResourceManager resources = new ResourceManager(FormShipyard.class);
        GroupBox boxWelcome = new GroupBox();
        Label labelSkillDescription = new Label();
        Label labelSkill = new Label();
        Label labelSizeSpecialty = new Label();
        labelSkillLabel = new Label();
        Label labelSizeSpecialtyLabel = new Label();
        Label labelWelcome = new Label();
        Label labelWarning = new Label();
        PictureBox pictureLogo = new PictureBox();
        GroupBox boxInfo = new GroupBox();
        buttonSave = new Button();
        Button buttonLoad = new Button();
        PictureBox pictureInfoLine = new PictureBox();
        Button buttonPrevImage = new Button();
        Button buttonNextImage = new Button();
        labelImage = new Label();
        Label labelImageLabel = new Label();
        selTemplate = new ComboBox();
        Label labelTemplate = new Label();
        selSize = new ComboBox();
        Label labelSize = new Label();
        Button buttonSetCustomImage = new Button();
        pictureShip = new PictureBox();
        txtName = new TextBox();
        Label labelName = new Label();
        labelUnitsUsed = new Label();
        Label labelUnitsUsedLabel = new Label();
        GroupBox boxCosts = new GroupBox();
        labelTradeIn = new Label();
        Label labelTradeInLabel = new Label();
        PictureBox pictureCostsLine = new PictureBox();
        labelPenalty = new Label();
        Label labelPenaltyLabel = new Label();
        labelShipCost = new Label();
        labelTotalCost = new Label();
        Label labelTotalCostLabel = new Label();
        Label labelShipCostLabel = new Label();
        labelDesignFee = new Label();
        Label labelDesignFeeLabel = new Label();
        buttonConstruct = new Button();
        Button buttonCancel = new Button();
        GroupBox boxAllocation = new GroupBox();
        labelPct = new Label();
        labelPctLabel = new Label();
        numHullStrength = new NumericUpDown();
        Label labelHullStrengthLabel = new Label();
        numCargoBays = new NumericUpDown();
        numCrewQuarters = new NumericUpDown();
        numFuelTanks = new NumericUpDown();
        numShieldSlots = new NumericUpDown();
        numGadgetSlots = new NumericUpDown();
        numWeaponSlots = new NumericUpDown();
        Label labelCargoBays = new Label();
        Label labelFuelTanks = new Label();
        Label labelCrewQuarters = new Label();
        Label labelShieldSlots = new Label();
        Label labelGadgetSlots = new Label();
        Label labelWeaponsSlots = new Label();
        ImageList ilShipyardLogos = new ImageList();
        dlgOpen = new OpenFileDialog();
        labelDisabledPct = new Label();
        dlgSave = new SaveFileDialog();
        labelDisabledName = new Label();
        boxWelcome.SuspendLayout();
        boxInfo.SuspendLayout();
        boxCosts.SuspendLayout();
        boxAllocation.SuspendLayout();
                                                                SuspendLayout();
        // boxWelcome
        boxWelcome.Controls.addAll(labelSkillDescription, labelSkill, labelSizeSpecialty, labelSkillLabel, labelSizeSpecialtyLabel, labelWarning, pictureLogo, labelWelcome);
        boxWelcome.setLocation(new Point(8, 0));
        boxWelcome.setName("boxWelcome");
        boxWelcome.setSize(new SizeF(204, 270));
        boxWelcome.setTabIndex(1);
        boxWelcome.setTabStop(false);
        // labelSkillDescription
        labelSkillDescription.setLocation(new Point(8, 98));
        labelSkillDescription.setName("labelSkillDescription");
        labelSkillDescription.setSize(new SizeF(26, 258));
        labelSkillDescription.setTabIndex(27);
        labelSkillDescription.setText("All ships constructed at this shipyard use 2 fewer units per crew quarter.");
        // labelSkill
        labelSkill.setLocation(new Point(180, 79));
        labelSkill.setName("labelSkill");
        labelSkill.setSize(new SizeF(13, 87));
        labelSkill.setTabIndex(26);
        labelSkill.setText("Crew Quartering");
        // labelSizeSpecialty
        labelSizeSpecialty.setLocation(new Point(180, 65));
        labelSizeSpecialty.setName("labelSizeSpecialty");
        labelSizeSpecialty.setSize(new SizeF(13, 64));
        labelSizeSpecialty.setTabIndex(25);
        labelSizeSpecialty.setText("Gargantuan");
        // labelSkillLabel
        labelSkillLabel.setAutoSize(true);
        labelSkillLabel.setFont(new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte) (0))));
        labelSkillLabel.setLocation(new Point(92, 79));
        labelSkillLabel.setName("labelSkillLabel");
        labelSkillLabel.setSize(new SizeF(13, 72));
        labelSkillLabel.setTabIndex(24);
        labelSkillLabel.setText("Special Skill:");
        // labelSizeSpecialtyLabel
        labelSizeSpecialtyLabel.setAutoSize(true);
        labelSizeSpecialtyLabel.setFont(new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte) (0))));
        labelSizeSpecialtyLabel.setLocation(new Point(92, 65));
        labelSizeSpecialtyLabel.setName("labelSizeSpecialtyLabel");
        labelSizeSpecialtyLabel.setSize(new SizeF(13, 82));
        labelSizeSpecialtyLabel.setTabIndex(23);
        labelSizeSpecialtyLabel.setText("Size Specialty:");
        // labelWelcome
        labelWelcome.setLocation(new Point(92, 12));
        labelWelcome.setName("labelWelcome");
        labelWelcome.setSize(new SizeF(52, 176));
        labelWelcome.setTabIndex(3);
        labelWelcome.setText("Welcome to Sorosuub Engineering Shipyards! Our best engineer, Obi-Wan, is at your service.");
        // labelWarning
        labelWarning.setLocation(new Point(8, 134));
        labelWarning.setName("labelWarning");
        labelWarning.setSize(new SizeF(65, 258));
        labelWarning.setTabIndex(5);
        labelWarning.setText("Bear in mind that getting too close to the maximum number of units will result in a \"Crowding Penalty\" due to the engineering difficulty of squeezing everything in. There is a modest penalty at 80%, and a more severe one at 90%.");
        // pictureLogo
        pictureLogo.setBackColor(Color.black);
        pictureLogo.setLocation(new Point(8, 12));
        pictureLogo.setName("pictureLogo");
        pictureLogo.setSize(new SizeF(80, 80));
        pictureLogo.SizeMode = PictureBoxSizeMode.StretchImage;
        pictureLogo.setTabIndex(22);
        pictureLogo.setTabStop(false);
        // boxInfo
        boxInfo.Controls.addAll(buttonSave, buttonLoad, pictureInfoLine, buttonPrevImage, buttonNextImage, labelImage, labelImageLabel, selTemplate,
                labelTemplate, selSize, labelSize, buttonSetCustomImage, pictureShip, txtName, labelName);
        boxInfo.setLocation(new Point(8, 208));
        boxInfo.setName("boxInfo");
        boxInfo.setSize(new SizeF(160, 270));
        boxInfo.setTabIndex(2);
        boxInfo.setTabStop(false);
        boxInfo.setText("Info");
        // buttonSave
        buttonSave.setFlatStyle(FlatStyle.Flat);
        buttonSave.setLocation(new Point(216, 40));
        buttonSave.setName("buttonSave");
        buttonSave.setSize(new SizeF(20, 44));
        buttonSave.setTabIndex(4);
        buttonSave.setText("Save");
        buttonSave.setClick(
                new EventHandler<>() {
                    @Override
                    public void handle(Object sender, EventData data) {
                        buttonSave_Click(sender, data);
                    }
                });
        buttonSave.setMouseEnter(
                new EventHandler<>() {
                    @Override
                    public void handle(Object sender, EventData data) {
                        buttonSave_MouseEnter(sender, data);
                    }
                });
        buttonSave.setMouseLeave(
                new EventHandler<>() {
                    @Override
                    public void handle(Object sender, EventData data) {
                        buttonSave_MouseLeave(sender, data);
                    }
                });
        // buttonLoad
        buttonLoad.setFlatStyle(FlatStyle.Flat);
        buttonLoad.setLocation(new Point(216, 16));
        buttonLoad.setName("buttonLoad");
        buttonLoad.setSize(new SizeF(20, 44));
        buttonLoad.setTabIndex(2);
        buttonLoad.setText("Load");
        buttonLoad.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonLoad_Click(sender, data);
            }
        });
        // pictureInfoLine
        pictureInfoLine.setBackColor(Color.darkGray);
        pictureInfoLine.setLocation(new Point(8, 89));
        pictureInfoLine.setName("pictureInfoLine");
        pictureInfoLine.setSize(new SizeF(1, 254));
        pictureInfoLine.setTabIndex(132);
        pictureInfoLine.setTabStop(false);
        // buttonPrevImage
        buttonPrevImage.setFlatStyle(FlatStyle.Flat);
        buttonPrevImage.setLocation(new Point(154, 95));
        buttonPrevImage.setName("buttonPrevImage");
        buttonPrevImage.setSize(new SizeF(18, 18));
        buttonPrevImage.setTabIndex(6);
        buttonPrevImage.setText("<");
        buttonPrevImage.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonPrevImage_Click(sender, data);
            }
        });
        // buttonNextImage
        buttonNextImage.setFlatStyle(FlatStyle.Flat);
        buttonNextImage.setLocation(new Point(242, 95));
        buttonNextImage.setName("buttonNextImage");
        buttonNextImage.setSize(new SizeF(18, 18));
        buttonNextImage.setTabIndex(7);
        buttonNextImage.setText(">");
        buttonNextImage.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonNextImage_Click(sender, data);
            }
        });
        // labelImage
        labelImage.setLocation(new Point(174, 98));
        labelImage.setName("labelImage");
        labelImage.setSize(new SizeF(13, 70));
        labelImage.setTabIndex(61);
        labelImage.setText("Custom Ship");
        labelImage.TextAlign = ContentAlignment.TopCenter;
        // labelImageLabel
        labelImageLabel.setAutoSize(true);
        labelImageLabel.setLocation(new Point(8, 95));
        labelImageLabel.setName("labelImageLabel");
        labelImageLabel.setSize(new SizeF(13, 39));
        labelImageLabel.setTabIndex(22);
        labelImageLabel.setText("Image:");
        // selTemplate
        selTemplate.DropDownStyle = ComboBoxStyle.DropDownList;
        selTemplate.setLocation(new Point(80, 16));
        selTemplate.setName("selTemplate");
        selTemplate.setSize(new SizeF(21, 132));
        selTemplate.setTabIndex(1);
        // labelTemplate
        labelTemplate.setAutoSize(true);
        labelTemplate.setLocation(new Point(8, 19));
        labelTemplate.setName("labelTemplate");
        labelTemplate.setSize(new SizeF(13, 55));
        labelTemplate.setTabIndex(20);
        labelTemplate.setText("Template:");
        // selSize
        selSize.DropDownStyle = ComboBoxStyle.DropDownList;
        selSize.setLocation(new Point(80, 63));
        selSize.setName("selSize");
        selSize.setSize(new SizeF(21, 180));
        selSize.setTabIndex(5);
        selSize.setSelectedIndexChanged(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                selSize_SelectedIndexChanged(sender, data);
            }
        });
        // labelSize
        labelSize.setAutoSize(true);
        labelSize.setLocation(new Point(8, 66));
        labelSize.setName("labelSize");
        labelSize.setSize(new SizeF(13, 29));
        labelSize.setTabIndex(18);
        labelSize.setText("Size:");
        // buttonSetCustomImage
        buttonSetCustomImage.setFlatStyle(FlatStyle.Flat);
        buttonSetCustomImage.setLocation(new Point(154, 121));
        buttonSetCustomImage.setName("buttonSetCustomImage");
        buttonSetCustomImage.setSize(new SizeF(22, 106));
        buttonSetCustomImage.setTabIndex(8);
        buttonSetCustomImage.setText("Set Custom...");
        buttonSetCustomImage.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonSetCustomImage_Click(sender, data);
            }
        });
        // pictureShip
        pictureShip.setBackColor(Color.white);
        pictureShip.setBorderStyle(BorderStyle.FixedSingle);
        pictureShip.setLocation(new Point(80, 95));
        pictureShip.setName("pictureShip");
        pictureShip.setSize(new SizeF(54, 66));
        pictureShip.setTabIndex(14);
        pictureShip.setTabStop(false);
        // txtName
        txtName.setLocation(new Point(80, 40));
        txtName.setName("txtName");
        txtName.setSize(new SizeF(20, 132));
        txtName.setTabIndex(3);
        txtName.setText("");
        txtName.setTextChanged(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                txtName_TextChanged(sender, data);
            }
        });
        // labelName
        labelName.setAutoSize(true);
        labelName.setLocation(new Point(8, 44));
        labelName.setName("labelName");
        labelName.setSize(new SizeF(13, 63));
        labelName.setTabIndex(5);
        labelName.setText("Ship Name:");
        // labelUnitsUsed
        labelUnitsUsed.setLocation(new Point(110, 186));
        labelUnitsUsed.setName("labelUnitsUsed");
        labelUnitsUsed.setSize(new SizeF(13, 23));
        labelUnitsUsed.setTabIndex(17);
        labelUnitsUsed.setText("888");
        labelUnitsUsed.TextAlign = ContentAlignment.TopRight;
        // labelUnitsUsedLabel
        labelUnitsUsedLabel.setAutoSize(true);
        labelUnitsUsedLabel.setLocation(new Point(8, 186));
        labelUnitsUsedLabel.setName("labelUnitsUsedLabel");
        labelUnitsUsedLabel.setSize(new SizeF(13, 63));
        labelUnitsUsedLabel.setTabIndex(16);
        labelUnitsUsedLabel.setText("Units Used:");
        // boxCosts
        boxCosts.Controls.addAll(labelTradeIn, labelTradeInLabel, pictureCostsLine, labelPenalty, labelPenaltyLabel,
                labelShipCost, labelTotalCost, labelTotalCostLabel, labelShipCostLabel, labelDesignFee, labelDesignFeeLabel);
        boxCosts.setLocation(new Point(286, 230));
        boxCosts.setName("boxCosts");
        boxCosts.setSize(new SizeF(106, 184));
        boxCosts.setTabIndex(4);
        boxCosts.setTabStop(false);
        boxCosts.setText("Costs");
        // labelTradeIn
        labelTradeIn.setLocation(new Point(106, 64));
        labelTradeIn.setName("labelTradeIn");
        labelTradeIn.setSize(new SizeF(16, 75));
        labelTradeIn.setTabIndex(135);
        labelTradeIn.setText("-8,888,888 cr.");
        labelTradeIn.TextAlign = ContentAlignment.TopRight;
        // labelTradeInLabel
        labelTradeInLabel.setAutoSize(true);
        labelTradeInLabel.setLocation(new Point(8, 64));
        labelTradeInLabel.setName("labelTradeInLabel");
        labelTradeInLabel.setSize(new SizeF(13, 77));
        labelTradeInLabel.setTabIndex(134);
        labelTradeInLabel.setText("Less Trade-In:");
        // pictureCostsLine
        pictureCostsLine.setBackColor(Color.darkGray);
        pictureCostsLine.setLocation(new Point(8, 80));
        pictureCostsLine.setName("pictureCostsLine");
        pictureCostsLine.setSize(new SizeF(1, 168));
        pictureCostsLine.setTabIndex(133);
        pictureCostsLine.setTabStop(false);
        // labelPenalty
        labelPenalty.setLocation(new Point(106, 32));
        labelPenalty.setName("labelPenalty");
        labelPenalty.setSize(new SizeF(16, 74));
        labelPenalty.setTabIndex(21);
        labelPenalty.setText("8,888,888 cr.");
        labelPenalty.TextAlign = ContentAlignment.TopRight;
        // labelPenaltyLabel
        labelPenaltyLabel.setAutoSize(true);
        labelPenaltyLabel.setLocation(new Point(8, 32));
        labelPenaltyLabel.setName("labelPenaltyLabel");
        labelPenaltyLabel.setSize(new SizeF(13, 96));
        labelPenaltyLabel.setTabIndex(20);
        labelPenaltyLabel.setText("Crowding Penalty:");
        // labelShipCost
        labelShipCost.setLocation(new Point(106, 16));
        labelShipCost.setName("labelShipCost");
        labelShipCost.setSize(new SizeF(16, 74));
        labelShipCost.setTabIndex(19);
        labelShipCost.setText("8,888,888 cr.");
        labelShipCost.TextAlign = ContentAlignment.TopRight;
        // labelTotalCost
        labelTotalCost.setLocation(new Point(106, 84));
        labelTotalCost.setName("labelTotalCost");
        labelTotalCost.setSize(new SizeF(16, 74));
        labelTotalCost.setTabIndex(18);
        labelTotalCost.setText("8,888,888 cr.");
        labelTotalCost.TextAlign = ContentAlignment.TopRight;
        // labelTotalCostLabel
        labelTotalCostLabel.setAutoSize(true);
        labelTotalCostLabel.setLocation(new Point(8, 84));
        labelTotalCostLabel.setName("labelTotalCostLabel");
        labelTotalCostLabel.setSize(new SizeF(13, 59));
        labelTotalCostLabel.setTabIndex(17);
        labelTotalCostLabel.setText("Total Cost:");
        // labelShipCostLabel
        labelShipCostLabel.setAutoSize(true);
        labelShipCostLabel.setLocation(new Point(8, 16));
        labelShipCostLabel.setName("labelShipCostLabel");
        labelShipCostLabel.setSize(new SizeF(13, 56));
        labelShipCostLabel.setTabIndex(16);
        labelShipCostLabel.setText("Ship Cost:");
        // labelDesignFee
        labelDesignFee.setLocation(new Point(106, 48));
        labelDesignFee.setName("labelDesignFee");
        labelDesignFee.setSize(new SizeF(16, 74));
        labelDesignFee.setTabIndex(15);
        labelDesignFee.setText("888,888 cr.");
        labelDesignFee.TextAlign = ContentAlignment.TopRight;
        // labelDesignFeeLabel
        labelDesignFeeLabel.setAutoSize(true);
        labelDesignFeeLabel.setLocation(new Point(8, 48));
        labelDesignFeeLabel.setName("labelDesignFeeLabel");
        labelDesignFeeLabel.setSize(new SizeF(13, 65));
        labelDesignFeeLabel.setTabIndex(14);
        labelDesignFeeLabel.setText("Design Fee:");
        // buttonConstruct
        buttonConstruct.setFlatStyle(FlatStyle.Flat);
        buttonConstruct.setForeColor(SystemColors.ControlText);
        buttonConstruct.setLocation(new Point(382, 344));
        buttonConstruct.setName("buttonConstruct");
        buttonConstruct.setSize(new SizeF(22, 88));
        buttonConstruct.setTabIndex(6);
        buttonConstruct.setText("Construct Ship");
        buttonConstruct.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonConstruct_Click(sender, data);
            }
        });
        buttonConstruct.setMouseEnter(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonConstruct_MouseEnter(sender, data);
            }
        });
        buttonConstruct.setMouseLeave(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonConstruct_MouseLeave(sender, data);
            }
        });
        // buttonCancel
        buttonCancel.setDialogResult(DialogResult.Cancel);
        buttonCancel.setFlatStyle(FlatStyle.Flat);
        buttonCancel.setLocation(new Point(286, 344));
        buttonCancel.setName("buttonCancel");
        buttonCancel.setSize(new SizeF(22, 88));
        buttonCancel.setTabIndex(5);
        buttonCancel.setText("Cancel Design");
        // boxAllocation
        boxAllocation.Controls.addAll(labelPct, labelPctLabel, numHullStrength, labelHullStrengthLabel, numCargoBays, numCrewQuarters, numFuelTanks,
                numShieldSlots, numGadgetSlots, numWeaponSlots, labelCargoBays, labelFuelTanks, labelCrewQuarters,
                labelShieldSlots, labelGadgetSlots, labelWeaponsSlots, labelUnitsUsedLabel, labelUnitsUsed);
        boxAllocation.setLocation(new Point(286, 0));
        boxAllocation.setName("boxAllocation");
        boxAllocation.setSize(new SizeF(226, 184));
        boxAllocation.setTabIndex(3);
        boxAllocation.setTabStop(false);
        boxAllocation.setText("Space Allocation");
        // labelPct
        labelPct.setFont(new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte) (0))));
        labelPct.setForeColor(Color.red);
        labelPct.setLocation(new Point(110, 204));
        labelPct.setName("labelPct");
        labelPct.setSize(new SizeF(13, 34));
        labelPct.setTabIndex(19);
        labelPct.setText("888%");
        labelPct.TextAlign = ContentAlignment.TopRight;
        // labelPctLabel
        labelPctLabel.setAutoSize(true);
        labelPctLabel.setLocation(new Point(8, 204));
        labelPctLabel.setName("labelPctLabel");
        labelPctLabel.setSize(new SizeF(13, 54));
        labelPctLabel.setTabIndex(18);
        labelPctLabel.setText("% of Max:");
        // numHullStrength
        numHullStrength.setBackColor(Color.white);
        numHullStrength.setLocation(new Point(110, 64));
        numHullStrength.setMaximum(9999);
        numHullStrength.setName("numHullStrength");
        numHullStrength.setReadOnly(true);
        numHullStrength.setSize(new SizeF(20, 64));
        numHullStrength.setTabIndex(1);
        numHullStrength.TextAlign = HorizontalAlignment.Right;
        numHullStrength.setEnter(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                num_ValueEnter(sender, data);
            }
        });
        numHullStrength.setValueChanged(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                num_ValueChanged(sender, data);
            }
        });
        // labelHullStrengthLabel
        labelHullStrengthLabel.setAutoSize(true);
        labelHullStrengthLabel.setLocation(new Point(8, 66));
        labelHullStrengthLabel.setName("labelHullStrengthLabel");
        labelHullStrengthLabel.setSize(new SizeF(13, 70));
        labelHullStrengthLabel.setTabIndex(13);
        labelHullStrengthLabel.setText("Hull Strength:");
        // numCargoBays
        numCargoBays.setBackColor(Color.white);
        numCargoBays.setLocation(new Point(110, 16));
        numCargoBays.setMaximum(999);
        numCargoBays.setName("numCargoBays");
        numCargoBays.setReadOnly(true);
        numCargoBays.setSize(new SizeF(20, 64));
        numCargoBays.setTabIndex(3);
        numCargoBays.TextAlign = HorizontalAlignment.Right;
        numCargoBays.setEnter(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                num_ValueEnter(sender, data);
            }
        });
        numCargoBays.setValueChanged(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                num_ValueChanged(sender, data);
            }
        });
        // numCrewQuarters
        numCrewQuarters.setBackColor(Color.white);
        numCrewQuarters.setLocation(new Point(110, 160));
        numCrewQuarters.setMinimum(1);
        numCrewQuarters.setName("numCrewQuarters");
        numCrewQuarters.setReadOnly(true);
        numCrewQuarters.setSize(new SizeF(20, 64));
        numCrewQuarters.setTabIndex(4);
        numCrewQuarters.TextAlign = HorizontalAlignment.Right;
        numCrewQuarters.setValue(1);
        numCrewQuarters.setEnter(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                num_ValueEnter(sender, data);
            }
        });
        numCrewQuarters.setValueChanged(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                num_ValueChanged(sender, data);
            }
        });
        // numFuelTanks
        numFuelTanks.setBackColor(Color.white);
        numFuelTanks.setLocation(new Point(110, 40));
        numFuelTanks.setName("numFuelTanks");
        numFuelTanks.setReadOnly(true);
        numFuelTanks.setSize(new SizeF(20, 64));
        numFuelTanks.setTabIndex(2);
        numFuelTanks.TextAlign = HorizontalAlignment.Right;
        numFuelTanks.setEnter(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                num_ValueEnter(sender, data);
            }
        });
        numFuelTanks.setValueChanged(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                num_ValueChanged(sender, data);
            }
        });
        // numShieldSlots
        numShieldSlots.setBackColor(Color.white);
        numShieldSlots.setLocation(new Point(110, 112));
        numShieldSlots.setName("numShieldSlots");
        numShieldSlots.setReadOnly(true);
        numShieldSlots.setSize(new SizeF(20, 64));
        numShieldSlots.setTabIndex(6);
        numShieldSlots.TextAlign = HorizontalAlignment.Right;
        numShieldSlots.setEnter(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                num_ValueEnter(sender, data);
            }
        });
        numShieldSlots.setValueChanged(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                num_ValueChanged(sender, data);
            }
        });
        // numGadgetSlots
        numGadgetSlots.setBackColor(Color.white);
        numGadgetSlots.setLocation(new Point(110, 136));
        numGadgetSlots.setName("numGadgetSlots");
        numGadgetSlots.setReadOnly(true);
        numGadgetSlots.setSize(new SizeF(20, 64));
        numGadgetSlots.setTabIndex(7);
        numGadgetSlots.TextAlign = HorizontalAlignment.Right;
        numGadgetSlots.setEnter(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                num_ValueEnter(sender, data);
            }
        });
        numGadgetSlots.setValueChanged(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                num_ValueChanged(sender, data);
            }
        });
        // numWeaponSlots
        numWeaponSlots.setBackColor(Color.white);
        numWeaponSlots.setLocation(new Point(110, 88));
        numWeaponSlots.setName("numWeaponSlots");
        numWeaponSlots.setReadOnly(true);
        numWeaponSlots.setSize(new SizeF(20, 64));
        numWeaponSlots.setTabIndex(5);
        numWeaponSlots.TextAlign = HorizontalAlignment.Right;
        numWeaponSlots.setEnter(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                num_ValueEnter(sender, data);
            }
        });
        numWeaponSlots.setValueChanged(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                num_ValueChanged(sender, data);
            }
        });
        // labelCargoBays
        labelCargoBays.setAutoSize(true);
        labelCargoBays.setLocation(new Point(8, 18));
        labelCargoBays.setName("labelCargoBays");
        labelCargoBays.setSize(new SizeF(13, 66));
        labelCargoBays.setTabIndex(5);
        labelCargoBays.setText("Cargo Bays:");
        // labelFuelTanks
        labelFuelTanks.setAutoSize(true);
        labelFuelTanks.setLocation(new Point(8, 42));
        labelFuelTanks.setName("labelFuelTanks");
        labelFuelTanks.setSize(new SizeF(13, 41));
        labelFuelTanks.setTabIndex(4);
        labelFuelTanks.setText("Range:");
        // labelCrewQuarters
        labelCrewQuarters.setAutoSize(true);
        labelCrewQuarters.setLocation(new Point(8, 162));
        labelCrewQuarters.setName("labelCrewQuarters");
        labelCrewQuarters.setSize(new SizeF(13, 81));
        labelCrewQuarters.setTabIndex(3);
        labelCrewQuarters.setText("Crew Quarters:");
        // labelShieldSlots
        labelShieldSlots.setAutoSize(true);
        labelShieldSlots.setLocation(new Point(8, 114));
        labelShieldSlots.setName("labelShieldSlots");
        labelShieldSlots.setSize(new SizeF(13, 67));
        labelShieldSlots.setTabIndex(2);
        labelShieldSlots.setText("Shield Slots:");
        // labelGadgetSlots
        labelGadgetSlots.setAutoSize(true);
        labelGadgetSlots.setLocation(new Point(8, 138));
        labelGadgetSlots.setName("labelGadgetSlots");
        labelGadgetSlots.setSize(new SizeF(13, 73));
        labelGadgetSlots.setTabIndex(1);
        labelGadgetSlots.setText("Gadget Slots:");
        // labelWeaponsSlots
        labelWeaponsSlots.setAutoSize(true);
        labelWeaponsSlots.setLocation(new Point(8, 90));
        labelWeaponsSlots.setName("labelWeaponsSlots");
        labelWeaponsSlots.setSize(new SizeF(13, 78));
        labelWeaponsSlots.setTabIndex(0);
        labelWeaponsSlots.setText("Weapon Slots:");
        // ilShipyardLogos
        ilShipyardLogos.ColorDepth = ColorDepth.Depth24Bit;
        ilShipyardLogos.setImageSize(new SizeF(80, 80));
        ilShipyardLogos.setImageStream(((ImageListStreamer) (resources.GetObject("ilShipyardLogos.ImageStream"))));
        ilShipyardLogos.setTransparentColor(Color.black);
        // dlgOpen
        dlgOpen.setFilter("Windows Bitmaps (*.bmp)|*bmp");
        dlgOpen.setTitle("Open Ship Image");
        // labelDisabledPct
        labelDisabledPct.setBackColor(SystemColors.Info);
        labelDisabledPct.setBorderStyle(BorderStyle.FixedSingle);
        labelDisabledPct.ImageAlign = ContentAlignment.MiddleRight;
        labelDisabledPct.setLocation(new Point(154, 182));
        labelDisabledPct.setName("labelDisabledPct");
        labelDisabledPct.setSize(new SizeF(20, 276));
        labelDisabledPct.setTabIndex(8);
        labelDisabledPct.setText("Your % of Max must be less than or equal to 100%.");
        labelDisabledPct.TextAlign = ContentAlignment.MiddleCenter;
        labelDisabledPct.setVisible(false);
        // dlgSave
        dlgSave.setDefaultExt("sst");
        dlgSave.setFileName("CustomShip.sst");
        dlgSave.setFilter("SpaceTrader Ship Template Files (*.sst)|*.sst");
        dlgSave.setTitle("Save Ship Template");
        // labelDisabledName
        labelDisabledName.setBackColor(SystemColors.Info);
        labelDisabledName.setBorderStyle(BorderStyle.FixedSingle);
        labelDisabledName.ImageAlign = ContentAlignment.MiddleLeft;
        labelDisabledName.setLocation(new Point(96, 222));
        labelDisabledName.setName("labelDisabledName");
        labelDisabledName.setSize(new SizeF(20, 170));
        labelDisabledName.setTabIndex(7);
        labelDisabledName.setText("You must enter a Ship Name.");
        labelDisabledName.TextAlign = ContentAlignment.MiddleRight;
        labelDisabledName.setVisible(false);
        // Form_Shipyard
        setAcceptButton(buttonConstruct);
        setAutoScaleBaseSize(new SizeF(13, 5));
        setCancelButton(buttonCancel);
        setClientSize(new SizeF(375, 478));
        Controls.addAll(Arrays.asList(labelDisabledPct, boxWelcome, labelDisabledName, boxAllocation, boxCosts, boxInfo, buttonCancel, buttonConstruct));
        setFormBorderStyle(FormBorderStyle.FixedDialog);
        setMaximizeBox(false);
        setMinimizeBox(false);
        setName("Form_Shipyard");
        setShowInTaskbar(false);
        setStartPosition(FormStartPosition.CenterParent);
        setText("Ship Design at XXXX Shipyards");
        boxWelcome.ResumeLayout(false);
        boxInfo.ResumeLayout(false);
        boxCosts.ResumeLayout(false);
        boxAllocation.ResumeLayout(false);
                                                                ResumeLayout(false);
        setText(Functions.StringVars(Strings.ShipyardTitle, yard.Name()));
        pictureLogo.setImage(ilShipyardLogos.getImages()[yard.Id().getId()]);
        labelWelcome.setText(Functions.StringVars(Strings.ShipyardWelcome, yard.Name(), yard.Engineer()));
        labelSizeSpecialty.setText(Strings.Sizes[yard.SpecialtySize().getId()]);
        labelSkill.setText(Strings.ShipyardSkills[yard.Skill().getId()]);
        labelSkillDescription.setText(Strings.ShipyardSkillDescriptions[yard.Skill().getId()]);
        labelWarning.setText(Functions.StringVars(Strings.ShipyardWarning, "" + Shipyard.PENALTY_FIRST_PCT, "" + Shipyard.PENALTY_SECOND_PCT));
        dlgOpen.setInitialDirectory(Constants.CustomImagesDirectory);
        dlgSave.setInitialDirectory(Constants.CustomTemplatesDirectory);
        labelDisabledName.setImage(game.getParentWindow().DirectionImages().getImages()[Constants.DirectionDown]);
        labelDisabledPct.setImage(game.getParentWindow().DirectionImages().getImages()[Constants.DirectionDown]);
        LoadSizes();
        LoadTemplateList();
        LoadSelectedTemplate();
    }


    private boolean ConstructButtonEnabled() {
        return yard.PercentOfMaxUnits() <= 100 && !txtName.getText().isEmpty();
    }

    private wfBitmap GetImageFile(String fileName) {
        wfBitmap image = null;
        try {
            image = new wfBitmap(fileName);
        } catch (Exception ex) {
            FormAlert.Alert(AlertType.FileErrorOpen, this, fileName, ex.getMessage());
        }
        return image;
    }

    private void LoadSelectedTemplate() {
        if (selTemplate.getSelectedItem() instanceof ShipTemplate) {
            loading = true;
            ShipTemplate template = (ShipTemplate) selTemplate.getSelectedItem();
            if (template.Name().equals(Strings.ShipNameCurrentShip)) {
                txtName.setText(commander.getShip().Name());
            } else if (template.Name().endsWith(Strings.ShipNameTemplateSuffixDefault) || template.Name().endsWith(Strings.ShipNameTemplateSuffixMinimum)) {
                txtName.setText("");
            } else {
                txtName.setText(template.Name());
            }
            selSize.setSelectedIndex(Math.max(0, sizes.indexOf(template.Size())));
            imgIndex = template.ImageIndex() == ShipType.Custom.getId() ? imgTypes.length - 1 : template.ImageIndex();
            if (template.Images() != null) {
                customImages = template.Images();
            } else {
                customImages = game.getParentWindow().CustomShipImages();
            }
            numCargoBays.setValue(template.CargoBays());
            numFuelTanks.setValue(Math.min(Math.max(numFuelTanks.getMinimum(), template.FuelTanks()), numFuelTanks.getMaximum()));
            numHullStrength.setValue(Math.min(Math.max(numHullStrength.getMinimum(), template.HullStrength()), numHullStrength.getMaximum()));
            numWeaponSlots.setValue(template.WeaponSlots());
            numShieldSlots.setValue(template.ShieldSlots());
            numGadgetSlots.setValue(template.GadgetSlots());
            numCrewQuarters.setValue(Math.max(numCrewQuarters.getMinimum(), template.CrewQuarters()));
            UpdateShip();
            UpdateCalculatedFigures();
            if (selTemplate.Items.getElementAt(0).toString().equals(Strings.ShipNameModified)) {
                selTemplate.Items.removeElementAt(0);
            }
            loading = false;
        }
    }

    private void LoadSizes() {
        sizes = new ArrayList<>(6);
        for (ShipSize size : yard.AvailableSizes()) {
            sizes.add(size);
            selSize.Items.addElement(Functions.StringVars(
                        Strings.ShipyardSizeItem, Strings.Sizes[size.getId()],
                        Functions.Multiples(Shipyard.MAX_UNITS[size.getId()], Strings.ShipyardUnit)));
        }
    }

    private void LoadTemplateList() {
        ShipTemplate currentShip = new ShipTemplate(commander.getShip(), Strings.ShipNameCurrentShip);
        selTemplate.Items.addElement(currentShip);
        selTemplate.Items.addElement(Constants.ShipTemplateSeparator);
        // Add the minimal sizes templates.
        for (ShipSize size : sizes) {
            Object obj = new ShipTemplate(size, Strings.Sizes[size.getId()] + Strings.ShipNameTemplateSuffixMinimum);
            selTemplate.Items.addElement(obj);
        }
        selTemplate.Items.addElement(Constants.ShipTemplateSeparator);
        // Add the buyable ship spec templates.
        for (ShipSpec spec : Constants.ShipSpecs) {
            if (sizes.contains(spec.getSize()) && spec.Type().getId() <= Constants.MaxShip) {
                Object obj = new ShipTemplate(spec, spec.Name() + Strings.ShipNameTemplateSuffixDefault);
                selTemplate.Items.addElement(obj);
            }
        }
        selTemplate.Items.addElement(Constants.ShipTemplateSeparator);
        // Add the user-created templates.
        ArrayList<ShipTemplate> userTemplates = new ArrayList<>();
        for (String fileName : Directory.getFiles(Constants.CustomTemplatesDirectory, "*.sst")) {
            ShipTemplate template = new ShipTemplate((Hashtable) Functions.LoadFile(fileName, true, this));
            if (sizes.contains(template.Size())) {
                userTemplates.add(template);
            }
        }
        Collections.sort(userTemplates);
        for (Object obj : userTemplates.toArray(new ShipTemplate[0])) {
            selTemplate.Items.addElement(obj);
        }
        selTemplate.setSelectedIndex(0);
    }

    private boolean SaveButtonEnabled() {
        return (!txtName.getText().isEmpty());
    }

    private void SetTemplateModified() {
        if (!loading && selTemplate.Items.getSize() > 0) {
            if (!selTemplate.Items.getElementAt(0).toString().equals(Strings.ShipNameModified)) {
                selTemplate.Items.insertElementAt(Strings.ShipNameModified, 0);
            }
            selTemplate.setSelectedIndex(0);
        }
    }

    private void UpdateAllocation() {
        boolean fuelMinimum = numFuelTanks.getValue() == numFuelTanks.getMinimum();
        boolean hullMinimum = numHullStrength.getValue() == numHullStrength.getMinimum();
        numFuelTanks.setMinimum(yard.BaseFuel());
        numFuelTanks.setIncrement(yard.PerUnitFuel());
        numFuelTanks.setMaximum(Constants.MaxFuelTanks);
        if (fuelMinimum) {
            numFuelTanks.setValue(numFuelTanks.getMinimum());
        }
        numHullStrength.setMinimum(yard.BaseHull());
        numHullStrength.setIncrement(yard.PerUnitHull());
        if (hullMinimum) {
            numHullStrength.setValue(numHullStrength.getMinimum());
        }
        numWeaponSlots.setMaximum(Constants.MaxSlots);
        numShieldSlots.setMaximum(Constants.MaxSlots);
        numGadgetSlots.setMaximum(Constants.MaxSlots);
        numCrewQuarters.setMaximum(Constants.MaxSlots);
    }

    private void UpdateCalculatedFigures() {
        // Fix the fuel value to be a multiple of the per unit value less the super.
        int extraFuel = numFuelTanks.getValue() - yard.BaseFuel();
        if (extraFuel % yard.PerUnitFuel() > 0 && numFuelTanks.getValue() < numFuelTanks.getMaximum()) {
            numFuelTanks.setValue(Math.max(numFuelTanks.getMinimum(),
                    Math.min(numFuelTanks.getMaximum(), (extraFuel + yard.PerUnitFuel()) / yard.PerUnitFuel() * yard.PerUnitFuel() + yard.BaseFuel())));
        }
        // Fix the hull value to be a multiple of the unit value less the super.
        int extraHull = numHullStrength.getValue() - yard.BaseHull();
        if (extraHull % yard.PerUnitHull() > 0) {
            numHullStrength.setValue(Math.max(numHullStrength.getMinimum(), (extraHull + yard.PerUnitHull()) / yard.PerUnitHull() * yard.PerUnitHull() + yard.BaseHull()));
        }
        yard.ShipSpec().CargoBays(numCargoBays.getValue());
        yard.ShipSpec().FuelTanks(numFuelTanks.getValue());
        yard.ShipSpec().HullStrength(numHullStrength.getValue());
        yard.ShipSpec().setWeaponSlots(numWeaponSlots.getValue());
        yard.ShipSpec().setShieldSlots(numShieldSlots.getValue());
        yard.ShipSpec().setGadgetSlots(numGadgetSlots.getValue());
        yard.ShipSpec().setCrewQuarters(numCrewQuarters.getValue());
        yard.CalculateDependantVariables();
        labelUnitsUsed.setText(yard.UnitsUsed() + "");
        labelPct.setText(Functions.FormatPercent(yard.PercentOfMaxUnits()));
        if (yard.PercentOfMaxUnits() >= Shipyard.PENALTY_FIRST_PCT) {
            labelPct.setFont(labelSkillLabel.getFont());
        } else {
            labelPct.setFont(labelPctLabel.getFont());
        }
        if (yard.UnitsUsed() > yard.MaxUnits()) {
            labelPct.setForeColor(Color.red);
        } else if (yard.PercentOfMaxUnits() >= Shipyard.PENALTY_SECOND_PCT) {
            labelPct.setForeColor(Color.orange);
        } else if (yard.PercentOfMaxUnits() >= Shipyard.PENALTY_FIRST_PCT) {
            labelPct.setForeColor(Color.yellow);
        } else {
            labelPct.setForeColor(labelPctLabel.getForeColor());
        }
        labelShipCost.setText(Functions.FormatMoney(yard.AdjustedPrice()));
        labelDesignFee.setText(Functions.FormatMoney(yard.AdjustedDesignFee()));
        labelPenalty.setText(Functions.FormatMoney(yard.AdjustedPenaltyCost()));
        labelTradeIn.setText(Functions.FormatMoney(-yard.TradeIn()));
        labelTotalCost.setText(Functions.FormatMoney(yard.TotalCost()));
        UpdateButtonEnabledState();
    }

    private void UpdateButtonEnabledState() {
        buttonConstruct.setForeColor(ConstructButtonEnabled() ? Color.black : Color.gray);
        buttonSave.setForeColor(SaveButtonEnabled() ? Color.black : Color.gray);
    }

    private void UpdateShip() {
        yard.ShipSpec().ImageIndex(imgTypes[imgIndex].getId());
        pictureShip.setImage((imgIndex > Constants.MaxShip ? customImages[0] : Constants.ShipSpecs[imgTypes[imgIndex].getId()].Image()));
        labelImage.setText((imgIndex > Constants.MaxShip ? Strings.ShipNameCustomShip : Constants.ShipSpecs[imgTypes[imgIndex].getId()].Name()));
    }

    private void buttonConstruct_Click(Object sender, EventData e) {
        if (ConstructButtonEnabled()) {
            if (commander.TradeShip(yard.ShipSpec(), yard.TotalCost(), txtName.getText(), this)) {
                Strings.ShipNames[ShipType.Custom.getId()] = txtName.getText();
                if (game.getQuestStatusScarab() == SpecialEvent.StatusScarabDone) {
                    game.setQuestStatusScarab(SpecialEvent.StatusScarabNotStarted);
                }
                // Replace the current custom images with the new ones.
                if (commander.getShip().ImageIndex() == ShipType.Custom.getId()) {
                    game.getParentWindow().setCustomShipImages(customImages);
                    commander.getShip().UpdateCustomImageOffsetConstants();
                }
                FormAlert.Alert(AlertType.ShipDesignThanks, this, yard.Name());
                Close();
            }
        }
    }

    private void buttonConstruct_MouseEnter(Object sender, EventData e) {
        labelDisabledName.setVisible(txtName.getText().isEmpty());
        labelDisabledPct.setVisible(yard.PercentOfMaxUnits() > 100);
    }

    private void buttonConstruct_MouseLeave(Object sender, EventData e) {
        labelDisabledName.setVisible(false);
        labelDisabledPct.setVisible(false);
    }

    private void buttonLoad_Click(Object sender, EventData e) {
        LoadSelectedTemplate();
    }

    private void buttonNextImage_Click(Object sender, EventData e) {
        SetTemplateModified();
        imgIndex = (imgIndex + 1) % imgTypes.length;
        UpdateShip();
    }

    private void buttonPrevImage_Click(Object sender, EventData e) {
        SetTemplateModified();
        imgIndex = (imgIndex + imgTypes.length - 1) % imgTypes.length;
        UpdateShip();
    }

    private void buttonSave_Click(Object sender, EventData e) {
        if (SaveButtonEnabled()) {
            if (dlgSave.ShowDialog(this) == DialogResult.OK) {
                ShipTemplate template = new ShipTemplate(yard.ShipSpec(), txtName.getText());
                if (imgIndex > Constants.MaxShip) {
                    template.ImageIndex(ShipType.Custom.getId());
                    template.Images(customImages);
                } else {
                    template.ImageIndex(imgIndex);
                }
                Functions.SaveFile(dlgSave.getFileName(), template.Serialize(), this);
                LoadTemplateList();
            }
        }
    }

    private void buttonSave_MouseEnter(Object sender, EventData e) {
        labelDisabledName.setVisible(txtName.getText().isEmpty());
    }

    private void buttonSave_MouseLeave(Object sender, EventData e) {
        labelDisabledName.setVisible(false);
    }

    private void buttonSetCustomImage_Click(Object sender, EventData e) {
        if (dlgOpen.ShowDialog(this) == DialogResult.OK) {
            String baseFileName = Path.removeExtension(dlgOpen.getFileName());
            String ext = Path.getExtension(dlgOpen.getFileName());
            wfBitmap image = GetImageFile(baseFileName + ext);
            wfBitmap imageDamaged = GetImageFile(baseFileName + "d" + ext);
            wfBitmap imageShields = GetImageFile(baseFileName + "s" + ext);
            wfBitmap imageShieldsDamaged = GetImageFile(baseFileName + "sd" + ext);
            if (image != null && imageDamaged != null && imageShields != null && imageShieldsDamaged != null) {
                customImages[Constants.ShipImgOffsetNormal] = image;
                customImages[Constants.ShipImgOffsetDamage] = imageDamaged;
                customImages[Constants.ShipImgOffsetShield] = imageShields;
                customImages[Constants.ShipImgOffsetShieldDamage] = imageShieldsDamaged;
            }
            imgIndex = imgTypes.length - 1;
            UpdateShip();
        }
    }

    private void num_ValueChanged(Object sender, EventData e) {
        SetTemplateModified();
        UpdateCalculatedFigures();
    }

    private void num_ValueEnter(Object sender, EventData e) {
        ((NumericUpDown) sender).Select(0, ("" + ((NumericUpDown) sender).getValue()).length());
    }

    private void selSize_SelectedIndexChanged(Object sender, EventData e) {
        SetTemplateModified();
        yard.ShipSpec().setSize(sizes.get(selSize.getSelectedIndex()));
        UpdateAllocation();
        UpdateCalculatedFigures();
    }

    private void txtName_TextChanged(Object sender, EventData e) {
        SetTemplateModified();
        UpdateButtonEnabledState();
    }
}
