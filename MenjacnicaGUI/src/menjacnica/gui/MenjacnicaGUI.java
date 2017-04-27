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
import javax.swing.JFileChooser;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.TableModelListener;
import javax.swing.plaf.basic.BasicComboBoxUI.ComboBoxLayoutManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.WindowConstants;

import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.InputEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
	private JPopupMenu popupMenu;
	private JMenuItem mntmDodajKurs;
	private JMenuItem mntmObrisiKurs;
	private JMenuItem mntmIzvrsiZamenu;

	public MenjacnicaGUI() {

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				GUIKontroler.izadji();
			}
		});

		setIconImage(
				Toolkit.getDefaultToolkit().getImage(MenjacnicaGUI.class.getResource("/ikonice/dollar-symbol.png")));
		setTitle("Menjacnica");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
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

	public void setTextArea(JTextArea textArea) {
		this.textArea = textArea;
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
			mntmOpen.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					GUIKontroler.upisiText("Ucitan file : " + GUIKontroler.izborFile(), textArea);
				}
			});
			mntmOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
			mntmOpen.setIcon(new ImageIcon(MenjacnicaGUI.class.getResource("/ikonice/open-folder-outline.png")));
		}
		return mntmOpen;
	}

	private JMenuItem getMntmSave() {
		if (mntmSave == null) {
			mntmSave = new JMenuItem("Save");
			mntmSave.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIKontroler.upisiText("Sacuvan file : " + GUIKontroler.izborFile(), textArea);

				}
			});
			mntmSave.setAccelerator(
					KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK));
			mntmSave.setIcon(new ImageIcon(MenjacnicaGUI.class.getResource("/ikonice/diskette.png")));
		}
		return mntmSave;
	}

	private JMenuItem getMntmExit() {
		if (mntmExit == null) {
			mntmExit = new JMenuItem("Exit");
			mntmExit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIKontroler.izadji();
				}
			});
			mntmExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_MASK));
			mntmExit.setIcon(new ImageIcon(MenjacnicaGUI.class.getResource("/ikonice/door.png")));
		}
		return mntmExit;
	}

	private JMenuItem getMntmAbout() {
		if (mntmAbout == null) {
			mntmAbout = new JMenuItem("About");
			mntmAbout.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIKontroler.podaciOAutoru();
				}
			});
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
			btnDodajKurs.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIKontroler.OtvoriProzorDodajKurs();
				}
			});
			btnDodajKurs.setPreferredSize(new Dimension(100, 25));
		}
		return btnDodajKurs;
	}

	private JButton getBtnObrisiKurs() {
		if (btnObrisiKurs == null) {
			btnObrisiKurs = new JButton("Obrisi kurs");
			btnObrisiKurs.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIKontroler.OtvoriProzorObrisiKurs();
				}
			});
			btnObrisiKurs.setPreferredSize(new Dimension(100, 25));
		}
		return btnObrisiKurs;
	}

	private JButton getBtnIzvrsiZamenu() {
		if (btnIzvrsiZamenu == null) {
			btnIzvrsiZamenu = new JButton("Izvrsi zamenu");
			btnIzvrsiZamenu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIKontroler.otvoriIzvrsiZamenuProzor();
				}
			});
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

	 JTextArea getTextArea() {
		if (textArea == null) {
			textArea = new JTextArea();
			textArea.setEditable(false);
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
			table.getTableHeader().setReorderingAllowed(false);
			addPopup(table, getPopupMenu());

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
			addPopup(table, getPopupMenu());
		}

		return table;
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
	private JPopupMenu getPopupMenu() {
		if (popupMenu == null) {
			popupMenu = new JPopupMenu();
			popupMenu.add(getMntmDodajKurs());
			popupMenu.add(getMntmObrisiKurs());
			popupMenu.add(getMntmIzvrsiZamenu());
		}
		return popupMenu;
	}
	private JMenuItem getMntmDodajKurs() {
		if (mntmDodajKurs == null) {
			mntmDodajKurs = new JMenuItem("Dodaj kurs");
			mntmDodajKurs.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIKontroler.OtvoriProzorDodajKurs();
				}
			});
		}
		return mntmDodajKurs;
	}
	private JMenuItem getMntmObrisiKurs() {
		if (mntmObrisiKurs == null) {
			mntmObrisiKurs = new JMenuItem("Obrisi kurs");
			mntmObrisiKurs.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIKontroler.OtvoriProzorObrisiKurs();
				}
			});
		}
		return mntmObrisiKurs;
	}
	private JMenuItem getMntmIzvrsiZamenu() {
		if (mntmIzvrsiZamenu == null) {
			mntmIzvrsiZamenu = new JMenuItem("Izvrsi zamenu");
			mntmIzvrsiZamenu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIKontroler.otvoriIzvrsiZamenuProzor();
				}
			});
		}
		return mntmIzvrsiZamenu;
	}
}
