package io.github.serq0.discordbot.commands.general;

import io.github.serq0.discordbot.commands.CommandImpl;
import io.github.serq0.discordbot.database.Database;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.util.List;

public class CommandsCommand extends CommandImpl {
    @Override
    public void execute(MessageReceivedEvent event, List<String> command, Database database) {
        event.getChannel().sendMessage(String.join(", ", command)).queue();
    }
}
