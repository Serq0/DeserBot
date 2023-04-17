package io.github.serq0.discordbot;

import io.github.serq0.discordbot.commands.Command;
import io.github.serq0.discordbot.commands.general.CommandsCommand;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.util.ArrayList;
import java.util.List;

public class MessageReceivedEventHandler {
    private DiscordBot discordBot;
    private CommandValidator validator;

    public MessageReceivedEventHandler(DiscordBot discordBot) {
        this.discordBot = discordBot;
        this.validator = new CommandValidator(discordBot);
    }

    public MessageReceivedEventHandler() {
    }

    public void handleEvent(MessageReceivedEvent event) {
        Command command = validator.recognizeCommand(event);
        if (command != null && command instanceof CommandsCommand) {
            List<String> commands = new ArrayList<>(validator.getCommandMap().keySet());
            command.execute(event, commands, discordBot.getDatabase());
        } else if (command != null) {
            command.execute(event, CommandValidator.getCommandsToListFromMessage(getDiscordBot().getCommandPrefix(), event.getMessage().getContentRaw()), discordBot.getDatabase());
        }
    }

    public DiscordBot getDiscordBot() {
        return discordBot;
    }

    public void setDiscordBot(DiscordBot discordBot) {
        this.discordBot = discordBot;
    }

    public CommandValidator getValidator() {
        return validator;
    }

    public void setValidator(CommandValidator validator) {
        this.validator = validator;
    }
}