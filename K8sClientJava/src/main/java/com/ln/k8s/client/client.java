package com.ln.k8s.client;

import com.ln.k8s.client.config.K8sConfig;
import com.ln.k8s.client.config.K8sProperty;
import io.fabric8.kubernetes.api.model.PodList;
import io.fabric8.kubernetes.client.KubernetesClient;

public class client {
    private static KubernetesClient kclient;

    public static void main(String [] args){
        if(args.length<2){
            System.out.println("kubeconfig配置文件: 请输入 kubeconfig和Namespace");
            System.out.println("WebHook单向验证： 请输入Url,TokenId,Ca证书和Namespace");
            return;
        }
        if(args.length>2 && args.length<4){
            System.out.println("WebHook单向验证： 请输入Url,TokenId,Ca证书和Namespace");
            return;
        }

        if(args.length==2){     //k8s配置文件
            K8sProperty.setKubeConfig(args[0].trim());
            K8sProperty.setNameSpace(args[1].trim());

        }else if(args.length>2){ //Token文件
            K8sProperty.setMasterUrl(args[0]);
            K8sProperty.setTokenID(args[1].trim());
            K8sProperty.setCaFile(args[2].trim());
            K8sProperty.setNameSpace(args[3].trim());

        }
        //客户端获取pod数
        K8sConfig kc=new K8sConfig();
        kclient=kc.getClient();
        PodList pl=kclient.pods().inNamespace(K8sProperty.getNameSpace()).list();
        System.out.println("PodList Size: "+pl.getItems().size());

    }
}
