package by.tms.calculator.web.handler;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;

public class HelpHttpHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String rule = "localhost:8080/help\nlocalhost:8080/history\nlocalhost:8080/calculate?num1=2&num2=2&type=sum";

        exchange.sendResponseHeaders(200, rule.length());
        exchange.getResponseBody().write(rule.getBytes());

        exchange.close();
    }
}
