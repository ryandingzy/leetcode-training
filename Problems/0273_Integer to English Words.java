class Solution {
    String[] nums = new String[] {
        "Zero", "One", "Two", "Three", "Four",
        "Five", "Six", "Seven", "Eight", "Nine",
        "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen",
        "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"
    };
    
    String[] tens = new String[] {
        "", "", "Twenty", "Thirty", "Forty", "Fifty",
        "Sixty", "Seventy", "Eighty", "Ninety"
    };
    
    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        StringBuilder sb = new StringBuilder();
        if (num / 1000000000 != 0) {
            sb.append(hundredWords(num / 1000000000));
            sb.append(" Billion");
        }
        if (num % 1000000000 / 1000000 != 0) {
            if (sb.length() != 0) sb.append(" ");
            sb.append(hundredWords(num % 1000000000 / 1000000));
            sb.append(" Million");
        }
        if (num % 1000000 / 1000 != 0) {
            if (sb.length() != 0) sb.append(" ");
            sb.append(hundredWords(num % 1000000 / 1000));
            sb.append(" Thousand");
        }
        if (num % 1000 != 0) {
            if (sb.length() != 0) sb.append(" ");
            sb.append(hundredWords(num % 1000));
        }
        return sb.toString();
    }
    
    public String hundredWords(int num) {
        StringBuilder sb = new StringBuilder();
        int hundred = num / 100;
        if (hundred != 0) {
            sb.append(nums[hundred]);
            sb.append(" Hundred");
        }
        
        int ten = num % 100 / 10;
        if (ten == 0) {
            if (num % 10 != 0) {
                if (sb.length() != 0) sb.append(" ");
                sb.append(nums[num % 10]);
            }
        } else if (ten == 1) {
            if (sb.length() != 0) sb.append(" ");
            sb.append(nums[num % 100]);
        } else {
            if (sb.length() != 0) sb.append(" ");
            sb.append(tens[ten]);
            if (num % 10 != 0) {
                sb.append(" ");
                sb.append(nums[num % 10]);
            }
        }
        return sb.toString();
    }
    
}
