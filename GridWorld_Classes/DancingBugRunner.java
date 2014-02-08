package GridWorld_Classes;

import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;

import java.awt.Color;

/**
 * This class runs a world that contains box bugs. <br />
 * This class is not tested on the AP CS A and AB exams.
 */
public class DancingBugRunner
{
    public static void main(String[] args)
    {
        int[] dance1;
        int[] dance2;
        
        dance1 = new int[4];
        dance1[0] = 90;
        dance1[1] = 135;
        dance1[2] = 45;
        dance1[3] = 315;
        
        dance2 = new int[5];
        dance2[0] = 270;
        dance2[1] = 225;
        dance2[2] = 180;
        dance2[3] = 0;
        dance2[4] = 135;
        
        ActorWorld world = new ActorWorld();
        DancingBug alice = new DancingBug(dance1);
        alice.setColor(Color.ORANGE);
        DancingBug bob = new DancingBug(dance2);
        world.add(new Location(7, 8), alice);
        world.add(new Location(5, 5), bob);
        world.show();
    }
}