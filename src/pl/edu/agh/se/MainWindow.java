package pl.edu.agh.se;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Scale;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.forms.widgets.FormToolkit;
import smile.Network;

public class MainWindow {

	protected Shell shell;
	private final FormToolkit formToolkit = new FormToolkit(Display.getDefault());
	private final Network bayesNetwork;
	private Network currentNetwork;
	private Button btnMale, btnFemale;
	private Scale scaleActing, scaleLang, scaleProg, scaleMath, scaleAnalyth, scaleSports;
	private Button btnPoliticalInterests, btnTechnicalInterrests, btnSportInterests;
	private Results results;
	private final double[] defYes = new double[5];
	private final double[] rathYes = new double[5];
	private final double[] rathNo = new double[5];
	private final double[] defNo = new double[5];

	public MainWindow() throws CloneNotSupportedException {
		bayesNetwork = new Network();
		bayesNetwork.readFile("res/expert_system.xdsl");
		// currentNetwork = (Network) bayesNetwork.clone();
		currentNetwork = bayesNetwork;
	}

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			MainWindow window = new MainWindow();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(400, 600);
		shell.setText("SWT Application");
		shell.setLayout(new FillLayout(SWT.VERTICAL));

		Group grpGender = new Group(shell, SWT.NONE);
		grpGender.setText("Gender");
		grpGender.setLayout(new FillLayout(SWT.HORIZONTAL));

		btnMale = new Button(grpGender, SWT.BORDER | SWT.RADIO);
		btnMale.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				currentNetwork.setEvidence("Gender", "Male");
			}
		});
		btnMale.setText("Male");

		btnFemale = new Button(grpGender, SWT.BORDER | SWT.RADIO);
		btnFemale.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				currentNetwork.setEvidence("Gender", "Female");
			}
		});
		btnFemale.setText("Female");

		Group grpActing = new Group(shell, SWT.NONE);
		grpActing.setText("Acting Skills");
		grpActing.setLayout(new FillLayout(SWT.HORIZONTAL));

		scaleActing = new Scale(grpActing, SWT.NONE);
		scaleActing.setPageIncrement(1);
		scaleActing.setMaximum(3);
		scaleActing.setMinimum(1);
		scaleActing.setSelection(1);
		scaleActing.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				int selection = scaleActing.getSelection();
				switch (selection) {
				case 1:
					currentNetwork.setEvidence("Acting_Skills", "Bad");
					break;
				case 2:
					currentNetwork.setEvidence("Acting_Skills", "Average");
					break;
				case 3:
					currentNetwork.setEvidence("Acting_Skills", "Good");
					break;
				}

			}
		});

		Group grpLanguage = new Group(shell, SWT.NONE);
		grpLanguage.setText("Language Skills");
		grpLanguage.setLayout(new FillLayout(SWT.HORIZONTAL));

		scaleLang = new Scale(grpLanguage, SWT.NONE);
		scaleLang.setPageIncrement(1);
		scaleLang.setMaximum(3);
		scaleLang.setMinimum(1);
		scaleLang.setSelection(1);
		scaleLang.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				int selection = scaleLang.getSelection();
				switch (selection) {
				case 1:
					currentNetwork.setEvidence("Language_Skills", "Bad");
					break;
				case 2:
					currentNetwork.setEvidence("Language_Skills", "Average");
					break;
				case 3:
					currentNetwork.setEvidence("Language_Skills", "Good");
					break;
				}
			}
		});

		Group grpProgramming = new Group(shell, SWT.NONE);
		grpProgramming.setText("Programming Skills");
		grpProgramming.setLayout(new FillLayout(SWT.HORIZONTAL));

		scaleProg = new Scale(grpProgramming, SWT.NONE);
		scaleProg.setPageIncrement(1);
		scaleProg.setMaximum(3);
		scaleProg.setMinimum(1);
		scaleProg.setSelection(1);
		scaleProg.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				int selection = scaleProg.getSelection();
				switch (selection) {
				case 1:
					currentNetwork.setEvidence("Programming_Skills", "Bad");
					break;
				case 2:
					currentNetwork.setEvidence("Programming_Skills", "Average");
					break;
				case 3:
					currentNetwork.setEvidence("Programming_Skills", "Good");
					break;
				}
			}
		});

		Group grpMathematical = new Group(shell, SWT.NONE);
		grpMathematical.setText("Mathematical Skills");
		grpMathematical.setLayout(new FillLayout(SWT.HORIZONTAL));

		scaleMath = new Scale(grpMathematical, SWT.NONE);
		scaleMath.setPageIncrement(1);
		scaleMath.setMaximum(3);
		scaleMath.setMinimum(1);
		scaleMath.setSelection(1);
		scaleMath.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				int selection = scaleMath.getSelection();
				switch (selection) {
				case 1:
					currentNetwork.setEvidence("Mathematical_Skills", "Bad");
					break;
				case 2:
					currentNetwork.setEvidence("Mathematical_Skills", "Average");
					break;
				case 3:
					currentNetwork.setEvidence("Mathematical_Skills", "Good");
					break;
				}
			}
		});

		Group grpAnalyticalThinking = new Group(shell, SWT.NONE);
		grpAnalyticalThinking.setText("Analytical Thinking Skills");
		grpAnalyticalThinking.setLayout(new FillLayout(SWT.HORIZONTAL));

		scaleAnalyth = new Scale(grpAnalyticalThinking, SWT.NONE);
		scaleAnalyth.setPageIncrement(1);
		scaleAnalyth.setMaximum(3);
		scaleAnalyth.setMinimum(1);
		scaleAnalyth.setSelection(1);
		scaleAnalyth.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				int selection = scaleAnalyth.getSelection();
				switch (selection) {
				case 1:
					currentNetwork.setEvidence("Analytical_Thinking", "Bad");
					break;
				case 2:
					currentNetwork.setEvidence("Analytical_Thinking", "Average");
					break;
				case 3:
					currentNetwork.setEvidence("Analytical_Thinking", "Good");
					break;
				}
			}
		});

		Group grpSport = new Group(shell, SWT.NONE);
		grpSport.setText("Sport Skills");
		grpSport.setLayout(new FillLayout(SWT.HORIZONTAL));

		scaleSports = new Scale(grpSport, SWT.NONE);
		scaleSports.setPageIncrement(1);
		scaleSports.setMaximum(3);
		scaleSports.setMinimum(1);
		scaleSports.setSelection(1);
		scaleSports.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				int selection = scaleSports.getSelection();
				switch (selection) {
				case 1:
					currentNetwork.setEvidence("Sport_Skills", "Bad");
					break;
				case 2:
					currentNetwork.setEvidence("Sport_Skills", "Average");
					break;
				case 3:
					currentNetwork.setEvidence("Sport_Skills", "Good");
					break;
				}
			}
		});

		Composite composite_1 = new Composite(shell, SWT.NONE);
		formToolkit.adapt(composite_1);
		formToolkit.paintBordersFor(composite_1);
		composite_1.setLayout(new FillLayout(SWT.HORIZONTAL));

		Label label = new Label(composite_1, SWT.NONE);
		label.setText("Bad");
		formToolkit.adapt(label, true, true);

		Label label_1 = new Label(composite_1, SWT.NONE);
		label_1.setText("Average");
		label_1.setAlignment(SWT.CENTER);
		formToolkit.adapt(label_1, true, true);

		Label label_2 = new Label(composite_1, SWT.NONE);
		label_2.setText("Good");
		label_2.setAlignment(SWT.RIGHT);
		formToolkit.adapt(label_2, true, true);

		Group grpInterests = new Group(shell, SWT.NONE);
		grpInterests.setText("Interests");
		grpInterests.setLayout(new FillLayout(SWT.HORIZONTAL));

		Composite composite_4 = new Composite(grpInterests, SWT.NONE);
		composite_4.setLayout(new FillLayout(SWT.HORIZONTAL));

		btnPoliticalInterests = new Button(composite_4, SWT.CHECK);
		btnPoliticalInterests.setText("Political");
		btnPoliticalInterests.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				boolean selection = btnPoliticalInterests.getSelection();
				if (selection)
					currentNetwork.setEvidence("Political_Interests", "Yes");
				else
					currentNetwork.setEvidence("Political_Interests", "No");

			}
		});

		btnTechnicalInterrests = new Button(composite_4, SWT.CHECK);
		btnTechnicalInterrests.setText("Technical");
		btnTechnicalInterrests.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				boolean selection = btnTechnicalInterrests.getSelection();
				if (selection)
					currentNetwork.setEvidence("Technical_Interests", "Yes");
				else
					currentNetwork.setEvidence("Technical_Interests", "No");

			}
		});

		btnSportInterests = new Button(composite_4, SWT.CHECK);
		btnSportInterests.setText("Sport");
		btnSportInterests.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				boolean selection = btnSportInterests.getSelection();
				if (selection)
					currentNetwork.setEvidence("Sport_Interests", "Yes");
				else
					currentNetwork.setEvidence("Sport_Interests", "No");

			}
		});

		Composite controls = new Composite(shell, SWT.NONE);
		formToolkit.adapt(controls);
		formToolkit.paintBordersFor(controls);
		controls.setLayout(null);

		Button btnOK = new Button(controls, SWT.NONE);
		btnOK.setBounds(72, 10, 75, 25);
		formToolkit.adapt(btnOK, true, true);
		btnOK.setText("OK");
		btnOK.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				currentNetwork.updateBeliefs();
				double[] values;
				values = currentNetwork.getNodeValue("Academy_Of_Psyhical_Education");
				defYes[0] = values[0] * 100;
				rathYes[0] = values[1] * 100;
				rathNo[0] = values[2] * 100;
				defNo[0] = values[3] * 100;
				
				values = currentNetwork.getNodeValue("Journalism");
				defYes[1] = values[0] * 100;
				rathYes[1] = values[1] * 100;
				rathNo[1] = values[2] * 100;
				defNo[1] = values[3] * 100;
				
				values = currentNetwork.getNodeValue("Technical_University");
				defYes[2] = values[0] * 100;
				rathYes[2] = values[1] * 100;
				rathNo[2] = values[2] * 100;
				defNo[2] = values[3] * 100;
				
				values = currentNetwork.getNodeValue("IT_Studies");
				defYes[3] = values[0] * 100;
				rathYes[3] = values[1] * 100;
				rathNo[3] = values[2] * 100;
				defNo[3] = values[3] * 100;
				
				values = currentNetwork.getNodeValue("Acting_School");
				defYes[4] = values[0] * 100;
				rathYes[4] = values[1] * 100;
				rathNo[4] = values[2] * 100;
				defNo[4] = values[3] * 100;
					
				try {
					results = new Results(Display.getDefault(), defYes, rathYes, rathNo, defNo);
					results.open();
					currentNetwork = (Network) bayesNetwork.clone();
				} catch (CloneNotSupportedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		Button btnReset = new Button(controls, SWT.NONE);
		btnReset.setBounds(223, 10, 75, 25);
		formToolkit.adapt(btnReset, true, true);
		btnReset.setText("Reset");
		btnReset.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					currentNetwork = (Network) bayesNetwork.clone();
				} catch (CloneNotSupportedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

	}
}
