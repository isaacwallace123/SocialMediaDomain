package org.isaacwallace.socialmedia.Admin.DataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
    public Admin findAdminByAdminIdentifier_Adminid(String userid);
}
