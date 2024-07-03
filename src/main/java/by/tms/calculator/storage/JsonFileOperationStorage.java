package by.tms.calculator.storage;

import by.tms.calculator.model.Operation;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JsonFileOperationStorage implements OperationStorage {

    private final String FILE_PATH = "src\\main\\java\\org\\example\\hustory.json";
    private final Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .create();

    @Override
    public void save(Operation operation) {
        List<Operation> list = findAll();
        list.add(operation);
        String json = gson.toJson(list);
        //System.out.println(json);

        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            writer.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Operation> findAll() {
        try (Reader reader = new FileReader(FILE_PATH)) {
            BufferedReader bufferedReader = new BufferedReader(reader);
            Stream<String> lines = bufferedReader.lines();
            String json = lines.collect(Collectors.joining("\n"));

//            List<Operation> list = new ArrayList<>();
//            list.add(new Operation(2, 2, "sum", 4));
//            list.add(new Operation(3, 3, "sum", 6));
//            list.add(new Operation(4, 5, "sum", 9));
            //List<Operation> list = gson.fromJson(reader, List.class);

            List<Operation> list = gson.fromJson(json, ArrayList.class);
            return list;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return List.of();
    }
}

//ArrayList<Operation> list = new ArrayList<>();
//        list.add(new Operation(2, 2, "sum", 4));
//        list.add(new Operation(3, 3, "sum", 6));
//        list.add(new Operation(4, 5, "sum", 9));
//String json = new Gson().toJson(list);
//        System.out.println(json);
//
//ArrayList<Operation> listRes = new Gson().fromJson(json, ArrayList.class);
//        System.out.println(listRes.get(2));
