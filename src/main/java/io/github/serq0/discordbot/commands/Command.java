package io.github.serq0.discordbot.commands;

import io.github.serq0.discordbot.database.Database;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.util.List;

public interface Command {
    void execute(MessageReceivedEvent event, List<String> command, Database database);
}
