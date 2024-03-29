package KINTalk;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener{
	//선언부
	String imgPath = "D:\\KIN톡\\workspace_KINTalk\\dev_java\\src\\KINTalk\\";
	ImageIcon ig = new ImageIcon(imgPath+"");//로그인화면 배경화면 이미지 삽입 "main.PNG"
	//폰트 추가하기
	Font font = new Font("휴먼모음T",Font.BOLD,22);
	//아이디와 패스워드 라벨추가하기
	JLabel jlb_id 		= new JLabel("아이디");
	JTextField jtf_id 	= new JTextField("");
	JLabel jlb_pw 		= new JLabel("비밀번호");
	JPasswordField jpf_pw = new JPasswordField("");
	JButton jbtn_login 	= new JButton("로그인");//이미지 삽입 new ImageIcon(imgPath+"login.png")
	JButton jbtn_create	= new JButton("회원가입");//이미지 삽입 new ImageIcon(imgPath+"confirm.png")
	String nickName = null; 
//	TalkClient tc2 = null;
	
	//생성자
	
	//화면처리부
	private void initDisplay() {
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setSize(375,667);
		this.setVisible(true);
		this.setTitle("KINTALK");
		this.setLocation(700, 250);
		this.setLayout(null);
		jlb_id.setBounds(45, 350, 80, 40);
		jtf_id.setBounds(130, 350, 165, 40);
		jlb_id.setFont(font);
		jlb_pw.setBounds(45, 400, 80, 40);
		jpf_pw.setBounds(130, 400, 165, 40);
		jlb_pw.setFont(font);
		jbtn_login.setBounds(45, 450, 120, 40);
		jbtn_create.setBounds(175, 450, 120, 40);
		this.add(jlb_id);
		this.add(jtf_id);
		this.add(jlb_pw);
		this.add(jpf_pw);
		this.add(jbtn_login);
		this.add(jbtn_create);
	}//end of initDisplay();
	public void login() {
		//사용자가 입력한 아이디와 비밀번호 담기
		String mem_id = jtf_id.getText();
		String mem_pw = jpf_pw.getText();
		if(mem_id==null&&mem_id.length()==0) {
			JOptionPane.showMessageDialog(this, "아이디를 입력하세요");
			return;
		}else if(mem_pw==null&&mem_pw.length()==0) {
			JOptionPane.showMessageDialog(this, "비밀번호를 입력하세요");
			return;
		}
		ChatDao cDao = new Chatdao();
		nickName = cDao.login(mem_id, mem_pw);
		if("실패".equals(nickName)) {//"실패" procedure 결과값 확인
			JOptionPane.showMessageDialog(this, "아이디와 비밀번호를 확인하세요");
		}else {//성공한 경우
			JOptionPane.showMessageDialog(this, nickName+"님 환영합니다");
			this.setVisible(false);
			jtf_id.setText("");
			jpf_pw.setText("");
//			tc2 = new TalkClient(this);
		}
	}//end of login()
	//메인메소드
	public static void main(String[] args) {
		new Login().initDisplay();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj==jbtn_login) {
			login();
		}else if(obj==jbtn_create) {
			
		}
		
	}
	//내부클래스 - JPanel이미지를 입히기
	class myPanel extends JPanel{
		public void paintComponent(Graphics g) {
			g.drawImage(ig.getImage(), 0, 0, null);
			setOpaque(false);
			super.paintComponent(g);
		}
	}
}
