package logic;

import dal.IWeightDAO;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class WeightSim  implements ILogic{
    @Override
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

    @Override
    public void setDAO(IWeightDAO dao) {

    }

    @Override
    public String userAuthorization(int id) {
        return null;
    }

    @Override
    public String enterBatchNumber(int batchNumber) {
        return null;
    }

    @Override
    public int getWeight() {
        return 0;
    }

    @Override
    public boolean validateResult(double netto, double brutto) {
        return false;
    }
}
