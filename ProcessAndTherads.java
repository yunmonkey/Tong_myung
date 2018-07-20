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
	// String[] model_First_Data = { "NUM", "프로세스", "우선순위", "도착시간", "서비스시간" };
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
	JButton btn_Start = new JButton("실행");
	TaskSeriesCollection dataset = new TaskSeriesCollection();
	TaskSeries unavailable = new TaskSeries("Used Cpu Time");
	JFreeChart chart = ChartFactory.createGanttChart("", "Process name", "Time", dataset, true, true, false);

	public ProcessAndTherads() {
		col.add("NUM");
		col.add("프로세스");
		col.add("우선순위");
		col.add("도착시간");
		col.add("서비스시간");
		model = new DefaultTableModel(col, 0);// 디폴트 테이블 모델이게 약간 테이블의 리모컨? 같은역할
		table = new JTable(model);// 테이블에 모델 넣어준다
		table.getTableHeader().setReorderingAllowed(false);// 테이블 속성값 안움직이게 하는것
		table.setModel(model);// 테이블 UpdateUI();
		tableScroll = new JScrollPane(table);// 스크롤 페인에 붙히고
		this.setTitle("CPU스케쥴링");
		this.setBounds(0, 0, 1100, 500);
		MainPanel = new JPanel();// 가장 맨 뒤에 있는 패널
		JPanel firstPanel = new JPanel();// 왼쪽위 구석에 있는 패널
		JPanel leftDownPanel = new JPanel();// 각 스케쥴링 표기넣을 패널
		midPanel = new JPanel();// 성능 비교 패널
		JLabel firstInput = new JLabel();// 프로세스 실행방법
		JLabel secondInput = new JLabel();// 스케쥴링 기법
		JLabel howManyPro = new JLabel();// 프로세스 수
		JLabel thirdInput = new JLabel("성능비교");
		JLabel howDO = new JLabel("기법");
		JLabel avrWait = new JLabel("평균대기시간");
		JLabel avrReturn = new JLabel("평균반환시간");
		inputText = new JTextField(20);
		inputOk = new JButton("입력");
		// int howMany = Integer.parseInt(firstInput.getText());
		// model_Second_Data = new String[5][5];
		// for (int i = 0; i < howMany; i++) {
		// int processTime = r.nextInt(45) + 1;
		// }
		// DefaultTableModel model = new DefaultTableModel(model_Second_Data,
		// model_First_Data);// 모델과
		// 데이터를 연결해야하는데 데이터를 아직 못넣고있음
		// model.addRow(model_Second_Data);
		// JTable table = new JTable(model);// table 도 패널로 인식!
		// JScrollPane scroll = new JScrollPane(table);
		// table.add(scroll);
		// table.addMouseListener(new JTableMouseListener());
		firstRadio = new JRadioButton("자동");// 왼쪽위에 있는 라디오 버튼
		firstRadio2 = new JRadioButton("수동");// 왼쪽위에 있는 라디오 버튼
		fcfs = new JRadioButton("First-come First-served");
		HRN = new JRadioButton("Highest Response Radio Next");
		SJF = new JRadioButton("Shortest Job First");
		SRT = new JRadioButton("Shortest Remaining Time");
		Priority = new JRadioButton("Priority");
		Round_Robin = new JRadioButton("Round-Robin");
		ButtonGroup groupBt = new ButtonGroup();// 자동 수동 그룹
		ButtonGroup groupSche = new ButtonGroup();// 스케줄링 기법 그룹
		groupBt.add(firstRadio);
		groupBt.add(firstRadio2);
		groupSche.add(fcfs);
		groupSche.add(HRN);
		groupSche.add(SJF);
		groupSche.add(SRT);
		groupSche.add(Priority);
		groupSche.add(Round_Robin);
		firstInput.setText("프로세스 실행방법");
		secondInput.setText("스케쥴링 기법");
		secondInput.setForeground(Color.BLUE);
		howManyPro.setText("프로세스 수");
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
		add(tableScroll);// 테이블 자체가 패널이라서 그냥 바로 프레임에다가 테이블 붙힘
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
		int time = 0;// 프로그램 도착시간과 서비스 시간 합한 것
		int proTime[];// 프로세스 대기시간
		int proService[];// 프로세스 서비스 시간
		int proArrival[];// 프로세스 도착시간
		int turnAround[];// 프로그램 반환 시간
		int randomNumber[];
		int randomNumber1[];
		if (arg0.getActionCommand().equals("입력")) {// 눌러진게 입력이고
			if (firstRadio.isSelected()) {// 자동이 선택되면
				try {
					int many = Integer.parseInt(inputText.getText());
					if (many >= 6) {
						JOptionPane.showMessageDialog(null, "프로세스 수가 너무 많습니다.", "", JOptionPane.WARNING_MESSAGE);
						inputText.setText(null);
					} else if (many < 0) {
						JOptionPane.showMessageDialog(null, "프로세스가 0보다 작을 수 없습니다.", "", JOptionPane.WARNING_MESSAGE);
						inputText.setText(null);
					} else if (1 <= many || many <= 5) {
//						System.out.print("자동이 선택되었습니다.");
						DefaultTableModel model = new DefaultTableModel(col, many);
						table.setModel(model);// UpdateUI테이블 업데이트();
						randomNumber = RandomNumber(many, 1);
						randomNumber1 = RandomNumber(many, 2);
						for (int i = 0; i < many; i++) {
							table.setValueAt(" " + (i + 1), i, 0);// 수동일 때도 두개값 넣어주면 편함
							table.setValueAt("P" + (i + 1), i, 1);// 테이블 값 넣는것 값 불러오는것 table.getValueAt
							table.setValueAt(randomNumber[i], i, 3);// 도착시간 도착시간은 0 이 존재 할수도 있으니까 랜덤정수에서 +1 안해줌
							table.setValueAt(randomNumber1[i], i, 4);// 서비스 시간
							// table.getV
						}
					}
				} catch (Exception e) {// many가 아예 try문에 들어가지 않으니까 문자열 입력된것!
					JOptionPane.showMessageDialog(null, "테이블 수로 문자열이나 공백을 적을수 없습니다!", "", JOptionPane.WARNING_MESSAGE);
					inputText.setText(null);
				}
			}

		}
		if (arg0.getActionCommand().equals("입력")) {
			if (firstRadio2.isSelected()) {
				try {
					int many = Integer.parseInt(inputText.getText());
					if (many >= 6) {
						JOptionPane.showMessageDialog(null, "프로세스 수가 너무 많습니다.", "", JOptionPane.WARNING_MESSAGE);
						inputText.setText(null);
					} else if (many < 0) {
						JOptionPane.showMessageDialog(null, "프로세스가 0보다 작을 수 없습니다.", "", JOptionPane.WARNING_MESSAGE);
						inputText.setText(null);
					} else if (1 <= many || many <= 5) {
//						System.out.print("수동이 선택되었습니다.");
						DefaultTableModel model = new DefaultTableModel(col, many);
						table.setModel(model);// UpdateUI();
						randomNumber = RandomNumber(many, 1);
						randomNumber1 = RandomNumber(many, 2);
						for (int i = 0; i < many; i++) {
							table.setValueAt(" " + (i + 1), i, 0);// 수동일 때도 두개값 넣어주면 편함
							table.setValueAt("P" + (i + 1), i, 1);
						}
					}
				}

				catch (Exception e) {// many가 try문에 해당되는것이 없기 때문에 catch 에서 걸림
					JOptionPane.showMessageDialog(null, "문자열을 입력 하였습니다!", "", JOptionPane.WARNING_MESSAGE);
					inputText.setText(null);
					for (int i = 0; i < table.getRowCount(); i++) {
						if (Integer.parseInt(table.getValueAt(i, 3).toString()) < 0) {
							JOptionPane.showMessageDialog(null, "도착시간이 음수값이 될수 없습니다.", "", JOptionPane.WARNING_MESSAGE);
							table.setModel(model);
						}
					}
				}
			}
		}
		try {
			if (arg0.getActionCommand().equals("실행")) {
				if (fcfs.isSelected()) {// fcfs 라디오 버튼 선택되는 이벤트 평균대기시간 반환시간 double형으로 바꿔줘야함 !!!
//					System.out.println("fcfs기법이 선택되었습니다.");
					proService = new int[table.getRowCount()];// 프로세스 서비스 시간 행 갯수만큼 배열 생성
					proArrival = new int[table.getRowCount()];// 프로세스 도착시간 행 갯수만큼 배열 생성
					proTime = new int[table.getRowCount()];// 대기시간 배열 생성
					turnAround = new int[table.getRowCount()];// 반환시간 배열 생성
					double totalWait = 0;
					double totalTurnAround = 0;
					// JLabel fcfs_avgWait = new JLabel();
					// JLabel fcfs_avgTurnAroun = new JLabel();
					Task[] task = new Task[Integer.parseInt(inputText.getText())];
					task[0] = new Task("p0", new Date(1), new Date(10));
					unavailable.add(task[0]);

					for (int i = 0; i < table.getRowCount(); i++) {
						proArrival[i] = Integer.parseInt(table.getValueAt(i, 3).toString());// 서비스 시간 초기화
//						System.out.print("proArrival 시간은" + proArrival[i] + " ");
						proService[i] = Integer.parseInt(table.getValueAt(i, 4).toString());// 도착 시간 초기화
//						System.out.println("proService 시간은" + proService[i] + " ");
						// System.out.println("proArrival 정렬된 시간은" + proArrival[i] + " ");
					}
					SortServiceAndArriaval(proArrival, proService);
					for (int i = 0; i < proArrival.length; i++) {
//						System.out.print("proArrival 정렬된 시간은" + proArrival[i] + " ");
//						System.out.println("proService 시간은" + proService[i] + " ");
						if (i == 0) {
							proTime[i] = 0;// i가 0 이면 대기없이 바로 진행
							turnAround[0] = proService[0];// 반환 시간은 첫번째 서비스 시간
							time = proService[0] + proArrival[0];// 그러니까 다음 프로세스와 빼주기 위해서 time을 만들었는데 그 time과 도착 시간을 빼줌
							task[0] = new Task("P0", new Date(proArrival[0]), new Date(time));
							totalWait += (double) proTime[0];
							totalTurnAround += (double) turnAround[0];
						} else if (time <= proArrival[i])// 그 합한 시간이 도착시간 보다 작을경우 그러면 바로 진행 가능하다
						{
							proTime[i] = 0;// 따라서 대기 시간은 0
							// turnAround[i] = 0;// 반환 시간 //둘다 주석처리 해놨는데 아직 확실한게 아님,,, 밑에껄로 선택함
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
						System.out.print("프로세스 P" + (i + 1) + "의 대기시간 : " + proTime[i] + "\t");
						System.out.println("프로세스 P" + (i + 1) + "의 반환시간 : " + turnAround[i]);
						// avrWait.setBounds(90, 50, 80, 20);
					}
					System.out.println("평균 대기시간 : " + (totalWait / proArrival.length));
					fcfs_avgWait.setText((totalWait / (double) proArrival.length) + "");
					fcfs_avgWait.setBounds(120, 70, 80, 30);
					System.out.println("평균 반환시간 : " + (totalTurnAround / proArrival.length));
					fcfs_avgTurnAroun.setText((totalTurnAround / (double) proArrival.length) + "");
					fcfs_avgTurnAroun.setBounds(230, 70, 80, 30);
					// avrReturn.setBounds(200, 50, 80, 20);
					midPanel.add(fcfs_avgWait);
					midPanel.add(fcfs_avgTurnAroun);
					midPanel.updateUI();
				}
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "테이블 값에 값이 들어가있지 않거나 테이블생성이 안되었습니다!", "", JOptionPane.WARNING_MESSAGE);
		}
		try {
			if (arg0.getActionCommand().equals("실행")) {
				if (SJF.isSelected()) {
//					System.out.println("SJF기법이 선택되었습니다.");
					proTime = new int[table.getRowCount()];// 대기시간 배열 생성
					turnAround = new int[table.getRowCount()];// 반환시간 배열
					proService = new int[table.getRowCount()];// 프로세스 서비스 시간 행 갯수만큼 배열 생성
					proArrival = new int[table.getRowCount()];// 프로세스 도착시간 행 갯수만큼 배열 생성
					ArrayList<Integer> tempService = new ArrayList<Integer>();
					ArrayList<Integer> tempArrival = new ArrayList<Integer>();
					boolean[] notFinish = new boolean[table.getRowCount()];
					double totalWait = 0;
					double totalTurnAround = 0;

					for (int i = 0; i < table.getRowCount(); i++) {
						int tableArrival = Integer.parseInt(table.getValueAt(i, 3).toString());
						proArrival[i] = tableArrival;
						// proArrival[i] = (int) table.getValueAt(i, 3);// 서비스 시간 초기화
//						System.out.print("proArrival 시간은" + proArrival[i] + " ");
						// proService[i] = (int) table.getValueAt(i, 4);// 도착 시간 초기화
						int tableService = Integer.parseInt(table.getValueAt(i, 4).toString());
						proService[i] = tableService;
//						System.out.println("proService 시간은" + proService[i] + " ");
						// System.out.println("proArrival 정렬된 시간은" + proArrival[i] + " ");
						notFinish[i] = true;
					}

					System.out.println("--------------------------");
					SortServiceAndArriaval(proArrival, proService);
					for (int i = 0; i < table.getRowCount(); i++) {
//						System.out.print("정렬된 proArrival시간 : " + proArrival[i] + "  ");
						// tempService.add(proService[i]);
//						System.out.println("정렬된 proService시간 : " + proService[i] + "  ");
						// tempArrival.add(proArrival[i]);
					}
					for (int i = 0; i < table.getRowCount(); i++) {
						if (i == 0 && notFinish[i]) {
							proTime[0] = 0;// i가 0 이면 대기없이 바로 진행
							turnAround[0] = proService[0];// 반환 시간은 첫번째 서비스 시간
							time = proService[0] + proArrival[0];// 그러니까 다음 프로세스와 빼주기 위해서 time을 만들었는데 그 time과 도착 시간을
							// SJFService[0] = 99999;
							// finishTime += time;
							totalWait += (double) proTime[0];
							totalTurnAround += (double) turnAround[0];
							notFinish[0] = false;
						} else if (time <= proArrival[i] && notFinish[i]) {
							proTime[i] = 0;// 따라서 대기 시간은 0
							// turnAround[i] = 0;//반환 시간 //둘다 주석처리 해놨는데 아직 확실한게 아님,,,
							// turnAround[i] += proService[i];
							turnAround[i] = proService[i];// 반환시간
							time = proArrival[i] + proService[i];// 서비스 시간 + 도착시간
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
						System.out.print("P"+(i + 1)+" : 프로세스 대기시간 : " + proTime[i] + " ");
						System.out.println("P"+(i + 1)+" : 프로세스 반환 시간 : " + turnAround[i]);
					}
					System.out.println("평균 대기시간 : " + (totalWait / (double) proArrival.length));
					SJF_avgWait.setText(totalWait / (double) proArrival.length + "");
					System.out.println("평균 반환시간 : " + (totalTurnAround / (double) proArrival.length));
					SJF_avgTurnAroun.setText(totalTurnAround / (double) proArrival.length + "");
					SJF_avgWait.setBounds(120, 90, 80, 30);
					SJF_avgTurnAroun.setBounds(230, 90, 80, 30);
					midPanel.updateUI();// 업데이트!

				}
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "테이블 값에 값이 들어가있지 않거나 테이블생성이 안되었습니다!", "", JOptionPane.WARNING_MESSAGE);
		}
		try {
			if (arg0.getActionCommand().equals("실행")) {
				if (HRN.isSelected()) {
					System.out.println("HRN기법이 선택 되었습니다.");
					proTime = new int[table.getRowCount()];// 대기시간 배열 생성
					turnAround = new int[table.getRowCount()];// 반환시간 배열
					proService = new int[table.getRowCount()];// 프로세스 서비스 시간 행 갯수만큼 배열 생성
					proArrival = new int[table.getRowCount()];// 프로세스 도착시간 행 갯수만큼 배열 생성
					ArrayList<Integer> tempService = new ArrayList<Integer>();
					ArrayList<Integer> tempArrival = new ArrayList<Integer>();
					ArrayList<Integer> tempProWait = new ArrayList<Integer>();
					ArrayList<Float> responMax = new ArrayList<Float>();
					boolean[] notFinish = new boolean[table.getRowCount()];
					double totalWait = 0;
					double totalTurnAround = 0;

					for (int j = 0; j < table.getRowCount(); j++) {
						int tableService = (Integer.parseInt(table.getValueAt(j, 4).toString()));
						proService[j] = tableService;// 서비스 시간 초기화
						int tableArrival = (Integer.parseInt(table.getValueAt(j, 3).toString()));// toString 해준이유는
						proArrival[j] = tableArrival;// 도착시간 초기화
						notFinish[j] = true; // 그 프로세스가 실행중일때 못들어가게 하려고 불린형 추가시킴
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
							proTime[i] = 0;// 따라서 대기 시간은 0
							// turnAround[i] = 0;//반환 시간 //둘다 주석처리 해놨는데 아직 확실한게 아님,,,
							// turnAround[i] += proService[i];
							turnAround[i] = proService[i];// 반환시간
							time = proArrival[i] + proService[i];// 서비스 시간 + 도착시간
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
								// System.out.print("tempArrival 의 값 : " + tempArrival.get(x));
								// System.out.println("tempService 의 값 : " + tempService.get(x));
								tempProWait.add(time - tempArrival.get(x));
								// System.out.print("tempProWait 의 값 : " + tempProWait.get(x) + " ");
								// System.out.println((tempProWait.get(x) + tempService.get(x)) /
								// tempService.get(x));
								float responPro = (((float) tempProWait.get(x)) + ((float) tempService.get(x)))
										/ ((float) tempService.get(x));
//								System.out.println(tempProWait.get(x) + " + " + tempService.get(x) + " / "
//										+ tempService.get(x) + " = " + responPro);
								responMax.add(responPro);
								// System.out.println("responMax 의 값 : " + responMax.get(x));
							}

							int j = 0;
							while (true) {
								// System.out.println("바뀐 time 의 값 : " + time);
								// System.out.println("");
								if (Collections.max(responMax) == responMax.get(j)) {
//									System.out.println(
//											time + "-" + tempArrival.get(j) + "=" + (time - tempArrival.get(j)));
									proTime[i] = time - tempArrival.get(j);
									turnAround[i] = proTime[i] + tempService.get(j);
									time += tempService.get(j);
									totalWait += (double) proTime[i];
									totalTurnAround += (double) turnAround[i];
									// System.out.println("더해진 time 값 : " + time);
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
						System.out.print("P"+(i+1)+"프로세스 대기시간 : " + proTime[i] + " ");
						System.out.println("P"+(i+1)+"프로세스 반환 시간 : " + turnAround[i]);
					}
					System.out.println("평균 대기 시간 : " + totalWait / (double) proArrival.length);
					HRN_avgWait.setText(totalWait / (double) proArrival.length + "");
					System.out.println("평균 반환 시간 : " + totalTurnAround / (double) proArrival.length);
					HRN_avgTurnAroun.setText(totalTurnAround / (double) proArrival.length + "");
					HRN_avgWait.setBounds(120, 110, 80, 30);
					HRN_avgTurnAroun.setBounds(230, 110, 80, 30);
					midPanel.updateUI();
				}
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "테이블 값에 값이 들어가있지 않거나 테이블생성이 안되었습니다!", "", JOptionPane.WARNING_MESSAGE);
		}
		try
		{
			if(arg0.getActionCommand().equals("실행"))
				if(Priority.isSelected())
				{
					System.out.println("우선순위 기법이 선택 되었습니다.");
					ArrayList<Integer> proWait = new ArrayList<Integer>();
					turnAround = new int[table.getRowCount()];// 반환시간 배열
					proService = new int[table.getRowCount()];// 프로세스 서비스 시간 행 갯수만큼 배열 생성
					proArrival = new int[table.getRowCount()];// 프로세스 도착시간 행 갯수만큼 배열 생성
					ArrayList<Integer> firstprior = new ArrayList<Integer>();//우선순위 넣을 배열 생성
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
						System.out.print("P"+(i+1)+"프로세스 대기시간 : " + proWait.get(i) + " ");
						System.out.println("P"+(i+1)+"프로세스 반환 시간 : " + turnAround[i]);
					}
					System.out.println("평균 대기 시간 : " + totalWait / (double) proArrival.length);
					Priority_avgWait.setText(totalWait / (double) proArrival.length + "");
					System.out.println("평균 반환 시간 : " + totalTurnAround / (double) proArrival.length);
					Priority_avgTurnAroun.setText(totalTurnAround / (double) proArrival.length + "");
					Priority_avgWait.setBounds(120, 110, 80, 30);
					Priority_avgTurnAroun.setBounds(230, 110, 80, 30);
					midPanel.updateUI();
				}
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, "테이블 값에 값이 들어가있지 않거나 테이블생성이 안되었습니다!", "", JOptionPane.WARNING_MESSAGE);
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
			} // 중복 안되게 하는 것
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
	}// 아까 위에 Arrays.sort 하면 같이 동시에 바뀌지를 않아서 클래스를 하나 만듦

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
						JOptionPane.showMessageDialog(null, "도착시간은 음수값이 될수 없습니다!", "", JOptionPane.WARNING_MESSAGE);
						table.setValueAt(null, i, 3);
					} else if ((int) (table.getValueAt(i, 3)) >= 65 || (int) (table.getValueAt(i, 3)) <= 97) {
						JOptionPane.showMessageDialog(null, "도착시간에 문자를 넣을순 없습니다!", "", JOptionPane.WARNING_MESSAGE);
						table.setValueAt("", i, 3);
					}
				}
			} catch (Exception e) {

			}
			try {
				for (int i = 0; i < table.getRowCount(); i++) {
					if (Integer.parseInt(table.getValueAt(i, 4).toString()) < 0) {
						JOptionPane.showMessageDialog(null, "서비스 시간은 음수값이 될 수 없습니다!", "", JOptionPane.WARNING_MESSAGE);
						table.setValueAt(null, i, 4);
					} else if ((int) (table.getValueAt(i, 4)) >= 65 || (int) (table.getValueAt(i, 4)) <= 97) {
						JOptionPane.showMessageDialog(null, "도착시간에 문자를 넣을순 없습니다!", "", JOptionPane.WARNING_MESSAGE);
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