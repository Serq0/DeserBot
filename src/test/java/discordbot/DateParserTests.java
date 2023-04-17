package discordbot;

import io.github.serq0.discordbot.DateParser;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration
@TestPropertySource(locations = "classpath:bot.properties")
public class DateParserTests {
    @Autowired
    private Environment env;

    @Test
    public void parseDateTest() {
        DateParser dateParser = new DateParser();
        dateParser.setDateFormat(env.getProperty("bot.dateFormat"));

        //yyyy-MM-dd HH:mm:ss
        String dateString = "2020-03-04 15:20:00";
        Date date = dateParser.getDateFromString(dateString);
        assertNotNull(date);

        dateString = "2020-03-04";
        date = dateParser.getDateFromString(dateString);
        assertNull(date);
    }

    @Test
    public void getCalendarTest() {
        DateParser dateParser = new DateParser();
        dateParser.setDateFormat(env.getProperty("bot.dateFormat"));

        //yyyy-MM-dd HH:mm:ss
        String dateString = "2020-03-04 15:25:54";
        Calendar calendar = dateParser.getCalendarFromString(dateString);

        assertEquals(2020, calendar.get(Calendar.YEAR));
        assertEquals(3 - 1, calendar.get(Calendar.MONTH));
        assertEquals(4, calendar.get(Calendar.DAY_OF_MONTH));
        assertEquals(15, calendar.get(Calendar.HOUR_OF_DAY));
        assertEquals(25, calendar.get(Calendar.MINUTE));
        assertEquals(54, calendar.get(Calendar.SECOND));
    }
}
