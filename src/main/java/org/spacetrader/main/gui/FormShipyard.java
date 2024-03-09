package org.spacetrader.main.gui;
import java.awt.Color;
import java.awt.Point;
import java.util.Arrays;
import jwinforms.Button;
import jwinforms.ComboBox;
import jwinforms.Container;
import jwinforms.EventArgs;
import jwinforms.EventHandler;
import jwinforms.Font;
import jwinforms.FormSize;
import jwinforms.GraphicsUnit;
import jwinforms.GroupBox;
import jwinforms.IContainer;
import jwinforms.ISupportInitialize;
import jwinforms.ImageList;
import jwinforms.ImageListStreamer;
import jwinforms.Label;
import jwinforms.NumericUpDown;
import jwinforms.OpenFileDialog;
import jwinforms.PictureBox;
import jwinforms.PictureBoxSizeMode;
import jwinforms.ResourceManager;
import jwinforms.SaveFileDialog;
import jwinforms.SystemColors;
import jwinforms.TextBox;
import jwinforms.WfBitmap;
import jwinforms.WfImage;
import jwinforms.WinformControl;
import jwinforms.WinformForm;
import jwinforms.enums.BorderStyle;
import jwinforms.enums.ColorDepth;
import jwinforms.enums.ComboBoxStyle;
import jwinforms.enums.ContentAlignment;
import jwinforms.enums.DialogResult;
import jwinforms.enums.FlatStyle;
import jwinforms.enums.FontStyle;
import jwinforms.enums.FormBorderStyle;
import jwinforms.enums.FormStartPosition;
import jwinforms.enums.HorizontalAlignment;
import org.spacetrader.main.enums.AlertType;
import org.spacetrader.main.stub.ArrayList;
import org.spacetrader.main.stub.Directory;
import org.spacetrader.main.util.Hashtable;
import org.spacetrader.ship.ShipSize;
import org.spacetrader.ship.ShipType;
import org.spacetrader.main.Commander;
import org.spacetrader.main.Consts;
import org.spacetrader.main.Functions;
import org.spacetrader.main.Game;
import org.spacetrader.main.ShipSpec;
import org.spacetrader.main.ShipTemplate;
import org.spacetrader.main.Shipyard;
import org.spacetrader.main.SpecialEvent;
import org.spacetrader.main.Strings;
import org.spacetrader.util.Path;


public class FormShipyard extends WinformForm {
  private final Game game = Game.CurrentGame();
  private final Commander cmdr = game.Commander();
  private final Shipyard yard = cmdr.CurrentSystem().Shipyard();
  private final ShipType[] imgTypes = new ShipType[]{
    ShipType.Flea, ShipType.Gnat, ShipType.Firefly, ShipType.Mosquito, ShipType.Bumblebee, ShipType.Beetle,
    ShipType.Hornet, ShipType.Grasshopper, ShipType.Termite, ShipType.Wasp, ShipType.Custom
  };
  private ArrayList<ShipSize> sizes = null;
  private Button btnConstruct;
  private Button btnCancel;
  private Button btnSetCustomImage;
  private Button btnNextImage;
  private Button btnPrevImage;
  private Button btnLoad;
  private Button btnSave;
  private ComboBox selSize;
  private ComboBox selTemplate;
  private GroupBox boxCosts;
  private GroupBox boxAllocation;
  private GroupBox boxWelcome;
  private GroupBox boxInfo;
  private IContainer components;
  private WfImage[] customImages = new WfImage[Consts.ImagesPerShip];
  private ImageList ilShipyardLogos;
  private Label lblWelcome;
  private Label lblName;
  private Label lblDesignFee;
  private Label lblHullStrenghLabel;
  private Label lblCargoBays;
  private Label lblFuelTanks;
  private Label lblCrewQuarters;
  private Label lblShieldSlots;
  private Label lblGadgetSlots;
  private Label lblWeaponsSlots;
  private Label lblShipCost;
  private Label lblTotalCost;
  private Label lblTotalCostLabel;
  private Label lblShipCostLabel;
  private Label lblDesignFeeLabel;
  private Label lblSize;
  private Label lblTemplate;
  private Label lblImageLabel;
  private Label lblImage;
  private Label lblUnitsUsedLabel;
  private Label lblPctLabel;
  private Label lblPct;
  private Label lblPenaltyLabel;
  private Label lblPenalty;
  private Label lblSizeSpecialtyLabel;
  private Label lblSkillLabel;
  private Label lblSizeSpecialty;
  private Label lblSkill;
  private Label lblSkillDescription;
  private Label lblWarning;
  private Label lblTradeInLabel;
  private Label lblTradeIn;
  private Label lblUnitsUsed;
  private Label lblDisabledPct;
  private Label lblDisabledName;
  private NumericUpDown numHullStrength;
  private NumericUpDown numCargoBays;
  private NumericUpDown numCrewQuarters;
  private NumericUpDown numFuelTanks;
  private NumericUpDown numShieldSlots;
  private NumericUpDown numGadgetSlots;
  private NumericUpDown numWeaponSlots;
  private OpenFileDialog dlgOpen;
  private PictureBox picShip;
  private PictureBox picLogo;
  private PictureBox picInfoLine;
  private PictureBox picCostsLine;
  private SaveFileDialog dlgSave;
  private TextBox txtName;
  private boolean loading = false;
  private int imgIndex = 0;

  public FormShipyard() {
    InitializeComponent();
    setText(Functions.StringVars(Strings.ShipyardTitle, yard.Name()));
    picLogo.setImage(ilShipyardLogos.getImages()[yard.Id().CastToInt()]);
    lblWelcome.setText(Functions.StringVars(Strings.ShipyardWelcome, yard.Name(), yard.Engineer()));
    lblSizeSpecialty.setText(Strings.Sizes[yard.SpecialtySize().CastToInt()]);
    lblSkill.setText(Strings.ShipyardSkills[yard.Skill().CastToInt()]);
    lblSkillDescription.setText(Strings.ShipyardSkillDescriptions[yard.Skill().CastToInt()]);
    lblWarning.setText(Functions.StringVars(Strings.ShipyardWarning, "" + Shipyard.PENALTY_FIRST_PCT, "" + Shipyard.PENALTY_SECOND_PCT));
    dlgOpen.setInitialDirectory(Consts.CustomImagesDirectory);
    dlgSave.setInitialDirectory(Consts.CustomTemplatesDirectory);
    lblDisabledName.setImage(game.getParentWindow().DirectionImages().getImages()[Consts.DirectionDown]);
    lblDisabledPct.setImage(game.getParentWindow().DirectionImages().getImages()[Consts.DirectionDown]);
    LoadSizes();
    LoadTemplateList();
    LoadSelectedTemplate();
  }

  // Required method for Designer support - do not modify the contents of this method with the code editor.
  @SuppressWarnings("deprecation")
  private void InitializeComponent() {
    components = new Container();
    ResourceManager resources = new ResourceManager(FormShipyard.class);
    boxWelcome = new GroupBox();
    lblSkillDescription = new Label();
    lblSkill = new Label();
    lblSizeSpecialty = new Label();
    lblSkillLabel = new Label();
    lblSizeSpecialtyLabel = new Label();
    lblWelcome = new Label();
    lblWarning = new Label();
    picLogo = new PictureBox();
    boxInfo = new GroupBox();
    btnSave = new Button();
    btnLoad = new Button();
    picInfoLine = new PictureBox();
    btnPrevImage = new Button();
    btnNextImage = new Button();
    lblImage = new Label();
    lblImageLabel = new Label();
    selTemplate = new ComboBox();
    lblTemplate = new Label();
    selSize = new ComboBox();
    lblSize = new Label();
    btnSetCustomImage = new Button();
    picShip = new PictureBox();
    txtName = new TextBox();
    lblName = new Label();
    lblUnitsUsed = new Label();
    lblUnitsUsedLabel = new Label();
    boxCosts = new GroupBox();
    lblTradeIn = new Label();
    lblTradeInLabel = new Label();
    picCostsLine = new PictureBox();
    lblPenalty = new Label();
    lblPenaltyLabel = new Label();
    lblShipCost = new Label();
    lblTotalCost = new Label();
    lblTotalCostLabel = new Label();
    lblShipCostLabel = new Label();
    lblDesignFee = new Label();
    lblDesignFeeLabel = new Label();
    btnConstruct = new Button();
    btnCancel = new Button();
    boxAllocation = new GroupBox();
    lblPct = new Label();
    lblPctLabel = new Label();
    numHullStrength = new NumericUpDown();
    lblHullStrenghLabel = new Label();
    numCargoBays = new NumericUpDown();
    numCrewQuarters = new NumericUpDown();
    numFuelTanks = new NumericUpDown();
    numShieldSlots = new NumericUpDown();
    numGadgetSlots = new NumericUpDown();
    numWeaponSlots = new NumericUpDown();
    lblCargoBays = new Label();
    lblFuelTanks = new Label();
    lblCrewQuarters = new Label();
    lblShieldSlots = new Label();
    lblGadgetSlots = new Label();
    lblWeaponsSlots = new Label();
    ilShipyardLogos = new ImageList(components);
    dlgOpen = new OpenFileDialog();
    lblDisabledPct = new Label();
    dlgSave = new SaveFileDialog();
    lblDisabledName = new Label();
    boxWelcome.SuspendLayout();
    boxInfo.SuspendLayout();
    boxCosts.SuspendLayout();
    boxAllocation.SuspendLayout();
    ((ISupportInitialize)(numHullStrength)).BeginInit();
    ((ISupportInitialize)(numCargoBays)).BeginInit();
    ((ISupportInitialize)(numCrewQuarters)).BeginInit();
    ((ISupportInitialize)(numFuelTanks)).BeginInit();
    ((ISupportInitialize)(numShieldSlots)).BeginInit();
    ((ISupportInitialize)(numGadgetSlots)).BeginInit();
    ((ISupportInitialize)(numWeaponSlots)).BeginInit();
    SuspendLayout();
    // boxWelcome
    boxWelcome.Controls.addAll((new WinformControl[]{
          lblSkillDescription, lblSkill, lblSizeSpecialty, lblSkillLabel, lblSizeSpecialtyLabel, lblWarning, picLogo, lblWelcome
        }));
    boxWelcome.setLocation(new Point(8, 0));
    boxWelcome.setName("boxWelcome");
    boxWelcome.setSize(new FormSize(270, 204));
    boxWelcome.setTabIndex(1);
    boxWelcome.setTabStop(false);
    // lblSkillDescription
    lblSkillDescription.setLocation(new Point(8, 98));
    lblSkillDescription.setName("lblSkillDescription");
    lblSkillDescription.setSize(new FormSize(258, 26));
    lblSkillDescription.setTabIndex(27);
    lblSkillDescription.setText("All ships constructed at this shipyard use 2 fewer units per crew quarter.");
    // lblSkill
    lblSkill.setLocation(new Point(180, 79));
    lblSkill.setName("lblSkill");
    lblSkill.setSize(new FormSize(87, 13));
    lblSkill.setTabIndex(26);
    lblSkill.setText("Crew Quartering");
    // lblSizeSpecialty
    lblSizeSpecialty.setLocation(new Point(180, 65));
    lblSizeSpecialty.setName("lblSizeSpecialty");
    lblSizeSpecialty.setSize(new FormSize(64, 13));
    lblSizeSpecialty.setTabIndex(25);
    lblSizeSpecialty.setText("Gargantuan");
    // lblSkillLabel
    lblSkillLabel.setAutoSize(true);
    lblSkillLabel.setFont(new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte)(0))));
    lblSkillLabel.setLocation(new Point(92, 79));
    lblSkillLabel.setName("lblSkillLabel");
    lblSkillLabel.setSize(new FormSize(72, 13));
    lblSkillLabel.setTabIndex(24);
    lblSkillLabel.setText("Special Skill:");
    // lblSizeSpecialtyLabel
    lblSizeSpecialtyLabel.setAutoSize(true);
    lblSizeSpecialtyLabel.setFont(new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte)(0))));
    lblSizeSpecialtyLabel.setLocation(new Point(92, 65));
    lblSizeSpecialtyLabel.setName("lblSizeSpecialtyLabel");
    lblSizeSpecialtyLabel.setSize(new FormSize(82, 13));
    lblSizeSpecialtyLabel.setTabIndex(23);
    lblSizeSpecialtyLabel.setText("Size Specialty:");
    // lblWelcome
    lblWelcome.setLocation(new Point(92, 12));
    lblWelcome.setName("lblWelcome");
    lblWelcome.setSize(new FormSize(176, 52));
    lblWelcome.setTabIndex(3);
    lblWelcome.setText("Welcome to Sorosuub Engineering Shipyards! Our best engineer, Obi-Wan, is at your service.");
    // lblWarning
    lblWarning.setLocation(new Point(8, 134));
    lblWarning.setName("lblWarning");
    lblWarning.setSize(new FormSize(258, 65));
    lblWarning.setTabIndex(5);
    lblWarning.setText("Bear in mind that getting too close to the maximum number of units will result in a \"Crowding Penalty\" due to the engineering difficulty of squeezing everything in. There is a modest penalty at 80%, and a more severe one at 90%.");
    // picLogo
    picLogo.setBackColor(Color.black);
    picLogo.setLocation(new Point(8, 12));
    picLogo.setName("picLogo");
    picLogo.setSize(new FormSize(80, 80));
    picLogo.SizeMode = PictureBoxSizeMode.StretchImage;
    picLogo.setTabIndex(22);
    picLogo.setTabStop(false);
    // boxInfo
    boxInfo.Controls.addAll((new WinformControl[]{
          btnSave, btnLoad, picInfoLine, btnPrevImage, btnNextImage, lblImage, lblImageLabel, selTemplate,
          lblTemplate, selSize, lblSize, btnSetCustomImage, picShip, txtName, lblName
        }));
    boxInfo.setLocation(new Point(8, 208));
    boxInfo.setName("boxInfo");
    boxInfo.setSize(new FormSize(270, 160));
    boxInfo.setTabIndex(2);
    boxInfo.setTabStop(false);
    boxInfo.setText("Info");
    // btnSave
    btnSave.setFlatStyle(FlatStyle.Flat);
    btnSave.setLocation(new Point(216, 40));
    btnSave.setName("btnSave");
    btnSave.setSize(new FormSize(44, 20));
    btnSave.setTabIndex(4);
    btnSave.setText("Save");
    btnSave.setClick(
        new EventHandler<Object, EventArgs>() {
          @Override
          public void handle(Object sender, EventArgs e) {
            btnSave_Click(sender, e);
          }
        });
    btnSave.setMouseEnter(
        new EventHandler<Object, EventArgs>() {
          @Override
          public void handle(Object sender, EventArgs e) {
            btnSave_MouseEnter(sender, e);
          }
        });
    btnSave.setMouseLeave(
        new EventHandler<Object, EventArgs>() {
          @Override
          public void handle(Object sender, EventArgs e) {
            btnSave_MouseLeave(sender, e);
          }
        });
    // btnLoad
    btnLoad.setFlatStyle(FlatStyle.Flat);
    btnLoad.setLocation(new Point(216, 16));
    btnLoad.setName("btnLoad");
    btnLoad.setSize(new FormSize(44, 20));
    btnLoad.setTabIndex(2);
    btnLoad.setText("Load");
    btnLoad.setClick(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        btnLoad_Click(sender, e);
      }
    });
    // picInfoLine
    picInfoLine.setBackColor(Color.darkGray);
    picInfoLine.setLocation(new Point(8, 89));
    picInfoLine.setName("picInfoLine");
    picInfoLine.setSize(new FormSize(254, 1));
    picInfoLine.setTabIndex(132);
    picInfoLine.setTabStop(false);
    // btnPrevImage
    btnPrevImage.setFlatStyle(FlatStyle.Flat);
    btnPrevImage.setLocation(new Point(154, 95));
    btnPrevImage.setName("btnPrevImage");
    btnPrevImage.setSize(new FormSize(18, 18));
    btnPrevImage.setTabIndex(6);
    btnPrevImage.setText("<");
    btnPrevImage.setClick(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        btnPrevImage_Click(sender, e);
      }
    });
    // btnNextImage
    btnNextImage.setFlatStyle(FlatStyle.Flat);
    btnNextImage.setLocation(new Point(242, 95));
    btnNextImage.setName("btnNextImage");
    btnNextImage.setSize(new FormSize(18, 18));
    btnNextImage.setTabIndex(7);
    btnNextImage.setText(">");
    btnNextImage.setClick(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        btnNextImage_Click(sender, e);
      }
    });
    // lblImage
    lblImage.setLocation(new Point(174, 98));
    lblImage.setName("lblImage");
    lblImage.setSize(new FormSize(70, 13));
    lblImage.setTabIndex(61);
    lblImage.setText("Custom Ship");
    lblImage.TextAlign = ContentAlignment.TopCenter;
    // lblImageLabel
    lblImageLabel.setAutoSize(true);
    lblImageLabel.setLocation(new Point(8, 95));
    lblImageLabel.setName("lblImageLabel");
    lblImageLabel.setSize(new FormSize(39, 13));
    lblImageLabel.setTabIndex(22);
    lblImageLabel.setText("Image:");
    // selTemplate
    selTemplate.DropDownStyle = ComboBoxStyle.DropDownList;
    selTemplate.setLocation(new Point(80, 16));
    selTemplate.setName("selTemplate");
    selTemplate.setSize(new FormSize(132, 21));
    selTemplate.setTabIndex(1);
    // lblTemplate
    lblTemplate.setAutoSize(true);
    lblTemplate.setLocation(new Point(8, 19));
    lblTemplate.setName("lblTemplate");
    lblTemplate.setSize(new FormSize(55, 13));
    lblTemplate.setTabIndex(20);
    lblTemplate.setText("Template:");
    // selSize
    selSize.DropDownStyle = ComboBoxStyle.DropDownList;
    selSize.setLocation(new Point(80, 63));
    selSize.setName("selSize");
    selSize.setSize(new FormSize(180, 21));
    selSize.setTabIndex(5);
    selSize.setSelectedIndexChanged(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        selSize_SelectedIndexChanged(sender, e);
      }
    });
    // lblSize
    lblSize.setAutoSize(true);
    lblSize.setLocation(new Point(8, 66));
    lblSize.setName("lblSize");
    lblSize.setSize(new FormSize(29, 13));
    lblSize.setTabIndex(18);
    lblSize.setText("Size:");
    // btnSetCustomImage
    btnSetCustomImage.setFlatStyle(FlatStyle.Flat);
    btnSetCustomImage.setLocation(new Point(154, 121));
    btnSetCustomImage.setName("btnSetCustomImage");
    btnSetCustomImage.setSize(new FormSize(106, 22));
    btnSetCustomImage.setTabIndex(8);
    btnSetCustomImage.setText("Set Custom...");
    btnSetCustomImage.setClick(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        btnSetCustomImage_Click(sender, e);
      }
    });
    // picShip
    picShip.setBackColor(Color.white);
    picShip.setBorderStyle(BorderStyle.FixedSingle);
    picShip.setLocation(new Point(80, 95));
    picShip.setName("picShip");
    picShip.setSize(new FormSize(66, 54));
    picShip.setTabIndex(14);
    picShip.setTabStop(false);
    // txtName
    txtName.setLocation(new Point(80, 40));
    txtName.setName("txtName");
    txtName.setSize(new FormSize(132, 20));
    txtName.setTabIndex(3);
    txtName.setText("");
    txtName.setTextChanged(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        txtName_TextChanged(sender, e);
      }
    });
    // lblName
    lblName.setAutoSize(true);
    lblName.setLocation(new Point(8, 44));
    lblName.setName("lblName");
    lblName.setSize(new FormSize(63, 13));
    lblName.setTabIndex(5);
    lblName.setText("Ship Name:");
    // lblUnitsUsed
    lblUnitsUsed.setLocation(new Point(110, 186));
    lblUnitsUsed.setName("lblUnitsUsed");
    lblUnitsUsed.setSize(new FormSize(23, 13));
    lblUnitsUsed.setTabIndex(17);
    lblUnitsUsed.setText("888");
    lblUnitsUsed.TextAlign = ContentAlignment.TopRight;
    // lblUnitsUsedLabel
    lblUnitsUsedLabel.setAutoSize(true);
    lblUnitsUsedLabel.setLocation(new Point(8, 186));
    lblUnitsUsedLabel.setName("lblUnitsUsedLabel");
    lblUnitsUsedLabel.setSize(new FormSize(63, 13));
    lblUnitsUsedLabel.setTabIndex(16);
    lblUnitsUsedLabel.setText("Units Used:");
    // boxCosts
    boxCosts.Controls.addAll((new WinformControl[]{
          lblTradeIn, lblTradeInLabel, picCostsLine, lblPenalty, lblPenaltyLabel,
          lblShipCost, lblTotalCost, lblTotalCostLabel, lblShipCostLabel, lblDesignFee, lblDesignFeeLabel}));
    boxCosts.setLocation(new Point(286, 230));
    boxCosts.setName("boxCosts");
    boxCosts.setSize(new FormSize(184, 106));
    boxCosts.setTabIndex(4);
    boxCosts.setTabStop(false);
    boxCosts.setText("Costs");
    // lblTradeIn
    lblTradeIn.setLocation(new Point(106, 64));
    lblTradeIn.setName("lblTradeIn");
    lblTradeIn.setSize(new FormSize(75, 16));
    lblTradeIn.setTabIndex(135);
    lblTradeIn.setText("-8,888,888 cr.");
    lblTradeIn.TextAlign = ContentAlignment.TopRight;
    // lblTradeInLabel
    lblTradeInLabel.setAutoSize(true);
    lblTradeInLabel.setLocation(new Point(8, 64));
    lblTradeInLabel.setName("lblTradeInLabel");
    lblTradeInLabel.setSize(new FormSize(77, 13));
    lblTradeInLabel.setTabIndex(134);
    lblTradeInLabel.setText("Less Trade-In:");
    // picCostsLine
    picCostsLine.setBackColor(Color.darkGray);
    picCostsLine.setLocation(new Point(8, 80));
    picCostsLine.setName("picCostsLine");
    picCostsLine.setSize(new FormSize(168, 1));
    picCostsLine.setTabIndex(133);
    picCostsLine.setTabStop(false);
    // lblPenalty
    lblPenalty.setLocation(new Point(106, 32));
    lblPenalty.setName("lblPenalty");
    lblPenalty.setSize(new FormSize(74, 16));
    lblPenalty.setTabIndex(21);
    lblPenalty.setText("8,888,888 cr.");
    lblPenalty.TextAlign = ContentAlignment.TopRight;
    // lblPenaltyLabel
    lblPenaltyLabel.setAutoSize(true);
    lblPenaltyLabel.setLocation(new Point(8, 32));
    lblPenaltyLabel.setName("lblPenaltyLabel");
    lblPenaltyLabel.setSize(new FormSize(96, 13));
    lblPenaltyLabel.setTabIndex(20);
    lblPenaltyLabel.setText("Crowding Penalty:");
    // lblShipCost
    lblShipCost.setLocation(new Point(106, 16));
    lblShipCost.setName("lblShipCost");
    lblShipCost.setSize(new FormSize(74, 16));
    lblShipCost.setTabIndex(19);
    lblShipCost.setText("8,888,888 cr.");
    lblShipCost.TextAlign = ContentAlignment.TopRight;
    // lblTotalCost
    lblTotalCost.setLocation(new Point(106, 84));
    lblTotalCost.setName("lblTotalCost");
    lblTotalCost.setSize(new FormSize(74, 16));
    lblTotalCost.setTabIndex(18);
    lblTotalCost.setText("8,888,888 cr.");
    lblTotalCost.TextAlign = ContentAlignment.TopRight;
    // lblTotalCostLabel
    lblTotalCostLabel.setAutoSize(true);
    lblTotalCostLabel.setLocation(new Point(8, 84));
    lblTotalCostLabel.setName("lblTotalCostLabel");
    lblTotalCostLabel.setSize(new FormSize(59, 13));
    lblTotalCostLabel.setTabIndex(17);
    lblTotalCostLabel.setText("Total Cost:");
    // lblShipCostLabel
    lblShipCostLabel.setAutoSize(true);
    lblShipCostLabel.setLocation(new Point(8, 16));
    lblShipCostLabel.setName("lblShipCostLabel");
    lblShipCostLabel.setSize(new FormSize(56, 13));
    lblShipCostLabel.setTabIndex(16);
    lblShipCostLabel.setText("Ship Cost:");
    // lblDesignFee
    lblDesignFee.setLocation(new Point(106, 48));
    lblDesignFee.setName("lblDesignFee");
    lblDesignFee.setSize(new FormSize(74, 16));
    lblDesignFee.setTabIndex(15);
    lblDesignFee.setText("888,888 cr.");
    lblDesignFee.TextAlign = ContentAlignment.TopRight;
    // lblDesignFeeLabel
    lblDesignFeeLabel.setAutoSize(true);
    lblDesignFeeLabel.setLocation(new Point(8, 48));
    lblDesignFeeLabel.setName("lblDesignFeeLabel");
    lblDesignFeeLabel.setSize(new FormSize(65, 13));
    lblDesignFeeLabel.setTabIndex(14);
    lblDesignFeeLabel.setText("Design Fee:");
    // btnConstruct
    btnConstruct.setFlatStyle(FlatStyle.Flat);
    btnConstruct.setForeColor(SystemColors.ControlText);
    btnConstruct.setLocation(new Point(382, 344));
    btnConstruct.setName("btnConstruct");
    btnConstruct.setSize(new FormSize(88, 22));
    btnConstruct.setTabIndex(6);
    btnConstruct.setText("Construct Ship");
    btnConstruct.setClick(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        btnConstruct_Click(sender, e);
      }
    });
    btnConstruct.setMouseEnter(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        btnConstruct_MouseEnter(sender, e);
      }
    });
    btnConstruct.setMouseLeave(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        btnConstruct_MouseLeave(sender, e);
      }
    });
    // btnCancel
    btnCancel.setDialogResult(DialogResult.Cancel);
    btnCancel.setFlatStyle(FlatStyle.Flat);
    btnCancel.setLocation(new Point(286, 344));
    btnCancel.setName("btnCancel");
    btnCancel.setSize(new FormSize(88, 22));
    btnCancel.setTabIndex(5);
    btnCancel.setText("Cancel Design");
    // boxAllocation
    boxAllocation.Controls.addAll((new WinformControl[]{
          lblPct, lblPctLabel, numHullStrength, lblHullStrenghLabel, numCargoBays, numCrewQuarters, numFuelTanks,
          numShieldSlots, numGadgetSlots, numWeaponSlots, lblCargoBays, lblFuelTanks, lblCrewQuarters,
          lblShieldSlots, lblGadgetSlots, lblWeaponsSlots, lblUnitsUsedLabel, lblUnitsUsed
    }));
    boxAllocation.setLocation(new Point(286, 0));
    boxAllocation.setName("boxAllocation");
    boxAllocation.setSize(new FormSize(184, 226));
    boxAllocation.setTabIndex(3);
    boxAllocation.setTabStop(false);
    boxAllocation.setText("Space Allocation");
    // lblPct
    lblPct.setFont(new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte)(0))));
    lblPct.setForeColor(Color.red);
    lblPct.setLocation(new Point(110, 204));
    lblPct.setName("lblPct");
    lblPct.setSize(new FormSize(34, 13));
    lblPct.setTabIndex(19);
    lblPct.setText("888%");
    lblPct.TextAlign = ContentAlignment.TopRight;
    // lblPctLabel
    lblPctLabel.setAutoSize(true);
    lblPctLabel.setLocation(new Point(8, 204));
    lblPctLabel.setName("lblPctLabel");
    lblPctLabel.setSize(new FormSize(54, 13));
    lblPctLabel.setTabIndex(18);
    lblPctLabel.setText("% of Max:");
    // numHullStrength
    numHullStrength.setBackColor(Color.white);
    numHullStrength.setLocation(new Point(110, 64));
    numHullStrength.setMaximum(9999);
    numHullStrength.setName("numHullStrength");
    numHullStrength.setReadOnly(true);
    numHullStrength.setSize(new FormSize(64, 20));
    numHullStrength.setTabIndex(1);
    numHullStrength.TextAlign = HorizontalAlignment.Right;
    numHullStrength.setEnter(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        num_ValueEnter(sender, e);
      }
    });
    numHullStrength.setValueChanged(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        num_ValueChanged(sender, e);
      }
    });
    // lblHullStrenghLabel
    lblHullStrenghLabel.setAutoSize(true);
    lblHullStrenghLabel.setLocation(new Point(8, 66));
    lblHullStrenghLabel.setName("lblHullStrenghLabel");
    lblHullStrenghLabel.setSize(new FormSize(70, 13));
    lblHullStrenghLabel.setTabIndex(13);
    lblHullStrenghLabel.setText("Hull Strengh:");
    // numCargoBays
    numCargoBays.setBackColor(Color.white);
    numCargoBays.setLocation(new Point(110, 16));
    numCargoBays.setMaximum(999);
    numCargoBays.setName("numCargoBays");
    numCargoBays.setReadOnly(true);
    numCargoBays.setSize(new FormSize(64, 20));
    numCargoBays.setTabIndex(3);
    numCargoBays.TextAlign = HorizontalAlignment.Right;
    numCargoBays.setEnter(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        num_ValueEnter(sender, e);
      }
    });
    numCargoBays.setValueChanged(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        num_ValueChanged(sender, e);
      }
    });
    // numCrewQuarters
    numCrewQuarters.setBackColor(Color.white);
    numCrewQuarters.setLocation(new Point(110, 160));
    numCrewQuarters.setMinimum(1);
    numCrewQuarters.setName("numCrewQuarters");
    numCrewQuarters.setReadOnly(true);
    numCrewQuarters.setSize(new FormSize(64, 20));
    numCrewQuarters.setTabIndex(4);
    numCrewQuarters.TextAlign = HorizontalAlignment.Right;
    numCrewQuarters.setValue(1);
    numCrewQuarters.setEnter(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        num_ValueEnter(sender, e);
      }
    });
    numCrewQuarters.setValueChanged(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        num_ValueChanged(sender, e);
      }
    });
    // numFuelTanks
    numFuelTanks.setBackColor(Color.white);
    numFuelTanks.setLocation(new Point(110, 40));
    numFuelTanks.setName("numFuelTanks");
    numFuelTanks.setReadOnly(true);
    numFuelTanks.setSize(new FormSize(64, 20));
    numFuelTanks.setTabIndex(2);
    numFuelTanks.TextAlign = HorizontalAlignment.Right;
    numFuelTanks.setEnter(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        num_ValueEnter(sender, e);
      }
    });
    numFuelTanks.setValueChanged(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        num_ValueChanged(sender, e);
      }
    });
    // numShieldSlots
    numShieldSlots.setBackColor(Color.white);
    numShieldSlots.setLocation(new Point(110, 112));
    numShieldSlots.setName("numShieldSlots");
    numShieldSlots.setReadOnly(true);
    numShieldSlots.setSize(new FormSize(64, 20));
    numShieldSlots.setTabIndex(6);
    numShieldSlots.TextAlign = HorizontalAlignment.Right;
    numShieldSlots.setEnter(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        num_ValueEnter(sender, e);
      }
    });
    numShieldSlots.setValueChanged(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        num_ValueChanged(sender, e);
      }
    });
    // numGadgetSlots
    numGadgetSlots.setBackColor(Color.white);
    numGadgetSlots.setLocation(new Point(110, 136));
    numGadgetSlots.setName("numGadgetSlots");
    numGadgetSlots.setReadOnly(true);
    numGadgetSlots.setSize(new FormSize(64, 20));
    numGadgetSlots.setTabIndex(7);
    numGadgetSlots.TextAlign = HorizontalAlignment.Right;
    numGadgetSlots.setEnter(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        num_ValueEnter(sender, e);
      }
    });
    numGadgetSlots.setValueChanged(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        num_ValueChanged(sender, e);
      }
    });
    // numWeaponSlots
    numWeaponSlots.setBackColor(Color.white);
    numWeaponSlots.setLocation(new Point(110, 88));
    numWeaponSlots.setName("numWeaponSlots");
    numWeaponSlots.setReadOnly(true);
    numWeaponSlots.setSize(new FormSize(64, 20));
    numWeaponSlots.setTabIndex(5);
    numWeaponSlots.TextAlign = HorizontalAlignment.Right;
    numWeaponSlots.setEnter(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        num_ValueEnter(sender, e);
      }
    });
    numWeaponSlots.setValueChanged(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        num_ValueChanged(sender, e);
      }
    });
    // lblCargoBays
    lblCargoBays.setAutoSize(true);
    lblCargoBays.setLocation(new Point(8, 18));
    lblCargoBays.setName("lblCargoBays");
    lblCargoBays.setSize(new FormSize(66, 13));
    lblCargoBays.setTabIndex(5);
    lblCargoBays.setText("Cargo Bays:");
    // lblFuelTanks
    lblFuelTanks.setAutoSize(true);
    lblFuelTanks.setLocation(new Point(8, 42));
    lblFuelTanks.setName("lblFuelTanks");
    lblFuelTanks.setSize(new FormSize(41, 13));
    lblFuelTanks.setTabIndex(4);
    lblFuelTanks.setText("Range:");
    // lblCrewQuarters
    lblCrewQuarters.setAutoSize(true);
    lblCrewQuarters.setLocation(new Point(8, 162));
    lblCrewQuarters.setName("lblCrewQuarters");
    lblCrewQuarters.setSize(new FormSize(81, 13));
    lblCrewQuarters.setTabIndex(3);
    lblCrewQuarters.setText("Crew Quarters:");
    // lblShieldSlots
    lblShieldSlots.setAutoSize(true);
    lblShieldSlots.setLocation(new Point(8, 114));
    lblShieldSlots.setName("lblShieldSlots");
    lblShieldSlots.setSize(new FormSize(67, 13));
    lblShieldSlots.setTabIndex(2);
    lblShieldSlots.setText("Shield Slots:");
    // lblGadgetSlots
    lblGadgetSlots.setAutoSize(true);
    lblGadgetSlots.setLocation(new Point(8, 138));
    lblGadgetSlots.setName("lblGadgetSlots");
    lblGadgetSlots.setSize(new FormSize(73, 13));
    lblGadgetSlots.setTabIndex(1);
    lblGadgetSlots.setText("Gadget Slots:");
    // lblWeaponsSlots
    lblWeaponsSlots.setAutoSize(true);
    lblWeaponsSlots.setLocation(new Point(8, 90));
    lblWeaponsSlots.setName("lblWeaponsSlots");
    lblWeaponsSlots.setSize(new FormSize(78, 13));
    lblWeaponsSlots.setTabIndex(0);
    lblWeaponsSlots.setText("Weapon Slots:");
    // ilShipyardLogos
    ilShipyardLogos.ColorDepth = ColorDepth.Depth24Bit;
    ilShipyardLogos.setImageSize(new FormSize(80, 80));
    ilShipyardLogos.setImageStream(((ImageListStreamer)(resources.GetObject("ilShipyardLogos.ImageStream"))));
    ilShipyardLogos.setTransparentColor(Color.black);
    // dlgOpen
    dlgOpen.setFilter("Windows Bitmaps (*.bmp)|*bmp");
    dlgOpen.setTitle("Open Ship Image");
    // lblDisabledPct
    lblDisabledPct.setBackColor(SystemColors.Info);
    lblDisabledPct.setBorderStyle(BorderStyle.FixedSingle);
    lblDisabledPct.ImageAlign = ContentAlignment.MiddleRight;
    lblDisabledPct.setLocation(new Point(154, 182));
    lblDisabledPct.setName("lblDisabledPct");
    lblDisabledPct.setSize(new FormSize(276, 20));
    lblDisabledPct.setTabIndex(8);
    lblDisabledPct.setText("Your % of Max must be less than or equal to 100%.");
    lblDisabledPct.TextAlign = ContentAlignment.MiddleCenter;
    lblDisabledPct.setVisible(false);
    // dlgSave
    dlgSave.setDefaultExt("sst");
    dlgSave.setFileName("CustomShip.sst");
    dlgSave.setFilter("SpaceTrader Ship Template Files (*.sst)|*.sst");
    dlgSave.setTitle("Save Ship Template");
    // lblDisabledName
    lblDisabledName.setBackColor(SystemColors.Info);
    lblDisabledName.setBorderStyle(BorderStyle.FixedSingle);
    lblDisabledName.ImageAlign = ContentAlignment.MiddleLeft;
    lblDisabledName.setLocation(new Point(96, 222));
    lblDisabledName.setName("lblDisabledName");
    lblDisabledName.setSize(new FormSize(170, 20));
    lblDisabledName.setTabIndex(7);
    lblDisabledName.setText("You must enter a Ship Name.");
    lblDisabledName.TextAlign = ContentAlignment.MiddleRight;
    lblDisabledName.setVisible(false);
    // Form_Shipyard
    setAcceptButton(btnConstruct);
    setAutoScaleBaseSize(new FormSize(5, 13));
    setCancelButton(btnCancel);
    setClientSize(new FormSize(478, 375));
    Controls.addAll(Arrays.asList(lblDisabledPct, boxWelcome, lblDisabledName, boxAllocation, boxCosts, boxInfo, btnCancel, btnConstruct));
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
    ((ISupportInitialize)(numHullStrength)).EndInit();
    ((ISupportInitialize)(numCargoBays)).EndInit();
    ((ISupportInitialize)(numCrewQuarters)).EndInit();
    ((ISupportInitialize)(numFuelTanks)).EndInit();
    ((ISupportInitialize)(numShieldSlots)).EndInit();
    ((ISupportInitialize)(numGadgetSlots)).EndInit();
    ((ISupportInitialize)(numWeaponSlots)).EndInit();
    ResumeLayout(false);
  }

  private boolean ConstructButtonEnabled() {
    return yard.PercentOfMaxUnits() <= 100 && txtName.getText().length() > 0;
  }

  private WfBitmap GetImageFile(String fileName) {
    WfBitmap image = null;
    try {
      image = new WfBitmap(fileName);
    } catch(Exception ex) {
      FormAlert.Alert(AlertType.FileErrorOpen, this, fileName, ex.getMessage());
    }
    return image;
  }

  private void LoadSelectedTemplate() {
    if(selTemplate.getSelectedItem() instanceof ShipTemplate) {
      loading = true;
      ShipTemplate template = (ShipTemplate)selTemplate.getSelectedItem();
      if(template.Name().equals(Strings.ShipNameCurrentShip)) {
        txtName.setText(cmdr.getShip().Name());
      } else if(template.Name().endsWith(Strings.ShipNameTemplateSuffixDefault) || template.Name().endsWith(Strings.ShipNameTemplateSuffixMinimum)) {
        txtName.setText("");
      } else {
        txtName.setText(template.Name());
      }
      selSize.setSelectedIndex(Math.max(0, sizes.indexOf(template.Size())));
      imgIndex = template.ImageIndex() == ShipType.Custom.CastToInt() ? imgTypes.length - 1 : template.ImageIndex();
      if(template.Images() != null) {
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
      if(selTemplate.Items.get(0).toString().equals(Strings.ShipNameModified)) {
        selTemplate.Items.remove(0);
      }
      loading = false;
    }
  }

  private void LoadSizes() {
    sizes = new ArrayList<>(6);
    for(ShipSize size : yard.AvailableSizes()) {
      sizes.add(size);
      selSize.Items.add(Functions.StringVars(
          Strings.ShipyardSizeItem, Strings.Sizes[size.CastToInt()],
          Functions.Multiples(Shipyard.MAX_UNITS[size.CastToInt()], Strings.ShipyardUnit)));
    }
  }

  private void LoadTemplateList() {
    ShipTemplate currentShip = new ShipTemplate(cmdr.getShip(), Strings.ShipNameCurrentShip);
    selTemplate.Items.add(currentShip);
    selTemplate.Items.add(Consts.ShipTemplateSeparator);
    // Add the minimal sizes templates.
    for(ShipSize size : sizes) {
      selTemplate.Items.add(new ShipTemplate(size, Strings.Sizes[size.CastToInt()] + Strings.ShipNameTemplateSuffixMinimum));
    }
    selTemplate.Items.add(Consts.ShipTemplateSeparator);
    // Add the buyable ship spec templates.
    for(ShipSpec spec : Consts.ShipSpecs) {
      if(sizes.contains(spec.getSize()) && spec.Type().CastToInt() <= Consts.MaxShip) {
        selTemplate.Items.add(new ShipTemplate(spec, spec.Name() + Strings.ShipNameTemplateSuffixDefault));
      }
    }
    selTemplate.Items.add(Consts.ShipTemplateSeparator);
    // Add the user-created templates.
    ArrayList<ShipTemplate> userTemplates = new ArrayList<>();
    for(String fileName : Directory.GetFiles(Consts.CustomTemplatesDirectory, "*.sst")) {
      ShipTemplate template = new ShipTemplate((Hashtable)Functions.LoadFile(fileName, true, this));
      if(sizes.contains(template.Size())) {
        userTemplates.add(template);
      }
    }
    userTemplates.Sort();
    selTemplate.Items.AddRange(userTemplates.toArray(new ShipTemplate[0]));
    selTemplate.setSelectedIndex(0);
  }

  private boolean SaveButtonEnabled() {
    return (txtName.getText().length() > 0);
  }

  private void SetTemplateModified() {
    if(!loading && selTemplate.Items.getSize() > 0) {
      if(!selTemplate.Items.get(0).toString().equals(Strings.ShipNameModified)) {
        selTemplate.Items.Insert(0, Strings.ShipNameModified);
      }
      selTemplate.setSelectedIndex(0);
    }
  }

  private void UpdateAllocation() {
    boolean fuelMinimum = numFuelTanks.getValue() == numFuelTanks.getMinimum();
    boolean hullMinimum = numHullStrength.getValue() == numHullStrength.getMinimum();
    numFuelTanks.setMinimum(yard.BaseFuel());
    numFuelTanks.setIncrement(yard.PerUnitFuel());
    numFuelTanks.setMaximum(Consts.MaxFuelTanks);
    if(fuelMinimum) {
      numFuelTanks.setValue(numFuelTanks.getMinimum());
    }
    numHullStrength.setMinimum(yard.BaseHull());
    numHullStrength.setIncrement(yard.PerUnitHull());
    if(hullMinimum) {
      numHullStrength.setValue(numHullStrength.getMinimum());
    }
    numWeaponSlots.setMaximum(Consts.MaxSlots);
    numShieldSlots.setMaximum(Consts.MaxSlots);
    numGadgetSlots.setMaximum(Consts.MaxSlots);
    numCrewQuarters.setMaximum(Consts.MaxSlots);
  }

  private void UpdateCalculatedFigures() {
    // Fix the fuel value to be a multiple of the per unit value less the super.
    int extraFuel = numFuelTanks.getValue() - yard.BaseFuel();
    if(extraFuel % yard.PerUnitFuel() > 0 && numFuelTanks.getValue() < numFuelTanks.getMaximum()) {
      numFuelTanks.setValue(Math.max(numFuelTanks.getMinimum(),
          Math.min(numFuelTanks.getMaximum(), (extraFuel + yard.PerUnitFuel()) / yard.PerUnitFuel() * yard.PerUnitFuel() + yard.BaseFuel())));
    }
    // Fix the hull value to be a multiple of the unit value value less the super.
    int extraHull = numHullStrength.getValue() - yard.BaseHull();
    if(extraHull % yard.PerUnitHull() > 0) {
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
    lblUnitsUsed.setText(yard.UnitsUsed() + "");
    lblPct.setText(Functions.FormatPercent(yard.PercentOfMaxUnits()));
    if(yard.PercentOfMaxUnits() >= Shipyard.PENALTY_FIRST_PCT) {
      lblPct.setFont(lblSkillLabel.getFont());
    } else {
      lblPct.setFont(lblPctLabel.getFont());
    }
    if(yard.UnitsUsed() > yard.MaxUnits()) {
      lblPct.setForeColor(Color.red);
    } else if(yard.PercentOfMaxUnits() >= Shipyard.PENALTY_SECOND_PCT) {
      lblPct.setForeColor(Color.orange);
    } else if(yard.PercentOfMaxUnits() >= Shipyard.PENALTY_FIRST_PCT) {
      lblPct.setForeColor(Color.yellow);
    } else {
      lblPct.setForeColor(lblPctLabel.getForeColor());
    }
    lblShipCost.setText(Functions.FormatMoney(yard.AdjustedPrice()));
    lblDesignFee.setText(Functions.FormatMoney(yard.AdjustedDesignFee()));
    lblPenalty.setText(Functions.FormatMoney(yard.AdjustedPenaltyCost()));
    lblTradeIn.setText(Functions.FormatMoney(-yard.TradeIn()));
    lblTotalCost.setText(Functions.FormatMoney(yard.TotalCost()));
    UpdateButtonEnabledState();
  }

  private void UpdateButtonEnabledState() {
    btnConstruct.setForeColor(ConstructButtonEnabled() ? Color.black : Color.gray);
    btnSave.setForeColor(SaveButtonEnabled() ? Color.black : Color.gray);
  }

  private void UpdateShip() {
    yard.ShipSpec().ImageIndex(imgTypes[imgIndex].CastToInt());
    picShip.setImage((imgIndex > Consts.MaxShip ? customImages[0] : Consts.ShipSpecs[imgTypes[imgIndex].CastToInt()].Image()));
    lblImage.setText((imgIndex > Consts.MaxShip ? Strings.ShipNameCustomShip : Consts.ShipSpecs[imgTypes[imgIndex].CastToInt()].Name()));
  }

  private void btnConstruct_Click(Object sender, EventArgs e) {
    if(ConstructButtonEnabled()) {
      if(cmdr.TradeShip(yard.ShipSpec(), yard.TotalCost(), txtName.getText(), this)) {
        Strings.ShipNames[ShipType.Custom.CastToInt()] = txtName.getText();
        if(game.getQuestStatusScarab() == SpecialEvent.StatusScarabDone) {
          game.setQuestStatusScarab(SpecialEvent.StatusScarabNotStarted);
        }
        // Replace the current custom images with the new ones.
        if(cmdr.getShip().ImageIndex() == ShipType.Custom.CastToInt()) {
          game.getParentWindow().setCustomShipImages(customImages);
          cmdr.getShip().UpdateCustomImageOffsetConstants();
        }
        FormAlert.Alert(AlertType.ShipDesignThanks, this, yard.Name());
        Close();
      }
    }
  }

  private void btnConstruct_MouseEnter(Object sender, EventArgs e) {
    lblDisabledName.setVisible(txtName.getText().length() == 0);
    lblDisabledPct.setVisible(yard.PercentOfMaxUnits() > 100);
  }

  private void btnConstruct_MouseLeave(Object sender, EventArgs e) {
    lblDisabledName.setVisible(false);
    lblDisabledPct.setVisible(false);
  }

  private void btnLoad_Click(Object sender, EventArgs e) {
    LoadSelectedTemplate();
  }

  private void btnNextImage_Click(Object sender, EventArgs e) {
    SetTemplateModified();
    imgIndex = (imgIndex + 1) % imgTypes.length;
    UpdateShip();
  }

  private void btnPrevImage_Click(Object sender, EventArgs e) {
    SetTemplateModified();
    imgIndex = (imgIndex + imgTypes.length - 1) % imgTypes.length;
    UpdateShip();
  }

  private void btnSave_Click(Object sender, EventArgs e) {
    if(SaveButtonEnabled()) {
      if(dlgSave.ShowDialog(this) == DialogResult.OK) {
        ShipTemplate template = new ShipTemplate(yard.ShipSpec(), txtName.getText());
        if(imgIndex > Consts.MaxShip) {
          template.ImageIndex(ShipType.Custom.CastToInt());
          template.Images(customImages);
        } else {
          template.ImageIndex(imgIndex);
        }
        Functions.SaveFile(dlgSave.getFileName(), template.Serialize(), this);
        LoadTemplateList();
      }
    }
  }

  private void btnSave_MouseEnter(Object sender, EventArgs e) {
    lblDisabledName.setVisible(txtName.getText().length() == 0);
  }

  private void btnSave_MouseLeave(Object sender, EventArgs e) {
    lblDisabledName.setVisible(false);
  }

  private void btnSetCustomImage_Click(Object sender, EventArgs e) {
    if(dlgOpen.ShowDialog(this) == DialogResult.OK) {
      String baseFileName = Path.RemoveExtension(dlgOpen.getFileName());
      String ext = Path.GetExtension(dlgOpen.getFileName());
      WfBitmap image = GetImageFile(baseFileName + ext);
      WfBitmap imageDamaged = GetImageFile(baseFileName + "d" + ext);
      WfBitmap imageShields = GetImageFile(baseFileName + "s" + ext);
      WfBitmap imageShieldsDamaged = GetImageFile(baseFileName + "sd" + ext);
      if(image != null && imageDamaged != null && imageShields != null && imageShieldsDamaged != null) {
        customImages[Consts.ShipImgOffsetNormal] = image;
        customImages[Consts.ShipImgOffsetDamage] = imageDamaged;
        customImages[Consts.ShipImgOffsetShield] = imageShields;
        customImages[Consts.ShipImgOffsetSheildDamage] = imageShieldsDamaged;
      }
      imgIndex = imgTypes.length - 1;
      UpdateShip();
    }
  }

  private void num_ValueChanged(Object sender, EventArgs e) {
    SetTemplateModified();
    UpdateCalculatedFigures();
  }

  private void num_ValueEnter(Object sender, EventArgs e) {
    ((NumericUpDown)sender).Select(0, ("" + ((NumericUpDown)sender).getValue()).length());
  }

  private void selSize_SelectedIndexChanged(Object sender, EventArgs e) {
    SetTemplateModified();
    yard.ShipSpec().setSize(sizes.get(selSize.getSelectedIndex()));
    UpdateAllocation();
    UpdateCalculatedFigures();
  }

  private void txtName_TextChanged(Object sender, EventArgs e) {
    SetTemplateModified();
    UpdateButtonEnabledState();
  }
}
