package GridWorld_Classes;

import info.gridworld.actor.Bug;

public class DancingBug extends Bug
{
    private int[] danceArray;
    private int currentTurn;

    /**
     * Constructs a box bug that traces a square of a given side length
     * @param length the side length
     */
    public DancingBug(int[] danceArray)
    {
        this.danceArray = danceArray;
        currentTurn = 0;
    }

    /**
     * Moves to the next location of the square.
     */
    public void act()
    {
        if (currentTurn != danceArray.length)
        {
            setDirection(danceArray[currentTurn]);
            currentTurn++;
            return;
        }
        else if (currentTurn == danceArray.length)
        {
            if (canMove())
            {
                move();
                currentTurn = 0;
                return;
            }
            else
            {
                turn();
                return;
            }
        }
    }
}
