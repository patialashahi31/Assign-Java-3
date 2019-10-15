
public class Rooms {
    private int roomNo;
    private int capacity;
    

    public Rooms(int roomNo, int capacity) {
        this.roomNo = roomNo;
        this.capacity = capacity;
    }

    public int getRoomNumber() {
        return roomNo;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNo = roomNo;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
