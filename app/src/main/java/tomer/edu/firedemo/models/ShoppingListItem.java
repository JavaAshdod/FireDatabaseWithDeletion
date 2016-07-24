package tomer.edu.firedemo.models;

/**
 * Created by stud27 on 24/07/16.
 */
public class ShoppingListItem {
    private String title;

    public ShoppingListItem() {
    }

    public ShoppingListItem(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "ShoppingListItem{" +
                "title='" + title + '\'' +
                '}';
    }
}
