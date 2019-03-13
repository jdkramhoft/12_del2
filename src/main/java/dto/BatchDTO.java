package dto;

public class BatchDTO {

    private static final int MIN = 11;
    private static final int MAX = 99;

    private String name;
    private int id;

    public BatchDTO(int id, String name){
        this.id = id;
        this.name = name;
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

    public boolean isValid(){
        boolean idIsValid = (id <= MAX && id >= MIN);
        boolean nameIsValid = (name != null && name.length() > 0);
        return idIsValid && nameIsValid;
    }
}
