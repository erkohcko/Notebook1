package org.utility;

import org.command.CommandMap;
import org.command.ListOfCommands;
import org.utility.exception.NoteException;

import java.util.Scanner;

public class ConsoleReady {

    public static void consoleReady() throws NoteException {
        System.out.println("Список доступных команд:");
        ListOfCommands.printCommands();
        Scanner scanner = new Scanner(System.in);
        String userCommand = null;
        CommandMap map = new CommandMap();
        while (true) {
            System.out.println("Введите команду:");
            userCommand = scanner.nextLine().toUpperCase().trim();
            map.executeCommand(userCommand);
        }
    }
}

