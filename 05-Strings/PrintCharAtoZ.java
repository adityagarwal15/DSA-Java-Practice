public class PrintCharAtoZ {
    public static void main(String[] args){

        //initializing empty string
        StringBuilder sb = new StringBuilder("");

        //loop from a-z
        for(char ch='a'; ch<='z'; ch++){
            sb.append(ch);  //to add all char a-z in the (sb) object
        }

        //print object sb to get all characters a-z
        System.out.println(sb);
    }
}
