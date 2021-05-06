import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ManufacturingMower {
	public MowerWareHouse mowed;
	public LawnTractor lt;
	public Engine engine;
	public Mower mow;
	public CommercialMower com;
	public GasPoweredMower cap;
	public PushReelMower push;

	public ManufacturingMower() throws IOException {
		//File fn = new File("inp.txt");
		
		//FileInputStream f = new FileInputStream(fn); 
		//Scanner scnr = new Scanner(f);
		 mowed = new MowerWareHouse();
		
		mowed.readMowerData("inp.txt");
		mowed.saveMowertData("out.txt");
		//System.out.println(mowed.toString());
		//System.out.println();
		
		JFrame mainFrame = new JFrame("Java Swing Examples");
		JPanel buttonPanel = new JPanel(new GridBagLayout());
		JPanel mainPanel = new JPanel(new BorderLayout());
		GridBagConstraints layoutConst = new GridBagConstraints();
		
		mainFrame.setLayout(new GridBagLayout());
		
		
		
		mainFrame.addWindowListener(( new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent) {
				
			}
		}));
		
		layoutConst.fill = GridBagConstraints.VERTICAL;
		
		JButton view = new JButton ("View");
		layoutConst.gridx = 0;
		layoutConst.gridy = 0;
		mainFrame.add(view, layoutConst);
		
		view.addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(mowed.toString());
			}
		});
		
		JButton add = new JButton("Add");
		layoutConst.gridx = 0;
		layoutConst.gridy = 1;
		mainFrame.add(add, layoutConst);
		
		add.addActionListener((ActionListener) new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame mainFrame1 = new JFrame("Mower Type");
				GridBagConstraints layoutConst1 = new GridBagConstraints();
				// TODO Auto-generated method stub
						mainFrame1.setLayout(new GridBagLayout());
						
						mainFrame.addWindowListener(( new WindowAdapter() {
							public void windowClosing(WindowEvent windowEvent) {
								
							}
						}));
						
						layoutConst1.fill = GridBagConstraints.VERTICAL;
						
						JButton lawnTractor = new JButton("LawnTractor");
						layoutConst1.gridx = 0;
						layoutConst1.gridy = 0;
						mainFrame1.add(lawnTractor, layoutConst1);
						
						lawnTractor.addActionListener(new lawnTractorForm());
						
						
						JButton CommercialMower = new JButton("Commercial Mower");
						layoutConst1.gridx = 0;
						layoutConst1.gridy = 1;
						mainFrame1.add(CommercialMower, layoutConst1);
						
						CommercialMower.addActionListener(new CommercialMowerForm());
						
						JButton GasPoweredMower = new JButton("Gas Powered Mower");
						layoutConst1.gridx = 0;
						layoutConst1.gridy = 2;
						mainFrame1.add(GasPoweredMower, layoutConst1);
						
						GasPoweredMower.addActionListener(new GasPoweredMowerForm());
						
						JButton PushReelMower = new JButton("Push Reel Mower");
						layoutConst1.gridx = 0;
						layoutConst1.gridy = 3;
						mainFrame1.add(PushReelMower, layoutConst1);
						
						PushReelMower.addActionListener(new PushReelForm());
						
						mainFrame1.pack();
						mainFrame1.setSize(250, 250);
						mainFrame1.setVisible(true);
				
			}
			
			
			
		});
		
		
		JButton load = new JButton("Load");
		layoutConst.gridx = 0;
		layoutConst.gridy = 2;
		mainFrame.add(load, layoutConst);
		
		JLabel tLabel = new JLabel("", JLabel.CENTER);
		
		load.addActionListener((ActionListener) new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				JFileChooser choice = new JFileChooser();
				
				choice.setCurrentDirectory(new File("/Users/jordanmozebo/eclipse-workspace/MajorProgramming/inp.txt "));
				
				int r = choice.showOpenDialog(new JFrame());
				
				if(r == JFileChooser.APPROVE_OPTION) {
					File SFile = choice.getSelectedFile();
					
					System.out.println("Selected File: " + SFile.getAbsoluteFile());
					
					String path = SFile.getPath();
					
					try {
						mowed.readMowerData(path);
						
					}
					catch (Exception el) {
						el.printStackTrace();
					}
				}
				
			}
			
		});
		
		JButton saving = new JButton("Save");
		layoutConst.gridx = 0;
		layoutConst.gridy = 3;
		mainFrame.add(saving, layoutConst);
		mainFrame.add(tLabel);
		
		
		
		saving.addActionListener((ActionListener) new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				JFileChooser choice = new JFileChooser();
				
				choice.setCurrentDirectory(new File("/Users/jordanmozebo/eclipse-workspace/MajorProgramming/out.txt "));
				
				int r = choice.showOpenDialog(new JFrame());
				
				if(r == JFileChooser.APPROVE_OPTION) {
					File SFile = choice.getSelectedFile();
					
					System.out.println("Selected File: " + SFile.getAbsoluteFile());
					
					String path = SFile.getPath();
					
					try {
						mowed.saveMowertData(path);
						
					}
					catch (Exception el) {
						el.printStackTrace();
					}
				}
				
			}
			
		});
		
		JButton exit = new JButton("Exit");
		layoutConst.gridx = 0;
		layoutConst.gridy = 4;
		
		mainFrame.add(exit,layoutConst);
		
		exit.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		
		//scnr.close();
		
		mainFrame.pack();
		mainFrame.setSize(300, 250);
		mainFrame.setVisible(true);
				

	}
	public static void main(String[] args) throws IOException {
		ManufacturingMower mw = new ManufacturingMower();
	}
class lawnTractorForm implements ActionListener {
	private JFrame TractorFrame;
	private JTextField manufacturer;
	private JTextField Enginemanufacturer;
	private JTextField cyl;
	private JTextField horsePower;
	private JTextField model;
	private JTextField deckWidth;
	private JTextField MowerManufacturer;
	private JTextField year;
	private JTextField SNumber;
	private JTextField mowerType;
	private JLabel EnginemanLabel;
	private JLabel cylinderLabel;
	private JLabel horsePowerLabel;
	private JLabel deckWidthLabel;
	private JLabel modelLabel;
	private JLabel manufacturerLabel;
	private JLabel MowerManufacturerLabel;
	private JLabel yearLabel;
	private JLabel SNumberLabel;
	private JLabel mowerTypeLabel;
	private JButton submit;
	private JButton exit;
	private JPanel controlPanel;
	

	@Override
	public void actionPerformed(ActionEvent e) {
		TractorFrame = new JFrame();
		TractorFrame.setBounds(300,90,900,300);
		TractorFrame.setResizable(true);
		controlPanel = new JPanel();
		controlPanel.setLayout(null);
		
		EnginemanLabel = new JLabel("Engine Manufacturer");
		EnginemanLabel.setSize(100, 20);
		EnginemanLabel.setLocation(100, 100);
		controlPanel.add(EnginemanLabel);
		
		Enginemanufacturer =  new JTextField(100);
		Enginemanufacturer.setSize(200, 20);
		Enginemanufacturer.setLocation(200, 100);
		controlPanel.add(Enginemanufacturer);
		
		cylinderLabel = new JLabel("Cylinder");
		cylinderLabel.setSize(100, 20);
		cylinderLabel.setLocation(100, 150);
		controlPanel.add(cylinderLabel);
		cyl = new JTextField(100);
		cyl.setSize(100, 20);
		cyl.setLocation(200, 150);
		controlPanel.add(cyl);
		
		horsePowerLabel = new JLabel("Horse Power");
		horsePowerLabel.setSize(100, 20);
		horsePowerLabel.setLocation(100, 200);
		controlPanel.add(horsePowerLabel);
		horsePower = new JTextField(100);
		horsePower.setSize(100, 20);
		horsePower.setLocation(200, 200);
		controlPanel.add(horsePower);
		
		
		manufacturerLabel = new JLabel("Enter manufacturer");
		manufacturerLabel.setSize(100, 20);
		manufacturerLabel.setLocation(100, 250);
		controlPanel.add(manufacturerLabel);
		manufacturer = new JTextField(100);
		manufacturer.setSize(190, 20);
		manufacturer.setLocation(200, 250);
		controlPanel.add(manufacturer);
		
		modelLabel = new JLabel("Model");
		modelLabel.setSize(100, 20);
		modelLabel.setLocation(100, 300);
		controlPanel.add(modelLabel);
		model = new JTextField(100);
		model.setSize(100, 20);
		model.setLocation(200, 300);
		controlPanel.add(model);
		
		deckWidthLabel = new JLabel("DeckWidth");
		deckWidthLabel.setSize(100, 20);
		deckWidthLabel.setLocation(100, 350);
		controlPanel.add(deckWidthLabel);
		deckWidth = new JTextField(100);
		deckWidth.setSize(100, 20);
		deckWidth.setLocation(200, 350);
		controlPanel.add(deckWidth);
		
		MowerManufacturerLabel = new JLabel("Mower manufacturer");
		MowerManufacturerLabel.setSize(100, 20);
		MowerManufacturerLabel.setLocation(100, 400);
		controlPanel.add(MowerManufacturerLabel);
		MowerManufacturer = new JTextField(100);
		MowerManufacturer.setSize(100, 20);
		MowerManufacturer.setLocation(200, 400);
		controlPanel.add(MowerManufacturer);
		
		yearLabel = new JLabel("year");
		yearLabel.setSize(100, 20);
		yearLabel.setLocation(100, 450);
		controlPanel.add(yearLabel);
		year = new JTextField(100);
		year.setSize(100, 20);
		year.setLocation(200, 450);
		controlPanel.add(year);
		
		SNumberLabel = new JLabel("Serial Number");
		SNumberLabel.setSize(100, 20);
		SNumberLabel.setLocation(100, 500);
		controlPanel.add(SNumberLabel);
		SNumber = new JTextField(100);
		SNumber.setSize(100,20);
		SNumber.setLocation(200, 500);
		controlPanel.add(SNumber);
		
		mowerTypeLabel = new JLabel("Type of Mower");
		mowerTypeLabel.setSize(100, 20);
		mowerTypeLabel.setLocation(100, 550);
		controlPanel.add(mowerTypeLabel);
		mowerType = new JTextField(100);
		mowerType.setSize(100, 20);
		mowerType.setLocation(200, 550);
		controlPanel.add(mowerType);
		
		
		submit = new JButton("submit");
		submit.setSize(100,20);
		submit.setLocation(150, 600);
		controlPanel.add(submit);
		
		exit = new JButton("exit");
		exit.setSize(100, 20);
		exit.setLocation(300, 600);
		controlPanel.add(exit);
		
		TractorFrame.add(controlPanel);
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lt = new LawnTractor();
				engine = new Engine();
				String mowerMan = "";
				int mowerYear = 0;
				String serNumber = "";
				String mowType = "";
				String manuF = "";
				double hPower = 0.0; 
				int cylind = 0;
				String mode = "";
				double deckW = 0.0;
				
				manuF = Enginemanufacturer.getText();
				hPower = Double.parseDouble(horsePower.getText());
				cylind = Integer.parseInt(cyl.getText());
				mode = model.getText();
				deckW = Double.parseDouble(deckWidth.getText());
				mowerMan = MowerManufacturer.getText();
				mowerYear = Integer.parseInt(year.getText());
				serNumber = SNumber.getText();
				mowType = mowerType.getText();
				engine.setManufacturer(manuF);
				engine.setHorsePower(hPower);
				engine.setCylinders(cylind);
				
				lt.setEngine(engine);
				lt.setModel(mode);
				lt.setDeckWidth(deckW);
				lt.setManufacturer(mowerMan);
				lt.setYear(mowerYear);
				lt.setSerialNumber(serNumber);
				lt.setMowerType(mowType);
				mowed.addMower(lt);
				
			}
		});
		
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		
		TractorFrame.setVisible(true);
		
		// TODO Auto-generated method stub
		
	}
	
}
class CommercialMowerForm implements ActionListener{
	private JFrame MowerFrame;
	private JPanel controlPanel;
	private JLabel operatingHoursLabel;
	private JLabel zeroTRadiusLabel;
	private JTextField operatingHours;
	private JTextField zeroTRadius;
	private JTextField manufacturer;
	private JTextField Enginemanufacturer;
	private JTextField cyl;
	private JTextField horsePower;
	private JTextField model;
	private JTextField deckWidth;
	private JTextField MowerManufacturer;
	private JTextField year;
	private JTextField SNumber;
	private JTextField mowerType;
	private JLabel EnginemanLabel;
	private JLabel cylinderLabel;
	private JLabel horsePowerLabel;
	private JLabel deckWidthLabel;
	private JLabel modelLabel;
	private JLabel manufacturerLabel;
	private JLabel MowerManufacturerLabel;
	private JLabel yearLabel;
	private JLabel SNumberLabel;
	private JLabel mowerTypeLabel;
	private JButton submit;
	private JButton exit;

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		MowerFrame = new JFrame();
		MowerFrame.setBounds(300,90,900,300);
		MowerFrame.setResizable(true);
		controlPanel = new JPanel();
		controlPanel.setLayout(null);
		
		
		EnginemanLabel = new JLabel("Engine Manufacturer");
		EnginemanLabel.setSize(100, 20);
		EnginemanLabel.setLocation(100, 100);
		controlPanel.add(EnginemanLabel);
		
		Enginemanufacturer =  new JTextField(100);
		Enginemanufacturer.setSize(200, 20);
		Enginemanufacturer.setLocation(200, 100);
		controlPanel.add(Enginemanufacturer);
		
		cylinderLabel = new JLabel("Cylinder");
		cylinderLabel.setSize(100, 20);
		cylinderLabel.setLocation(100, 150);
		controlPanel.add(cylinderLabel);
		cyl = new JTextField(100);
		cyl.setSize(100, 20);
		cyl.setLocation(200, 150);
		controlPanel.add(cyl);
		
		horsePowerLabel = new JLabel("Horse Power");
		horsePowerLabel.setSize(100, 20);
		horsePowerLabel.setLocation(100, 200);
		controlPanel.add(horsePowerLabel);
		horsePower = new JTextField(100);
		horsePower.setSize(100, 20);
		horsePower.setLocation(200, 200);
		controlPanel.add(horsePower);
		
		
		manufacturerLabel = new JLabel("Enter manufacturer");
		manufacturerLabel.setSize(100, 20);
		manufacturerLabel.setLocation(100, 250);
		controlPanel.add(manufacturerLabel);
		manufacturer = new JTextField(100);
		manufacturer.setSize(190, 20);
		manufacturer.setLocation(200, 250);
		controlPanel.add(manufacturer);
		
		modelLabel = new JLabel("Model");
		modelLabel.setSize(100, 20);
		modelLabel.setLocation(100, 300);
		controlPanel.add(modelLabel);
		model = new JTextField(100);
		model.setSize(100, 20);
		model.setLocation(200, 300);
		controlPanel.add(model);
		
		deckWidthLabel = new JLabel("DeckWidth");
		deckWidthLabel.setSize(100, 20);
		deckWidthLabel.setLocation(100, 350);
		controlPanel.add(deckWidthLabel);
		deckWidth = new JTextField(100);
		deckWidth.setSize(100, 20);
		deckWidth.setLocation(200, 350);
		controlPanel.add(deckWidth);
		
		MowerManufacturerLabel = new JLabel("Mower manufacturer");
		MowerManufacturerLabel.setSize(100, 20);
		MowerManufacturerLabel.setLocation(100, 400);
		controlPanel.add(MowerManufacturerLabel);
		MowerManufacturer = new JTextField(100);
		MowerManufacturer.setSize(100, 20);
		MowerManufacturer.setLocation(200, 400);
		controlPanel.add(MowerManufacturer);
		
		yearLabel = new JLabel("year");
		yearLabel.setSize(100, 20);
		yearLabel.setLocation(100, 450);
		controlPanel.add(yearLabel);
		year = new JTextField(100);
		year.setSize(100, 20);
		year.setLocation(200, 450);
		controlPanel.add(year);
		
		SNumberLabel = new JLabel("Serial Number");
		SNumberLabel.setSize(100, 20);
		SNumberLabel.setLocation(100, 500);
		controlPanel.add(SNumberLabel);
		SNumber = new JTextField(100);
		SNumber.setSize(100,20);
		SNumber.setLocation(200, 500);
		controlPanel.add(SNumber);
		
		mowerTypeLabel = new JLabel("Type of Mower");
		mowerTypeLabel.setSize(100, 20);
		mowerTypeLabel.setLocation(100, 550);
		controlPanel.add(mowerTypeLabel);
		mowerType = new JTextField(100);
		mowerType.setSize(100, 20);
		mowerType.setLocation(200, 550);
		controlPanel.add(mowerType);
		
		
		operatingHoursLabel = new JLabel("Operating Hours");
		operatingHoursLabel.setSize(100, 20);
		operatingHoursLabel.setLocation(100, 600);
		controlPanel.add(operatingHoursLabel);
		operatingHours =  new JTextField(100);
		operatingHours.setSize(200, 20);
		operatingHours.setLocation(200, 600);
		controlPanel.add(operatingHours);
		
		zeroTRadiusLabel = new JLabel("Radius");
		zeroTRadiusLabel.setSize(100, 20);
		zeroTRadiusLabel.setLocation(100, 650);
		controlPanel.add(zeroTRadiusLabel);
		zeroTRadius = new JTextField(100);
		zeroTRadius.setSize(100, 20);
		zeroTRadius.setLocation(200, 650);
		controlPanel.add(zeroTRadius);
		
		
		
		submit = new JButton("submit");
		submit.setSize(100,20);
		submit.setLocation(150, 700);
		controlPanel.add(submit);
		
		exit = new JButton("exit");
		exit.setSize(100, 20);
		exit.setLocation(150, 750);
		controlPanel.add(exit);
		
		MowerFrame.add(controlPanel);
		
		submit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				lt = new LawnTractor();
				engine = new Engine();
				String mowerMan = "";
				int mowerYear = 0;
				String serNumber = "";
				String mowType = "";
				String manuF = "";
				double hPower = 0.0; 
				int cylind = 0;
				String mode = "";
				double deckW = 0.0;
				
				manuF = Enginemanufacturer.getText();
				hPower = Double.parseDouble(horsePower.getText());
				cylind = Integer.parseInt(cyl.getText());
				mode = model.getText();
				deckW = Double.parseDouble(deckWidth.getText());
				mowerMan = MowerManufacturer.getText();
				mowerYear = Integer.parseInt(year.getText());
				serNumber = SNumber.getText();
				mowType = mowerType.getText();
				engine.setManufacturer(manuF);
				engine.setHorsePower(hPower);
				engine.setCylinders(cylind);
				
				lt.setEngine(engine);
				lt.setModel(mode);
				lt.setDeckWidth(deckW);
				lt.setManufacturer(mowerMan);
				lt.setYear(mowerYear);
				lt.setSerialNumber(serNumber);
				lt.setMowerType(mowType);
				
				
				com = new CommercialMower();
				double OpHours = 0.0;
				boolean zTRadius;
				
				OpHours = Double.parseDouble(operatingHours.getText());
				zTRadius = Boolean.parseBoolean(zeroTRadius.getText());
				com.setOperatingHours(OpHours);
				com.setZeroTurnRadius(zTRadius);
				lt.setM(com);
				mowed.addMower(lt);
				
				// TODO Auto-generated method stub
				
			}
			
		});
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		MowerFrame.setVisible(true);
		
	}
	
}
class GasPoweredMowerForm implements ActionListener{
	private JFrame PoweredFrame;
	private JLabel EnginemanLabel;
	private JLabel cylinderLabel;
	private JLabel horsePowerLabel;
	private JLabel cutWLabel;
	private JLabel wheelDLabel;
	private JTextField Enginemanufacturer;
	private JTextField cyl;
	private JTextField horsePower;
	private JTextField selfPropel;
	private JTextField cutW;
	private JTextField wheelD;
	private JLabel mowerTypeLabel;
	private JTextField mowerType;
	private JButton submit;
	private JButton exit;
	private JPanel controlPanel;
	private JLabel selfPropelLabel;

	@Override
	public void actionPerformed(ActionEvent e) {
		PoweredFrame = new JFrame();
		PoweredFrame.setBounds(300,90,900,300);
		PoweredFrame.setResizable(true);
		controlPanel = new JPanel();
		controlPanel.setLayout(null);
		
		EnginemanLabel = new JLabel("Engine Manufacturer");
		EnginemanLabel.setSize(100, 20);
		EnginemanLabel.setLocation(100, 100);
		controlPanel.add(EnginemanLabel);
		Enginemanufacturer =  new JTextField(100);
		Enginemanufacturer.setSize(200, 20);
		Enginemanufacturer.setLocation(200, 100);
		controlPanel.add(Enginemanufacturer);
		
		cylinderLabel = new JLabel("Cylinder");
		cylinderLabel.setSize(100, 20);
		cylinderLabel.setLocation(100, 150);
		controlPanel.add(cylinderLabel);
		cyl = new JTextField(100);
		cyl.setSize(100, 20);
		cyl.setLocation(200, 150);
		controlPanel.add(cyl);
		
		horsePowerLabel = new JLabel("Horse Power");
		horsePowerLabel.setSize(100, 20);
		horsePowerLabel.setLocation(100, 200);
		controlPanel.add(horsePowerLabel);
		horsePower = new JTextField(100);
		horsePower.setSize(100, 20);
		horsePower.setLocation(200, 200);
		controlPanel.add(horsePower);
		
		mowerTypeLabel = new JLabel("Type of Mower");
		mowerTypeLabel.setSize(100, 20);
		mowerTypeLabel.setLocation(100, 250);
		controlPanel.add(mowerTypeLabel);
		mowerType = new JTextField(100);
		mowerType.setSize(100, 20);
		mowerType.setLocation(200, 250);
		controlPanel.add(mowerType);
		
		selfPropelLabel = new JLabel("Self propel");
		selfPropelLabel.setSize(100, 20);
		selfPropelLabel.setLocation(100, 300);
		controlPanel.add(selfPropelLabel);
		selfPropel = new JTextField(100);
		selfPropel.setSize(100, 20);
		selfPropel.setLocation(200, 300);
		controlPanel.add(selfPropel);
		
		cutWLabel = new JLabel("cut");
		cutWLabel.setSize(100, 20);
		cutWLabel.setLocation(100, 350);
		controlPanel.add(cutWLabel);
		cutW = new JTextField(100);
		cutW.setSize(100, 20);
		cutW.setLocation(200, 350);
		controlPanel.add(cutW);
		
		wheelDLabel = new JLabel("Wheel diameter");
		wheelDLabel.setSize(100, 20);
		wheelDLabel.setLocation(100, 400);
		controlPanel.add(wheelDLabel);
		wheelD = new JTextField(100);
		wheelD.setSize(100, 20);
		wheelD.setLocation(200, 400);
		controlPanel.add(wheelD);
	
		submit = new JButton("submit");
		submit.setSize(100,20);
		submit.setLocation(150, 600);
		controlPanel.add(submit);
		
		exit = new JButton("exit");
		exit.setSize(100, 20);
		exit.setLocation(300, 600);
		controlPanel.add(exit);
		// TODO Auto-generated method stub
		
		PoweredFrame.add(controlPanel);
		submit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				lt = new LawnTractor();
				cap = new GasPoweredMower();
				engine = new Engine();
				int cut = 0;
				int wheel = 0;
				String mowType = "";
				String manuF = "";
				double hPower = 0.0;
				int cylind = 0;
				boolean selfP;
				
				manuF = Enginemanufacturer.getText();
				hPower = Double.parseDouble(horsePower.getText());
				cylind = Integer.parseInt(cyl.getText());
				mowType = mowerType.getText();
				selfP = Boolean.parseBoolean(selfPropel.getText());
				cut = Integer.parseInt(cutW.getText());
				wheel = Integer.parseInt(wheelD.getText());
				
				engine.setManufacturer(manuF);
				engine.setHorsePower(hPower);
				engine.setCylinders(cylind);
				cap.setEngine(engine);
				cap.setSelfPropelled(selfP);
				cap.setCutWidth(cut);
				cap.setWheelDiameter(wheel);
				cap.setMowerType(mowType);
				mowed.addMower(cap);
				// TODO Auto-generated method stub
				
			}
			
		});
		
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		
		PoweredFrame.setVisible(true);
		
	}
	
}
class PushReelForm implements ActionListener{
	private JFrame ReelFrame;
	private JLabel cutWLabel;
	private JLabel wheelDLabel;
	private JLabel mowerTypeLabel;
	private JLabel numWLabel;
	private JTextField mowerType;
	private JTextField numW;
	private JTextField cutW;
	private JTextField wheelD;
	private JButton submit;
	private JButton exit;
	private JPanel controlPanel;

	@Override
	public void actionPerformed(ActionEvent e) {
		ReelFrame = new JFrame();
		ReelFrame.setBounds(300,90,900,300);
		ReelFrame.setResizable(true);
		controlPanel = new JPanel();
		controlPanel.setLayout(null);
		
		numWLabel = new JLabel("Number of Wheel");
		numWLabel.setSize(100, 20);
		numWLabel.setLocation(100, 100);
		controlPanel.add(numWLabel);
		numW = new JTextField(100);
		numW.setSize(100, 20);
		numW.setLocation(200, 100);
		controlPanel.add(numW);
		
		mowerTypeLabel = new JLabel("Type of Mower");
		mowerTypeLabel.setSize(100, 20);
		mowerTypeLabel.setLocation(100, 150);
		controlPanel.add(mowerTypeLabel);
		mowerType = new JTextField(100);
		mowerType.setSize(100, 20);
		mowerType.setLocation(200, 150);
		controlPanel.add(mowerType);
		
		cutWLabel = new JLabel("cut");
		cutWLabel.setSize(100, 20);
		cutWLabel.setLocation(100, 200);
		controlPanel.add(cutWLabel);
		cutW = new JTextField(100);
		cutW.setSize(100, 20);
		cutW.setLocation(200, 200);
		controlPanel.add(cutW);
		
		wheelDLabel = new JLabel("Wheel diameter");
		wheelDLabel.setSize(100, 20);
		wheelDLabel.setLocation(100, 250);
		controlPanel.add(wheelDLabel);
		wheelD = new JTextField(100);
		wheelD.setSize(100, 20);
		wheelD.setLocation(200, 250);
		controlPanel.add(wheelD);
	
		submit = new JButton("submit");
		submit.setSize(100,20);
		submit.setLocation(150, 300);
		controlPanel.add(submit);
		
		exit = new JButton("exit");
		exit.setSize(100, 20);
		exit.setLocation(300, 300);
		controlPanel.add(exit);
		
		ReelFrame.add(controlPanel);
		
		submit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				push = new PushReelMower();
				int numWheel = 0;
				int cut = 0;
				double wheel = 0;
				String MowerType = "";
				
				numWheel = Integer.parseInt(numW.getText());
				cut = Integer.parseInt(cutW.getText());
				wheel = Double.parseDouble(wheelD.getText());
				MowerType = mowerType.getText();
				
				push.setNumWheels(numWheel);
				push.setCutWidth(cut);
				push.setWheelD(wheel);
				push.setMowerType(MowerType);
				mowed.addMower(push);
				
				
				
				// TODO Auto-generated method stub
				
			}
			
		});
		
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		ReelFrame.setVisible(true);
		// TODO Auto-generated method stub
		
	}
	
}
}
