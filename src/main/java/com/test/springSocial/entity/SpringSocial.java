package com.test.springSocial.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SPRING_SOCIAL")
public class SpringSocial {

    @Id //required as Hibernate needs a PK for an Entity
    @Column(name = "USER_ID")
    private String userID;

    @Column(name = "IMAGE_URL")
    private String imageURL;

    @Column(name = "ACCESS_TOKEN")
    private String accessToken;

    public String getUserID() { return userID; }

    public void setUserID(String userID) { this.userID = userID; }

    public String getImageURL() { return imageURL; }

    public void setImageURL(String imageURL) { this.imageURL = imageURL; }

    public String getAccessToken() { return accessToken; }

    public void setAccessToken(String accessToken) { this.accessToken = accessToken; }

}