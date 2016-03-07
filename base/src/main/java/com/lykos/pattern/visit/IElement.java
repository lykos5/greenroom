package com.lykos.pattern.visit;

/**
 *
 * 被访问者接口
 * Created by Lykos on 16/3/7.
 */
public interface IElement {
    void accept(IVisitor visitor);
}
