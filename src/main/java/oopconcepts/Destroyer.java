package oopconcepts;

public class Destroyer extends Robot {
    @Override
    public void madeBy() {
        System.out.println("Metal");
    }

    @Override
    public void createdFor() {
        System.out.println("Destroy objects.");
    }
}
