package teachsync.requests;

import java.util.UUID;

public class CheckIfUserExistsEvent {
    private UUID userId;

    public CheckIfUserExistsEvent(UUID userId) {
        this.userId = userId;
    }

    public CheckIfUserExistsEvent() {
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }
}
