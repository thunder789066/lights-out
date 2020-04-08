/**
 * @(#)LightGrid.java
 *
 *
 * @author 
 * @version 1.00 2017/2/19
 */

//Swing package GUI components
import javax.swing.JPanel;

//AWT package GUI details
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;

//AWT Listener Events
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


/**
 * Implements a new LightGrid object for the game. A LightGrid
 * is a specialized 2D grid of Lights (JButtons). The LightGrid's
 * responsibilities are to instantiate each Light with a starting
 * state, organize them into a GridLayout, and once a Light has
 * been clicked determine which of the Lights it was.
 * <p>
 * Once the Light that was clicked is found, the LightGrid should
 * handle finding all adjacent Lights and toggling each of them
 * on/off, and count the number of lights that are still on each
 * turn.
 * <p>
 * LightGrid extends a JPanel in order to implement all of the
 * properties of a simple container object including the Layout
 * features so a GridLayout can be created to organize the Lights.
 *
 */
public class LightGrid extends JPanel {
 
 /** Size of square grid as percent of height of the GameWindow */
 public static final int SIZE = (int)(GameWindow.HEIGHT * .8);

 /** Number of cells in a row/column of the grid (Lights Out is a 5x5 grid) */
 public static final int CELLS = 5;
 
 /** Underlying 2D array for grid of lights */
 private Light[][] grid;
 
 /** Game Listener passed from the top level JFrame */
 private MouseListener gameListener;
 
 /** 
  * Counter for number of lights that are currently on. Player
  * wins the game once all lights are off (i.e. counter == 0)
  */
 private int lightCounter;
 
 
 /**
  * Creates a new LightGrid object and assigns the specified
  * MouseListener passed from the top level JFrame to the
  * gameListener field for use with the Lights in the game.
  * <p>
  * The default implementation should establish the listener
  * field, set the size to that specified above, set the
  * layout to a GridLayout with the correct number of cells,
  * instantiate the underlying 2D array to hold the Lights,
  * and finally invoke the process for initializing those
  * Lights in the grid.
  *
  */
 public LightGrid(MouseListener listener) {
  /************************************************
   * Correctly assign the listener, set the size *
   * of the LightGrid, assign a GridLayout with *
   * the correct number of rows/columns, create *
   * the underlying 2D array, and correctly   *
   * invoke the initialization of the individual *
   * lights.          *
   ************************************************/
  this.gameListener = listener;
  this.initializeLights();
 }
 
 /**
  * Correctly instantiates a Light object for each spot
  * in the grid with a 50% chance for that light to start
  * in the ON state. If a Light gets switced to ON, be
  * sure to correctly incriment the light counter. Each
  * light needs to be instantiated, on/off state determined,
  * added to the grid in the proper location, assigned the
  * mouse listener passed from the top level JFrame, and 
  * finally (which is the easiest to forget) it must be added
  * to 'this' LightGrid (JPanel) itself. 
  * <p>
  * Very common to confuse that adding of the Light to the
  * 2D array and adding it to the JPanel as the same thing.
  * IT IS NOT! If you want something to show up inside of
  * a container, you must add it straight to the container
  * itself. Once added, the layout specifications determine 
  * where exactly the component will be placed or if no layout
  * exists (switced to null) then the set bounds method must
  * be invoked to determine where exactly the component should
  * go (we did this at the top level JFrame).
  *
  *
  */
private void initializeLights() {
  /****************************************************
   * Correctly create a Light for each spot in the *
   * grid, toggle the light on with a 50% chance,  *
   * assign the listener from the top level JFrame to *
   * each Light, and count the total number of Lights *
   * that are switched on        * 
   ****************************************************/
   this.grid = new Light[this.CELLS][this.CELLS];
   for (int i = 0; i < this.grid.length; i++) {
     for (int j = 0; j < this.grid[i].length; j++) {
       this.grid[i][j] = new Light();
       this.add(this.grid[i][j]);
       this.grid[i][j].addMouseListener(this.gameListener);
       if (Math.random() < .5) {
         this.grid[i][j].toggle();
         this.lightCounter++;
       }
     }
   }
 }
 
 /**
  * Invoked by top level JFrame class when it is determined
  * a left mouse click has occurred on one of the Lights in
  * the grid. This method must correctly find the source of
  * the mouse click (which Light was clicked) by invoking
  * the correct information from the passed MouseEvent.
  * <p>
  * Once the Light source is found, this method should pass
  * the required information for which Light was clicked to
  * the method that handles toggling the Light and all of
  * the adjacent lights.
  * <p>
  * Once this process is complete, it is here we will invoke
  * the repaint method for the JPanel in order for the 
  * screen to update the changes, then for efficiency exit
  * the method before the loop finishes.
  *
  * @param e MouseEvent that occured in the game passed
  *   from the top level JFrame class when it is
  *   determined the event was triggered by a left
  *   mouse click on one of the lights in the grid.
  *
  *
  */
 public void onLeftClick(MouseEvent e) {
  /********************************************
   * Correctly determine which Light was the *
   * source of the click, then correctly use *
   * that information to toggle the Light and *
   * all adjacent lights. Then, invoke the *
   * repaint and exit the method early.  *
   ********************************************/
   //DO NOT OVERRIDE REPAINT -> IT WILL JACK/MESS WITH YOUR CODE
//   for(every light on LightGrid/check column & row on 5x5 grid) {
//     search for the light that was clicked;
//     toggleAdjacentLights();
//     repaint();
//   }
 }
 
 /**
  * Uses the specified corrdinates to correctly toggle
  * the given light and each adjacent light. A Light is
  * adjacent to another if it is directly above/below
  * or to the side of the first Light. Diagonals are
  * NOT adjacent.
  *
  * @param r Row number of the Light that was
  *   determined to be clicked
  *
  * @param c Column number of the Light that was
  *   determined to be clicked
  *
  *
  */
 public void toggleAdjacentLights(int r, int c) {
  /********************************************
   * Correctly toggle the Light at the given *
   * location and all adjacent lights while *
   * also tracking the total number of lights *
   * that are on with the counter.   *
   ********************************************/
   //USE 2 FOR-LOOPS - FOR-LOOP WITHIN FOR-LOOP
   //THE 1st  FOR-LOOP CHECKS/SEARCHES FOR THE LIGHT CLICKED( onLeftClick() )
   //change state of tile touching the tile clicked
   //if (tile clicked is out-of-bounds/(Out-Of-Bound Exception)) {
     //change only the tiles within the bounds
     //Light.toggle();
   //}
 }
 
 /**
  * Resets the light grid by switching each light off
  * and correctly randomizing which lights are on with
  * a 50% chance and correctly updates the light counter.
  *
  */
 public void reset() {
  /********************************************************
   * Reset the counter and each Light in the grid with *
   * a 50% chance of being switched on, and keep track of *
   * total number switched on.       *
   ********************************************************/
  this.initializeLights();
 }
 
 /**
  * Return current number of lights that are on
  *
  * @return Total number of lights that remain
  *   on inside the grid.
  *
  */
 public int getNumberOfLightsOn() {
   return this.lightCounter;
 }
 
}