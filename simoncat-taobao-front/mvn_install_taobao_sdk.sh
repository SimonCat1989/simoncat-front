# ./mvn_install_taobao_sdk.sh ~/Downloads/sdk-java-24958642/taobao-sdk-java-auto_1521526934105-20180723.jar

PATH_OF_SDK=$1

mvn install:install-file -Dfile=${PATH_OF_SDK} -DgroupId=com.taobao -DartifactId=taobao-sdk-java -Dversion=1.0 -Dpackaging=jar