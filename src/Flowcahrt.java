import javax.swing.JFrame;

import org.w3c.dom.Text;

public class Flowcahrt {
 /**    
    Start
  |
  V
Initialize JFrame
  |
  V
Set JFrame Title, Size, and Default Close Operation
  |
  V
Create Text Fields for Angle, Velocity, and Mass Input
  |
  V
Create a Dropdown for Selecting Planets
  |
  V
Create a Button for Drawing the Graph
  |
  V
Initialize a Dataset (XYSeriesCollection)
  |
  V
Create a JFreeChart with Dataset
  |
  V
Get the XYPlot of the Chart
  |
  V
Create an XYLineAndShapeRenderer for the Plot
  |
  V
Create a ChartPanel for Displaying the Chart
  |
  V
Add Action Listener to the "Draw Graph" Button
  |
  V
   |---> Parse Angle, Velocity, and Mass Inputs
   |    |
   |    V
   |   Check if "All Planets" is Selected
   |    |   |
   |    |   V
   |    | Clear Existing Series
   |    |    |
   |    |    V
   |    | Loop Through Selected Planets
   |    |   |
   |    |   V
   |    | Calculate Gravity for the Planet
   |    |    |
   |    |    V
   |    | Update the Graph for the Planet
   |    |
   |    V
   | Else (A Specific Planet is Selected)
   |    |
   |    V
   | Get the Selected Planet's Gravity
   |    |
   |    V
   | Get the Selected Planet's Name
   |    |
   |    V
   | Update the Graph for the Selected Planet
   |
   V
Create an Input Panel for User Inputs
  |
  V
Add Labels, Text Fields, Dropdown, and Button to the Input Panel
  |
  V
Create a Container for the Content Pane
  |
  V
Set Layout for the Content Pane
  |
  V
Add Input Panel to the Content Pane's North
  |
  V
Add Chart Panel to the Content Pane's Center
  |
  V
Display the JFrame
  |
  V
End (Application is Running)

}

**/
}
/*import javax.swing.*;
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

    private final JTextField angleTextField;
    private final JTextField velocityTextField;
    private final JTextField massTextField; // Text field for mass input
    private final JComboBox<String> planetComboBox; // Dropdown for selecting planets
    private final XYSeriesCollection dataset;
    private final JFreeChart chart;

    // Define planet data (mass and gravity) - you can add more planets as needed
    private final String[] planets = {"All Planets", "Earth (9.81 m/s^2)", "Moon (1.625 m/s^2)", "Mars (3.72076 m/s^2)"};
    private final double[] gravityValues = {9.81, 1.625, 3.72076};
    private final double[] massValues = {5.972e24, 7.342e22, 6.4171e23}; // Masses in kg

    public ProjectileMotionGraphSwing() {
        setTitle("Projectile Motion Graph");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);

        angleTextField = new JTextField(10);
        velocityTextField = new JTextField(10);
        massTextField = new JTextField(10); // Add mass input field
        planetComboBox = new JComboBox<>(planets); // Dropdown for selecting planets
        JButton drawButton = new JButton("Draw Graph");

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
*/

