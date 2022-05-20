package model;

public class Hall {
    private int hall_id;
    private String library_name;
    private String hall;
    private String specialization;
    private int number_seats;

    public Hall(int hall_id, String library_name, String hall, String specialization, int number_seats) {
        this.hall_id = hall_id;
        this.library_name = library_name;
        this.hall = hall;
        this.specialization = specialization;
        this.number_seats = number_seats;
    }

    public int getHall_id() {
        return hall_id;
    }

    public String getLibrary_name() {
        return library_name;
    }

    public String getHall() {
        return hall;
    }

    public String getSpecialization() {
        return specialization;
    }

    public int getNumber_seats() {
        return number_seats;
    }
}
