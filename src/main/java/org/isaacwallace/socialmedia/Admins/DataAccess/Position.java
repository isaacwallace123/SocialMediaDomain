package org.isaacwallace.socialmedia.Admins.DataAccess;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.isaacwallace.socialmedia.Common.Enums.PositionEnum;

@Embeddable
@Getter
@NoArgsConstructor
public class Position {
    @Enumerated(EnumType.STRING)
    @Column(name = "position_title")
    private PositionEnum position_title;

    @Column(name = "position_code")
    private String position_code;

    public Position(@NotNull PositionEnum position_title, @NotNull String position_code) {
        this.position_title = position_title;
        this.position_code = position_code;
    }
}
