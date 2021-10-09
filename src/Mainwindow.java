import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileWriter;
import java.util.Date;

public class Mainwindow extends JFrame {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu Valikko;
	private JMenuItem mntmTyhj;
	private JMenuItem mntmSulje;
	private JTextField txtLuku1;
	private JTextField txtLuku2;
	private JTextField txtTulos;
	private JLabel lblLuku1;
	private JLabel lblLuku2;
	private JLabel lblTulos;
	private JButton buttonPlus;
	private JButton buttonMinus;
	private JButton buttonMultiply;
	private JButton buttonDivision;
	private JCheckBoxMenuItem checkBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mainwindow frame = new Mainwindow();
					frame.setVisible(true);
					frame.tulostaTiedostoon("Ohjelma käynnistyi.");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Mainwindow() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				tulostaTiedostoon("Ohjelma suljettiin.");
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 276, 362);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		Valikko = new JMenu("Valikko");
		menuBar.add(Valikko);
		
		mntmTyhj = new JMenuItem("Tyhjennä kentät");
		mntmTyhj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtLuku1.setText("");
				txtLuku2.setText("");
				txtTulos.setText("");
			}
		});
		Valikko.add(mntmTyhj);
		
		mntmSulje = new JMenuItem("Sulje");
		mntmSulje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "Lopetetaanko?", 
						"Varotus!", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
				if (result == JOptionPane.YES_OPTION) {
					tulostaTiedostoon("Ohjelma suljettiin.");
					System.exit(0);
				}
			}

		});
		Valikko.add(mntmSulje);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtLuku1 = new JTextField();
		txtLuku1.setBackground(Color.WHITE);
		txtLuku1.setHorizontalAlignment(SwingConstants.RIGHT);
		txtLuku1.setBounds(122, 12, 75, 19);
		contentPane.add(txtLuku1);
		txtLuku1.setColumns(10);
		
		txtLuku2 = new JTextField();
		txtLuku2.setHorizontalAlignment(SwingConstants.RIGHT);
		txtLuku2.setColumns(10);
		txtLuku2.setBounds(122, 32, 75, 19);
		contentPane.add(txtLuku2);
		
		txtTulos = new JTextField();
		txtTulos.setHorizontalAlignment(SwingConstants.RIGHT);
		txtTulos.setColumns(10);
		txtTulos.setBounds(122, 63, 75, 19);
		contentPane.add(txtTulos);
		
		lblLuku1 = new JLabel("Luku 1");
		lblLuku1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLuku1.setBounds(12, 14, 70, 15);
		contentPane.add(lblLuku1);
		
		lblLuku2 = new JLabel("Luku 2");
		lblLuku2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLuku2.setBounds(12, 36, 70, 15);
		contentPane.add(lblLuku2);
		
		lblTulos = new JLabel("Tulos");
		lblTulos.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTulos.setBounds(12, 65, 70, 15);
		contentPane.add(lblTulos);
		
		buttonPlus = new JButton("+");
		buttonPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String luku1 = txtLuku1.getText();
				String luku2 = txtLuku2.getText();
				try {
					int intLuku1 = Integer.parseInt(luku1);
					int intLuku2 = Integer.parseInt(luku2);
					
					int tulos = intLuku1 + intLuku2;
					txtTulos.setText(luku1 + " + " + luku2 + " = " + tulos);
					if (checkBox.isSelected()) {
						tulostaTiedostoon("Laskutoimitus : " + luku1 + " + " + luku2 + " = " + tulos);
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Laskutoimituksessa virheellinen syöte, aloita alusta.");
					txtLuku1.setText("");
					txtLuku2.setText("");
					txtTulos.setText("");
				}
			}
		});
		buttonPlus.setFont(new Font("Dialog", Font.BOLD, 20));
		buttonPlus.setBounds(65, 105, 56, 44);
		contentPane.add(buttonPlus);
		
		buttonMinus = new JButton("-");
		buttonMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String luku1 = txtLuku1.getText();
				String luku2 = txtLuku2.getText();
				try {
					int intLuku1 = Integer.parseInt(luku1);
					int intLuku2 = Integer.parseInt(luku2);
					
					int tulos = intLuku1 - intLuku2;
					txtTulos.setText(luku1 + " - " + luku2 + " = " + tulos);
					if (checkBox.isSelected()) {
						tulostaTiedostoon("Laskutoimitus : " + luku1 + " - " + luku2 + " = " + tulos);
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Laskutoimituksessa virheellinen syöte, aloita alusta.");
					txtLuku1.setText("");
					txtLuku2.setText("");
					txtTulos.setText("");
				}
			}
		});
		buttonMinus.setFont(new Font("Dialog", Font.BOLD, 20));
		buttonMinus.setBounds(144, 105, 56, 44);
		contentPane.add(buttonMinus);
		
		buttonMultiply = new JButton("*");
		buttonMultiply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String luku1 = txtLuku1.getText();
				String luku2 = txtLuku2.getText();
				try {
					int intLuku1 = Integer.parseInt(luku1);
					int intLuku2 = Integer.parseInt(luku2);
					
					int tulos = intLuku1 * intLuku2;
					txtTulos.setText(luku1 + " * " + luku2 + " = " + tulos);
					if (checkBox.isSelected()) {
						tulostaTiedostoon("Laskutoimitus : " + luku1 + " * " + luku2 + " = " + tulos);
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Laskutoimituksessa virheellinen syöte, aloita alusta.");
					txtLuku1.setText("");
					txtLuku2.setText("");
					txtTulos.setText("");
				}
			}
		});
		buttonMultiply.setFont(new Font("Dialog", Font.BOLD, 20));
		buttonMultiply.setBounds(65, 161, 56, 44);
		contentPane.add(buttonMultiply);
		
		buttonDivision = new JButton("/");
		buttonDivision.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String luku1 = txtLuku1.getText();
				String luku2 = txtLuku2.getText();
				try {
					int intLuku1 = Integer.parseInt(luku1);
					int intLuku2 = Integer.parseInt(luku2);
					
					if (intLuku2 == 0) {
						JOptionPane.showMessageDialog(null, "Nollalla ei voi jakaa, aloita alusta.");
						txtLuku1.setText("");
						txtLuku2.setText("");
						txtTulos.setText("");
					} else {
						int tulos = intLuku1 / intLuku2;
						txtTulos.setText(luku1 + " / " + luku2 + " = " + tulos);
						if (checkBox.isSelected()) {
							tulostaTiedostoon("Laskutoimitus : " + luku1 + " / " + luku2 + " = " + tulos);
						}
					}				
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Laskutoimituksessa virheellinen syöte, aloita alusta.");
					txtLuku1.setText("");
					txtLuku2.setText("");
					txtTulos.setText("");
				}
			}
		});
		buttonDivision.setFont(new Font("Dialog", Font.BOLD, 20));
		buttonDivision.setBounds(144, 161, 56, 44);
		contentPane.add(buttonDivision);
		
		checkBox = new JCheckBoxMenuItem("Kirjoitetaan tiedostoon");
		checkBox.setSelected(true);
		checkBox.setBounds(12, 231, 185, 19);
		contentPane.add(checkBox);
	}
	
	public void tulostaTiedostoon(String txt) {
		String filename = "src/Resources/laskin.txt";
		try {
			java.util.Date date = new java.util.Date();
			FileWriter fwriter = new FileWriter(filename, true);
			fwriter.write(date.toString() + " : ");
			fwriter.write(txt + "\n");
			fwriter.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
