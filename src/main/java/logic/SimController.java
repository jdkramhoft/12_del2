package logic;

import dal.IWeightDAO;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class SimController implements IController {

    private IWeightDAO dao;

    @Override
    public void setDAO(IWeightDAO dao) {
        this.dao = dao;
    }

    public void work() throws IOException {
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
        } while(!sentence.equals("Q crlf"));
        clientSocket.close();
    }



}
