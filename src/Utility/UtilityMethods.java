package utility;

/**
 * Created by JonCatanio on 12/9/15.
 */
public class UtilityMethods {
    /**
     * Having to create this wonderful method because Kendall refused to use the Enum yay!
     *
     * @param type The beautiful enum!
     * @return
     */
    public static String convertEnumToString(EQuestionTypes type) {
        switch (type) {
            case FILL_IN_THE_BLANK:
                return "Fill in The Blank";
            case MULTIPLE_CHOICE:
                return "Multiple Choice";
            case MULTIPLE_SELECT:
                return "Multiple Select";
            case FREE_RESPONSE:
                return "Free Response";
            case SHORT_ANSWER:
                return "Short Answer";
            case CODING:
                return "Coding";
            case UML:
                return "UML";
            case MATCHING:
                return "Matching";
            default:
                System.out.println("Not a valid type.");
                return null;
        }
    }
}
