package com.lykos.pattern.visit;

import java.util.Collection;

/**
 *
 * 访问者接口
 * Created by Lykos on 16/3/7.
 */
public interface IVisitor {

    void visitApple(AppleElement appleElement);

    void visitBanana(BananaElement bananaElement);

    void visitCollection(Collection<IElement> collection);
}
