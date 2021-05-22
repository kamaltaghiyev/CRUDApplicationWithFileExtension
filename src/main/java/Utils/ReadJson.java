package Utils;

import Model.Student;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.lang.reflect.Type;
import java.nio.file.Path;
import java.util.*;

public class ReadJson {
    static Type type = new TypeToken<HashMap<String, Student>>() {
    }.getType();
    public static HashMap<String,Student> read() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("database.json"));
        GsonBuilder gson = new GsonBuilder();
        HashMap<String, Student> map = gson.create().fromJson(reader,type);
        reader.close();
        return map;
    }
}
