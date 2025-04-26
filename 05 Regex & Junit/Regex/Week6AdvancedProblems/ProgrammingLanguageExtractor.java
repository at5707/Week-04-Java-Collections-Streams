import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProgrammingLanguageExtractor {
    public static List<String> extractProgrammingLanguages(String text) {
        String[] languages={
            "Java", "Python", "JavaScript", "Go", "C", "C++", "Ruby", "PHP", "Swift", "Kotlin", 
            "Rust", "TypeScript", "Perl", "Scala", "Dart", "Haskell", "Lua", "R", "Objective-C"
        };
        StringBuilder regexBuilder=new StringBuilder("\\b(");
        for (int i = 0; i < languages.length; i++) {
            regexBuilder.append(languages[i]);
            if (i<languages.length-1) {
                regexBuilder.append("|");
            }
        }
        regexBuilder.append(")\\b");
        Pattern pattern=Pattern.compile(regexBuilder.toString());
        Matcher matcher=pattern.matcher(text);
        List<String> foundLanguages=new ArrayList<>();
        while (matcher.find()) {
            foundLanguages.add(matcher.group());
        }
        return foundLanguages;
    }
    public static void main(String[] args) {
        String text = "I love Java, Python, and JavaScript, but I haven't tried Go yet.";
        List<String> languages=extractProgrammingLanguages(text);
        System.out.println(String.join(", ", languages));
    }
}