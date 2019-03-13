package dal;

import dto.BatchDTO;
import dto.UserDTO;

import java.sql.*;

public class DatabaseImplementation implements IWeightDAO {

    private Connection createConnection() throws SQLException {
        return  DriverManager.getConnection("jdbc:mysql://ec2-52-30-211-3.eu-west-1.compute.amazonaws.com/s185101?"
                + "user=s185101&password=ocWobhGa6mSep6MBVqBa1");
    }

    @Override
    public UserDTO getUser(int userId) throws DALException{

        try (Connection c = createConnection()){
            PreparedStatement statement = c.prepareStatement("SELECT * FROM Users WHERE userId = ?");
            statement.setInt(1, userId);
            ResultSet rs = statement.executeQuery();
            UserDTO user = new UserDTO(rs.getInt("userId"), rs.getString("userName"));
            return user;

        } catch (SQLException e) {
            throw new DALException(e.getMessage());
        }
    }

    @Override
    public BatchDTO getBatch(int id) throws DALException{

        try (Connection c = createConnection()){
            PreparedStatement statement = c.prepareStatement("SELECT * FROM Batches WHERE batchId = ?");
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            BatchDTO batch = new BatchDTO(rs.getInt("batchId"), rs.getString("batchName"), rs.getInt("userId"), rs.getDouble("nettoWeight"));
            return batch;

        } catch (SQLException e) {
            throw new DALException(e.getMessage());
        }

    }

    @Override
    public void createUser(UserDTO user) throws DALException{

        int id = user.getId();
        String name = user.getName();

        try (Connection c = createConnection()){
            PreparedStatement statement = c.prepareStatement("INSERT INTO Users(userId,userName) VALUES (?,?)");
            statement.setInt(1, id);
            statement.setString(2, name);
            statement.executeQuery();

        } catch (SQLException e) {
            throw new DALException(e.getMessage());
        }
    }

    @Override
    public void deleteUser(int id) throws DALException{

        try (Connection c = createConnection()){
            PreparedStatement statement = c.prepareStatement("DELETE * FROM Users WHERE userId = ?");
            statement.setInt(1, id);
            statement.executeQuery();

        } catch (SQLException e) {
            throw new DALException(e.getMessage());
        }

    }

    @Override
    public void createBatch(BatchDTO batch) throws DALException{

        int batchId = batch.getId();
        String batchName = batch.getName();
        int userId = batch.getUserID();
        double batchWeight = batch.getWeight();

        try (Connection c = createConnection()){
            PreparedStatement statement = c.prepareStatement("INSERT INTO Batches (batchId, batchName, userId, batchWeight) VALUES (?,?,?,?)");
            statement.setInt(1, batchId);
            statement.setString(2, batchName);
            statement.setInt(3, userId);
            statement.setDouble(4, batchWeight);
            statement.executeQuery();

        } catch (SQLException e) {
            throw new DALException(e.getMessage());
        }
    }

    @Override
    public void deleteBatch(int id) throws DALException{

        try (Connection c = createConnection()){
            PreparedStatement statement = c.prepareStatement("DELETE * FROM Batches WHERE batchId = ?");
            statement.setInt(1, id);
            statement.executeQuery();

        } catch (SQLException e) {
            throw new DALException(e.getMessage());
        }

    }

    @Override
    public void updateUser(UserDTO user) throws DALException{

        int id = user.getId();
        String name = user.getName();

        try (Connection c = createConnection()){
            PreparedStatement statement = c.prepareStatement("UPDATE Users SET (userId = ?, userName = ?)");
            statement.setInt(1, id);
            statement.setString(2, name);
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new DALException(e.getMessage());
        }
    }

    @Override
    public void updateBatch(BatchDTO batch) throws DALException{

        int batchId = batch.getId();
        String batchName = batch.getName();
        int userId = batch.getUserID();
        double batchWeight = batch.getWeight();

        try (Connection c = createConnection()){
            PreparedStatement statement = c.prepareStatement("UPDATE Batches SET (batchId = ?, batchName = ?, userId = ?, nettoWeight = ?)");
            statement.setInt(1, batchId);
            statement.setString(2, batchName);
            statement.setInt(3, userId);
            statement.setDouble(4, batchWeight);
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new DALException(e.getMessage());
        }
    }


}
