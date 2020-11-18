package HomeDZ_2;

public class MyArrayDataException extends Exception{

        public MyArrayDataException (int i, int j) {
            super("Нехороший символ затаился под номером " + i + j);
        }

}
