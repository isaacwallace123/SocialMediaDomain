package org.isaacwallace.socialmedia.Posts.DataAccess;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.isaacwallace.socialmedia.Common.Enums.MediaEnum;

@Embeddable
@Getter
@NoArgsConstructor
public class Media {
    @Enumerated(EnumType.STRING)
    @Column(name = "media_type")
    private MediaEnum media_type;

    @Column(name = "media_attachment")
    private String media_attachment;

    public Media(@NotNull MediaEnum media_type, @NotNull String media_attachment) {
        this.media_type = media_type;
        this.media_attachment = media_attachment;
    }
}
