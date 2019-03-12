package punch.day1.task1;

import com.sun.istack.internal.NotNull;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 *
 * @version punch
 * Date: 2019-02-27 16:18
 * To change this template use File | Settings | File Templates.
 * Description:
 *  [problems]? link https://github.com/wangzheng0822/algo
 * <p>
 *    1. 实现数组的动态扩容 （本质实现 JAVA ArrayList部分功能）
 *    2. 实现一个固定大小的有序数组，支持动态增删改操作
 *    3. 实现两个有序数组合并为一个数组
 * <br>
 */
public class IArray {

    /**
     *  1 实现动态扩容 （ArrayList）
     * @param <T>
     */
    public static class IArrayList<T>{
        private int size = 0;
        private  Object[] array;
        public IArrayList(int cap){
            this.array = new Object[cap];
        }
        public IArrayList(){
            this(16);
        }

        public void add(T element){
            set(size,element);
            this.size+=1;
        }

        public int size(){
            return this.size;
        }

        public void set(int index,T ele){
            if (index >= this.array.length ){
                grow(index);
                this.size = index;
            }
            this.array[index] = ele;
        }

        public T get(int index){
            return (T)this.array[index];
        }
        /**
         *  扩容 2 倍
         * @param cap 的2倍
         */
        private void grow(int cap){
            Object[] newArray = new Object[cap << 1];
            System.arraycopy(this.array,0,newArray,0,this.size);
            this.array = newArray;
        }

    }

    /**
     * 2 固定大小排序数组
     */
    public static class FixSortedArray{

        private int [] array;
        private int size = 0 ;
        public FixSortedArray(int cap){
            this.array = new int[cap];
        }
        public int get(int index){
            return array[index];
        }
        public void insert(int value){
            if(size == 0){
                this.array[0] = value;
                size ++;
            }else {
                // do move
                int index = findInsertIndex(value, 0, size-1 );
                if(index >= this.array.length) return;
                if (size < array.length) {
                    size++;
                }
                // copy swap
                int swap ;
                for (int i = index; i < size ; i++) {
                    swap = array[i];
                    array[i] = value;
                    value = swap;
                }
            }
        }
        private int findInsertIndex(int value,int start,int end){
            if(start == end){
                return array[start] >= value?start:start+1 ;
            }
            int mid = (start + end ) >> 1;
            if(array[mid]==value){
                return mid;
            }else{
                 return array[mid]> value?findInsertIndex(value,start,mid):findInsertIndex(value,mid+1,end);
            }

        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < size  ; i++) {
                sb.append(array[i]);
                sb.append(",");
            }
            return sb.delete(sb.length()-1,sb.length()).toString();

        }

        public int size() {
            return size;
        }
    }

    /**
     *  3.实现两个有序数组合并为一个数组
     *  默认为 small to big
     *  double pointer
     * @param a
     * @param b
     * @return
     */
    public static int [] mergeSortedArray(@NotNull int [] a,@NotNull int [] b){
        if(a.length == 0 || b.length == 0){
            return a.length ==0 ?b:a;
        }
        //todo  double pointer
        int[] res = new int[a.length +b.length];

        int i =0 ,j = 0;
        while ( i < a.length && j < b.length ) {
            if(a[i] >= b[j]){
                res[i+j] = b[j];
                j++;
            }else {
                res[i+j] = a[i];
                i++;
            }
        }
        // copy remain
        if(i == a.length){
            System.arraycopy(b,j,res,i+j,b.length-j);
        }else {
            System.arraycopy(a,j,res,i+j,a.length-i);
        }

        return res;
    }

}
