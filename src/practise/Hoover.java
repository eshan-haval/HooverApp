package practise;

//import java.util.Timer;
//import java.util.TimerTask;

public class Hoover {

	private int numCleanedSpots;
	private PositionCoordinates positionCoords;
	// private int remainingPower;
	// boolean pluggedIn;
	// Timer timer;
	private String currentRoom;

	public Hoover() {
		numCleanedSpots = 0;
		positionCoords = new PositionCoordinates(0, 0);
		// remainingPower = 0; if it reaches 0, tells user to recharge the Hoover
		// pluggedIn = false;
	}

	public Hoover(int stepcount, int xcoordinate, int ycoordinate) {
		numCleanedSpots = 0;
		positionCoords = new PositionCoordinates(xcoordinate, ycoordinate);
		// remainingPower = 0;
		// pluggedIn = false;
	}

	public void setCurrentRoom(String room) {
		currentRoom = room;
	}

	public String getCurrentRoom() {
		return currentRoom;
	}

	public void incrementCleanedSpots() {
		numCleanedSpots++;
	}

	public int getNumCleanedSpots() {
		return numCleanedSpots;
	}

	public void resetNumCleanedSpots() {
		numCleanedSpots = 0;
	}

	public int[] getHooverPosition() {
		return new int[] { positionCoords.getXCordinate(),
				positionCoords.getYCordinate() };
	}

	public String printHooverPosition() {
		return positionCoords.getXCordinate() + " "
				+ positionCoords.getYCordinate();
	}

	public void setHooverPosition(int x, int y) {
		positionCoords.setPositionCoordinates(x, y);
	}

	/*
	 * public int getRemainingPower(){ return remainingPower; }
	 * 
	 * public int reducePower(){ remainingPower--; }
	 * 
	 * public void plugInHoover(){ pluggedIn = true; }
	 * 
	 * public void plugOutHoover(){ pluggedIn = false; }
	 * 
	 * public void rechargeHoover(){ while(pluggedIn){ timer = new Timer();
	 * timer.schedule(new RechargePowerTask(), 500000); } }
	 * 
	 * public Class RechargePowerTask extends TimerTask { public void run(){
	 * remainingPower++; } }
	 */

	class PositionCoordinates {
		int x;
		int y;

		public PositionCoordinates() {
			x = 0;
			y = 0;
		}

		public PositionCoordinates(int xcord, int ycord) {
			x = xcord;
			y = ycord;
		}

		public void setPositionCoordinates(int xcord, int ycord) {
			x = xcord;
			y = ycord;
		}

		public int getXCordinate() {
			return x;
		}

		public int getYCordinate() {
			return y;
		}
	}
}
