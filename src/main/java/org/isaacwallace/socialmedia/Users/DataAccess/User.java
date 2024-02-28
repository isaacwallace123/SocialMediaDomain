package org.isaacwallace.socialmedia.Users.DataAccess;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.isaacwallace.socialmedia.Common.Objects.Address;

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

    @Embedded
    private Address address;

    public User(@NotNull String first_name, @NotNull String last_name, @NotNull String username, @NotNull String email, @NotNull String password, @NotNull String bio, @NotNull Date joined_date, @NotNull Address address) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.bio = bio;
        this.joined_date = joined_date;
        this.address = address;
    }
}
