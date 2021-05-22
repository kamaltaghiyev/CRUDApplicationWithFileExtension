package Service;

import org.json.simple.parser.ParseException;

import java.io.IOException;

public interface SearchService {
    public void searchByName(String name) throws IOException, ParseException;
    public void searchBySurname(String surname) throws IOException, ParseException;
    public void searchByFatherName(String fatherName) throws IOException, ParseException;
}
