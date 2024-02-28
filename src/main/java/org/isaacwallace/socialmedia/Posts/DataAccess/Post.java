package org.isaacwallace.socialmedia.Posts.DataAccess;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "posts")
@Data
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Embedded
    private PostIdentifier postIdentifier;

    private String userid;

    private String content;
    private Date created_date;
    private Media media;

    public Post(@NotNull String userid, @NotNull String content, @NotNull Date created_date, @NotNull Media media) {
        this.userid = userid;
        this.content = content;
        this.created_date = created_date;
        this.media = media;
    }
}
