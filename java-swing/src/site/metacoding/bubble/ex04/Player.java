package site.metacoding.bubble.ex04;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * 
 * @author stuuu �÷��̾�� �¿��̵��� �����ϴ�. ������ �����ϴ�. ��� �߻縦 �Ѵ�.(���߿� ��������) x, y ��ǥ �ʿ�
 *         x��ǥ�� �¿� �̵� y��ǥ�� ����
 *
 */

public class Player extends JLabel {

	private int x;
	private int y;

	private ImageIcon playerR; // �������� �����ִ� pR
	private ImageIcon playerL; // ������ �����ִ� pL

	private boolean isRight; // ���� boolean ���� �̸����� is�� ����
	private boolean isLeft;

	// �ڹ��� Ư¡ : is�� ���� boolean ������ getIsRight�� �ƴ� isRight��� �̸��� ����
	public boolean isRight() {
		return isRight;
	}

	// �ڹ��� Ư¡ : is�� ���� boolean ������ setIsRight�� �ƴ� setRight��� �̸��� ����
	public void setRight(boolean isRight) {
		this.isRight = isRight;
	}

	public boolean isLeft() {
		return isLeft;
	}

	public void setLeft(boolean isLeft) {
		this.isLeft = isLeft;
	}

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
		setLocation(x, y); // paintComponent ȣ������, �κ� ���ΰ�ħ

		isRight = false;
		isLeft = false;
	}

	// �ϳ��� ���� å���� ���� �޼���, �޼��� ���
	public void right() {
		isRight = true;

		System.out.println("������ �̵�");

		setIcon(playerR);

		new Thread(() -> {
			while (isRight) {
				x = x + 10;
				setLocation(x, y);
				try {
					Thread.sleep(10);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();

	}

	// �ܺο��� ȣ�� �����ϰ�
	public void left() {
		isLeft = true;

		System.out.println("���� �̵�");

		setIcon(playerL);

		new Thread(() -> {
			while (isLeft) {
				x = x - 10;
				setLocation(x, y);
				try {
					Thread.sleep(10);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();

	}
}