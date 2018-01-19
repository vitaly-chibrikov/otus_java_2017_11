package ru.otus.l081.sjson;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

/**
 * Created by tully.
 */
public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse((new FileReader("jsondata.txt")));

        navigateTree(jsonObject, "root");
    }

    @SuppressWarnings("unchecked")
    private static void navigateTree(Object aware, String key) {
        // System.out.println(key + ": " + aware);

        String awareClassName = aware.getClass().getSimpleName();
        switch (awareClassName) {
            case "JSONArray":
                JSONArray array = (JSONArray) aware;
                array.forEach(element -> navigateTree(element, "array_element"));
                break;
            case "JSONObject":
                JSONObject jsonObject = (JSONObject) aware;
                jsonObject.entrySet().forEach(element -> navigateTree(element, "set_element"));
                break;
            case "Node":
                Map.Entry entry = (Map.Entry) aware;
                navigateTree(entry.getValue(), entry.getKey().toString());
                break;
            default:
                System.out.println(key + ": " + aware);

        }
    }
}
