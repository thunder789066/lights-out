/**
 * @(#)GameWindow.java
 *
 *
 * @author 
 * @version 1.00 2017/2/19
 */

//Swing package GUI
import javax.swing.JPanel;

//AWT package GUI details
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;

//AWT Listener Events
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


/**
 * Implementation of the container that organized the components
 * of our Lights Out game by extending the javax.swing.JPanel class.
 * <p>
 * A JPanel is a lightweight container with easy to learn implementation
 * details such as layouts and painting. When you get the hang of the
 * Graphics class, you can basically use a panel to custom draw any aspect 
 * of your GUI windows and easily break the program graphics into different
 * grid junks. Although, as you become even better, implementing a JComponent
 * itself would be better but we will address that later.
 * <p>
 * Again, the important thing to wrap your head around is because we are
 * inheriting from the JPanel class, this game window is now a JPanel itself
 * and can do all things a JPanel container can do without us having to know
 * how those things are implemented.
 *
 */
public class GameWindow extends JPanel {
 
 /** Set width of game window to same as the Frame width */
 public static final int WIDTH = LightsOut.WIDTH;
 /** Set height of game window to same as the Frame height */
 public static final int HEIGHT = LightsOut.HEIGHT;
 
 
 /** Background color of game window */
 public static final Color BACKGROUND =  Color.BLACK;
 
 
 /** LightGrid object for game which contains all of the Lights */
 private LightGrid grid;
 
 /** ControlPanel object for game which contains stats and reset button */
 private ControlPanel controlPanel;
 
 /** GameListener from JFrame to be passed throughout the different components */
 private MouseListener gameListener;
 
 
 /**
  * Creates a new GameWindow responsible for set up of the different
  * components of the game with the specified MouseListener object that
  * all of the components actions are handled through.
  *
  * @param listener MouseListener that was implemented in the JFrame
  *   window. We will pass this listener object down throughout
  *   the different components of the program so the single
  *    listener object will communicate with all different parts.
  *
  */
 public GameWindow(MouseListener listener) {
  /********************************************************************
   * Set up the listener, correctly set the size, set the background *
   * color and also set the opacity of the JPanel to true (meaning *
   * its not transparent), nullify the layout of this JPanel, and  *
   * invoke the method responsible for creating the components of  *
   * the GameWindow.             *
   ********************************************************************/
   this.gameListener = listener;
   this.setSize(WIDTH, HEIGHT);
   this.setBackground(BACKGROUND);
   this.setOpaque(true);
   this.setLayout(null);
   this.initializeControlPanel();
   this.initializeLightGrid();
 }
 
 
 /**
  * Responsible for implementing the 2D grid of Light objects. This method
  * will only be invoked by the constructor of this class, thus we have set
  * the accessibility to private.
  * <p>
  * Although you may ask why we don't do this in the constructor, it is
  * a useful organizational technique to separate any multiple line 
  * implementations into other methods. Therefore, if we wanted to create
  * a more complex version of the Lights Out game we could add more details
  * to this method. Or, if there were multiple constructors for the class then
  * we would only need to write the implementation once here and each
  * constructor invokes this method themselves.
  * 
  */
 private void initializeLightGrid() {
  /************************************************************************
   * Instantiate a LightGrid, set the bounds of the light grid with the *
   * starting coordinates set to 1% of the width and 14% of the height *
   * of this GameWindow, and finally be sure to add the grid to the  *
   * GameWindow.               *
   ************************************************************************/
  this.grid = new LightGrid(gameListener);
  this.grid.setLocation((int)(WIDTH * .01), ((int)(HEIGHT * .14)));
  //this.add(grid);
 }
 
 /**
  * Responsible for implementing the panel that contains the stats
  * for the game as well as the button that resets the game. Again,
  * for the same reasons as listed in the above method we have
  * separated this task from the constructor.
  *
  */
 private void initializeControlPanel() {
  /****************************************************************
   * Instantiate a ControlPanel, set the bounds of the control *
   * panel with the starting coordinates set to 50 more than  *
   * the width of the LightGrid and the same y-coordinate as  *
   * the LightGrid so they line up nicely, set the text of  * 
   * the light counter label in the control panel to the   *
   * current number of lights that are on, and finally don't  *
   * forget to add the control panel to the GameWindow.   *
   ****************************************************************/
  this.controlPanel = new ControlPanel(gameListener);
  this.controlPanel.setBounds(WIDTH + 50, HEIGHT + 50, WIDTH, HEIGHT);
  this.controlPanel.getLightCounter().setText("" + this.grid.getNumberOfLightsOn());
  
 }
 
 /**
  * Used to pass left click event from main window down to
  * the light grid. Thus the sole purpose here is to act like
  * the middle man, transferring the event from the top level
  * class down to one or more of its parts.
  * 
  * @param e MouseEvent that was passed from the JFrame's 
  *   listener class.
  *
  */
 public void onLeftClick(MouseEvent e) {
  /************************************************************
   * Correctly pass the MouseEvent that occurred to the grid *
   * for processing, then update the control panel's light *
   * counter label to the new number of lights that are on, *
   * and update the click counter label since a click on the  *
   * LightGrid was just determined to have occurred.   *
   ************************************************************/
   this.grid.onLeftClick(e);
   //ControlPanel.getLightCounter();
 }

 /**
  * Responsible for resetting the different components of the Lights Out 
  * game when the reset button has been clicked. This method should be
  * invoked by the JFrame's event handling class when the reset button
  * was clicked.
  * 
  */
 public void reset() {
  /************************************************************
   * Reset the grid, reset the control panel, then update the *
   * control panel's light counter to be the new number of *
   * lights that are on in the grid.       *
   ************************************************************/
  grid.reset();
 } 
}