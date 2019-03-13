package main;

import logic.ILogic;
import logic.Logic;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        ILogic controller = new Logic();
        controller.work();
    }

}
