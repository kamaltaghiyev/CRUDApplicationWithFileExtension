import Service.Impl.ConsoleServiceImpl;
import org.json.JSONException;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, JSONException, ParseException {
        ConsoleServiceImpl consoleService = new ConsoleServiceImpl();
        consoleService.GUI();
    }
}
