package org.spacetrader.model;

import org.spacetrader.Constants;
import org.spacetrader.controller.Game;
import org.spacetrader.controller.HighScoreRecord;
import org.spacetrader.model.enums.AlertType;
import org.spacetrader.model.enums.Difficulty;
import org.spacetrader.model.ship.Ship;
import org.spacetrader.model.system.StarSystem;
import org.spacetrader.ui.DialogAlert;
import org.spacetrader.ui.Strings;
import org.spacetrader.util.*;
import org.winforms.util.Graphics;
import org.winforms.dialog.Pane;
import org.winforms.image.Image;
import org.winforms.util.Rectangle;
import org.winforms.image.Bitmap;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Random;

// TODO this is a random collection of things class, split it up
public class ModelUtils {
    private final static long DEFSEEDX = 521288629;
    private final static long DEFSEEDY = 362436069;
    private final static int MAX_WORD = 65535;
    private static final Random rand = new Random();
    private static long SeedX = DEFSEEDX;
    private static long SeedY = DEFSEEDY;

    public static int adjustSkillForDifficulty(int skill) {
        Difficulty difficulty = Game.getCurrentGame().Difficulty();
        return difficulty.adjustSkill(skill);
    }

    public static String[] arrayListtoStringArray(ArrayList<?> list) {
        String[] items = new String[list.size()];
        for (int i = 0; i < items.length; i++) {
            items[i] = (String) list.get(i);
        }
        return items;
    }

    public static int distance(StarSystem a, StarSystem b) {
        return (int) Math.floor(Math.sqrt(Math.pow(a.X() - b.X(), 2) + Math.pow(a.Y() - b.Y(), 2)));
    }

    public static int distance(StarSystem a, int x, int y) {
        return (int) Math.floor(Math.sqrt(Math.pow(a.X() - x, 2) + Math.pow(a.Y() - y, 2)));
    }

    private static void drawPartialImage(Graphics g, Image img, int start, int stop) {
        g.drawImage(img, 2 + start, 2, new Rectangle(start, 0, stop - start, img.getHeight()));
    }

    public static String formatNumber(int num) {
        return String.format("%,d", num);
    }

    public static String formatList(String[] listItems) {
        return StringVars(Strings.ListStrings[listItems.length], listItems);
    }

    public static String formatMoney(int num) {
        return String.format("%,d cr.", num);
    }

    public static String formatPercent(int num) {
        return String.format("%,d%%", num);
    }

    public static int getColumnOfFirstNonWhitePixel(Image image, int direction) {
        Bitmap bitmap = new Bitmap(image);
        int step = direction < 0 ? -1 : 1;
        int col = step > 0 ? 0 : bitmap.getWidth() - 1;
        int stop = step > 0 ? bitmap.getWidth() : -1;
        for (; col != stop; col += step) {
            for (int row = 0; row < bitmap.getHeight(); row++) {
                if (bitmap.toArgb(col, row) != 0) {
                    return col;
                }
            }
        }
        return -1;
    }

    public static HighScoreRecord[] GetHighScores(Pane owner) {
        HighScoreRecord[] highScores = new HighScoreRecord[3];
        Object obj = loadFile(Constants.HighScoreFile, true, owner);
        if (obj != null) {
            highScores = (HighScoreRecord[]) SerializableObject.ArrayListToArray((ArrayList<Hashtable>) obj, "HighScoreRecord");
        }
        return highScores;
    }

    public static int getRandom(int max) {
        return getRandom(0, max);
    }

    public static int getRandom(int min, int max) {
        return rand.nextInt(max - min) + min;
    }

    // Pieter's new random functions, tweaked a bit by SjG
    public static int getRandom2(int max) {
        return (int) (rand() % max);
    }

    public static RegistryKey getRegistryKey() {
        File regfile = new File("registryKey.properties");
        return new RegistryKey(regfile);
    }

    public static boolean isInt(String toParse) {
        boolean isInt = true;
        try {
            Integer.parseInt(toParse);
        } catch (Exception e) {
            return false;
        }
        return isInt;
    }

    public static Object loadFile(String fileName, boolean ignoreMissingFile, Pane owner) {
        Object obj = null;
        FileInputStream inStream = null;
        try {
            inStream = new FileInputStream(fileName/* , FileMode.Open */);
            obj = Utils.deserialize(inStream);
        } catch (FileNotFoundException e) {
            if (!ignoreMissingFile) {
                DialogAlert.Alert(AlertType.FileErrorOpen, owner, fileName, e.getMessage());
            }
        } catch (IOException ex) {
            DialogAlert.Alert(AlertType.FileErrorOpen, owner, fileName, ex.getMessage());
        } catch (SerializationException ex) {
            DialogAlert.Alert(AlertType.FileErrorOpen, owner, fileName, Strings.FileFormatBad);
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

    public static String multiples(int num, String unit) {
        return formatNumber(num) + " " + unit + (num == 1 ? "" : "s");
    }

    public static void paintShipImage(Ship ship, Graphics graphics, Color backgroundColor) {
        int x = Constants.ShipImageOffsets[ship.Type().getId()].x;
        int width = Constants.ShipImageOffsets[ship.Type().getId()].width;
        int startDamage = x + width - ship.getHull() * width / ship.HullStrength();
        int startShield = x + width + 2 - (ship.ShieldStrength() > 0 ? ship.ShieldCharge() * (width + 4) / ship.ShieldStrength() : 0);
        graphics.clear(backgroundColor);
        if (startDamage > x) {
            if (startShield > x) {
                drawPartialImage(graphics, ship.ImageDamaged(), x, Math.min(startDamage, startShield));
            }
            if (startShield < startDamage) {
                drawPartialImage(graphics, ship.ImageDamagedWithShields(), startShield, startDamage);
            }
        }
        if (startShield > startDamage) {
            drawPartialImage(graphics, ship.Image(), startDamage, startShield);
        }
        if (startShield < x + width + 2) {
            drawPartialImage(graphics, ship.ImageWithShields(), startShield, x + width + 2);
        }
    }

    private static long rand() {
        final int a = 18000;
        final int b = 30903;
        SeedX = a * (SeedX & MAX_WORD) + (SeedX >> 16);
        SeedY = b * (SeedY & MAX_WORD) + (SeedY >> 16);
        return ((SeedX << 16) + (SeedY & MAX_WORD));
    }

    public static int getRandomSkill() {
        return 1 + getRandom(5) + getRandom(6);
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

    public static boolean saveFile(String fileName, Object toSerialize, Pane owner) {
        System.out.println(fileName);
        FileOutputStream outStream = null;
        boolean saveOk = false;
        try {
            new File(fileName).createNewFile();
            outStream = new FileOutputStream(fileName, false);
            Utils.Serialize(outStream, toSerialize);
            saveOk = true;
        } catch (IOException ex) {
            DialogAlert.Alert(AlertType.FileErrorSave, owner, fileName, ex.getMessage());
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
        int[] wormholes = Game.getCurrentGame().Wormholes();
        int i = Utils.bruteSeek(wormholes, a);
        return (i >= 0 && (b < 0 || wormholes[(i + 1) % wormholes.length] == b));
    }

    public static boolean WormholeExists(StarSystem a, StarSystem b) {
        StarSystem[] universe = Game.getCurrentGame().getUniverse();
        int[] wormholes = Game.getCurrentGame().Wormholes();
        int i = Utils.bruteSeek(wormholes, a.Id().getId());
        return (i >= 0 && (universe[wormholes[(i + 1) % wormholes.length]] == b));
    }
}
