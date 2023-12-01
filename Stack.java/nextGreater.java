import java.util.Stack;


// 4 forms of nextGreater :-

//1️⃣Next Greater Right =  while(!s.isEmpty() && arr[s.peek()] <= arr[i])
//2️⃣Next Greater Left  =  while(!s.isEmpty() && arr[s.peek()] <= arr[i]) + for loop reverse
//3️⃣Next Smaller Right =  while(!s.isEmpty() && arr[s.peek()] >= arr[i])
//4️⃣Next Smaller Left  =  while(!s.isEmpty() && arr[s.peek()] >= arr[i]) + for loop reverse 

public class nextGreater {


    //1️⃣Next Greater Right =  while(!s.isEmpty() && arr[s.peek()] <= arr[i])
    public static void main(String args[]){
            // int arr[] = {6,8,0,1,3};
            // Stack<Integer> s = new Stack<Integer>();

            // int nextG[] = new int[arr.length];
            // for(int i=arr.length-1; i>=0; i--){
            //     //1 step = while loop
            //     while(!s.isEmpty() && arr[s.peek()] >= arr[i]){  //⭐arr[s.peek()]  MEANS idx of that which is at top
            //         s.pop();
            //     }
            //     //2 step = if-else
            //     if(s.isEmpty()){
            //         nextG[i] = -1;
            //     }
            //     else{
            //         nextG[i] = arr[s.peek()]; //value at understand
            //     }
            //     //3 step = push in s
            //     s.push(i);
            // }

            // for(int i=0; i<nextG.length; i++) {
            //     System.out.println(nextG[i]+" ");
            // }
            // System.out.println();




            //2️⃣Next Greater Left  =  while(!s.isEmpty() && arr[s.peek()] <= arr[i]) + for loop reverse
            // int arr[] = {6,8,0,1,3};
            // Stack<Integer> s = new Stack<Integer>();

            // int nextG[] = new int[arr.length];
            // for(int i=0; i<arr.length; i++){
            //     //1 step = while loop
            //     while(!s.isEmpty() && arr[s.peek()] >= arr[i]){  //⭐arr[s.peek()]  MEANS idx of that which is at top
            //         s.pop();
            //     }
            //     //2 step = if-else
            //     if(s.isEmpty()){
            //         nextG[i] = -1;
            //     }
            //     else{
            //         nextG[i] = arr[s.peek()]; //value at understand
            //     }
            //     //3 step = push in s
            //     s.push(i);
            // }

            // for(int i=0; i<nextG.length; i++) {
            //     System.out.println(nextG[i]+" ");
            // }
            // System.out.println();





            //3️⃣Next Smaller Right =  while(!s.isEmpty() && arr[s.peek()] >= arr[i])
    //        int arr[] = {6,8,0,1,3};
    //         Stack<Integer> s = new Stack<Integer>();

    //         int nextG[] = new int[arr.length];
    //         for(int i=arr.length-1; i>=0; i--){
    //             //1 step = while loop
    //             while(!s.isEmpty() && arr[s.peek()] >= arr[i]){  //⭐arr[s.peek()]  MEANS idx of that which is at top
    //                 s.pop();
    //             }
    //             //2 step = if-else
    //             if(s.isEmpty()){
    //                 nextG[i] = -1;
    //             }
    //             else{
    //                 nextG[i] = arr[s.peek()]; //value at understand
    //             }
    //             //3 step = push in s
    //             s.push(i);
    //         }

    //         for(int i=0; i<nextG.length; i++) {
    //             System.out.println(nextG[i]+" ");
    //         }
    //         System.out.println();
    // }






    //4️⃣Next Smaller Left  =  while(!s.isEmpty() && arr[s.peek()] >= arr[i]) + for loop reverse 
    int arr[] = {6,8,0,1,3};
            Stack<Integer> s = new Stack<Integer>();

            int nextG[] = new int[arr.length];
            for(int i=0; i<arr.length; i++){
                //1 step = while loop
                while(!s.isEmpty() && arr[s.peek()] >= arr[i]){  //⭐arr[s.peek()]  MEANS idx of that which is at top
                    s.pop();
                }
                //2 step = if-else
                if(s.isEmpty()){
                    nextG[i] = -1;
                }
                else{
                    nextG[i] = arr[s.peek()]; //value at understand
                }
                //3 step = push in s
                s.push(i);
            }

            for(int i=0; i<nextG.length; i++) {
                System.out.println(nextG[i]+" ");
            }
            System.out.println();
    }

}
