package exo;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Transformer {

    /**
     *
     * @param token
     * @param value
     */

    private Map<String, String> tokens = new HashMap<>();

    public void addToken(String token, String value){
        tokens.put(token, value);
    }

    public String transform(String text){
        String newText = text;

        for (Map.Entry<String, String> token : tokens.entrySet()) {
            newText = text.replace("["+ token.getKey() + "]", token.getValue());
        }

/**
 * tokens.forEach((token, value) -> {
 * text.replaceAll("["+ token + "]", value);});
 */

        return newText;
    }
    public String transform2(String text){
        int capacity = (int)(text.length()*1.2f);
        StringBuilder stringBuilder = new StringBuilder(capacity);

        Pattern pattern = Pattern.compile("\\{(.*)\\}");
        Matcher matcher = pattern.matcher(text);

        // Pour chaque occurence de token dans le texte
        while (matcher.find()){
            // Récupérer le nom du token
            String token = matcher.group(1);
            // Récupérer la valeur associée au token
            String value = tokens.get(token);
            if (value != null){
                matcher.appendReplacement(stringBuilder, token);
            } else {
                matcher.appendReplacement(stringBuilder, "{" + token + "}");
            }

        }
        return text;
    }


}