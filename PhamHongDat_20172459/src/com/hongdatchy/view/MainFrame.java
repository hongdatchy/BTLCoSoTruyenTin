package com.hongdatchy.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;

public class MainFrame {
	private JFrame frame;
	private JTextField addProField;
	private JTextField lField;
	private JTextArea proArea = new JTextArea();
	private JTextArea lengthTumaArea = new JTextArea();
	private JTextArea tumaArea = new JTextArea();
    private String str="";
    private List <Float>listPro = new ArrayList<Float>();
    private List <String>listTuma = new ArrayList<String>();
    private boolean clr= false;
    private JTextField entropyField;
    private JTextField bitsField;
    private JTextField resultField;
    private int myLength; 
	
    
    // Hàm Main
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame window = new MainFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	// End hàm main

	
	// Hàm MainFrame
	public MainFrame() {
		initialize();
	}
	// End hàm MainFrame
	
	
	// Init content
	private void initialize() {
		frame = new JFrame("Mã hóa bằng phương pháp Shannon và Huffman");// Tiltle
		frame.setBounds(100, 100, 700, 450);// Set Position
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		// 1 số model khác
		addProField = new JTextField();
		addProField.setBounds(217, 35, 108, 20);
		frame.getContentPane().add(addProField);
		addProField.setColumns(10);
		
		JButton clearBtn = new JButton("Clear");
		clearBtn.setBounds(415, 34, 89, 23);
		frame.getContentPane().add(clearBtn);
		
		JLabel proLabel = new JLabel("X\u00E1c xu\u1EA5t");
		proLabel.setHorizontalAlignment(SwingConstants.CENTER);
		proLabel.setBounds(59, 132, 114, 14);
		frame.getContentPane().add(proLabel);
		
		JLabel lengthTumaLabel = new JLabel("\u0110\u1ED9 d\u00E0i t\u1EEB m\u00E3");
		lengthTumaLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lengthTumaLabel.setBounds(217, 132, 135, 14);
		frame.getContentPane().add(lengthTumaLabel);
		lengthTumaArea.setEditable(false);
		
		lengthTumaArea.setBounds(217, 157, 135, 150);
		frame.getContentPane().add(lengthTumaArea);
		proArea.setEditable(false);
		
		proArea.setBounds(59, 157, 114, 150);
		frame.getContentPane().add(proArea);
		
		JLabel tumaBtn = new JLabel("T\u1EEB m\u00E3");
		tumaBtn.setHorizontalAlignment(SwingConstants.CENTER);
		tumaBtn.setBounds(414, 132, 136, 14);
		frame.getContentPane().add(tumaBtn);
		tumaArea.setEditable(false);
		
		tumaArea.setBounds(415, 157, 135, 150);
		frame.getContentPane().add(tumaArea);
		
		JLabel lblNewLabel = new JLabel("Chi\u1EC1u d\u00E0i t\u1EEB m\u00E3 trung b\u00ECnh");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(21, 318, 187, 14);
		frame.getContentPane().add(lblNewLabel);
		
		lField = new JTextField();
		lField.setBounds(59, 343, 114, 20);
		frame.getContentPane().add(lField);
		lField.setColumns(10);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 684, 23);
		frame.getContentPane().add(menuBar);
		
		JMenu mahoaBtn = new JMenu("Mã hóa");
		menuBar.add(mahoaBtn);
		
		JMenu giaimaBtn = new JMenu("Giải mã");
		menuBar.add(giaimaBtn);
		
		JMenu aboutBtn = new JMenu("About");
		menuBar.add(aboutBtn);
		
		JMenuItem aboutme = new JMenuItem("About me");
		aboutme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"by Phạm Hồng Đạt 20172459", "", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		aboutme.setHorizontalAlignment(SwingConstants.CENTER);
		aboutBtn.add(aboutme);
		
		JLabel entropyLabel = new JLabel("Entropy");
		entropyLabel.setHorizontalAlignment(SwingConstants.CENTER);
		entropyLabel.setBounds(218, 318, 135, 14);
		frame.getContentPane().add(entropyLabel);
		
		entropyField = new JTextField();
		entropyField.setBounds(218, 343, 135, 20);
		frame.getContentPane().add(entropyField);
		entropyField.setColumns(10);
		
		bitsField = new JTextField();
		bitsField.setBounds(217, 73, 287, 20);
		frame.getContentPane().add(bitsField);
		bitsField.setColumns(10);
		
		resultField = new JTextField();
		resultField.setBounds(217, 101, 287, 20);
		frame.getContentPane().add(resultField);
		resultField.setColumns(10);
		
		JLabel bitsLabel = new JLabel("Nhập dãy bit");
		bitsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		bitsLabel.setBounds(59, 76, 114, 14);
		frame.getContentPane().add(bitsLabel);
		
		JLabel resultLabel = new JLabel("Kết quả giải mã");
		resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
		resultLabel.setBounds(59, 104, 114, 14);
		frame.getContentPane().add(resultLabel);
	// End 1 số model khác
		
		
	// Thêm xác suất
		JButton probabilityBtn = new JButton("Th\u00EAm x\u00E1c xu\u1EA5t");
		probabilityBtn.addActionListener(new ActionListener() {// Add action cho Button
			public void actionPerformed(ActionEvent arg0) {
				String s= addProField.getText();
				if(s.matches("^0\\.[0-9]+$")) {
					str+=s+"\n";
					proArea.setText(str);
					listPro.add(Float.valueOf(s));
				}
				else {
					JOptionPane.showMessageDialog(null,"Nhập giá trị 0 < P(x) < 1", "lỗi", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		probabilityBtn.setBounds(36, 34, 153, 23);
		frame.getContentPane().add(probabilityBtn);
	// End thêm xác suất	
		
		
	// Mã hóa shannon 
		JMenuItem shannonMahoaBtn = new JMenuItem("Shannon");
		shannonMahoaBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Float tmp;
				Float sumPro=(float) 0;
				if(clr==false) {
					sumPro=(float) 0;
					clr=true;
				}
				myLength = listPro.size();
				for(int i=0; i < myLength; i++) {
					sumPro+=listPro.get(i);
				}
				if(sumPro<1) {
					JOptionPane.showMessageDialog(null,"Tổng xác suất phải bằng 1", "lỗi", JOptionPane.INFORMATION_MESSAGE);
				}else {
					if(sumPro>1) {
						JOptionPane.showMessageDialog(null,"Tổng xác suất đã lớn 1\nnhấn Clear để nhập lại", "lỗi", JOptionPane.INFORMATION_MESSAGE);
					}else {
						String str3="";
						Float[] arrPro= new Float[myLength];
						for(int i=0; i < myLength; i++) {
							arrPro[i]=listPro.get(i);
							sumPro+=arrPro[i];
						}
						for (int i = 0; i < myLength; i++) {
							for(int j=i; j<myLength; j++) {
								if(arrPro[j]> arrPro[i]) {
									tmp= arrPro[j];
									arrPro[j]= arrPro[i];
									arrPro[i]= tmp;
								}
							}
						}
						Float[] arrPro2= new Float[myLength];
						for(int i = 0; i < myLength; i++) {
							float s=0;
							for(int j=0; j<i; j++) {
								s+=arrPro[j];
							}
							arrPro2[i]=s;
							str3+=String.valueOf(arrPro[i])+"\n";
						}
						proArea.setText(str3);
						
						arrPro2[0]=(float) 0;
						String str="", str2="";
						for(int i = 0; i < myLength; i++) {
							str+=String.valueOf(getLengthTuma(arrPro[i]))+"\n";
							str2+=getBit(arrPro2[i], getLengthTuma(arrPro[i]))+"\n";
							listTuma.add(getBit(arrPro2[i], getLengthTuma(arrPro[i])));
						}
						lengthTumaArea.setText(str);
						tumaArea.setText(str2);
						
						float L=(float)0;
						for(int i = 0; i < myLength; i++) {
							L+=arrPro[i]*getLengthTuma(arrPro[i]);
						}
						lField.setText(String.valueOf(L));
						
						float en=(float)0;
						for(int i = 0; i < myLength; i++) {
							en+=-log2(arrPro[i])*arrPro[i];
						}
						entropyField.setText(String.valueOf(en));
						
					}
				}			
			}
		});	
		shannonMahoaBtn.setHorizontalAlignment(SwingConstants.CENTER);
		shannonMahoaBtn.setHorizontalTextPosition(SwingConstants.CENTER);
		mahoaBtn.add(shannonMahoaBtn);
	// End mã hóa shannon 
		
	
	// Mã hóa huffman 	
		JMenuItem huffmanMahoaBtn = new JMenuItem("Huffman");
		huffmanMahoaBtn.setHorizontalAlignment(SwingConstants.CENTER);
		mahoaBtn.add(huffmanMahoaBtn);
	// End mã hóa huffman 
		
		
	// Giải mã shannon
		JMenuItem shannonGiaimaBtn = new JMenuItem("Shannon");
		shannonGiaimaBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s= bitsField.getText();
				String regex= "^[0-1]+$";
				Pattern pattern;
			    Matcher matcher;
				pattern= Pattern.compile(regex);
				matcher= pattern.matcher(s);
				if(matcher.find()) {
					String arr[] = new String[myLength];
					for (int i = 0; i < myLength; i++) {
						arr[i]= listTuma.get(i);
					}
					int i=0, dem= 0;
					String resultText= "";
					while(true) {
						if(s.indexOf(arr[i])==0) {
							resultText += "x" +(i+1) +" ";
							s=s.substring(arr[i].length());
						}else {
							i++;
						}
						if(s.length()==0) {
							break;
						}
						if(i== myLength  && s.length()!=0) {
							i=0;
							dem++;
						}
						if(dem==10) {
							break;
						}
					}
					if(dem== 10) {
						resultField.setText("Mã Bit không thỏa mãn");
					}
					else{
						resultField.setText(resultText);
					}
				}
				else {
					JOptionPane.showMessageDialog(null,"Nhập lại giá trị mã Bit", "lỗi", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		shannonGiaimaBtn.setHorizontalAlignment(SwingConstants.CENTER);
		giaimaBtn.add(shannonGiaimaBtn);
	// End giải mã shannon
		
	
	// Giải mã huffman
		JMenuItem huffmanGiaimaBtn = new JMenuItem("Huffman");
		huffmanGiaimaBtn.setHorizontalAlignment(SwingConstants.CENTER);
		giaimaBtn.add(huffmanGiaimaBtn);
	// End giải mã huffman
		
		
	// Clear
		clearBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				str="";
				clr= true;
				listPro.clear();
				proArea.setText("");
				tumaArea.setText("");
				lengthTumaArea.setText("");
			}
		});
	// End clear			
	}
	// End init content
	
	
	private Float log2(double d) {
		return (float) (Math.log10(d)/Math.log10(2));
	}
	
	
	private int getLengthTuma(double d) {
		int rs=0;
		float i=-log2(d);
		rs= (int)i;
		double du =i-rs;
		if(du!=0) {
			rs++;
		}
		return rs;
	}
	
	
	private String getBit(double d, int lengthTuma) {
		String rs="";
		int count=0;
		float s=(float) 0;
		while(d!=0 && count!=lengthTuma) {
			d*=2;
			int nguyen= (int)d;
			double du =d-nguyen;
			count++;
			s+=nguyen*Math.pow(10, -count);
			d=du;
		}
		s=(float) (s*Math.pow(10, lengthTuma));
		int bit=(int) s;
		for(int i=0; i<lengthTuma; i++) {
			int nguyen=(int) (bit/Math.pow(10, lengthTuma-i-1));
			int du=(int) (bit-nguyen*Math.pow(10, lengthTuma-i-1));
			bit=du;
			rs+= String.valueOf(nguyen);
		}
		return rs;
	}
}
