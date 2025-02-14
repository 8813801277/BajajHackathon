package com.mukul.Bajaj.Entity;

import jakarta.annotation.Nonnull;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(value = "User")
@Data
@Builder
public class UserEntity {

    @Id
    private long id;
    private String username;
    private String password;

    private List<String> feedback;
    private long pushUps;
    private long squats;
    private long crunches;

    public UserEntity(){}

    public UserEntity(long id, String username, String password, List<String> feedback, long pushUps, long squats, long crunches) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.feedback = feedback;
        this.pushUps = pushUps;
        this.squats = squats;
        this.crunches = crunches;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public @NonNull String getUsername() {
        return username;
    }

    public void setUsername(@NonNull String username) {
        this.username = username;
    }

    public @NonNull String getPassword() {
        return password;
    }

    public void setPassword(@NonNull String password) {
        this.password = password;
    }

    public List<String> getFeedback() {
        return feedback;
    }

    public void setFeedback(List<String> feedback) {
        this.feedback = feedback;
    }

    public long getPushUps() {
        return pushUps;
    }

    public void setPushUps(long pushUps) {
        this.pushUps = pushUps;
    }

    public long getSquats() {
        return squats;
    }

    public void setSquats(long squats) {
        this.squats = squats;
    }

    public long getCrunches() {
        return crunches;
    }

    public void setCrunches(long crunches) {
        this.crunches = crunches;
    }
}
