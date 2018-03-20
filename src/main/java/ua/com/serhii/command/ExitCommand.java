package ua.com.serhii.command;

import org.springframework.stereotype.Component;
import ua.com.serhii.ConsoleHelper;

@Component
public class ExitCommand implements Command{
    @Override
    public void execute() {
        ConsoleHelper.writeMessage("exit..");
    }
}
