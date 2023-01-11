package alexiil.mc.mod.load.frame;

import alexiil.mc.mod.load.progress.SingleProgressBarTracker;
import com.mio.customsplash.MioCustomSplash;
import com.mio.customsplash.MioModBridge;

import java.util.Timer;
import java.util.TimerTask;

public class FrameDisplayer {
//    public final LoadingFrame frame;
    private Timer timer;

    public FrameDisplayer() {
//        frame = LoadingFrame.openWindow();
    }

    public void start() {
//        if (frame == null) {
//            return;
//        }
        Timer t = new Timer("updater");
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
//                MioCustomSplash.logger.info("TimerTask running!");
                setProgress();
            }
        };
        t.schedule(task, 0, 10);
    }
    public void setProgress() {
        String status;
        String subStatus;
        int progress;
        boolean isInReload;
        try (SingleProgressBarTracker.LockUnlocker u = SingleProgressBarTracker.lockUpdate()) {
            status = SingleProgressBarTracker.getStatusText();
            subStatus = SingleProgressBarTracker.getSubStatus();
            progress = SingleProgressBarTracker.getProgress();
            isInReload = SingleProgressBarTracker.isInReload();
        }
        MioModBridge.sendStatus((isInReload ? status : (status + " - " + subStatus) + "  "));
        double p = progress / SingleProgressBarTracker.MAX_PROGRESS_D;
        MioModBridge.sendProgress((int) (p * 100));
        if((int) (p * 100)==100){
            finish();
        }
    }
    public void finish() {
        if (timer != null) {
            timer.cancel();
        }
        MioModBridge.stop();
//        if (frame != null) {
//            frame.dispose();
//        }
    }
}
