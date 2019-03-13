package main;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Main {

    public static void main(String[] args) throws IOException {
        String sentence;
        String modifiedSentence;
        Socket clientSocket;
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader((System.in)));
        clientSocket = new Socket("127.0.0.1", 8000);
        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
        BufferedReader inFromServer = new BufferedReader(new InputStreamReader((clientSocket.getInputStream())));
        do{
            sentence = inFromUser.readLine();
            outToServer.writeBytes(sentence + '\n');
            modifiedSentence = inFromServer.readLine();
            System.out.println("FROM SERVER: " + modifiedSentence);
        } while(!modifiedSentence.equals("Q"));
        clientSocket.close();
    }

}
