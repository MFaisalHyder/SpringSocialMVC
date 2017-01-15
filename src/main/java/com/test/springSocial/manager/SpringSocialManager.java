package com.test.springSocial.manager;

import com.test.springSocial.entity.SpringSocial;

public interface SpringSocialManager {

    /**
     * saves the user data
     *
     * @param user
     */
    void saveUser(SpringSocial user);

    /**
     * Returns user given their Facebook user ID
     *
     * @param userID
     * @return
     */
    SpringSocial getUserByID(String userID);
}
