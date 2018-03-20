package ua.com.serhii.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.com.serhii.ConsoleHelper;
import ua.com.serhii.dao.JDBCLectorDAO;
import ua.com.serhii.entity.Lector;

import java.io.IOException;

@Component
public class ShowHeadCommand implements Command {
    @Autowired
    private JDBCLectorDAO lectorDAO;

    @Override
    public void execute() throws IOException {
        ConsoleHelper.writeMessage("Department:");
        String department = ConsoleHelper.readString();
        Lector head = lectorDAO.findHead(department);
        ConsoleHelper.writeMessage((String.format("Head of the department %s is %s %s", department, head.getFirstName(), head.getLastName())));
    }
}
