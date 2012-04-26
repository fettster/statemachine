package org.wintrisstech.erik.iaroc;

import android.os.SystemClock;
import ioio.lib.api.IOIO;
import ioio.lib.api.exception.ConnectionLostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.wintrisstech.irobot.ioio.IRobotCreateInterface;

public class MyRobot extends Ferrari
{
    private int[][] stateTable =
    {
        {
            0, 2, 1, 3
        },
        {
            1, 2, 1, 3
        },
        {
            2, 2, 1, 3
        },
        {
            3, 2, 1, 3
        }
            
    };
    private int presentState = 0;
    private int statePointer = 0;
   
    

    MyRobot(IOIO ioio, IRobotCreateInterface iRobotCreate, Dashboard dashboard) throws ConnectionLostException
    {
        super(ioio, iRobotCreate, dashboard);
    }

    /*
     * THE FUN STARTS HERE!
     */
    public void goRobot()
    {
        try
        {
            driveDirect(100, 100);
            stateControler();
        } catch (Exception ex)
        {
            Logger.getLogger(MyRobot.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void stateControler() throws Exception
    {
        while (true)
        {
            switch(stateTable[presentState][statePointer])
        {
            case 0: //case A, not bumped
                presentState = 0;
                break;
            case 1: //case B, right bumped
                presentState = 1;
                bumpReaction("right");
                break;
            case 2: //case C, left bumped
                presentState = 0;
                bumpReaction("left");
                break;
            case 3: //case D, bump bolth
                presentState = 0;
                bumpReaction("both");
                break;
                
        }
        }
    }
   public void bumpReaction(String bumpDirection) throws Exception
   {
       if (bumpDirection.equals("right"))
       {
           driveDirect(-100, -200);
       }
       if (bumpDirection.equals("left"))
       {
           driveDirect(-200, -100);
       }
       if (bumpDirection.equals("both"))
       {
           driveDirect(-100, -100);
       }
       SystemClock.sleep(2000);
       driveDirect(100, 100);
       statePointer = 0;
       presentState = 0;
   }
   public void checkSensors() throws Exception
   {
       readSensors(SENSORS_GROUP_ID6);
       if ( isBumpRight() && isBumpLeft())
       {
           statePointer = 3;    
       }
       if (!isBumpRight() && !isBumpLeft())
       {
           statePointer = 0;    
       }
       if ( isBumpRight() && !isBumpLeft())
       {
           statePointer = 1;    
       }
       if ( !isBumpRight() && isBumpLeft())
       {
           statePointer = 2;    
       }
   }
           
    
    
}
