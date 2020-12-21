package oopconcepts;

public abstract class Animal {
    public abstract int weight(int weight);
    public abstract int age(int age);
    public boolean makeNoise(boolean isMakeNoise){
        return isMakeNoise;
    }

    public boolean sleep(boolean isSleep){
        return isSleep;
    }

    public boolean roam(boolean isroam){
        return isroam;
    }
}
