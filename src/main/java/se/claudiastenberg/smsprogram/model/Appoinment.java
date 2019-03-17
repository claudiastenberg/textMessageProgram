package se.claudiastenberg.smsprogram.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Appoinment {

    @Id
    @GeneratedValue
    private Long id;
    private String cause;

    @OneToMany(mappedBy = "appoinment")
    private Collection<User> user;

    protected Appoinment() { }

    public Appoinment(String cause, Collection<User> user) {
        this.cause = cause;
        this.user = user;
    }

    public Appoinment(Long id, Collection<User> user, String cause) {
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

    public Collection<User> getUser() {
        return user;
    }

    public void setUser(Collection<User> user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Appoinment{" +
                "id=" + id +
                ", cause='" + cause + '\'' +
                ", user=" + user +
                '}';
    }
}
