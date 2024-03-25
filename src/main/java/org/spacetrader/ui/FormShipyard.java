package org.spacetrader.ui;

import org.spacetrader.controller.Constants;
import org.spacetrader.controller.Functions;
import org.spacetrader.controller.Game;
import org.spacetrader.model.crew.Commander;
import org.spacetrader.model.enums.AlertType;
import org.spacetrader.model.events.SpecialEvent;
import org.spacetrader.model.ship.*;
import org.spacetrader.util.Directory;
import org.spacetrader.util.Path;
import org.winforms.Button;
import org.winforms.FileDialog;
import org.winforms.Font;
import org.winforms.Image;
import org.winforms.Label;
import org.winforms.TextField;
import org.winforms.*;
import org.winforms.enums.*;

import java.awt.*;
import java.util.List;
import java.util.*;


public class FormShipyard extends form {
    private final Game game = Game.getCurrentGame();
    private final Commander commander = game.Commander();
    private final Shipyard yard = commander.CurrentSystem().Shipyard();
    private final ShipType[] imgTypes = {
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
    private final Spinner numHullStrength;
    private final Spinner numCargoBays;
    private final Spinner numCrewQuarters;
    private final Spinner numFuelTanks;
    private final Spinner numShieldSlots;
    private final Spinner numGadgetSlots;
    private final Spinner numWeaponSlots;
    private final FileDialog dialogOpen = FileDialog.createOpenFileDialog();
    private final PictureBox pictureShip;
    private final FileDialog dialogSave = FileDialog.createSaveFileDialog();
    private final TextField textName;
    private ArrayList<ShipSize> sizes;
    private Image[] customImages = new Image[Constants.ImagesPerShip];
    private boolean loading;
    private int imgIndex;

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
        textName = new TextField();
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
        numHullStrength = new Spinner();
        Label labelHullStrengthLabel = new Label();
        numCargoBays = new Spinner();
        numCrewQuarters = new Spinner();
        numFuelTanks = new Spinner();
        numShieldSlots = new Spinner();
        numGadgetSlots = new Spinner();
        numWeaponSlots = new Spinner();
        Label labelCargoBays = new Label();
        Label labelFuelTanks = new Label();
        Label labelCrewQuarters = new Label();
        Label labelShieldSlots = new Label();
        Label labelGadgetSlots = new Label();
        Label labelWeaponsSlots = new Label();
        ImageList ilShipyardLogos = new ImageList();
        labelDisabledPct = new Label();
        labelDisabledName = new Label();
        boxWelcome.suspendLayout();
        boxInfo.suspendLayout();
        boxCosts.suspendLayout();
        boxAllocation.suspendLayout();
        suspendLayout();
        // boxWelcome
        boxWelcome.controls.addAll(labelSkillDescription, labelSkill, labelSizeSpecialty, labelSkillLabel, labelSizeSpecialtyLabel, labelWarning, pictureLogo, labelWelcome);
        boxWelcome.setLocation(new Point(8, 0));
        boxWelcome.setName("boxWelcome");
        boxWelcome.setSize(new Dimension(270, 204));
        boxWelcome.setTabIndex(1);
        boxWelcome.setTabStop(false);
        // labelSkillDescription
        labelSkillDescription.setLocation(new Point(8, 98));
        labelSkillDescription.setName("labelSkillDescription");
        labelSkillDescription.setSize(new Dimension(258, 26));
        labelSkillDescription.setTabIndex(27);
        labelSkillDescription.setText("All ships constructed at this shipyard use 2 fewer units per crew quarter.");
        // labelSkill
        labelSkill.setLocation(new Point(180, 79));
        labelSkill.setName("labelSkill");
        labelSkill.setSize(new Dimension(87, 13));
        labelSkill.setTabIndex(26);
        labelSkill.setText("Crew Quartering");
        // labelSizeSpecialty
        labelSizeSpecialty.setLocation(new Point(180, 65));
        labelSizeSpecialty.setName("labelSizeSpecialty");
        labelSizeSpecialty.setSize(new Dimension(64, 13));
        labelSizeSpecialty.setTabIndex(25);
        labelSizeSpecialty.setText("Gargantuan");
        // labelSkillLabel
        labelSkillLabel.setAutoSize(true);
        labelSkillLabel.setFont(new Font("Microsoft Sans Serif", FontStyle.Bold, (int) 8.25F));
        labelSkillLabel.setLocation(new Point(92, 79));
        labelSkillLabel.setName("labelSkillLabel");
        labelSkillLabel.setSize(new Dimension(72, 13));
        labelSkillLabel.setTabIndex(24);
        labelSkillLabel.setText("Special Skill:");
        // labelSizeSpecialtyLabel
        labelSizeSpecialtyLabel.setAutoSize(true);
        labelSizeSpecialtyLabel.setFont(new Font("Microsoft Sans Serif", FontStyle.Bold, (int) 8.25F));
        labelSizeSpecialtyLabel.setLocation(new Point(92, 65));
        labelSizeSpecialtyLabel.setName("labelSizeSpecialtyLabel");
        labelSizeSpecialtyLabel.setSize(new Dimension(82, 13));
        labelSizeSpecialtyLabel.setTabIndex(23);
        labelSizeSpecialtyLabel.setText("Size Specialty:");
        // labelWelcome
        labelWelcome.setLocation(new Point(92, 12));
        labelWelcome.setName("labelWelcome");
        labelWelcome.setSize(new Dimension(176, 52));
        labelWelcome.setTabIndex(3);
        labelWelcome.setText("Welcome to Sorosuub Engineering Shipyards! Our best engineer, Obi-Wan, is at your service.");
        // labelWarning
        labelWarning.setLocation(new Point(8, 134));
        labelWarning.setName("labelWarning");
        labelWarning.setSize(new Dimension(258, 65));
        labelWarning.setTabIndex(5);
        labelWarning.setText("Bear in mind that getting too close to the maximum number of units will result in a \"Crowding Penalty\" due to the engineering difficulty of squeezing everything in. There is a modest penalty at 80%, and a more severe one at 90%.");
        // pictureLogo
        pictureLogo.setBackgroundColor(Color.black);
        pictureLogo.setLocation(new Point(8, 12));
        pictureLogo.setName("pictureLogo");
        pictureLogo.setSize(new Dimension(80, 80));
        pictureLogo.SizeMode = PictureBoxSizeMode.StretchImage;
        pictureLogo.setTabIndex(22);
        pictureLogo.setTabStop(false);
        // boxInfo
        boxInfo.controls.addAll(buttonSave, buttonLoad, pictureInfoLine, buttonPrevImage, buttonNextImage, labelImage, labelImageLabel, selTemplate,
                labelTemplate, selSize, labelSize, buttonSetCustomImage, pictureShip, textName, labelName);
        boxInfo.setLocation(new Point(8, 208));
        boxInfo.setName("boxInfo");
        boxInfo.setSize(new Dimension(270, 160));
        boxInfo.setTabIndex(2);
        boxInfo.setTabStop(false);
        boxInfo.setText("Info");
        // buttonSave
        buttonSave.setFlatStyle(FlatStyle.Flat);
        buttonSave.setLocation(new Point(216, 40));
        buttonSave.setName("buttonSave");
        buttonSave.setSize(new Dimension(44, 20));
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
        buttonLoad.setSize(new Dimension(44, 20));
        buttonLoad.setTabIndex(2);
        buttonLoad.setText("Load");
        buttonLoad.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonLoad_Click(sender, data);
            }
        });
        // pictureInfoLine
        pictureInfoLine.setBackgroundColor(Color.darkGray);
        pictureInfoLine.setLocation(new Point(8, 89));
        pictureInfoLine.setName("pictureInfoLine");
        pictureInfoLine.setSize(new Dimension(254, 1));
        pictureInfoLine.setTabIndex(132);
        pictureInfoLine.setTabStop(false);
        // buttonPrevImage
        buttonPrevImage.setFlatStyle(FlatStyle.Flat);
        buttonPrevImage.setLocation(new Point(154, 95));
        buttonPrevImage.setName("buttonPrevImage");
        buttonPrevImage.setSize(new Dimension(18, 18));
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
        buttonNextImage.setSize(new Dimension(18, 18));
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
        labelImage.setSize(new Dimension(70, 13));
        labelImage.setTabIndex(61);
        labelImage.setText("Custom Ship");
        labelImage.textAlignment = ContentAlignment.TopCenter;
        // labelImageLabel
        labelImageLabel.setAutoSize(true);
        labelImageLabel.setLocation(new Point(8, 95));
        labelImageLabel.setName("labelImageLabel");
        labelImageLabel.setSize(new Dimension(39, 13));
        labelImageLabel.setTabIndex(22);
        labelImageLabel.setText("Image:");
        // selTemplate
        selTemplate.DropDownStyle = ComboBoxStyle.DropDownList;
        selTemplate.setLocation(new Point(80, 16));
        selTemplate.setName("selTemplate");
        selTemplate.setSize(new Dimension(132, 21));
        selTemplate.setTabIndex(1);
        // labelTemplate
        labelTemplate.setAutoSize(true);
        labelTemplate.setLocation(new Point(8, 19));
        labelTemplate.setName("labelTemplate");
        labelTemplate.setSize(new Dimension(55, 13));
        labelTemplate.setTabIndex(20);
        labelTemplate.setText("Template:");
        // selSize
        selSize.DropDownStyle = ComboBoxStyle.DropDownList;
        selSize.setLocation(new Point(80, 63));
        selSize.setName("selSize");
        selSize.setSize(new Dimension(180, 21));
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
        labelSize.setSize(new Dimension(29, 13));
        labelSize.setTabIndex(18);
        labelSize.setText("Size:");
        // buttonSetCustomImage
        buttonSetCustomImage.setFlatStyle(FlatStyle.Flat);
        buttonSetCustomImage.setLocation(new Point(154, 121));
        buttonSetCustomImage.setName("buttonSetCustomImage");
        buttonSetCustomImage.setSize(new Dimension(106, 22));
        buttonSetCustomImage.setTabIndex(8);
        buttonSetCustomImage.setText("Set Custom...");
        buttonSetCustomImage.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonSetCustomImage_Click(sender, data);
            }
        });
        // pictureShip
        pictureShip.setBackgroundColor(Color.white);
        pictureShip.setBorderStyle(BorderStyle.FixedSingle);
        pictureShip.setLocation(new Point(80, 95));
        pictureShip.setName("pictureShip");
        pictureShip.setSize(new Dimension(66, 54));
        pictureShip.setTabIndex(14);
        pictureShip.setTabStop(false);
        // textName
        textName.setLocation(new Point(80, 40));
        textName.setName("textName");
        textName.setSize(new Dimension(132, 20));
        textName.setTabIndex(3);
        textName.setText("");
        textName.setTextChanged(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                textName_TextChanged(sender, data);
            }
        });
        // labelName
        labelName.setAutoSize(true);
        labelName.setLocation(new Point(8, 44));
        labelName.setName("labelName");
        labelName.setSize(new Dimension(63, 13));
        labelName.setTabIndex(5);
        labelName.setText("Ship Name:");
        // labelUnitsUsed
        labelUnitsUsed.setLocation(new Point(110, 186));
        labelUnitsUsed.setName("labelUnitsUsed");
        labelUnitsUsed.setSize(new Dimension(23, 13));
        labelUnitsUsed.setTabIndex(17);
        labelUnitsUsed.setText("888");
        labelUnitsUsed.textAlignment = ContentAlignment.TopRight;
        // labelUnitsUsedLabel
        labelUnitsUsedLabel.setAutoSize(true);
        labelUnitsUsedLabel.setLocation(new Point(8, 186));
        labelUnitsUsedLabel.setName("labelUnitsUsedLabel");
        labelUnitsUsedLabel.setSize(new Dimension(63, 13));
        labelUnitsUsedLabel.setTabIndex(16);
        labelUnitsUsedLabel.setText("Units Used:");
        // boxCosts
        boxCosts.controls.addAll(labelTradeIn, labelTradeInLabel, pictureCostsLine, labelPenalty, labelPenaltyLabel,
                labelShipCost, labelTotalCost, labelTotalCostLabel, labelShipCostLabel, labelDesignFee, labelDesignFeeLabel);
        boxCosts.setLocation(new Point(286, 230));
        boxCosts.setName("boxCosts");
        boxCosts.setSize(new Dimension(184, 106));
        boxCosts.setTabIndex(4);
        boxCosts.setTabStop(false);
        boxCosts.setText("Costs");
        // labelTradeIn
        labelTradeIn.setLocation(new Point(106, 64));
        labelTradeIn.setName("labelTradeIn");
        labelTradeIn.setSize(new Dimension(75, 16));
        labelTradeIn.setTabIndex(135);
        labelTradeIn.setText("-8,888,888 cr.");
        labelTradeIn.textAlignment = ContentAlignment.TopRight;
        // labelTradeInLabel
        labelTradeInLabel.setAutoSize(true);
        labelTradeInLabel.setLocation(new Point(8, 64));
        labelTradeInLabel.setName("labelTradeInLabel");
        labelTradeInLabel.setSize(new Dimension(77, 13));
        labelTradeInLabel.setTabIndex(134);
        labelTradeInLabel.setText("Less Trade-In:");
        // pictureCostsLine
        pictureCostsLine.setBackgroundColor(Color.darkGray);
        pictureCostsLine.setLocation(new Point(8, 80));
        pictureCostsLine.setName("pictureCostsLine");
        pictureCostsLine.setSize(new Dimension(168, 1));
        pictureCostsLine.setTabIndex(133);
        pictureCostsLine.setTabStop(false);
        // labelPenalty
        labelPenalty.setLocation(new Point(106, 32));
        labelPenalty.setName("labelPenalty");
        labelPenalty.setSize(new Dimension(74, 16));
        labelPenalty.setTabIndex(21);
        labelPenalty.setText("8,888,888 cr.");
        labelPenalty.textAlignment = ContentAlignment.TopRight;
        // labelPenaltyLabel
        labelPenaltyLabel.setAutoSize(true);
        labelPenaltyLabel.setLocation(new Point(8, 32));
        labelPenaltyLabel.setName("labelPenaltyLabel");
        labelPenaltyLabel.setSize(new Dimension(96, 13));
        labelPenaltyLabel.setTabIndex(20);
        labelPenaltyLabel.setText("Crowding Penalty:");
        // labelShipCost
        labelShipCost.setLocation(new Point(106, 16));
        labelShipCost.setName("labelShipCost");
        labelShipCost.setSize(new Dimension(74, 16));
        labelShipCost.setTabIndex(19);
        labelShipCost.setText("8,888,888 cr.");
        labelShipCost.textAlignment = ContentAlignment.TopRight;
        // labelTotalCost
        labelTotalCost.setLocation(new Point(106, 84));
        labelTotalCost.setName("labelTotalCost");
        labelTotalCost.setSize(new Dimension(74, 16));
        labelTotalCost.setTabIndex(18);
        labelTotalCost.setText("8,888,888 cr.");
        labelTotalCost.textAlignment = ContentAlignment.TopRight;
        // labelTotalCostLabel
        labelTotalCostLabel.setAutoSize(true);
        labelTotalCostLabel.setLocation(new Point(8, 84));
        labelTotalCostLabel.setName("labelTotalCostLabel");
        labelTotalCostLabel.setSize(new Dimension(59, 13));
        labelTotalCostLabel.setTabIndex(17);
        labelTotalCostLabel.setText("Total Cost:");
        // labelShipCostLabel
        labelShipCostLabel.setAutoSize(true);
        labelShipCostLabel.setLocation(new Point(8, 16));
        labelShipCostLabel.setName("labelShipCostLabel");
        labelShipCostLabel.setSize(new Dimension(56, 13));
        labelShipCostLabel.setTabIndex(16);
        labelShipCostLabel.setText("Ship Cost:");
        // labelDesignFee
        labelDesignFee.setLocation(new Point(106, 48));
        labelDesignFee.setName("labelDesignFee");
        labelDesignFee.setSize(new Dimension(74, 16));
        labelDesignFee.setTabIndex(15);
        labelDesignFee.setText("888,888 cr.");
        labelDesignFee.textAlignment = ContentAlignment.TopRight;
        // labelDesignFeeLabel
        labelDesignFeeLabel.setAutoSize(true);
        labelDesignFeeLabel.setLocation(new Point(8, 48));
        labelDesignFeeLabel.setName("labelDesignFeeLabel");
        labelDesignFeeLabel.setSize(new Dimension(65, 13));
        labelDesignFeeLabel.setTabIndex(14);
        labelDesignFeeLabel.setText("Design Fee:");
        // buttonConstruct
        buttonConstruct.setFlatStyle(FlatStyle.Flat);
        buttonConstruct.setForegroundColor(SystemColors.ControlText);
        buttonConstruct.setLocation(new Point(382, 344));
        buttonConstruct.setName("buttonConstruct");
        buttonConstruct.setSize(new Dimension(88, 22));
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
        buttonCancel.setSize(new Dimension(88, 22));
        buttonCancel.setTabIndex(5);
        buttonCancel.setText("Cancel Design");
        // boxAllocation
        boxAllocation.controls.addAll(labelPct, labelPctLabel, numHullStrength, labelHullStrengthLabel, numCargoBays, numCrewQuarters, numFuelTanks,
                numShieldSlots, numGadgetSlots, numWeaponSlots, labelCargoBays, labelFuelTanks, labelCrewQuarters,
                labelShieldSlots, labelGadgetSlots, labelWeaponsSlots, labelUnitsUsedLabel, labelUnitsUsed);
        boxAllocation.setLocation(new Point(286, 0));
        boxAllocation.setName("boxAllocation");
        boxAllocation.setSize(new Dimension(184, 226));
        boxAllocation.setTabIndex(3);
        boxAllocation.setTabStop(false);
        boxAllocation.setText("Space Allocation");
        // labelPct
        labelPct.setFont(new Font("Microsoft Sans Serif", FontStyle.Bold, (int) 8.25F));
        labelPct.setForegroundColor(Color.red);
        labelPct.setLocation(new Point(110, 204));
        labelPct.setName("labelPct");
        labelPct.setSize(new Dimension(34, 13));
        labelPct.setTabIndex(19);
        labelPct.setText("888%");
        labelPct.textAlignment = ContentAlignment.TopRight;
        // labelPctLabel
        labelPctLabel.setAutoSize(true);
        labelPctLabel.setLocation(new Point(8, 204));
        labelPctLabel.setName("labelPctLabel");
        labelPctLabel.setSize(new Dimension(54, 13));
        labelPctLabel.setTabIndex(18);
        labelPctLabel.setText("% of Max:");
        // numHullStrength
        numHullStrength.setBackgroundColor(Color.white);
        numHullStrength.setLocation(new Point(110, 64));
        numHullStrength.setMaximum(9999);
        numHullStrength.setName("numHullStrength");
        numHullStrength.setReadOnly(true);
        numHullStrength.setSize(new Dimension(64, 20));
        numHullStrength.setTabIndex(1);
        numHullStrength.textAlignment = HorizontalAlignment.Right;
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
        labelHullStrengthLabel.setSize(new Dimension(70, 13));
        labelHullStrengthLabel.setTabIndex(13);
        labelHullStrengthLabel.setText("Hull Strength:");
        // numCargoBays
        numCargoBays.setBackgroundColor(Color.white);
        numCargoBays.setLocation(new Point(110, 16));
        numCargoBays.setMaximum(999);
        numCargoBays.setName("numCargoBays");
        numCargoBays.setReadOnly(true);
        numCargoBays.setSize(new Dimension(64, 20));
        numCargoBays.setTabIndex(3);
        numCargoBays.textAlignment = HorizontalAlignment.Right;
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
        numCrewQuarters.setBackgroundColor(Color.white);
        numCrewQuarters.setLocation(new Point(110, 160));
        numCrewQuarters.setMinimum(1);
        numCrewQuarters.setName("numCrewQuarters");
        numCrewQuarters.setReadOnly(true);
        numCrewQuarters.setSize(new Dimension(64, 20));
        numCrewQuarters.setTabIndex(4);
        numCrewQuarters.textAlignment = HorizontalAlignment.Right;
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
        numFuelTanks.setBackgroundColor(Color.white);
        numFuelTanks.setLocation(new Point(110, 40));
        numFuelTanks.setName("numFuelTanks");
        numFuelTanks.setReadOnly(true);
        numFuelTanks.setSize(new Dimension(64, 20));
        numFuelTanks.setTabIndex(2);
        numFuelTanks.textAlignment = HorizontalAlignment.Right;
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
        numShieldSlots.setBackgroundColor(Color.white);
        numShieldSlots.setLocation(new Point(110, 112));
        numShieldSlots.setName("numShieldSlots");
        numShieldSlots.setReadOnly(true);
        numShieldSlots.setSize(new Dimension(64, 20));
        numShieldSlots.setTabIndex(6);
        numShieldSlots.textAlignment = HorizontalAlignment.Right;
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
        numGadgetSlots.setBackgroundColor(Color.white);
        numGadgetSlots.setLocation(new Point(110, 136));
        numGadgetSlots.setName("numGadgetSlots");
        numGadgetSlots.setReadOnly(true);
        numGadgetSlots.setSize(new Dimension(64, 20));
        numGadgetSlots.setTabIndex(7);
        numGadgetSlots.textAlignment = HorizontalAlignment.Right;
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
        numWeaponSlots.setBackgroundColor(Color.white);
        numWeaponSlots.setLocation(new Point(110, 88));
        numWeaponSlots.setName("numWeaponSlots");
        numWeaponSlots.setReadOnly(true);
        numWeaponSlots.setSize(new Dimension(64, 20));
        numWeaponSlots.setTabIndex(5);
        numWeaponSlots.textAlignment = HorizontalAlignment.Right;
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
        labelCargoBays.setSize(new Dimension(66, 13));
        labelCargoBays.setTabIndex(5);
        labelCargoBays.setText("Cargo Bays:");
        // labelFuelTanks
        labelFuelTanks.setAutoSize(true);
        labelFuelTanks.setLocation(new Point(8, 42));
        labelFuelTanks.setName("labelFuelTanks");
        labelFuelTanks.setSize(new Dimension(41, 13));
        labelFuelTanks.setTabIndex(4);
        labelFuelTanks.setText("Range:");
        // labelCrewQuarters
        labelCrewQuarters.setAutoSize(true);
        labelCrewQuarters.setLocation(new Point(8, 162));
        labelCrewQuarters.setName("labelCrewQuarters");
        labelCrewQuarters.setSize(new Dimension(81, 13));
        labelCrewQuarters.setTabIndex(3);
        labelCrewQuarters.setText("Crew Quarters:");
        // labelShieldSlots
        labelShieldSlots.setAutoSize(true);
        labelShieldSlots.setLocation(new Point(8, 114));
        labelShieldSlots.setName("labelShieldSlots");
        labelShieldSlots.setSize(new Dimension(67, 13));
        labelShieldSlots.setTabIndex(2);
        labelShieldSlots.setText("Shield Slots:");
        // labelGadgetSlots
        labelGadgetSlots.setAutoSize(true);
        labelGadgetSlots.setLocation(new Point(8, 138));
        labelGadgetSlots.setName("labelGadgetSlots");
        labelGadgetSlots.setSize(new Dimension(73, 13));
        labelGadgetSlots.setTabIndex(1);
        labelGadgetSlots.setText("Gadget Slots:");
        // labelWeaponsSlots
        labelWeaponsSlots.setAutoSize(true);
        labelWeaponsSlots.setLocation(new Point(8, 90));
        labelWeaponsSlots.setName("labelWeaponsSlots");
        labelWeaponsSlots.setSize(new Dimension(78, 13));
        labelWeaponsSlots.setTabIndex(0);
        labelWeaponsSlots.setText("Weapon Slots:");
        // ilShipyardLogos
        ilShipyardLogos.colorDepth = ColorDepth.Depth24Bit;
        ilShipyardLogos.setImageSize(new Dimension(80, 80));
        ilShipyardLogos.setImageStream(((ImageListStreamer) (resources.getObject("ilShipyardLogos.ImageStream"))));
        ilShipyardLogos.setTransparentColor(Color.black);
        // dialogOpen
        dialogOpen.setFilter("Windows Bitmaps (*.bmp)|*bmp");
        dialogOpen.setTitle("Open Ship Image");
        // labelDisabledPct
        labelDisabledPct.setBackgroundColor(SystemColors.Info);
        labelDisabledPct.setBorderStyle(BorderStyle.FixedSingle);
        labelDisabledPct.imageAlignment = ContentAlignment.MiddleRight;
        labelDisabledPct.setLocation(new Point(154, 182));
        labelDisabledPct.setName("labelDisabledPct");
        labelDisabledPct.setSize(new Dimension(276, 20));
        labelDisabledPct.setTabIndex(8);
        labelDisabledPct.setText("Your % of Max must be less than or equal to 100%.");
        labelDisabledPct.textAlignment = ContentAlignment.MiddleCenter;
        labelDisabledPct.setVisible(false);
        // dialogSave
        dialogSave.setDefaultExt("sst");
        dialogSave.setFileName("CustomShip.sst");
        dialogSave.setFilter("SpaceTrader Ship Template Files (*.sst)|*.sst");
        dialogSave.setTitle("Save Ship Template");
        // labelDisabledName
        labelDisabledName.setBackgroundColor(SystemColors.Info);
        labelDisabledName.setBorderStyle(BorderStyle.FixedSingle);
        labelDisabledName.imageAlignment = ContentAlignment.MiddleLeft;
        labelDisabledName.setLocation(new Point(96, 222));
        labelDisabledName.setName("labelDisabledName");
        labelDisabledName.setSize(new Dimension(170, 20));
        labelDisabledName.setTabIndex(7);
        labelDisabledName.setText("You must enter a Ship Name.");
        labelDisabledName.textAlignment = ContentAlignment.MiddleRight;
        labelDisabledName.setVisible(false);
        // Form_Shipyard
        setAcceptButton(buttonConstruct);
        setAutoScaleBaseSize(new Dimension(5, 13));
        setCancelButton(buttonCancel);
        setClientSize(new Dimension(478, 375));
        Controls.addAll(Arrays.asList(labelDisabledPct, boxWelcome, labelDisabledName, boxAllocation, boxCosts, boxInfo, buttonCancel, buttonConstruct));
        setFormBorderStyle(FormBorderStyle.FixedDialog);
        setMaximizeBox(false);
        setMinimizeBox(false);
        setName("Form_Shipyard");
        setShowInTaskbar(false);
        setStartPosition(FormStartPosition.CenterParent);
        setText("Ship Design at XXXX Shipyards");
        boxWelcome.resumeLayout(false);
        boxInfo.resumeLayout(false);
        boxCosts.resumeLayout(false);
        boxAllocation.resumeLayout(false);
        resumeLayout(false);
        setText(Functions.StringVars(Strings.ShipyardTitle, yard.Name()));
        pictureLogo.setImage(ilShipyardLogos.getImages()[yard.Id().getId()]);
        labelWelcome.setText(Functions.StringVars(Strings.ShipyardWelcome, yard.Name(), yard.Engineer()));
        labelSizeSpecialty.setText(Strings.Sizes[yard.SpecialtySize().getId()]);
        labelSkill.setText(Strings.ShipyardSkills[yard.Skill().getId()]);
        labelSkillDescription.setText(Strings.ShipyardSkillDescriptions[yard.Skill().getId()]);
        labelWarning.setText(Functions.StringVars(Strings.ShipyardWarning, "" + Shipyard.PENALTY_FIRST_PCT, "" + Shipyard.PENALTY_SECOND_PCT));
        dialogOpen.setInitialDirectory(Constants.CustomImagesDirectory);
        dialogSave.setInitialDirectory(Constants.CustomTemplatesDirectory);
        labelDisabledName.setImage(game.getParentWindow().DirectionImages().getImages()[Constants.DirectionDown]);
        labelDisabledPct.setImage(game.getParentWindow().DirectionImages().getImages()[Constants.DirectionDown]);
        LoadSizes();
        LoadTemplateList();
        LoadSelectedTemplate();
    }


    private boolean ConstructButtonEnabled() {
        return 100 >= yard.PercentOfMaxUnits() && !textName.getText().isEmpty();
    }

    private Bitmap GetImageFile(String fileName) {
        Bitmap image = null;
        try {
            image = new Bitmap(fileName);
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
                textName.setText(commander.getShip().Name());
            } else if (template.Name().endsWith(Strings.ShipNameTemplateSuffixDefault) || template.Name().endsWith(Strings.ShipNameTemplateSuffixMinimum)) {
                textName.setText("");
            } else {
                textName.setText(template.Name());
            }
            selSize.setSelectedIndex(Math.max(0, sizes.indexOf(template.Size())));
            imgIndex = template.ImageIndex() == ShipType.Custom.getId() ? imgTypes.length - 1 : template.ImageIndex();
            if (null != template.Images()) {
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
            if (sizes.contains(spec.getSize()) && Constants.MaxShip >= spec.Type().getId()) {
                Object obj = new ShipTemplate(spec, spec.Name() + Strings.ShipNameTemplateSuffixDefault);
                selTemplate.Items.addElement(obj);
            }
        }
        selTemplate.Items.addElement(Constants.ShipTemplateSeparator);
        // Add the user-created templates.
        List<ShipTemplate> userTemplates = new ArrayList<>();
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
        return (!textName.getText().isEmpty());
    }

    private void SetTemplateModified() {
        if (!loading && 0 < selTemplate.Items.getSize()) {
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
        if (0 < extraFuel % yard.PerUnitFuel() && numFuelTanks.getValue() < numFuelTanks.getMaximum()) {
            numFuelTanks.setValue(Math.max(numFuelTanks.getMinimum(),
                    Math.min(numFuelTanks.getMaximum(), (extraFuel + yard.PerUnitFuel()) / yard.PerUnitFuel() * yard.PerUnitFuel() + yard.BaseFuel())));
        }
        // Fix the hull value to be a multiple of the unit value less the super.
        int extraHull = numHullStrength.getValue() - yard.BaseHull();
        if (0 < extraHull % yard.PerUnitHull()) {
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
        if (Shipyard.PENALTY_FIRST_PCT <= yard.PercentOfMaxUnits()) {
            labelPct.setFont(labelSkillLabel.getFont());
        } else {
            labelPct.setFont(labelPctLabel.getFont());
        }
        if (yard.UnitsUsed() > yard.MaxUnits()) {
            labelPct.setForegroundColor(Color.red);
        } else if (Shipyard.PENALTY_SECOND_PCT <= yard.PercentOfMaxUnits()) {
            labelPct.setForegroundColor(Color.orange);
        } else if (Shipyard.PENALTY_FIRST_PCT <= yard.PercentOfMaxUnits()) {
            labelPct.setForegroundColor(Color.yellow);
        } else {
            labelPct.setForegroundColor(labelPctLabel.getForegroundColor());
        }
        labelShipCost.setText(Functions.FormatMoney(yard.AdjustedPrice()));
        labelDesignFee.setText(Functions.FormatMoney(yard.AdjustedDesignFee()));
        labelPenalty.setText(Functions.FormatMoney(yard.AdjustedPenaltyCost()));
        labelTradeIn.setText(Functions.FormatMoney(-yard.TradeIn()));
        labelTotalCost.setText(Functions.FormatMoney(yard.TotalCost()));
        UpdateButtonEnabledState();
    }

    private void UpdateButtonEnabledState() {
        buttonConstruct.setForegroundColor(ConstructButtonEnabled() ? Color.black : Color.gray);
        buttonSave.setForegroundColor(SaveButtonEnabled() ? Color.black : Color.gray);
    }

    private void UpdateShip() {
        yard.ShipSpec().ImageIndex(imgTypes[imgIndex].getId());
        pictureShip.setImage((Constants.MaxShip < imgIndex ? customImages[0] : Constants.ShipSpecs[imgTypes[imgIndex].getId()].Image()));
        labelImage.setText((Constants.MaxShip < imgIndex ? Strings.ShipNameCustomShip : Constants.ShipSpecs[imgTypes[imgIndex].getId()].Name()));
    }

    private void buttonConstruct_Click(Object sender, EventData e) {
        if (ConstructButtonEnabled()) {
            if (commander.TradeShip(yard.ShipSpec(), yard.TotalCost(), textName.getText(), this)) {
                Strings.ShipNames[ShipType.Custom.getId()] = textName.getText();
                if (SpecialEvent.StatusScarabDone == game.getQuestStatusScarab()) {
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
        labelDisabledName.setVisible(textName.getText().isEmpty());
        labelDisabledPct.setVisible(100 < yard.PercentOfMaxUnits());
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
            if (DialogResult.OK == dialogSave.ShowDialog(this)) {
                ShipTemplate template = new ShipTemplate(yard.ShipSpec(), textName.getText());
                if (Constants.MaxShip < imgIndex) {
                    template.ImageIndex(ShipType.Custom.getId());
                    template.Images(customImages);
                } else {
                    template.ImageIndex(imgIndex);
                }
                Functions.SaveFile(dialogSave.getFileName(), template.Serialize(), this);
                LoadTemplateList();
            }
        }
    }

    private void buttonSave_MouseEnter(Object sender, EventData e) {
        labelDisabledName.setVisible(textName.getText().isEmpty());
    }

    private void buttonSave_MouseLeave(Object sender, EventData e) {
        labelDisabledName.setVisible(false);
    }

    private void buttonSetCustomImage_Click(Object sender, EventData e) {
        if (DialogResult.OK == dialogOpen.ShowDialog(this)) {
            String baseFileName = Path.removeExtension(dialogOpen.getFileName());
            String ext = Path.getExtension(dialogOpen.getFileName());
            Bitmap image = GetImageFile(baseFileName + ext);
            Bitmap imageDamaged = GetImageFile(baseFileName + "d" + ext);
            Bitmap imageShields = GetImageFile(baseFileName + "s" + ext);
            Bitmap imageShieldsDamaged = GetImageFile(baseFileName + "sd" + ext);
            if (null != image && null != imageDamaged && null != imageShields && null != imageShieldsDamaged) {
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
        ((Spinner) sender).select(0, ("" + ((Spinner) sender).getValue()).length());
    }

    private void selSize_SelectedIndexChanged(Object sender, EventData e) {
        SetTemplateModified();
        yard.ShipSpec().setSize(sizes.get(selSize.getSelectedIndex()));
        UpdateAllocation();
        UpdateCalculatedFigures();
    }

    private void textName_TextChanged(Object sender, EventData e) {
        SetTemplateModified();
        UpdateButtonEnabledState();
    }
}
