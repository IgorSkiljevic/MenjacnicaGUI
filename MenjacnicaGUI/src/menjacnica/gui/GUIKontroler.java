package menjacnica.gui;

import java.awt.EventQueue;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GUIKontroler {

	private static MenjacnicaGUI menjacnicaGUI;
	private static DodajKursGUI dodajKursGui;
	private static ObrisiKursGUI obrisiKursGui;
	private static IzvrsiZamenuGUI izvrsiZamenuGui;

	public static String izborFile() {
		JFileChooser jfc = new javax.swing.JFileChooser();
		int izabrani = jfc.showOpenDialog(menjacnicaGUI.getContentPane());

		if (izabrani == JFileChooser.APPROVE_OPTION) {
			File file = jfc.getSelectedFile();

			String ispis = file.getAbsolutePath();
			return ispis;
		}
		return "";
	}

	public static void upisiText(String text, Object mesto) {
		if (mesto instanceof JTextArea) {
			((JTextArea) mesto).setText(text);
		}
		if (mesto instanceof JTextField) {
			((JTextField) mesto).setText(text);
		}
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIKontroler.menjacnicaGUI = new MenjacnicaGUI();
					menjacnicaGUI.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static void izadji() {
		int jop = JOptionPane.showConfirmDialog(menjacnicaGUI.getContentPane(), "Da li zelite da izadjete iz programa",
				"Izlaz", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
		if (jop == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}

	public static void podaciOAutoru() {
		JOptionPane.showMessageDialog(menjacnicaGUI, "Autor : Igor Skiljevic \n Dodatna nastava iz programiranja");
	}

	public static void OtvoriProzorDodajKurs() {
		GUIKontroler.dodajKursGui = new DodajKursGUI();
		dodajKursGui.setVisible(true);
	}

	public static void zatvoriProzorDodajKursGui() {
		dodajKursGui.dispose();
		dodajKursGui = null;
	
	}

	public static void upisiTextUMenjacnicaGUI(String string) {
		String txt = menjacnicaGUI.getTextArea().getText() + " \n" + string;
		upisiText(txt, menjacnicaGUI.getTextArea());
	}

	public static void OtvoriProzorObrisiKurs() {
		GUIKontroler.obrisiKursGui = new ObrisiKursGUI();
		obrisiKursGui.setVisible(true);
	}

	public static void zatvoriProzorObrisiKursGui() {
		obrisiKursGui.dispose();
		obrisiKursGui = null;
	}

	public static void promeniStanjeDugmeta(JButton btnObrisi) {
		if (btnObrisi.isEnabled() == true){btnObrisi.setEnabled(false);}else{
			btnObrisi.setEnabled(true);
		}
	}

	public static void zatvoriIzvrsiZamenuGUI() {
		izvrsiZamenuGui.dispose();
		izvrsiZamenuGui = null;
	}

	public static void otvoriIzvrsiZamenuProzor() {
		izvrsiZamenuGui = new IzvrsiZamenuGUI();
		izvrsiZamenuGui.setVisible(true);
	}

}
