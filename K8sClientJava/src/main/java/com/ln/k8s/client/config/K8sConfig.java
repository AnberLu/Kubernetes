package com.ln.k8s.client.config;

import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class K8sConfig {
    static {
        //设置配置文件位置
        if (!K8sProperty.getKubeConfig().equals("")) {
            System.setProperty("kubeconfig", K8sProperty.getKubeConfig());
            System.out.println("kubeconfig:" + K8sProperty.getKubeConfig());
        }
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(K8sConfig.class);

    public static KubernetesClient client;


    public KubernetesClient getClient() {
        return this.client;
    }

    public void setClient(KubernetesClient client) {
        this.client = client;
    }

    public K8sConfig() {
        try {
            Config config = new Config();
            if (K8sProperty.getKubeConfig().equals("")) {
                LOGGER.debug("Url: " + K8sProperty.getMasterUrl() + " TokenId: " + K8sProperty.getTokenID() + " Ca文件：" + K8sProperty.getCaFile());
                config.setMasterUrl(K8sProperty.getMasterUrl());
                config.setOauthToken(K8sProperty.getTokenID());
                config.setCaCertFile(K8sProperty.getCaFile());
                config.setTrustCerts(true);
                config.setWebsocketTimeout(60);
                LOGGER.info("token配置完成");
            }
            this.setClient(new DefaultKubernetesClient(config));
        } catch (KubernetesClientException e) {
            LOGGER.error("[K8sClient]-->" + e);
        }
    }


}
