import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StackTest {

    Stack stack;

    @Test
    public void SampleTest() {
        stack = new Stack<>(Object.class);
        for (int i = 0; i < 9; i++) {
            stack.push(i);
            stack.push((char)('a' + i));
        }
        assertEquals('i',stack.pop());
        assertEquals(8,stack.peek());
        assertEquals(17,stack.size());
    }

    @Test
    public void IntTest() {
        Stack<Object> stack = new Stack<>(Object.class);
        for (int i = 0; i < 5; i++){
            stack.push(i);
        }
        assertEquals(4,stack.pop());
        assertEquals(3,stack.peek());
    }

    @Test
    public void StringTest(){
        Stack<Object> stack = new Stack<>(Object.class);
        for (int i = 0; i < 5; i++){
            stack.push("" + i);
        }
        assertEquals("4",stack.pop());
        assertEquals("3",stack.peek());
    }

    @Test
    public void popWithDifferTypes() {
        Stack<Object> stack = new Stack<>(Object.class);
        stack.push(1);
        stack.push("2");
        stack.push(3.14);
        stack.push("Template");
        while (stack.size() > 0) {
            assertEquals(stack.peek(),stack.pop());
        }
        assertEquals(0,stack.size());
    }

    @Test
    public void reverseStackTest() {
        stack = new Stack<>(Object.class);
        for (int i = 0; i < 9; i++){
            stack.push2(i);
        }
        assertEquals(8,stack.pop2());
    }

    @Test
    public void BracketsCheck() {
        String s = "(()((())()))";
        assertEquals(true,Stack.checkBrackets(s));
        s = ")))(((";
        assertEquals(false,Stack.checkBrackets(s));
        s = "())(";
        assertEquals(false,Stack.checkBrackets(s));
        s = "((()()()))";
        assertEquals(true,Stack.checkBrackets(s));
        s = "((())";
        assertEquals(false,Stack.checkBrackets(s));
        s = "(()()(()";
        assertEquals(false,Stack.checkBrackets(s));
        s = ")";
        assertEquals(false,Stack.checkBrackets(s));
        s = "(((((()))))";
        assertEquals(false,Stack.checkBrackets(s));
    }

    @Test
    public void postFixTets() {
        String s = "12+3*";
        assertEquals(9,Stack.postFix(s));
        s = "82+5*9+=";
        assertEquals(59,Stack.postFix(s));
    }

}
