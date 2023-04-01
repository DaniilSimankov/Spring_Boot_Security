package ru.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Account implements Serializable {

    // TODO: serialVersionUID

    public enum Role{
        USER,
        ADMIN
    };

    public enum State{
        NOT_CONFIRMED,
        CONFIRMED,
        DELETED,
        BANNED
    };

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String fistName;
    @Column(name = "last_name")
    private String lastName;

    private String email;
    private String password;

    @Enumerated(value = EnumType.STRING)
    private Role role;
    @Enumerated(value = EnumType.STRING)
    private State state;

}
