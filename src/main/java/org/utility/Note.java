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

    public static boolean add(Note note) {
        if (noteList.contains(note)) {
            return false;
        }
        return noteList.add(note);
    }

    public static boolean remove(Note note) {
        return noteList.remove(note);
    }

    public static boolean removeNoteById(int id) {
        Iterator<Note> iterator = noteList.iterator();
        while (iterator.hasNext()) {
            Note note = iterator.next();
            if (note.getId() == id) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    public void setNoteText(String noteText) {
    }

    public void setLabels(List<String> labels) {
    }

    public void setId(int id) {
    }

    public Note() {
        this(0, "", new ArrayList<>());
    }


    public List<String> getLabel() {
        return labels;
    }
}