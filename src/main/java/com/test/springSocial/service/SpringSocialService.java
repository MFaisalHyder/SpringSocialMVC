package com.test.springSocial.service;

import com.test.springSocial.entity.SpringSocial;
import com.test.springSocial.manager.SpringSocialManager;
import com.test.springSocial.repository.SpringSocialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpringSocialService implements SpringSocialManager {

    @Autowired
    SpringSocialRepository socialRepository;

    /**
     * get user given Facebook user ID
     *
     * @param userID
     * @return
     */
    public SpringSocial getUserByID(String userID) {

        SpringSocial springSocial = new SpringSocial();

        try {
            springSocial = socialRepository.findByUserID(userID);
        } catch (Exception e) {
            System.out.println("User not found wth given user ID");
        }

        return springSocial;
    }

    /**
     * saves given user in DB
     *
     * @param user
     */
    public void saveUser(SpringSocial user) {
        SpringSocial springSocial = new SpringSocial();

        try {
            springSocial.setUserID(user.getUserID().toString());
            springSocial.setImageURL(user.getImageURL().toString());
            springSocial.setAccessToken(user.getAccessToken().toString());

            socialRepository.save(springSocial);

        } catch (Exception e) {
            System.out.println("Some issue in saving user");
        }
    }
}