package com.lykos.pattern.visit;

import java.util.Collection;
import java.util.Iterator;

/**
 * Created by Lykos on 16/3/7.
 */
public class FruitVisitor implements IVisitor {
    @Override
    public void visitApple(AppleElement appleElement) {
        System.out.println("appleElement---->"+appleElement.getMes());
    }

    @Override
    public void visitBanana(BananaElement bananaElement) {
        System.out.println("BananaElement------>"+bananaElement.getMes());
    }

    @Override
    public void visitCollection(Collection<IElement> collection) {
        Iterator<IElement> elements = collection.iterator();
        while (elements.hasNext()){
            elements.next().accept(this);
        }
    }

}
