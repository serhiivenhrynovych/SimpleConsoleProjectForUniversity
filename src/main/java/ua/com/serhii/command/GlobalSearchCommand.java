package ua.com.serhii.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.com.serhii.ConsoleHelper;
import ua.com.serhii.dao.JDBCLectorDAO;
import ua.com.serhii.entity.Lector;

import java.io.IOException;
import java.util.List;

@Component
public class GlobalSearchCommand implements Command {
    @Autowired
    private JDBCLectorDAO lectorDAO;

    @Override
    public void execute() throws IOException {
        ConsoleHelper.writeMessage("Search:");
        String searchQuery = ConsoleHelper.readString();
        List<Lector> lectors = lectorDAO.search(searchQuery);
        lectors.forEach(el -> {
            ConsoleHelper.writeMessage(el.getFirstName() + " " + el.getLastName());
        });
    }
}
