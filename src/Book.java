public class Book {
   private String title;
   private String author;
   private String genre;
   private int pages;
   private String date_read;

    public Book(String title, String author, String genre, int pages, String date_read) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.pages = pages;
        this.date_read = date_read;
    }

    public Book(){}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getDate_read() {
        return date_read;
    }

    public void setDate_read(String date_read) {
        this.date_read = date_read;
    }
}
