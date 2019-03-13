package main;

import logic.IController;
import logic.SimController;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Main {

    public static void main(String[] args) throws IOException {
        IController controller = new SimController();
        controller.work();
    }

}
