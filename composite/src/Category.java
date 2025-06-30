import java.util.ArrayList;
import java.util.List;

class Category implements LibraryItem {
    private String name;
    private List<LibraryItem> items;

    public Category(String name) {
        this.name = name;
        this.items = new ArrayList<>();
    }

    public void add(LibraryItem item) {
        items.add(item);
    }

    public void remove(LibraryItem item) {
        items.remove(item);
    }

    @Override
    public void display(String indent) {
        System.out.println(indent + "[Kategoria] " + name);
        for (LibraryItem item : items) {
            item.display(indent + "  ");
        }
    }
}
