package org.utility;

import org.utility.exception.NoteException;

public final class Checkout {

    private Checkout() {

    }

    public static boolean checkNoteLabel (String text) throws NoteException {
        return text.matches("^[a-zA-ZА-Яа-яЁё ]*$");
    }

    public static boolean checkNoteTextLength (String text) {
        return text.length() < 3;
    }

    public static int parseInt(String str) {
        int num;
        try {
            num = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return -1;
        }
        return num;
    }
}