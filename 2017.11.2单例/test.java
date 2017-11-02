
/*
*单例 是最为最常见的设计模式之一。对于任何时刻，如果某个类只存在且最多存在一个具体的实例，
*那么我们称这种设计模式为单例。
*例如，对于 class Mouse (不是动物的mouse哦)，我们应将其设计为 singleton 模式。
*你的任务是设计一个 getInstance 方法，对于给定的类，每次调用 getInstance 时，都可得到同一个实例。
*
*样例
*在 Java 中:
*A a = A.getInstance();
*A b = A.getInstance();
*/


/*懒汉式*/
class Solution {
    
    public static Solution instance = null;
    
    /**
     * 采用synchronized完后并发调用getInstance也能顺利执行
     * 当多线程两个或者两个以上访问的时候,第一个线程执行instance为空,
     * 第二个线程执行,此时instance为空,还是会new一个实例,以此类推，在高并发下面，
     * 就可能存在两个或者以上的Solution的实例,所以要用synchronized.但是此写法太耗性能,下边的第二个方法是改良版
     */
    public static synchronized Solution getInstance() {
        // write your code here
        if(instance == null){
            instance = new Solution();
        }
        return instance;
    }
    /*
     *改良版
    */
    public static Solution getInstance() {
        // write your code here
        if(instance == null){
            synchronized(Solution.class){
                if (instance == null) {
                    instance = new Solution();
                }
            }
        }
        return instance;
    }
};

    /*饿汉式*/
    class Solution{
        private static Solution instance = new Solution();

        public static Solution getInstance(){
            return instance;
        }
    }