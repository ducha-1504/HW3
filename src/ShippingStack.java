public class ShippingStack {
    public final int Capacity = 100;
    private Order[] stack;
    private int top;

    public ShippingStack() {
        top = -1;
        stack = new Order[Capacity];
    }
    public boolean isEmpty() {
        return (top == -1);
    }
    public void ensureCapacity(int minCapacity) {
        Order[] temp;
        if (stack.length < minCapacity) {
            temp = new Order[minCapacity];
            System.arraycopy(stack, 0, temp, 0, stack.length);
            stack = temp;
        }
    }
    public void push(Order o) {
        if (top == Capacity - 1) {
            ensureCapacity(Capacity*2 + 1);
        }
        stack[++top] = o;
    }
    public String pop() {
        if (top == -1) {
            System.out.println("Stack is empty");
            return null;
        }
        String answer = stack[top].toString();
        top--;
        return answer;
    }
    public Order peek() {
        if (top == -1) {
            System.out.println("Stack is empty");
        }
        return stack[top];
    }
    public int length(){
        return top + 1;
    }
    public void printStack(){
        int m = 1;
        if (isEmpty()){
            System.out.println("Stack is empty");
            return;
        }
        for(int i = top; i >= 0; i--){
            System.out.println(m + ". " + stack[i].toString());
            m++;
        }
    }
}
