package BAEKJOON.Baisc1;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        System.out.println(str);

        System.out.println(str.charAt(0));
        System.out.println(str.charAt(1));
        System.out.println(str.charAt(2));
        System.out.println(str.charAt(3));
        System.out.println(str.charAt(4));


        }

}

/* 17087 숨바꼭질 6 */
/*public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int s = sc.nextInt();

        for(int i=0; i<n; ++i)
            arr[i] = Math.abs(s-sc.nextInt());

        int gcd = arr[0];

        for(int i=1; i<arr.length; ++i) {
            gcd = GCD(gcd, arr[i]);
        }
        System.out.println(gcd);
    }

    public static int GCD(int i, int j){
        if(j == 0)
            return i;
        else
            return GCD(j, i%j);
    }
}*/
/* 9613 GCC합 */
/*public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i=0; i<n; ++i)
                arr[i] = sc.nextInt();

            for(int i : arr)
                System.out.println(i);

            long sum = 0;
            for(int i=0; i<arr.length; ++i)
                for(int j=i+1; j<arr.length; ++j) {
                    sum += GCD(arr[i], arr[j]);
                    System.out.print("arr[i] : "+arr[i]+
                            " arr[j] : "+arr[j] + " sum : "+sum);
                    System.out.println();
                }
            System.out.println(sum);
        }
    }
    public static int GCD(int i, int j){
        if(j == 0)
            return i;
        else
            return GCD(j, i%j);
    }
}*/
/* 6588 골드바흐의 추측 */
/*public class Main {
    public static void main(String[] args) {

        boolean[] check = new boolean[1000001];
        // true : 소수x
        // false : 소수
        
        for(int i=2; i<Math.sqrt(check.length); ++i){
            if(!check[i])
                for(int j=i+i; j<check.length; j = j+i)
                    check[j] = true;
        }

        Scanner sc = new Scanner(System.in);

        while(true) {

            int n = sc.nextInt();

            if(n == 0)
                break;

            for (int i = 2; i < n - 1; ++i) {
                if (!check[n - i] && !check[i]) {
                    System.out.println(n + " = " + i + " + " + (n-i));
                    break;
                }
            }
        }
    }
}*/
/* 1934 최소공배수 */
/*public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        while(n-->0){
            int i= sc.nextInt();
            int j= sc.nextInt();
            System.out.println(i * j / GCD(i,j));
        }
    }
    public static int GCD(int i, int j){
        if(j==0)
            return i;
        else
            return GCD(j, i%j);
    }
}*/
/*2609 최대공약수와 최소공배수 (유클리드 호제법)*/
/*public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int m = GCD1(a,b);
        System.out.println(m);
        System.out.println(a*b/m);
    }

    // 재귀 버전
    public static int GCD1(int i, int j) {
        if(j==0)
            return i;
        else{
            return GCD1(j, i%j);
        }
    }
    // 반복문 버전
    public static int GCD2(int i, int j){
        if(i == 1 || j == 1)
            return 1;
        int a = i;
        int b = j;
        while(b != 0){
            int c = a % b;
            a = b;
            b = c;
        }
        return a;
    }
}*/
/* 11626 접미사 배열 */
/*public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        String strs[] = new String[input.length()];

        for(int i=0; i<input.length();++i){
            strs[i] = input.substring(i);
        }
        Arrays.sort(strs);

        for(String s : strs)
            System.out.println(s);
    }
}*/
/* 10824 네 수 */
/*public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long n1 = sc.nextInt();
        long n2 = sc.nextInt();
        long n3 = sc.nextInt();
        long n4 = sc.nextInt();

        String str1 = ""+n1+n2;
        String str2 = ""+n3+n4;

        System.out.println(Long.parseLong(str1.toString()) + Long.parseLong(str2.toString()));

    }
}*/
/* 2743 단어 길이 재기 */
/*public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        System.out.println(str.length());

    }
}*/
/* 10808 알파벳 개수 */
/*public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        int[] answer = new int[26];

        for(char c : str.toCharArray()){
            answer[c-'a']++;
        }

        for(int i:answer)
            System.out.print(i+" ");
    }
}*/
/* 1918 후위표기식 (맑은 정신으로 다시 풀어보자) */
/*public class Main {
    public static void main(String[] args) {

    }
}*/
/* 1935 후의표기식2 */
/*public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Double> stack = new Stack<>();

        int n = Integer.parseInt(sc.nextLine());
        String input = sc.nextLine();

        HashMap<Character, Integer> map = new HashMap<>();
        char ch = 'A';
        for(int i=0; i<n; ++i)
            map.put(ch++, sc.nextInt());

        for(int i=0; i<input.length(); ++i){
            ch = input.charAt(i);
            
            if(Character.isAlphabetic(ch))       // 알파벳인 경우
                stack.push((double)map.get(ch));    // 알파벳(key)의 정수(value)를 꺼내 스택에 push
            else {                       // 알파벳이 아닌 경우
                double right = stack.pop();
                double left = stack.pop();
                switch (ch) {
                    case '+':
                        stack.push(left + right); break;
                    case '-':
                        stack.push(left - right); break;
                    case '*':
                        stack.push(left * right); break;
                    case '/':
                        stack.push(left / right); break;
                    case '%':
                        stack.push(left % right); break;
                }
            }
        }
        System.out.printf("%.2f", stack.pop());
    }
}*/
/* 10799 쇠막대기 */
/*public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Character> stack = new Stack<>();
        String input = sc.next();
        int result = 0;

        char tmp = 'c';
        for(char c : input.toCharArray()){
            if(c == '('){           // c가 ( 일때
                stack.push(c);
            }
            else{                   // c가 ) 일때
                if(tmp == '('){     // () 레이저로 지이잉
                    stack.pop();
                    result += stack.size();
                }
                else{               // )) 하나만 떨구기
                    stack.pop();
                    result += 1;
                }
            }
            tmp = c;
        }

        System.out.println(result);
    }
}*/
/* 17413 단어 뒤집기2 */
/*public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean inTag = false;
        Stack<Character> charStack = new Stack<>();
        StringBuilder answer = new StringBuilder();

        String input = sc.nextLine();

        for(char c : input.toCharArray()){
            if(c == '<'){
                if(!charStack.isEmpty()){
                    while(!charStack.isEmpty())
                        answer.append(charStack.pop());
                }
                inTag = true;
                answer.append(c);

            }
            else if(c == '>'){
                inTag = false;
                answer.append(c);
            }
            else{   //
                if(inTag) // 태그 안에 있는 문자 처리
                    answer.append(c);
                else{   // 태그 밖에 있는 문자 처리 (거꾸로)
                    if(c == ' '){    // 띄어쓰기 만남, charStack 모두 pop해서 answer로
                        while(!charStack.isEmpty())
                            answer.append(charStack.pop());
                        answer.append(' ');
                    }
                    else{   // 띄어쓰기가 아님,
                        charStack.push(c);
                    }
                }
            }
        }
        // charStack에 남아있는 문자를 answer에 추가
        while(!charStack.isEmpty())
            answer.append(charStack.pop());

        System.out.println(answer);
    }
}*/
/* 1158 요세푸스 문제 */
/*public class Main {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> answer = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        for(int i=1; i<=n; ++i)
            q.offer(i);

        while(!q.isEmpty())
        {
            for(int i=0; i<k-1; ++i){
                q.offer(q.poll());
            }
            answer.add(q.poll());
        }

        System.out.print('<');
        for(int i=0; i< answer.size()-1; ++i)
            System.out.print(answer.get(i)+", ");
        System.out.print(answer.get(answer.size()-1));
        System.out.print('>');
    }
}*/
/* 10845 큐 */
/*public class Main {
    public static void main(String[] args) {
        Queue q = new Queue(10000);
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();


        while(n-->0){
            String str = sc.next();

            switch (str){
                case "push":
                    q.push(sc.nextInt()); break;
                case "pop":
                    sb.append(q.pop()).append('\n'); break;
                case "front":
                    sb.append(q.front()).append('\n'); break;
                case "size":
                    sb.append(q.size()).append('\n'); break;
                case "empty":
                    sb.append(q.isEmpty()).append('\n'); break;
                case "back":
                    sb.append(q.back()).append('\n'); break;
            }
        }
        System.out.println(sb);

    }

    public static class Queue{
        int front;
        int rear;
        int[] queue;

        public Queue(int capacity){
            this.front = 0;
            this.rear = 0;
            this.queue = new int[capacity];
        }

        public void push(int n){
            if(rear!=queue.length-1)
                queue[++rear] = n;
        }

        public int pop(){
            if(front==rear)
                return -1;
            else
                return queue[++front];
        }

        public int size(){
            return rear - front;
        }

        public int isEmpty(){
            if(rear == front)
                return 1;
            else
                return 0;
        }

        public int front(){
            if(rear == front)
                return -1;
            else
                return queue[front+1];
        }

        public int back(){
            if(rear == front)
                return -1;
            else
                return queue[rear];
        }


    }
}*/


