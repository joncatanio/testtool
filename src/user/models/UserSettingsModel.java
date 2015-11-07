package user.models;

/**
 * UserSettings contains all the methods and operations that allow a user
 * to customize his or her settings by changing their User object.
 *
 * UserSettings is derived from <a href=
 * "../../../requirements/settings-overview.html"> Section 2.8.</a> and its various
 * subclasses.
 *
 * Created by rgarmsen on 11/7/15.
 */
public class UserSettingsModel {
    /**
     * The user's real-world name.
     */
    private String name;

    /**
     * The email given by the user for things like notifications.
     */
    private String email;

    /**
     * The user's chosen color theme for the application.  Defaults to white.
     */
    private String themeColor;

    /**
     * Whether the user has waived their FERPA rights. Defaults to false.
     */
    private boolean ferpaStatus;

    /**
     * Gets the current name of the user.
     * @return This user's name.
     */
    public String getName() {
        System.out.println("name= " + name);
        return name;
    }

    /**
     * Sets the current name of the user.
     * @param newName The user's new name.
     */
    public void setName(String newName) {
        System.out.println("name= " + newName);
        name = newName;
    }

    /**
     * Gets the current email of the user.
     * @return This user's email.
     */
    public String getEmail() {
        System.out.println("email= " + email);
        return email;
    }

    /**
     * Sets the current email of the user.
     * @param newEmail The user's new email.
     */
    public void setEmail(String newEmail) {
        System.out.println("name= " + newEmail);
        email = newEmail;
    }

    /**
     * Gets the current theme color of the user.
     * @return This user's theme color.
     */
    public String getThemeColor() {
        System.out.println("themeColor= " + themeColor);
        return themeColor;
    }

    /**
     * Sets the current theme color of the user.
     * @param newThemeColor The user's new theme color.
     */
    public void setThemeColor(String newThemeColor) {
        System.out.println("newThemeColor= " + newThemeColor);
        themeColor = newThemeColor;
    }

    /**
     * Gets the current ferpa status of the user.
     * @return The current ferpa status of the user.
     */
    public boolean getFerpaStatus() {
        System.out.println("ferpaStatus= " + ferpaStatus);
        return ferpaStatus;
    }

    /**
     * Sets the current FERPA status for the user.
     * @param newFerpaStatus The user's new ferpa status.
     */
    public void setFerpaWaived(boolean newFerpaStatus) {
        System.out.println("newFerpaStatus= " + newFerpaStatus);
        ferpaStatus = newFerpaStatus;
    }

    /**
     * Updates a user's settings using the id of the provided User object and compares to
     * see what has changed and must be updated.  The changed object is provided using the
     * settings GUI.
     * @param u Updates the user with new settings.
     */
    void updateUserSettings(UserModel u) {

    }
}
