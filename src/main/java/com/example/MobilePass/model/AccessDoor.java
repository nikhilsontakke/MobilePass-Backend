package com.example.MobilePass.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.repository.MongoRepository;

@Document("accessdoors")
public class AccessDoor {
    public String getId() {
        return id;
    }

    public AccessDoor(String id, String roomId) {
        this.id = id;
        this.roomId = roomId;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    @Id
    String id;
    String roomId;
}
