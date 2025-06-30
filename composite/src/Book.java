public class Book implements LibraryItem{
        private String title;
        private String author;
        private boolean available;

        public Book(String title, String author) {
            this.title = title;
            this.author = author;
            this.available = true;
        }

        public void borrow() {
            available = false;
        }

        public void returnBook() {
            available = true;
        }

        public boolean isAvailable() {
            return available;
        }

        public String getTitle() {
            return title;
        }

        @Override
        public void display(String indent) {
            System.out.println(indent + "- " + title + " (" + author + ") [" + (available ? "Dostępna" : "Wypożyczona") + "]");
        }
    }

