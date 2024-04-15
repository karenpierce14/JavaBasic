package controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class JsonManager {

    private final Gson gson;

    public JsonManager() {
        this.gson = new GsonBuilder().setPrettyPrinting().create();
    }

    public void writeToJson(Object object, String fileName) throws IOException {
        try (FileWriter writer = new FileWriter(fileName)) {
            gson.toJson(object, writer);
        }
    }

    public <T> T readFromJson(String fileName, Class<T> type) throws IOException {
        try (FileReader reader = new FileReader(fileName)) {
            return gson.fromJson(reader, type);
        }
    }
}