package com.lykos.pattern.command;

/**
 * 简单遥控器
 * Created by Lykos on 16/3/2.
 */
public class SimpleRemoteControl {

    Command slot;

    public void setCommand(Command command){
        slot = command;
    }

    public void buttonWasPressed(){
        slot.execute();
    }

}
