package ua.com.serhii.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.com.serhii.ConsoleHelper;
import ua.com.serhii.dao.JDBCLectorDAO;
import ua.com.serhii.entity.helpingModels.Degree;

import java.io.IOException;
import java.util.Map;

@Component
public class StatisticCommand implements Command {
    @Autowired
    private JDBCLectorDAO lectorDAO;

    @Override
    public void execute() throws IOException {
        ConsoleHelper.writeMessage("Department:");
        String department = ConsoleHelper.readString();
        Map<Degree, Integer> statistic = lectorDAO.statistic(department);
        for (Map.Entry<Degree, Integer> entry : statistic.entrySet()){
            ConsoleHelper.writeMessage(String.format("%s - %d", entry.getKey().getName(), entry.getValue()));
        }

    }
}
