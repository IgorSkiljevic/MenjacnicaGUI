package menjacnica.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;

public class ObrisiKursGUI extends JFrame {

	private JPanel contentPane;
	private JLabel lblSifra;
	private JLabel lblNaziv;
	private JTextField txtSifra;
	private JTextField txtNaziv;
	private JLabel lblProdajniKurs;
	private JLabel lblKupovniKurs;
	private JTextField txtProdajniKurs;
	private JTextField txtKupovniKurs;
	private JLabel lblSrednjiKurs;
	private JLabel lblSkraceniNaziv;
	private JTextField txtSrednjiKurs;
	private JTextField txtSkraceniNaziv;
	private JButton btnObrisi;
	private JButton btnOdustani;
	private JCheckBox chckbxZaistaObrisi;

	public ObrisiKursGUI() {

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				GUIKontroler.zatvoriProzorObrisiKursGui();
			}
		});

		setTitle("Obrisi kurs");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblSifra());
		contentPane.add(getLblNaziv());
		contentPane.add(getTxtSifra());
		contentPane.add(getTxtNaziv());
		contentPane.add(getLblProdajniKurs());
		contentPane.add(getLblKupovniKurs());
		contentPane.add(getTxtProdajniKurs());
		contentPane.add(getTxtKupovniKurs());
		contentPane.add(getLblSrednjiKurs());
		contentPane.add(getLblSkraceniNaziv());
		contentPane.add(getTxtSrednjiKurs());
		contentPane.add(getTxtSkraceniNaziv());
		contentPane.add(getBtnObrisi());
		contentPane.add(getBtnOdustani());
		contentPane.add(getChckbxZaistaObrisi());
		setLocationRelativeTo(null);
	}

	private JLabel getLblSifra() {
		if (lblSifra == null) {
			lblSifra = new JLabel("Sifra");
			lblSifra.setBounds(10, 27, 46, 14);
		}
		return lblSifra;
	}

	private JLabel getLblNaziv() {
		if (lblNaziv == null) {
			lblNaziv = new JLabel("Naziv");
			lblNaziv.setBounds(230, 27, 46, 14);
		}
		return lblNaziv;
	}

	private JTextField getTxtSifra() {
		if (txtSifra == null) {
			txtSifra = new JTextField();
			txtSifra.setEditable(false);
			txtSifra.setBounds(10, 53, 176, 20);
			txtSifra.setColumns(10);
		}
		return txtSifra;
	}

	private JTextField getTxtNaziv() {
		if (txtNaziv == null) {
			txtNaziv = new JTextField();
			txtNaziv.setEditable(false);
			txtNaziv.setBounds(230, 52, 176, 20);
			txtNaziv.setColumns(10);
		}
		return txtNaziv;
	}

	private JLabel getLblProdajniKurs() {
		if (lblProdajniKurs == null) {
			lblProdajniKurs = new JLabel("Prodajni kurs");
			lblProdajniKurs.setBounds(10, 84, 92, 14);
		}
		return lblProdajniKurs;
	}

	private JLabel getLblKupovniKurs() {
		if (lblKupovniKurs == null) {
			lblKupovniKurs = new JLabel("Kupovni kurs");
			lblKupovniKurs.setBounds(230, 83, 131, 14);
		}
		return lblKupovniKurs;
	}

	private JTextField getTxtProdajniKurs() {
		if (txtProdajniKurs == null) {
			txtProdajniKurs = new JTextField();
			txtProdajniKurs.setEditable(false);
			txtProdajniKurs.setBounds(10, 118, 176, 20);
			txtProdajniKurs.setColumns(10);
		}
		return txtProdajniKurs;
	}

	private JTextField getTxtKupovniKurs() {
		if (txtKupovniKurs == null) {
			txtKupovniKurs = new JTextField();
			txtKupovniKurs.setEditable(false);
			txtKupovniKurs.setBounds(230, 118, 176, 20);
			txtKupovniKurs.setColumns(10);
		}
		return txtKupovniKurs;
	}

	private JLabel getLblSrednjiKurs() {
		if (lblSrednjiKurs == null) {
			lblSrednjiKurs = new JLabel("Srednji kurs");
			lblSrednjiKurs.setBounds(10, 149, 148, 14);
		}
		return lblSrednjiKurs;
	}

	private JLabel getLblSkraceniNaziv() {
		if (lblSkraceniNaziv == null) {
			lblSkraceniNaziv = new JLabel("Skraceni naziv");
			lblSkraceniNaziv.setBounds(230, 149, 111, 14);
		}
		return lblSkraceniNaziv;
	}

	private JTextField getTxtSrednjiKurs() {
		if (txtSrednjiKurs == null) {
			txtSrednjiKurs = new JTextField();
			txtSrednjiKurs.setEditable(false);
			txtSrednjiKurs.setBounds(10, 174, 176, 20);
			txtSrednjiKurs.setColumns(10);
		}
		return txtSrednjiKurs;
	}

	private JTextField getTxtSkraceniNaziv() {
		if (txtSkraceniNaziv == null) {
			txtSkraceniNaziv = new JTextField();
			txtSkraceniNaziv.setEditable(false);
			txtSkraceniNaziv.setBounds(230, 174, 176, 20);
			txtSkraceniNaziv.setColumns(10);
		}
		return txtSkraceniNaziv;
	}

	private JButton getBtnObrisi() {
		if (btnObrisi == null) {
			btnObrisi = new JButton("Obrisi");
			btnObrisi.setEnabled(false);
			btnObrisi.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIKontroler.upisiTextUMenjacnicaGUI("Obrisan kurs \n Sifra : " + getTxtSifra().getText() + " ; Naziv : " + getTxtNaziv().getText()
							+ " ; Prodajni kurs : " + getTxtProdajniKurs().getText() + " ; Kupovni kurs : " + getTxtKupovniKurs().getText()
							+ " ; Srednji kurs : " + getTxtSrednjiKurs().getText() + " ; Skraceni Naziv : "
							+ getTxtSkraceniNaziv().getText());
				}
			});
			btnObrisi.setBounds(10, 232, 176, 23);
		}
		return btnObrisi;
	}

	private JButton getBtnOdustani() {
		if (btnOdustani == null) {
			btnOdustani = new JButton("Odustani");
			btnOdustani.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIKontroler.zatvoriProzorObrisiKursGui();
				}
			});
			btnOdustani.setBounds(230, 232, 176, 23);
		}
		return btnOdustani;
	}
	private JCheckBox getChckbxZaistaObrisi() {
		if (chckbxZaistaObrisi == null) {
			chckbxZaistaObrisi = new JCheckBox("Zaista obrisi kurs");
			chckbxZaistaObrisi.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIKontroler.promeniStanjeDugmeta(btnObrisi);
				}
			});
			chckbxZaistaObrisi.setBounds(5, 201, 153, 23);
		}
		return chckbxZaistaObrisi;
	}
}
