package logic;

import dal.IWeightDAO;

import java.io.IOException;

public interface IController {

    void setDAO(IWeightDAO dao);
    void work() throws IOException;

}
