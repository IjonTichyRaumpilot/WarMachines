package edu.WarMachineGame.Visualisierung;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import edu.WarMachineGame.TestDrive.GameStarter;

public class StartBildschirm extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public StartBildschirm() {
		setResizable(false);
		setTitle("WarMachines - Extended Hyper Deluxe Platinum Edition");
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 836, 414);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(5, 5, 460, 346);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setIcon(new ImageIcon("Logo.png"));
		contentPane.add(lblNewLabel);

		JLabel lblWarmachines = new JLabel("WarMachines");
		lblWarmachines.setFont(new Font("Tahoma", Font.BOLD, 42));
		lblWarmachines.setForeground(Color.RED);
		lblWarmachines.setBounds(495, 97, 295, 59);
		contentPane.add(lblWarmachines);

		JLabel lbltheGame = new JLabel("-=The Game=-");
		lbltheGame.setForeground(Color.RED);
		lbltheGame.setFont(new Font("Tahoma", Font.BOLD, 42));
		lbltheGame.setBounds(475, 167, 315, 59);
		contentPane.add(lbltheGame);

		JPanel panel = new JPanel();
		panel.setBounds(475, 288, 315, 59);
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));

		JLabel lblGameStatus = new JLabel("Game Status");
		lblGameStatus.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblGameStatus, BorderLayout.NORTH);

		JLabel iniStatus = new JLabel("");
		iniStatus.setHorizontalAlignment(SwingConstants.CENTER);
		GameStarter.setIniLabel(iniStatus);
		panel.add(iniStatus, BorderLayout.CENTER);

		JLabel lblNewLabel_2 = new JLabel(
				"Sponsored by the National Security Agency");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(475, 237, 315, 14);
		contentPane.add(lblNewLabel_2);
	}
}
