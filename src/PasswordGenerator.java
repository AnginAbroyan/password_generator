import java.security.SecureRandom;
import java.util.Scanner;

public class PasswordGenerator {

    public static String generatePassword(int length) {

        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder();

        // ASCII ranges for characters
        int upperCaseRangeStart = 65; // 'A'
        int upperCaseRangeEnd = 90; // 'Z'
        int lowerCaseRangeStart = 97; // 'a'
        int lowerCaseRangeEnd = 122; // 'z'
        int specialCharRangeStart = 33; // '!'
        int specialCharRangeEnd = 47; // '/'
        int numberRangeStart = 48; // '0'
        int numberRangeEnd = 57; // '9'

        // Add one character from each group
        password.append((char) (upperCaseRangeStart + random.nextInt(upperCaseRangeEnd - upperCaseRangeStart + 1))); // Uppercase
        password.append((char) (lowerCaseRangeStart + random.nextInt(lowerCaseRangeEnd - lowerCaseRangeStart + 1))); // Lowercase
        password.append((char) (specialCharRangeStart + random.nextInt(specialCharRangeEnd - specialCharRangeStart + 1))); // Special char
        password.append((char) (numberRangeStart + random.nextInt(numberRangeEnd - numberRangeStart + 1))); // Number

        // Fill the rest of the password with random characters
        for (int i = 4; i < length; i++) {
            int charType = random.nextInt(4); // 0: uppercase, 1: lowercase, 2: special char, 3: number
            int asciiValue;

            switch (charType) {
                case 0:
                    asciiValue = upperCaseRangeStart + random.nextInt(upperCaseRangeEnd - upperCaseRangeStart + 1);
                    break;
                case 1:
                    asciiValue = lowerCaseRangeStart + random.nextInt(lowerCaseRangeEnd - lowerCaseRangeStart + 1);
                    break;
                case 2:
                    asciiValue = specialCharRangeStart + random.nextInt(specialCharRangeEnd - specialCharRangeStart + 1);
                    break;
                case 3:
                    asciiValue = numberRangeStart + random.nextInt(numberRangeEnd - numberRangeStart + 1);
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + charType);
            }

            password.append((char) asciiValue);
        }

        return password.toString();
    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the length of the password: ");
        int length = scanner.nextInt();

        String password = generatePassword(length);
        System.out.println("Generated password: " + password);

        scanner.close();
    }
}
