package Service.Impl;

import Model.Student;
import Service.SearchService;
import Utils.ReadJson;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchServiceImpl implements SearchService {
    @Override
    public void searchByName(String name) throws IOException, ParseException {
        ReadJson readJson = new ReadJson();
        HashMap<String, Student> students = readJson.read();
        Set<Map.Entry<String, Student>> entrySet = students.entrySet();

        for (HashMap.Entry<String, Student> data : entrySet) {
            Student student = data.getValue();
            Pattern pName = Pattern.compile(name);
            Matcher mName = pName.matcher(student.getName());
            if (mName.find()) {
                System.out.println(student);

            }
        }
    }

    @Override
    public void searchBySurname(String surname) throws IOException, ParseException {
        ReadJson readJson = new ReadJson();
        HashMap<String, Student> students = readJson.read();
        Set<Map.Entry<String, Student>> entrySet = students.entrySet();

        for (HashMap.Entry<String, Student> data : entrySet) {
            Student student = data.getValue();
            Pattern pSurname = Pattern.compile(surname);
            Matcher mSurname = pSurname.matcher(student.getSurname());
            if (mSurname.find()) {
                System.out.println(student);

            }
        }
    }
    @Override
    public void searchByFatherName(String fatherName) throws IOException, ParseException {
        ReadJson readJson = new ReadJson();
        HashMap<String, Student> students = readJson.read();
        Set<Map.Entry<String, Student>> entrySet = students.entrySet();

        for (HashMap.Entry<String, Student> data : entrySet) {
            Student student = data.getValue();
            Pattern pFatherName = Pattern.compile(fatherName);
            Matcher mFatherName = pFatherName.matcher(student.getSurname());
            if (mFatherName.find()) {
                System.out.println(student);

            }
        }
    }
}
