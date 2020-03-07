package com.model;

import com.model.Template;
import org.junit.Before;
import org.junit.Test;

public class TestTemplatePerformance {
    Template template;

    @Before
    public void setup(){
        template = new Template("");
    }

    @Test
    public void templateWith100WOrdsAnd20Variables()throws Exception{
        long expected = 200L;
        long time = System.currentTimeMillis();
        template.evaluate();

    }

}
