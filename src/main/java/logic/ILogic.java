package logic;

import dal.IWeightDAO;
import dto.BatchDTO;
import dto.UserDTO;

import java.io.IOException;
import java.net.Socket;

public interface ILogic {
    final static double ERROR_MARGIN = 0.0001;
    Socket EstablishConnection() throws IOException;
    void setDAO(IWeightDAO dao);
    UserDTO getUser(int id); // 11-99
    BatchDTO enterBatchNumber(int batchNumber); // 1000-9999
    int getWeight();
    boolean validateResult(double netto, double brutto);
}
