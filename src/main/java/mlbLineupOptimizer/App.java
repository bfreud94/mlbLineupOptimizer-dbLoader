package mlbLineupOptimizer;

import java.util.Calendar;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

import mlbLineupOptimizer.service.CronService;

public class App {

    public static void main(String[] args) {
        Timer timer = new Timer();
        
        Calendar today = Calendar.getInstance();
        today.set(Calendar.HOUR_OF_DAY, 00);
        today.set(Calendar.MINUTE, 11);
        today.set(Calendar.SECOND, 00);

        CronService service = new CronService();
        timer.schedule(service, today.getTime(), TimeUnit.MILLISECONDS.convert(1, TimeUnit.DAYS));
    }
}
