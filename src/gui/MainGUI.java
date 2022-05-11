package gui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class MainGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textAmount;
	private JTextField textStart;
	private JTextField textLimit;

	private CreateFile create;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGUI frame = new MainGUI();
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
	public MainGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 296, 172);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		textAmount = new JTextField();
		textAmount.setBounds(10, 100, 119, 20);
		contentPane.add(textAmount);
		textAmount.setColumns(10);
		
		textStart = new JTextField();
		textStart.setBounds(10, 60, 119, 20);
		contentPane.add(textStart);
		textStart.setColumns(10);
		
		JLabel lblMin = new JLabel("Start mappe nummer");
		lblMin.setHorizontalAlignment(SwingConstants.CENTER);
		lblMin.setBounds(10, 44, 119, 14);
		contentPane.add(lblMin);
		
		JLabel lblMax = new JLabel("Antal");
		lblMax.setHorizontalAlignment(SwingConstants.CENTER);
		lblMax.setBounds(10, 84, 119, 14);
		contentPane.add(lblMax);
		
		textLimit = new JTextField();
		textLimit.setText("20");
		textLimit.setBounds(228, 21, 42, 20);
		contentPane.add(textLimit);
		textLimit.setColumns(10);
		
		JLabel lblLimit = new JLabel("Limit");
		lblLimit.setHorizontalAlignment(SwingConstants.CENTER);
		lblLimit.setBounds(228, 6, 42, 14);
		contentPane.add(lblLimit);
		
		JLabel lblCreator = new JLabel("LH");
		lblCreator.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreator.setBounds(0, 119, 33, 14);
		contentPane.add(lblCreator);
		
		JButton btnNewButton = new JButton("Opret");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					create.createFolders(getStart(), getAmount(), getLimit());
				} catch (IOException e1) {
					System.out.println(e1.getMessage());
				}
			}
		});
		btnNewButton.setBounds(200, 99, 70, 23);
		contentPane.add(btnNewButton);
		
		init();
	}
	
	private void init() {
		create = new CreateFile();
	}
	
	private int getStart() {
		return Integer.parseInt(textStart.getText());
		}
	private int getAmount() {
		return Integer.parseInt(textAmount.getText());
	}
	private int getLimit() {
		return Integer.parseInt(textLimit.getText());
	}
}
