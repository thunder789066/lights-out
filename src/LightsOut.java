/**
 * @(#)LightsOut.java
 *
 *
 * @author 
 * @version 1.00 2017/2/19
 */


//AWT package GUI details
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;

//AWT Listener Events
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

//Swing package GUI components
import javax.swing.JButton;
import javax.swing.JFrame;



/**
 * An implementation of a JFrame window that simulates the game Lights Out.
 * <p>
 * The LightsOut class extends a JFrame, thus it itself is a JFrame window.
 * We extend the javax.swing.JFrame class so our Lights Out game will have
 * all the properties and behaviors of a normal window on the operating system.
 * Thus, all we have to do is at to the class what we want to be inside of
 * that JFrame window. The parent class takes care of all of the difficult
 * operating system window management details for us.
 * <p>
 * This is one of the most useful purposes of inheritance in programming. Once
 * it has been created, we never recreate it again. A good programmer can
 * break up their problem into a set of problems that we already have solutions
 * for. What is left over that we haven't solved is usually much smaller and
 * easier to implementation a solution that works for us for the time being.
 * 
 */
public class LightsOut extends JFrame {
 
 /** Set width of game window to 70% width of computer screen */
 public static final int WIDTH = (int)(Toolkit.getDefaultToolkit().getScreenSize().getWidth() * .6);
 /** Set height of game window to 70% height of computer screen */
 public static final int HEIGHT = (int)(Toolkit.getDefaultToolkit().getScreenSize().getHeight() * .8);
 
 /** Text color for logo */
 public static final Color LOGO  =  Color.RED;
 /** Shadow color for logo */
 public static final Color LOGO_SHADOW = new Color(224, 145, 145);
 
 /** Amount of depth the shadow is behind the Logo Text */
 public static final int DEPTH = 6;
 
 /** Window title of game */
 public static final String TITLE = "Lights Out";
 
 /** Font for text */
 public static final Font FONT = new Font("Serif", Font.BOLD, 40);
 
 
 /** GameWindow for game containing the grid and control panel **/
 private GameWindow gameWindow;
 
 
//================================================================================================================================================================= 
 /**
  * Initialize and start LightsOut game window
  */
 public static void main(String[] args) {
  
  /********************************************************
   * Initialize and activate the Lights Out JFrame here *
   ********************************************************/
   
 }
//================================================================================================================================================================= 
 
 
 /**
  * Creates a default lights out window. Instantiates a new GameWindow
  * object which is the panel that holds the different parts of the
  * game. The GameWindow will then implement all the necessary components
  * the Lights Out game needs to run.
  */
 public LightsOut() {
  /********************************************************************
   * Set the size of the window, deactivate the resizable option so *
   * the window cannot be resized, set the JFrame window to stop the *
   * program when the window is closed (look up JFrame default close *
   * operation), nullify the layout of the JFrame, then instantiate *
   * a the GameWindow with bounds that will cover the entire JFrame *
   * and add it to the JFrame           *
   ********************************************************************/
  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 }
 
 /**
  * Activates the LightsOut JFrame window by setting
  * visibility to true.
  */
 public void play() {
  
  /********************************
   * Activate the JFrame window *
   ********************************/
   
 }
 
 /**
  * Overrides paint method from parent class. Important to note that
  * overriding the paint method incorrectly can result in detrimental
  * side effects in showing your GUI to the screen. If you must override
  * the paint method there are two things you must consider:
  * <p>
  * <ul>
  * <li> 1) If you are using a Layout Manager then you MUST make a call
  *   to the super class paint method in order to correctly draw
  *   those components with the corresponding layout. Then, any
  *   additional details you may draw AFTER said call has completed.
  *
  * <li> 2) If you have set the layout to <code>null</code> then the order
  *   in which components are drawn are up to your implementation and
  *   their locations will be based off of their bounds that are set
  *   via their setBounds(x, y, w, h) method. If no call to the set
  *   bounds method, then that component will not have a location in
  *   the container.
  * </ul>
  * 
  * @param g the specified Graphics window
  *
  */
 @Override public void paint(Graphics g) {
  //Convert Graphics object from OS of computer to 2D Graphics
  // Graphics2D inherits (subclass of) Graphics
  Graphics2D g2 = (Graphics2D) g;
  
  //Call parent to paint all components added to window.
  super.paint(g2);
  
  
  /* Paint logo after other components painted */
  g2.setFont(this.FONT);
  int x = (int)(this.WIDTH * .5 - g2.getFontMetrics().stringWidth(this.TITLE) / 2);
  int y = (int)(this.HEIGHT * .001 + g2.getFontMetrics().getHeight());
  //Draw shadow first
  g2.setColor(this.LOGO_SHADOW);
  g2.drawString(this.TITLE, x, y + this.DEPTH);
  g2.drawString(this.TITLE, x + this.DEPTH, y + this.DEPTH);
  g2.drawString(this.TITLE, x + this.DEPTH, y);
  //Draw logo over shadow
  g2.setColor(this.LOGO);
  g2.drawString(this.TITLE, x - 1, y - 1);
  
 }

//=================================================================================================================================================================
//    Listener For Game
//=================================================================================================================================================================

 /**
  * Implements an inner class to the LightsOut game to handle
  * MouseEvents by implementing the MouseListener class. The
  * MouseListener interface handles receiving mouse events on
  * a component (press, release, click, enter, exit). The class 
  * that is interested in processing a mouse event must implement 
  * the MouseListener interface.
  * <p>
  * Most of the time as beginner programmers we want our top level
  * class to implement our listener interfaces because they will
  * have reference to all parts of the program (panels, buttons,
  * text fields, images, etc.) by accessing the getters or those
  * objects created inside of it.
  * <p>
  * Note, for larger programs this is not the best design as many
  * different parts of the program will likely listen to for the
  * same events. Like in a game with the arrow keys doing one thing
  * when you're in the level, and a totally different thing when
  * you're in the main menu.
  *
  */
 private class GameListener implements MouseListener  { 
  /**
   * Invoked when the mouse button has been clicked (pressed
   * and released) on a component.
   *
   * @param e MouseEvent that took place on the component.
   *   Note, a MouseEvent object has multiple properties
   *   that are very useful to invoke, a couple of them
   *   are described below in the comments in which you
   *   will implement.
   */
  public void mouseClicked(MouseEvent e)  {
   
   /************************************************************
    * Correctly determine which mouse button threw the event. *
    * We only care about the left mouse button (info found in *
    * MouseEvent class). If the mouse button was not the left *
    * one then go ahead and exit the method now. Otherwise, *
    * you need to determine the source of the click. Was it *
    * one of the Lights or the reset button. Once the source *
    * is found, correctly invoke the method that performs  *
    * the appropriate task in the GameWindow.     *
    ************************************************************/
      
  }
  
  
  /********************************************************************
   * The following methods are unused methods of the MouseListener *
   * interface. However, by "law" we must implement these methods  *
   * when we enter into the contract of using the MouseListener  *
   * interface. In our Lights Out game, these buttons don't do  *
   * anything, thus we will just leave these methods with empty  *
   * implementations. No different than any other program not using *
   * a key that's on the keyboard.         *
   *                 *
   * NOTE: IF YOU WOULD LIKE TO AFTER YOUR GAME WORKS TO IMPLEMENT *
   *    THESE TO DO SOMETHING IN YOUR GAME FEEL FREE! FOR EXAMPLE, *
   *       PERHAPS MOUSING OVER A LIGHT CHANGES IT'S COLOR.   *
   ********************************************************************/
  
  
  /** Invoked when a mouse button has been pressed down */
  public void mousePressed(MouseEvent e) {}
  /** Invoked when a mouse button has been let up */
  public void mouseReleased(MouseEvent e) {}
  /** Invoked when a mouse hovers over a component */
  public void mouseEntered(MouseEvent e) {}
  /** Invoked when a mouse is moved off of a component */
  public void mouseExited(MouseEvent e) {}
  
 }
}