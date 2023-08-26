































package Game;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
public class Game implements ActionListener{
	Random random=new Random();
	JFrame frame=new JFrame();
	JPanel title_panel=new JPanel();
	JPanel button_panel=new JPanel();
	JLabel textfield=new JLabel();
	JLabel text=new JLabel();
	JButton[] buttons=new JButton[9];
	boolean player1_turn;
	boolean player2_turn;
	
	Game(){
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800,800);
		frame.getContentPane().setBackground(new Color(50,50,50));
		//frame.getContentPane().setBackground(Color.red);
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);
		
		
		textfield.setBackground(Color.black);
		textfield.setForeground(Color.yellow);
		textfield.setFont(new Font("",Font.BOLD,75));
		textfield.setHorizontalAlignment(JLabel.CENTER);
		textfield.setText("TIC-TAC-TOE");
		textfield.setOpaque(true);
		
		
		title_panel.setLayout(new BorderLayout());
		title_panel.setBounds(0,0,800,100);
		
		button_panel.setLayout(new GridLayout(3,3));
		button_panel.setBackground(Color.BLACK);
		
		for(int i=0;i<9;i++) {
			buttons[i]=new JButton();
			button_panel.add(buttons[i]);
			buttons[i].setFont(new Font("ink free",Font.BOLD,120));
			buttons[i].setFocusable(false);
			buttons[i].addActionListener(this);
		}

		
		title_panel.add(textfield);
		frame.add(title_panel,BorderLayout.NORTH);
		
		frame.add(button_panel);
		
		firstTurn();

		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		for(int i=0;i<9;i++) {
			if(e.getSource()==buttons[i]) {
				if(player1_turn) {
					if(buttons[i].getText()=="") {
						buttons[i].setForeground(Color.RED);
						buttons[i].setText("X");
						player1_turn=false;
						textfield.setText("O TURN");
						check();
					}
				}
				else {
					if(buttons[i].getText()=="") {
						buttons[i].setForeground(Color.BLACK);
						buttons[i].setText("0");
						player1_turn=true;
						textfield.setText("X TURN");
						check();
					}
				}
			}
			}
		}
		

	public void firstTurn() {
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(random.nextInt(2)==0) {
			player1_turn=true;
			textfield.setText("X turn");
		}
		else {
			player1_turn=false;
			textfield.setText("o turn");
		}
		
	}

	public void check() {
		//check X wins
		if((buttons[0].getText()=="X")&& (buttons[1].getText()=="X")&& (buttons[2].getText()=="X")) {
			xWins(0,1,2);
		}
		else if((buttons[3].getText()=="X")&& (buttons[4].getText()=="X")&& (buttons[5].getText()=="X")) {
			xWins(3,4,5);
		}
		else if((buttons[6].getText()=="X")&& (buttons[7].getText()=="X")&& (buttons[8].getText()=="X")) {
			xWins(6,7,8);
		}
		else if((buttons[0].getText()=="X")&& (buttons[3].getText()=="X")&& (buttons[6].getText()=="X")) {
			xWins(0,3,6);
		}
		else if((buttons[1].getText()=="X")&& (buttons[4].getText()=="X")&& (buttons[7].getText()=="X")) {
			xWins(1,4,7);
		}
		else if((buttons[2].getText()=="X")&& (buttons[5].getText()=="X")&& (buttons[8].getText()=="X")) {
			xWins(2,5,8);
		}
		if((buttons[0].getText()=="X")&& (buttons[4].getText()=="X")&& (buttons[8].getText()=="X")) {
			xWins(0,4,8);
		}
		if((buttons[2].getText()=="X")&& (buttons[4].getText()=="X")&& (buttons[6].getText()=="X")) {
			xWins(2,4,6);
		}
		
		//check 0 wins
		if((buttons[0].getText()=="o")&& (buttons[1].getText()=="o")&& (buttons[2].getText()=="o")) {
			oWins(0,1,2);
		}
		if((buttons[3].getText()=="o")&& (buttons[4].getText()=="o")&& (buttons[5].getText()=="o")) {
			oWins(3,4,5);
		}
		if((buttons[6].getText()=="o")&& (buttons[7].getText()=="o")&& (buttons[8].getText()=="o")) {
			oWins(6,7,8);
		}
		if((buttons[0].getText()=="o")&& (buttons[3].getText()=="o")&& (buttons[6].getText()=="o")) {
			oWins(0,3,6);
		}
		if((buttons[1].getText()=="o")&& (buttons[4].getText()=="o")&& (buttons[7].getText()=="o")) {
			oWins(1,4,7);
		}
		if((buttons[2].getText()=="o")&& (buttons[5].getText()=="o")&& (buttons[8].getText()=="o")) {
			oWins(2,5,8);
		}
		if((buttons[0].getText()=="o")&& (buttons[4].getText()=="o")&& (buttons[8].getText()=="o")) {
			oWins(0,4,8);
		}
		if((buttons[2].getText()=="o")&& (buttons[4].getText()=="o")&& (buttons[6].getText()=="o")) {
			oWins(2,4,6);
		}
		
		
		
	}
	public void xWins(int a,int b,int c) {
		buttons[a].setBackground(Color.GREEN);
		buttons[b].setBackground(Color.GREEN);
		buttons[c].setBackground(Color.GREEN);
		for(int i=0;i<9;i++) {
			buttons[i].setEnabled(false);
		}
	
		textfield.setText("CONGRATS");
		
		
	}
	public void oWins(int x,int y,int z) {
		buttons[x].setBackground(Color.GREEN);
		buttons[y].setBackground(Color.GREEN);
		buttons[z].setBackground(Color.GREEN);
		for(int i=0;i<9;i++) {
			buttons[i].setEnabled(false);
		}
		textfield.setText("o WINS");
		textfield.setText("CONGRATS");
		
		
	}

	

}
