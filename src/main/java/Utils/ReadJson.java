package Utils;

import Model.Student;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.util.*;

public class ReadJson {
    public List<Student> read() throws IOException, ParseException {
        JsonParser jsonParser = new JsonParser();
        List<Student> list = new ArrayList<>();
        Gson gson = new Gson();
        FileReader reader = new FileReader("database.json");
        while (true) {
            JsonElement jsonElement = jsonParser.parse(reader);


            if (!jsonElement.isJsonNull()) {

                list.add(gson.fromJson(jsonElement, Student.class));
            } else {
                break;
            }
        }
        for (int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }
        reader.close();


return list;
    }
}
