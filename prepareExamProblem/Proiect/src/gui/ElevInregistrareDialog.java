package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import clase.abstractfactory.AbstractFactory;
import clase.abstractfactory.Elev;
import clase.abstractfactory.LiceuFactory;
import clase.abstractfactory.ScoalaFactory;
import clase.common.Constants;
import clase.database.DBManagerSingleton;

public class ElevInregistrareDialog extends JDialog implements Constants {

	private static final long serialVersionUID = 1L;
	public static boolean isElevLiceu;
	public static Elev elevScoala;
	public static Elev elevLiceu;
	
	private JPanel panel = new JPanel();
	private JLabel numeJLabel = new JLabel("Nume: ");
	private JTextField numeTextField = new JTextField();
	private JLabel prenumeJLabel = new JLabel("Prenume: ");
	private JTextField prenumeTextField = new JTextField();
	private JLabel clasaJLabel = new JLabel("Clasa: ");
	private JTextField clasaTextField = new JTextField();
	private ButtonGroup radioGroup = new ButtonGroup();
	private JRadioButton elevLiceuRadioButton = new JRadioButton("Elev liceu");
	private JRadioButton elevScoalaRadioButton = new JRadioButton("Elev scoala");
	private JButton submitButton = new JButton("Submit");

	public JTextField getNumeTextField() {
		numeTextField.setPreferredSize(new Dimension(200, 24));
		return numeTextField;
	}

	public JTextField getPrenumeTextField() {
		prenumeTextField.setPreferredSize(new Dimension(200, 24));
		return prenumeTextField;
	}

	public JTextField getClasaTextField() {
		clasaTextField.setPreferredSize(new Dimension(200, 24));
		return clasaTextField;
	}

	public void showDialog() {
		initViews();

		submitButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Elev elev = creareElev();
				clearControls();
				new MeditatieDialog(elevLiceuRadioButton.isSelected(), elev).showDialog();
			}

		});
		
		this.setModalityType(ModalityType.APPLICATION_MODAL);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setSize(1000, 400);
		this.setTitle("Inregistrare elev");
		this.add(panel);
		this.setVisible(true);
	}
	
	private void clearControls() {
		getNumeTextField().setText("");
		getPrenumeTextField().setText("");
		getClasaTextField().setText("");
		elevLiceuRadioButton.setSelected(true);
	}

	private void initViews() {
		JPanel labels = new JPanel(new GridLayout(0, 1));
		JPanel controls = new JPanel(new GridLayout(0, 1));

		panel.add(labels, BorderLayout.WEST);
		panel.add(controls, BorderLayout.CENTER);

		labels.add(numeJLabel);
		controls.add(getNumeTextField());
		labels.add(prenumeJLabel);
		controls.add(getPrenumeTextField());
		labels.add(clasaJLabel);
		controls.add(getClasaTextField());

		radioGroup.add(elevLiceuRadioButton);
		elevLiceuRadioButton.setSelected(true);
		radioGroup.add(elevScoalaRadioButton);
		panel.add(elevLiceuRadioButton);
		panel.add(elevScoalaRadioButton);

		panel.add(submitButton, BorderLayout.SOUTH);
	}

	private Elev creareElev() {
		AbstractFactory liceuFactory = new LiceuFactory();
		AbstractFactory scoalaFactory = new ScoalaFactory();


		if (elevLiceuRadioButton.isSelected()) {
			elevLiceu = liceuFactory.createElev();
			isElevLiceu = true;
			elevLiceu.setNotaTemeRezolvate(0);
			elevLiceu.setTotalTemeRezolvate(0);
			elevLiceu.setNume(numeTextField.getText());
			elevLiceu.setPrenume(prenumeTextField.getText());
			elevLiceu.setClasa(clasaTextField.getText());

			DBManagerSingleton.insertElev(ELEVI_LICEU_TABLE, elevLiceu);
			return elevLiceu;
		} else {
			elevScoala = scoalaFactory.createElev();
			isElevLiceu = false;
			elevScoala.setNotaTemeRezolvate(0);
			elevScoala.setTotalTemeRezolvate(0);
			elevScoala.setNume(numeTextField.getText());
			elevScoala.setPrenume(prenumeTextField.getText());
			elevScoala.setClasa(clasaTextField.getText());

			DBManagerSingleton.insertElev(ELEVI_SCOALA_TABLE, elevScoala);
			return elevScoala;
		}
	}

}
