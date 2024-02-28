package org.isaacwallace.socialmedia.Admin.DataAccess;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.isaacwallace.socialmedia.Common.Address;

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

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "admin_phonenumbers", joinColumns = @JoinColumn(name = "adminid"))
    private List<PhoneNumber> phoneNumbers;
    private String firstName;
    private String lastName;
    private String email;
    private Double salary;


}
