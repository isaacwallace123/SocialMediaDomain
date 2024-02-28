package org.isaacwallace.socialmedia.Admins.DataAccess;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.isaacwallace.socialmedia.Common.Enums.PositionEnum;
import org.isaacwallace.socialmedia.Common.Objects.Address;
import org.isaacwallace.socialmedia.Common.Objects.PhoneNumber;

import java.util.List;

@Entity
@Table(name = "admins")
@Data
@NoArgsConstructor
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Embedded
    private AdminIdentifier adminIdentifier;

    @Embedded
    private Address address;

    private String first_name;
    private String last_name;
    private String email;
    private Double salary;
    private Position position;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "admin_phonenumbers", joinColumns = @JoinColumn(name = "id"))
    private List<PhoneNumber> phoneNumbers;
    public Admin(@NotNull Address address, @NotNull String first_name, @NotNull String last_name, @NotNull String email, @NotNull Double salary, @NotNull List<PhoneNumber> phoneNumbers, @NotNull Position position) {
        this.address = address;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.salary = salary;
        this.phoneNumbers = phoneNumbers;
        this.position = position;
    }
}
