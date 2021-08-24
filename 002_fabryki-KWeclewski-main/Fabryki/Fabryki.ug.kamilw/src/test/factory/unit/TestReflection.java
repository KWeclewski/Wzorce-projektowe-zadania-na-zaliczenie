package factory.unit;

import factories.register.ReflectionSizeFactory;
import model.Size.Box;
import model.Size.ISize;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class TestReflection {
    @Test(expected = IllegalStateException.class)
    public void getNotExistingSize(){
        ReflectionSizeFactory.getSize("WhatTheHell");
    }

    @Test(expected = IllegalStateException.class)
    public void tryToaddNewClass(){
        ReflectionSizeFactory.getSize("box");

        ReflectionSizeFactory.registerSize("box", Box.class);

        ISize box = ReflectionSizeFactory.getSize("box");
        assertThat(box, instanceOf(Box.class));
        assertEquals("Box", box.getSize());
    }

    @Test
    public void tryToGetSizes(){
        ISize small = ReflectionSizeFactory.getSize("small");
        ISize medium = ReflectionSizeFactory.getSize("medium");
        ISize large = ReflectionSizeFactory.getSize("large");
        ISize mega = ReflectionSizeFactory.getSize("mega");

        assertEquals("Small",small.getSize());
        assertEquals("Medium",medium.getSize());
        assertEquals("Mega",mega.getSize());
        assertEquals("Large",large.getSize());
    }
}
