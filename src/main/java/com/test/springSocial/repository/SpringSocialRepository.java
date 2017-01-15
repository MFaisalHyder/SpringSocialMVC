package com.test.springSocial.repository;

import com.test.springSocial.entity.SpringSocial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringSocialRepository extends JpaRepository<SpringSocial, Long> {

    /**
     * Finds user given Facebook user ID
     *
     * @param userID
     * @return
     */
    SpringSocial findByUserID(String userID);
}
