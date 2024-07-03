package by.tms.calculator.web.handler;

import by.tms.calculator.model.Operation;
import by.tms.calculator.storage.JsonFileOperationStorage;
import com.google.gson.Gson;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.util.List;

public class HistoryCalculatorHttpHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        JsonFileOperationStorage storage = new JsonFileOperationStorage();
        List<Operation> list = storage.findAll();

//        Gson gson = new GsonBuilder()
//                .setPrettyPrinting()
//                .create();

        String json = new Gson().toJson(list);

        exchange.getResponseHeaders().add("Content-Type", "application/json");
        exchange.sendResponseHeaders(200, json.length());
        exchange.getResponseBody().write(json.getBytes());

        exchange.close();
    }
}
