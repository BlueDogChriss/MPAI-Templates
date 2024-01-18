package gui;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import clase.abstractfactory.Elev;
import clase.strategy.StrategieBonusTemeRezolvate;

public class TemeDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel panel = new JPanel();

	private Elev elevLiceu = ElevInregistrareDialog.elevLiceu;
	private Elev elevScoala = ElevInregistrareDialog.elevScoala;

	private JLabel RankJLabel = new JLabel("Nota: ");
	private JLabel RankJLabelValue = new JLabel();

	private JLabel temeRezolvateJLabel = new JLabel("Teme rezolvate: ");
	private JLabel temeRezolvateJLabelValue = new JLabel();

	private JLabel tema1JLabel = new JLabel("TEMA 1: ");
	private Checkbox cb1 = new Checkbox();
	private JLabel tema2JLabel = new JLabel("TEMA 2: ");
	private Checkbox cb2 = new Checkbox();
	private JLabel tema3JLabel = new JLabel("TEMA 3: ");
	private Checkbox cb3 = new Checkbox();
	private JLabel tema4JLabel = new JLabel("TEMA 4: ");
	private Checkbox cb4 = new Checkbox();
	private JLabel tema5JLabel = new JLabel("TEMA 5: ");
	private Checkbox cb5 = new Checkbox();
	private JLabel tema6JLabel = new JLabel("TEMA 6: ");
	private Checkbox cb6 = new Checkbox();
	private JLabel tema7JLabel = new JLabel("TEMA 7: ");
	private Checkbox cb7 = new Checkbox();
	private JLabel tema8JLabel = new JLabel("TEMA 8: ");
	private Checkbox cb8 = new Checkbox();
	private JLabel tema9JLabel = new JLabel("TEMA 9: ");
	private Checkbox cb9 = new Checkbox();
	private JLabel tema10JLabel = new JLabel("TEMA 10: ");
	private Checkbox cb10 = new Checkbox();

	public void showDialog() {
		JPanel labels = new JPanel(new GridLayout(7, 2));

		panel.add(labels, BorderLayout.WEST);

		labels.add(RankJLabel);
		labels.add(RankJLabelValue);
		labels.add(temeRezolvateJLabel);
		labels.add(temeRezolvateJLabelValue);
		labels.add(tema1JLabel);
		labels.add(cb1);
		labels.add(tema2JLabel);
		labels.add(cb2);
		labels.add(tema3JLabel);
		labels.add(cb3);
		labels.add(tema4JLabel);
		labels.add(cb4);
		labels.add(tema5JLabel);
		labels.add(cb5);
		labels.add(tema6JLabel);
		labels.add(cb6);
		labels.add(tema7JLabel);
		labels.add(cb7);
		labels.add(tema8JLabel);
		labels.add(cb8);
		labels.add(tema9JLabel);
		labels.add(cb9);
		labels.add(tema10JLabel);
		labels.add(cb10);

		cb1.addItemListener(ItemListenerCheckBox());
		cb2.addItemListener(ItemListenerCheckBox());
		cb3.addItemListener(ItemListenerCheckBox());
		cb4.addItemListener(ItemListenerCheckBox());
		cb5.addItemListener(ItemListenerCheckBox());
		cb6.addItemListener(ItemListenerCheckBox());
		cb7.addItemListener(ItemListenerCheckBox());
		cb8.addItemListener(ItemListenerCheckBox());
		cb9.addItemListener(ItemListenerCheckBox());
		cb10.addItemListener(ItemListenerCheckBox());

		this.setModalityType(ModalityType.APPLICATION_MODAL);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setSize(500, 500);
		this.setTitle("Chat");
		this.add(panel);
		this.setVisible(true);

	}

	private ItemListener ItemListenerCheckBox() {
		return new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (ElevInregistrareDialog.isElevLiceu) {
					elevLiceu.setStrategie(new StrategieBonusTemeRezolvate());
					elevLiceu.primesteNotaTemeRezolvate();

					temeRezolvateJLabelValue
							.setText((e.getStateChange() == 1 ? Integer.toString(elevLiceu.getTotalTemeRezolvate() + 1)
									: Integer.toString(elevLiceu.getTotalTemeRezolvate() - 1)));

					elevLiceu.setTotalTemeRezolvate((e.getStateChange() == 1 ? elevLiceu.getTotalTemeRezolvate() + 1
							: elevLiceu.getTotalTemeRezolvate() - 1));

					RankJLabelValue
							.setText((e.getStateChange() == 1 ? Integer.toString(elevLiceu.getNotaTemeRezolvate() + 1)
									: Integer.toString(elevLiceu.getNotaTemeRezolvate() - 1)));

					elevLiceu.setNotaTemeRezolvate(Integer.valueOf(RankJLabelValue.getText()));

					System.out.println(elevLiceu.getTotalTemeRezolvate());
					System.out.println("Nota: " + elevLiceu.getNotaTemeRezolvate());
				} else {
					elevScoala.setStrategie(new StrategieBonusTemeRezolvate());
					elevScoala.primesteNotaTemeRezolvate();

					temeRezolvateJLabelValue
							.setText((e.getStateChange() == 1 ? Integer.toString(elevScoala.getTotalTemeRezolvate() + 1)
									: Integer.toString(elevScoala.getTotalTemeRezolvate() - 1)));

					elevScoala.setTotalTemeRezolvate((e.getStateChange() == 1 ? elevScoala.getTotalTemeRezolvate() + 1
							: elevScoala.getTotalTemeRezolvate() - 1));

					RankJLabelValue
							.setText((e.getStateChange() == 1 ? Integer.toString(elevScoala.getNotaTemeRezolvate() + 1)
									: Integer.toString(elevScoala.getNotaTemeRezolvate() - 1)));

					elevScoala.setNotaTemeRezolvate(Integer.valueOf(RankJLabelValue.getText()));

					System.out.println(elevScoala.getTotalTemeRezolvate());
					System.out.println("Nota: " + elevScoala.getNotaTemeRezolvate());
				}

			}

		};

	}

}
