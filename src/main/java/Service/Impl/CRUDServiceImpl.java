package Service.Impl;

import Model.Student;
import Service.CRUDService;
import Utils.ReadJson;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CRUDServiceImpl implements CRUDService {
    public void addStudent(String name, String surname, String fatherName, String email, String phoneNumber) throws IOException, ParseException {
        ObjectMapper mapper = new ObjectMapper();

        ReadJson readJson = new ReadJson();
        List<Student> students = readJson.read();
        Integer id = students.size();

        Student student = new Student(id, name, surname, fatherName, email, phoneNumber);


        students.add(student);

        Map<Integer, Object> studentMap = new HashMap<>();
        int counter = 1;
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i) != null) {

                studentMap.put(counter, students.get(i));
                counter++;
            }
        }


        try {
            mapper.writeValue(new File("database.json"), studentMap);
        } catch (Exception e) {
            e.printStackTrace();

        }


    }

    public void updateStudentName(String newName, String oldName) throws IOException, ParseException {
        ObjectMapper mapper = new ObjectMapper();
        ReadJson readJson = new ReadJson();
        List<Student> students = readJson.read();
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getName() == oldName) {
                students.get(i).setName(newName);
            }
        }
        Map<Integer, Object> studentMap = new HashMap<>();
        int counter = 1;
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i) != null) {

                studentMap.put(counter, students.get(i));
                counter++;
            }
        }


        try {
            mapper.writeValue(new File("database.json"), studentMap);
        } catch (Exception e) {
            e.printStackTrace();

        }

    }

    public void updateStudentSurname(String newSurname, String oldSurname) throws IOException, ParseException {
        ObjectMapper mapper = new ObjectMapper();
        ReadJson readJson = new ReadJson();
        List<Student> students = readJson.read();
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getSurname() == oldSurname) {
                students.get(i).setSurname(newSurname);
            }
        }
        Map<Integer, Object> studentMap = new HashMap<>();
        int counter = 1;
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i) != null) {

                studentMap.put(counter, students.get(i));
                counter++;
            }
        }


        try {
            mapper.writeValue(new File("database.json"), studentMap);
        } catch (Exception e) {
            e.printStackTrace();

        }

    }

    public void updateStudentFatherName(String newFatherName, String oldFatherName) throws IOException, ParseException {
        ObjectMapper mapper = new ObjectMapper();
        ReadJson readJson = new ReadJson();
        List<Student> students = readJson.read();
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getFatherName() == oldFatherName) {
                students.get(i).setFatherName(newFatherName);
            }
        }
        Map<Integer, Object> studentMap = new HashMap<>();
        int counter = 1;
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i) != null) {

                studentMap.put(counter, students.get(i));
                counter++;
            }
        }


        try {
            mapper.writeValue(new File("database.json"), studentMap);
        } catch (Exception e) {
            e.printStackTrace();

        }

    }
    public void delete(String name) throws IOException, ParseException {
        ObjectMapper mapper = new ObjectMapper();
        ReadJson readJson = new ReadJson();
        List<Student> students = readJson.read();
        for (int i = 0; i < students.size() - 1; i++) {
            if (students.get(i).getName() == name) {
                students.set(i,students.get(i+1));
            }
        }
        Map<Integer, Object> studentMap = new HashMap<>();
        int counter = 1;
        for (int i = 0; i < students.size()-1; i++) {
            if (students.get(i) != null) {

                studentMap.put(counter, students.get(i));
                counter++;
            }
        }


        try {
            mapper.writeValue(new File("database.json"), studentMap);
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}


