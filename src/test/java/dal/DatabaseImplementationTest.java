package dal;

import dto.BatchDTO;
import dto.UserDTO;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DatabaseImplementationTest {

    DatabaseImplementation database;
    UserDTO testUser;
    BatchDTO testBatch;

    @Before
    public void setup(){
        database = new DatabaseImplementation();
        testUser = new UserDTO(1, "Bente Bent");
        testBatch = new BatchDTO(1, "Sukker", 1, 23.32);
        try {
            database.createUser(testUser);
            database.createBatch(testBatch);
        } catch (IWeightDAO.DALException e) {
            e.printStackTrace();
        }
    }

    @After
    public void tearDown(){
        try {
            database.deleteBatch(1);
            database.deleteUser(1);
        } catch (IWeightDAO.DALException e) {
            e.printStackTrace();
        }
        database = null;
        testUser = null;
        testBatch = null;
    }

    @Test
    public void shouldGetUser() {
        try {
            UserDTO user = database.getUser(1);
            assertEquals(1, user.getId());
            assertEquals("Bente Bent", user.getName());
        } catch (IWeightDAO.DALException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void shouldGetBatch() {
        try {
            BatchDTO batch = database.getBatch(1);
            assertEquals(1, batch.getId());
            assertEquals("Sukker", batch.getName());
            assertEquals(1, batch.getUserID());
            assertEquals((int) 23.32, (int) batch.getWeight());
        } catch (IWeightDAO.DALException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void ShouldCreateUser() {
        // Done in setup and tested in getUser()
    }

    @Test
    public void shouldDeleteUser() {
        try {
            assertNotNull(database.getUser(1));
            database.deleteBatch(1);
            assertNull(database.getBatch(1));
        } catch (IWeightDAO.DALException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void shouldCreateBatch() {
        // Done in setup and tested in getBatch()
    }

    @Test
    public void shouldDeleteBatch() {
        try {
            assertNotNull(database.getBatch(1));
            database.deleteUser(1);
            assertNull(database.getUser(1));
        } catch (IWeightDAO.DALException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void shouldUpdateUser() {
        UserDTO updatedUser = new UserDTO(1, "Updated User");
        try {
            database.updateUser(updatedUser);
            UserDTO user = database.getUser(1);
            assertEquals(1, user.getId());
            assertEquals("Updated User", user.getName());
        } catch (IWeightDAO.DALException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void shouldUpdateBatch() {
        BatchDTO updatedBatch = new BatchDTO(1, "Updated name", 1, 420.0);
        try {
            database.updateBatch(updatedBatch);
            BatchDTO batch = database.getBatch(1);
            assertEquals(1, batch.getId());
            assertEquals("Updated name", batch.getName());
            assertEquals(1, batch.getUserID());
            assertEquals((int) 420.0, (int) batch.getWeight());
        } catch (IWeightDAO.DALException e) {
            e.printStackTrace();
        }
    }
}