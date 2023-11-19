# Start from the base image
FROM mcr.microsoft.com/devcontainers/java:1-21-bullseye

# Install Docker CLI
RUN apt-get update && apt-get install -y docker.io

# Mavenのバージョンを環境変数として定義します。
ENV MAVEN_VERSION 3.6.3

# Mavenをダウンロードし、解凍し、シンボリックリンクを作成します。
RUN curl -fsSL https://archive.apache.org/dist/maven/maven-3/$MAVEN_VERSION/binaries/apache-maven-$MAVEN_VERSION-bin.tar.gz | tar xzf - -C /opt \
    && ln -s /opt/apache-maven-$MAVEN_VERSION /opt/maven

# PATH環境変数にMavenのbinディレクトリを追加します。
ENV PATH ${PATH}:/opt/maven/bin