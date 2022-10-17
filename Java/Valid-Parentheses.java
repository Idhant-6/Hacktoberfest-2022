//			STACK SOLUTION
class Solution {
    public boolean isValid(String str) {
        Stack<Character> s=new Stack<>();
        int n=str.length();
        for(int i=0; i<n; i++){
            char c=str.charAt(i);
            if(c=='(' || c=='[' || c=='{'){ s.push(c); }
            
            else{
                if(s.empty()) return false;
                char d=s.peek();
                if(c==')'){
                    if(d=='(') s.pop();
                    else return false;
                }
                else if(c=='}'){
                    if(d=='{') s.pop();
                    else return false;
                }
                else if(c==']'){
                    if(d=='[') s.pop();
                    else return false;
                }
                }
            }
        
        return s.isEmpty();
    }
}

//              STRING SOLUTION

// class Solution {
//     public boolean isValid(String s) {
        
//     int n = -1;
// 	while (s.length() != n) {
// 		n = s.length();
// 		s = s.replace("()", "");
// 		s = s.replace("[]", "");
// 		s = s.replace("{}", "");
// 	}
        
// 	if(s.length() == 0){
//         return true;
//     }
        
// 	else{
//         return false;
//         }
//     }
// }