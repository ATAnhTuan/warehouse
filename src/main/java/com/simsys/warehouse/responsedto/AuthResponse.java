package com.simsys.warehouse.responsedto;

public class AuthResponse {
    private String username;
    private String token;
    private String gmail;
    private String contactInfo;

    public AuthResponse(String username, String token, String gmail, String contactInfo) {
        this.username = username;
        this.token = token;
        this.gmail = gmail;
        this.contactInfo = contactInfo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }
}
