package builderpatternexample;

public class BuilderPatternTest {
    public static void main(String[] args) {
        Computer computer = new Computer.Builder().setCPU("I5 8500T").setRAM(16).setStorage(512).build();
        System.out.println(computer);
    }
}