import java.util.List;
import java.util.ArrayList;

public class QuotedFieldParser {
    public static List<String> parseQuotedLine(String line) {
        List<String> fields = new ArrayList<>();
        boolean inQuotes = false;
        StringBuilder currentField = new StringBuilder();

        for (char c : line.toCharArray()) {
            switch (c) {
                case '"':
                    inQuotes =!inQuotes;
                    break;
                case ',':
                    if (!inQuotes) {
                        fields.add(currentField.toString().trim());
                        currentField = new StringBuilder();
                    } else {
                        currentField.append(c);
                    }
                    break;
                default:
                    currentField.append(c);
            }
        }
        fields.add(currentField.toString().trim());
        return fields;
    }
}