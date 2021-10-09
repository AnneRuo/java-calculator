import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import java.awt.event.WindowAdapter;

public class PaaIkkuna extends JFrame {

	private JPanel contentPane;
	private JTextField textField1;
	private JTextField textField2;
	private JTextField textField3;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmNewMenuItem_1;
	private JCheckBox checkbox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PaaIkkuna frame = new PaaIkkuna();
					frame.setVisible(true);
					frame.tulostaTiedostoon("Ohjelma käynnistyi");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PaaIkkuna() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				tulostaTiedostoon("Ohjelma suljettiin");
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 547, 347);

		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		mnNewMenu = new JMenu("Valikko");
		menuBar.add(mnNewMenu);

		mntmNewMenuItem = new JMenuItem("Tyhjenn\u00E4");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField1.setText("");
				textField2.setText("");
				textField3.setText("");
			}
		});
		mnNewMenu.add(mntmNewMenuItem);

		mntmNewMenuItem_1 = new JMenuItem("Lopeta");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int result = JOptionPane.showConfirmDialog(null, "lopetetaanko?", "Varotus!", JOptionPane.YES_NO_OPTION,
						JOptionPane.WARNING_MESSAGE);
				if (result == JOptionPane.YES_OPTION) {
					tulostaTiedostoon("Ohjelma lopetettiin");
					System.exit(0);
				}
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField1 = new JTextField();
		textField1.setBounds(89, 11, 86, 20);
		contentPane.add(textField1);
		textField1.setColumns(10);

		textField2 = new JTextField();
		textField2.setBounds(89, 34, 86, 20);
		contentPane.add(textField2);
		textField2.setColumns(10);

		textField3 = new JTextField();
		textField3.setBounds(89, 71, 86, 20);
		contentPane.add(textField3);
		textField3.setColumns(10);

		lblNewLabel = new JLabel("luku 1");
		lblNewLabel.setBounds(33, 14, 46, 14);
		contentPane.add(lblNewLabel);

		lblNewLabel_1 = new JLabel("luku 2");
		lblNewLabel_1.setBounds(33, 37, 46, 14);
		contentPane.add(lblNewLabel_1);

		lblNewLabel_2 = new JLabel("Tulos");
		lblNewLabel_2.setBounds(33, 74, 46, 14);
		contentPane.add(lblNewLabel_2);

		btnNewButton = new JButton("/");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnNewButton.setBounds(170, 198, 63, 54);
		contentPane.add(btnNewButton);

		btnNewButton_1 = new JButton("+");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String luku1 = textField1.getText();
				String luku2 = textField2.getText();
				try {
					int int_luku1 = Integer.parseInt(luku1);
					int int_luku2 = Integer.parseInt(luku2);

					int tulos = int_luku1 + int_luku2;
					textField3.setText(luku1 + " + " + luku2 + " = " + tulos);
					if (checkbox.isSelected()) {
						tulostaTiedostoon("Laskutoimitus : " + luku1 + " + " + luku2 + " = " + tulos);
					}

				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Laskutoimituksessa virheellinen syöte, aloita alusta!");
					textField1.setText("");
					textField2.setText("");
					textField3.setText("");
				}

			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnNewButton_1.setBounds(89, 121, 63, 54);
		contentPane.add(btnNewButton_1);

		btnNewButton_2 = new JButton("-");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnNewButton_2.setBounds(170, 121, 63, 54);
		contentPane.add(btnNewButton_2);

		btnNewButton_3 = new JButton("*");
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnNewButton_3.setBounds(89, 198, 63, 54);
		contentPane.add(btnNewButton_3);

		checkbox = new JCheckBox("Kirjoitetaan tulos tiedostoon");
		checkbox.setSelected(true);
		checkbox.setBounds(363, 229, 97, 23);
		contentPane.add(checkbox);
	}

	public void tulostaTiedostoon(String txt) {
		String filename = "src/Resources/nelilaskin.txt";
		try {
			java.util.Date date = new java.util.Date();
			// Valinta true lopussa aiheuttaa sen, että ei ylikirjoiteta vaan jatketaan
			// olemassa olevan perään
			FileWriter fwriter = new FileWriter(filename, true);
			fwriter.write(date.toString() + " : ");
			fwriter.write(txt + "\n");
			fwriter.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
