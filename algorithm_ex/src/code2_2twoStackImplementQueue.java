import java.util.Stack;

public class code2_2twoStackImplementQueue {
    public static class TwoStacksQueue {
        private Stack<Integer> pushStack;
        private Stack<Integer> popStack;

        public TwoStacksQueue() {
            pushStack=new Stack<Integer>();
            popStack=new Stack<Integer>();
        }

//        // push栈向pop栈倒入数据
//        private void pushToPop() {
//            if (stackPop.empty()) {
//                while (!stackPush.empty()) {
//                    stackPop.push(stackPush.pop());
//                }
//            }
//        }
//
//        public void add(int pushInt) {
//            stackPush.push(pushInt);
//            pushToPop();
//        }
//
//        public int poll() {
//            if (stackPop.empty() && stackPush.empty()) {
//                throw new RuntimeException("Queue is empty!");
//            }
//            pushToPop();
//            return stackPop.pop();
//        }
//
//        public int peek() {
//            if (stackPop.empty() && stackPush.empty()) {
//                throw new RuntimeException("Queue is empty!");
//            }
//            pushToPop();
//            return stackPop.peek();
//        }
        public void add(Integer data){//先进入pushStack
            pushStack.push(data);
        }
        public Integer poll(){
            //倒入popStack后，把popStack的弹出以后，再全部倒回pushStack，以便后续操作
            transfer(pushStack, popStack);
            Integer data=null;
            if(!popStack.empty()){
                data=popStack.pop();
            }
            transfer(popStack, pushStack);
            return data;
        }
        public static void transfer(Stack<Integer> stack1, Stack<Integer> stack2){
            //把stack1的东西全部倒入stack2中
            Integer tmp;
            while(!stack1.empty()){
                tmp = stack1.pop();
                stack2.push(tmp);
            }
        }
        //存在的问题：没有写peek
        public Integer peek(){
            transfer(pushStack,popStack);
            Integer data=null;
            if(!popStack.empty()){
                data=popStack.peek();
            }
            transfer(popStack,pushStack);
            return data;
        }
    }

    public static void main(String[] args) {
        TwoStacksQueue test = new TwoStacksQueue();
        test.add(1);
        test.add(2);
        test.add(3);
        System.out.println(test.peek());
        System.out.println(test.poll());
        System.out.println(test.peek());
        System.out.println(test.poll());
        System.out.println(test.peek());
        System.out.println(test.poll());
    }

}