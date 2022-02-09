package site.metacoding.bubble.test;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * 
 * @author stuuu 플레이어의 역할 좌우 이동이 가능하다. 점프가 가능하다. 방울 발사. 부드러운 이동을 위해 Thread를
 *         사용한다.
 * 
 */
public class Player extends JLabel {

	private int x;
	private int y;
	private ImageIcon playerR;
	private ImageIcon playerL;
	private boolean isRight;
	private boolean isLeft;
	private boolean isJump; // 점프상태 Up, Down

	private static final int JUMPSPEED = 2; // 점프 속도
	private static final int SPEED = 4; // 플레이어 캐릭터의 이동속도

	// isRight와 isLeft에 Getter, Setter를 생성해준다.
	// isJump의 Getter, Setter를 생성해준다.

	public Player() {
		initObject();
		initSetting();
	}

	public boolean isRight() { // 생성된 isRight 의 Getter
		return isRight;
	}

	public void setRight(boolean isRight) { // 생성된 isRight 의 Setter
		this.isRight = isRight;
	}

	public boolean isLeft() { // 생성된 isLeft 의 Getter
		return isLeft;
	}

	public void setLeft(boolean isLeft) { // 생성된 isLeft 의 Setter
		this.isLeft = isLeft;
	}

	public boolean isJump() {// 생성된 isJump 의 Getter
		return isJump;
	}

	public void setJump(boolean isJump) { // 생성된 isJump 의 Setter
		this.isJump = isJump;
	}

	private void initObject() {
		playerR = new ImageIcon("image/playerR.png"); // 플레이어 우방향 이미지 삽입
		playerL = new ImageIcon("image/playerL.png"); // 플레이어 좌방향 이미지 삽입
	}

	private void initSetting() {
		x = 70; // 플레이어 캐릭터 호출 x좌표
		y = 535; // 플레이어 캐릭터 호출 y좌표
		setIcon(playerR); // 플레이어 캐릭터 이미지 삽입
		setSize(50, 50); // 플레이어 캐릭터 사이즈
		setLocation(x, y); // 플레이어 캐릭터 위치

		isRight = false; // 플레이어 캐릭터가 default는 움직이지 않고 있기 때문에 false를 넣어준다.
		isLeft = false; // 플레이어 캐릭터가 default는 움직이지 않고 있기 때문에 false를 넣어준다.
		isJump = false; // 플레이어 캐릭터가 default는 움직이지 않고 있기 때문에 false를 넣어준다.
	}

	public void right() {
		isRight = true; // isRight가 true이면 (즉, 우방향 키보드가 눌러지면)
		System.out.println("플레이어가 오른쪽으로 이동합니다.");
		setIcon(playerR); // 캐릭터 방향 이미지 : 오른쪽

		new Thread(() -> { // Thread 생성
			while (isRight) {
				x = x + SPEED; // 메서드가 실행되면 x가 SPEED만큼 증가한다.
				setLocation(x, y); // 해당 좌표로 위치 옮기기
				try {
					Thread.sleep(10); // 과부하를 막기위해 대기시간 걸어주기 0.01초. try-catch로 감싸준다.
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();

	} // 오른쪽 이동 종료

	public void left() {
		isLeft = true; // isLeft가 true이면 (즉, 좌방향 키보드가 눌러지면)
		System.out.println("플레이어가 왼쪽으로 이동합니다.");
		setIcon(playerL); // 캐릭터 방향 이미지 : 왼쪽

		new Thread(() -> { // Thread 생성
			while (isLeft) {
				x = x - SPEED; // 메서드가 실행되면 x가 SPEED만큼 감소한다.
				setLocation(x, y); // 해당 좌표로 위치 옮기기
				try {
					Thread.sleep(10); // 순간이동을 막기위해 대기시간 걸어주기 0.01초. try-catch로 감싸준다.
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();
	} // 왼쪽 이동 종료

	public void jump() {
		isJump = true;
		System.out.println("점프");

		new Thread(() -> {
			// UP 시작
			for (int i = 0; i < 130 / JUMPSPEED; i++) { // JUMPSPEED에 따라 높이가 달라지면 안된다.
				y = y - JUMPSPEED;
				setLocation(x, y);
				isJump = true; // 더블점프 방지

				try {
					Thread.sleep(5);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} // UP 종료

			// DOWN 시작
			for (int i = 0; i < 130 / JUMPSPEED; i++) { // JUMPSPEED에 따라 높이가 달라지면 안된다.
				y = y + JUMPSPEED;
				setLocation(x, y);
				isJump = true; // 더블점프 방지

				try {
					Thread.sleep(3);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			isJump = false; // 다운이 끝난 후점프기능 false 로 바꾼다.
		}).start();

	}
}
