package builderpatternexample;

public class Computer {
    private final String CPU;
    private final int RAM, storage;
    private Computer(Builder builder) {
        this.CPU = builder.CPU;
        this.RAM = builder.RAM;
        this.storage = builder.storage;
    }
    @Override
    public String toString() {
        return "Computer [CPU=" + CPU +
               ", RAM=" + RAM +
               ", storage=" + storage + "]";
    }
    public static class Builder {
        private String CPU;
        private int RAM, storage;
        public Builder setCPU(String CPU) {
            this.CPU = CPU;
            return this;
        }
        public Builder setRAM(int size) {
            this.RAM = size;
            return this;
        }
        public Builder setStorage(int size) {
            this.storage = size;
            return this;
        }
        public Computer build() {
            return new Computer(this);
        } 
    }
}