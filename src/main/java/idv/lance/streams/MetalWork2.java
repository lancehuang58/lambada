package idv.lance.streams;

import onjava.Operation;

import java.util.Arrays;

public class MetalWork2 {

    public static void main(String[] args) {

        Arrays.stream(new Operation[] {()-> Operation.show("Heat")}).forEach(Operation::execute);
    }


}
