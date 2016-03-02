package com.lykos.pattern.command;

/**
 * Created by Lykos on 16/3/2.
 */
public class NoCommand implements Command {
    @Override
    public void execute() {
        System.out.println("默认指令调用");
    }

    @Override
    public void undo() {
        System.out.println("撤销默认指令");
    }
}
