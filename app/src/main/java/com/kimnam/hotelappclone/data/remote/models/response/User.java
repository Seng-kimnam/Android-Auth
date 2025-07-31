package com.kimnam.hotelappclone.data.remote.models.response;
import com.kimnam.hotelappclone.data.remote.models.response.RolesItem;
import java.util.List;
import com.google.gson.annotations.SerializedName;

public class User{

    @SerializedName("lastName")
    private String lastName;

    @SerializedName("profile")
    private String profile;

    @SerializedName("roles")
    private List<RolesItem> roles;

    @SerializedName("updateAt")
    private Object updateAt;

    @SerializedName("verifyEmail")
    private Object verifyEmail;

    @SerializedName("createAt")
    private String createAt;

    @SerializedName("changePassword")
    private String changePassword;

    @SerializedName("firstName")
    private String firstName;

    @SerializedName("createBy")
    private String createBy;

    @SerializedName("phoneNumber")
    private String phoneNumber;

    @SerializedName("updateBy")
    private Object updateBy;

    @SerializedName("id")
    private int id;

    @SerializedName("email")
    private String email;

    @SerializedName("username")
    private String username;

    @SerializedName("status")
    private String status;

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public String getLastName(){
        return lastName;
    }

    public void setProfile(String profile){
        this.profile = profile;
    }

    public String getProfile(){
        return profile;
    }

    public void setRoles(List<RolesItem> roles){
        this.roles = roles;
    }

    public List<RolesItem> getRoles(){
        return roles;
    }

    public void setUpdateAt(Object updateAt){
        this.updateAt = updateAt;
    }

    public Object getUpdateAt(){
        return updateAt;
    }

    public void setVerifyEmail(Object verifyEmail){
        this.verifyEmail = verifyEmail;
    }

    public Object getVerifyEmail(){
        return verifyEmail;
    }

    public void setCreateAt(String createAt){
        this.createAt = createAt;
    }

    public String getCreateAt(){
        return createAt;
    }

    public void setChangePassword(String changePassword){
        this.changePassword = changePassword;
    }

    public String getChangePassword(){
        return changePassword;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getFirstName(){
        return firstName;
    }

    public void setCreateBy(String createBy){
        this.createBy = createBy;
    }

    public String getCreateBy(){
        return createBy;
    }

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }

    public void setUpdateBy(Object updateBy){
        this.updateBy = updateBy;
    }

    public Object getUpdateBy(){
        return updateBy;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return id;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getEmail(){
        return email;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public String getUsername(){
        return username;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public String getStatus(){
        return status;
    }

    @Override
    public String toString(){
        return
                "User{" +
                        "lastName = '" + lastName + '\'' +
                        ",profile = '" + profile + '\'' +
                        ",roles = '" + roles + '\'' +
                        ",updateAt = '" + updateAt + '\'' +
                        ",verifyEmail = '" + verifyEmail + '\'' +
                        ",createAt = '" + createAt + '\'' +
                        ",changePassword = '" + changePassword + '\'' +
                        ",firstName = '" + firstName + '\'' +
                        ",createBy = '" + createBy + '\'' +
                        ",phoneNumber = '" + phoneNumber + '\'' +
                        ",updateBy = '" + updateBy + '\'' +
                        ",id = '" + id + '\'' +
                        ",email = '" + email + '\'' +
                        ",username = '" + username + '\'' +
                        ",status = '" + status + '\'' +
                        "}";
    }
}