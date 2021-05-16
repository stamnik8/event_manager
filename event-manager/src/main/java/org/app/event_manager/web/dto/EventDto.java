package org.app.event_manager.web.dto;

import lombok.Getter;
import lombok.Setter;
import org.app.event_manager.dao.Enums.EventCategory;
import org.app.event_manager.dao.model.Event;


import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.UUID;


@Getter
@Setter
public class EventDto implements Serializable {

    //attributes to be exposed
    private UUID id;

    @NotNull
    private String eventName;

    @NotNull
    private String location;

    private String description;

    private String weather;

    private String imgUrl;

    @Enumerated(EnumType.STRING)
    @NotNull
    private EventCategory category;

    private ZonedDateTime date;

    private String lon;

    private String lat;

    //Empty
    public EventDto() {
    }

    public EventDto(UUID id, @NotNull String eventName, @NotNull String location, String description, String imgUrl, @NotNull EventCategory category, ZonedDateTime date, String lon, String lat) {
        this.id = id;
        this.eventName = eventName;
        this.location = location;
        this.description = description;
        this.imgUrl = imgUrl;
        this.category = category;
        this.date = date;
        this.lon = lon;
        this.lat = lat;
    }

    public EventDto fromEntity(Event event) {

        setId(event.getExternalId());
        setEventName(event.getEventName());
        setLocation(event.getLocation());
        setCategory(event.getCategory());
        setDate(event.getDateOfEvent());
        setLon(event.getLon());
        setLat(event.getLat());
        setImgUrl(event.getImgUrl());
        setDescription(event.getDescription());

        return this;
    }

    public Event toEntity() {
        Event event = new Event();

        return this.toEntity(event);
    }

    public Event toEntity(Event event) {

        event.setEventName(eventName);
        event.setLocation(location);
        event.setCategory(category);
        event.setDescription(description);
        event.setDateOfEvent(date);
        event.setLat(lat);
        event.setLon(lon);
        event.setImgUrl(imgUrl);

        return event;
    }
}