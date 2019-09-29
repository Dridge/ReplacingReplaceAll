import java.util.List;
import java.util.stream.Collectors;

public class StringReplacer {
    String currentString;

    public StringReplacer(String stringToReplace) {
        currentString = stringToReplace;
    }

    public String toString() {
        return currentString;
    }

    public void replaceChar(char characterToRemove, char characterToReplace) {
        while (currentString.indexOf(characterToRemove) > 0) {
            int indexOfChar = currentString.indexOf(characterToRemove);
            currentString = currentString.substring(0, indexOfChar).concat(String.valueOf(characterToReplace))
                    .concat(currentString.substring(++indexOfChar, currentString.length()));
        }
    }

    public void replaceCharWithRecursion(char characterToRemove, char characterToReplace) {
        int indexOfChar = currentString.indexOf(characterToRemove);
        if (indexOfChar > 0 ) {
            indexOfChar = currentString.indexOf(characterToRemove);
            currentString = currentString.substring(0, indexOfChar).concat(String.valueOf(characterToReplace))
                    .concat(currentString.substring(++indexOfChar, currentString.length()));
            replaceCharWithRecursion(characterToRemove, characterToReplace);
        }
    }

    public void replaceCharWithCollectionIteration(char characterToRemove, char characterToReplace) {
        String stringInProgress = "";
        List<Integer> list = currentString.chars().boxed().collect(Collectors.toList());
        for (Integer i : list) {
            if (i != characterToRemove) {
                stringInProgress = stringInProgress + Character.toString(i);
            } else {
                stringInProgress = stringInProgress + characterToReplace;
            }
        }
        currentString = stringInProgress;
    }

    public void replaceCharWithStreamFiltering(char characterToRemove, char characterToReplace) {
        String stringInProgress = "";
        List<Integer> list = currentString.chars().boxed().map(integer -> integer == characterToRemove ?
                characterToReplace : integer).collect(Collectors.toList());
        for (Integer i : list) {
                stringInProgress = stringInProgress + Character.toString(i);
        }
        currentString = stringInProgress;
    }

    public void replaceCharWithSimpleReplace(char characterToRemove, char characterToReplace) {
        currentString = currentString.replaceAll(String.valueOf(characterToRemove), String.valueOf(characterToReplace));
    }
}
