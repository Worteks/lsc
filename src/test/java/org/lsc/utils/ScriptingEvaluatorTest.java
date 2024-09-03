package org.lsc.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import mockit.Mocked;
import mockit.NonStrictExpectations;
import org.junit.Before;
import org.junit.Test;
import org.lsc.Task;
import org.lsc.configuration.*;
import org.lsc.exception.LscServiceConfigurationException;
import org.lsc.exception.LscServiceException;
import org.lsc.jndi.SimpleJndiSrcService;

import java.util.*;

public class ScriptingEvaluatorTest {

    @Mocked Task task;

    @Before
    public void setUp() throws LscServiceConfigurationException {
        new NonStrictExpectations() {
            {
                TaskType taskConf = LscConfiguration.getTask("ldap2ldapTestTask");
                task.getSourceService(); result = new SimpleJndiSrcService(taskConf);
            }
        };
    }

    @Test
    public void testString() throws LscServiceException {
        String expression = "gjs:dn='ou=test-user' + ',ou=people,dc=example,dc=com'";
        String stringOutput = ScriptingEvaluator.evalToString(task, expression, new HashMap<>());
        assertEquals("ou=test-user,ou=people,dc=example,dc=com", stringOutput);
    }

    @Test
    public void testBoolean() throws LscServiceException {
        String expression = "gjs:booleanVariable=true";
        boolean booleanOutput = ScriptingEvaluator.evalToBoolean(task, expression, new HashMap<>());
        assertTrue(booleanOutput);
    }

    @Test
    public void testJSPrefix1() throws LscServiceException {
        String expression = "\njs:true";
        boolean booleanOutput = ScriptingEvaluator.evalToBoolean(task, expression, new HashMap<>());
        assertTrue(booleanOutput);
    }

    @Test
    public void testJSPrefix2() throws LscServiceException {
        String expression = "\njs:\ntrue";
        boolean booleanOutput = ScriptingEvaluator.evalToBoolean(task, expression, new HashMap<>());
        assertTrue(booleanOutput);
    }

    @Test
    public void testJSPrefix3() throws LscServiceException {
        String expression = "\njs:test=\"js\"";
        String stringOutput = ScriptingEvaluator.evalToString(task, expression, new HashMap<>());
        assertEquals("js", stringOutput);
    }

    @Test
    public void testJSPrefix4() throws LscServiceException {
        String expression = "\njs:\ntest=\"js\"";
        String stringOutput = ScriptingEvaluator.evalToString(task, expression, new HashMap<>());
        assertEquals("js", stringOutput);
    }

    @Test
    public void testJSPrefix5() throws LscServiceException {
        String expression = "\n\njs:\n\ntest=\"js\"";
        String stringOutput = ScriptingEvaluator.evalToString(task, expression, new HashMap<>());
        assertEquals("js", stringOutput);
    }
}