import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JSONFileParser implements BookParser{
    public List<Book> parse(String filePath) throws IOException {
        List<Book> books = new ArrayList<>();

        // Initialize Jackson's ObjectMapper
        ObjectMapper objectMapper = new ObjectMapper();
        // Parse JSON into a JsonNode
        JsonNode rootNode = objectMapper.readTree(new File(filePath));

        // Iterate over the JSON array
        for (JsonNode node : rootNode) {
            Book book = new Book();
            book.setTitle(node.get("title").asText());
            book.setAuthor(node.get("author").asText());
            book.setGenre(node.get("genre").asText());
            book.setPages(node.get("pages").asInt());
            book.setDate_read(node.get("date_read").asText());

            books.add(book);
        }

        return books;
    }
}


