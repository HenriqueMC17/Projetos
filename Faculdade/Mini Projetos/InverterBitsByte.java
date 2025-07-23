public class InverterBitsByte {
    public static int inverterBits(int b) {
        return ~b & 0xFF; // Inverte e mantém apenas 8 bits
    }

    public static void main(String[] args) {
        int b = 0b10101010; // 170
        int invertido = inverterBits(b);
        System.out.println(Integer.toBinaryString(invertido)); // 01010101
        System.out.println(invertido); // 85
    }
}