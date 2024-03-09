package org.spacetrader.main.gui;
import java.awt.Point;
import java.util.Arrays;
import jwinforms.Button;
import jwinforms.Font;
import jwinforms.FormSize;
import jwinforms.GraphicsUnit;
import jwinforms.GroupBox;
import jwinforms.Label;
import jwinforms.WinformControl;
import jwinforms.WinformForm;
import jwinforms.enums.DialogResult;
import jwinforms.enums.FontStyle;
import jwinforms.enums.FormBorderStyle;
import jwinforms.enums.FormStartPosition;
import org.spacetrader.main.stub.ArrayList;
import org.spacetrader.main.util.Util;
import org.spacetrader.ship.equip.GadgetType;
import org.spacetrader.main.Consts;
import org.spacetrader.main.Functions;
import org.spacetrader.main.Game;
import org.spacetrader.main.Ship;
import org.spacetrader.main.SpecialEvent;
import org.spacetrader.main.Strings;


public class FormViewShip extends WinformForm {
  private Button btnClose;
  private GroupBox boxSpecialCargo;
  private Label lblTypeLabel;
  private Label lblType;
  private Label lblSpecialCargo;
  private Label lblEquipLabel;
  private Label lblEquip;
  private Game game = Game.CurrentGame();
  private Ship ship = game.Commander().getShip();

  public FormViewShip() {
    InitializeComponent();
    lblType.setText(ship.Name());
    lblEquipLabel.setText("");
    lblEquip.setText("");
    DisplayEquipment();
    DisplaySpecialCargo();
  }

  // Required method for Designer support - do not modify the contents of this method with the code editor.
  private void InitializeComponent() {
    lblTypeLabel = new Label();
    lblType = new Label();
    btnClose = new Button();
    lblEquipLabel = new Label();
    lblEquip = new Label();
    boxSpecialCargo = new GroupBox();
    lblSpecialCargo = new Label();
    boxSpecialCargo.SuspendLayout();
    SuspendLayout();
    // lblTypeLabel
    lblTypeLabel.setAutoSize(true);
    lblTypeLabel.setFont(new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte)(0))));
    lblTypeLabel.setLocation(new Point(8, 8));
    lblTypeLabel.setSize(new FormSize(34, 13));
    lblTypeLabel.setTabIndex(2);
    lblTypeLabel.setText("Type:");
    // lblType
    lblType.setLocation(new Point(80, 8));
    lblType.setSize(new FormSize(100, 13));
    lblType.setTabIndex(4);
    lblType.setText("Grasshopper");
    // btnClose
    btnClose.setDialogResult(DialogResult.Cancel);
    btnClose.setLocation(new Point(-32, -32));
    btnClose.setSize(new FormSize(32, 32));
    btnClose.setTabIndex(32);
    btnClose.setTabStop(false);
    btnClose.setText("X");
    // lblEquipLabel
    lblEquipLabel.setFont(new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte)(0))));
    lblEquipLabel.setLocation(new Point(8, 34));
    lblEquipLabel.setSize(new FormSize(64, 176));
    lblEquipLabel.setTabIndex(43);
    lblEquipLabel.setText("Hull:\r\n\r\nEquipment:\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\nUnfilled:");
    // lblEquip
    lblEquip.setLocation(new Point(80, 34));
    lblEquip.setSize(new FormSize(120, 176));
    lblEquip.setTabIndex(44);
    lblEquip.setText("Hardened\r\n\r\n1 Military Laser\r\n1 Morgan\'s Laser\r\n1 Energy Shield\r\n1 Reflective Shi"
        + "eld\r\n1 Lightning Shield\r\nNavigating System\r\nAuto-Repair System\r\n10 Extra Cargo Bays\r\nAn Escape Pod\r\n"
        + "\r\n1 weapon slot\r\n1 gadget slot");
    // boxSpecialCargo
    boxSpecialCargo.Controls.addAll((new WinformControl[] {lblSpecialCargo}));
    boxSpecialCargo.setLocation(new Point(192, 8));
    boxSpecialCargo.setSize(new FormSize(200, 204));
    boxSpecialCargo.setTabIndex(64);
    boxSpecialCargo.setTabStop(false);
    boxSpecialCargo.setText("Special Cargo");
    // lblSpecialCargo
    lblSpecialCargo.setLocation(new Point(8, 16));
    lblSpecialCargo.setSize(new FormSize(190, 176));
    lblSpecialCargo.setTabIndex(0);
    lblSpecialCargo.setText("No special items.");
    // FormViewShip
    setAutoScaleBaseSize(new FormSize(5, 13));
    setCancelButton(btnClose);
    setClientSize(new FormSize(402, 219));
    Controls.addAll(Arrays.asList(boxSpecialCargo, lblEquip, lblEquipLabel, btnClose, lblTypeLabel, lblType));
    setFormBorderStyle(FormBorderStyle.FixedDialog);
    setMaximizeBox(false);
    setMinimizeBox(false);
    setShowInTaskbar(false);
    setStartPosition(FormStartPosition.CenterParent);
    setText("Current Ship");
    boxSpecialCargo.ResumeLayout(false);
    ResumeLayout(false);
  }

  private void DisplayEquipment() {
    if(game.getQuestStatusScarab() == SpecialEvent.StatusScarabDone) {
      lblEquipLabel.setText(lblEquipLabel.getText() + ("Hull:" + Strings.newline + Strings.newline));
      lblEquip.setText(lblEquip.getText() + ("Hardened" + Strings.newline + Strings.newline));
    }
    boolean equipPrinted = false;
    for(int i = 0; i < Consts.WeapObjs.length; i++) {
      int count = 0;
      for(int j = 0; j < ship.Weapons().length; j++) {
        if(ship.Weapons()[j] != null && ship.Weapons()[j].Type() == Consts.WeapObjs[i].Type()) {
          count++;
        }
      }
      if(count > 0) {
        lblEquipLabel.setText(lblEquipLabel.getText() + (equipPrinted ? Strings.newline : "Equipment:" + Strings.newline));
        lblEquip.setText(lblEquip.getText() + (Functions.Multiples(count, Consts.WeapObjs[i].Name()) + Strings.newline));
        equipPrinted = true;
      }
    }
    for(int i = 0; i < Consts.Shields.length; i++) {
      int count = 0;
      for(int j = 0; j < ship.Shields().length; j++) {
        if(ship.Shields()[j] != null && ship.Shields()[j].Type() == Consts.Shields[i].Type()) {
          count++;
        }
      }
      if(count > 0) {
        lblEquipLabel.setText(lblEquipLabel.getText() + (equipPrinted ? Strings.newline : "Equipment:" + Strings.newline));
        lblEquip.setText(lblEquip.getText() + (Functions.Multiples(count, Consts.Shields[i].Name()) + Strings.newline));
        equipPrinted = true;
      }
    }
    for(int i = 0; i < Consts.Gadgets.length; i++) {
      int count = 0;
      for(int j = 0; j < ship.Gadgets().length; j++) {
        if(ship.Gadgets()[j] != null && ship.Gadgets()[j].Type() == Consts.Gadgets[i].Type()) {
          count++;
        }
      }
      if(count > 0) {
        lblEquipLabel.setText(lblEquipLabel.getText() + (equipPrinted ? Strings.newline : "Equipment:" + Strings.newline));
        if(i == GadgetType.ExtraCargoBays.asInteger() || i == GadgetType.HiddenCargoBays.asInteger()) {
          count *= 5;
          lblEquip.setText(lblEquip.getText() + (Functions.FormatNumber(count) + Consts.Gadgets[i].Name().substring(1) + Strings.newline));
        } else {
          lblEquip.setText(lblEquip.getText() + (Functions.Multiples(count, Consts.Gadgets[i].Name()) + Strings.newline));
        }
        equipPrinted = true;
      }
    }
    if(ship.getEscapePod()) {
      lblEquipLabel.setText(lblEquipLabel.getText() + (equipPrinted ? Strings.newline : "Equipment:" + Strings.newline));
      lblEquip.setText(lblEquip.getText() + ("1 " + Strings.ShipInfoEscapePod + Strings.newline));
      equipPrinted = true;
    }
    if(ship.FreeSlots() > 0) {
      lblEquipLabel.setText(lblEquipLabel.getText() + ((equipPrinted ? Strings.newline : "") + "Unfilled:"));
      lblEquip.setText(lblEquip.getText() + (equipPrinted ? Strings.newline : ""));
      if(ship.FreeSlotsWeapon() > 0) {
        lblEquip.setText(lblEquip.getText() + (Functions.Multiples(ship.FreeSlotsWeapon(), "weapon slot") + Strings.newline));
      }
      if(ship.FreeSlotsShield() > 0) {
        lblEquip.setText(lblEquip.getText() + (Functions.Multiples(ship.FreeSlotsShield(), "shield slot") + Strings.newline));
      }
      if(ship.FreeSlotsGadget() > 0) {
        lblEquip.setText(lblEquip.getText() + (Functions.Multiples(ship.FreeSlotsGadget(), "gadget slot") + Strings.newline));
      }
    }
  }

  private void DisplaySpecialCargo() {
    ArrayList<String> specialCargo = new ArrayList<>(12);
    if(ship.getTribbles() > 0) {
      if(ship.getTribbles() == Consts.MaxTribbles) {
        specialCargo.add(Strings.SpecialCargoTribblesInfest);
      } else {
        specialCargo.add(Functions.Multiples(ship.getTribbles(), Strings.SpecialCargoTribblesCute) + ".");
      }
    }
    if(game.getQuestStatusJapori() == SpecialEvent.StatusJaporiInTransit) {
      specialCargo.add(Strings.SpecialCargoJapori);
    }
    if(ship.ArtifactOnBoard()) {
      specialCargo.add(Strings.SpecialCargoArtifact);
    }
    if(game.getQuestStatusJarek() == SpecialEvent.StatusJarekDone) {
      specialCargo.add(Strings.SpecialCargoJarek);
    }
    if(ship.ReactorOnBoard()) {
      specialCargo.add(Strings.SpecialCargoReactor);
      specialCargo.add(Functions.Multiples(10 - ((game.getQuestStatusReactor() - 1) / 2), "bay") + Strings.SpecialCargoReactorBays);
    }
    if(ship.SculptureOnBoard()) {
      specialCargo.add(Strings.SpecialCargoSculpture);
    }
    if(game.getCanSuperWarp()) {
      specialCargo.add(Strings.SpecialCargoExperiment);
    }
    lblSpecialCargo.setText(specialCargo.size() == 0
        ? Strings.SpecialCargoNone
        : Util.StringsJoin(Strings.newline + Strings.newline, Functions.ArrayListtoStringArray(specialCargo)));
  }
}
