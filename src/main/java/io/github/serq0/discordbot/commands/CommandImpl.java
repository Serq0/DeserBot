package io.github.serq0.discordbot.commands;

import io.github.serq0.discordbot.CommandValidator;
import io.github.serq0.discordbot.database.Database;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

public abstract class CommandImpl implements Command {
    public List<String> getCommand(String prefix, MessageReceivedEvent event, Database database) {
        return CommandValidator.getCommandsToListFromMessage(prefix, event.getMessage().getContentRaw());
    }

    protected boolean isNumber(Object object) {
        if (object instanceof Number || (object instanceof CharSequence && StringUtils.isNumeric((CharSequence) object))) {
            return true;
        }
        return false;
    }
}
