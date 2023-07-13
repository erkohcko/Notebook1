package org.command;

import java.util.logging.Logger;


public class CommandExit implements CommandExecutor {
    public static final Logger LOGGER = Logger.getLogger(CommandExit.class.getName());


    @Override
    public void execute() {
        LOGGER.fine("Вызвана команда exit");
        System.exit(0);

    }
}

