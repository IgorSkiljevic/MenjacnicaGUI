package menjacnica.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;import javax.swing.event.TableModelListener;
import javax.swing.plaf.basic.BasicComboBoxUI.ComboBoxLayoutManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;

public class MenjacnicaGUI extends JFrame {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnFile;
	private JMenu mnHelp;
	private JMenuItem mntmOpen;
	private JMenuItem mntmSave;
	private JMenuItem mntmExit;
	private JMenuItem mntmAbout;
	private JPanel Epanel;
	private JButton btnDodajKurs;
	private JButton btnObrisiKurs;
	private JButton btnIzvrsiZamenu;
	private JScrollPane SscrollPane;
	private JTextArea textArea;
	private JScrollPane TabelaScrollPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenjacnicaGUI frame = new MenjacnicaGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MenjacnicaGUI() {
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(MenjacnicaGUI.class.getResource("/ikonice/dollar-symbol.png")));
		setTitle("Menjacnica");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 558, 383);
		setJMenuBar(getMenuBar_1());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getEpanel(), BorderLayout.EAST);
		contentPane.add(getSscrollPane(), BorderLayout.SOUTH);
		contentPane.add(getTabelaScrollPane(), BorderLayout.CENTER);
		setLocationRelativeTo(null);
	}

	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMnFile());
			menuBar.add(getMnHelp());
		}
		return menuBar;
	}

	private JMenu getMnFile() {
		if (mnFile == null) {
			mnFile = new JMenu("File");
			mnFile.add(getMntmOpen());
			mnFile.add(getMntmSave());
			mnFile.add(getMntmExit());
		}
		return mnFile;
	}

	private JMenu getMnHelp() {
		if (mnHelp == null) {
			mnHelp = new JMenu("Help");
			mnHelp.add(getMntmAbout());
		}
		return mnHelp;
	}

	private JMenuItem getMntmOpen() {
		if (mntmOpen == null) {
			mntmOpen = new JMenuItem("Open");
			mntmOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
			mntmOpen.setIcon(new ImageIcon(MenjacnicaGUI.class.getResource("/ikonice/open-folder-outline.png")));
		}
		return mntmOpen;
	}

	private JMenuItem getMntmSave() {
		if (mntmSave == null) {
			mntmSave = new JMenuItem("Save");
			mntmSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK));
			mntmSave.setIcon(new ImageIcon(MenjacnicaGUI.class.getResource("/ikonice/diskette.png")));
		}
		return mntmSave;
	}

	private JMenuItem getMntmExit() {
		if (mntmExit == null) {
			mntmExit = new JMenuItem("Exit");
			mntmExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_MASK));
			mntmExit.setIcon(new ImageIcon(MenjacnicaGUI.class.getResource("/ikonice/door.png")));
		}
		return mntmExit;
	}

	private JMenuItem getMntmAbout() {
		if (mntmAbout == null) {
			mntmAbout = new JMenuItem("About");
			mntmAbout.setIcon(new ImageIcon(MenjacnicaGUI.class.getResource("/ikonice/info.png")));
		}
		return mntmAbout;
	}

	private JPanel getEpanel() {
		if (Epanel == null) {
			Epanel = new JPanel();
			Epanel.setPreferredSize(new Dimension(120, 10));
			Epanel.add(getBtnDodajKurs());
			Epanel.add(getBtnObrisiKurs());
			Epanel.add(getBtnIzvrsiZamenu());
		}
		return Epanel;
	}

	private JButton getBtnDodajKurs() {
		if (btnDodajKurs == null) {
			btnDodajKurs = new JButton("Dodaj kurs");
			btnDodajKurs.setPreferredSize(new Dimension(100, 25));
		}
		return btnDodajKurs;
	}

	private JButton getBtnObrisiKurs() {
		if (btnObrisiKurs == null) {
			btnObrisiKurs = new JButton("Obrisi kurs");
			btnObrisiKurs.setPreferredSize(new Dimension(100, 25));
		}
		return btnObrisiKurs;
	}

	private JButton getBtnIzvrsiZamenu() {
		if (btnIzvrsiZamenu == null) {
			btnIzvrsiZamenu = new JButton("Izvrsi zamenu");
			btnIzvrsiZamenu.setPreferredSize(new Dimension(100, 25));
		}
		return btnIzvrsiZamenu;
	}

	private JScrollPane getSscrollPane() {
		if (SscrollPane == null) {
			SscrollPane = new JScrollPane();
			SscrollPane.setName("");
			SscrollPane.setBorder(new TitledBorder(null, "STATUS", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			SscrollPane.setToolTipText("");
			SscrollPane.setPreferredSize(new Dimension(2, 80));
			SscrollPane.setViewportView(getTextArea());
		}
		return SscrollPane;
	}

	private JTextArea getTextArea() {
		if (textArea == null) {
			textArea = new JTextArea();
		}
		return textArea;
	}
	private JScrollPane getTabelaScrollPane() {
		if (TabelaScrollPane == null) {
			TabelaScrollPane = new JScrollPane();
			TabelaScrollPane.setViewportView(getTable());
		}
		return TabelaScrollPane;
	}
	private JTable getTable() {
		if (table == null) {
			table = new JTable();
			table.setFillsViewportHeight(true);
			

			table = new JTable();
			table.setModel(new DefaultTableModel(new Object[][] {},
					new String[] { "\u0160ifra", "Skra\u0107eni naziv", "Prodajni", "Srednji", "Kupovni", "Naziv" }) {
				boolean[] columnEditables = new boolean[] { false, false, false, false, false, false };

				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			});
			table.setFillsViewportHeight(true);
			table.getTableHeader().setReorderingAllowed(false);
		}

		
		return table;
	}
}
