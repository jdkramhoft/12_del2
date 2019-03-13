package logic;

import dal.DatabaseImplementation;
import dal.IWeightDAO;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class WeightSim  implements ILogic{
    DatabaseImplementation DBConnection = new DatabaseImplementation();

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
        String returnMsg="";
        if(id > 10 && id < 100){
            String name=""; //= DBConnection."getUserName";
            //replace true with check for found id
            if(true){
                returnMsg = name;
            }
            else{
             return returnMsg = "User not found";
            }

        }else{
            returnMsg = "Please insert userid between 11-99";
            return returnMsg;
        }
        return returnMsg;
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
        return (Math.abs(netto/brutto - 1) <= ERROR_MARGIN);
    }
}
