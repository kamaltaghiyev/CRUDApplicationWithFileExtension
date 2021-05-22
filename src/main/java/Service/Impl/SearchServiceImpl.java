package Service.Impl;

import Model.Student;
import Service.SearchService;
import Utils.ReadJson;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchServiceImpl implements SearchService {
    @Override
    public void searchByName(String name) throws IOException, ParseException {
        ReadJson readJson = new ReadJson();
        List<Student> students = readJson.read();
        for (int i=0;i<students.size();i++){
            Pattern p = Pattern.compile(name);
            Matcher m = p.matcher(students.get(i).getName());
            if(m.find()){
                System.out.println(students.get(i));

            }
        }
    }

    @Override
    public void searchBySurname(String surname) throws IOException, ParseException {
        ReadJson readJson = new ReadJson();
        List<Student> students = readJson.read();
        for (int i=0;i<students.size();i++){
            Pattern p = Pattern.compile(surname);
            Matcher m = p.matcher(students.get(i).getSurname());
            if(m.find()){
                System.out.println(students.get(i));
            }
        }
    }

    @Override
    public void searchByFatherName(String fatherName) throws IOException, ParseException {
        ReadJson readJson = new ReadJson();
        List<Student> students = readJson.read();
        for (int i=0;i<students.size();i++){
            Pattern p = Pattern.compile(fatherName);
            Matcher m = p.matcher(students.get(i).getFatherName());
            if(m.find()){
                System.out.println(students.get(i));
            }
        }
    }
}
