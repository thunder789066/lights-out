/**
 * @(#)ControlPanel.java
 *
 *
 * @author 
 * @version 1.00 2017/2/19
 */

//Swing package GUI components
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

//AWT package GUI details
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

//AWT action events and listener
import java.awt.event.MouseListener;


/**
 * Implementation of the panel that is responsible for the button that
 * resets the state of the Lights Out game back to the start and the
 * tracking of the statistics (number of clicks and lights still left
 * on) in the game. 
 * <p>
 * Again, note that this object IS a type of JPanel.
 *
 */
public class ControlPanel extends JPanel {
 
 /** Size of control panel width to be 32% the width of the game window */
 public static final int WIDTH = (int)(GameWindow.WIDTH * .32);
 
 /** Height of control panel same as LightGrid */
 public static final int HEIGHT = LightGrid.SIZE;
 
 /** 
  * Font for control panel (My implementation was same as the 
  * GameWindow, but at 40pt size).
  */
 public static final Font FONT = new Font("Serif", Font.BOLD, 40);
 
 /**
  * Text color (My implementation was same as the Light's off color)
  */
 public static final Color TEXT_COLOR = Color.ORANGE;
 
 /**
  * Color for reset button
  */
 public static final Color RESET_COLOR = new Color(138, 93, 175);
 
 /**
  * Color for text of reset button
  */
 public static final Color RESET_TEXT_COLOR = Color.WHITE;
 
 /**
  * First Color for the border of the reset button
  */
 public static final Color BORDER1 = new Color(67, 74, 86);
 
 /**
  * Second Color for the border of the reset button
  */
 public static final Color BORDER2 = new Color(82, 104, 140);
 
 
 /**
  * Labels for each of the different parts of the control panel.
  * Note, the part that actually says "Clicks" and the number that
  * is the total number of clicks are separate JLabels. This makes
  * things much easier to layout and adjust.
  */
 private JLabel clickLabel, clickCounter, lightLabel, lightCounter, statusLabel;
 
 /** Button that when clicked resets the game */
 private JButton resetButton;
 
 /** Reference to the MouseListener that came from the top level JFrame */
 private MouseListener gameListener;
 

 /**
  * Creates a new ControlPanel which is responsible for implementing
  * all of the necessary labels for displaying the total number of
  * clicks and lights that remain on, as well as holding the reset
  * button and the label which displays the status of the game. If the
  * game is currently in progress, the bottom status label should read
  * some generic message like "Good Luck!", once the player switches
  * off all of the lights this label should be responsible for displaying
  * a winning message.
  *
  * @param listener MouseListener from the top level JFrame window
  *
  */
 public ControlPanel(MouseListener listener) {
  
  /****************************************************************
   * Correctly assign the specified listener to gameListener.  *
   * Set the size of the ControlPanel, set the opacity to false *
   * since we do not want an outline of the control panel to  *
   * show up, and finally remove the layout so the set bounds  *
   * applied below will take effect.        *
   *                *
   * IMPORTANT IDEA:            *
   * The MouseListener is assigned to the reset button at   *
   * the bottom of this constructor. Note, how simple it   *
   * actually is for different components of a GUI to actually *
   * communicate simply by passing the same object references  *
   * around.              *
   ****************************************************************/
  this.gameListener = listener;
  
  
  /********************************************************
   * THE INSTANTIATION OF EACH OF THE COMPONENTS OF THE *
   * CONTROL PANEL HAVE BEEN SET FOR YOU. DO NOT ADJUST *
   * ANYTHING BELOW THIS COMMENT IN THE CONSTRUCTOR  *
   ********************************************************/
   
  //Create a label for total number of clicks
  this.clickLabel = new JLabel("Clicks:");
  this.clickLabel.setFont(this.FONT);
  this.clickLabel.setForeground(this.TEXT_COLOR);
  //Add click label to this panel
  this.clickLabel.setBounds((int)(this.WIDTH * .01), (int)(this.HEIGHT * .01), (int)(this.WIDTH * .5), (int)(this.HEIGHT * .2));
  this.add(this.clickLabel);
  
  //Create counter label
  this.clickCounter = new JLabel("0");
  this.clickCounter.setFont(this.FONT);
  this.clickCounter.setForeground(this.TEXT_COLOR);
  //Add counter label to this panel
  this.clickCounter.setBounds((int)(this.WIDTH * .7), (int)(this.HEIGHT * .01), (int)(this.WIDTH * .45), (int)(this.HEIGHT * .2)); 
  this.add(this.clickCounter);
  
  
  //Create lights label
  this.lightLabel = new JLabel("Lights:");
  this.lightLabel.setFont(this.FONT);
  this.lightLabel.setForeground(this.TEXT_COLOR);
  //Add light label to this panel
  this.lightLabel.setBounds((int)(this.WIDTH * .01), (int)(this.HEIGHT * .24), (int)(this.WIDTH * .5), (int)(this.HEIGHT * .2));
  this.add(this.lightLabel);
  
  //Create lights counter
  this.lightCounter = new JLabel("0");
  this.lightCounter.setFont(this.FONT);
  this.lightCounter.setForeground(this.TEXT_COLOR);
  //Add light counter label to this panel
  this.lightCounter.setBounds((int)(this.WIDTH * .7), (int)(this.HEIGHT * .24), (int)(this.WIDTH * .45), (int)(this.HEIGHT * .2)); 
  this.add(this.lightCounter);
  
  
  //Create reset button
  this.resetButton = new JButton("Reset");
  this.resetButton.setFont(this.FONT);
  this.resetButton.setPreferredSize(new Dimension((int)(this.WIDTH * .6), (int)(this.HEIGHT * .1) ));
  this.resetButton.setForeground(this.RESET_TEXT_COLOR);
  this.resetButton.setBackground(this.RESET_COLOR);
  this.resetButton.setBorder( new BevelBorder(BevelBorder.RAISED, this.BORDER1, this.BORDER2) );
  this.resetButton.setFocusable(false);
  //Add game listener to this button
  this.resetButton.addMouseListener(this.gameListener);  
  //Add reset button
  this.resetButton.setBounds((int)(this.WIDTH * .2), (int)(this.HEIGHT * .55), (int)(this.WIDTH * .6), (int)(this.HEIGHT * .1));
  this.add(this.resetButton);
  
  
  //Create status label
  this.statusLabel = new JLabel("Good Luck!");
  this.statusLabel.setFont(this.FONT);
  this.statusLabel.setForeground(this.TEXT_COLOR);
  //Add status label
  this.statusLabel.setBounds((int)(this.WIDTH * .1), (int)(this.HEIGHT * .7), (int)(this.WIDTH * .9), (int)(this.HEIGHT * .2));
  this.add(this.statusLabel);
  
 }
 
 /**
  * Reset control panel when reset button clicked
  */
 public void reset() {
     //this.clickCounter = new JLabel("0");
  /****************************************
   * Set the label counters back to zero *
   ****************************************/
     this.clickCounter.setText("0");
 }
 
 /**
  * Return light counter label
  */
 public JLabel getLightCounter() {
   return this.lightCounter;
 }
 
 /**
  * Return click counter label
  */
 public JLabel getClickCounter() {
  return this.clickCounter;
 }
 
}