package logic;

import dal.DatabaseImplementation;
import dal.IWeightDAO;
import dto.BatchDTO;
import dto.UserDTO;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class WeightSimTest {

    private ILogic sim;
    private IWeightDAO dao;
    private int invalidID = 1;
    private BatchDTO batch;
    private UserDTO operator;

    @Before
    public void setUp(){
        this.dao = new DatabaseImplementation();
        this.sim = new WeightSim();
        sim.setDAO(dao);

        //Hardcoded operator
        operator = new UserDTO(12, "Anders And");

        //Hardcoded batchID and name
        this.batch = new BatchDTO();
        batch.setId(1234);
        batch.setName("Salt");
    }

    @After
    public void tearDown(){
        this.dao = null;
        this.sim = null;
        this.batch = null;
        this.operator = null;
    }
/*
    @Test
    public void shouldGetUser(){
        UserDTO user = sim.userAuthorization(operator.getId());
        assertEquals(operator, user);
    }

    @Test
    public void shouldReturnNull(){
        UserDTO user = sim.userAuthorization(invalidID);
        assertNull(user);
    }
*/


}