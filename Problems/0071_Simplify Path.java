class Solution {
    public static final int s0 = 0;
    public static final int s1 = 1;
    public static final int s2 = 2;
    
    public String simplifyPath(String path) {
        List<String> stack = new ArrayList<>();
        // Deque<String> stack = new ArrayDeque<>();
        int state = s0;
        StringBuilder sb = new StringBuilder();
        int periodNum = 0;
        for (int i = 0; i < path.length(); i++) {
            switch(state) {
                case s0:
                    if (path.charAt(i) == '.') {
                        periodNum++;
                        state = s2;
                    } else if (Character.isLetter(path.charAt(i)) || path.charAt(i) == '_') {
                        sb.append(path.charAt(i));
                        state = s1;
                    }
                    break;
                case s1:
                    if (path.charAt(i) == '/') {
                        stack.add(sb.toString());
                        //stack.addLast(sb.toString());
                        sb.setLength(0);
                        state = s0;
                    } else {
                        sb.append(path.charAt(i));
                    }
                    break;
                case s2:
                    if (periodNum == 1) {
                        if (path.charAt(i) == '/') {
                            periodNum = 0;
                            state = s0;
                        } else if (path.charAt(i) == '.') {
                            periodNum++;
                        } else {
                            sb.append('.');
                            sb.append(path.charAt(i));
                            periodNum = 0;
                            state = s1;
                        }
                    } else {
                        if (path.charAt(i) == '/') {
                            if (!stack.isEmpty()) {
                                stack.remove(stack.size() - 1);
                            }
                            //stack.pollLast();
                            periodNum = 0;
                            state = s0;
                        } else {
                            sb.append('.');
                            sb.append('.');
                            sb.append(path.charAt(i));
                            periodNum = 0;
                            state = s1;
                        }
                    }
                    break;
            }
        }
        if (sb.length() != 0) {
            stack.add(sb.toString());
            //stack.append(sb.toString());
        } else if (periodNum == 2) {
            if (stack.size() > 0) {
                stack.remove(stack.size() - 1);
            }
        }
        
        String str = "/";
        for (int i = 0; i < stack.size(); i++) {
            if (i != 0) str += "/";
            str += stack.get(i);
        }
        return str;
    }
}

// Better Solution
class Solution {
    public String simplifyPath(String path) {
        // 双端队列
        Deque<String> queue = new LinkedList<>();
        // 分割字符
        String[] res = path.split("/");
        for(int i = 0; i < res.length; i++){
            String s = res[i];
            if(s.equals(".") || s.equals("")) continue;
            else if (s.equals("..")){
                if(!queue.isEmpty()){
                    queue.pollLast();
                }
            }else{
                queue.offer(s);
            }
        }
        // 拼接
        StringBuilder sb = new StringBuilder("/");
        while(!queue.isEmpty()){
            sb.append(queue.poll());
            if(!queue.isEmpty()){
                sb.append("/");
            }
        }
        // 判空
        return sb.toString().equals("") ? "/" : sb.toString();
    }
}
