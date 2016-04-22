package practise;

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class HooverApp {

	Hoover hoover;
	List roomList; // To save the room's configuration and to retrieve a
					// previously saved room.
	char[] commandArray; // To save the Navigation Commands
	HooverRoom currentRoom;

	public HooverApp() {
		hoover = new Hoover();
		roomList = new LinkedList<HooverRoom>();
	}

	public static void main(String[] args) {
		HooverApp hooverBot = new HooverApp();
		System.out.println("-----Your Hoover Bot has been initialised successfully------");
		try {
			Scanner console = new Scanner(System.in);
			System.out.println("To start using your Hoover, please enter the path of commands file:");
			String path = console.nextLine();
			console.close();

			console = new Scanner(new File(path));
			int lineCount = 0;
			while (console.hasNextLine()) {
				String line = console.nextLine();
				if (lineCount == 0) {
					String[] strArray = line.split(" ");
					hooverBot.currentRoom = new HooverRoom(
							Integer.parseInt(strArray[0]),
							Integer.parseInt(strArray[1]));
					hooverBot.hoover.setCurrentRoom("room1");
					hooverBot.currentRoom.setRoomName("room1");
					lineCount++;
				} else if (lineCount == 1) {
					String[] strArray = line.split(" ");
					hooverBot.hoover.setHooverPosition(
							Integer.parseInt(strArray[0]),
							Integer.parseInt(strArray[1]));
					lineCount++;
				} else {
					if (!(line.toUpperCase().contains("N")
							|| line.toUpperCase().contains("S")
							|| line.toUpperCase().contains("E") || line
							.toUpperCase().contains("W"))) {
						String[] strArray = line.split(" ");
						hooverBot.currentRoom.setDirtySpot(
								Integer.parseInt(strArray[0]),
								Integer.parseInt(strArray[1]));
					} else {
						hooverBot.commandArray = line.toUpperCase()
								.toCharArray();
					}
				}
			}
			console.close();
		} catch (FileNotFoundException ex) {
			System.out.println("Command File Not found.");
			return;
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}

		for (char c : hooverBot.commandArray) {
			int[] hooverPosition;
			switch (c) {
			case 'N':
				hooverPosition = hooverBot.hoover.getHooverPosition();
				if (hooverPosition[1] + 1 < hooverBot.currentRoom.getBreadth()) {
					if (!(hooverBot.currentRoom.isSpotClean(hooverPosition[0],
							hooverPosition[1] + 1))) {
						hooverBot.currentRoom.setCleanSpot(hooverPosition[0],
								hooverPosition[1] + 1);
						hooverBot.hoover.incrementCleanedSpots();
						hooverBot.hoover.setHooverPosition(hooverPosition[0],
								hooverPosition[1] + 1);
					} else
						hooverBot.hoover.setHooverPosition(hooverPosition[0],
								hooverPosition[1] + 1);
				}
				break;

			case 'S':
				hooverPosition = hooverBot.hoover.getHooverPosition();
				if (hooverPosition[1] - 1 >= 0) {
					if (!(hooverBot.currentRoom.isSpotClean(hooverPosition[0],
							hooverPosition[1] - 1))) {
						hooverBot.currentRoom.setCleanSpot(hooverPosition[0],
								hooverPosition[1] - 1);
						hooverBot.hoover.incrementCleanedSpots();
						hooverBot.hoover.setHooverPosition(hooverPosition[0],
								hooverPosition[1] - 1);
					} else
						hooverBot.hoover.setHooverPosition(hooverPosition[0],
								hooverPosition[1] - 1);
				}
				break;

			case 'E':
				hooverPosition = hooverBot.hoover.getHooverPosition();
				if (hooverPosition[0] + 1 < hooverBot.currentRoom.getLength()) {
					if (!(hooverBot.currentRoom.isSpotClean(
							hooverPosition[0] + 1, hooverPosition[1]))) {
						hooverBot.currentRoom.setCleanSpot(
								hooverPosition[0] + 1, hooverPosition[1]);
						hooverBot.hoover.incrementCleanedSpots();
						hooverBot.hoover.setHooverPosition(
								hooverPosition[0] + 1, hooverPosition[1]);
					} else
						hooverBot.hoover.setHooverPosition(
								hooverPosition[0] + 1, hooverPosition[1]);
				}
				break;

			case 'W':
				hooverPosition = hooverBot.hoover.getHooverPosition();
				if (hooverPosition[0] - 1 >= 0) {
					if (!(hooverBot.currentRoom.isSpotClean(
							hooverPosition[0] - 1, hooverPosition[1]))) {
						hooverBot.currentRoom.setCleanSpot(
								hooverPosition[0] - 1, hooverPosition[1]);
						hooverBot.hoover.incrementCleanedSpots();
						hooverBot.hoover.setHooverPosition(
								hooverPosition[0] - 1, hooverPosition[1]);
					} else
						hooverBot.hoover.setHooverPosition(
								hooverPosition[0] - 1, hooverPosition[1]);
				}
				break;
			}
			hooverPosition = null;
		}
		hooverBot.roomList.add(hooverBot.currentRoom);

		System.out.println("Current position of your Hoover in "
				+ hooverBot.hoover.getCurrentRoom() + " : "
				+ hooverBot.hoover.printHooverPosition());

		System.out.println("Number of patches cleaned : "
				+ hooverBot.hoover.getNumCleanedSpots());
	}

}
