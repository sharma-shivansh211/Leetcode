class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> temp = new ArrayList<>();
        String al = "123456789";
        String a = String.valueOf(low);
        String b = String.valueOf(high);
        for(int i = a.length() ; i <= b.length() ; i++){
            int t = 0;
            for(int j = 0 ; j <= 9 - i ; j++){
                String n = al.substring(j,j+i);
                int num = Integer.parseInt(n);
                if(num >= low && num <= high && !temp.contains(num)) temp.add(num);
            }
        }
        return temp;

    }
}