package org.command;

import java.util.logging.Logger;
import org.utility.exception.NoteException;


public class CommandHelp implements CommandExecutor {
    private static final Logger LOGGER = Logger.getLogger(CommandHelp.class.getName());

    @Override
    public void execute() throws NoteException {
        LOGGER.fine("Вызвана команда help");
        ListOfCommands.printCommandsAndTitles();
    }
}