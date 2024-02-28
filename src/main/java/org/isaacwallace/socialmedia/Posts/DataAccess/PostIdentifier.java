package org.isaacwallace.socialmedia.Posts.DataAccess;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;

import java.util.UUID;

@Embeddable
@Getter
public class PostIdentifier {
    @Column(name = "postid")
    private String postid;

    public PostIdentifier(){
        this.postid = UUID.randomUUID().toString();
    }
}