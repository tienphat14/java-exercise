package collection;

public class TelevisionShow {
    private double frequency;
    private Channel channel;
    private String name;

    public TelevisionShow(double frequency, Channel channel, String name) {
        this.frequency = frequency;
        this.channel = channel;
        this.name = name;
    }

    public TelevisionShow() {

    }

    public double getFrequency() {
        return frequency;
    }

    public Channel getChannel() {
        return channel;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " on " + channel + " at " + frequency + "Hz";
    }
}