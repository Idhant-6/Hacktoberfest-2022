//                      METHOD 1
class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s == null || t == null || s.length() != t.length())
			return false;
        Map<Character, Character> map = new HashMap<>();
        
        for (int i = 0; i < s.length(); i++) {
            char char_str1 = s.charAt(i), char_str2 = t.charAt(i);
            if (map.containsKey(char_str1)) 
			{
                if (map.get(char_str1) != char_str2)
					return false;
            }
			else 
			{
                if (map.containsValue(char_str2)) 
					return false;
             map.put(char_str1, char_str2);
            }
        }
        
        return true;
//                      METHOD 2       
//         if(s.length()!=t.length()) return false;
//         HashMap<Character, Character> hash1= new HashMap<>();
//         HashMap<Character, Boolean> hash2= new HashMap<>();
        
//         for(int i=0; i<s.length(); ++i){
//             char chS=s.charAt(i);
//             char chT=t.charAt(i);
            
//             if(hash2.containsKey(chT)==true){
//                 return false;
//             }else{
//                 hash1.put(chS, chT);
//                 hash2.put(chT, true);
                
//             }
            
//             if(hash1.containsKey(chS)==true){

//                 if(hash1.get(chS)!=chT) return false;
//             }
//         }
//         return true;
    }
}