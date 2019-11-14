package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

/**
 * @author jzx
 * @email:
 * @Date: 2018-09-23 10:18
 */
public class PropertiesCompareUtil {

    static String betaPath = "F:\\promoengMgtService\\src\\main\\conf\\beta";
    static String prdPath = "F:\\promoengMgtService\\src\\main\\conf\\prd";
    static List<Properties> betaProperties = new ArrayList<>();
    static List<Properties> prdProperties = new ArrayList();

    static List<String> betaFileNames = new ArrayList<>();
    static List<String> prdFIleNames = new ArrayList();

    static String[][] diffValue = {{"beta", "prd"}};
    static String excludeFileName = "jdbc2.properties";


    public static void main(String[] args) {
        compareProperties(betaPath, prdPath);
    }


    public static void compareProperties(String betaPath, String prdPath) {
        betaFileNames = getFileList(betaPath);
        prdFIleNames = getFileList(prdPath);
        HashMap<String, String> diff = new LinkedHashMap<>();
        Boolean flag = false;
        for (String fileName : betaFileNames) {
            diff.put(fileName, fileName);
        }
        for (String betaFileName : diff.keySet()) {
            if (excludeFileName.equals(betaFileName)) {
                continue;
            }
            boolean contains = prdFIleNames.contains(betaFileName);
            if (!contains) {
                flag = true;
                System.out.println("beta 配置环境中包含文件:[" + betaFileName + "]" + "prd不存在该配置文件");
            }
        }
        if (flag || prdFIleNames.size() != betaFileNames.size()) {
            System.out.println("配置文件个数不同，不继续向下进行比较。。。。");
            return;
        }
        betaProperties = loadProperties(betaPath);
        prdProperties = loadProperties(prdPath);

        for (int i = 0; i < betaProperties.size(); i++) {
            Properties properties = betaProperties.get(i);
            Set<String> strings = properties.stringPropertyNames();
            HashMap<String, String> keyValue = new LinkedHashMap<>();
            for (String string : strings) {
                keyValue.put(string, properties.getProperty(string));
            }
            for (String s : keyValue.keySet()) {
                Set<String> prdKey = prdProperties.get(i).stringPropertyNames();
                if (!prdKey.contains(s)) {
                    System.out.print("beta配置文件" + betaFileNames.get(i) + "包含key :" + s + " prd 配置文件不包当前key"+System.lineSeparator());
                }

            }
            System.out.println(betaFileNames.get(i) + " 文件比对完成");
            comparePropertiesValue(betaProperties.get(i), prdProperties.get(i));
            //  System.out.println("keyValue = " + keyValue);
        }


    }

    private static void comparePropertiesValue(Properties betaProperties, Properties prdProperties) {

    }

    public static List getFileList(String path) {
        List<String> fileName = new ArrayList<>();
        File file = new File(path);
        File[] files = file.listFiles();
        for (File configFile : files) {
            if(configFile.getName().contains("xml")){
                continue;
            }
            fileName.add(configFile.getName());
        }
        return fileName;
    }

    public static List loadProperties(String path) {
        List<Properties> fileProperties = new ArrayList<>();
        File file = new File(path);
        File[] files = file.listFiles();
        for (File configFile : files) {
            FileInputStream in = null;
            try {
                if(configFile.getName().contains("xml")){
                    continue;
                }
                in = new FileInputStream(configFile);
                Properties properties = new Properties();
                properties.load(in);
                fileProperties.add(properties);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (in != null) {
                    try {
                        in.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

        }
        return fileProperties;
    }
}
