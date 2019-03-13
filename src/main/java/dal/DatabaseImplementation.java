package dal;

import java.sql.*;

public class DatabaseImplementation implements IWeightDAO {

    private Connection createConnection() throws SQLException {
        return  DriverManager.getConnection("jdbc:mysql://ec2-52-30-211-3.eu-west-1.compute.amazonaws.com/s185101?"
                + "user=s185101&password=ocWobhGa6mSep6MBVqBa1");
    }

    @Override
    public String getUserName(int userId) throws DALException{

        try (Connection c = createConnection()){
            PreparedStatement statement = c.prepareStatement("SELECT userName FROM Users WHERE userId = ?");
            statement.setInt(1, userId);
            ResultSet rs = statement.executeQuery();
            return rs.getString("userName");

        } catch (SQLException e) {
            throw new DALException(e.getMessage());
        }
    }

    @Override
    public void createUser(int id, String name) throws DALException{

        try (Connection c = createConnection()){
            PreparedStatement statement = c.prepareStatement("INSERT INTO Users(?,?)");
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
    public void createBatch(int batchId, int userId, String batchName, int batchWeight) throws DALException{

        try (Connection c = createConnection()){
            PreparedStatement statement = c.prepareStatement("INSERT INTO Batches (?,?,?,?)");
            statement.setInt(1, batchId);
            statement.setString(2, batchName);
            statement.setInt(3, userId);
            statement.setInt(4, batchWeight);
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
    public void updateUser(int id, String name) throws DALException{

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
    public void updateBatch(int batchId, int userId, String batchName, int batchWeight) throws DALException{

        try (Connection c = createConnection()){
            PreparedStatement statement = c.prepareStatement("UPDATE Batches SET(batchId = ?, batchName = ?, userId = ?, nettoWeight = ?)");
            statement.setInt(1, batchId);
            statement.setString(2, batchName);
            statement.setInt(3, userId);
            statement.setInt(4, batchWeight);
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new DALException(e.getMessage());
        }
    }


}
