package ua.com.serhii;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import ua.com.serhii.command.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class BCSimpleProjectApplication implements CommandLineRunner {

    @Autowired
    private ApplicationContext context;
    @Autowired
    private CommandExecutor commandExecutor;

    public static void main(String[] args) {
        SpringApplication.run(BCSimpleProjectApplication.class, args);
    }

    @Bean("commandMap")
    public Map<Operation, Command> getCommandMap(){
        HashMap<Operation, Command> commandMap = new HashMap<>();
        commandMap.put(Operation.SHOW_HEAD, context.getBean(ShowHeadCommand.class));
        commandMap.put(Operation.STATISTIC, context.getBean(StatisticCommand.class));
        commandMap.put(Operation.AVG_SALARY, context.getBean(AverageSalatyCommand.class));
        commandMap.put(Operation.EMP_COUNT, context.getBean(EmployeeCountCommand.class));
        commandMap.put(Operation.SEARCH, context.getBean(GlobalSearchCommand.class));
        commandMap.put(Operation.EXIT, context.getBean(ExitCommand.class));
        return commandMap;
    }

    @Override
    public void run(String... args) throws Exception {
        Operation operation;
        do {
            operation = askOperation();
            commandExecutor.execute(operation);
        } while (operation != Operation.EXIT);
    }

    private static Operation askOperation() throws IOException{
        ConsoleHelper.writeMessage("");
        ConsoleHelper.writeMessage("Select operation:");
        ConsoleHelper.writeMessage(String.format("\t %d - Who is head of department", Operation.SHOW_HEAD.ordinal()));
        ConsoleHelper.writeMessage(String.format("\t %d - Show statistic", Operation.STATISTIC.ordinal()));
        ConsoleHelper.writeMessage(String.format("\t %d - Show average salary for department", Operation.AVG_SALARY.ordinal()));
        ConsoleHelper.writeMessage(String.format("\t %d - Show count of employee", Operation.EMP_COUNT.ordinal()));
        ConsoleHelper.writeMessage(String.format("\t %d - Global search", Operation.SEARCH.ordinal()));
        ConsoleHelper.writeMessage(String.format("\t %d - Exit", Operation.EXIT.ordinal()));

        return Operation.values()[ConsoleHelper.readInt()];
    }
}
