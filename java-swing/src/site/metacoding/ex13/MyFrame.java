package site.metacoding.ex13;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

// �ڵ����� : Ctrl + Shift + F
// Import : Ctrl + Shift + O
public class MyFrame extends JFrame {
	public MyFrame() {
		super(); // �����Ǿ�����.
		System.out.print("MyFrame ����Ʈ ������");
		setSize(600, 400); // �������� width, height ũ�⼳��
		setLocationRelativeTo(null); // ����� ������ ȭ�� �߾� ��ġ
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x��ư Ŭ���� main ����
	}

	public MyFrame(int w, int h) {
		super(); // �����Ǿ�����.
		System.out.print("MyFrame �����ε��� ������");
		setSize(w, h); // �������� width, height ũ�⼳��
		setLocationRelativeTo(null); // ����� ������ ȭ�� �߾� ��ġ
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x��ư Ŭ���� main ����
	}
}