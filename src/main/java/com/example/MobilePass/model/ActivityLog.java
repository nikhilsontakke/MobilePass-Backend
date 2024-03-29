package com.example.MobilePass.model;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("activitylogs")
public class ActivityLog {
    String name;
    String nfcId;
    String username;
    String doorId;

    public String getNfcId() {
        return nfcId;
    }

    public void setNfcId(String nfcId) {
        this.nfcId = nfcId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDoorId() {
        return doorId;
    }

    public void setDoorId(String doorId) {
        this.doorId = doorId;
    }

    public ActivityLog(String name, String nfcId, String username, String doorId) {
        this.name = name;
        this.nfcId = nfcId;
        this.username = username;
        this.doorId = doorId;
    }
}
