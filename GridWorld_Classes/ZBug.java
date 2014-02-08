package GridWorld_Classes;

import info.gridworld.actor.Bug;

/**
 * A <code>BoxBug</code> traces out a square "box" of a given size. <br />
 * The implementation of this class is testable on the AP CS A and AB exams.
 */
public class ZBug extends Bug
{
    private int steps;
    private int length;
    private int section;

    /**
     * Constructs a box bug that traces a square of a given side length
     * @param length the side length
     */
    public ZBug(int length)
    {
        steps = 0;
        section = 1;
        this.length = length;
        setDirection(90);
    }

    /**
     * Moves to the next location of the square.
     */
    public void act()
    {
        if (steps < length && canMove())
        {
            move();
            steps++;
            return;
        }
        else if (steps == length && section == 2)
        {
            setDirection(90);
            steps = 0;
            section++;
            return;
        }
        else if (steps == length && section == 1)
        {
            setDirection(225);
            steps = 0;
            section++;
            return;
        }
    }
}
