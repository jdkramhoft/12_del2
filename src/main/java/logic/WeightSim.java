package logic;

import dal.DatabaseImplementation;
import dal.IWeightDAO;
import dto.BatchDTO;
import dto.UserDTO;

import java.io.IOException;
import java.net.Socket;

public class WeightSim implements ILogic{
    DatabaseImplementation DBConnection = new DatabaseImplementation();

    @Override
    public Socket EstablishConnection() throws IOException {
        Socket clientSocket;
        clientSocket = new Socket("127.0.0.1", 8000);
        return clientSocket;
    }

    @Override
    public void setDAO(IWeightDAO dao) {

    }

    @Override
    public UserDTO getUser(int id) {
        // UserDTO userDTO = getUser(id); //null if user not found in DB
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
    public BatchDTO enterBatchNumber(int batchNumber) {
        //BatchDTO batchDTO = getBatch(batchNumber); //null if batch not found in DB
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
