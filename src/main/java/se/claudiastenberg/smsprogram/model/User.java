package se.claudiastenberg.smsprogram.model;


import javax.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    private int personald;

    @ManyToOne
    private Appoinment appoinment;

    protected User() { }

    public User(String firstName, String lastName, int personald, Appoinment appoinment) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.personald = personald;
        this.appoinment = appoinment;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getPersonald() {
        return personald;
    }

    public void setPersonald(int personald) {
        this.personald = personald;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Appoinment getAppoinment() {
        return appoinment;
    }

    public void setAppoinment(Appoinment appoinment) {
        this.appoinment = appoinment;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", appoinment=" + appoinment +
                '}';
    }
}
