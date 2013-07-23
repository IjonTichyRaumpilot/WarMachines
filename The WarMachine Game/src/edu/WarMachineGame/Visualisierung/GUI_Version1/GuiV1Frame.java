package edu.WarMachineGame.Visualisierung.GUI_Version1;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.util.ArrayList;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import edu.WarMachineGame.SpielRaum.Spieler;
import edu.WarMachineGame.SpielRaum.ElementZustaende.FreiZustand;

public class GuiV1Frame extends JFrame {

	private JPanel contentPane;

	private Spieler spieler;
	private List<JPanel> spielerPanels;
	private Spieler gegner;
	private List<JPanel> gegnerPanels;

	/**
	 * Create the frame.
	 */
	public GuiV1Frame(Spieler spieler, Spieler gegner) {
		this.spieler = spieler;
		this.gegner = gegner;
		this.updateSpielerPanels();
		this.updateGegnerPanels();
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 770, 449);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.control);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JPanel EigenesFeld = new JPanel();
		EigenesFeld.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.GREEN));

		JPanel GegnerFeld = new JPanel();
		GegnerFeld.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.RED));

		JLabel lblGegnerSpielfeld = new JLabel("Gegner Spielfeld");
		lblGegnerSpielfeld.setFont(new Font("Tahoma", Font.BOLD, 14));

		JPanel vertikal_Gegner = new JPanel();
		vertikal_Gegner.setLayout(new GridLayout(10, 0, 3, 3));

		JPanel panel_122 = new JPanel();
		panel_122.setBackground(Color.ORANGE);
		vertikal_Gegner.add(panel_122);

		JLabel label_21 = new JLabel("9");
		panel_122.add(label_21);

		JPanel panel_123 = new JPanel();
		panel_123.setBackground(Color.ORANGE);
		vertikal_Gegner.add(panel_123);

		JLabel label_22 = new JLabel("8");
		panel_123.add(label_22);

		JPanel panel_124 = new JPanel();
		panel_124.setBackground(Color.ORANGE);
		vertikal_Gegner.add(panel_124);

		JLabel label_23 = new JLabel("7");
		panel_124.add(label_23);

		JPanel panel_125 = new JPanel();
		panel_125.setBackground(Color.ORANGE);
		vertikal_Gegner.add(panel_125);

		JLabel label_24 = new JLabel("6");
		panel_125.add(label_24);

		JPanel panel_126 = new JPanel();
		panel_126.setBackground(Color.ORANGE);
		vertikal_Gegner.add(panel_126);

		JLabel label_25 = new JLabel("5");
		panel_126.add(label_25);

		JPanel panel_127 = new JPanel();
		panel_127.setBackground(Color.ORANGE);
		vertikal_Gegner.add(panel_127);

		JLabel label_26 = new JLabel("4");
		panel_127.add(label_26);

		JPanel panel_128 = new JPanel();
		panel_128.setBackground(Color.ORANGE);
		vertikal_Gegner.add(panel_128);

		JLabel label_27 = new JLabel("3");
		panel_128.add(label_27);

		JPanel panel_129 = new JPanel();
		panel_129.setBackground(Color.ORANGE);
		vertikal_Gegner.add(panel_129);

		JLabel label_28 = new JLabel("2");
		panel_129.add(label_28);

		JPanel panel_130 = new JPanel();
		panel_130.setBackground(Color.ORANGE);
		vertikal_Gegner.add(panel_130);

		JLabel label_29 = new JLabel("1");
		panel_130.add(label_29);

		JPanel panel_131 = new JPanel();
		panel_131.setBackground(Color.ORANGE);
		vertikal_Gegner.add(panel_131);

		JLabel label_30 = new JLabel("0");
		panel_131.add(label_30);

		JPanel Spielfeld_Gegner = new JPanel();

		Spielfeld_Gegner.setLayout(new GridLayout(0, 10, 3, 3));

		for (JPanel jPanel : gegnerPanels) {
			Spielfeld_Gegner.add(jPanel);
		}

		JPanel horizontal_Gegner = new JPanel();
		horizontal_Gegner.setLayout(new GridLayout(0, 10, 3, 3));

		JPanel panel_234 = new JPanel();
		panel_234.setBackground(Color.ORANGE);
		horizontal_Gegner.add(panel_234);

		JLabel label_31 = new JLabel("0");
		panel_234.add(label_31);

		JPanel panel_235 = new JPanel();
		panel_235.setBackground(Color.ORANGE);
		horizontal_Gegner.add(panel_235);

		JLabel label_32 = new JLabel("1");
		panel_235.add(label_32);

		JPanel panel_236 = new JPanel();
		panel_236.setBackground(Color.ORANGE);
		horizontal_Gegner.add(panel_236);

		JLabel label_33 = new JLabel("2");
		panel_236.add(label_33);

		JPanel panel_237 = new JPanel();
		panel_237.setBackground(Color.ORANGE);
		horizontal_Gegner.add(panel_237);

		JLabel label_34 = new JLabel("3");
		panel_237.add(label_34);

		JPanel panel_238 = new JPanel();
		panel_238.setBackground(Color.ORANGE);
		horizontal_Gegner.add(panel_238);

		JLabel label_35 = new JLabel("4");
		panel_238.add(label_35);

		JPanel panel_239 = new JPanel();
		panel_239.setBackground(Color.ORANGE);
		horizontal_Gegner.add(panel_239);

		JLabel label_36 = new JLabel("5");
		panel_239.add(label_36);

		JPanel panel_240 = new JPanel();
		panel_240.setBackground(Color.ORANGE);
		horizontal_Gegner.add(panel_240);

		JLabel label_37 = new JLabel("6");
		panel_240.add(label_37);

		JPanel panel_241 = new JPanel();
		panel_241.setBackground(Color.ORANGE);
		horizontal_Gegner.add(panel_241);

		JLabel label_38 = new JLabel("7");
		panel_241.add(label_38);

		JPanel panel_242 = new JPanel();
		panel_242.setBackground(Color.ORANGE);
		horizontal_Gegner.add(panel_242);

		JLabel label_39 = new JLabel("8");
		panel_242.add(label_39);

		JPanel panel_243 = new JPanel();
		panel_243.setBackground(Color.ORANGE);
		horizontal_Gegner.add(panel_243);

		JLabel label_40 = new JLabel("9");
		panel_243.add(label_40);
		GroupLayout gl_GegnerFeld = new GroupLayout(GegnerFeld);
		gl_GegnerFeld
				.setHorizontalGroup(gl_GegnerFeld
						.createParallelGroup(Alignment.LEADING)
						.addGap(0, 356, Short.MAX_VALUE)
						.addGroup(
								gl_GegnerFeld
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(vertikal_Gegner,
												GroupLayout.PREFERRED_SIZE, 30,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addGroup(
												gl_GegnerFeld
														.createParallelGroup(
																Alignment.LEADING)
														.addComponent(
																horizontal_Gegner,
																GroupLayout.PREFERRED_SIZE,
																300,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																Spielfeld_Gegner,
																GroupLayout.PREFERRED_SIZE,
																300,
																GroupLayout.PREFERRED_SIZE))
										.addContainerGap(
												GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE))
						.addGroup(
								Alignment.TRAILING,
								gl_GegnerFeld.createSequentialGroup()
										.addContainerGap(121, Short.MAX_VALUE)
										.addComponent(lblGegnerSpielfeld)
										.addGap(117)));
		gl_GegnerFeld
				.setVerticalGroup(gl_GegnerFeld
						.createParallelGroup(Alignment.LEADING)
						.addGap(0, 389, Short.MAX_VALUE)
						.addGroup(
								Alignment.TRAILING,
								gl_GegnerFeld
										.createSequentialGroup()
										.addContainerGap(15, Short.MAX_VALUE)
										.addComponent(lblGegnerSpielfeld)
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addGroup(
												gl_GegnerFeld
														.createParallelGroup(
																Alignment.LEADING)
														.addComponent(
																vertikal_Gegner,
																GroupLayout.PREFERRED_SIZE,
																300,
																GroupLayout.PREFERRED_SIZE)
														.addGroup(
																gl_GegnerFeld
																		.createSequentialGroup()
																		.addComponent(
																				Spielfeld_Gegner,
																				GroupLayout.PREFERRED_SIZE,
																				300,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addComponent(
																				horizontal_Gegner,
																				GroupLayout.PREFERRED_SIZE,
																				30,
																				GroupLayout.PREFERRED_SIZE)))
										.addContainerGap()));
		GegnerFeld.setLayout(gl_GegnerFeld);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(
				Alignment.LEADING).addGroup(
				gl_contentPane
						.createSequentialGroup()
						.addContainerGap()
						.addComponent(EigenesFeld, GroupLayout.PREFERRED_SIZE,
								356, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 22,
								Short.MAX_VALUE)
						.addComponent(GegnerFeld, GroupLayout.PREFERRED_SIZE,
								356, GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));
		gl_contentPane
				.setVerticalGroup(gl_contentPane
						.createParallelGroup(Alignment.TRAILING)
						.addGroup(
								Alignment.LEADING,
								gl_contentPane
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.LEADING)
														.addComponent(
																GegnerFeld,
																GroupLayout.PREFERRED_SIZE,
																389,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																EigenesFeld,
																GroupLayout.DEFAULT_SIZE,
																389,
																Short.MAX_VALUE))
										.addContainerGap()));

		JPanel SpielFeld_Eigenes = new JPanel();
		SpielFeld_Eigenes.setLayout(new GridLayout(0, 10, 3, 3));

		JPanel vertikal_Spieler = new JPanel();

		JPanel horizontal_Spieler = new JPanel();

		JLabel lblNewLabel = new JLabel("Eigenes Spielfeld");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		GroupLayout gl_EigenesFeld = new GroupLayout(EigenesFeld);
		gl_EigenesFeld
				.setHorizontalGroup(gl_EigenesFeld
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_EigenesFeld
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(vertikal_Spieler,
												GroupLayout.PREFERRED_SIZE, 30,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addGroup(
												gl_EigenesFeld
														.createParallelGroup(
																Alignment.LEADING)
														.addComponent(
																horizontal_Spieler,
																GroupLayout.PREFERRED_SIZE,
																300,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																SpielFeld_Eigenes,
																GroupLayout.PREFERRED_SIZE,
																300,
																GroupLayout.PREFERRED_SIZE))
										.addContainerGap(
												GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE))
						.addGroup(
								Alignment.TRAILING,
								gl_EigenesFeld.createSequentialGroup()
										.addContainerGap(121, Short.MAX_VALUE)
										.addComponent(lblNewLabel).addGap(117)));
		gl_EigenesFeld
				.setVerticalGroup(gl_EigenesFeld
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								Alignment.TRAILING,
								gl_EigenesFeld
										.createSequentialGroup()
										.addContainerGap(15, Short.MAX_VALUE)
										.addComponent(lblNewLabel)
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addGroup(
												gl_EigenesFeld
														.createParallelGroup(
																Alignment.LEADING)
														.addComponent(
																vertikal_Spieler,
																GroupLayout.PREFERRED_SIZE,
																300,
																GroupLayout.PREFERRED_SIZE)
														.addGroup(
																gl_EigenesFeld
																		.createSequentialGroup()
																		.addComponent(
																				SpielFeld_Eigenes,
																				GroupLayout.PREFERRED_SIZE,
																				300,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addComponent(
																				horizontal_Spieler,
																				GroupLayout.PREFERRED_SIZE,
																				30,
																				GroupLayout.PREFERRED_SIZE)))
										.addContainerGap()));
		vertikal_Spieler.setLayout(new GridLayout(10, 0, 3, 3));

		JPanel panel = new JPanel();
		panel.setBackground(Color.ORANGE);
		vertikal_Spieler.add(panel);

		JLabel label = new JLabel("9");
		panel.add(label);

		JPanel panel_111 = new JPanel();
		panel_111.setBackground(Color.ORANGE);
		vertikal_Spieler.add(panel_111);

		JLabel label_1 = new JLabel("8");
		panel_111.add(label_1);

		JPanel panel_112 = new JPanel();
		panel_112.setBackground(Color.ORANGE);
		vertikal_Spieler.add(panel_112);

		JLabel label_2 = new JLabel("7");
		panel_112.add(label_2);

		JPanel panel_113 = new JPanel();
		panel_113.setBackground(Color.ORANGE);
		vertikal_Spieler.add(panel_113);

		JLabel label_3 = new JLabel("6");
		panel_113.add(label_3);

		JPanel panel_114 = new JPanel();
		panel_114.setBackground(Color.ORANGE);
		vertikal_Spieler.add(panel_114);

		JLabel label_4 = new JLabel("5");
		panel_114.add(label_4);

		JPanel panel_115 = new JPanel();
		panel_115.setBackground(Color.ORANGE);
		vertikal_Spieler.add(panel_115);

		JLabel label_5 = new JLabel("4");
		panel_115.add(label_5);

		JPanel panel_116 = new JPanel();
		panel_116.setBackground(Color.ORANGE);
		vertikal_Spieler.add(panel_116);

		JLabel label_6 = new JLabel("3");
		panel_116.add(label_6);

		JPanel panel_117 = new JPanel();
		panel_117.setBackground(Color.ORANGE);
		vertikal_Spieler.add(panel_117);

		JLabel label_7 = new JLabel("2");
		panel_117.add(label_7);

		JPanel panel_118 = new JPanel();
		panel_118.setBackground(Color.ORANGE);
		vertikal_Spieler.add(panel_118);

		JLabel label_8 = new JLabel("1");
		panel_118.add(label_8);

		JPanel panel_119 = new JPanel();
		panel_119.setBackground(Color.ORANGE);
		vertikal_Spieler.add(panel_119);

		JLabel label_9 = new JLabel("0");
		panel_119.add(label_9);
		horizontal_Spieler.setLayout(new GridLayout(0, 10, 3, 3));

		JPanel panel_101 = new JPanel();
		panel_101.setBackground(Color.ORANGE);
		horizontal_Spieler.add(panel_101);

		JLabel label_10 = new JLabel("0");
		panel_101.add(label_10);

		JPanel panel_102 = new JPanel();
		panel_102.setBackground(Color.ORANGE);
		horizontal_Spieler.add(panel_102);

		JLabel label_11 = new JLabel("1");
		panel_102.add(label_11);

		JPanel panel_103 = new JPanel();
		panel_103.setBackground(Color.ORANGE);
		horizontal_Spieler.add(panel_103);

		JLabel label_12 = new JLabel("2");
		panel_103.add(label_12);

		JPanel panel_104 = new JPanel();
		panel_104.setBackground(Color.ORANGE);
		horizontal_Spieler.add(panel_104);

		JLabel label_13 = new JLabel("3");
		panel_104.add(label_13);

		JPanel panel_105 = new JPanel();
		panel_105.setBackground(Color.ORANGE);
		horizontal_Spieler.add(panel_105);

		JLabel label_14 = new JLabel("4");
		panel_105.add(label_14);

		JPanel panel_106 = new JPanel();
		panel_106.setBackground(Color.ORANGE);
		horizontal_Spieler.add(panel_106);

		JLabel label_15 = new JLabel("5");
		panel_106.add(label_15);

		JPanel panel_107 = new JPanel();
		panel_107.setBackground(Color.ORANGE);
		horizontal_Spieler.add(panel_107);

		JLabel label_16 = new JLabel("6");
		panel_107.add(label_16);

		JPanel panel_108 = new JPanel();
		panel_108.setBackground(Color.ORANGE);
		horizontal_Spieler.add(panel_108);

		JLabel label_17 = new JLabel("7");
		panel_108.add(label_17);

		JPanel panel_109 = new JPanel();
		panel_109.setBackground(Color.ORANGE);
		horizontal_Spieler.add(panel_109);

		JLabel label_18 = new JLabel("8");
		panel_109.add(label_18);

		JPanel panel_110 = new JPanel();
		panel_110.setBackground(Color.ORANGE);
		horizontal_Spieler.add(panel_110);

		JLabel label_19 = new JLabel("9");
		panel_110.add(label_19);

		for (JPanel jPanel : spielerPanels) {
			SpielFeld_Eigenes.add(jPanel);
		}

		EigenesFeld.setLayout(gl_EigenesFeld);
		contentPane.setLayout(gl_contentPane);
		this.setVisible(true);
	}

	public void updateFenster() {

		updateSpielerPanels();
		updateGegnerPanels();
		this.revalidate();
		this.contentPane.revalidate();
	}

	private void updateSpielerPanels() {
		List<JPanel> panels = new ArrayList<JPanel>();

		for (int i = 9; i >= 0; i--) {
			for (int j = 0; j < 10; j++) {
				JPanel panel = new JPanel();
				panel.setBackground(spieler.getSpielfeld().getElements()[j][i]
						.getElementColor());
				panels.add(panel);

			}

		}
		this.spielerPanels = panels;
	}

	private void updateGegnerPanels() {
		List<JPanel> panels = new ArrayList<JPanel>();

		for (int i = 9; i >= 0; i--) {
			for (int j = 0; j < 10; j++) {
				JPanel panel = new JPanel();
				if (gegner.getSpielfeld().getElements()[j][i]
						.getZustandsIndex() == 2) {
					panel.setBackground(new FreiZustand(null).getElementColor());
				} else {
					panel.setBackground(gegner.getSpielfeld().getElements()[j][i]
							.getElementColor());
				}
				panels.add(panel);

			}

		}
		this.gegnerPanels = panels;
	}

}
