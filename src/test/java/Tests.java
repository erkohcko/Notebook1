import org.apache.commons.lang3.StringUtils;
import org.command.CommandRemove;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.utility.Checkout;
import org.utility.Note;
import org.utility.exception.NoteException;
import org.command.CommandExecutor;
import org.command.CommandNewNote;
import org.utility.idPart;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class Notebook {

    @Test
    @DisplayName("Выброс исключения NoteException при создании заметки с невалидными метками")
    void shouldThrowNoteExceptionWhenNoteLabelsAreNotValid() {
        List<String> labels = Arrays.asList("метка1", "метка2", "1неверная_метка");
        ByteArrayInputStream in = new ByteArrayInputStream(("Текст заметки" + "\n" + StringUtils.join(labels, " ") + "\n").getBytes());
        System.setIn(in);

        CommandExecutor commandNewNote = new CommandNewNote();
        assertThrows(NoteException.class, commandNewNote::execute);
    }
    @Test
    @DisplayName ("Цифры используются в заметках")
    void digitsCouldBeUsedInNote() {
        String q = "qweqwe123";
        assertFalse(Checkout.checkNoteTextLength(q));
    }
    @Test
    @DisplayName ("В заметках не может быть меньше 3 букв")
    void noteCannotHaveLessThanThreeLetters() {
        String q = "qw";
        assertTrue(Checkout.checkNoteTextLength(q));
    }
    @Test
    @DisplayName ("Метки не содержут цифры")
    void labelsCannotHaveDigits() throws NoteException {
        String q = "wq12";
        assertFalse(Checkout.checkNoteLabel(q));
    }
    @Test
    @DisplayName ("Неправильная метка не добавляется")
    void IncorrectLabelCannotBeApplyed() {
        CommandExecutor testCommand = new CommandNewNote();
        List <String> labels = Arrays.asList("парень", "2131");
        try{
            ByteArrayInputStream in = new ByteArrayInputStream(("Я текст заметки" + "\n" + StringUtils.join(labels," ") + "\n").getBytes());
            System.setIn(in);
        } catch (Exception e) {
            assertThrows(NoteException.class, testCommand::execute);
            assertEquals("Метка может содержать только буквы!", e.getMessage());
        }
    }
    @Test
    @DisplayName ("Корректно заполненная заметка добавляется")
    void correctlyFilledNoteAdded() throws NoteException {
        CommandExecutor testCommand = new CommandNewNote();
        String w = "Я устал это делать";
        List <String> labels = Arrays.asList("хнык", "хнык");
        ByteArrayInputStream in = new ByteArrayInputStream(("я устал это делать" + "\n" + StringUtils.join(labels," ") + "\n").getBytes());
        System.setIn(in);
        testCommand.execute();
        assertEquals(1, Note.noteList.size());
        assertEquals("я устал это делать", Note.noteList.get(0).getNoteText());
    }
    @Test
    @DisplayName ("Заметкам присваивается уникальный id")
    void everyNoteHasUniqueId() {
        int id = idPart.getId();
        assertEquals(id++, idPart.randomInt());
        assertEquals(id++, idPart.randomInt());
        assertEquals(id++, idPart.randomInt());
        assertEquals(id++, idPart.randomInt());
        assertEquals(id++, idPart.randomInt());
        assertEquals(id++, idPart.randomInt());
        assertEquals(id++, idPart.randomInt());

    }
    @Test
    @DisplayName("Удаление заметки по идентификатору")
    void testNoteRemovalById() throws NoteException {
        List<Note> noteList = new ArrayList<>();
        Note note = new Note("12313", Arrays.asList("что", "я", "делаю"));
        noteList.add(note);
        String idToDelete = "12313";
        ByteArrayInputStream in = new ByteArrayInputStream((idToDelete + "\n").getBytes());
        System.setIn(in);
        CommandExecutor command = new CommandRemove();
        command.execute();
        assertFalse (noteList.isEmpty(), "Заметка не была удалена из списка");
    }


}