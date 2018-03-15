export JAVA_HOME=/ceph/client/jdk1.8.0_152
export JRE_HOME=${JAVA_HOME}/jre
export CLASSPATH=.:${JAVA_HOME}/lib:${JRE_HOME}/lib
export PATH=$JAVA_HOME/bin:$PATH

# 配置文件
java -jar k8sclienttest-1.0-SNAPSHOT.jar   /<Path>/kube-client.conf   <namespace>
# Token文件
java -jar k8sclienttest-1.0-SNAPSHOT.jar   https://<master-ip/dns>:port  tokenId  <Path>/ca.crt  <namespace>
