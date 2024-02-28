package org.isaacwallace.socialmedia.Comments.DataAccess;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "comments")
@Data
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Embedded
    private CommentIdentifier commentIdentifier;

    private String postid;
    private String userid;
    private String content;
    private Date created_date;

    public Comment(@NotNull String postid, @NotNull String userid, @NotNull String content, @NotNull Date created_date) {
        this.postid = postid;
        this.userid = userid;
        this.content = content;
        this.created_date = created_date;
    }
}
