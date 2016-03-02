package com.lykos.pattern.command;

/**
 * Created by Lykos on 16/3/2.
 */
public class RemoteControl {
    int size = 7;
    Command [] onCommands;
    Command [] offCommands;
    Command undoCommand;//记录上一次执行的命令,方便后面撤销调用
    public RemoteControl(){
        onCommands = new Command[size];
        offCommands = new Command[size];
        NoCommand noCommand = new NoCommand();
        for(int i=0;i<size;i++){
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
        }
        undoCommand = noCommand;
    }

    public void setCommand(int slot,Command onCommand,Command offCommand){
        onCommands[slot] = onCommand;
        offCommands[slot] = offCommand;
    }

    public void onButtonWasPressed(int slot){
        onCommands[slot].execute();
        undoCommand = onCommands[slot];
    }

    public void offButtonWasPressed(int slot){
        offCommands[slot].execute();
        undoCommand = offCommands[slot];
    }

    public void undoButtonWasPressed(){
        undoCommand.undo();
    }

    @Override
    public String toString(){
        StringBuffer sb = new StringBuffer();
        sb.append("----------------Remote Control------------------\n");
        for(int i=0;i<size;i++){
            sb.append("[slot="+i+"]"+onCommands[i].getClass().getSimpleName()+"-----"+
            offCommands[i].getClass().getSimpleName()+"\n");
        }
        return sb.toString();
    }
}
