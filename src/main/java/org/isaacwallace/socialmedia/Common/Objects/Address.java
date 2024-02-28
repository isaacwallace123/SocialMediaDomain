package org.isaacwallace.socialmedia.Common.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
public class Address {
    @Column(name = "street")
    private String street;
    @Column(name = "city")
    private String city;
    @Column(name = "province")
    private String province;
    @Column(name = "country")
    private String country;
    @Column(name = "postal_code")
    private String postal_code;

    public Address(@NotNull String street, @NotNull String city, @NotNull String province, @NotNull String country, @NotNull String postal_code) {
        this.street = street;
        this.city = city;
        this.province = province;
        this.country = country;
        this.postal_code = postal_code;
    }
}
