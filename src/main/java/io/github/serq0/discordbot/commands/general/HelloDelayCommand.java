package io.github.serq0.discordbot.commands.general;

import io.github.serq0.discordbot.commands.CommandImpl;
import io.github.serq0.discordbot.database.Database;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HelloDelayCommand extends CommandImpl {
    @Override
    public void execute(MessageReceivedEvent event, List<String> command, Database database) {
        if(command.size()==2 && isNumber(command.get(1))){
            event.getChannel().sendMessage("Hello!").queueAfter(Long.parseLong(command.get(1)), TimeUnit.SECONDS);
        }
    }
}
