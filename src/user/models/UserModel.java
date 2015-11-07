package user.models;

import java.util.UUID;

/**
 * A User is the information stored about a registered user of the
 * Test Tool.  The Name component is the user`s real-world name.  The Id is
 * the unique identifier by which the user is known to the Test Tool that is
 * selected automatically.  The Username is another unique identifier that
 * is chosen by the user.  The EmailAddress is the electronic mail address
 * used by the Test Tool to contact the user when necessary.  The Type determines
 * whether the user is a Teacher or a Student which cannot be changed after startup.
 *
 * A User is derived from <a href=
 * "../../../requirements/ui-overview.html"> Section 2.1.</a> and <a href=
 * "../../../requirements/settings-overview.html"> Section 2.8.</a>of
 * the requirements, in particular Figure 1 in Section 2.1.
 *
 * Created by rgarmsen on 11/7/15.
 */
public class UserModel {
    /**
     * A unique random identifier, automatically assigned at account creation.
     */
    private String id;

    /**
     * A unique identifier chosen by the user at account creation.
     */
    private String username;

    /**
     * The string a user enters to login.  Chosen by the user at account creation.
     */
    private String password;

    /**
     * The current settings chosen by the user for the account.  This includes non-essential
     * features such as color settings.
     */
    private UserSettingsModel currentSettings;

    public UserModel (String newUsername, String newPassword) {
        id = UUID.randomUUID().toString();
        System.out.println("id = " + id);

        username = newUsername;
        System.out.println("username = " + username);

        password = newPassword;
        System.out.println("password = " + password);

        currentSettings = new UserSettingsModel();
        System.out.println("userSettings = " + currentSettings.toString());
    }

    /**
     * Gets the id of the user.
     * @return This user's id.
     */
    public String getId() {
        return id;
    }

    /**
     * Gets the username of the user.
     * @return This user's username.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the user's password if and only if the old password matches their current password.
     * @param currentPassword  The user's current password.
     * @param newPassword The user's new password.
     */
    public void setPassword(String currentPassword, String newPassword) {
        if (currentPassword.equals(password)) {
            password = newPassword;
        }
    }

    /**
     * Gets the current settings of the user.
     * @return This user's current settings.
     */
    public UserSettingsModel getUserSettings() {
        return currentSettings;
    }

    /**
     * Sets the user's current settings.
     * @param newSettings  The user's new settings.
     */
    public void setUserSettings(UserSettingsModel newSettings) {
        currentSettings = newSettings;
    }
}
