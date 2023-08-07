package mil.fap.security.encrypt;

/**
 * @author Fabian Perez Vasquez
 */
public class Sequence {

    final AES AES = new AES();

    private String encodeListNumber(String value) {
        String[] textToEncrypt = value.split(",");
        Integer[] length = new Integer[textToEncrypt.length];
        String output = "";
        for (int i = 0; i < textToEncrypt.length; i++) {
            length[i] = Integer.parseInt(textToEncrypt[i]);
            output = String.format("%s%s", output, (char) (int) length[i]);
        }
        return output.substring(0, output.length());
    }

    private Integer[] decodeListNumber(String value) {
        Integer length = value.length();
        Integer[] output = new Integer[length];
        for (int i = 0; i < length; i++) {
            output[i] = (int) value.charAt(i);
        }
        return output;
    }

    private Integer[] createSequence(Integer point, Integer length) {
        Integer start = point * 17 % 57;
        Integer end = point * 2 % 102;
        Integer pow = (int) Math.pow(2, 10);
        Integer aux = point;
        Integer[] output = new Integer[length];
        for (int i = 0; i < length; i++) {
            aux = (aux * aux + end) % pow;
            output[i] = aux;
        }
        return output;
    }

    private String[] generateArray(Integer seed, Integer length) {
        String[] output = new String[length];
        Integer[] array = new Integer[length];
        array = createSequence(seed, length);
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 3 != 0) {
                output[i] = "-";
            } else {
                output[i] = "+";
            }
        }
        return output;
    }

    public String encrypt(String value, Integer seed) {
        try {
            value = AES.encrypt(value);
            Integer[] numbers = decodeListNumber(value);
            String[] arrayOperators = generateArray(seed, numbers.length);
            Integer[] arraySequence = createSequence(seed, numbers.length);
            Integer[] transformedNumbers = new Integer[numbers.length];
            String output = "";
            for (int i = 0; i < numbers.length; i++) {
                switch (arrayOperators[i]) {
                    case "+":
                        transformedNumbers[i] = Integer.parseInt(numbers[i].toString()) - arraySequence[i];
                        break;
                    case "-":
                        transformedNumbers[i] = Integer.parseInt(numbers[i].toString()) + arraySequence[i];
                        break;
                }
            }
            for (int i = 0; i < numbers.length; i++) {
                output = String.format("%s%s%s", output, transformedNumbers[i], ",");
            }
            output = String.format("%s%s", output, transformedNumbers[transformedNumbers.length - 1]);
            return output;
        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }
    
    public String decrypt(String value, Integer seed) {
        try {
            String[] splited = value.split(",");
            Integer length  = splited.length;
            String[] arrayOperators = generateArray(seed, length);
            Integer[] arraySequence = createSequence(seed, length);
            Integer[] transformedNumbers = new Integer[length];
            Integer item = 0;
            String aux = "";
            for (int i = 0; i < length; i++) {
                item = Integer.parseInt(splited[i]);
                switch (arrayOperators[i]) {
                    case "+": 
                        transformedNumbers[i] = item + arraySequence[i];
                        break;
                    case "-":
                        transformedNumbers[i] = item - arraySequence[i];
                        break;
                }
            }
            length = transformedNumbers.length;
            for (int i = 0; i < length; i++) {
                aux = String.format("%s%s%s", aux, transformedNumbers[i], ",");
            }
            aux = String.format("%s%s", aux, transformedNumbers[length - 1]);
            return AES.decrypt(encodeListNumber(aux));
        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }
    
}
