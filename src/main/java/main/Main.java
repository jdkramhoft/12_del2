package main;

import logic.ILogic;
import logic.WeightSim;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        ILogic controller = new WeightSim();
        controller.work();
    }

}
