package MazeGame;

import java.awt.Image;
import java.io.File;
import java.util.Scanner;

import javax.swing.ImageIcon;

public class Map {
	private Scanner m;
	public static final Integer mazeSize = 30;
	public String Map[] = new String[mazeSize];
	private Image floor, wall, coin, end;
	public String path = "C:/MazeGame/TwoPlayerMazeGame/TwoPlayerMazeGame/Resources/";

	public Map() {
		ImageIcon img = new ImageIcon(path + "floor.png");
		floor = img.getImage();

		img = new ImageIcon(path + "wall_Grass.png");
		wall = img.getImage();

		img = new ImageIcon(path + "coin.gif");
		coin = img.getImage();

		openFile();
		readFile();
		closeFile();
	}

	public Image getFloor() {
		return floor;
	}

	public Image getWall() {
		return wall;
	}

	public Image getCoin() {
		return coin;
	}

	public Image getEnd() {
		return end;
	}

	public String getMap(int x, int y) {
		String index = Map[y].substring(x, x + 1);
		return index;
	}

	public boolean isWall(int x, int y) {
		if (getMap(x, y).equals(Board.wallCharacter)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isCoin(int x, int y) {
		if (getMap(x, y).equals(Board.coinCharacter)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isFloor(int x, int y) {
		if (getMap(x, y).equals(Board.floorCharacter)) {
			return true;
		} else {
			return false;
		}
	}

	public void openFile() {
		try {
			m = new Scanner(new File(path + "map_easy.txt"));
			System.out.println(m);
		} catch (Exception e) {
			System.out.println("error loading map" + e + m);
		}
	}

	public void readFile() {
		while (m.hasNext()) {
			for (int i = 0; i < mazeSize; i++) {
				Map[i] = m.next();
			}
		}
	}

	public void setTile(int x, int y, String tile) {
		char[] data = Map[y].toCharArray();
		data[x] = tile.toCharArray()[0];
		Map[y] = String.copyValueOf(data);
	}

	public void closeFile() {
	}
}
