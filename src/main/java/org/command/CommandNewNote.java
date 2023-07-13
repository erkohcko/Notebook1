package org.command;

import org.utility.Note;
import org.utility.exception.NoteException;
import org.utility.idPart;
import org.utility.Checkout;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

import static org.utility.Checkout.checkNoteLabel;
import static org.utility.Checkout.checkNoteTextLength;
import static org.utility.Note.noteList;

public class CommandNewNote implements CommandExecutor {
    private static final Logger LOGGER = Logger.getLogger(CommandNewNote.class.getName());
    private static final idPart idGenerator = new idPart();

    public void execute() throws NoteException {
        LOGGER.fine("Вызвана команда new_note");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите текст заметки:");
        String noteText = scanner.nextLine().trim();

        if (Checkout.checkNoteTextLength(noteText)) {
            LOGGER.info("Текст заметки должен быть длиннее 3 символов, введено - {" + noteText + "}");
            System.err.println("Введенная заметка не может быть короче трех символов!");
            return;
        }

        System.out.println("Укажите метку, она должна состоять только из букв");
        System.out.println("Можно добавить несколько, слова должны быть разделены пробелом.");
        String labelText = scanner.nextLine().trim().toUpperCase();

        List<String> labels = Arrays.asList(labelText.split(" "));
        for (String label : labels) {
            if (!Checkout.checkNoteLabel(label)) {
                LOGGER.info("Метки должны содержать только буквы, введено - {" + label + "}");
                System.err.println("Метка может содержать только буквы!");
                throw new NoteException("Метки содержат неверные символы");
            }
        }

        Note note = new Note(idGenerator.id(), noteText, labels);

        noteList.add(note);
        System.out.println("Заметка успешно добавлена!");
    }
}