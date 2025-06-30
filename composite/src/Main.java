public class Main {
    public static void main(String[] args) {
        Category root = new Category("Biblioteka");

        Category fantasy = new Category("Fantastyka");
        fantasy.add(new Book("Wiedźmin", "Andrzej Sapkowski"));
        fantasy.add(new Book("Hobbit", "J.R.R. Tolkien"));

        Category drama = new Category("Dramat");
        drama.add(new Book("Lalka", "Bolesław Prus"));

        root.add(fantasy);
        root.add(drama);
        
        root.display("");
    }
}