package org.command;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter

public enum ListOfCommands {
    HELP  ("Выводит на экран список доступных команд с их описанием"),
    NOTE_NEW ("Cоздать новую заметку"),
    NOTE_LIST ("Выводит все заметки на экран"),
    NOTE_REMOVE ("Удаляет заметку"),
    NOTE_EXPORT ("Сохраняет все заметки в текстовый файл и выводит имя сохраненного файла"),
    EXIT ("Выход из приложения");
    private final String description;

    public String getDescription() {
        return description;
    }

    public static void printCommands() {
        for (ListOfCommands command : ListOfCommands.values()) {
            System.out.println(command.toString().toLowerCase());
        }
    }

    public static void printCommandsAndTitles() {
        for (ListOfCommands command : ListOfCommands.values()) {
            System.out.println(command.toString().toLowerCase() + ": " + command.getDescription());
        }
    }
}