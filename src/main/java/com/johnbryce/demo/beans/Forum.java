package com.johnbryce.demo.beans;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table
public class Forum {
    private long id;
    private String name;
    private Collection<Person> members;

    public Forum(String name, Collection<Person> members) {
        this.name = name;
        this.members = members;
    }

    @Id
    @GeneratedValue
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(cascade = CascadeType.PERSIST) // , fetch=FetchType.EAGER)
    public Collection<Person> getMembers() {
        return members;
    }

    public void setMembers(Collection<Person> members) {
        this.members = members;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        result = prime * result + ((members == null) ? 0 : members.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Forum other = (Forum) obj;
        if (id != other.id)
            return false;
        if (members == null) {
            if (other.members != null)
                return false;
        } else if (!members.equals(other.members))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }
}
