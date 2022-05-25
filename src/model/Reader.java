package model;

public class Reader {
    private int reader_id;
    private String fio;
    private int ticket_number;
    private String birthday;
    private int phone;
    private String education;
    private int hall_id;
    private String hall_name;
    private int book_id;
    private String book_name;

    public Reader(int reader_id, String fio, int ticket_number, String birthday, int phone, String education, int hall_id, int book_id) {
        this.reader_id = reader_id;
        this.fio = fio;
        this.ticket_number = ticket_number;
        this.birthday = birthday;
        this.phone = phone;
        this.education = education;
        this.hall_id = hall_id;
        this.book_id = book_id;
    }

    public Reader(int reader_id, String fio, int ticket_number, String birthday, int phone, String education, String hall_name, String book_name) {
        this.reader_id = reader_id;
        this.fio = fio;
        this.ticket_number = ticket_number;
        this.birthday = birthday;
        this.phone = phone;
        this.education = education;
        this.hall_name = hall_name;
        this.book_name = book_name;
    }


    public int getReader_id() {
        return reader_id;
    }

    public String getFio() {
        return fio;
    }

    public int getTicket_number() {
        return ticket_number;
    }

    public String getBirthday() {
        return birthday;
    }

    public int getPhone() {
        return phone;
    }

    public String getEducation() {
        return education;
    }

    public int getHall_id() {
        return hall_id;
    }

    public int getBook_id() {
        return book_id;
    }
}
