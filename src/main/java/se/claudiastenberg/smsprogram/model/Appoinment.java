package se.claudiastenberg.smsprogram.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class Appoinment {

    @Id
   @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String cause;

    @Column(nullable = false)
    private String date;

    @ManyToOne
    @JsonBackReference
    private User user;

    protected Appoinment() { }

    public Appoinment(String cause, User user, String date) {
        this.cause = cause;
        this.user = user;
        this.date=date;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
