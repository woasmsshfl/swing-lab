package site.metacoding.ex13;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class GridLayoutEx01 extends MyFrame {

	public GridLayoutEx01() {
		super(1000, 400);

		JPanel panel = (JPanel) getContentPane();
		panel.setLayout(new GridLayout());

		JButton btn1 = new JButton("��ư1");
		JButton btn2 = new JButton("��ư2");
		JButton btn3 = new JButton("��ư3");
		JButton btn4 = new JButton("��ư4");

		panel.add(btn1);
		panel.add(btn2);
		panel.add(btn3);
		panel.add(btn4);

		setVisible(true);

	}

	public static void main(String[] args) {
		new GridLayoutEx01();
	}

}