package org.example;

import by.tms.calculator.Application;
import by.tms.calculator.console.ConsoleApplication;
import by.tms.calculator.web.WebApplication;


public class App {
    public static void main(String[] args) {
        Application application = new WebApplication();
        application.run();
    }
}
