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
import java.util.List;

public class RequestCmd extends Command {

    private static final long serialVersionUID = 7732235467234L;

    private static final Logger LOG = Logger.getLogger(RequestCmd.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, AppException {
        LOG.debug("Command starts");
        // get user cards list
        List<Card> cards = DBManager.getInstance().getCardsWithRequest();

        //  users.sort((o1, o2) -> (int) (o1.getId() - o2.getId()));
        LOG.trace("Found in DB: cardsList --> " + cards);

        request.setAttribute("cards", cards);

        LOG.trace("Set the request attribute: cards --> " + cards);

        LOG.debug("Command finished");
        return Path.PAGE_REQUEST;
    }
}
