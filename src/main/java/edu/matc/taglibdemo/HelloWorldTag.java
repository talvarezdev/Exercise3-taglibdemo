package edu.matc.taglibdemo;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class HelloWorldTag extends SimpleTagSupport {
    private int time;
    private int month;
    private int day;
    private String messageToDisplay =" ";


    @Override
    public void doTag() throws JspException, IOException {
        super.doTag();

        Calendar cal = Calendar.getInstance();

        SimpleDateFormat timeOfDay = new SimpleDateFormat("HH");
        SimpleDateFormat currentMonth = new SimpleDateFormat("MM");
        SimpleDateFormat currentDay = new SimpleDateFormat("dd");

        this.time = Integer.parseInt(timeOfDay.format(cal.getTime()));
        this.month = Integer.parseInt(currentMonth.format(cal.getTime()));
        this.day = Integer.parseInt(currentDay.format(cal.getTime()));
        this.messageToDisplay = " ";


        JspWriter out = getJspContext().getOut();
/*
        if (time > 4 && time < 12) {
            messageToDisplay += "Good Morning ";
        } else if ( time >= 12 && time < 17) {
            messageToDisplay += "Good Afternoon ";
        } else {
            messageToDisplay += "Good night ";
        }
*/
        checkTimeOfDay(time);

        checkHolidayMessage(month, day);

        out.println(messageToDisplay);
    }

    private void checkTimeOfDay(int time) {
        if (time > 4 && time < 12) {
            messageToDisplay += "Good Morning ";
           /* out.println("Good Morning Sunshine"); */
        } else if ( time >= 12 && time < 17) {
            messageToDisplay += "Good Afternoon ";
           /* out.println("Good Afternoon my friend"); */
        } else {
            messageToDisplay += "Good night ";
        }
    }

    private void checkHolidayMessage(int month, int day) {

        this.month = month;
        this.day = day;

        if (month == 10 && day == 31) {
        messageToDisplay += "and Happy Halloween!";
        }
        }
}
