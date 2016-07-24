package tomer.edu.firedemo.models;

/**
 * Created by stud27 on 20/07/16.
 */
public class Todo {
    private String title;
    private String content;

    public Todo() {
    }



    public Todo(String title, String content) {
        this.title = title;
        this.content = content;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
