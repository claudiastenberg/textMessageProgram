package se.claudiastenberg.smsprogram.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    private int personald;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    @JsonManagedReference
    private Collection<Appoinment> appoinment;

    protected User() { }

    public User(String firstName, String lastName, int personald, Collection <Appoinment> appoinment) {
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

    public Collection <Appoinment>  getAppoinment() {
        return appoinment;
    }

    public void setAppoinment(Collection <Appoinment>  appoinment) {
        this.appoinment = appoinment;
    }
}
