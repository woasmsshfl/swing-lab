package site.metacoding.bubble.ex04;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * 
 * @author stuuu ���� : �������� �¿��̵�
 *
 */

public class BubbleFrame extends JFrame {

	private JLabel backgroundMap;
	private Player player; // JLabel

	public BubbleFrame() {
		initObject();
		initSetting();
		initListener();

		setVisible(true); // ���ο� paintComponent() ȣ�� �ڵ尡 �ִ�.
	}

	// new �ϴ� ��
	private void initObject() {
		backgroundMap = new JLabel(new ImageIcon("image/backgroundMap.png"));
		setContentPane(backgroundMap); // ��׶��� ȭ�� ����

		player = new Player(); // �÷��̾� �߰�
		add(player); // Frame�� �߰�
	}

	// ���� ��� ����
	private void initSetting() {
		setSize(1000, 640);
		getContentPane().setLayout(null); // null�� ��� absolute ���̾ƿ��� ��
		setLocationRelativeTo(null); // ��� ��ġ
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x��ư Ŭ���� JVM ���� �����ϱ�
	}

	// Ű����
	private void initListener() {
		addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) { // ������ ����
				System.out.println("Ű���� ������");

				if (e.getKeyCode() == KeyEvent.VK_RIGHT) { // int�ϱ� ==���� ��
					// isRight�� false
					player.setRight(false);
				} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					// isLeft�� false
					player.setLeft(false);
				}
			}

			@Override
			public void keyPressed(KeyEvent e) { // ������
				// �� 37, �� 39, �� 38, �Ʒ� 40
				// System.out.println("Ű���� ������ : " + e.getKeyCode());

				// �׷��� ���ؼ� ������ �ִ��� ������ ���� ������ Ȯ���ϴ� ���� ������ �ʿ��ϴ�.
				if (e.getKeyCode() == 39) { // int�ϱ� ==���� ��
					// Ű���带 ������ �ִ� ���� right() �޼���� �ѹ��� �����ϰ� �ʹ�.
					if (!player.isRight()) { // == false �� ����
						player.right(); // �̵��� �÷��̾��� å��
					}
				} else if (e.getKeyCode() == 37) {
					if (!player.isLeft()) {
						player.left();
					}
				}
			}
		});
	}

	public static void main(String[] args) {
		new BubbleFrame();
	}

}