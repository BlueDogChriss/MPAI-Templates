package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Gui {
	private static JFrame frame = new JFrame("Platforma de meditatii");
	private static JPanel panel = new JPanel();
	private static JButton inregistrareProfesor = new JButton("Inregistrare profesor");
	private static JButton inregistrareElev = new JButton("Inregistrare elev");

	public static void createAndShowGUI() {

		frame.setContentPane(panel);

		panel.add(inregistrareProfesor);
		inregistrareProfesor.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new ProfesorInregistrareDialog().showDialog();
			}
		});

		panel.add(inregistrareElev);
		inregistrareElev.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new ElevInregistrareDialog().showDialog();
			}
		});

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.setOpaque(true);
		frame.pack();
		frame.setSize(550, 150);
		frame.setVisible(true);
	}

}
