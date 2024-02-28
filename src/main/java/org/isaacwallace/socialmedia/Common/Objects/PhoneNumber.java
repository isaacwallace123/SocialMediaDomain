package org.isaacwallace.socialmedia.Common.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.isaacwallace.socialmedia.Common.Enums.PhoneTypeEnum;

@Embeddable
@Getter
@NoArgsConstructor
public class PhoneNumber {
    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private PhoneTypeEnum type;

    @Column(name = "number")
    private String number;

    public PhoneNumber(@NotNull PhoneTypeEnum type, @NotNull String number) {
        this.type = type;
        this.number = number;
    }
}
