package ru.otus.l081.xjson;


import javax.json.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.StringWriter;

/**
 * Created by tully.
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        JsonReader reader = Json.createReader(new FileReader("jsondata.txt"));
        JsonStructure jsonst = reader.read();

        navigateTree(jsonst, "base");

        String jsonData = writeToString((JsonObject) jsonst);
        System.out.println(jsonData);
    }

    private static String writeToString(JsonObject jsonst) {
        StringWriter stWriter = new StringWriter();
        try (JsonWriter jsonWriter = Json.createWriter(stWriter)) {
            jsonWriter.writeObject(jsonst);
        }

        return stWriter.toString();
    }

    private static void navigateTree(JsonValue tree, String key) {
        if (key != null)
            System.out.print("Key " + key + ": ");
        switch (tree.getValueType()) {
            case OBJECT:
                System.out.println("OBJECT");
                JsonObject object = (JsonObject) tree;
                for (String name : object.keySet())
                    navigateTree(object.get(name), name);
                break;
            case ARRAY:
                System.out.println("ARRAY");
                JsonArray array = (JsonArray) tree;
                for (JsonValue val : array)
                    navigateTree(val, null);
                break;
            case STRING:
                JsonString st = (JsonString) tree;
                System.out.println("STRING " + st.getString());
                break;
            case NUMBER:
                JsonNumber num = (JsonNumber) tree;
                System.out.println("NUMBER " + num.toString());
                break;
            case TRUE:
            case FALSE:
            case NULL:
                System.out.println(tree.getValueType().toString());
                break;
        }
    }
}
