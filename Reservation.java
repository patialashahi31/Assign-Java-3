
public class Reservation {
    private int guestId,roomNo,noOfGuests,checkinDay, checkinMonth,checkoutMonth,checkoutDay, startOfBooking, endOfBooking;

    public Reservation(int guestId, int roomNo, int noOfGuests) {
        this.guestId = guestId;
        this.roomNo = roomNo;
        this.noOfGuests = noOfGuests;
    }

    public int getGuest() {
        return guestId;
    }

    

    public int getRoomNumber() {
        return roomNo;
    }

    

    public int getNumberOfGuests() {
        return noOfGuests;
    }

    public void setNumberOfGuests(int number_of_guests) {
        this.noOfGuests = noOfGuests;
    }

    public int getStartingDay() {
        return checkinDay;
    }

    

    public int getStartingMonth() {
        return checkinMonth;
    }

    

    public int getEndingDay() {
        return checkoutDay;
    }

    

    public int getEndingMonth() {
        return checkoutMonth;
    }

    

    public int getStarting() {
        return startOfBooking;
    }

    

    public int getEnding() {
        return endOfBooking;
    }
    
    public void setStartingDay(int checkinDay) {
        this.checkinDay = checkinDay;
    }
    
    public void setRoomNumber(int roomNo) {
        this.roomNo = roomNo;
    }
    
    public void setStartingMonth(int checkinMonth) {
        this.checkinMonth = checkinMonth;
    }
    
    
    public void setEndingDay(int checkoutDay) {
        this.checkoutDay = checkoutDay;
    }
    
    public void setEndingMonth(int checkoutMonth) {
        this.checkoutMonth = checkoutMonth;
    }
    
    public void setStartOfBooking(int startOfBooking) {
        this.startOfBooking = startOfBooking;
    }

    public void setEndOfBooking(int endOfBooking) {
        this.endOfBooking = endOfBooking;
    }
    public void setGuest(int guestId) {
        this.guestId = guestId;
    }
}
