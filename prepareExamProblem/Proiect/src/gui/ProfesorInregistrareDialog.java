package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import clase.abstractfactory.AbstractFactory;
import clase.abstractfactory.LiceuFactory;
import clase.abstractfactory.ScoalaFactory;
import clase.builder.Continut;
import clase.builder.DenumireMaterie;
import clase.builder.Materie;
import clase.builder.NivelDificultate;
import clase.common.Constants;
import clase.common.Profesor;
import clase.database.DBManagerSingleton;

public class ProfesorInregistrareDialog extends JDialog implements Constants {

	private static final long serialVersionUID = 1L;
	private JPanel panel = new JPanel();
	private JLabel numeJLabel = new JLabel("Nume: ");
	private JTextField numeTextField = new JTextField();
	private JLabel prenumeJLabel = new JLabel("Prenume: ");
	private JTextField prenumeTextField = new JTextField();
	private JLabel materieJLabel = new JLabel("Denumire materie: ");
	private JComboBox<DenumireMaterie> materieTextField = new JComboBox<DenumireMaterie>();
	private ButtonGroup radioGroup = new ButtonGroup();
	private JRadioButton liceuRadioButton = new JRadioButton("Profesor liceu");
	private JRadioButton scoalaRadioButton = new JRadioButton("Profesor scoala");
	private JLabel nivelJLabel = new JLabel("Nivel dificultate: ");
	private JComboBox<NivelDificultate> nivelDificultateComboBox = new JComboBox<>();
	private JLabel semestruJLabel = new JLabel("Semestru: ");
	private JComboBox<Integer> semestruComboBox = new JComboBox<>();
	private JCheckBox isExtracurricularaBox = new JCheckBox("Extracurriculara");
	private JCheckBox isMaterieExamenFinal = new JCheckBox("Materie examen final");
	private JLabel continutJLabel = new JLabel("Continut: ");
	private JTextField continutTextField = new JTextField();
	private JButton submitButton = new JButton("Submit");
	
	public JTextField getNumeTextField() {
		numeTextField.setPreferredSize(new Dimension(200, 24));
		return numeTextField;
	}

	public JTextField getPrenumeTextField() {
		prenumeTextField.setPreferredSize(new Dimension(200, 24));
		return prenumeTextField;
	}

	public void showDialog() {
		initViews();

		submitButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				creareProfesor();
				clearControls();
			}

		});

		this.setModalityType(ModalityType.APPLICATION_MODAL);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setSize(1000, 400);
		this.setTitle("Inregistrare profesor");
		this.add(panel);
		this.setVisible(true);

	}
	
	private void clearControls() {
		getNumeTextField().setText("");
		getPrenumeTextField().setText("");
		liceuRadioButton.setSelected(true);
		continutTextField.setText("");
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
		labels.add(materieJLabel);
		populateDenumireMaterie();
		controls.add(materieTextField);
		labels.add(nivelJLabel);
		populateNivelDificultateCB();
		controls.add(nivelDificultateComboBox);
		labels.add(semestruJLabel);
		populateSemestruCB();
		controls.add(semestruComboBox);
		labels.add(isExtracurricularaBox);
		controls.add(isMaterieExamenFinal);
		labels.add(continutJLabel);
		controls.add(continutTextField);

		radioGroup.add(liceuRadioButton);
		liceuRadioButton.setSelected(true);
		radioGroup.add(scoalaRadioButton);
		panel.add(liceuRadioButton);
		panel.add(scoalaRadioButton);

		panel.add(submitButton, BorderLayout.SOUTH);
	}

	private void populateDenumireMaterie() {
		materieTextField.addItem(DenumireMaterie.MATEMATICA);
		materieTextField.addItem(DenumireMaterie.CHIMIE);
		materieTextField.addItem(DenumireMaterie.GEOGRAFIE);
		materieTextField.addItem(DenumireMaterie.FIZICA);
		materieTextField.addItem(DenumireMaterie.INFORMATICA);
		materieTextField.addItem(DenumireMaterie.ISTORIE);
		materieTextField.addItem(DenumireMaterie.ENGLEZA);
		materieTextField.addItem(DenumireMaterie.ROMANA);
	}

	private void populateNivelDificultateCB() {
		nivelDificultateComboBox.addItem(NivelDificultate.INCEPATOR);
		nivelDificultateComboBox.addItem(NivelDificultate.MEDIU);
		nivelDificultateComboBox.addItem(NivelDificultate.AVANSAT);
	}
	
	private void populateSemestruCB() {
		semestruComboBox.addItem(1);
		semestruComboBox.addItem(2);
	}
	
	private void creareProfesor() {
		AbstractFactory liceuFactory = new LiceuFactory();
		AbstractFactory scoalaFactory = new ScoalaFactory();
		
		DenumireMaterie denumireMaterie = materieTextField.getItemAt(materieTextField.getSelectedIndex());
		NivelDificultate nivelDificultate = nivelDificultateComboBox.getItemAt(nivelDificultateComboBox.getSelectedIndex());
		int semestru = semestruComboBox.getItemAt(semestruComboBox.getSelectedIndex());
		boolean isExtracurriculara = isExtracurricularaBox.isSelected();
		boolean isMaterieExamen = isMaterieExamenFinal.isSelected();
		String continut = continutTextField.getText();
		
		Materie materie = createMaterie(denumireMaterie, nivelDificultate, semestru, isExtracurriculara, isMaterieExamen,
				continut);

		int primaryKey = DBManagerSingleton.getPrimaryKey();
		DBManagerSingleton.insertMaterie(materie, primaryKey);
		
		if (liceuRadioButton.isSelected()) {
			Profesor profesorLiceu = liceuFactory.createProfesor();
			profesorLiceu.setNume(numeTextField.getText());
			profesorLiceu.setPrenume(prenumeTextField.getText());
			profesorLiceu.setMaterie(materie);

			DBManagerSingleton.insertProfesor(profesorLiceu, primaryKey, PROFESORI_LICEU_TABLE);
		} else {
			Profesor profesorScoala = scoalaFactory.createProfesor();
			profesorScoala.setNume(numeTextField.getText());
			profesorScoala.setPrenume(prenumeTextField.getText());
			profesorScoala.setMaterie(materie);

			DBManagerSingleton.insertProfesor(profesorScoala, primaryKey, PROFESORI_SCOALA_TABLE);
		}
	}

	public static Materie createMaterie(DenumireMaterie denumireMaterie, NivelDificultate nivelDificultate, int semestru,
			boolean isExtracurriculara, boolean isMaterieExamen, String continut) {
		Materie materie = null;
		if (isExtracurriculara) {
			materie = new Materie.MaterieBuilder(denumireMaterie, nivelDificultate, semestru)
					.esteMaterieExtracurriculara().setContinut(new Continut(continut)).build();
		} else if (isMaterieExamen) {
			materie = new Materie.MaterieBuilder(denumireMaterie, nivelDificultate, semestru)
					.esteMaterieExamenFinal().setContinut(new Continut(continut)).build();
		} else if (isExtracurriculara && isMaterieExamen) {
			materie = new Materie.MaterieBuilder(denumireMaterie, nivelDificultate, semestru)
					.esteMaterieExtracurriculara().esteMaterieExamenFinal().setContinut(new Continut(continut)).build();
		} else {
			materie = new Materie.MaterieBuilder(denumireMaterie, nivelDificultate, semestru)
					.setContinut(new Continut(continut)).build();
		}
		return materie;
	}

}
