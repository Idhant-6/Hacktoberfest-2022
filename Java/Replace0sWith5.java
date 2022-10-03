class GfG {
    int convertfive(int num) {
        // Your code here
        String st = Integer.toString(num);
        st = st.replace('0','5');
        int x = Integer.parseInt(st);  
        return x;
    }
}