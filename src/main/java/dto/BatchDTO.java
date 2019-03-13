package dto;

public class BatchDTO {

    private double weight;
    private int userID;
    private String name;
    private int id;

    public BatchDTO(int id, String name, int userID, double weight){
        this.id = id;
        this.name = name;
        this.userID = userID;
        this.weight = weight;
    }

    public BatchDTO(){}


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
}
