package ru.otus.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * ava -jar $JETTY_HOME/start.jar jetty.http.port=8080
 */

public class TimerServlet extends HttpServlet {

    private static final String REFRESH_VARIABLE_NAME = "refreshPeriod";
    private static final String TIME_VARIABLE_NAME = "time";
    private static final String TIMER_PAGE_TEMPLATE = "timer.html";

    private static final int PERIOD_MS = 1000;

    private final TimeServiceSingleton timeService = TimeServiceSingleton.instance();

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws ServletException, IOException {
        Map<String, Object> pageVariables = new HashMap<>();
        pageVariables.put(REFRESH_VARIABLE_NAME, String.valueOf(PERIOD_MS));
        pageVariables.put(TIME_VARIABLE_NAME, timeService.getTime());

        response.setContentType("text/html;charset=utf-8");
        response.getWriter().println(TemplateProcessor.instance().getPage(TIMER_PAGE_TEMPLATE, pageVariables));
        response.setStatus(HttpServletResponse.SC_OK);
    }


}
