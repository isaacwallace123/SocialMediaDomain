package org.isaacwallace.socialmedia.Comments.DataAccess;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;

import java.util.UUID;

@Embeddable
@Getter
public class CommentIdentifier {
    @Column(name = "commentid")
    private String commentid;

    public CommentIdentifier() {
        this.commentid = UUID.randomUUID().toString();
    }
}