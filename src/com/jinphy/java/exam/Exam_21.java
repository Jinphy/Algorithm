package com.jinphy.java.exam;

import java.util.Scanner;
// 保卫方案
/*

时间限制：2秒 空间限制：65536K 热度指数：9721
        算法知识视频讲解
        题目描述
        战争游戏的至关重要环节就要到来了，这次的结果将决定王国的生死存亡，小B负责首都的防卫工作。首都位于一个四面环山的盆地中，周围的n个小山构成一个环，作为预警措施，小B计划在每个小山上设置一个观察哨，日夜不停的瞭望周围发生的情况。 一旦发生外地入侵事件，山顶上的岗哨将点燃烽烟，若两个岗哨所在的山峰之间没有更高的山峰遮挡且两者之间有相连通路，则岗哨可以观察到另一个山峰上的烽烟是否点燃。由于小山处于环上，任意两个小山之间存在两个不同的连接通路。满足上述不遮挡的条件下，一座山峰上岗哨点燃的烽烟至少可以通过一条通路被另一端观察到。对于任意相邻的岗哨，一端的岗哨一定可以发现一端点燃的烽烟。 小B设计的这种保卫方案的一个重要特性是能够观测到对方烽烟的岗哨对的数量，她希望你能够帮她解决这个问题。
        输入描述:
        输入中有多组测试数据，每一组测试数据的第一行为一个整数n(3<=n<=10^6),为首都周围的小山数量，第二行为n个整数，依次表示为小山的高度h（1<=h<=10^9）.
        输出描述:
        对每组测试数据，在单独的一行中输出能相互观察到的岗哨的对数。
        示例1
        输入

        5
        1 2 4 5 3
        输出

        7
*/

public class Exam_21 {

    private static int len ;

    private static Scanner reader = new Scanner(System.in);

    public static void main(String[] args) {
        len = reader.nextInt();
        int[] heights = new int[len];
        for (int i = 0; i < len; i++) {
            heights[i] = reader.nextInt();
        }
        countPairs(heights);
    }

    private static void countPairs(int[] heights) {
        //岗哨信息
        Sentry[] sentries = Sentry.transform(heights,len);
        heights = null;
        // 遍历的栈顶岗哨
        Sentry topSentry;
        Sentry.total = 0;
        // 遍历过程的堆栈
        Stack stack  = new Stack();
        // 把高度最大的岗哨压栈，作为第一个遍历的岗哨，之所以要把最高的作为第一个
        // 是因为该栈的元素是高度单调递减序列，所以把最高的作为首个遍历元素，就可以避免重复遍历
        stack.push(Sentry.max);

        // 设置遍历下标为高度最大的岗哨的下标的下一个并开始遍历，向在栈中的元素配对
        int i = (Sentry.max.index+1)%sentries.length;
        do {
            // 当前元素大于栈顶元素，此时当前元素将会影响栈中所有高度比当前
            // 元素小的岗哨对后续岗哨的观察，因此，在遍历当前岗哨后，栈中所有
            // 高度比当前岗哨小的岗哨将不能观察到后续遍历的岗哨，因此，将栈中
            // 所有高度小于当前岗哨的元素（岗哨）从栈中弹出，但是这些被弹出的
            // 岗哨是可以与当前岗哨配对的
            while (stack.peek().height < sentries[i].height) {
                topSentry = stack.pop();
                Sentry.total++;
            }
            // 弹出完成后再判断和修改当前栈顶的元素与当前遍历的元素的大小关系
            topSentry = stack.peek();

            if (topSentry.height == sentries[i].height) {
                // 高度相等时，同样对后续的遍历无影响，但是当前元素可以和栈中
                // 高度相等的元素配对，并且如果栈中还有更大的元素，则当前元素还可以
                // 再与栈中比当前元素大的最小的那个元素在配对一次
                Sentry.total += topSentry.count;
                if (topSentry.count < stack.size()) {
                    Sentry.total++;
                }
                sentries[i].count = topSentry.count + 1;
            } else {
                // 当前元素比栈顶元素小，说明该元素（岗哨）不影响栈中的元素
                // 观察接下来的元素，所以栈中的元素对后面将要遍历的元素是有效的
                // 所以不用弹出，但是当前元素只能与栈顶元素配对，因此当前元素
                // 在栈中只能与栈顶元素配对
                Sentry.total++;
            }

            // 把当前元素压入栈中
            stack.push(sentries[i]);
            //遍历下一个岗哨
            i = (i + 1) % sentries.length;
        } while (i != Sentry.max.index);

        // 处理遍历后环的末尾
        while (!stack.empty()) {
            topSentry = stack.pop();
            if (topSentry.height < Sentry.max.height) {
                Sentry.total++;
            } else {
                // 遍历是从第一个最大值开始的，所以这里判断剩下的栈顶元素是否为第一个最大值
                // 也是判断所有岗哨中最大值是否是唯一的
                if (topSentry.count == 1) {
                    // 最大值是唯一的，所以要减掉一个重复计算的配对
                    Sentry.total--;
                }
                break;
            }
        }
        System.out.println(Sentry.total);

    }

    private static class Sentry{
        public int height;
        public int index;
        public int count = 1;//相同高度岗哨的个数
        public static Sentry max = new Sentry();
        public static long total;

        public Sentry(){}

        public Sentry(int index, int height) {
            this.index = index;
            this.height = height;
        }

        public static Sentry[] transform(int[] heights, int len) {
            Sentry[] sentries = new Sentry[len];
            for (int i = 0; i < len; i++) {
                sentries[i] = new Sentry(i, heights[i]);
                if (max.height < heights[i]) {
                    max = sentries[i];
                }
            }
            return sentries;
        }

    }

    private static class Stack{
        Stack parent;
        Stack child;
        Sentry value;
        private static int size;

        public Stack(){}

        private Stack(Sentry value) {
            this.value = value;
        }

        public void push(Sentry element) {
            Stack child = new Stack(this.value);
            this.value = element;
            if (this.parent != null) {
                this.parent.child = child;
                child.parent = this.parent;
            }
            child.child = this;
            this.parent = child;
            Stack.size++;

        }

        public Sentry pop() {
            if (Stack.size ==0) {
                return null;
            }
            Stack.size--;
            Sentry value = this.value;
            Stack parent = this.parent;
            if (parent.value != null) {
                this.value = parent.value;
                parent.parent.child = this;
                this.parent = parent.parent;
                parent = null;
            } else {
                this.value = null;
                this.parent = null;
            }
            return value;
        }

        public Sentry peek() {
            return this.value;
        }

        public boolean empty() {
            return Stack.size==0;
        }

        public int size() {
            return size;
        }
    }

/*
    private static class Stack{
        Sentry[] elements;
        int top = -1;

        public Stack(int capacity) {
            elements = new Sentry[capacity];
        }

        public void push(Sentry element) {
            elements[++top] = element;
        }

        public Sentry pop() {
            Sentry element = elements[top];
            elements[top--] = null;
            return element;
        }

        public Sentry peek() {
            return elements[top];
        }

        public boolean empty() {
            return top < 0;
        }

        public int size() {
            return top + 1;
        }
    }*/
}

/*


public class Exam_21 {

    private static long pairs;
    private static int n ;
    private static int len ;
    private static int maxHeight;
    private static int[] heights = new int[1000000];

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        len = reader.nextInt();
        for (int i = 0; i < len; i++) {
            heights[i] = reader.nextInt();
        }
        countPairs(heights);
    }

    private static void countPairs(int[] heights) {
        Sentry[] sentries = Sentry.transform(heights,len);
        Sentry maxSentry = new Sentry();
        pairs = 0;
        n = len - 1;
        maxHeight = 0;
        for (int i = 0; i< n; i++) {
            maxHeight = 0;
            Sentry.setMaxHeight(sentries,maxSentry,i,i+1);

            for (int j = i+1;j<len;j++) {
                if (canPair(heights[i], heights[j], maxHeight)) {
                    pairs++;
                    maxHeight = heights[j];
                } else if (canPair(heights[i], heights[j], maxSentry.height)) {
                    pairs++;
                }
                if (maxSentry.index == j + 1) {
                    Sentry.updateMaxHeight(sentries,maxSentry,i,j+1);
                }
            }
        }
        System.out.println(pairs);

    }


    private static boolean canPair(int a, int b, int max) {
        if (max > a || max > b) {
            return false;
        }
        return true;
    }

    private static class Sentry{
        public int height;
        public int index;
        public static int start;

        public Sentry(){}

        public Sentry(int index, int height) {
            this.index = index;
            this.height = height;
        }

        public static Sentry[] transform(int[] heights, int len) {
            Sentry[] sentries = new Sentry[len];
            for (int i = 0; i < len; i++) {
                sentries[i] = new Sentry(i, heights[i]);
            }
            Arrays.sort(sentries, new Comparator<Sentry>() {
                @Override
                public int compare(Sentry o1, Sentry o2) {
                    return o1.height-o2.height;
                }
            });
            Sentry.start = len-1;
            return sentries;
        }

        public static void setMaxHeight(Sentry[] sentries, Sentry maxHeightSentry, int outStart, int outEnd) {
            start = sentries.length-1;
            if (sentries[start].index == outStart || sentries[start].index == outEnd) {
                updateMaxHeight(sentries, maxHeightSentry, outStart, outEnd);
            } else {
                maxHeightSentry.height = sentries[start].height;
                maxHeightSentry.index = sentries[start].index;
            }
        }

        public static void updateMaxHeight(Sentry[] sentries, Sentry maxHeightSentry, int outStart, int outEnd) {
            start--;
            for (int i = start;i>=0;i--) {
                if (sentries[i].index < outStart || sentries[i].index > outEnd) {
                    maxHeightSentry.height = sentries[i].height;
                    maxHeightSentry.index = sentries[i].index;
                    return;
                }
            }
            maxHeightSentry.height = 0;
            maxHeightSentry.index = -1;
        }
    }
}

*/


/*

public class Exam_21 {

    private static long pairs;
    private static int n ;
    private static int len ;
    private static int maxA;
    private static int maxB;
    private static boolean[] succeed = new boolean[1000000];
    private static int[] heights = new int[1000000];

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        len = reader.nextInt();
        for (int i = 0; i < len; i++) {
            heights[i] = reader.nextInt();
        }
        countPairs(heights);
    }

    private static void countPairs(int[] heights) {
        pairs = 0;
        n = len - 1;
        maxA = 0;
        maxB =0;
        for (int i = 0; i< n; i++) {
            maxA = 0;
            for (int j = i+1; j < len; j++) {
                if (canPass(heights[i], heights[j], maxA)) {
                    pairs++;
                    succeed[j] = true;
                }
                maxA = Math.max(maxA, heights[j]);
            }
            maxA = maxB;
            for (int j = n;j>=i+1;j--) {
                if (!succeed[j] && canPass(heights[i], heights[j], maxA)) {
                    pairs++;
                }
                succeed[j] = false;
                maxA = Math.max(maxA, heights[j]);
            }
            maxB = Math.max(maxB, heights[i]);
        }
        System.out.println(pairs);

    }

    private static boolean canPass(int a, int b, int max) {
        if (max > a || max > b) {
            return false;
        }
        return true;
    }
}
*/
