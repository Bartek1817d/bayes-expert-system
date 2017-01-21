package pl.edu.agh.se;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import swing2swt.layout.BorderLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.layout.FillLayout;
import swing2swt.layout.BoxLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import swing2swt.layout.FlowLayout;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.widgets.Scale;
import org.eclipse.swt.widgets.Slider;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Label;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.swt.widgets.List;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.ui.forms.widgets.FormToolkit;

public class MainWindow {

	protected Shell shell;
	private final FormToolkit formToolkit = new FormToolkit(Display.getDefault());

	/**
	 * Launch the application.
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
		shell.setSize(557, 600);
		shell.setText("SWT Application");
		shell.setLayout(new FillLayout(SWT.VERTICAL));
		
		Group grpGender = new Group(shell, SWT.NONE);
		grpGender.setText("Gender");
		grpGender.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		Button btnMale = new Button(grpGender, SWT.BORDER | SWT.RADIO);
		btnMale.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnMale.setText("Male");
		
		Button btnFemale = new Button(grpGender, SWT.BORDER | SWT.RADIO);
		btnFemale.setText("Female");
		
		Group grpActing = new Group(shell, SWT.NONE);
		grpActing.setText("Acting Skills");
		grpActing.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		Composite composite = new Composite(grpActing, SWT.NONE);
		composite.setLayout(new FillLayout(SWT.VERTICAL));
		
		Scale scaleActing = new Scale(composite, SWT.NONE);
		scaleActing.setPageIncrement(1);
		scaleActing.setMaximum(3);
		scaleActing.setMinimum(1);
		scaleActing.setSelection(1);
		
		Composite composite_1 = new Composite(composite, SWT.NONE);
		composite_1.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		Label lblNewLabel = new Label(composite_1, SWT.NONE);
		lblNewLabel.setText("Bad");
		
		Label lblNewLabel_1 = new Label(composite_1, SWT.NONE);
		lblNewLabel_1.setAlignment(SWT.CENTER);
		lblNewLabel_1.setText("Average");
		
		Label lblNewLabel_2 = new Label(composite_1, SWT.NONE);
		lblNewLabel_2.setAlignment(SWT.RIGHT);
		lblNewLabel_2.setText("Good");
		
		Group grpLanguage = new Group(shell, SWT.NONE);
		grpLanguage.setText("Language Skills");
		grpLanguage.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		Composite composite_2 = new Composite(grpLanguage, SWT.NONE);
		composite_2.setLayout(new FillLayout(SWT.VERTICAL));
		
		Scale scaleLang = new Scale(composite_2, SWT.NONE);
		scaleLang.setPageIncrement(1);
		scaleLang.setMaximum(3);
		scaleLang.setMinimum(1);
		scaleLang.setSelection(1);
		
		Composite composite_3 = new Composite(composite_2, SWT.NONE);
		composite_3.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		Label label = new Label(composite_3, SWT.NONE);
		label.setText("Bad");
		
		Label label_1 = new Label(composite_3, SWT.NONE);
		label_1.setText("Average");
		label_1.setAlignment(SWT.CENTER);
		
		Label label_2 = new Label(composite_3, SWT.NONE);
		label_2.setText("Good");
		label_2.setAlignment(SWT.RIGHT);
		
		Group grpProgramming = new Group(shell, SWT.NONE);
		grpProgramming.setText("Programming Skills");
		grpProgramming.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		Composite composite_5 = new Composite(grpProgramming, SWT.NONE);
		composite_5.setLayout(new FillLayout(SWT.VERTICAL));
		
		Scale scale = new Scale(composite_5, SWT.NONE);
		scale.setPageIncrement(1);
		scale.setMaximum(3);
		scale.setMinimum(1);
		scale.setSelection(1);
		
		Composite composite_6 = new Composite(composite_5, SWT.NONE);
		composite_6.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		Label label_3 = new Label(composite_6, SWT.NONE);
		label_3.setText("Bad");
		
		Label label_4 = new Label(composite_6, SWT.NONE);
		label_4.setText("Average");
		label_4.setAlignment(SWT.CENTER);
		
		Label label_5 = new Label(composite_6, SWT.NONE);
		label_5.setText("Good");
		label_5.setAlignment(SWT.RIGHT);
		
		Group grpMathematical = new Group(shell, SWT.NONE);
		grpMathematical.setText("Mathematical Skills");
		grpMathematical.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		Composite composite_7 = new Composite(grpMathematical, SWT.NONE);
		composite_7.setLayout(new FillLayout(SWT.VERTICAL));
		
		Scale scale_1 = new Scale(composite_7, SWT.NONE);
		scale_1.setPageIncrement(1);
		scale_1.setMaximum(3);
		scale_1.setMinimum(1);
		scale_1.setSelection(1);
		
		Composite composite_8 = new Composite(composite_7, SWT.NONE);
		composite_8.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		Label label_6 = new Label(composite_8, SWT.NONE);
		label_6.setText("Bad");
		
		Label label_7 = new Label(composite_8, SWT.NONE);
		label_7.setText("Average");
		label_7.setAlignment(SWT.CENTER);
		
		Label label_8 = new Label(composite_8, SWT.NONE);
		label_8.setText("Good");
		label_8.setAlignment(SWT.RIGHT);
		
		Group grpAnalyticalThinking = new Group(shell, SWT.NONE);
		grpAnalyticalThinking.setText("Analytical Thinking Skills");
		grpAnalyticalThinking.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		Composite composite_9 = new Composite(grpAnalyticalThinking, SWT.NONE);
		composite_9.setLayout(new FillLayout(SWT.VERTICAL));
		
		Scale scale_2 = new Scale(composite_9, SWT.NONE);
		scale_2.setPageIncrement(1);
		scale_2.setMaximum(3);
		scale_2.setMinimum(1);
		scale_2.setSelection(1);
		
		Composite composite_10 = new Composite(composite_9, SWT.NONE);
		composite_10.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		Label label_9 = new Label(composite_10, SWT.NONE);
		label_9.setText("Bad");
		
		Label label_10 = new Label(composite_10, SWT.NONE);
		label_10.setText("Average");
		label_10.setAlignment(SWT.CENTER);
		
		Label label_11 = new Label(composite_10, SWT.NONE);
		label_11.setText("Good");
		label_11.setAlignment(SWT.RIGHT);
		
		Group grpSport = new Group(shell, SWT.NONE);
		grpSport.setText("Sport Skills");
		grpSport.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		Composite composite_11 = new Composite(grpSport, SWT.NONE);
		composite_11.setLayout(new FillLayout(SWT.VERTICAL));
		
		Scale scale_3 = new Scale(composite_11, SWT.NONE);
		scale_3.setPageIncrement(1);
		scale_3.setMaximum(3);
		scale_3.setMinimum(1);
		scale_3.setSelection(1);
		
		Composite composite_12 = new Composite(composite_11, SWT.NONE);
		composite_12.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		Label label_12 = new Label(composite_12, SWT.NONE);
		label_12.setText("Bad");
		
		Label label_13 = new Label(composite_12, SWT.NONE);
		label_13.setText("Average");
		label_13.setAlignment(SWT.CENTER);
		
		Label label_14 = new Label(composite_12, SWT.NONE);
		label_14.setText("Good");
		label_14.setAlignment(SWT.RIGHT);
		
		Group grpInterests = new Group(shell, SWT.NONE);
		grpInterests.setText("Interests");
		grpInterests.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		Composite composite_4 = new Composite(grpInterests, SWT.NONE);
		composite_4.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		Button btnPoliticalInterests = new Button(composite_4, SWT.CHECK);
		btnPoliticalInterests.setText("Political");
		
		Button btnTechnicalInterrests = new Button(composite_4, SWT.CHECK);
		btnTechnicalInterrests.setText("Technical");
		
		Button btnSportInterests = new Button(composite_4, SWT.CHECK);
		btnSportInterests.setText("Sport");
		
		Group group = new Group(shell, SWT.NONE);
		group.setText("Interests");
		formToolkit.adapt(group);
		formToolkit.paintBordersFor(group);
		group.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		Composite composite_13 = new Composite(group, SWT.NONE);
		formToolkit.adapt(composite_13);
		formToolkit.paintBordersFor(composite_13);
		composite_13.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		Button button = new Button(composite_13, SWT.CHECK);
		button.setText("Political");
		formToolkit.adapt(button, true, true);
		
		Button button_1 = new Button(composite_13, SWT.CHECK);
		button_1.setText("Technical");
		formToolkit.adapt(button_1, true, true);
		
		Button button_2 = new Button(composite_13, SWT.CHECK);
		button_2.setText("Sport");
		formToolkit.adapt(button_2, true, true);

	}
}
