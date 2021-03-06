package site.metacoding.bubble.ex03;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * 
 * @author stuuu 플레이어는 좌우 이동이 가능하다. 점프가 가능하다. 방울 발사 (나중에 생각하자)
 */

public class Player extends JLabel {

	private int x;
	private int y;
	private ImageIcon playerR;
	private ImageIcon playerL;

	public Player() {
		initObject();
		initSetting();
	}

	private void initObject() {
		playerR = new ImageIcon("image/playerR.png");
		playerL = new ImageIcon("image/playerL.png");
	}

	private void initSetting() {
		x = 70;
		y = 535;
		setIcon(playerR);
		setSize(50, 50);
		setLocation(x, y);
	}

	public void left() {
		System.out.println("왼쪽 이동");
		x = x - 10;
		setLocation(x, y);
		setIcon(playerL);
	}

	public void right() {
		System.out.println("오른쪽 이동");
		x = x + 10;
		setLocation(x, y);
		setIcon(playerR);
	}
}
