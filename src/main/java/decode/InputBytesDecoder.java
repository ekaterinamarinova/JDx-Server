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
     *
     * @param data
     */
    public void sampleDecode(byte[] data) {
        byte payloadLength = data[0];
        byte payloadHeight = data[1];

        for (int i = 2; i < payloadLength; i++) {
            switch (data[i]) {
                case 10 :
                    System.out.println("Oxygen pressure in system OK.");
                    break;
                case 20 :
                    System.out.println("Battery voltage level fine.");
                    break;
                case 30 :
                    System.out.println("Fuel pressure in pump OK.");
                    break;
                case -50:
                    System.out.println("Error: oil pump pressure low!");
                    break;
            }
        }
    }
}
