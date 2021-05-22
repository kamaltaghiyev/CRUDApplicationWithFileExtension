package Service.Impl;

import Model.Student;
import Service.CRUDService;
import Utils.ReadJson;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.GsonBuilder;
import org.json.simple.parser.ParseException;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CRUDServiceImpl implements CRUDService {
    public void addStudent(String name, String surname, String fatherName, String email, String phoneNumber) throws IOException, ParseException {


        ReadJson readJson = new ReadJson();
        HashMap<String,Student> students = new HashMap<>();
        if(readJson.read() != null) {
            students = readJson.read();
        }
        Student student = new Student(name, surname, fatherName, email, phoneNumber);

        students.put(student.getId(), student);
        GsonBuilder gson = new GsonBuilder();
        String json = gson.setPrettyPrinting().create().toJson(students);
        BufferedWriter writer = new BufferedWriter(new FileWriter("database.json"));
        writer.append(json);
        writer.close();

    }




    public void delete(String id) throws IOException, ParseException {
        ReadJson readJson = new ReadJson();
        HashMap<String,Student> students = new HashMap<>();
        if(readJson.read() != null) {
            students = readJson.read();
        }
        if (students.containsKey(id)){
            students.remove(id);
            GsonBuilder gson = new GsonBuilder();
            String json = gson.setPrettyPrinting().create().toJson(students);
            BufferedWriter writer = new BufferedWriter(new FileWriter("database.json"));
            writer.append(json);
            writer.close();
        }else {
            System.out.println("There is not such student id:\n");
        }

    }
}


