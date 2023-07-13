package org.command;



import org.utility.Note;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;



public class
CommandExport implements CommandExecutor {
    private static final Logger LOGGER = Logger.getLogger(CommandExport.class.getName());

    @Override
    public void execute() {
        LOGGER.fine("Вызвана команда note_export");

        String filename = generateFilename();
        try (FileWriter writer = new FileWriter(filename)) {
            for (Note note : Note.getNoteList()) {
                writer.write(note.toString());
                writer.write(System.lineSeparator());
            }
            LOGGER.info("Заметки успешно экспортированы в файл " + filename);
        } catch (IOException e) {
            LOGGER.severe("Не удалось экспортировать заметки: " + e.getMessage());
        }
    }

    private String generateFilename() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd_HH-mm-ss");
        String timestamp = dateFormat.format(new Date());
        return "notes_" + timestamp + ".txt";
    }
}