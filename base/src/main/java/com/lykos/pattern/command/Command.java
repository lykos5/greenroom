package com.lykos.pattern.command;

/**
 *
 * 命令接口
 * Created by Lykos on 16/3/2.
 */
public interface Command {
    public void execute();
    public void undo();
}
