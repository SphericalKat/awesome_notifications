package me.carda.awesome_notifications.notifications.models;

import android.content.Context;

import java.util.HashMap;
import java.util.Map;

import me.carda.awesome_notifications.notifications.exceptions.AwesomeNotificationException;
import me.carda.awesome_notifications.utils.StringUtils;

public class NotificationMessageModel extends Model {
    public String name;
    public String body;
    public String icon;

    public NotificationMessageModel() {
    }

    @Override
    public NotificationMessageModel fromMap(Map<String, Object> arguments) {
        name = getValueOrDefault(arguments, "name", String.class);
        body = getValueOrDefault(arguments, "body", String.class);
        icon = getValueOrDefault(arguments, "icon", String.class);
        return this;
    }

    @Override
    public Map<String, Object> toMap() {
        Map<String, Object> returnedObject = new HashMap<>();
        returnedObject.put("name", name);
        returnedObject.put("body", body);
        returnedObject.put("icon", icon);

        return returnedObject;
    }

    @Override
    public String toJson() {
        return templateToJson();
    }

    @Override
    public NotificationMessageModel fromJson(String json) {
        return (NotificationMessageModel) super.templateFromJson(json);
    }

    @Override
    public void validate(Context context) throws AwesomeNotificationException {
        if (StringUtils.isNullOrEmpty(name)) {
            throw new AwesomeNotificationException("Message name cannot be null or empty");
        }
        if (StringUtils.isNullOrEmpty(body)) {
            throw new AwesomeNotificationException("Message body cannot be null or empty");
        }
        if (StringUtils.isNullOrEmpty(icon)) {
            throw new AwesomeNotificationException("Message icon cannot be null or empty");
        }
    }
}
