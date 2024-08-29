
package utils;

import java.io.IOException;
import java.nio.file.*;

public class CopyUtil  {

    public static void copyAllureResults() {
        Path sourceDirectory = Paths.get("allure-results");
        Path targetDirectory = Paths.get("target", "allure-results");

        try {
            if (!Files.exists(targetDirectory)) {
                Files.createDirectories(targetDirectory);
            }

            Files.walk(sourceDirectory)
                    .forEach(source -> {
                        try {
                            Path destination = targetDirectory.resolve(sourceDirectory.relativize(source));
                            if (Files.isDirectory(source)) {
                                if (!Files.exists(destination)) {
                                    Files.createDirectory(destination);
                                }
                            } else {
                                Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
