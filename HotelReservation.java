
import java.util.ArrayList;
import java.util.Scanner;


public class HotelReservation {
    Scanner scan;
    //ArrayList<Integer> startofbooking = new ArrayList<Integer>();
    //ArrayList<Integer> endofbooking = new ArrayList<Integer>();
    ArrayList<Guests> guests = new ArrayList<Guests>();
    ArrayList<Rooms> rooms = new ArrayList<Rooms>();
    ArrayList<Reservation> reservations = new ArrayList<Reservation>();
    ArrayList<Integer> roomNumbers = new ArrayList<Integer>();
    
    HotelReservation(){
        scan = new Scanner(System.in);
        menuOfHotel();
    }    
    public static void main(String[] args) {
        HotelReservation book = new HotelReservation();
    }
    
    void menuOfHotel(){
        System.out.println("Welcome to FedUni Hotel");
        System.out.println("");
        System.out.println("Main Menu - please select an option:");
        System.out.println("");
        System.out.println("1. Add Guest");
        System.out.println("2. Add Room");
        System.out.println("3. Add Booking");
        System.out.println("4. View Bookings");
        System.out.println("5. Quit");
        System.out.print("Enter Choice: ");
        int ans = scan.nextInt();
        scan.nextLine();
        switch(ans){
            case 1 : AddingGuest();
                     break;
            case 2 : AddingRoom();
                     break;
            case 3 : AddingReservation();
                     break;
            case 4 : ViewingReservation();
                     break;
            case 5 : exiting();
                     break;
            default : System.out.println("Invalid input");
                     menuOfHotel();
        }
    }
    
    void AddingRoom(){
        System.out.println("Please enter room number");
        int roomNo = scan.nextInt();
        Rooms temp = new Rooms(roomNo, 0);
        if (!rooms.contains(temp)) {
            System.out.println("Please enter room capacity:");
            int capacity = scan.nextInt();
            scan.nextLine();
            rooms.add(new Rooms(roomNo, capacity));
            roomNumbers.add(roomNo);
            System.out.println("Would you like to [A]dd a new room or [R]eturn to the previous menu?");
            char ans = scan.nextLine().toLowerCase().charAt(0);
            while(true){
            if (ans == 'a') {
                AddingRoom();
                break;
            } else if (ans == 'r') {
                menuOfHotel();
                break;
            } else {
                System.out.println("Invalid Input!");
                System.out.println("Would you like to [A]dd a new room or [R]eturn to the previous menu?");
                ans = scan.nextLine().toLowerCase().charAt(0);
            }
            }
        } else {
            System.out.println("Room already exists");
            AddingRoom();
        }
    }
    
    void AddingGuest(){
        System.out.println("Please Enter Guest Name");
        String guest_name = scan.nextLine();
        int guestId = 0;
        if (guests.isEmpty()) {
            guestId = 1;
        } else {
            guestId = guests.size() + 1;
        }
        guests.add(new Guests(guest_name, guestId));
        System.out.println("Guest " + guest_name + " has been created with guest ID: " + guestId);
        System.out.println("Would you like to [A]dd a new guest or [R]eturn to the previous menu?");
        char ans = scan.nextLine().toLowerCase().charAt(0);
        while(true){
        if (ans == 'a') {
            AddingGuest();
        } else if (ans == 'r') {
            menuOfHotel();
        } else {
            System.out.println("Invalid Input!");
            System.out.println("Would you like to [A]dd a new guest or [R]eturn to the previous menu?");
            ans = scan.nextLine().toLowerCase().charAt(0);
            
            
        }
        }

    }
    
    void exiting(){
        System.out.println("Thanks for using Fed Uni Hotel Bookings");
    }
    
    void AddingReservation(){
        System.out.println("Please enter guest ID ");
        int guestId = scan.nextInt();
        while (guestId > guests.size()) {
            System.out.println("Guest ID does not exist");
            AddingReservation();
        }

        Rooms selectRoom = null;
        while (true) {
            System.out.println("Please enter room number: ");
            int roomNo = scan.nextInt();
            
            if(roomNumbers.contains(roomNo)) {
                selectRoom = getRoombyNumber(roomNo);
                break;
            } else {
                System.out.println(" Room number does not exist!");
            }
        }
        Reservation booking = null;
        while (true) {
            System.out.println("Please enter number of guests : ");
            int totalGuests = scan.nextInt();
            if(totalGuests > selectRoom.getCapacity()) {
                System.out.println("Number of guests exceeds the capacity of room : " + selectRoom.getCapacity());
            } else {
                booking = new Reservation(guestId, selectRoom.getRoomNumber(), totalGuests);
                break;
            }
        }
        
        System.out.println("Please enter check-in month: ");
        int checkinMon = scan.nextInt();
        while (checkinMon > 12 || checkinMon <= 0) {
            System.out.println("Invalid month. Please enter check-in month:");
            checkinMon = scan.nextInt();
        }

        System.out.println("Please enter check-in day:");
        int checkinDay = scan.nextInt();
        while (daysofmonth(checkinMon) < checkinDay) {
            System.out.println("Invalid day. Please enter check-in day:");
            checkinDay = scan.nextInt();
        }
        int start = dateToDayNumber(checkinMon, checkinDay);

        System.out.println("Please enter check-out month:");
        int checkoutMon = scan.nextInt();

        System.out.println("Please enter check-out day:");
        int checkoutDay = scan.nextInt();
        scan.nextLine();
        int end = dateToDayNumber(checkoutMon, checkoutDay);
          
        if (isBookedRoom(selectRoom.getRoomNumber(),booking.getStarting(),booking.getEnding())) {
            System.out.println("*** Booking Successful ***");
            booking.setStartOfBooking(start);
            booking.setEndOfBooking(end);
            booking.setStartingDay(checkinDay);
            booking.setEndingDay(checkoutDay);
            booking.setStartingMonth(checkinMon);
            booking.setEndingMonth(checkoutMon);
            reservations.add(booking);
            rooms.add(selectRoom);

        } else {
            System.out.println("Room is not available during that period.");
            AddingReservation();
       }
       

        System.out.println("Would you like to [A]dd a new booking or [R]eturn to the previous menu?");

        char ans = scan.nextLine().toLowerCase().charAt(0);
        while(true){
        if (ans == 'a') {
            AddingReservation();
            break;
        } else if(ans == 'r') {
            menuOfHotel();
            break;
        } else {
            System.out.println("Invalid Input!");
            System.out.println("Would you like to [A]dd a new booking or [R]eturn to the previous menu?");
            
            ans = scan.nextLine().toLowerCase().charAt(0);
        }
    }
    }
    
    
    void ViewingReservation() {
        System.out.println("Would you like to view [G]uest bookings, [R]oom booking, or e[X]it?");
        char ans = scan.nextLine().toLowerCase().charAt(0);
        if (ans == 'g') {
            accordingToGuest();
        } else if (ans == 'r') {
            accordingToRoom();
        } else if (ans == 'e'){
            menuOfHotel();
        } else {
            System.out.println("Invalid Input!");
            ViewingReservation();
        }

    }
    
    
    void accordingToGuest(){
        System.out.println("Please enter guest ID:");
        int guestId = scan.nextInt();
        scan.nextLine();
        
        if (guests.size() >= guestId-1) {
            System.out.println("Guest " + guestId + " :  " + guests.get(guestId-1).getName());
            Reservation booking = getReservationbyGuest(guestId);
            System.out.println("Booking : Room " + booking.getRoomNumber() + " ," + booking.getNumberOfGuests() + "guest[s] from  "
                    + booking.getStartingMonth() + "/" + booking.getStartingDay()+ " to " + booking.getEndingMonth() + "/" + booking.getEndingDay());
            ViewingReservation();
        } else {
            System.out.println("Guest does not exist");
            accordingToGuest();
        }
    }
    
    void accordingToRoom(){
        System.out.println("Please enter room number:");
        int roomNo = scan.nextInt();
        scan.nextLine();
        Reservation booking = getReservationByRoom(roomNo);
        
        if (booking.getRoomNumber()==roomNo) {
              int index = rooms.indexOf(roomNo);
              
             System.out.println("Room " + roomNo + " bookings");
             System.out.println("Guest :  " + booking.getGuest() + " ," + booking.getNumberOfGuests() + "guest[s] from  "
                    + booking.getStartingMonth() + "/" + booking.getStartingDay() + " to " + booking.getEndingMonth() + "/" + booking.getStartingDay());
            
            ViewingReservation();

        } else {
            System.out.println("Room does not exists");
            accordingToRoom();
        }
    }
    
    static int dateToDayNumber(int month, int day) {
// Catch invalid input and return early
        if (month < 1 || month > 12 || day < 1 || day > 31) return 0;
        if (month == 1 ) return day;
        if (month == 2 ) return 31 + day;
        if (month == 3 ) return 59 + day;
        if (month == 4 ) return 90 + day;
        if (month == 5 ) return 120 + day;
        if (month == 6 ) return 151 + day;
        if (month == 7 ) return 181 + day;
        if (month == 8 ) return 212 + day;
        if (month == 9 ) return 243 + day;
        if (month == 10) return 273 + day;
        if (month == 11) return 304 + day;
        return 334 + day;
}
    
    
    static int daysofmonth(int month){
        if(month == 4 || month==6 || month==9 || month==11) return 30;
        else if(month==2) return 28;
        else return 31;
    }
    
    public Rooms getRoombyNumber(int number){
        for(Rooms room : rooms){
            if(room.getRoomNumber()==number){
                return room;
            }
        }
        return null;
        
    }
    private boolean isBookedRoom(int roomNo, int start,int end){
        int flag=0;
        for(Reservation booking : reservations){
            if(booking.getRoomNumber()==roomNo){
                flag=1;
                if(booking.getEnding()<start|| booking.getStarting()>end){
                    return true;
                }
            }
        }
        if(flag==0) return true;
        return false;
    }
    private  Reservation getReservationbyGuest(int id) {
        for (Reservation booking : reservations) {
            if(booking.getGuest() == id) {
                return booking;
            }
        }
        return null;
    }
    
    private Reservation getReservationByRoom(int number) {
        for (Reservation booking : reservations) {
            if(booking.getRoomNumber() == number) {
                return booking;
            }
        }
        return null;
    }
}
