package dal;

import dto.BatchDTO;
import dto.UserDTO;
import org.junit.Test;

import static org.junit.Assert.*;

public class DatabaseImplementationTest {

    DatabaseImplementation Database = new DatabaseImplementation();
    UserDTO testUser = new UserDTO(1, "Bente Bent");
    BatchDTO testBatch = new BatchDTO(1, "Sukker", 1, 23.32);

    @Test
    public void shouldGetUser() {

    }

    @Test
    public void shouldGetBatch() {
    }

    @Test
    public void ShouldCreateUser() {
    }

    @Test
    public void shouldDeleteUser() {
    }

    @Test
    public void shouldCreateBatch() {
    }

    @Test
    public void shouldDeleteBatch() {
    }

    @Test
    public void shouldUpdateUser() {
    }

    @Test
    public void shouldUpdateBatch() {
    }
}