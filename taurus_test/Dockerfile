FROM python:3.11.2-slim-buster

WORKDIR /var/app

# install app
RUN apt-get update && \
    apt-get -y install gcc openjdk-11-jdk

# ---- setting application ------
# Install PyPI packages

# TODO: pipenvからインストールして実行できるようにしたい
RUN pip install -U pip &&\
    pip install bzt
