package ua.com.serhii;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.com.serhii.command.Command;

import java.util.Map;

@Component
public class CommandExecutor {
    @Autowired
    Map<Operation, Command> commandMap;

    public void execute(Operation operation) throws Exception{
        commandMap.get(operation).execute();
    }
}
