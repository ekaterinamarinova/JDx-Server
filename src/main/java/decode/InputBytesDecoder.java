package decode;

public class InputBytesDecoder {

    /**
     * This is a sample method that assumes
     * that {@code data} contains bytes
     * ordered based on a custom protocol:
     *
     * byte 0 -> payload length
     * byte 1 -> payload height
     * byte 2+ -> payload itself
     *
     * @param data - bytes, containing state info of a mock vehicle
     */
    public void sampleDecode(byte[] data) {
        for (byte datum : data) {
            switch (datum) {
                case 10:
                    System.out.println("Oxygen pressure in system OK.");
                    break;
                case 20:
                    System.out.println("Battery voltage level fine.");
                    break;
                case 30:
                    System.out.println("Fuel pressure in pump OK.");
                    break;
                case -50:
                    System.out.println("Error: oil pump pressure low!");
                    break;
            }
        }
    }
}
