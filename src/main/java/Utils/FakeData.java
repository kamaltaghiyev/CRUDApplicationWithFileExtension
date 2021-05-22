package Utils;

import Model.Student;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.github.javafaker.Faker;

import java.io.File;
import java.io.IOException;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

public class FakeData {
    public static int id = 1000;

    public static void main(String[] args) throws IOException {

        Faker faker = new Faker(Locale.ENGLISH);

        Map<Integer, Student> students = new TreeMap<>();
        for (int i = 0; i < 20; i++) {
            Student student = new Student(
                    id++,
                    faker.name().firstName(),
                    faker.name().lastName(),
                    faker.name().firstName(),
                    faker.internet().safeEmailAddress(),
                    faker.regexify("\\+994(50|51|55|70|77|99)[1-9]\\d{6}")
            );
            students.put(student.getId(), student);
        }

        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writerWithDefaultPrettyPrinter();
        writer.writeValue(new File("data.json"), students);
    }
}
