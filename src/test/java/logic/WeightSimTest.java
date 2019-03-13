package logic;

import dal.DatabaseImplementation;
import dal.IWeightDAO;
import dto.BatchDTO;
import dto.UserDTO;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.Socket;

import static org.junit.Assert.*;

public class WeightSimTest {

    private static final int invalidBatchID = -1;
    private static final int invalidUserID = -1;

    private ILogic sim;
    private IWeightDAO dao;
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

    @Test
    public void shouldGetUser(){
        UserDTO user = sim.getUser(operator.getId());
        assertEquals(operator, user);
    }

    @Test
    public void shouldReturnNullUser() {
        UserDTO user = sim.getUser(invalidUserID);
        assertNull(user);
    }

    @Test
    public void shouldEstablishConnection() throws IOException {
        try(Socket socket = sim.EstablishConnection()){
            assertNotNull(socket);
        }
    }

    @Test
    public void shouldGetBatch(){
        BatchDTO receivedBatch = sim.enterBatchNumber(batch.getId());
        assertEquals(batch, receivedBatch);
    }

    @Test
    public void shouldReturnNullBatch(){
        BatchDTO receivedBatch = sim.enterBatchNumber(batch.getId());
        assertNull(receivedBatch);
    }

    //TODO: MORE!

}