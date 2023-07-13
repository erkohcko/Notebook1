package org.utility;

public class idPart {
    private static int id = 1;

    public static Object randomInt() {
        return id++;
    }

    public int id() {
        return id++;
    }
    public static int getId() {
    return id;
    }

}
