package teachsync.responses;


import java.util.UUID;

public class CheckIfUserExistsResponse {
    private UUID userId;
    private boolean exists;

    public CheckIfUserExistsResponse(UUID userId, boolean exists) {
        this.userId = userId;
        this.exists = exists;
    }

    public CheckIfUserExistsResponse() {
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public boolean isExists() {
        return exists;
    }

    public void setExists(boolean exists) {
        this.exists = exists;
    }
}
