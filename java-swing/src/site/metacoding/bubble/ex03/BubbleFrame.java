package site.metacoding.bubble.ex03;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * 
 * @author stuuu ���� : ĳ���� �¿� �̵�
 *
 */

public class BubbleFrame extends JFrame {

	private JLabel backgroundMap;
	private Player player;

	public BubbleFrame() {
		initObject();
		initSetting();
		initListener();

		setVisible(true); // ���ο� paintComponent() ȣ�� �ڵ尡 �ִ�.
	}

	// new �ϴ� ��
	private void initObject() {
		backgroundMap = new JLabel(new ImageIcon("image/backgroundMap.png"));
		setContentPane(backgroundMap); // ��׶��� ��� ����

		player = new Player();
		add(player);
	}

	// ���� ��� ����
	private void initSetting() {
		setSize(1000, 640);
		getContentPane().setLayout(null); // null�� ��� absolute ���̾ƿ��� ��
		setLocationRelativeTo(null); // ��� ��ġ
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x��ư Ŭ���� JVM ���� �����ϱ�
	}

	private void initListener() {
		addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) { // Ű���带 ��������
				System.out.println("Ű���� ������");
			}

			@Override
			public void keyPressed(KeyEvent e) { // Ű���带 ��������
				// Ű�ڵ� : ���� 37, ������ 39, ���� 38, �Ʒ��� 40
				System.out.println("Ű���� ������ : " + e.getKeyCode());

				if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					player.right();
				}
				if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					player.left();
				}
			}
		});
	}

	public static void main(String[] args) {
		new BubbleFrame();
	}

}