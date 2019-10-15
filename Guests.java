
public class Guests {
    private String nameOfGuest;
    private int idOfGuest;

    public Guests(String nameOfGuest, int idOfGuest) {
        this.nameOfGuest = nameOfGuest;
        this.idOfGuest = idOfGuest;
    }
    public int getId() {
        return idOfGuest;
    }

    public String getName() {
        return nameOfGuest;
    }

    public void setName(String guest_name) {
        this.nameOfGuest = nameOfGuest;
    }

    

    public void setId(int idOfGuest) {
        this.idOfGuest = idOfGuest;
    }
}
