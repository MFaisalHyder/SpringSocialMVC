package com.test.springSocial.controller;

import com.test.springSocial.entity.SpringSocial;
import com.test.springSocial.manager.SpringSocialManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.connect.support.OAuth2Connection;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.lang.reflect.Field;

@Controller
@RequestMapping("getData")
public class SpringSocialController {

    private Facebook facebook;
    private ConnectionRepository connectionRepository;

    @Autowired
    SpringSocialManager socialManager;

    @Bean
    @Scope(value = "request", proxyMode = ScopedProxyMode.INTERFACES)
    public Facebook facebook() {
        return connectionRepository.getPrimaryConnection(Facebook.class).getApi();
    }

    public SpringSocialController(Facebook facebook, ConnectionRepository connectionRepository) {
        this.facebook = facebook;
        this.connectionRepository = connectionRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Void> helloFacebook() throws NoSuchFieldException, IllegalAccessException {
        if (connectionRepository.findPrimaryConnection(Facebook.class) == null) {
            return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
        }

        Connection<Facebook> facebookConnection = connectionRepository.findPrimaryConnection(Facebook.class);

        //Access User Token
        Field field = OAuth2Connection.class.getDeclaredField("accessToken");
        field.setAccessible(true);
        String userToken = (String) field.get(facebookConnection);

        //Access User ID
        String[] fields = {"id"};
        User socialUser = facebook.fetchObject("me", User.class, fields);
        String userID = socialUser.getId();

        //get User profile display name
        String userName = facebookConnection.getDisplayName();

        //get user profile image URL
        String userImageURL = facebookConnection.getImageUrl();

        System.out.println(userID + " | " + userName +  " | " + userImageURL + " | " + userToken);

        SpringSocial springSocial = new SpringSocial();
        springSocial.setUserID(userID);
        springSocial.setImageURL(userImageURL);
        springSocial.setAccessToken(userToken);

        socialManager.saveUser(springSocial);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}