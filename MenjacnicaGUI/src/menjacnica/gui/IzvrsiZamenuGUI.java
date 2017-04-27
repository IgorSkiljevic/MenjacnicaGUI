package menjacnica.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JSlider;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class IzvrsiZamenuGUI extends JFrame {

	private JPanel contentPane;
	private JLabel lblKupovniKurs;
	private JLabel lblValuta;
	private JLabel lblProdajniKurs;
	private JTextField txtKupovni;
	private JTextField txtProdajni;
	private JComboBox comboValuta;
	private JLabel lblIznos;
	private JTextField txtIznos;
	private JLabel lblVrstaTransakcije;
	private JRadioButton rdbtnKupovina;
	private JRadioButton rdbtnProdaja;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JSlider slider;
	private JButton btnIzvrsiZamenu;
	private JButton btnOdustani;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public IzvrsiZamenuGUI() {

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				GUIKontroler.zatvoriIzvrsiZamenuGUI();
			}
		});

		setResizable(false);
		setTitle("Izvrsi Zamenu");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getRdbtnKupovina());
		contentPane.add(getLblKupovniKurs());
		contentPane.add(getLblValuta());
		contentPane.add(getLblProdajniKurs());
		contentPane.add(getTxtKupovni());
		contentPane.add(getTxtProdajni());
		contentPane.add(getComboValuta());
		contentPane.add(getLblIznos());
		contentPane.add(getTxtIznos());
		contentPane.add(getLblVrstaTransakcije());
		contentPane.add(getRdbtnProdaja());
		contentPane.add(getSlider());
		contentPane.add(getBtnIzvrsiZamenu());
		contentPane.add(getBtnOdustani());
		setLocationRelativeTo(null);
	}

	private JLabel getLblKupovniKurs() {
		if (lblKupovniKurs == null) {
			lblKupovniKurs = new JLabel("Kupovni kurs");
			lblKupovniKurs.setBounds(10, 11, 88, 14);
		}
		return lblKupovniKurs;
	}

	private JLabel getLblValuta() {
		if (lblValuta == null) {
			lblValuta = new JLabel("Valuta");
			lblValuta.setBounds(185, 11, 55, 14);
		}
		return lblValuta;
	}

	private JLabel getLblProdajniKurs() {
		if (lblProdajniKurs == null) {
			lblProdajniKurs = new JLabel("Prodajni kurs");
			lblProdajniKurs.setBounds(288, 11, 78, 14);
		}
		return lblProdajniKurs;
	}

	private JTextField getTxtKupovni() {
		if (txtKupovni == null) {
			txtKupovni = new JTextField();
			txtKupovni.setEditable(false);
			txtKupovni.setBounds(12, 36, 130, 20);
			txtKupovni.setColumns(10);
		}
		return txtKupovni;
	}

	private JTextField getTxtProdajni() {
		if (txtProdajni == null) {
			txtProdajni = new JTextField();
			txtProdajni.setEditable(false);
			txtProdajni.setBounds(288, 36, 130, 20);
			txtProdajni.setColumns(10);
		}
		return txtProdajni;
	}

	private JComboBox getComboValuta() {
		if (comboValuta == null) {
			comboValuta = new JComboBox();
			comboValuta.setModel(new DefaultComboBoxModel(new String[] { "EUR", "USD", "CHF" }));
			comboValuta.setBounds(178, 36, 78, 20);
		}
		return comboValuta;
	}

	private JLabel getLblIznos() {
		if (lblIznos == null) {
			lblIznos = new JLabel("Iznos");
			lblIznos.setBounds(10, 84, 46, 14);
		}
		return lblIznos;
	}

	private JTextField getTxtIznos() {
		if (txtIznos == null) {
			txtIznos = new JTextField();
			txtIznos.setBounds(10, 109, 182, 30);
			txtIznos.setColumns(10);
		}
		return txtIznos;
	}

	private JLabel getLblVrstaTransakcije() {
		if (lblVrstaTransakcije == null) {
			lblVrstaTransakcije = new JLabel("Vrsta transakcije");
			lblVrstaTransakcije.setBounds(245, 84, 116, 14);
		}
		return lblVrstaTransakcije;
	}

	private JRadioButton getRdbtnKupovina() {
		if (rdbtnKupovina == null) {
			rdbtnKupovina = new JRadioButton("Kupovina");
			rdbtnKupovina.setSelected(true);
			buttonGroup.add(rdbtnKupovina);
			rdbtnKupovina.setBounds(245, 108, 109, 23);
		}
		return rdbtnKupovina;
	}

	private JRadioButton getRdbtnProdaja() {
		if (rdbtnProdaja == null) {
			rdbtnProdaja = new JRadioButton("Prodaja");
			buttonGroup.add(rdbtnProdaja);
			rdbtnProdaja.setBounds(245, 134, 109, 23);
		}
		return rdbtnProdaja;
	}

	private JSlider getSlider() {
		if (slider == null) {
			slider = new JSlider();
			slider.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent arg0) {
					int iznos = slider.getValue();
					getTxtIznos().setText(iznos + "");
				}
			});
			slider.setMajorTickSpacing(10);
			slider.setMinorTickSpacing(5);
			slider.setPaintTicks(true);
			slider.setPaintLabels(true);
			slider.setBounds(10, 164, 408, 51);

		}
		return slider;
	}

	private JButton getBtnIzvrsiZamenu() {
		if (btnIzvrsiZamenu == null) {
			btnIzvrsiZamenu = new JButton("Izvrsi zamenu");
			btnIzvrsiZamenu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String transakcija = "";
					if(rdbtnKupovina.isSelected()){transakcija = "Kupvina";}else{
						transakcija = "Prodaja";
					}
					
					GUIKontroler.upisiTextUMenjacnicaGUI("Izvrsena zamena \n Valuta : "
							+ comboValuta.getSelectedItem().toString() + " ; Iznos : " + txtIznos.getText()
							+ " ; Vrsta transakcije : " + transakcija);
				}
			});
			btnIzvrsiZamenu.setBounds(9, 226, 153, 35);
		}
		return btnIzvrsiZamenu;
	}

	private JButton getBtnOdustani() {
		if (btnOdustani == null) {
			btnOdustani = new JButton("Odustani");
			btnOdustani.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIKontroler.zatvoriIzvrsiZamenuGUI();
				}
			});
			btnOdustani.setBounds(253, 226, 153, 35);
		}
		return btnOdustani;
	}
}
