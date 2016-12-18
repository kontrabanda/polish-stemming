public class TimeLogger {
	private long startTime;
	private long endTime;

	public void start() {
		startTime = System.currentTimeMillis();
	}

	public void end() {
		endTime = System.currentTimeMillis();
	}

	public double getMilliseconds() {
		return endTime - startTime;
	}

	public double getSeconds() {
		return getMilliseconds()/1000;
	}

	public double getMinutes() {
		return getSeconds()/60;
	}

	public double getHours() {
		return getMinutes()/60;
	}

	public void printFullTime() {
		System.out.println(getMilliseconds() + " milliseconds");
		System.out.println(getSeconds() + " seconds");
		System.out.println(getMinutes() + " minutes");
		System.out.println(getHours() + " hours");
	}
}