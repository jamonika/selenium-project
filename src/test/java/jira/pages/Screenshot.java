package jira.pages;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Screenshot {

    private WebDriver driver;
    public static final Path defaultScreenshotPath = Path.of("src","main", "resources", "screenshots");

    public Screenshot(WebDriver driver) {
        this.driver = driver;
    }

    public File takeScreenshot() throws IOException {
        File tmpFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        Path newPath = defaultScreenshotPath.resolve(tmpFile.getName());
        Files.move(tmpFile.toPath(), newPath);
        return newPath.toFile();
    }
}
