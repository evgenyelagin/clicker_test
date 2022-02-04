package utils;

public class Converter {
    public static int romanToInt(String s) {
        int sum = 0;
        char chs[] = s.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            if (chs[i] == 'I') sum += 1;
            if (chs[i] == 'V') {
                if (i != 0 && chs[i - 1] == 'I') sum += 4 - 1;
                else sum += 5;
            }
            if (chs[i] == 'X') {
                if (i != 0 && chs[i - 1] == 'I') sum += 9 - 1;
                else sum += 10;
            }
            if (chs[i] == 'L') {
                if (i != 0 && chs[i - 1] == 'X') sum += 40 - 10;
                else sum += 50;
            }
            if (chs[i] == 'C') {
                if (i != 0 && chs[i - 1] == 'X') sum += 90 - 10;
                else sum += 100;
            }
            if (chs[i] == 'D') {
                if (i != 0 && chs[i - 1] == 'C') sum += 400 - 100;
                else sum += 500;
            }
            if (chs[i] == 'M') {
                if (i != 0 && chs[i - 1] == 'C') sum += 900 - 100;
                else sum += 1000;
            }
        }
        return sum;
    }
}