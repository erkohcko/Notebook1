package org.command;


import org.utility.exception.NoteException;

public interface CommandExecutor {
    void execute() throws NoteException;


}
