package org.spacetrader.controller;

import org.spacetrader.controller.enums.AlertType;
import org.spacetrader.model.Difficulty;
import org.spacetrader.ui.FormAlert;
import org.spacetrader.util.*;
import org.winforms.Graphics;
import org.winforms.Rectangle;
import org.winforms.*;

import java.awt.*;
import java.io.*;
import java.util.Random;

// TODO this is a random collection of things class, split it up
public class Functions {
    private final static long DEFSEEDX = 521288629;
    private final static long DEFSEEDY = 362436069;
    private final static int MAX_WORD = 65535;
    private static Random rand = new Random();
    private static long SeedX = DEFSEEDX;
    private static long SeedY = DEFSEEDY;

    public static int AdjustSkillForDifficulty(int skill) {
        Difficulty diff = Game.CurrentGame().Difficulty();
        skill = diff.adjustSkill(skill);
        return skill;
    }

    public static String[] ArrayListtoStringArray(ArrayList<?> list) {
        String[] items = new String[list.size()];
        for (int i = 0; i < items.length; i++) {
            items[i] = (String) list.get(i);
        }
        return items;
    }

    public static int Distance(StarSystem a, StarSystem b) {
        return (int) Math.floor(Math.sqrt(Math.pow(a.X() - b.X(), 2) + Math.pow(a.Y() - b.Y(), 2)));
    }

    public static int Distance(StarSystem a, int x, int y) {
        return (int) Math.floor(Math.sqrt(Math.pow(a.X() - x, 2) + Math.pow(a.Y() - y, 2)));
    }

    private static void DrawPartialImage(Graphics g, wfImage img, int start, int stop) {
        g.DrawImage(img, 2 + start, 2, new Rectangle(start, 0, stop - start, img.getHeight()), GraphicsUnit.Pixel);
    }

    public static String FormatNumber(int num) {
        return String.format("%,d", num);
    }

    public static String FormatList(String[] listItems) {
        return StringVars(Strings.ListStrings[listItems.length], listItems);
    }

    public static String FormatMoney(int num) {
        return String.format("%,d cr.", num);
    }

    public static String FormatPercent(int num) {
        return String.format("%,d%%", num);
    }

    public static int GetColumnOfFirstNonWhitePixel(wfImage image, int direction) {
        wfBitmap bitmap = new wfBitmap(image);
        int step = direction < 0 ? -1 : 1;
        int col = step > 0 ? 0 : bitmap.getWidth() - 1;
        int stop = step > 0 ? bitmap.getWidth() : -1;
        for (; col != stop; col += step) {
            for (int row = 0; row < bitmap.getHeight(); row++) {
                if (bitmap.ToArgb(col, row) != 0) {
                    return col;
                }
            }
        }
        return -1;
    }

    public static HighScoreRecord[] GetHighScores(wfPane owner) {
        HighScoreRecord[] highScores = new HighScoreRecord[3];
        Object obj = LoadFile(Constants.HighScoreFile, true, owner);
        if (obj != null) {
            highScores = (HighScoreRecord[]) SerializableObject.ArrayListToArray((ArrayList<Hashtable>) obj, "HighScoreRecord");
        }
        return highScores;
    }

    public static int GetRandom(int max) {
        return GetRandom(0, max);
    }

    public static int GetRandom(int min, int max) {
        return rand.nextInt(max - min) + min;
    }

    // Pieter's new random functions, tweaked a bit by SjG
    public static int GetRandom2(int max) {
        return (int) (Rand() % max);
    }

    public static RegistryKey GetRegistryKey() {
        File regfile = new File("registryKey.properties");
        return new RegistryKey(regfile);
    }

    public static boolean IsInt(String toParse) {
        boolean isInt = true;
        try {
            Integer.parseInt(toParse);
        } catch (Exception e) {
            return false;
        }
        return isInt;
    }

    public static Object LoadFile(String fileName, boolean ignoreMissingFile, wfPane owner) {
        Object obj = null;
        FileInputStream inStream = null;
        try {
            inStream = new FileInputStream(fileName/* , FileMode.Open */);
            obj = (new BinaryFormatter()).Deserialize(inStream);
        } catch (FileNotFoundException e) {
            if (!ignoreMissingFile) {
                FormAlert.Alert(AlertType.FileErrorOpen, owner, fileName, e.getMessage());
            }
        } catch (IOException ex) {
            FormAlert.Alert(AlertType.FileErrorOpen, owner, fileName, ex.getMessage());
        } catch (SerializationException ex) {
            FormAlert.Alert(AlertType.FileErrorOpen, owner, fileName, Strings.FileFormatBad);
        } finally {
            if (inStream != null) {
                try {
                    inStream.close();
                } catch (IOException e) {
                    Log.write("Can't close instream... 231");
                }
            }
        }
        return obj;
    }

    public static String Multiples(int num, String unit) {
        return FormatNumber(num) + " " + unit + (num == 1 ? "" : "s");
    }

    public static void PaintShipImage(Ship ship, Graphics graphics, Color backgroundColor) {
        int x = Constants.ShipImageOffsets[ship.Type().CastToInt()].X;
        int width = Constants.ShipImageOffsets[ship.Type().CastToInt()].Width;
        int startDamage = x + width - ship.getHull() * width / ship.HullStrength();
        int startShield = x + width + 2 - (ship.ShieldStrength() > 0 ? ship.ShieldCharge() * (width + 4) / ship.ShieldStrength() : 0);
        graphics.clear(backgroundColor);
        if (startDamage > x) {
            if (startShield > x) {
                DrawPartialImage(graphics, ship.ImageDamaged(), x, Math.min(startDamage, startShield));
            }
            if (startShield < startDamage) {
                DrawPartialImage(graphics, ship.ImageDamagedWithShields(), startShield, startDamage);
            }
        }
        if (startShield > startDamage) {
            DrawPartialImage(graphics, ship.Image(), startDamage, startShield);
        }
        if (startShield < x + width + 2) {
            DrawPartialImage(graphics, ship.ImageWithShields(), startShield, x + width + 2);
        }
    }

    private static long Rand() {
        final int a = 18000;
        final int b = 30903;
        SeedX = a * (SeedX & MAX_WORD) + (SeedX >> 16);
        SeedY = b * (SeedY & MAX_WORD) + (SeedY >> 16);
        return ((SeedX << 16) + (SeedY & MAX_WORD));
    }

    public static int RandomSkill() {
        return 1 + GetRandom(5) + GetRandom(6);
    }

    public static void RandSeed(int seed1, int seed2) {
        if (seed1 > 0) {
            SeedX = seed1; /* use default seeds if parameter is 0 */
        } else {
            SeedX = DEFSEEDX;
        }
        if (seed2 > 0) {
            SeedY = seed2;
        } else {
            SeedY = DEFSEEDY;
        }
    }

    public static boolean SaveFile(String fileName, Object toSerialize, wfPane owner) {
        System.out.println(fileName);
        FileOutputStream outStream = null;
        boolean saveOk = false;
        try {
            new File(fileName).createNewFile();
            outStream = new FileOutputStream(fileName, false);
            (new BinaryFormatter()).Serialize(outStream, toSerialize);
            saveOk = true;
        } catch (IOException ex) {
            FormAlert.Alert(AlertType.FileErrorSave, owner, fileName, ex.getMessage());
        } finally {
            if (outStream != null) {
                try {
                    outStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return saveOk;
    }

    //TODO replace w/String.format?
    public static String StringVars(String toParse, String[] vars) {
        String parsed = toParse;
        for (int i = 0; i < vars.length; i++) {
            parsed = parsed.replaceAll("\\^" + (i + 1), vars[i]);
        }
        return parsed;
    }

    public static String StringVars(String toParse, String var1) {
        return StringVars(toParse, new String[]{var1});
    }

    public static String StringVars(String toParse, String var1, String var2) {
        return StringVars(toParse, new String[]{var1, var2});
    }

    // Returns true if there exists a wormhole from a to b.
    // If b < 0, then return true if there exists a wormhole at all from a.
    public static boolean WormholeExists(int a, int b) {
        int[] wormholes = Game.CurrentGame().Wormholes();
        int i = Util.BruteSeek(wormholes, a);
        return (i >= 0 && (b < 0 || wormholes[(i + 1) % wormholes.length] == b));
    }

    public static boolean WormholeExists(StarSystem a, StarSystem b) {
        StarSystem[] universe = Game.CurrentGame().Universe();
        int[] wormholes = Game.CurrentGame().Wormholes();
        int i = Util.BruteSeek(wormholes, a.Id().CastToInt());
        return (i >= 0 && (universe[wormholes[(i + 1) % wormholes.length]] == b));
    }

    public static StarSystem WormholeTarget(int a) {
        int[] wormholes = Game.CurrentGame().Wormholes();
        int i = Util.BruteSeek(wormholes, a);
        return (i >= 0 ? (Game.CurrentGame().Universe()[wormholes[(i + 1) % wormholes.length]]) : null);
    }
}
