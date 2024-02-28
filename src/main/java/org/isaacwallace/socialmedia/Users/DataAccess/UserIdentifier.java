package org.isaacwallace.socialmedia.Users.DataAccess;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;

import java.util.UUID;

@Embeddable
@Getter
public class UserIdentifier {
    @Column(name = "userid")
    private String userid;

    public UserIdentifier(){
        this.userid = UUID.randomUUID().toString();
    }

    public UserIdentifier(String userid){
        this.userid = userid;
    }
}
