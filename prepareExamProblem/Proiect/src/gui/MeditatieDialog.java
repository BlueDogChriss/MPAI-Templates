package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import clase.abstractfactory.Elev;
import clase.common.Constants;
import clase.common.Profesor;
import clase.database.DBManagerSingleton;
import clase.visitor.MessagingVisitor;
import clase.visitor.Persoana;

public class MeditatieDialog extends JDialog implements Constants {
	private static final long serialVersionUID = 1L;
	private boolean isElevLiceu;
	private Elev elev = null;

	private JPanel panel = new JPanel();
	private JLabel ziuaJLabel = new JLabel("Ziua: ");
	private JTextField ziuaTextField = new JTextField();
	private JLabel oraJLabel = new JLabel("Ora: ");
	private JTextField oraTextField = new JTextField();
	private JLabel profesorJLabel = new JLabel("Alege profesor: ");
	private JButton salveazaButton = new JButton("Salveaza");
	private JButton temeButton = new JButton("Inregistreaza-ti temele efectuate");
	private JComboBox<Profesor> combobox = new JComboBox<>();
	private JButton clearControlsButton = new JButton("Sterge controalele");

	public MeditatieDialog(boolean isElevLiceu, Elev elev) {
		super();
		this.isElevLiceu = isElevLiceu;
		this.elev = elev;
	}

	public JTextField getZiuaTextField() {
		ziuaTextField.setPreferredSize(new Dimension(200, 24));
		return ziuaTextField;
	}

	public JTextField getOraTextField() {
		oraTextField.setPreferredSize(new Dimension(200, 24));
		return oraTextField;
	}

	public void showDialog() {
		initViews();
		
		this.setModalityType(ModalityType.APPLICATION_MODAL);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setSize(1500, 450);
		this.setTitle("Meditatii");
		this.add(panel);
		this.setVisible(true);

	}

	private void initViews() {
		JPanel labels = new JPanel(new GridLayout(0, 1));
		JPanel controls = new JPanel(new GridLayout(0, 1));
		
		panel.add(labels, BorderLayout.WEST);
		panel.add(controls, BorderLayout.CENTER);

		labels.add(ziuaJLabel);
		controls.add(getZiuaTextField());
		labels.add(oraJLabel);
		controls.add(getOraTextField());
		labels.add(profesorJLabel);
		combobox = new JComboBox<>(DBManagerSingleton.getProfesori(isElevLiceu));
		controls.add(combobox);

		panel.add(salveazaButton, BorderLayout.SOUTH);

		salveazaButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				DBManagerSingleton.insertMeditatie(isElevLiceu, elev, combobox);
//				clearControls();
				notificaMeditatieNoua();
			}

		});
		
		panel.add(temeButton, BorderLayout.NORTH);
		temeButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new TemeDialog().showDialog();
			}

		});
		
		panel.add(clearControlsButton, BorderLayout.SOUTH);
		clearControlsButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				clearControls();
			}
		});
	}
	
	private void clearControls() {
		getZiuaTextField().setText("");
		getOraTextField().setText("");
	}
	
	private void notificaMeditatieNoua() {
		List<Persoana> persoaneList = new ArrayList<>();
		persoaneList.add(elev);
		persoaneList.add(combobox.getItemAt(combobox.getSelectedIndex()));
		MessagingVisitor messagingVisitor = new MessagingVisitor();
		messagingVisitor.sendMessages(persoaneList);
	}

}
