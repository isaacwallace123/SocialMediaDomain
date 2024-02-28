package org.isaacwallace.socialmedia.Admin.DataAccess;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
public class Position {
    public String title;
    public String code;

    public Position(@NotNull String title, @NotNull String code) {
        this.title = title;
        this.code = code;
    }
}
