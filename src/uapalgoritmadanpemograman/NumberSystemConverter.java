package uapalgoritmadanpemograman;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NumberSystemConverter extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textInput;
	private JTable table;
	MethodPembantu bantuan = new MethodPembantu();
	JLabel lblhasilBiner;
	JLabel lblhasilDesimal;
	JLabel lblhasilHexa;
	JLabel lblhasilOktal;
	JLabel lblError;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NumberSystemConverter frame = new NumberSystemConverter();
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
	public NumberSystemConverter() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 813, 417);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Number System Converter");
		lblNewLabel.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 18));
		lblNewLabel.setBounds(267, 11, 258, 36);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Jenis Input :");
		lblNewLabel_1.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(28, 100, 119, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Input :");
		lblNewLabel_1_1.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 13));
		lblNewLabel_1_1.setBounds(76, 128, 71, 16);
		contentPane.add(lblNewLabel_1_1);
		
		JComboBox cbJenis = new JComboBox();
		cbJenis.setModel(new DefaultComboBoxModel(new String[] {"Biner", "Desimal", "Oktal", "Hexadesimal"}));
		cbJenis.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 13));
		cbJenis.setBounds(145, 98, 142, 22);
		contentPane.add(cbJenis);
		
		textInput = new JTextField();
		textInput.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 13));
		textInput.setBounds(145, 127, 142, 20);
		contentPane.add(textInput);
		textInput.setColumns(10);
		
		JButton btnProses = new JButton("PROSES");
		btnProses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblError.setText(null);
				int input;
				String jenis = cbJenis.getSelectedItem().toString();
				
				switch (jenis) {
				
				case "Biner" :
					input = Integer.parseInt(textInput.getText());
					String hasilbiner=Integer.toString(input);
					lblhasilBiner.setText(hasilbiner);
					boolean isBiner = bantuan.Binerkah(input);
					
					if (isBiner) {
						int desimal = bantuan.B2D(input);
						String hasildesimal = Integer.toString(desimal);
						lblhasilDesimal.setText(hasildesimal);
						
						int oktal = bantuan.D2O(desimal);
						String hasiloktal = Integer.toString(oktal);
						lblhasilOktal.setText(hasiloktal);
						
						String hexa = bantuan.D2H(desimal);
						lblhasilHexa.setText(hexa);
					} else {
						lblError.setText("Error! Biner hanya 0 dan 1!");
						lblhasilBiner.setText("0");
						lblhasilOktal.setText("0");
						lblhasilDesimal.setText("0");
						lblhasilHexa.setText("0");
					}
					break;
				case "Desimal" :
					input = Integer.parseInt(textInput.getText());
					String hasildesimal2 = Integer.toString(input);
					lblhasilDesimal.setText(hasildesimal2);
					
					int oktal2 = bantuan.D2O(input);
					String hasiloktal2 = Integer.toString(oktal2);
					lblhasilOktal.setText(hasiloktal2);
					
					String hexa2 = bantuan.D2H(input);
					lblhasilHexa.setText(hexa2);
					
					int biner2 = bantuan.D2B(input);
					String hasilbiner2 = Integer.toString(biner2);
					lblhasilBiner.setText(hasilbiner2);
					break;
				case "Oktal" :
					input = Integer.parseInt(textInput.getText());
					String hasiloktal3 = Integer.toString(input);
					lblhasilOktal.setText(hasiloktal3);
					
					int desimal3 = bantuan.O2D(input);
					String hasildesimal3 = Integer.toString(desimal3);
					lblhasilDesimal.setText(hasildesimal3);
					
					String hexa3 = bantuan.D2H(desimal3);
					lblhasilHexa.setText(hexa3);
					
					int biner3 = bantuan.D2B(desimal3);
					String hasilbiner3 = Integer.toString(biner3);
					lblhasilBiner.setText(hasilbiner3);
					break;
				case "Hexadesimal":
					String hexa4 = textInput.getText();
					String untukhexa = hexa4.toUpperCase();
					lblhasilHexa.setText(untukhexa);
					
					int desimal4 = bantuan.H2D(untukhexa);
					String hasildesimal4 = Integer.toString(desimal4);
					lblhasilDesimal.setText(hasildesimal4);
					
					int biner4 = bantuan.D2B(desimal4);
					String hasilbiner4 = Integer.toString(biner4);
					lblhasilBiner.setText(hasilbiner4);
					
					int oktal4 = bantuan.D2O(desimal4);
					String hasiloktal4 = Integer.toString(oktal4);
					lblhasilOktal.setText(hasiloktal4);
					break;
				}
				
				int x = Integer.parseInt(lblhasilBiner.getText());
				boolean isBiner = bantuan.Binerkah(x);
				if (x>1111111111 || !isBiner) {
					lblError.setText("Error! Nilai Biner Melebihi Batas Integer");
					lblhasilBiner.setText("-");
				}
				String[] hasil = new String[4];
				hasil[0]=lblhasilBiner.getText();
				hasil[1]=lblhasilDesimal.getText();
				hasil[2]=lblhasilOktal.getText();
				hasil[3]=lblhasilHexa.getText();
				
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(hasil);
			}
		});
		btnProses.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 13));
		btnProses.setBounds(299, 126, 89, 23);
		contentPane.add(btnProses);
		
		JLabel lblNewLabel_1_2 = new JLabel("Biner       :");
		lblNewLabel_1_2.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 13));
		lblNewLabel_1_2.setBounds(28, 185, 119, 16);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Desimal     :");
		lblNewLabel_1_3.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 13));
		lblNewLabel_1_3.setBounds(28, 212, 119, 16);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Oktal       :");
		lblNewLabel_1_4.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 13));
		lblNewLabel_1_4.setBounds(28, 239, 119, 16);
		contentPane.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("Hexadesimal :");
		lblNewLabel_1_5.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 13));
		lblNewLabel_1_5.setBounds(28, 266, 119, 16);
		contentPane.add(lblNewLabel_1_5);
		
		lblhasilBiner = new JLabel("");
		lblhasilBiner.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 13));
		lblhasilBiner.setBounds(145, 187, 119, 16);
		contentPane.add(lblhasilBiner);
		
		lblhasilDesimal = new JLabel("");
		lblhasilDesimal.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 13));
		lblhasilDesimal.setBounds(145, 214, 119, 16);
		contentPane.add(lblhasilDesimal);
		
		lblhasilOktal = new JLabel("");
		lblhasilOktal.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 13));
		lblhasilOktal.setBounds(145, 241, 119, 16);
		contentPane.add(lblhasilOktal);
		
		lblhasilHexa = new JLabel("");
		lblhasilHexa.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 13));
		lblhasilHexa.setBounds(145, 266, 119, 16);
		contentPane.add(lblhasilHexa);
		
		table = new JTable();
		table.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 13));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"Biner", "Desimal", "Oktal", "Hexadesimal"},
			},
			new String[] {
				"New column", "New column", "New column", "New column"
			}
		));
		table.setBounds(420, 130, 369, 210);
		contentPane.add(table);
		
		JButton btnReset = new JButton("RESET");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.setRowCount(1);
			}
		});
		btnReset.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 13));
		btnReset.setBounds(566, 351, 89, 23);
		contentPane.add(btnReset);
		
		JLabel lblNewLabel_1_6 = new JLabel("Histori Konversi");
		lblNewLabel_1_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_6.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 13));
		lblNewLabel_1_6.setBounds(508, 100, 187, 16);
		contentPane.add(lblNewLabel_1_6);
		
		lblError = new JLabel("");
		lblError.setHorizontalAlignment(SwingConstants.CENTER);
		lblError.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 13));
		lblError.setBounds(28, 318, 360, 22);
		contentPane.add(lblError);
	}
}
