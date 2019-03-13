package logic;

import dal.IWeightDAO;

public class Controller implements IController {

    private IWeightDAO dao;

    @Override
    public void setDAO(IWeightDAO dao) {
        this.dao = dao;
    }
}
