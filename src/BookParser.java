import java.util.List;

public interface BookParser {
    List<Book> parse(String filePath) throws Exception;
}
