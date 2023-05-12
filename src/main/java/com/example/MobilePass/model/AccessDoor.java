package com.example.MobilePass.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("accessdoors")
public class AccessDoor {
    @Id
    Integer id;
    String nfcId;
    String roomId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNfcId() {
        return nfcId;
    }

    public AccessDoor(Integer id, String nfcId, String roomId) {
        this.id = id;
        this.nfcId = nfcId;
        this.roomId = roomId;
    }

    public void setNfcId(String nfcId) {
        this.nfcId = nfcId;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }
}
