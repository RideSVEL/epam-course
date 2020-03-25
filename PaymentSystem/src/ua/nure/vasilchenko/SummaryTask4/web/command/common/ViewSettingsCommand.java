package ua.nure.vasilchenko.SummaryTask4.web.command.common;

import org.apache.log4j.Logger;
import ua.nure.vasilchenko.SummaryTask4.Path;
import ua.nure.vasilchenko.SummaryTask4.web.command.base.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * View settings command.
 * 
 * @author D.Kolesnikov
 * 
 */
public class ViewSettingsCommand extends Command {
	
	private static final long serialVersionUID = -3071536593627692473L;
	
	private static final Logger LOG = Logger.getLogger(ViewSettingsCommand.class);
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {		
		LOG.debug("Command starts");

		LOG.debug("Command finished");
		return Path.PAGE_SETTINGS;
	}

}