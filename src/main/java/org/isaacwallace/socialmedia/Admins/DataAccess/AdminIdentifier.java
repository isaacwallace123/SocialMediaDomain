package org.isaacwallace.socialmedia.Admins.DataAccess;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;

import java.util.UUID;

@Embeddable
@Getter
public class AdminIdentifier {
    @Column(name = "adminid")
    private String adminid;

    public AdminIdentifier() {
        this.adminid = UUID.randomUUID().toString();
    }
    public AdminIdentifier(String adminid) {
        this.adminid = adminid;
    }
}