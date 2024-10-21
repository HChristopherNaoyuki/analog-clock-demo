# Analog Clock Application

## Overview
This Java Swing application displays a simple analog clock. It updates every second to show the current time with hour, minute, and second hands.

## Features
- Real-time updating of the current time.
- Clear, simple UI with a white background.
- Hour, minute, and second hands accurately represent the current time.

## Prerequisites
- Java Development Kit (JDK) 8 or higher.
- An IDE or text editor for Java development (e.g., IntelliJ IDEA, Eclipse, or command line).

## Setup

### Running the Application
1. **Clone the Repository** (if applicable):
   ```bash
   git clone https://github.com/HChristopherNaoyuki/analog-clock-demo.git
   ```

2. **Navigate to the Project Directory**:
   ```bash
   cd analog-clock
   ```

3. **Compile the Java File**:
   ```bash
   javac Solution/AnalogClock.java
   ```

4. **Run the Application**:
   ```bash
   java Solution.AnalogClock
   ```

## Code Explanation
- **AnalogClock Class**: This class extends `JPanel` and handles the drawing of the clock and updating of time:
  - A `Timer` is used to update the time every second and repaint the clock.
  - The `update` method retrieves the current hours, minutes, and seconds using the `Calendar` class.
  - The `paintComponent` method draws the clock face, hour hand, minute hand, and second hand.

- **Main Method**: This method creates a JFrame, sets its properties, and adds the `AnalogClock` instance to it, displaying the clock in a window.

## Customization
You can modify the clock's size, colors, and other properties by adjusting the relevant sections in the code. For instance, you can change the background color by modifying the `setBackground` method in the constructor.
