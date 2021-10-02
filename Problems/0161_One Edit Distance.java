class Solution {
    public boolean isOneEditDistance(String s, String t) {
        int ids = 0, idt = 0;
        boolean hasFalse = false;
        while (ids < s.length() && idt < t.length()) {
            if (s.charAt(ids) == t.charAt(idt)) {
                ids++;
                idt++;
            } else {
                if (hasFalse) return false;
                if (s.length() > t.length()) {
                    ids++;
                } else if (s.length() < t.length()) {
                    idt++;
                } else {
                    ids++;
                    idt++;
                }
                hasFalse = true;
            }
        }
        if (ids == s.length() && idt == t.length() && hasFalse) return true;
        else if (ids == idt && Math.abs(s.length() - t.length()) == 1) return true;
        else return false;
    }
}

// better solution
class Solution {
  public boolean isOneEditDistance(String s, String t) {
    int ns = s.length();
    int nt = t.length();

    // Ensure that s is shorter than t.
    if (ns > nt)
      return isOneEditDistance(t, s);

    // The strings are NOT one edit away distance  
    // if the length diff is more than 1.
    if (nt - ns > 1)
      return false;

    for (int i = 0; i < ns; i++)
      if (s.charAt(i) != t.charAt(i))
        // if strings have the same length
        if (ns == nt)
          return s.substring(i + 1).equals(t.substring(i + 1));
        // if strings have different lengths
        else
          return s.substring(i).equals(t.substring(i + 1));

    // If there is no diffs on ns distance
    // the strings are one edit away only if
    // t has one more character. 
    return (ns + 1 == nt);
  }
}
