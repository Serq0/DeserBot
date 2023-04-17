package io.github.serq0.discordbot.commands.general;

import io.github.serq0.discordbot.commands.CommandImpl;
import io.github.serq0.discordbot.database.Database;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.util.List;
import java.util.Random;

public class RollCommand extends CommandImpl {
    @Override
    public void execute(MessageReceivedEvent event, List<String> command, Database database) {
        Random random = new Random();
        Integer randomNumber;
        if (command.size() == 1) {
            randomNumber = random.nextInt(100) + 1;
            event.getChannel().sendMessage(String.valueOf(randomNumber)).queue();
        }
        if (command.size() == 2 && isNumber(command.get(1)) && Integer.parseInt(command.get(1)) > 0) {
            randomNumber = random.nextInt(Integer.parseInt(command.get(1))) + 1;
            event.getChannel().sendMessage(String.valueOf(randomNumber)).queue();
        }
    }
}
