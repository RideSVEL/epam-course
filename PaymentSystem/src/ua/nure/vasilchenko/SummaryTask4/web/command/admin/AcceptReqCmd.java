package ua.nure.vasilchenko.SummaryTask4.web.command.admin;

import org.apache.log4j.Logger;
import ua.nure.vasilchenko.SummaryTask4.Path;
import ua.nure.vasilchenko.SummaryTask4.db.DBManager;
import ua.nure.vasilchenko.SummaryTask4.db.entity.Card;
import ua.nure.vasilchenko.SummaryTask4.exception.AppException;
import ua.nure.vasilchenko.SummaryTask4.web.command.base.Command;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class AcceptReqCmd extends Command {

    private static final long serialVersionUID = 77288888755558505L;

    private static final Logger LOG = Logger.getLogger(UnblockCardCmd.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, AppException {
        LOG.debug("Command starts");
        DBManager manager = DBManager.getInstance();
        String id = request.getParameter("card_id");
        Card card = manager.findCard(Integer.parseInt(id));
        card.setActivityId(0);
        card.setRequestId(0);
        try {
            manager.updateCard(card);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        LOG.debug("Command finished");
        return Path.COMMAND_REQUEST;
    }
}
