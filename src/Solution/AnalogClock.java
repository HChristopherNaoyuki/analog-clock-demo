package Solution;

import javax.swing.*;
import java.awt.*;
import java.util.Calendar;

public class AnalogClock extends JPanel
{
    private int hours, minutes, seconds;

    // Constructor to set up the clock panel
    public AnalogClock()
    {
        // Set the background color of the clock to white
        setBackground(Color.WHITE);

        // Create a timer that triggers every second (1000 milliseconds)
        Timer timer = new Timer(1000, e ->
        {
            update(); // Update the current time
            repaint(); // Repaint the panel to show the updated time
        });
        
        // Start the timer
        timer.start();
    }

    // Method to update the current hours, minutes, and seconds
    private void update()
    {
        // Get the current time using the Calendar class
        Calendar now = Calendar.getInstance();
        
        // Retrieve the current hour, minute, and second
        hours = now.get(Calendar.HOUR);
        minutes = now.get(Calendar.MINUTE);
        seconds = now.get(Calendar.SECOND);
    }

    // Method to paint the components of the clock
    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g); // Call the superclass method to clear the panel
        
        // Get the dimensions of the panel
        int width = getWidth();
        int height = getHeight();
        
        // Calculate the center coordinates of the panel
        int centerX = width / 2;
        int centerY = height / 2;
        
        // Define the radius of the clock
        int radius = Math.min(width, height) / 2 - 10;

        // Draw the clock outline (circle)
        g.setColor(Color.BLACK);
        g.drawOval(centerX - radius, centerY - radius, 2 * radius, 2 * radius);

        // Draw the hour hand
        double hourAngle = Math.toRadians((hours % 12) * 30 + (minutes / 2)); // Calculate the angle of the hour hand
        int hourHandLength = radius / 2; // Define the length of the hour hand
        int hourX = (int) (centerX + hourHandLength * Math.cos(hourAngle)); // Calculate the x-coordinate of the hour hand's end
        int hourY = (int) (centerY + hourHandLength * Math.sin(hourAngle)); // Calculate the y-coordinate of the hour hand's end
        g.drawLine(centerX, centerY, hourX, hourY); // Draw the hour hand

        // Draw the minute hand
        double minuteAngle = Math.toRadians(minutes * 6 + (seconds / 10)); // Calculate the angle of the minute hand
        int minuteHandLength = (int) (radius * 0.8); // Define the length of the minute hand
        int minuteX = (int) (centerX + minuteHandLength * Math.cos(minuteAngle)); // Calculate the x-coordinate of the minute hand's end
        int minuteY = (int) (centerY + minuteHandLength * Math.sin(minuteAngle)); // Calculate the y-coordinate of the minute hand's end
        g.drawLine(centerX, centerY, minuteX, minuteY); // Draw the minute hand

        // Draw the second hand
        double secondAngle = Math.toRadians(seconds * 6); // Calculate the angle of the second hand
        int secondHandLength = (int) (radius * 0.9); // Define the length of the second hand
        int secondX = (int) (centerX + secondHandLength * Math.cos(secondAngle)); // Calculate the x-coordinate of the second hand's end
        int secondY = (int) (centerY + secondHandLength * Math.sin(secondAngle)); // Calculate the y-coordinate of the second hand's end
        g.setColor(Color.RED); // Set the color of the second hand to red
        g.drawLine(centerX, centerY, secondX, secondY); // Draw the second hand
    }

    // Main method to run the application
    public static void main(String[] args)
    {
        JFrame frame = new JFrame("Analog Clock"); // Create a new frame for the clock
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exit the application when the frame is closed
        frame.setSize(400, 400); // Set the size of the frame
        frame.setLocationRelativeTo(null); // Center the frame on the screen
        AnalogClock clock = new AnalogClock(); // Create an instance of the AnalogClock
        frame.add(clock); // Add the clock to the frame
        frame.setVisible(true); // Make the frame visible
    }
}
