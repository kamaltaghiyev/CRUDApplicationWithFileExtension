package Service;

import org.json.JSONException;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public interface CRUDService {
    public void addStudent(String name, String surname, String fatherName, String email, String phoneNumber) throws IOException, JSONException, ParseException;
}
