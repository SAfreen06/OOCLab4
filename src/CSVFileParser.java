import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVFileParser implements BookParser {
    @Override
    public List<Book> parse(String filePath) throws IOException {
        List<Book> books = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isFirstLine = true;

            while ((line = br.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }


                String[] values = line.split(",");

                if (values.length >= 5) {
                    String title = values[0];
                    String author = values[1];
                    String genre = values[2];
                    int pages=Integer.parseInt(values[3]);
                    String date=values[4];


                    books.add(new Book(title,author,genre,pages,date));
                }
            }
        }

        return books;
    }
}