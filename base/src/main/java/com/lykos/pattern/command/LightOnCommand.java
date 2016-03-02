package com.lykos.pattern.command;

/**
 * 打开电灯命令
 * Created by Lykos on 16/3/2.
 */
public class LightOnCommand implements Command {
    Light light;
    public LightOnCommand(Light light){
        this.light = light;
    }
    @Override
    public void execute() {
        light.on();
    }

    @Override
    public void undo() {
        light.off();
    }
}
