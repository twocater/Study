package com.cpaladin.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Properties;

public class PropertyUtils {

    private static final String PATH_SEPARATOR = "/";

    public static Properties getPropertiesFromResource(String file) {
        Properties properties = new Properties();
        InputStream in = null;
        if (file.indexOf(PATH_SEPARATOR) != 0) {
            file = PATH_SEPARATOR + file;
        }
        try {
            in = PropertyUtils.class.getResourceAsStream(file);
            properties.load(in);
        } catch (IOException e) {
            throw new IllegalStateException("read file fail.", e.getCause());
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                }
            }
        }
        return properties;
    }

    public static Properties getPropertiesFromResource(String file, String charset) {
        Properties properties = new Properties();
        BufferedReader in = null;
        if (file.indexOf(PATH_SEPARATOR) != 0) {
            file = PATH_SEPARATOR + file;
        }
        try {
            in = new BufferedReader(new InputStreamReader(PropertyUtils.class.getResourceAsStream(file), charset));
            properties.load(in);
        } catch (IOException e) {
            throw new IllegalStateException("read file fail.", e.getCause());
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                }
            }
        }
        return properties;
    }

    public static Properties getPropertiesFromFile(String file) {
        Properties properties = new Properties();
        FileInputStream fileIn = null;
        try {
            fileIn = new FileInputStream(file);
            properties.load(fileIn);
        } catch (IOException e) {
            throw new IllegalStateException("read file fail.", e.getCause());
        } finally {
            if (fileIn != null) {
                try {
                    fileIn.close();
                } catch (IOException e) {
                }
            }
        }
        return properties;
    }

    public static Properties getPropertiesFromResourceWithReader(String file) {
        Properties properties = new Properties();
        Reader in = null;
        if (file.indexOf(PATH_SEPARATOR) != 0) {
            file = PATH_SEPARATOR + file;
        }
        try {
            in = new InputStreamReader(PropertyUtils.class.getResourceAsStream(file),"utf-8");
            properties.load(in);
        } catch (IOException e) {
            throw new IllegalStateException("read file fail.", e.getCause());
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                }
            }
        }
        return properties;
    }
    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(PropertyUtils.getPropertiesFromResource("masterdb.properties"));
        System.out.println(PropertyUtils.getPropertiesFromResource("slavedb.properties"));
    }
}
