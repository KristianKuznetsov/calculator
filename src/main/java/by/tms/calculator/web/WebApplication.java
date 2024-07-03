package by.tms.calculator.web;

import by.tms.calculator.Application;
import by.tms.calculator.web.handler.CalculatorHttpHandler;
import by.tms.calculator.web.handler.HelpHttpHandler;
import by.tms.calculator.web.handler.HistoryCalculatorHttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class WebApplication implements Application {
    @Override
    public void run() {
        HttpServer httpServer = null;
        try {
            httpServer = HttpServer.create(new InetSocketAddress(8080), 0);
            httpServer.createContext("/help", new HelpHttpHandler());
            httpServer.createContext("/history", new HistoryCalculatorHttpHandler());
            httpServer.createContext("/calculate", new CalculatorHttpHandler());
            httpServer.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
