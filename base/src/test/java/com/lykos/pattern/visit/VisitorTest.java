package com.lykos.pattern.visit;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Lykos on 16/3/7.
 */
public class VisitorTest {

    @Test
    public void testVistor(){
        IElement appleElement = new AppleElement("this is an apple");
        IElement bananaElement = new BananaElement("this is a banana");
        Collection elements = new ArrayList<>();
        elements.add(appleElement);
        elements.add(bananaElement);
        FruitVisitor visitor = new FruitVisitor();
        visitor.visitCollection(elements);
    }

}