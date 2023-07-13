package org.command;

import org.utility.exception.NoteException;

import java.util.EnumMap;
import java.util.List;
import java.util.stream.Collectors;

public class CommandMap {

    private static final EnumMap<ListOfCommands, CommandExecutor> mapOfCommands = new EnumMap<>(ListOfCommands.class);

    static {
        mapOfCommands.put(ListOfCommands.EXIT, new CommandExit());
        mapOfCommands.put(ListOfCommands.NOTE_EXPORT, new CommandExport());
        mapOfCommands.put(ListOfCommands.HELP, new CommandHelp());
        mapOfCommands.put(ListOfCommands.NOTE_LIST, new CommandNoteList());
        mapOfCommands.put(ListOfCommands.NOTE_NEW, new CommandNewNote());
        mapOfCommands.put(ListOfCommands.NOTE_REMOVE, new CommandRemove());
    }

    public void executeCommand(String command) throws NoteException {
        if (!isCommandValid(command)) {
            throw new IllegalArgumentException("Недопустимая команда: " + command);
        }
        mapOfCommands.get(ListOfCommands.valueOf(command)).execute();
    }

    private boolean isCommandValid(String command) {
        try {
            ListOfCommands.valueOf(command);
            return true;
        } catch (NullPointerException | IllegalArgumentException e) {
            return false;
        }
    }

    public List<String> getValidCommands() {
        return mapOfCommands.keySet().stream()
                .map(ListOfCommands::toString)
                .collect(Collectors.toList());
    }

}