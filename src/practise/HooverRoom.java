package practise;

public class HooverRoom {

	private int length;
	private int breadth;
	private int[][] dimensionMatrix;
	private String roomName;

	public HooverRoom(int l, int b) {
		length = l;
		breadth = b;
		dimensionMatrix = new int[length][breadth];
	}

	public void setLength(int l) {
		length = l;
	}

	public int getLength() {
		return length;
	}

	public void setBreadth(int b) {
		breadth = b;
	}

	public int getBreadth() {
		return breadth;
	}

	public void setRoomName(String room_name) {
		roomName = room_name;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setDirtySpot(int x, int y) {
		dimensionMatrix[(length - 1) - x][(breadth - 1) - y] = 1;
	}

	public void setCleanSpot(int x, int y) {
		dimensionMatrix[(length - 1) - x][(breadth - 1) - y] = 0;
	}

	public boolean isSpotClean(int x, int y) {
		if (dimensionMatrix[(length - 1) - x][(breadth - 1) - y] == 1) {
			return false;
		} else {
			return true;
		}
	}

	// To add functionality of adding and retrieving previously saved rooms in RoomList
	@Override
	public boolean equals(Object obj) {
		boolean retVal = false;

		if (obj instanceof HooverRoom) {
			if (((HooverRoom) obj).roomName.equals(this.roomName)) {
				retVal = true;
			}
		}

		return retVal;
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 13 * hash
				+ (this.roomName != null ? this.roomName.hashCode() : 0);
		return hash;
	}

}
