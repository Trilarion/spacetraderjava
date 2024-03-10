package org.spacetrader.controller;

import org.spacetrader.controller.enums.SpaceTraderEnum;
import org.spacetrader.model.ship.equipment.Gadget;
import org.spacetrader.model.ship.equipment.Shield;
import org.spacetrader.model.ship.equipment.Weapon;
import java.util.ArrayList;
import org.spacetrader.util.DWIM;
import java.util.Hashtable;

// TODO part of io?
abstract public class SerializableObject {

    public SerializableObject() {
    }

    public SerializableObject(Hashtable hash) {
    }

    /**
     * Types currentrently supported:<ul>
     * <li>CrewMember</li>
     * <li>Gadget</li>
     * <li>HighScoreRecord</li>
     * <li>Shield</li>
     * <li>StarSystem</li>
     * <li>Weapon</li>
     * </ul>
     * If an array of a type not listed is converted using {@link #ArrayToArrayList(SerializableObject[]) ArrayToArrayList},
     * the type needs to be added here.
     */
    public static SerializableObject[] ArrayListToArray(ArrayList<Hashtable> list, String typeName) {
        SerializableObject[] array = null;
        SupportedTypesOfSomethingST type = SupportedTypesOfSomethingST.valueOf(typeName);
        if (list == null) {
            return null;
        }
        switch (type) {
            case CrewMember:
                array = new CrewMember[list.size()];
                break;
            case Gadget:
                array = new Gadget[list.size()];
                break;
            case HighScoreRecord:
                array = new HighScoreRecord[list.size()];
                break;
            case Shield:
                array = new Shield[list.size()];
                break;
            case StarSystem:
                array = new StarSystem[list.size()];
                break;
            case Weapon:
                array = new Weapon[list.size()];
                break;
            default:
                throw new RuntimeException("Unknown SuppType: " + type);
        }
        for (int index = 0; index < list.size(); index++) {
            Hashtable hash = list.get(index);
            SerializableObject obj;
            if (hash == null) {
                obj = null;
            } else {
                switch (type) {
                    case CrewMember:
                        obj = new CrewMember(hash);
                        break;
                    case Gadget:
                        obj = new Gadget(hash);
                        break;
                    case HighScoreRecord:
                        obj = new HighScoreRecord(hash);
                        break;
                    case Shield:
                        obj = new Shield(hash);
                        break;
                    case StarSystem:
                        obj = new StarSystem(hash);
                        break;
                    case Weapon:
                        obj = new Weapon(hash);
                        break;
                    default:
                        throw new RuntimeException("Unknown SuppType: " + type);
                }
            }
            array[index] = obj;
        }
        return array;
    }

    public static Integer[] ArrayListToIntArray(ArrayList<? extends SpaceTraderEnum> list) {
        Integer[] array = new Integer[list.size()];
        if (list.isEmpty()) {
            return array;
        }
        {
            // Sometimes weird stuff happens when you mess with casts & generics.
            if ((Object) list.get(0) instanceof Integer) {
                return list.toArray(array);
            }
        }
        for (int index = 0; index < array.length; index++) {
            array[index] = list.get(index).CastToInt();
        }
        return array;
    }

    public static ArrayList<Hashtable> ArrayToArrayList(SerializableObject[] array) {
        ArrayList<Hashtable> list = null;
        if (array != null) {
            list = new ArrayList<>();
            for (SerializableObject obj : array) {
                list.add(obj == null ? null : obj.Serialize());
            }
        }
        return list;
    }

    // TODO is this a good way? lots of casting, what about more direct ways instead?
    public static <U> U GetValueFromHash(Hashtable hash, String key, Class<U> requestedType) {
        if (!hash.containsKey(key)) {
            return null;
        }
        Object object = hash.get(key);
        if (object instanceof SpaceTraderEnum) {
            return (U) (Integer) ((SpaceTraderEnum) object).CastToInt();
        } else {
            return (U) object;
        }
    }


    public static <T> T GetValueFromHash(Hashtable hash, String key, T defaultValue) {
        return GetValueFromHash(hash, key, defaultValue, (Class<T>) defaultValue.getClass());
    }


    public static <U, T extends U> U GetValueFromHash(Hashtable hash, String key, T defaultValue, Class<U> requstedType) {
        if (!hash.containsKey(key)) {
            return defaultValue;
        }
        if (SpaceTraderEnum.class.isAssignableFrom(requstedType)) {
            return (U) DWIM.dwim(hash.get(key), (Class<? extends SpaceTraderEnum>) requstedType);
        } else {
            return (U) hash.get(key);
        }
    }

    public static int GetValueFromHash(Hashtable hash, String key, SpaceTraderEnum defaultValue, Class<Integer> requstedType) {
        //TODO many of calls to this method then cast it back to the enum type; fix them to call generic form.
        if (!hash.containsKey(key)) {
            return defaultValue.CastToInt();
        }
        Object saved = hash.get(key);
        if (saved instanceof Integer) {
            return (Integer) saved;
        } else { //Assume its the enum
            return ((SpaceTraderEnum) saved).CastToInt();
        }
    }

    public static int GetValueFromHash(Hashtable hash, String key, int defaultValue) {
        return hash.containsKey(key) ? (Integer) hash.get(key) : defaultValue;
    }

    public static boolean GetValueFromHash(Hashtable hash, String key, boolean defaultValue) {
        return hash.containsKey(key) ? (Boolean) hash.get(key) : defaultValue;
    }

    public Hashtable Serialize() {
        return new Hashtable();
    }

    private enum SupportedTypesOfSomethingST {
        CrewMember,
        Gadget,
        HighScoreRecord,
        Shield,
        StarSystem,
        Weapon
    }
}
