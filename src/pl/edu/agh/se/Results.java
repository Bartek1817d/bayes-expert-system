package pl.edu.agh.se;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.FillLayout;
import org.swtchart.Chart;
import org.swtchart.IBarSeries;
import org.swtchart.ISeries.SeriesType;
import org.swtchart.Range;

public class Results extends Shell {

	private final double[] defYes;
	private final double[] rathYes;
	private final double[] rathNo;
	private final double[] defNo;
	private static final String[] outcomes = { "Academy of Physical Education", "Journalism", "Technical University",
			"IT Studies", "Acting School" };

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	/*public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			Results shell = new Results(display);
			shell.open();
			shell.layout();
			while (!shell.isDisposed()) {
				if (!display.readAndDispatch()) {
					display.sleep();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	/**
	 * Create the shell.
	 * 
	 * @param display
	 */
	public Results(Display display, double[] defYes, double[] rathYes, double[] rathNo, double[] defNo) {
		super(display, SWT.SHELL_TRIM);
		this.defYes = defYes;
		this.rathYes = rathYes;
		this.rathNo = rathNo;
		this.defNo = defNo;
		
		setLayout(new FillLayout(SWT.HORIZONTAL));
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("SWT Application");
		setSize(1000, 388);
		Chart chart = new Chart(this, SWT.NONE);

		chart.setOrientation(SWT.VERTICAL);
		
		// set titles
		chart.getTitle().setText("Results");
		chart.getAxisSet().getXAxis(0).getTitle().setText("");
		chart.getAxisSet().getYAxis(0).getTitle().setText("");

		// set category
		chart.getAxisSet().getXAxis(0).enableCategory(true);
		chart.getAxisSet().getXAxis(0).setCategorySeries(outcomes);

		IBarSeries defYesSeries = (IBarSeries) chart.getSeriesSet().createSeries(SeriesType.BAR, "definitely yes");
		defYesSeries.setYSeries(defYes);
		defYesSeries.setBarColor(Display.getDefault().getSystemColor(SWT.COLOR_GREEN));
		
		IBarSeries rathYesSeries = (IBarSeries) chart.getSeriesSet().createSeries(SeriesType.BAR, "rather yes");
		rathYesSeries.setYSeries(rathYes);
		rathYesSeries.setBarColor(Display.getDefault().getSystemColor(SWT.COLOR_YELLOW));
		
		IBarSeries rathNoSeries = (IBarSeries) chart.getSeriesSet().createSeries(SeriesType.BAR, "rather no");
		rathNoSeries.setYSeries(rathNo);
		rathNoSeries.setBarColor(Display.getDefault().getSystemColor(SWT.COLOR_DARK_YELLOW));
		
		IBarSeries defNoSeries = (IBarSeries) chart.getSeriesSet().createSeries(SeriesType.BAR, "definitely no");
		defNoSeries.setYSeries(defNo);
		defNoSeries.setBarColor(Display.getDefault().getSystemColor(SWT.COLOR_RED));

		defYesSeries.enableStack(true);
		rathYesSeries.enableStack(true);
		rathNoSeries.enableStack(true);
		defNoSeries.enableStack(true);
		
		chart.getAxisSet().adjustRange();
		//chart.getAxisSet().getYAxes()[0].setRange(new Range(0, 100));
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

}
