package duarte.gabriel.chat;

import java.io.Serializable;

/**
 * Created by gabriel on 19/05/17.
 */

@SuppressWarnings("serial")
public class User implements Serializable {
    private String name;
    private String email;
    private String photoUri;
    private String uId;
    private String fcmId;

    public User(String name, String email, String photoUri, String uId, String fcmId) {
        this.name = name;
        this.email = email;
        this.photoUri = photoUri;
        this.uId = uId;
        this.fcmId = fcmId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhotoUri() {
        return photoUri;
    }

    public String getuId() {
        return uId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhotoUri(String photoUri) {
        this.photoUri = photoUri;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public String getFcmId() { return fcmId; }
    public void setFcmId(String fcmId) { this.fcmId = fcmId; }
}
