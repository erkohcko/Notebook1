package org.command;


import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;
import org.utility.Note;

import org.utility.exception.NoteException;
import org.utility.Checkout;



public class CommandRemove implements CommandExecutor {
    private static final Logger LOGGER = Logger.getLogger(CommandRemove.class.getName());

    @Override
    public void execute() throws NoteException {
        LOGGER.fine("Вызвана команда note_remove");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите id удаляемой заметки: ");
        try {
            int id = Checkout.parseInt(scanner.nextLine());
            if (id == -1) {
                throw new NoteException("Было введено не число");
            }
                List<Note> noteList = Note.getNoteList();
                boolean found = false;
                for (int i = 0; i < noteList.size(); i++) {
                    Note note = noteList.get(i);
                    if (note.getId() == id) {
                        found = true;
                        boolean removed = Note.remove(note);
                        if (removed) {
                            System.out.printf("Заметка с id %d удалена\n", id);
                        } else {
                            System.out.printf("Не удалось удалить заметку с id %d\n", id);
                        }
                        break;
                    }
                }
                if (!found) {
                    System.out.printf("Заметка с id %d не найдена\n", id);
                }

        } catch (NoteException e) {
            System.err.println(e.getMessage());
        }
    }
}