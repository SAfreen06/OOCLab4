import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

// XMLFileParser class that implements BookParser
class XMLFileParser implements BookParser {

    // Method to parse the XML file and return a list of books
    @Override
    public List<Book> parse(String filePath) throws Exception {
        List<Book> books = new ArrayList<>();

        // Initialize DocumentBuilderFactory and DocumentBuilder
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        // Parse the XML file and get the document
        Document document = builder.parse(new File(filePath));

        // Normalize the XML structure
        document.getDocumentElement().normalize();

        // Get a list of all <book> nodes
        NodeList bookNodes = document.getElementsByTagName("book");

        // Iterate over each <book> node
        for (int i = 0; i < bookNodes.getLength(); i++) {
            Node bookNode = bookNodes.item(i);

            if (bookNode.getNodeType() == Node.ELEMENT_NODE) {
                Element bookElement = (Element) bookNode;

                // Create a new Book object and set its fields
                Book book = new Book();
                book.setTitle(getTagValue("title", bookElement));
                book.setAuthor(getTagValue("author", bookElement));
                book.setGenre(getTagValue("genre", bookElement));
                book.setPages(Integer.parseInt(getTagValue("pages", bookElement)));
                book.setDate_read(getTagValue("date_read", bookElement));

                books.add(book); // Add the book to the list
            }
        }

        return books;
    }

    // Helper method to get the text content of a specific XML tag
    private String getTagValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = nodeList.item(0);
        return node.getNodeValue();
    }
}

