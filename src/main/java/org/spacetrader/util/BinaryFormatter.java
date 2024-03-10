package org.spacetrader.util;

import java.io.*;

// TODO very small class, should maybe be part of something bigger (serialization related)
public class BinaryFormatter {

    public Object Deserialize(FileInputStream inStream) throws SerializationException, IOException {
        try {
            return new ObjectInputStream(inStream).readObject();
        } catch (ClassNotFoundException e) {
            throw new SerializationException(e);
        }
    }

    public void Serialize(FileOutputStream outStream, Object toSerialize) throws IOException {
        new ObjectOutputStream(outStream).writeObject(toSerialize);
    }
}
