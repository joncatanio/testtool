package user.models;

import java.util.*;

/**
 * UserDB is the repository of registered user information.  It is derived from
 * various sections of the requirements that require a list of users (teachers and students).
 *
 * Created by rgarmsen on 11/8/15.
 */
public abstract class UserDBModel {
    /**
     * The collection of user data records.
     */
    Collection<UserModel> users;

    /**
     * Add the given User to the given UserDB.  The Id of the given user
     * record must not be the same as a user record already in the UserDB.
     * The Id component is required and must be eight characters or less.  The
     * email address is required.  The username is also required.  The nickname is optional
     * and may be omitted.
     */
    abstract void add(UserModel u);

    /**
     * Find a user by unique id.
     */
    abstract UserModel findById(String id);

    /**
     * Find a user or users by unique username.  If more than one is found,
     * the output list is sorted by id.
     */
    abstract UserModel findByName(String username);
}
