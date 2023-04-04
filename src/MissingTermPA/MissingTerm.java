package MissingTermPA;

public class MissingTerm {  //criar uma função que encontre o termo faltando em uma PA
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 5};
        System.out.println(findMissing(numbers));
    }
    public static int findMissing(int[] numbers) {
        int infLimit = Math.min(numbers[0], numbers[numbers.length-1]);
        int supLimit = Math.max(numbers[0], numbers[numbers.length-1]);
        int x = numbers[1] - numbers[0];
        int y = numbers[2] - numbers[1];

        if (x == 0 && y == 0) {
            return 0;
        }

        int missingNum = 0;
        boolean correct = false;
        while (!correct) {
            for (int j = 0; j < numbers.length-1; j++) {
                if (numbers[j+1] != numbers[j] + x) {
                    missingNum = numbers[j] + x;
                }
            }
            if (missingNum > infLimit && missingNum < supLimit) {
                correct = true;
            } else {
                x = y;
            }
        }

        return missingNum;
    }
}
