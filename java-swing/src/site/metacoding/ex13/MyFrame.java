package site.metacoding.ex13;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

// 자동정렬 : Ctrl + Shift + F
// Import : Ctrl + Shift + O
public class MyFrame extends JFrame {
	public MyFrame() {
		super(); // 생략되어있음.
		System.out.print("MyFrame 디폴트 생성자");
		setSize(600, 400); // 프레임의 width, height 크기설정
		setLocationRelativeTo(null); // 실행시 프레임 화면 중앙 배치
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x버튼 클릭시 main 종료
	}

	public MyFrame(int w, int h) {
		super(); // 생략되어있음.
		System.out.print("MyFrame 오버로딩된 생성자");
		setSize(w, h); // 프레임의 width, height 크기설정
		setLocationRelativeTo(null); // 실행시 프레임 화면 중앙 배치
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x버튼 클릭시 main 종료
	}
}