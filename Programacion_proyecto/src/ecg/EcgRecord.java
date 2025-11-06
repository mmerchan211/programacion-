package ecg;

public class ECGRecord {
    private String id;
    private String timestamp;
    private double[] signal; // valores normalizados -1..1
    private String description;

    public ECGRecord(String id, String timestamp, double[] signal, String description) {
        this.id = id;
        this.timestamp = timestamp;
        this.signal = signal;
        this.description = description;
    }

    public String getId() { return id; }
    public String getTimestamp() { return timestamp; }
    public double[] getSignal() { return signal; }
    public String getDescription() { return description; }
}
