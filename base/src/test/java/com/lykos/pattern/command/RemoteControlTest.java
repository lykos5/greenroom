package com.lykos.pattern.command;

import org.junit.Test;

/**
 * Created by Lykos on 16/3/2.
 */
public class RemoteControlTest {

    @Test
    public void testSimpleRemoteControl(){
        SimpleRemoteControl remote = new SimpleRemoteControl();
        Light light = new Light();
        LightOnCommand lightOnCommand = new LightOnCommand(light);
        remote.setCommand(lightOnCommand);
        remote.buttonWasPressed();
        ///////////////////////////
        GarageDoor garageDoor = new GarageDoor();
        GarageDoorOpenCommand garageDoorOpenCommand = new GarageDoorOpenCommand(garageDoor);
        remote.setCommand(garageDoorOpenCommand);
        remote.buttonWasPressed();
    }

}