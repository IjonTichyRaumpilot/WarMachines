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
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import edu.WarMachineGame.SpielRaum.Spieler;
import edu.WarMachineGame.SpielRaum.ElementZustaende.FreiZustand;
import edu.WarMachineGame.TestDrive.GameStarter;

/**
 * Diese Klasse wurde mit WindowBuilder erstellt und dann den Anforderungen
 * entsprechend modifiziert.
 * 
 * @author Arthur
 * 
 */
public class GuiV1Frame extends JFrame {

	private JPanel contentPane;

	private Spieler spieler;
	private JPanel spielFeld_Spieler;
	private Spieler gegner;
	private JPanel spielFeld_Gegner;

	/**
	 * Create the frame.
	 */
	public GuiV1Frame(Spieler spieler, Spieler gegner) {
		this.spieler = spieler;
		this.gegner = gegner;
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 770, 634);
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

		for (int i = 9; i >= 0; i--) {
			JPanel panel = new JPanel();
			panel.setBackground(Color.orange);
			JLabel label = new JLabel(Integer.toString(i));
			panel.add(label);
			vertikal_Gegner.add(panel);
		}

		spielFeld_Gegner = new JPanel();

		spielFeld_Gegner.setLayout(new GridLayout(0, 10, 3, 3));
		GameStarter.setSpielFeld_Gegner(spielFeld_Gegner);
		updateGegnerPanels(spielFeld_Gegner);

		JPanel horizontal_Gegner = new JPanel();
		horizontal_Gegner.setLayout(new GridLayout(0, 10, 3, 3));

		for (int i = 0; i < 10; i++) {
			JPanel panel = new JPanel();
			panel.setBackground(Color.orange);
			JLabel label = new JLabel(Integer.toString(i));
			panel.add(label);
			horizontal_Gegner.add(panel);
		}

		// Generiere Layout
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
																spielFeld_Gegner,
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
																				spielFeld_Gegner,
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

		JLabel lblNewLabel_1 = new JLabel("Info");

		JScrollPane ScrollAusgabe = new JScrollPane();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane
				.setHorizontalGroup(gl_contentPane
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								Alignment.TRAILING,
								gl_contentPane
										.createSequentialGroup()
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.TRAILING)
														.addGroup(
																Alignment.LEADING,
																gl_contentPane
																		.createSequentialGroup()
																		.addContainerGap()
																		.addComponent(
																				ScrollAusgabe,
																				GroupLayout.DEFAULT_SIZE,
																				734,
																				Short.MAX_VALUE))
														.addGroup(
																Alignment.LEADING,
																gl_contentPane
																		.createSequentialGroup()
																		.addContainerGap()
																		.addComponent(
																				EigenesFeld,
																				GroupLayout.PREFERRED_SIZE,
																				356,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				ComponentPlacement.RELATED,
																				22,
																				Short.MAX_VALUE)
																		.addComponent(
																				GegnerFeld,
																				GroupLayout.PREFERRED_SIZE,
																				356,
																				GroupLayout.PREFERRED_SIZE))
														.addGroup(
																Alignment.LEADING,
																gl_contentPane
																		.createSequentialGroup()
																		.addContainerGap()
																		.addComponent(
																				lblNewLabel_1)))
										.addContainerGap()));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(
				Alignment.TRAILING).addGroup(
				gl_contentPane
						.createSequentialGroup()
						.addContainerGap()
						.addComponent(lblNewLabel_1)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(ScrollAusgabe, GroupLayout.DEFAULT_SIZE,
								147, Short.MAX_VALUE)
						.addGap(18)
						.addGroup(
								gl_contentPane
										.createParallelGroup(Alignment.LEADING,
												false)
										.addComponent(EigenesFeld,
												Alignment.TRAILING,
												GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(GegnerFeld,
												Alignment.TRAILING,
												GroupLayout.DEFAULT_SIZE, 389,
												Short.MAX_VALUE))
						.addContainerGap()));

		JTextArea Ausgabe = new JTextArea();
		Ausgabe.setForeground(Color.WHITE);
		Ausgabe.setBackground(SystemColor.activeCaption);
		Ausgabe.setEditable(false);
		GameStarter.setTextArea(Ausgabe);
		JScrollBar scrollBarVertical = ScrollAusgabe.getVerticalScrollBar();
		GameStarter.setScrollBar(scrollBarVertical);
		ScrollAusgabe.setViewportView(Ausgabe);
		spielFeld_Spieler = new JPanel();
		spielFeld_Spieler.setLayout(new GridLayout(0, 10, 3, 3));
		GameStarter.setSpielFeld_Spieler(spielFeld_Spieler);
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
																spielFeld_Spieler,
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
																				spielFeld_Spieler,
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

		for (int i = 9; i >= 0; i--) {
			JPanel panel = new JPanel();
			panel.setBackground(Color.orange);
			JLabel label = new JLabel(Integer.toString(i));
			panel.add(label);
			vertikal_Spieler.add(panel);
		}

		horizontal_Spieler.setLayout(new GridLayout(0, 10, 3, 3));

		for (int i = 0; i < 10; i++) {
			JPanel panel = new JPanel();
			panel.setBackground(Color.orange);
			JLabel label = new JLabel(Integer.toString(i));
			panel.add(label);
			horizontal_Spieler.add(panel);
		}

		updateSpielerPanels(spielFeld_Spieler);

		EigenesFeld.setLayout(gl_EigenesFeld);
		contentPane.setLayout(gl_contentPane);
		this.setVisible(true);
	}

	public void updateFenster() {

		updateSpielerPanels(this.spielFeld_Spieler);
		updateGegnerPanels(this.spielFeld_Gegner);
		this.revalidate();
	}

	private void updateSpielerPanels(JPanel spielFeld) {
		List<JPanel> panels = new ArrayList<JPanel>();
		for (int i = 9; i >= 0; i--) {
			for (int j = 0; j < 10; j++) {
				JPanel panel = new JPanel();
				panel.setBackground(spieler.getSpielfeld().getElements()[j][i]
						.getElementColor());
				panels.add(panel);

			}

		}
		spielFeld_Spieler.removeAll();
		for (JPanel jPanel : panels) {
			spielFeld.add(jPanel);
		}
	}

	private void updateGegnerPanels(JPanel spielFeld) {
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
				panel.addMouseListener(new MouseOnElementHandler(j, i, panel));
				panels.add(panel);

			}

		}
		spielFeld_Gegner.removeAll();
		for (JPanel jPanel : panels) {
			spielFeld.add(jPanel);
		}
	}

}
