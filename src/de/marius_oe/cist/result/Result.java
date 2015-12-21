package de.marius_oe.cist.result;

import de.marius_oe.cist.Util;

public class Result {

	private long bytesTransfered;
	private long endTime;
	private long startTime;

	/**
	 * The amount of bytes which are received in the speed-test.
	 * 
	 * @return amount of received bytes
	 */
	public long getBytesTransfered() {
		return bytesTransfered;
	}

	/**
	 * The time when the speed-test finished.
	 * 
	 * @return ending time
	 */
	public long getEndTime() {
		return endTime;
	}

	/**
	 * The time when the speed-test started.
	 * 
	 * @return starting time
	 */
	public long getStartTime() {
		return startTime;
	}

	/**
	 * Sets the amount of received bytes
	 * 
	 * @param bytesTransfered
	 *            amount of received bytes
	 */
	public void setBytesTransfered(long bytesTransfered) {
		this.bytesTransfered = bytesTransfered;
	}

	/**
	 * Sets the ending time
	 * 
	 * @param endTime
	 *            ending time
	 */
	public void setEndTime(long endTime) {
		this.endTime = endTime;
	}

	/**
	 * Sets the starting time
	 * 
	 * @param startTime
	 *            starting time
	 */
	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}

	@Override
	public String toString() {
		double durationSeconds = getDurationSeconds();
		double bytesPerSecond = getBytesPerSecond();
		return String.format("Transfered %s in %f seconds. Average speed: %s/sec", Util.humanReadableByteCount(bytesTransfered), durationSeconds,
				Util.humanReadableByteCount((long)bytesPerSecond));
	}

	public double getDurationSeconds() {
		return ((double)(endTime - startTime)) / 1000;
	}

	public double getBytesPerSecond() {
		return ((double)bytesTransfered) / getDurationSeconds();
	}
}
