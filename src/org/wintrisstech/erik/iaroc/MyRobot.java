package org.wintrisstech.erik.iaroc;

import android.os.SystemClock;
import ioio.lib.api.IOIO;
import ioio.lib.api.exception.ConnectionLostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.wintrisstech.irobot.ioio.IRobotCreateInterface;

public class MyRobot extends Ferrari
{
    int cState = STRAIGHT;
    int vectorState = 0;
    static final int STRAIGHT = 0;
    static final int LEFT = 1;
    static final int RIGHT = 2;
    static final int CENTER = 3;
    static int r2d2[][] =
    {
        {
            STRAIGHT, LEFT, RIGHT, CENTER
        },
        {
            STRAIGHT, LEFT, RIGHT, CENTER
        },
        {
            STRAIGHT, LEFT, RIGHT, CENTER
        },
        {
            STRAIGHT, LEFT, RIGHT, CENTER
        }
    };

    MyRobot(IOIO ioio, IRobotCreateInterface iRobotCreate, Dashboard dashboard) throws ConnectionLostException
    {
        super(ioio, iRobotCreate, dashboard);
    }

    /*
     * THE FUN STARTS HERE!
     */
    public void goRobot()
    {
        switch (r2d2[vectorState][cState])
        {
            case STRAIGHT: //_(iodejvomrdbifgv,clf
                break;
            case LEFT: //_(iodejvomrdbifgv,clf
                break;
            case RIGHT: //_(iodejvomrdbifgv,clf
                break;
            case CENTER: //_(iodejvomrdbifgv,clf
                break;

        }
    }
}
