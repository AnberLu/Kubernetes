package com.ln.k8s.client.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

public class K8sProperty {
    private static final Logger LOGGER = LoggerFactory.getLogger(K8sProperty.class);

    public static String kubeConfig="";
    public static String caFile="";
    public static String masterUrl="";
    public static String tokenID="";
    public static String nameSpace="";

    public static void setKubeConfig(String kubeConfig) {
        LOGGER.info("k8s客户端配置文件： "+kubeConfig);
        K8sProperty.kubeConfig = kubeConfig;
    }

    public static String getKubeConfig() {
        return kubeConfig;
    }

    public static String getCaFile() {
        return caFile;
    }

    public static void setCaFile(String caFile) {
        LOGGER.info("k8s认证文件： "+caFile);
        K8sProperty.caFile = caFile;
    }

    public static String getMasterUrl() {
        return masterUrl;
    }

    public static void setMasterUrl(String masterUrl) {
        LOGGER.info("k8s Master Url： "+masterUrl);
        K8sProperty.masterUrl = masterUrl;
    }

    public static String getTokenID() {
        return tokenID;
    }

    public static void setTokenID(String tokenID) {
        LOGGER.info("k8s tokenID： "+tokenID);
        K8sProperty.tokenID = tokenID;
    }

    public static String getNameSpace() {
        return nameSpace;
    }

    public static void setNameSpace(String nameSpace) {
        K8sProperty.nameSpace = nameSpace;
    }
}
