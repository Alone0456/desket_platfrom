package tyut.selab.desktop.ui.todolist.listener;

import java.io.IOException;
import java.sql.SQLException;

public interface ActionDoneListener {

    void done(Object result) throws SQLException, IOException;
}
