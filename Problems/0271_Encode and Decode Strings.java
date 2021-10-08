public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs.size() - 1; i++) {
            if (sb.length() != 0) {
                sb.append(" ");
            }
            sb.append(Integer.toString(strs.get(i).length()));
        }
        sb.append("#");
        for (String str : strs) {
            sb.append(str);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> res = new ArrayList<>();
        int p = s.indexOf("#");
        String[] pos = s.substring(0, p).split(" ");
        int index = p + 1;
        for (int i = 0; i < pos.length; i++) {
            if (pos[i].equals("")) break;
            int num = Integer.valueOf(pos[i]);
            res.add(s.substring(index, index + num));
            index += num;
        }
        res.add(s.substring(index));
        return res;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));
