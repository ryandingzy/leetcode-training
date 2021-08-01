class Solution {
    public String intToRoman(int num) {
        int[][] value = new int[][] {
            {'M' - 'A', 1000},
            {'D' - 'A', 500},
            {'C' - 'A', 100},
            {'L' - 'A', 50},
            {'X' - 'A', 10},
            {'V' - 'A', 5},
            {'I' - 'A', 1}
        };
        
        StringBuffer sb = new StringBuffer("");
        int i = 0, idc = 2, idx = 4, idi = 6;
        while (num > 0) {
            if (num >= value[i][1]) {
                num -= value[i][1];
                sb.append((char)('A' + value[i][0]));
            } else {
                if (i < idi) {
                    int ii = i < idc ? idc : (i < idx ? idx : idi);
                    if (num >= value[i][1] - value[ii][1]) {
                        num -= value[i][1] - value[ii][1];
                        sb.append((char)('A' + value[ii][0]));
                        sb.append((char)('A' + value[i][0]));
                    }
                }
                i++;
            }
        }
        return sb.toString();
    }
}

// Greedy Algorithm
const pair<int, string> valueSymbols[] = {
    {1000, "M"},
    {900,  "CM"},
    {500,  "D"},
    {400,  "CD"},
    {100,  "C"},
    {90,   "XC"},
    {50,   "L"},
    {40,   "XL"},
    {10,   "X"},
    {9,    "IX"},
    {5,    "V"},
    {4,    "IV"},
    {1,    "I"},
};

class Solution {
public:
    string intToRoman(int num) {
        string roman;
        for (const auto &[value, symbol] : valueSymbols) {
            while (num >= value) {
                num -= value;
                roman += symbol;
            }
            if (num == 0) {
                break;
            }
        }
        return roman;
    }
};

// hard coded
class Solution {
    String[] thousands = {"", "M", "MM", "MMM"};
    String[] hundreds  = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
    String[] tens      = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    String[] ones      = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

    public String intToRoman(int num) {
        StringBuffer roman = new StringBuffer();
        roman.append(thousands[num / 1000]);
        roman.append(hundreds[num % 1000 / 100]);
        roman.append(tens[num % 100 / 10]);
        roman.append(ones[num % 10]);
        return roman.toString();
    }
}
