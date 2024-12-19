import javax.swing.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProjectileMotionGraphSwing extends JFrame {

    private final JTextField angleTextField; //Text field for angle input
    private final JTextField velocityTextField; //Text field for velocity input
    private final JTextField massTextField; // Text field for mass input
    private final JComboBox<String> planetComboBox; // Dropdown for selecting planets
    private final XYSeriesCollection dataset; // dataset of x and y coordinate
    private final JFreeChart chart;

    // planet data (mass and gravity)
    private final String[] planets = {"All Planets", "Earth (9.81 m/s^2)", "Moon (1.625 m/s^2)", "Mars (3.72076 m/s^2)"};
    private final double[] gravityValues = {9.81, 1.625, 3.72076};
   

    public ProjectileMotionGraphSwing() {
        setTitle("Projectile Motion Graph");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);

        angleTextField = new JTextField(10); // Angle input field 
        velocityTextField = new JTextField(10); //Velocity input field
        massTextField = new JTextField(10); // Add mass input field
        planetComboBox = new JComboBox<>(planets); // Dropdown for selecting planets
        JButton drawButton = new JButton("Draw Graph"); // Tap button for executting the graph

        dataset = new XYSeriesCollection();
        chart = ChartFactory.createXYLineChart(
                "Projectile Motion", "Horizontal Distance (m)", "Vertical Distance (m)",
                dataset, PlotOrientation.VERTICAL, true, true, false);

        XYPlot plot = chart.getXYPlot();
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        plot.setRenderer(renderer);

        ChartPanel chartPanel = new ChartPanel(chart);

        drawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double angle = Double.parseDouble(angleTextField.getText());
                double velocity = Double.parseDouble(velocityTextField.getText());
                double mass = Double.parseDouble(massTextField.getText()); // Get mass value

                // Check if "All Planets" is selected in the dropdown
                if (planetComboBox.getSelectedIndex() == 0) {
                    dataset.removeAllSeries(); // Clear existing series
                    for (int i = 1; i < planets.length; i++) {
                        double gravity = gravityValues[i - 1];
                        updateGraph(angle, velocity, mass, gravity, planets[i]);
                    }
                } else {
                    int selectedPlanetIndex = planetComboBox.getSelectedIndex();
                    double gravity = gravityValues[selectedPlanetIndex - 1];
                    String planetName = planets[selectedPlanetIndex];
                    updateGraph(angle, velocity, mass, gravity, planetName);
                }
            }
        });

        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Launch Angle (degrees):"));
        inputPanel.add(angleTextField);
        inputPanel.add(new JLabel("Initial Velocity (m/s):"));
        inputPanel.add(velocityTextField);
        inputPanel.add(new JLabel("Mass (kg):")); // Add mass label
        inputPanel.add(massTextField); // Add mass input field
        inputPanel.add(new JLabel("Select Planet:"));
        inputPanel.add(planetComboBox); // Add the planet dropdown
        inputPanel.add(drawButton);

        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(inputPanel, BorderLayout.NORTH);
        contentPane.add(chartPanel, BorderLayout.CENTER);
    }

    private void updateGraph(double angle, double velocity, double mass, double gravity, String planetName) {
        XYSeries projectileSeries = new XYSeries("Projectile Path (" + planetName + ")");
        dataset.addSeries(projectileSeries);

        for (double t = 0; t <= (2 * velocity * Math.sin(Math.toRadians(angle))) / gravity; t += 0.1) {
            double x = velocity * t * Math.cos(Math.toRadians(angle));
            double y = velocity * t * Math.sin(Math.toRadians(angle)) - 0.5 * gravity * t * t;
            projectileSeries.add(x, y);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ProjectileMotionGraphSwing().setVisible(true);
            }
        });
    }
}
