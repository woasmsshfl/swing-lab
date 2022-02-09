package site.metacoding.bubble.test;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * 
 * @author stuuu �÷��̾��� ���� �¿� �̵��� �����ϴ�. ������ �����ϴ�. ��� �߻�. �ε巯�� �̵��� ���� Thread��
 *         ����Ѵ�.
 * 
 */
public class Player extends JLabel {

	private int x;
	private int y;
	private ImageIcon playerR;
	private ImageIcon playerL;
	private boolean isRight;
	private boolean isLeft;
	private boolean isJump; // �������� Up, Down

	private static final int JUMPSPEED = 2; // ���� �ӵ�
	private static final int SPEED = 4; // �÷��̾� ĳ������ �̵��ӵ�

	// isRight�� isLeft�� Getter, Setter�� �������ش�.
	// isJump�� Getter, Setter�� �������ش�.

	public Player() {
		initObject();
		initSetting();
	}

	public boolean isRight() { // ������ isRight �� Getter
		return isRight;
	}

	public void setRight(boolean isRight) { // ������ isRight �� Setter
		this.isRight = isRight;
	}

	public boolean isLeft() { // ������ isLeft �� Getter
		return isLeft;
	}

	public void setLeft(boolean isLeft) { // ������ isLeft �� Setter
		this.isLeft = isLeft;
	}

	public boolean isJump() {// ������ isJump �� Getter
		return isJump;
	}

	public void setJump(boolean isJump) { // ������ isJump �� Setter
		this.isJump = isJump;
	}

	private void initObject() {
		playerR = new ImageIcon("image/playerR.png"); // �÷��̾� ����� �̹��� ����
		playerL = new ImageIcon("image/playerL.png"); // �÷��̾� �¹��� �̹��� ����
	}

	private void initSetting() {
		x = 70; // �÷��̾� ĳ���� ȣ�� x��ǥ
		y = 535; // �÷��̾� ĳ���� ȣ�� y��ǥ
		setIcon(playerR); // �÷��̾� ĳ���� �̹��� ����
		setSize(50, 50); // �÷��̾� ĳ���� ������
		setLocation(x, y); // �÷��̾� ĳ���� ��ġ

		isRight = false; // �÷��̾� ĳ���Ͱ� default�� �������� �ʰ� �ֱ� ������ false�� �־��ش�.
		isLeft = false; // �÷��̾� ĳ���Ͱ� default�� �������� �ʰ� �ֱ� ������ false�� �־��ش�.
		isJump = false; // �÷��̾� ĳ���Ͱ� default�� �������� �ʰ� �ֱ� ������ false�� �־��ش�.
	}

	public void right() {
		isRight = true; // isRight�� true�̸� (��, ����� Ű���尡 ��������)
		System.out.println("�÷��̾ ���������� �̵��մϴ�.");
		setIcon(playerR); // ĳ���� ���� �̹��� : ������

		new Thread(() -> { // Thread ����
			while (isRight) {
				x = x + SPEED; // �޼��尡 ����Ǹ� x�� SPEED��ŭ �����Ѵ�.
				setLocation(x, y); // �ش� ��ǥ�� ��ġ �ű��
				try {
					Thread.sleep(10); // �����ϸ� �������� ���ð� �ɾ��ֱ� 0.01��. try-catch�� �����ش�.
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();

	} // ������ �̵� ����

	public void left() {
		isLeft = true; // isLeft�� true�̸� (��, �¹��� Ű���尡 ��������)
		System.out.println("�÷��̾ �������� �̵��մϴ�.");
		setIcon(playerL); // ĳ���� ���� �̹��� : ����

		new Thread(() -> { // Thread ����
			while (isLeft) {
				x = x - SPEED; // �޼��尡 ����Ǹ� x�� SPEED��ŭ �����Ѵ�.
				setLocation(x, y); // �ش� ��ǥ�� ��ġ �ű��
				try {
					Thread.sleep(10); // �����̵��� �������� ���ð� �ɾ��ֱ� 0.01��. try-catch�� �����ش�.
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();
	} // ���� �̵� ����

	public void jump() {
		isJump = true;
		System.out.println("����");

		new Thread(() -> {
			// UP ����
			for (int i = 0; i < 130 / JUMPSPEED; i++) { // JUMPSPEED�� ���� ���̰� �޶����� �ȵȴ�.
				y = y - JUMPSPEED;
				setLocation(x, y);
				isJump = true; // �������� ����

				try {
					Thread.sleep(5);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} // UP ����

			// DOWN ����
			for (int i = 0; i < 130 / JUMPSPEED; i++) { // JUMPSPEED�� ���� ���̰� �޶����� �ȵȴ�.
				y = y + JUMPSPEED;
				setLocation(x, y);
				isJump = true; // �������� ����

				try {
					Thread.sleep(3);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			isJump = false; // �ٿ��� ���� ��������� false �� �ٲ۴�.
		}).start();

	}
}
