package org.isaacwallace.socialmedia.Admin.DataAccess;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.isaacwallace.socialmedia.Common.PhoneType;

@Embeddable
@Getter
@NoArgsConstructor
public class PhoneNumber {
    @Enumerated(EnumType.STRING)
    private PhoneType type;
    private String number;

    public PhoneNumber(@NotNull PhoneType type, @NotNull String number) {
        this.type = type;
        this.number = number;
    }
}
