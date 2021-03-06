package ua.com.serhii.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.com.serhii.ConsoleHelper;
import ua.com.serhii.dao.JDBCLectorDAO;

import java.io.IOException;

@Component
public class AverageSalatyCommand implements Command {
    @Autowired
    private JDBCLectorDAO lectorDAO;

    @Override
    public void execute() throws IOException {
        ConsoleHelper.writeMessage("Department:");
        String department = ConsoleHelper.readString();
        Double avgSalary = lectorDAO.avgSalary(department);
        ConsoleHelper.writeMessage(String.valueOf(avgSalary));
    }
}
