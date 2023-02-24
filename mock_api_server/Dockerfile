FROM python:3.11.2-slim-buster

WORKDIR /var/app

# install app
RUN apt-get update && \
    apt-get -y install gcc libmariadb-dev

# ---- setting application ------
COPY Pipfile /var/app/
COPY Pipfile.lock /var/app/

# Install PyPI packages
RUN pip install -U pip &&\
    pip install pipenv &&\
    pipenv install --ignore-pipfile

ENTRYPOINT pipenv run python src/main.py