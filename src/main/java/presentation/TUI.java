package presentation;

import logic.ILogic;
import logic.WeightSim;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class TUI implements IPresentation {

    private ILogic controller;

    @Override
    public void setController(ILogic controller) {
        this.controller = controller;
    }

    public  void MichaelTouchedmarinastui() throws IOException {
        Socket clientSocket=null;
        String sentence;
        String modifiedSentence;
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader((System.in)));
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
