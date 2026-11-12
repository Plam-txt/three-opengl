package psn.Main.Window;

import psn.Main.Out.LogWin_l;
import psn.Main.Settings;
import psn.Main.command.Terminal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TerminalWindow { /// as TW
static JFrame frame =  new JFrame(Settings.TW_Title);
static JTextField TF = new JTextField();
static JButton B = new JButton();

public static void createWindow() {
	settings();
	frame.setVisible(true);
}

private static void settings() {
	ImageIcon icon = new ImageIcon(Settings.TW_ico_path);
	frame.setSize(Settings.TW_size_w, Settings.TW_size_h);//800,600
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setIconImage(icon.getImage());
	frame.setResizable(true);
	frame.setLayout(null);
	text_field();
	button();
	build();
}

private static void text_field(){
	TF.setBounds(0,50,Settings.FULL_WIDTH,(Settings.TW_size_h - 400));
	TF.setFont(new Font("Arial", Font.PLAIN,30));
}

private static void button(){
	B.setBounds(0,0,200,50);
	B.setText("Submit");
	B.addActionListener(new ActionListener() {
		@Override public void actionPerformed(ActionEvent e) {
			String msg = TF.getText();
			Terminal.use_terminal(msg);
		}
	});
}

private static void build(){ frame.add(TF); frame.add(B);}
}
