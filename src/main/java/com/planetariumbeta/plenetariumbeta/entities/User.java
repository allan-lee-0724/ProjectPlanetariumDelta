package com.planetariumbeta.plenetariumbeta.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    
    @Id
    @Column(name = "id")
    private int userId;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

}
