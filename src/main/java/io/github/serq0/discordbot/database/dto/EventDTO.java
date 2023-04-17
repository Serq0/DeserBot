package io.github.serq0.discordbot.database.dto;

import java.util.Calendar;

public class EventDTO {
    private Integer id;
    private String creatorDiscordId;
    private String channelDiscordId;
    private String description;
    private String dateTime;
    private String maxParticipants;

    public Calendar getTime() {
        Calendar calendar = Calendar.getInstance();
        return calendar;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCreatorDiscordId() {
        return creatorDiscordId;
    }

    public void setCreatorDiscordId(String creatorDiscordId) {
        this.creatorDiscordId = creatorDiscordId;
    }

    public String getChannelDiscordId() {
        return channelDiscordId;
    }

    public void setChannelDiscordId(String channelDiscordId) {
        this.channelDiscordId = channelDiscordId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getMaxParticipants() {
        return maxParticipants;
    }

    public void setMaxParticipants(String maxParticipants) {
        this.maxParticipants = maxParticipants;
    }
}
