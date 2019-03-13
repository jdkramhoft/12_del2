package logic;

import dal.IWeightDAO;
import dto.BatchDTO;
import dto.UserDTO;

import java.io.IOException;
import java.net.Socket;

public class WeightSim implements ILogic{
    IWeightDAO dao;

    @Override
    public Socket EstablishConnection() throws IOException {
        Socket clientSocket;
        clientSocket = new Socket("127.0.0.1", 8000);
        return clientSocket;
    }

    @Override
    public void setDAO(IWeightDAO dao) {
        this.dao = dao;
    }

    @Override
    public UserDTO getUser(int id) {
        UserDTO user = dao.getUser(id); //null if user not found in DB

        return user;
    }

    @Override
    public BatchDTO enterBatchNumber(int batchNumber) {
        BatchDTO batch = dao.getBatch(batchNumber); //null if batch not found in DB
        return batch;
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
