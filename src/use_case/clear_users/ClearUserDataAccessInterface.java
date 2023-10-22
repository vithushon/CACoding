package use_case.clear_users;

import entity.User;

public interface ClearUserDataAccessInterface {
    boolean isEmpty();

    void clear();
}
