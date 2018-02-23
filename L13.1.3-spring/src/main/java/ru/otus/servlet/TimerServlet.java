package ru.otus.servlet;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TimerServlet extends HttpServlet {

    private static final String REFRESH_VARIABLE_NAME = "refreshPeriod";
    private static final String TIME_VARIABLE_NAME = "time";
    private static final String TIMER_PAGE_TEMPLATE = "timer.html";

    private static final int PERIOD_MS = 1000;

    private TimeService timeService;

    public void init() {
        //TODO: Create one context for the application. Inject beans.
        ApplicationContext context = new ClassPathXmlApplicationContext("SpringBeans.xml");
        timeService = (TimeService) context.getBean("timeService");
    }

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
