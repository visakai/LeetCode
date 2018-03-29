public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        System.out.println(new Main().hammingDistance(1,4));
    }
//
    public int hammingDistance(int x, int y) {
        int min = Math.min(x, y);
        int max = Math.max(x, y);
        String maxStr = Integer.toBinaryString(max);
        String minStr = Integer.toBinaryString(min);
        int diff = 0;
        for(int i =0; i<maxStr.length()-minStr.length(); i++){
            if(maxStr.charAt(i)!='0'){
                diff ++;
            }
        }
        for(int i = 0; i<minStr.length(); i++){
            if(minStr.charAt(minStr.length()-1-i) != maxStr.charAt(maxStr.length()-1-i)){
                diff ++;
            }
        }
        return diff;
    }
}
