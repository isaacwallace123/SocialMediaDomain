package org.isaacwallace.socialmedia.Users.DataAccess;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Embedded
    private UserIdentifier userIdentifier;

    private String username;
    private String first_name;
    private String last_name;

    private String email;
    private String password;

    private String bio;
    private Date joined_date;

    private String postal_code;
    private String street;
    private String city;
    private String province;
    private String country;

    public User(@NotNull String first_name, @NotNull String last_name, @NotNull String username, @NotNull String email, @NotNull String password, @NotNull String bio, @NotNull Date joined_date, @NotNull String postal_code, @NotNull String street, @NotNull String city, @NotNull String province, @NotNull String country) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.bio = bio;
        this.joined_date = joined_date;
        this.postal_code = postal_code;
        this.street = street;
        this.city = city;
        this.province = province;
        this.country = country;
    }
}
