package org.wintrisstech.erik.iaroc;

import ioio.lib.api.IOIO;
import ioio.lib.api.exception.ConnectionLostException;
import org.wintrisstech.irobot.ioio.IRobotCreateInterface;


public class MyRobot extends Ferrari 
{

    MyRobot(IOIO ioio, IRobotCreateInterface iRobotCreate, Dashboard dashboard) throws ConnectionLostException
    {
        super(ioio, iRobotCreate, dashboard);
    }

    public void goRobot()
    {
        dashboard.log("hello from My Robot");
    }
    
}
