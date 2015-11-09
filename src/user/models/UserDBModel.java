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
     *   pre:
     *   //
     *   // There is no user model in the input UserDBModel with the same id as the
     *   // user to be added.
     *   //
     *   !exists (UserModel um_other ;
     *           data.contains(um_other) ;
     *               um_other.id.equals(um.id))
     *
     *       &&
     *
     *   //
     *   // The id of the given user record is not empty
     *   //
     *   (um.id != null) && (um.id.length() > 0))
     *
     *      &&
     *
     *   //
     *   // The username username is not empty.
     *   //
     *   (um.username != null) && (um.username.length() > 0)
     *
     * post:
     *   //
     *   // A user is in the output data if and only if it is the new
     *   // user to be added or it is in the input data.
     *   //
     *   forall (UserRecord um_other ;
     *       (data'.contains(um_other)) iff
     *           um_other.equals(um) || data.contains(um_other));
     */
    abstract void add(UserModel um);

    /**
     * Find a user by unique id.
     *
     * post:
     *   //
     *   // If there is a user with the given id in the input data, then the
     *   // output user is equal to that record, otherwise the output record
     *   // is null.
     *   //
     *   exists (UserModel um_found ; data.contains(um_found) ;
     *           um_found.id.equals(id) && um_found.equals(return))
     *       ||
     *   !exists (UserModel um_found ; data.contains(um_found) ;
     *           um_found.id.equals(id)) && return == null;
     */
    abstract UserModel findById(String id);

    /**
     * Find a user or users by unique username.  If more than one is found,
     * the output list is sorted by id.
     *
     * post:
     *   //
     *   // If there is a user with the given id in the input data, then the
     *   // output user is equal to that record, otherwise the output record
     *   // is null.
     *   //
     *   exists (UserModel um_found ; data.contains(um_found) ;
     *           um_found.id.equals(id) && um_found.equals(return))
     *       ||
     *   !exists (UserModel um_found ; data.contains(um_found) ;
     *           um_found.id.equals(id)) && return == null;
     */
    abstract UserModel findByUsername(String username);
}
