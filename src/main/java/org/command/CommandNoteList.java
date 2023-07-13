package org.command;

import org.utility.Note;
import org.utility.exception.NoteException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

public class CommandNoteList implements CommandExecutor {

    private static final Logger LOGGER = Logger.getLogger(CommandNoteList.class.getName());

    @Override
    public void execute() throws NoteException {
        LOGGER.fine("Вызвана команда note_list");

        System.out.println("Введите метки, чтобы отобразить определенные заметки или оставьте пустым для отображения всех заметок.");

        Scanner sc = new Scanner(System.in);
        String userInput = sc.nextLine().toUpperCase().trim();

        List<Note> notesToShow;
        if (!userInput.isBlank()) {
            try {
                String[] arrStringInput = userInput.split(" ");
                notesToShow = findNoteByLabels(arrStringInput);
                if (notesToShow.isEmpty()) {
                    throw new NoteException("Заметки не найдены.");
                }
            } catch (NoteException e) {
                LOGGER.warning("Произошла ошибка при выполнении команды note_list: " + e.getMessage());
                System.err.println(e.getMessage());
                return;
            }
        } else {
            notesToShow = Note.noteList;
        }

        printNotes(notesToShow);
    }

    private void printNotes(List<Note> list) {
        for (Note note : list) {
            System.out.println(note);
        }
    }

    private List<Note> findNoteByLabels(String[] input) {
        List<Note> list = new ArrayList<>();
        for (String everyLabel : input) {
            for (Note note : Note.noteList) {
                if (note.getLabels().contains(everyLabel)) {
                    list.add(note);
                }
            }
        }
        return list;
    }
}