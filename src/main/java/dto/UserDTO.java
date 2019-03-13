package dto;

public class UserDTO {

    private static final int MIN = 1111;
    private static final int MAX = 9999;

    private int id;
    private String name;

    public UserDTO(int id, String name){
        this.id = id;
        this.name = name;
    }

    public UserDTO(){
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isValid(){
        boolean idIsValid = (id <= MAX && id >= MIN);
        boolean nameIsValid = (name != null && name.length() > 0);
        return idIsValid && nameIsValid;
    }

}
