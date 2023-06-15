package org.example;

import exo.Transformer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args) {

        Transformer transformer2 = new Transformer();

        String str = "Bonjour mon nom est [name]";

        transformer2.addToken("name", "Nico");

        String result = transformer2.transform(str);

        logger.info(result);

    }
}