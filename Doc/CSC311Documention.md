# CSC311 Convex Hull Project Documentation

Course: CSC311 Instructor: Dr. Mishal Aldekhayel \
Team Members: Mohammed Alwanis, Waleed Alnajashi, Fahad Alsuhaibani, Abdulrahamn Almzeal 

## Project Overview
For our CSC311 project, we built a Java application with a graphical user interface (GUI) to visualize how different Convex Hull algorithms work. The app lets the user load a text file full of 2D coordinates, displays them on a grid, and draws the convex hull using three different methods so we can compare them.

## Our Classes
Here is a breakdown of how we organized our code into three main classes:

### 1. ConvexHullApp.java (The Main GUI)
This is the main file we run to start the program.


Screens: We used a CardLayout so the app starts on a Welcome screen (with a start button and a credits button) and then switches to the Main App screen when you click "Start Project".


Layout: The main app is split into three parts using BorderLayout.

The left side has all our control buttons (Load Data, Brute Force, Quick Hull, Graham Scan, Reset, and Back).

The center is the canvas where the points are drawn.

The right side is a dashboard that prints out the execution time in milliseconds and lists the exact coordinates of the Upper Hull, Lower Hull, and Extreme Points.

### 2. DrawerPanel.java (The Visualization & Algorithms)
This class extends JPanel and is basically the engine of our project. It handles both the math and the drawing.

Drawing the Graph: The paintComponent method draws a grid with X and Y axes. We made it scale automatically so no matter how big the coordinates are, they fit on the screen.

The Algorithms: We implemented three algorithms inside this class:

Brute Force (runBruteForce): Checks points one by one to find the outermost boundary.

Quick Hull (runQuickHull): Uses recursion to divide the points into upper and lower sets.

Graham Scan (runGrahamScan): Sorts the points by polar angle and uses a Stack to figure out the counter-clockwise turns.

Colors: To make it easy to understand, we coded it so the Upper Hull draws in blue, the Lower Hull in green, and the Extreme points show up as big red dots. We also wrote a quick bubble sort method so the lines connect properly from left to right.

### 3. Reader.java (File Handling)
This is a small helper class we made just for reading files.

Reading Data (getData): It takes the path of a .txt file containing our X,Y data, strips out the parentheses, and puts the coordinates into a String array. The DrawerPanel then uses this array to plot the points.


Getting the Logo: We also put a getLogo method here to load the KSU image file for our Welcome screen.

How to Run Our Project
Run ConvexHullApp.java to open the app.

Click Start Project.

Click Load Data on the left and pick a text file with coordinate points.

Click on Brute Force, Quick Hull, or Graham Scan to watch the algorithm calculate and draw the hull.

Check the right panel to see how fast it ran and which points were chosen.

Hit Reset if you want to clear the screen and try again.
