package ru.kata.spring.boot_security.demo.entity;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Data
@Entity
@Table(name = "t_role")
public class Role implements GrantedAuthority {

    @Id
    /*@Column(name = "id")*/
    private Integer id;

    @Column(name = "name")
    private String name;

    @Transient
    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    public Role(int i, String roleUser) {
        this.id = i;
        this.name = roleUser;
    }

    public Role() {

    }

    @Override
    public String getAuthority() {
        return getName();
    }
}
