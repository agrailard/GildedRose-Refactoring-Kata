package com.gildedrose;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GoldenmasterThirtyDaysTest {
    // Sauvegarder la sortie de la console d'origine pour la restaurer après le test
    private final PrintStream originalOut = System.out;
    private final ByteArrayOutputStream consoleOutput = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        // Rediriger la sortie standard vers un ByteArrayOutputStream
        System.setOut(new PrintStream(consoleOutput));
    }

    @AfterEach
    public void tearDown() {
        // Restaurer la sortie standard après le test
        System.setOut(originalOut);
    }

    @Test
    public void testLogsAgainstExpectedFile() throws Exception {
        // Exécuter le code qui génère les logs dans la console
        TexttestFixture.main(new String[]{});

        // Lire les logs générés par le programme
        String actualLogs = consoleOutput.toString("UTF-8");

        // Lire le fichier texte attendu pour la comparaison
        String expectedLogs = new String(Files.readAllBytes(Paths.get("src/test/resources/Goldenmaster_ThirtyDays_expected_logs.txt")), StandardCharsets.UTF_8);

        // Comparer les logs générés avec le contenu du fichier attendu
        assertEquals(expectedLogs.trim(), actualLogs.trim(), "Les logs générés ne correspondent pas aux logs attendus");
    }
}
