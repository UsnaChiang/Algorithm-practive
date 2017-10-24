
/**
 * Created by usna on 24/10/2017.
 * 二分查找法简单版
 */
public class AP20171024 {
   public static int rank(int key,int[] a){
       int l=0;
       int h=a.length-1;
       while (l<h){
           int mid= l+(h-l)/2;
           if       (key<a[mid]) h=mid-1;
           else   if(key>a[mid]) l=mid+1;
           else                  return mid;
       }
       return -1;
   }
}
