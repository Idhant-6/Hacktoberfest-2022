class Solution {
    public boolean isAnagram(String s, String t) {
        
//                  METHOD 1              
       
        if(s.length()!=t.length()) return false;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            char temp = s.charAt(i);
            map.put(temp, map.getOrDefault(temp, 0)+1);
        }
        
        for(int i=0; i<t.length(); i++){
            char temp = t.charAt(i);
            if(map.containsKey(temp)==false) return false;
            else if(map.get(temp)==1){
                map.remove(temp);
            }
            else{
                map.put(temp, map.get(temp)-1);
            }
        }
        return map.size()==0;

//                  METHOD 2              
//        
//      FASTER USING CHARACTER ARRAY
        
//         int cha[] = new int[26];
//         for(int i=0;i<s.length();i++){
//             cha[s.charAt(i)-97]++;
//         }
//         for(int i=0;i<t.length();i++){
//             cha[t.charAt(i)-97]--;
//         }
//         for(int i=0;i<26;i++){
//             if(cha[i]!=0){
//                 return false;
//             }
//         }
//         return true;
    }
}
