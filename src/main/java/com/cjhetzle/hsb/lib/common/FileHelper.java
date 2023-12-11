package com.cjhetzle.hsb.lib.common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * something.
 * 
 * @author Cameron Hetzler
 *
 */
public class FileHelper {

    private static Logger LOGGER = LoggerFactory.getLogger(FileHelper.class);

    public static Properties readPropertiesFile() {
        Properties mainProperties = new Properties();
        System.out.println(
                "Working Directory = " + System.getProperty("user.dir"));

        do {
            try {
                LOGGER.info("Looking for CONFIG.PROPERTIES: "
                        + Constants.PROP_FILE());
                FileInputStream fis = new FileInputStream(
                        Constants.PROP_FILE());

                mainProperties.load(fis);
                fis.close();
                LOGGER.info(
                        "Continuing operation from: " + Constants.PROP_FILE());
                break;
            } catch (FileNotFoundException e) {
                LOGGER.error(
                        "Properties file Not Found : " + Constants.PROP_FILE());
            } catch (IOException e) {
                LOGGER.error("IO exception reading Properties file: "
                        + Constants.PROP_FILE());
            }
        } while (Constants.CHANGE_DIR_TYPE());

        return mainProperties;
    }
}
