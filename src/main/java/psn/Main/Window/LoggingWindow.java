package psn.Main.Window;

import psn.Main.Settings;

import javax.swing.*;
import java.awt.*;

public class LoggingWindow { /// as LW
static JFrame frame =  new JFrame(Settings.LW_Title);
public static JTextArea textArea = new JTextArea();


public static void log_build(){
	settings();
	TextArea_log();
	build();
}
private static void settings(){
	ImageIcon icon = new ImageIcon(Settings.LW_ico_path);
	frame.setIconImage(icon.getImage());
	frame.setSize(Settings.LW_size_w,Settings.LW_size_h);
	frame.getContentPane().setBackground(Color.black);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setResizable(true);
	frame.setVisible(true);
	frame.setLocationRelativeTo(null);
	frame.setLayout(null);
}
private static void TextArea_log(){/// this only use in create
	textArea.setBounds(0,0,Settings.FULL_WIDTH,Settings.FULL_HEIGHT);
	textArea.setForeground(Color.GREEN);
	textArea.setBackground(Color.black);
	textArea.setFont(new Font("Arial", Font.PLAIN,20));
}
private static void build(){
		frame.add(textArea);
	}
}
