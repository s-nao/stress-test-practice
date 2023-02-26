FROM python:3.11.2-slim-buster

WORKDIR /var/app

# install app
RUN apt-get update && \
    apt-get -y install gcc libmariadb-dev

# ---- setting application ------
COPY Pipfile /var/app/
COPY Pipfile.lock /var/app/

# Install PyPI packages
# typing_extensionsがないと起動ができないため、仕方なく直接インストールする
RUN pip install -U pip && \
    pip install pipenv typing_extensions

RUN pipenv install --ignore-pipfile --system
