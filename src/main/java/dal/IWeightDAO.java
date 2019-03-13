package dal;

public interface IWeightDAO {

    String getUserName(int userId) throws DALException;
    void createUser(int id, String name) throws DALException;
    void deleteUser(int id) throws DALException;
    void createBatch(int batchId, int userId, String batchName, int batchWeight) throws DALException;
    void deleteBatch(int id) throws DALException;
    void updateUser(int id, String name) throws DALException;
    void updateBatch(int batchId, int userId, String batchName, int batchWeight)throws DALException;

    public class DALException extends Exception {

        private static final long serialVersionUID = 7355418246336739229L;

        public DALException(String msg, Throwable e) {
            super(msg,e);
        }

        public DALException(String msg) {
            super(msg);
        }

    }
}
