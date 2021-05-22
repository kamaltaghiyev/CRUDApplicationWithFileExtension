package Utils;

import Model.Student;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

import java.nio.file.Path;
import java.util.*;

public class ReadJson {
    public List<Student> read() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<Map<Integer, Student>> reference = new TypeReference<>() {};
        return List.copyOf(mapper.readValue(Path.of("data.json").toFile(), reference).values());
    }
}
