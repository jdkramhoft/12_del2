package logic;

import dal.IWeightDAO;

import java.io.IOException;

public interface ILogic {
    static double errorMargin = 0;
    void work() throws IOException;
    void setDAO(IWeightDAO dao);
    String userAuthorization(int id); //returns username to display on scale, 11-99
    String enterBatchNumber(int batchNumber); // returns name corresponding to batchNumber, 1000-9999
    void enterWeight(double weight);
    int getWeight();
    boolean validateResult(double netto, double brutto);
}
