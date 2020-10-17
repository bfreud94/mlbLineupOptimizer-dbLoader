package mlbLineupOptimizer.service;

import java.util.Date;
import java.util.TimerTask;

public class CronService extends TimerTask {
    
    @Override
    public void run() {
        System.out.println(new Date());
    }
}
