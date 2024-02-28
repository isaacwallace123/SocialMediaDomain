package org.isaacwallace.socialmedia.Users.DataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    public User findUserByUserIdentifier_Userid(String userid);
}
