
public class ClockAnimateThread extends Thread {

	private ClockPanel theClock;
	private int pauseTime;

	public ClockAnimateThread(ClockPanel cp, int pause) {
		pauseTime = pause;
		theClock = cp;
	}

	public void run() {

		while (true) {
            try {
				Thread.sleep(pauseTime/60);
			} catch (InterruptedException e) {
				e.printStackTrace();
            }
            
			theClock.bumpTime();
		}

	}

}
