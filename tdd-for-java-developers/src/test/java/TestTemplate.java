import com.model.Template;
import org.junit.Before;
import org.junit.Test;

import com.exception.MissingValueException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;


public class TestTemplate {

    private Template template;

    @Before
    public void setup() {
        template = new Template("${one}, ${two}, ${three}");
        template.set("one", "1");
        template.set("two", "2");
        template.set("three", "3");
    }

    @Test
    public void oneVariable() throws Exception {
        Template template = new Template("Hello, ${name}");
        template.set("name", "Reader");

        assertEquals("Hello, Reader", template.evaluate());
    }

    @Test
    public void differentValue() throws Exception {
        Template template = new Template("Hi, ${name}");
        template.set("name", "Someone Else");
        assertEquals("Hi, Someone Else", template.evaluate());
    }

    @Test
    public void multipleVariables() throws Exception {
        assertEquals("1, 2, 3", template.evaluate());
    }

    @Test
    public void unknownVariablesAreIgnored() throws Exception {
        template.set("doesnotexist", "Hi");

        assertTemplateEvaluateTo("1, 2, 3");
    }

    @Test
    public void missingValueRaisesException() throws Exception {
        try {
            new Template("${foo}").evaluate();
            fail("evaluate() shoud throw an exception if "
                    + "a variable was left without a value!");
        }catch (MissingValueException expected){
            assertEquals("No value for ${foo}", expected.getMessage());
        }
    }

    private void assertTemplateEvaluateTo(String expected) {
        assertEquals(expected, template.evaluate());
    }
}