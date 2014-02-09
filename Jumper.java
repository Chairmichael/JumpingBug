import info.gridworld.actor.Actor;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import java.awt.Color;

/**
 * The Jumper bug moves forward two spaces when it moves. It can move over rocks and flowers directly in front of it. It does not leave anything behind when it jumps.
 * 
 * @author Dan Leonard
 * @author Jefferson Henry
 * @author Matt Kramer
 * @author Jason Hanselman
 * 
 * @version 1.0.0
 */

public class Jumper extends Actor
{
    /**
     * A bug that will jump.
     */
    public Jumper()
    {
        setColor(Color.RED);
    }
    
    /**
     * A bug that will jump with a given color.
     * @param color the color for this Bug
     */
    public Jumper(Color color)
    {
        setColor(color);
    }
    
    /**
     * Makes the bug act. If it can jump, it jumps. If not, it turns.
     */
    public void act()
    {
        if (canJump())
            jump();
        else
            turn();
    }
    
    /**
     * Turns the Jumper half a right turn.
     */
    public void turn()
    {
        setDirection(getDirection() + Location.HALF_RIGHT);
    }
    
    /**
     * Moves the Jumper foward twice.
     */
    public void jump()
    {
        Grid<Actor> grid = getGrid();
        Location currentLoc = getLocation();
        Location oneNext = currentLoc.getAdjacentLocation(getDirection());
        Location twoNext = oneNext.getAdjacentLocation(getDirection());
        
        if (grid.isValid(twoNext))
            moveTo(twoNext);
        else
            turn();
    }
    
    /**
     * Tests if the Jumper can move forward two spots.
     */
    public boolean canJump()
    {
        Grid<Actor> grid = getGrid();
        Location currentLoc = getLocation();
        Location oneNext = currentLoc.getAdjacentLocation(getDirection());
        Location twoNext = oneNext.getAdjacentLocation(getDirection());
        
        if (!grid.isValid(oneNext))
            return false;
        if (!grid.isValid(twoNext))
            return false;
        if (grid.get(twoNext) instanceof Flower)
            return false;
        return true;
    }
}
