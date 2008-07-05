/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.berlios.kcookb.gui.utils;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Knitter
 */
public class Settings {

    private static final Settings me = new Settings();
    private boolean populateCategories;
    private boolean saveCreationDate;
    private boolean useHome;
    private String customLocation;
    private boolean useProxy;
    private String username;
    private String password;
    private String proxyType;
    private String proxyPort;
    private String proxyAddress;
    private String email;
    private String owner;
    private Properties props;
    private File settings;

    private Settings() {
        String filepath = System.getProperty("user.home") + File.separator + ".kcookb";
        File folder = new File(filepath);
        settings = new File(filepath + File.separator + "kcookb.settings");
        try {
            if(!folder.exists()) {
                folder.mkdir();
            }
            
            if (!settings.exists()) {
                settings.createNewFile();
            }
            props = new Properties();

            props.load(new FileReader(settings));
            populateCategories = Boolean.valueOf(props.getProperty("populate.categories", "false"));
            saveCreationDate = Boolean.valueOf(props.getProperty("save.creation.date", "false"));
            useHome = Boolean.valueOf(props.getProperty("use.home", "false"));
            customLocation = props.getProperty("custom.location", "");
            useProxy = Boolean.valueOf(props.getProperty("use.proxy", "false"));
            username = props.getProperty("username", "");
            password = props.getProperty("password", "");
            proxyType = props.getProperty("proxy.type", "");
            proxyPort = props.getProperty("proxy.port", "");
            proxyAddress = props.getProperty("proxy.address", "");
            email = props.getProperty("email", "");
            owner = props.getProperty("owner", "");
        } catch (IOException ex) {
            Logger.getLogger(Settings.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static final Settings getSettings() {
        return me;
    }

    public void saveSettings() {
        props.setProperty("populate.categories", String.valueOf(populateCategories));
        props.setProperty("save.creation.date", String.valueOf(saveCreationDate));
        props.setProperty("use.home", String.valueOf(useHome));
        props.setProperty("custom.location", customLocation);
        props.setProperty("use.proxy", String.valueOf(useProxy));
        props.setProperty("username", username);
        props.setProperty("password", password);
        props.setProperty("proxy.type", proxyType);
        props.setProperty("proxy.port", proxyPort);
        props.setProperty("proxy.address", proxyAddress);
        props.setProperty("email", email);
        props.setProperty("owner", owner);
        try {
            props.store(new FileWriter(settings), "");
        } catch (IOException ex) {
            Logger.getLogger(Settings.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getCustomLocation() {
        return customLocation;
    }

    public void setCustomLocation(String customLocation) {
        this.customLocation = customLocation;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isPopulateCategories() {
        return populateCategories;
    }

    public void setPopulateCategories(boolean populateCategories) {
        this.populateCategories = populateCategories;
    }

    public String getProxyAddress() {
        return proxyAddress;
    }

    public void setProxyAddress(String proxyAddress) {
        this.proxyAddress = proxyAddress;
    }

    public String getProxyPort() {
        return proxyPort;
    }

    public void setProxyPort(String proxyPort) {
        this.proxyPort = proxyPort;
    }

    public String getProxyType() {
        return proxyType;
    }

    public void setProxyType(String proxyType) {
        this.proxyType = proxyType;
    }

    public boolean isSaveCreationDate() {
        return saveCreationDate;
    }

    public void setSaveCreationDate(boolean saveCreationDate) {
        this.saveCreationDate = saveCreationDate;
    }

    public boolean isUseHome() {
        return useHome;
    }

    public void setUseHome(boolean useHome) {
        this.useHome = useHome;
    }

    public boolean isUseProxy() {
        return useProxy;
    }

    public void setUseProxy(boolean useProxy) {
        this.useProxy = useProxy;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
