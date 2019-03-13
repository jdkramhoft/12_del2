package logic;

import dal.IWeightDAO;

import java.io.IOException;
import java.net.Socket;

public interface ILogic {
    final static double ERROR_MARGIN = 0.0001;
    Socket EstablishConnection() throws IOException;
    void setDAO(IWeightDAO dao);
    String userAuthorization(int id); //returns username to display on scale, 11-99
    String enterBatchNumber(int batchNumber); // returns name corresponding to batchNumber, 1000-9999
    int getWeight();
    boolean validateResult(double netto, double brutto);
}
