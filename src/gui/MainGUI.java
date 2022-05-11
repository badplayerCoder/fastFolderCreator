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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MainGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textAmount;
	private JTextField textStart;
	private JTextField textLimit;

	private CreateFile create;
	private JTextField textHeadFolder;
	
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
		setBounds(100, 100, 310, 172);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		
		textAmount = new JTextField();
		textAmount.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				ActionHandler.integerHandler(e, textAmount);
			}
		});
		textAmount.setBounds(10, 100, 155, 20);
		contentPane.add(textAmount);
		textAmount.setColumns(10);
		
		textStart = new JTextField();
		textStart.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				ActionHandler.integerHandler(e, textStart);
			}
		});
		textStart.setBounds(10, 60, 155, 20);
		contentPane.add(textStart);
		textStart.setColumns(10);
		
		JLabel lblMin = new JLabel("Start mappe nummer");
		lblMin.setHorizontalAlignment(SwingConstants.CENTER);
		lblMin.setBounds(10, 44, 155, 14);
		contentPane.add(lblMin);
		
		JLabel lblMax = new JLabel("Antal");
		lblMax.setHorizontalAlignment(SwingConstants.CENTER);
		lblMax.setBounds(10, 84, 155, 14);
		contentPane.add(lblMax);
		
		textLimit = new JTextField();
		textLimit.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				ActionHandler.integerHandler(e, textLimit);
			}
		});
		textLimit.setText("20");
		textLimit.setBounds(239, 21, 42, 20);
		contentPane.add(textLimit);
		textLimit.setColumns(10);
		
		JLabel lblLimit = new JLabel("Begrænsning");
		lblLimit.setHorizontalAlignment(SwingConstants.CENTER);
		lblLimit.setBounds(215, 6, 89, 14);
		contentPane.add(lblLimit);
		
		JLabel lblCreator = new JLabel("Lavet af lassehas");
		lblCreator.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreator.setBounds(6, 124, 120, 14);
		contentPane.add(lblCreator);
		
		JButton btnNewButton = new JButton("Opret");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					create.createFolders(getHeadFolder(), getStart(), getAmount(), getLimit());
				} catch (IOException e1) {
					System.out.println(e1.getMessage());
				}
			}
		});
		btnNewButton.setBounds(200, 100, 104, 23);
		contentPane.add(btnNewButton);
		
		textHeadFolder = new JTextField();
		textHeadFolder.setBounds(10, 21, 155, 20);
		contentPane.add(textHeadFolder);
		textHeadFolder.setColumns(10);
		
		JLabel lbl = new JLabel("Hovedmappe navn");
		lbl.setHorizontalAlignment(SwingConstants.CENTER);
		lbl.setBounds(10, 5, 155, 16);
		contentPane.add(lbl);
		
		init();
	}
	
	private void init() {
		create = new CreateFile();
	}
	
	private int getStart() {
		int n = !textStart.getText().isEmpty() ? Integer.parseInt(textStart.getText()) : 0;
		return n;
		}
	private int getAmount() {
		int n = !textAmount.getText().isEmpty() ? Integer.parseInt(textAmount.getText()) : 0;
		return n;
	}
	private int getLimit() {
		int n = !textLimit.getText().isEmpty() ? Integer.parseInt(textLimit.getText()) : 0;
		return n;
	}
	
	private String getHeadFolder() {
		return textHeadFolder.getText();
	}
}
