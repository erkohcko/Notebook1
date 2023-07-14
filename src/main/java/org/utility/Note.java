package org.utility;

import java.util.*;

public class Note {
    private int id;
    private  String noteText;
    private  List<String> labels;

    public static final List<Note> noteList = new ArrayList<>();

    public Note(int id, String noteText, List<String> labels) {
        this.id = id;
        this.noteText = noteText;
        this.labels = labels;
    }

    public <T> Note(String s, List<T> asList) {

    }


    public static List<Note> getNoteList() {
        return new ArrayList<>(noteList);
    }

    public int getId() {
        return id;
    }

    public String getNoteText() {
        return noteText;
    }

    public List<String> getLabels() {
        return new ArrayList<>(labels);
    }

    @Override
    public String toString() {
        return id + "# " + noteText + "\n" + labels;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Note note = (Note) o;
        return id == note.id &&
                Objects.equals(noteText, note.noteText) &&
                Objects.equals(labels, note.labels);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, noteText, labels);
    }



    public static boolean remove(Note note) {
        return noteList.remove(note);
    }




}