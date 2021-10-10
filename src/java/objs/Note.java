
package objs;

import java.io.Serializable;

/**
 *
 * @author Connor
 */
public class Note implements Serializable{
    
    private String noteTitle;
    private String noteContent;

    public Note(String noteTitle, String noteContent) {
        this.noteTitle = noteTitle;
        this.noteContent = noteContent;
    }
    
    public Note(){
        this.noteContent = "";
        this.noteTitle = "";
    }
    
    public String getNoteTitle() {
        return noteTitle;
    }

    public String getNoteContent() {
        return noteContent;
    }

    public void setNoteTitle(String noteTitle) {
        this.noteTitle = noteTitle;
    }

    public void setNoteContent(String noteContent) {
        this.noteContent = noteContent;
    }
    
    
    
}
