package CPUSCHDULING;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.gantt.Task;
import org.jfree.data.gantt.TaskSeries;
import org.jfree.data.gantt.TaskSeriesCollection;

public class ProcessAndTherads extends JFrame implements ActionListener, KeyListener {
	/**
	 * 
	 */
	/**
	 * 
	 */
	JRadioButton firstRadio;
	JRadioButton firstRadio2;
	JButton inputOk;
	String[][] model_Second_Data;
	JTextField inputText;
	Vector<String> col = new Vector<String>();
	// String[] model_First_Data = { "NUM", "���μ���", "�켱����", "�����ð�", "���񽺽ð�" };
	DefaultTableModel model;
	JScrollPane tableScroll;
	JPanel MainPanel;
	JPanel subPanel;
	JTable table;
	JPanel midPanel;
	JRadioButton fcfs;
	JRadioButton HRN;
	JRadioButton SJF;
	JRadioButton SRT;
	JRadioButton Priority;
	JRadioButton Round_Robin;
	private JLabel lb_fcfs = new JLabel("FCFS");
	private JLabel lb_SJF = new JLabel("SJF");
	private JLabel lb_HRN = new JLabel("HRN");
	private JLabel lb_SRT = new JLabel("SRT");
	private JLabel lb_Priority = new JLabel("Priority");
	private JLabel lb_Round_Robin = new JLabel("Round_Robin");
	private JLabel fcfs_avgWait = new JLabel("0");
	private JLabel fcfs_avgTurnAroun = new JLabel("0");
	private JLabel SJF_avgWait = new JLabel("0");
	private JLabel SJF_avgTurnAroun = new JLabel("0");
	private JLabel HRN_avgWait = new JLabel("0");
	private JLabel HRN_avgTurnAroun = new JLabel("0");
	private JLabel SRT_avgWait = new JLabel("0");
	private JLabel SRT_avgTrunAroun = new JLabel("0");
	private JLabel Priority_avgWait = new JLabel("0");
	private JLabel Priority_avgTurnAroun = new JLabel("0");
	private JLabel Round_Robin_avgWait = new JLabel("0");
	private JLabel Round_Robin_avgTurnAroun = new JLabel("0");
	JButton btn_Start = new JButton("����");
	TaskSeriesCollection dataset = new TaskSeriesCollection();
	TaskSeries unavailable = new TaskSeries("Used Cpu Time");
	JFreeChart chart = ChartFactory.createGanttChart("", "Process name", "Time", dataset, true, true, false);

	public ProcessAndTherads() {
		col.add("NUM");
		col.add("���μ���");
		col.add("�켱����");
		col.add("�����ð�");
		col.add("���񽺽ð�");
		model = new DefaultTableModel(col, 0);// ����Ʈ ���̺� ���̰� �ణ ���̺��� ������? ��������
		table = new JTable(model);// ���̺� �� �־��ش�
		table.getTableHeader().setReorderingAllowed(false);// ���̺� �Ӽ��� �ȿ����̰� �ϴ°�
		table.setModel(model);// ���̺� UpdateUI();
		tableScroll = new JScrollPane(table);// ��ũ�� ���ο� ������
		this.setTitle("CPU�����층");
		this.setBounds(0, 0, 1100, 500);
		MainPanel = new JPanel();// ���� �� �ڿ� �ִ� �г�
		JPanel firstPanel = new JPanel();// ������ ������ �ִ� �г�
		JPanel leftDownPanel = new JPanel();// �� �����층 ǥ����� �г�
		midPanel = new JPanel();// ���� �� �г�
		JLabel firstInput = new JLabel();// ���μ��� ������
		JLabel secondInput = new JLabel();// �����층 ���
		JLabel howManyPro = new JLabel();// ���μ��� ��
		JLabel thirdInput = new JLabel("���ɺ�");
		JLabel howDO = new JLabel("���");
		JLabel avrWait = new JLabel("��մ��ð�");
		JLabel avrReturn = new JLabel("��չ�ȯ�ð�");
		inputText = new JTextField(20);
		inputOk = new JButton("�Է�");
		// int howMany = Integer.parseInt(firstInput.getText());
		// model_Second_Data = new String[5][5];
		// for (int i = 0; i < howMany; i++) {
		// int processTime = r.nextInt(45) + 1;
		// }
		// DefaultTableModel model = new DefaultTableModel(model_Second_Data,
		// model_First_Data);// �𵨰�
		// �����͸� �����ؾ��ϴµ� �����͸� ���� ���ְ�����
		// model.addRow(model_Second_Data);
		// JTable table = new JTable(model);// table �� �гη� �ν�!
		// JScrollPane scroll = new JScrollPane(table);
		// table.add(scroll);
		// table.addMouseListener(new JTableMouseListener());
		firstRadio = new JRadioButton("�ڵ�");// �������� �ִ� ���� ��ư
		firstRadio2 = new JRadioButton("����");// �������� �ִ� ���� ��ư
		fcfs = new JRadioButton("First-come First-served");
		HRN = new JRadioButton("Highest Response Radio Next");
		SJF = new JRadioButton("Shortest Job First");
		SRT = new JRadioButton("Shortest Remaining Time");
		Priority = new JRadioButton("Priority");
		Round_Robin = new JRadioButton("Round-Robin");
		ButtonGroup groupBt = new ButtonGroup();// �ڵ� ���� �׷�
		ButtonGroup groupSche = new ButtonGroup();// �����ٸ� ��� �׷�
		groupBt.add(firstRadio);
		groupBt.add(firstRadio2);
		groupSche.add(fcfs);
		groupSche.add(HRN);
		groupSche.add(SJF);
		groupSche.add(SRT);
		groupSche.add(Priority);
		groupSche.add(Round_Robin);
		firstInput.setText("���μ��� ������");
		secondInput.setText("�����층 ���");
		secondInput.setForeground(Color.BLUE);
		howManyPro.setText("���μ��� ��");
		firstInput.setForeground(Color.BLUE);
		firstPanel.setLayout(null);
		leftDownPanel.setLayout(null);
		firstInput.setBounds(20, 10, 200, 20);
		howManyPro.setBounds(20, 60, 200, 20);
		inputText.setBounds(20, 80, 100, 20);
		inputOk.setBounds(130, 80, 70, 20);
		firstRadio.setBounds(10, 30, 70, 30);
		// firstRadio.addItemListener(new SelectItemListener());
		firstRadio2.setBounds(90, 30, 70, 30);
		firstPanel.setBounds(0, 0, 550, 220);
		firstPanel.add(firstInput);
		firstPanel.add(howManyPro);
		firstPanel.add(firstRadio);
		firstPanel.add(firstRadio2);
		firstPanel.add(inputText);
		firstPanel.add(inputOk);
		inputOk.addActionListener(this);
		// firstPanel.add(table);
		// firstPanel.setBackground(Color.black);
		leftDownPanel.setBounds(0, 230, 220, 230);
		// leftDownPanel.setBackground(Color.pink);
		fcfs.setBounds(10, 30, 160, 30);
		HRN.setBounds(10, 60, 200, 30);
		SJF.setBounds(10, 90, 160, 30);
		SRT.setBounds(10, 120, 170, 30);
		Priority.setBounds(10, 150, 160, 30);
		Round_Robin.setBounds(10, 180, 160, 30);
		secondInput.setBounds(20, 10, 200, 20);
		leftDownPanel.add(secondInput);
		// fcfs.addActionListener(this);
		// SJF.addActionListener(this);
		leftDownPanel.add(fcfs);
		leftDownPanel.add(HRN);
		leftDownPanel.add(SJF);
		leftDownPanel.add(SRT);
		leftDownPanel.add(Priority);
		leftDownPanel.add(Round_Robin);
		// subPanel = new JPanel();
		// subPanel.setBounds(240, 0, 330, 210);
		//// subPanel.setBackground(Color.PINK);
		tableScroll.setBounds(220, 0, 330, 220);
		// subPanel.add(tableScroll);
		// firstPanel.add(subPanel);
		myListenerStart();
		add(tableScroll);// ���̺� ��ü�� �г��̶� �׳� �ٷ� �����ӿ��ٰ� ���̺� ����
		midPanel.setBounds(230, 230, 320, 230);
		midPanel.setLayout(null);
		thirdInput.setBounds(20, 10, 200, 20);
		thirdInput.setForeground(Color.BLUE);
		howDO.setBounds(30, 50, 50, 20);
		avrWait.setBounds(90, 50, 80, 20);
		avrReturn.setBounds(200, 50, 80, 20);
		lb_fcfs.setBounds(30, 70, 80, 30);
		lb_SJF.setBounds(35, 90, 80, 30);
		lb_HRN.setBounds(35, 110, 80, 30);
		lb_SRT.setBounds(35, 130, 80, 30);
		lb_Priority.setBounds(25, 150, 80, 30);
		lb_Round_Robin.setBounds(15, 170, 80, 30);
		fcfs_avgWait.setBounds(120, 70, 80, 30);
		fcfs_avgTurnAroun.setBounds(230, 70, 80, 30);
		SJF_avgWait.setBounds(120, 90, 80, 30);
		SJF_avgTurnAroun.setBounds(230, 90, 80, 30);
		HRN_avgWait.setBounds(120, 110, 80, 30);
		HRN_avgTurnAroun.setBounds(230, 110, 80, 30);
		SRT_avgWait.setBounds(120, 130, 80, 30);
		SRT_avgTrunAroun.setBounds(230, 130, 80, 30);
		Priority_avgWait.setBounds(120, 150, 80, 30);
		Priority_avgTurnAroun.setBounds(230, 150, 80, 30);
		Round_Robin_avgWait.setBounds(120, 170, 80, 30);
		Round_Robin_avgTurnAroun.setBounds(230, 170, 80, 30);
		btn_Start.setBounds(120, 200, 80, 30);
		btn_Start.addActionListener(this);
		// midPanel.setBackground(Color.BLUE);
		midPanel.add(thirdInput);
		midPanel.add(howDO);
		midPanel.add(avrWait);
		midPanel.add(avrReturn);
		midPanel.add(lb_fcfs);
		midPanel.add(lb_SJF);
		midPanel.add(lb_HRN);
		midPanel.add(lb_SRT);
		midPanel.add(lb_Priority);
		midPanel.add(lb_Round_Robin);
		midPanel.add(fcfs_avgWait);
		midPanel.add(fcfs_avgTurnAroun);
		midPanel.add(SJF_avgWait);
		midPanel.add(SJF_avgTurnAroun);
		midPanel.add(HRN_avgWait);
		midPanel.add(HRN_avgTurnAroun);
		midPanel.add(SRT_avgWait);
		midPanel.add(SRT_avgTrunAroun);
		midPanel.add(Priority_avgWait);
		midPanel.add(Priority_avgTurnAroun);
		midPanel.add(Round_Robin_avgWait);
		midPanel.add(Round_Robin_avgTurnAroun);
		midPanel.add(btn_Start);
		MainPanel.setLayout(null);
		MainPanel.add(leftDownPanel);
		MainPanel.add(firstPanel);
		MainPanel.add(midPanel);
		MainPanel.setBackground(Color.BLACK);
		ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setBounds(565, 0, 505, 455);

		MainPanel.add(chartPanel, BorderLayout.CENTER);
		this.add(MainPanel);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	private void myListenerStart() {
		fcfs.addActionListener(this);
		SJF.addActionListener(this);
		SRT.addActionListener(this);
		Priority.addActionListener(this);
		HRN.addActionListener(this);
		Round_Robin.addActionListener(this);
		table.addKeyListener(this);
	}

	public static void main(String[] args) {
		ProcessAndTherads f = new ProcessAndTherads();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		int time = 0;// ���α׷� �����ð��� ���� �ð� ���� ��
		int proTime[];// ���μ��� ���ð�
		int proService[];// ���μ��� ���� �ð�
		int proArrival[];// ���μ��� �����ð�
		int turnAround[];// ���α׷� ��ȯ �ð�
		int randomNumber[];
		int randomNumber1[];
		if (arg0.getActionCommand().equals("�Է�")) {// �������� �Է��̰�
			if (firstRadio.isSelected()) {// �ڵ��� ���õǸ�
				try {
					int many = Integer.parseInt(inputText.getText());
					if (many >= 6) {
						JOptionPane.showMessageDialog(null, "���μ��� ���� �ʹ� �����ϴ�.", "", JOptionPane.WARNING_MESSAGE);
						inputText.setText(null);
					} else if (many < 0) {
						JOptionPane.showMessageDialog(null, "���μ����� 0���� ���� �� �����ϴ�.", "", JOptionPane.WARNING_MESSAGE);
						inputText.setText(null);
					} else if (1 <= many || many <= 5) {
//						System.out.print("�ڵ��� ���õǾ����ϴ�.");
						DefaultTableModel model = new DefaultTableModel(col, many);
						table.setModel(model);// UpdateUI���̺� ������Ʈ();
						randomNumber = RandomNumber(many, 1);
						randomNumber1 = RandomNumber(many, 2);
						for (int i = 0; i < many; i++) {
							table.setValueAt(" " + (i + 1), i, 0);// ������ ���� �ΰ��� �־��ָ� ����
							table.setValueAt("P" + (i + 1), i, 1);// ���̺� �� �ִ°� �� �ҷ����°� table.getValueAt
							table.setValueAt(randomNumber[i], i, 3);// �����ð� �����ð��� 0 �� ���� �Ҽ��� �����ϱ� ������������ +1 ������
							table.setValueAt(randomNumber1[i], i, 4);// ���� �ð�
							// table.getV
						}
					}
				} catch (Exception e) {// many�� �ƿ� try���� ���� �����ϱ� ���ڿ� �ԷµȰ�!
					JOptionPane.showMessageDialog(null, "���̺� ���� ���ڿ��̳� ������ ������ �����ϴ�!", "", JOptionPane.WARNING_MESSAGE);
					inputText.setText(null);
				}
			}

		}
		if (arg0.getActionCommand().equals("�Է�")) {
			if (firstRadio2.isSelected()) {
				try {
					int many = Integer.parseInt(inputText.getText());
					if (many >= 6) {
						JOptionPane.showMessageDialog(null, "���μ��� ���� �ʹ� �����ϴ�.", "", JOptionPane.WARNING_MESSAGE);
						inputText.setText(null);
					} else if (many < 0) {
						JOptionPane.showMessageDialog(null, "���μ����� 0���� ���� �� �����ϴ�.", "", JOptionPane.WARNING_MESSAGE);
						inputText.setText(null);
					} else if (1 <= many || many <= 5) {
//						System.out.print("������ ���õǾ����ϴ�.");
						DefaultTableModel model = new DefaultTableModel(col, many);
						table.setModel(model);// UpdateUI();
						randomNumber = RandomNumber(many, 1);
						randomNumber1 = RandomNumber(many, 2);
						for (int i = 0; i < many; i++) {
							table.setValueAt(" " + (i + 1), i, 0);// ������ ���� �ΰ��� �־��ָ� ����
							table.setValueAt("P" + (i + 1), i, 1);
						}
					}
				}

				catch (Exception e) {// many�� try���� �ش�Ǵ°��� ���� ������ catch ���� �ɸ�
					JOptionPane.showMessageDialog(null, "���ڿ��� �Է� �Ͽ����ϴ�!", "", JOptionPane.WARNING_MESSAGE);
					inputText.setText(null);
					for (int i = 0; i < table.getRowCount(); i++) {
						if (Integer.parseInt(table.getValueAt(i, 3).toString()) < 0) {
							JOptionPane.showMessageDialog(null, "�����ð��� �������� �ɼ� �����ϴ�.", "", JOptionPane.WARNING_MESSAGE);
							table.setModel(model);
						}
					}
				}
			}
		}
		try {
			if (arg0.getActionCommand().equals("����")) {
				if (fcfs.isSelected()) {// fcfs ���� ��ư ���õǴ� �̺�Ʈ ��մ��ð� ��ȯ�ð� double������ �ٲ������ !!!
//					System.out.println("fcfs����� ���õǾ����ϴ�.");
					proService = new int[table.getRowCount()];// ���μ��� ���� �ð� �� ������ŭ �迭 ����
					proArrival = new int[table.getRowCount()];// ���μ��� �����ð� �� ������ŭ �迭 ����
					proTime = new int[table.getRowCount()];// ���ð� �迭 ����
					turnAround = new int[table.getRowCount()];// ��ȯ�ð� �迭 ����
					double totalWait = 0;
					double totalTurnAround = 0;
					// JLabel fcfs_avgWait = new JLabel();
					// JLabel fcfs_avgTurnAroun = new JLabel();
					Task[] task = new Task[Integer.parseInt(inputText.getText())];
					task[0] = new Task("p0", new Date(1), new Date(10));
					unavailable.add(task[0]);

					for (int i = 0; i < table.getRowCount(); i++) {
						proArrival[i] = Integer.parseInt(table.getValueAt(i, 3).toString());// ���� �ð� �ʱ�ȭ
//						System.out.print("proArrival �ð���" + proArrival[i] + " ");
						proService[i] = Integer.parseInt(table.getValueAt(i, 4).toString());// ���� �ð� �ʱ�ȭ
//						System.out.println("proService �ð���" + proService[i] + " ");
						// System.out.println("proArrival ���ĵ� �ð���" + proArrival[i] + " ");
					}
					SortServiceAndArriaval(proArrival, proService);
					for (int i = 0; i < proArrival.length; i++) {
//						System.out.print("proArrival ���ĵ� �ð���" + proArrival[i] + " ");
//						System.out.println("proService �ð���" + proService[i] + " ");
						if (i == 0) {
							proTime[i] = 0;// i�� 0 �̸� ������ �ٷ� ����
							turnAround[0] = proService[0];// ��ȯ �ð��� ù��° ���� �ð�
							time = proService[0] + proArrival[0];// �׷��ϱ� ���� ���μ����� ���ֱ� ���ؼ� time�� ������µ� �� time�� ���� �ð��� ����
							task[0] = new Task("P0", new Date(proArrival[0]), new Date(time));
							totalWait += (double) proTime[0];
							totalTurnAround += (double) turnAround[0];
						} else if (time <= proArrival[i])// �� ���� �ð��� �����ð� ���� ������� �׷��� �ٷ� ���� �����ϴ�
						{
							proTime[i] = 0;// ���� ��� �ð��� 0
							// turnAround[i] = 0;// ��ȯ �ð� //�Ѵ� �ּ�ó�� �س��µ� ���� Ȯ���Ѱ� �ƴ�,,, �ؿ����� ������
							turnAround[i] = proService[i];
							time = proService[i] + proArrival[i];
							task[i] = new Task("P" + i, new Date(time), new Date(time));
							totalWait += (double) proTime[i];
							totalTurnAround += (double) turnAround[i];
							// chart.add
						} else if (time > proArrival[i]) {
							proTime[i] = time - proArrival[i];
							turnAround[i] = proTime[i] + proService[i];
							time += proService[i];
							task[i] = new Task("P" + i, new Date(time), new Date(time));
							totalWait += (double) proTime[i];
							totalTurnAround += (double) turnAround[i];
						}
						System.out.print("���μ��� P" + (i + 1) + "�� ���ð� : " + proTime[i] + "\t");
						System.out.println("���μ��� P" + (i + 1) + "�� ��ȯ�ð� : " + turnAround[i]);
						// avrWait.setBounds(90, 50, 80, 20);
					}
					System.out.println("��� ���ð� : " + (totalWait / proArrival.length));
					fcfs_avgWait.setText((totalWait / (double) proArrival.length) + "");
					fcfs_avgWait.setBounds(120, 70, 80, 30);
					System.out.println("��� ��ȯ�ð� : " + (totalTurnAround / proArrival.length));
					fcfs_avgTurnAroun.setText((totalTurnAround / (double) proArrival.length) + "");
					fcfs_avgTurnAroun.setBounds(230, 70, 80, 30);
					// avrReturn.setBounds(200, 50, 80, 20);
					midPanel.add(fcfs_avgWait);
					midPanel.add(fcfs_avgTurnAroun);
					midPanel.updateUI();
				}
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "���̺� ���� ���� ������ �ʰų� ���̺������ �ȵǾ����ϴ�!", "", JOptionPane.WARNING_MESSAGE);
		}
		try {
			if (arg0.getActionCommand().equals("����")) {
				if (SJF.isSelected()) {
//					System.out.println("SJF����� ���õǾ����ϴ�.");
					proTime = new int[table.getRowCount()];// ���ð� �迭 ����
					turnAround = new int[table.getRowCount()];// ��ȯ�ð� �迭
					proService = new int[table.getRowCount()];// ���μ��� ���� �ð� �� ������ŭ �迭 ����
					proArrival = new int[table.getRowCount()];// ���μ��� �����ð� �� ������ŭ �迭 ����
					ArrayList<Integer> tempService = new ArrayList<Integer>();
					ArrayList<Integer> tempArrival = new ArrayList<Integer>();
					boolean[] notFinish = new boolean[table.getRowCount()];
					double totalWait = 0;
					double totalTurnAround = 0;

					for (int i = 0; i < table.getRowCount(); i++) {
						int tableArrival = Integer.parseInt(table.getValueAt(i, 3).toString());
						proArrival[i] = tableArrival;
						// proArrival[i] = (int) table.getValueAt(i, 3);// ���� �ð� �ʱ�ȭ
//						System.out.print("proArrival �ð���" + proArrival[i] + " ");
						// proService[i] = (int) table.getValueAt(i, 4);// ���� �ð� �ʱ�ȭ
						int tableService = Integer.parseInt(table.getValueAt(i, 4).toString());
						proService[i] = tableService;
//						System.out.println("proService �ð���" + proService[i] + " ");
						// System.out.println("proArrival ���ĵ� �ð���" + proArrival[i] + " ");
						notFinish[i] = true;
					}

					System.out.println("--------------------------");
					SortServiceAndArriaval(proArrival, proService);
					for (int i = 0; i < table.getRowCount(); i++) {
//						System.out.print("���ĵ� proArrival�ð� : " + proArrival[i] + "  ");
						// tempService.add(proService[i]);
//						System.out.println("���ĵ� proService�ð� : " + proService[i] + "  ");
						// tempArrival.add(proArrival[i]);
					}
					for (int i = 0; i < table.getRowCount(); i++) {
						if (i == 0 && notFinish[i]) {
							proTime[0] = 0;// i�� 0 �̸� ������ �ٷ� ����
							turnAround[0] = proService[0];// ��ȯ �ð��� ù��° ���� �ð�
							time = proService[0] + proArrival[0];// �׷��ϱ� ���� ���μ����� ���ֱ� ���ؼ� time�� ������µ� �� time�� ���� �ð���
							// SJFService[0] = 99999;
							// finishTime += time;
							totalWait += (double) proTime[0];
							totalTurnAround += (double) turnAround[0];
							notFinish[0] = false;
						} else if (time <= proArrival[i] && notFinish[i]) {
							proTime[i] = 0;// ���� ��� �ð��� 0
							// turnAround[i] = 0;//��ȯ �ð� //�Ѵ� �ּ�ó�� �س��µ� ���� Ȯ���Ѱ� �ƴ�,,,
							// turnAround[i] += proService[i];
							turnAround[i] = proService[i];// ��ȯ�ð�
							time = proArrival[i] + proService[i];// ���� �ð� + �����ð�
							totalWait += (double) proTime[i];
							totalTurnAround += (double) turnAround[i];
							notFinish[i] = false;
						} else if (time > proArrival[i]) {
							for (int x = i; x < proArrival.length; x++) {
								if (notFinish[x] && time >= proArrival[x]) {
									tempArrival.add(proArrival[x]);
									tempService.add(proService[x]);
									notFinish[x] = false;
								}
							}

							int j = 0;
							int min = 0;
							while (true) {
								min = FindMin(tempService);
								if (min == tempService.get(j)) {
//									System.out.println(
//											time + "-" + tempArrival.get(j) + "=" + (time - tempArrival.get(j)));
									proTime[i] = time - tempArrival.get(j);
									turnAround[i] = proTime[i] + tempService.get(j);
									time += tempService.get(j);
									totalWait += (double) proTime[i];
									totalTurnAround += (double) turnAround[i];
									tempService.remove(j);
									tempArrival.remove(j);
									break;
								}
								if (j < tempService.size())
									j++;
							}
						}
						System.out.print("P"+(i + 1)+" : ���μ��� ���ð� : " + proTime[i] + " ");
						System.out.println("P"+(i + 1)+" : ���μ��� ��ȯ �ð� : " + turnAround[i]);
					}
					System.out.println("��� ���ð� : " + (totalWait / (double) proArrival.length));
					SJF_avgWait.setText(totalWait / (double) proArrival.length + "");
					System.out.println("��� ��ȯ�ð� : " + (totalTurnAround / (double) proArrival.length));
					SJF_avgTurnAroun.setText(totalTurnAround / (double) proArrival.length + "");
					SJF_avgWait.setBounds(120, 90, 80, 30);
					SJF_avgTurnAroun.setBounds(230, 90, 80, 30);
					midPanel.updateUI();// ������Ʈ!

				}
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "���̺� ���� ���� ������ �ʰų� ���̺������ �ȵǾ����ϴ�!", "", JOptionPane.WARNING_MESSAGE);
		}
		try {
			if (arg0.getActionCommand().equals("����")) {
				if (HRN.isSelected()) {
					System.out.println("HRN����� ���� �Ǿ����ϴ�.");
					proTime = new int[table.getRowCount()];// ���ð� �迭 ����
					turnAround = new int[table.getRowCount()];// ��ȯ�ð� �迭
					proService = new int[table.getRowCount()];// ���μ��� ���� �ð� �� ������ŭ �迭 ����
					proArrival = new int[table.getRowCount()];// ���μ��� �����ð� �� ������ŭ �迭 ����
					ArrayList<Integer> tempService = new ArrayList<Integer>();
					ArrayList<Integer> tempArrival = new ArrayList<Integer>();
					ArrayList<Integer> tempProWait = new ArrayList<Integer>();
					ArrayList<Float> responMax = new ArrayList<Float>();
					boolean[] notFinish = new boolean[table.getRowCount()];
					double totalWait = 0;
					double totalTurnAround = 0;

					for (int j = 0; j < table.getRowCount(); j++) {
						int tableService = (Integer.parseInt(table.getValueAt(j, 4).toString()));
						proService[j] = tableService;// ���� �ð� �ʱ�ȭ
						int tableArrival = (Integer.parseInt(table.getValueAt(j, 3).toString()));// toString ����������
						proArrival[j] = tableArrival;// �����ð� �ʱ�ȭ
						notFinish[j] = true; // �� ���μ����� �������϶� ������ �Ϸ��� �Ҹ��� �߰���Ŵ
					}
					SortServiceAndArriaval(proArrival, proService);

					for (int i = 0; i < table.getRowCount(); i++) {
						if (i == 0) {
							proTime[0] = 0;
							turnAround[0] = proTime[0] + proService[0];
							time = proArrival[0] + proService[0];
							totalWait += (double) proTime[0];
							totalTurnAround += (double) turnAround[0];

						} else if (time <= proArrival[i] && notFinish[i]) {
							proTime[i] = 0;// ���� ��� �ð��� 0
							// turnAround[i] = 0;//��ȯ �ð� //�Ѵ� �ּ�ó�� �س��µ� ���� Ȯ���Ѱ� �ƴ�,,,
							// turnAround[i] += proService[i];
							turnAround[i] = proService[i];// ��ȯ�ð�
							time = proArrival[i] + proService[i];// ���� �ð� + �����ð�
							totalWait += (double) proTime[i];
							totalTurnAround += (double) turnAround[i];
							notFinish[i] = false;
						} else if (time > proArrival[i]) {
							for (int x = i; x < proService.length; x++) {
								if (notFinish[x] && time >= proArrival[x]) {
									tempArrival.add(proArrival[x]);
									tempService.add(proService[x]);
									notFinish[x] = false;
								}
							}
							for (int x = 0; x < tempArrival.size(); x++) {
								// System.out.print("tempArrival �� �� : " + tempArrival.get(x));
								// System.out.println("tempService �� �� : " + tempService.get(x));
								tempProWait.add(time - tempArrival.get(x));
								// System.out.print("tempProWait �� �� : " + tempProWait.get(x) + " ");
								// System.out.println((tempProWait.get(x) + tempService.get(x)) /
								// tempService.get(x));
								float responPro = (((float) tempProWait.get(x)) + ((float) tempService.get(x)))
										/ ((float) tempService.get(x));
//								System.out.println(tempProWait.get(x) + " + " + tempService.get(x) + " / "
//										+ tempService.get(x) + " = " + responPro);
								responMax.add(responPro);
								// System.out.println("responMax �� �� : " + responMax.get(x));
							}

							int j = 0;
							while (true) {
								// System.out.println("�ٲ� time �� �� : " + time);
								// System.out.println("");
								if (Collections.max(responMax) == responMax.get(j)) {
//									System.out.println(
//											time + "-" + tempArrival.get(j) + "=" + (time - tempArrival.get(j)));
									proTime[i] = time - tempArrival.get(j);
									turnAround[i] = proTime[i] + tempService.get(j);
									time += tempService.get(j);
									totalWait += (double) proTime[i];
									totalTurnAround += (double) turnAround[i];
									// System.out.println("������ time �� : " + time);
									tempService.remove(j);
									tempArrival.remove(j);
									tempProWait.clear();
									responMax.clear();
									break;
								}
								if (j < responMax.size())
									j++;
							}
						}
						System.out.print("P"+(i+1)+"���μ��� ���ð� : " + proTime[i] + " ");
						System.out.println("P"+(i+1)+"���μ��� ��ȯ �ð� : " + turnAround[i]);
					}
					System.out.println("��� ��� �ð� : " + totalWait / (double) proArrival.length);
					HRN_avgWait.setText(totalWait / (double) proArrival.length + "");
					System.out.println("��� ��ȯ �ð� : " + totalTurnAround / (double) proArrival.length);
					HRN_avgTurnAroun.setText(totalTurnAround / (double) proArrival.length + "");
					HRN_avgWait.setBounds(120, 110, 80, 30);
					HRN_avgTurnAroun.setBounds(230, 110, 80, 30);
					midPanel.updateUI();
				}
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "���̺� ���� ���� ������ �ʰų� ���̺������ �ȵǾ����ϴ�!", "", JOptionPane.WARNING_MESSAGE);
		}
		try
		{
			if(arg0.getActionCommand().equals("����"))
				if(Priority.isSelected())
				{
					System.out.println("�켱���� ����� ���� �Ǿ����ϴ�.");
					ArrayList<Integer> proWait = new ArrayList<Integer>();
					turnAround = new int[table.getRowCount()];// ��ȯ�ð� �迭
					proService = new int[table.getRowCount()];// ���μ��� ���� �ð� �� ������ŭ �迭 ����
					proArrival = new int[table.getRowCount()];// ���μ��� �����ð� �� ������ŭ �迭 ����
					ArrayList<Integer> firstprior = new ArrayList<Integer>();//�켱���� ���� �迭 ����
					double totalWait = 0;
					double totalTurnAround = 0;

					for (int i = 0; i < table.getRowCount(); i++) {
						int tableService = Integer.parseInt(table.getValueAt(i, 4).toString());
						proService[i] = tableService;
						int tableArrival = Integer.parseInt(table.getValueAt(i, 3).toString());
						proArrival[i] = tableArrival;
						firstprior.add(Integer.parseInt(table.getValueAt(i, 2).toString()));
					}
					int j = 0;
					while(true) {
						if(Collections.max(firstprior) == firstprior.get(j)) {
							if(proWait.isEmpty()) {
								proWait.add(0);
								time += proService[j];
								firstprior.remove(j);
								turnAround[j] = proWait.get(0) + proService[j];
								totalWait += proWait.get(0);
								totalTurnAround += turnAround[j];
							}
							proWait.add(time);
							time += proService[j];
							firstprior.remove(j);
							turnAround[j] = proWait.get(j) + proService[j];
							totalWait += proWait.get(0);
							totalTurnAround += turnAround[j];
							break;
						}
						if(j < firstprior.size())
							j++;
					}
					for (int i = 0; i < table.getRowCount(); i++) {
						System.out.print("P"+(i+1)+"���μ��� ���ð� : " + proWait.get(i) + " ");
						System.out.println("P"+(i+1)+"���μ��� ��ȯ �ð� : " + turnAround[i]);
					}
					System.out.println("��� ��� �ð� : " + totalWait / (double) proArrival.length);
					Priority_avgWait.setText(totalWait / (double) proArrival.length + "");
					System.out.println("��� ��ȯ �ð� : " + totalTurnAround / (double) proArrival.length);
					Priority_avgTurnAroun.setText(totalTurnAround / (double) proArrival.length + "");
					Priority_avgWait.setBounds(120, 110, 80, 30);
					Priority_avgTurnAroun.setBounds(230, 110, 80, 30);
					midPanel.updateUI();
				}
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, "���̺� ���� ���� ������ �ʰų� ���̺������ �ȵǾ����ϴ�!", "", JOptionPane.WARNING_MESSAGE);
		}
	}

	private int[] RandomNumber(int howMany, int choice) {
		// TODO Auto-generated method stub
		int random[] = new int[howMany];
		for (int i = 0; i < howMany; i++) {
			if (choice == 2) {
				random[i] = (int) (Math.random() * 20) + 1;
			} else if (choice == 1) {
				random[i] = (int) (Math.random() * 20);
			}
			for (int j = 0; j < i; j++) {
				if (random[i] == random[j]) {
					i--;
					break;
				}
			} // �ߺ� �ȵǰ� �ϴ� ��
		}
		return random;
	}

	protected int FindMin(ArrayList<Integer> tmpService) {
		int min = 0;
		for (int i = 0; i < tmpService.size(); i++) {
			min = tmpService.get(i);
			for (int j = 0; j < tmpService.size(); j++) {
				if (min > tmpService.get(j))
					min = tmpService.get(j);
			}
		}
		return min;
	}

	protected void SortServiceAndArriaval(int arrival[], int service[]) {
		int arrivalTemp = 0;
		int serviceTemp = 0;
		for (int i = 0; i < arrival.length; i++) {
			for (int j = 0; j < arrival.length; j++) {
				if (arrival[i] < arrival[j]) {
					arrivalTemp = arrival[i];
					serviceTemp = service[i];
					arrival[i] = arrival[j];
					service[i] = service[j];
					arrival[j] = arrivalTemp;
					service[j] = serviceTemp;
				}
			}
		}
	}// �Ʊ� ���� Arrays.sort �ϸ� ���� ���ÿ� �ٲ����� �ʾƼ� Ŭ������ �ϳ� ����

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		int whatPress = arg0.getKeyCode();
		if (whatPress == KeyEvent.VK_ENTER) {
			try {
				for (int i = 0; i < table.getRowCount(); i++) {
					if (Integer.parseInt(table.getValueAt(i, 3).toString()) < 0) {
						JOptionPane.showMessageDialog(null, "�����ð��� �������� �ɼ� �����ϴ�!", "", JOptionPane.WARNING_MESSAGE);
						table.setValueAt(null, i, 3);
					} else if ((int) (table.getValueAt(i, 3)) >= 65 || (int) (table.getValueAt(i, 3)) <= 97) {
						JOptionPane.showMessageDialog(null, "�����ð��� ���ڸ� ������ �����ϴ�!", "", JOptionPane.WARNING_MESSAGE);
						table.setValueAt("", i, 3);
					}
				}
			} catch (Exception e) {

			}
			try {
				for (int i = 0; i < table.getRowCount(); i++) {
					if (Integer.parseInt(table.getValueAt(i, 4).toString()) < 0) {
						JOptionPane.showMessageDialog(null, "���� �ð��� �������� �� �� �����ϴ�!", "", JOptionPane.WARNING_MESSAGE);
						table.setValueAt(null, i, 4);
					} else if ((int) (table.getValueAt(i, 4)) >= 65 || (int) (table.getValueAt(i, 4)) <= 97) {
						JOptionPane.showMessageDialog(null, "�����ð��� ���ڸ� ������ �����ϴ�!", "", JOptionPane.WARNING_MESSAGE);
						table.setValueAt("", i, 4);
					}
				}
			} catch (Exception e) {

			}
		}

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}
}