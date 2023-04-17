package io.github.serq0.discordbot.database.dao;

import io.github.serq0.discordbot.database.dto.EventDTO;
import org.springframework.beans.factory.annotation.Value;

import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Named
public class EventDAO {
    @Inject
    private DataSource dataSource;

    @Value("${events.selectById}")
    private String SELECT_BY_ID_SQL;

    @Value("${events.insert}")
    private String INSERT_SQL;

    public EventDTO read(String id) throws SQLException {
        try (Connection connection = dataSource.getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID_SQL)) {
                statement.setString(1, id);
                try (ResultSet result = statement.executeQuery()) {
                    if (result.next()) {
                        EventDTO event = new EventDTO();
                        event.setId(Integer.valueOf(result.getInt("id")));
                        event.setCreatorDiscordId(result.getString("creator_discord_id"));
                        event.setChannelDiscordId(result.getString("channel_discord_id"));
                        event.setDescription(result.getString("description"));
                        event.setDateTime(result.getString("date_time"));
                        return event;
                    } else {
                        return null;
                    }
                }
            }
        }
    }

    public void create(EventDTO event) throws SQLException {
        try (Connection connection = dataSource.getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement(INSERT_SQL)) {
                statement.setInt(1, event.getId());
                statement.setString(2, event.getCreatorDiscordId());
                statement.setString(3, event.getChannelDiscordId());
                statement.setString(4, event.getDescription());
                statement.setString(5, event.getDateTime());
                statement.executeUpdate();
            }
        }
    }
}
