package teachsync.responses;


import java.util.UUID;

public class CheckIfUserExistsResponse {
    private UUID userId;
    private boolean exists;
    private boolean isTeacher;

    public CheckIfUserExistsResponse(UUID userId, boolean exists, boolean isTeacher) {
        this.userId = userId;
        this.exists = exists;
        this.isTeacher = isTeacher;
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

    public boolean isTeacher() {
        return isTeacher;
    }

    public void setTeacher(boolean teacher) {
        isTeacher = teacher;
    }
}
