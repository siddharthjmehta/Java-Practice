public class Luhn {
    public static boolean check(String ccNumber) {
        // How many digits should there be - perhaps it can vary? Anyway should be all digits
        if (!ccNumber.matches("\\d+")) {
            throw new RuntimeException(String.format(
                    "CC number %s should be all digits", ccNumber));
        }

        // Keep running total
        int sum = 0;

        // 'odd' in the sense of an undefined index, starting at 0
        // so the first odd character will be the second one we look at (index 1)
        boolean odd = false;

        // Start inspecting each digit from right to left
        for (int i = ccNumber.length(); --i >= 0;) {
            int n = ccNumber.charAt(i) - '0';

            if (odd) {
                // Double each alternate digit
                n *= 2;

                // If result of doubling in two figures, make it one figure
                // which is the sum of the two digits
                if (n > 9) {
                    n -= 9;
                }
            }

            // Accumulate
            sum += n;
            odd = !odd;
        }

        //Accumulated total should be multiple of 10
        return ((sum % 10) == 0);
    }

    public static void main(String[] args) {
        System.out.println(Luhn.check("1111"));
    }
}
