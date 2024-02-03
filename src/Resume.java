/**
 * Initial resume class
 */
public class Resume {

    // Unique identifier
    private String uuid;

    @Override
    public String toString() {
        return uuid;
    }
    public String getUuid() {
        try {
            return uuid;
        } catch (NullPointerException e) {
            throw new RuntimeException(e);
        }
    }
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
