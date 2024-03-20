FROM centos:latest

RUN cd /etc/yum.repos.d/
RUN sed -i 's/mirrorlist/#mirrorlist/g' /etc/yum.repos.d/CentOS-*
RUN sed -i 's|#baseurl=http://mirror.centos.org|baseurl=http://vault.centos.org|g' /etc/yum.repos.d/CentOS-*

RUN yum install -y unzip wget

RUN wget https://github.com/duckdb/duckdb/releases/download/v0.10.1/duckdb_cli-linux-amd64.zip
RUN unzip duckdb_cli-linux-amd64.zip 

ENTRYPOINT ["tail", "-f", "/dev/null"]