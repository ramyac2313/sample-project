FROM ubuntu:16.04

RUN apt-get update && apt-get clean && apt-get install -y \
    x11vnc \
    xvfb \
    fluxbox \
    wmctrl \
    wget \
    curl \
    apt-transport-https \
    ca-certificates \
    python-pip \
    && curl -sSL https://deb.nodesource.com/setup_12.x | bash - \
    && wget -q -O - https://dl-ssl.google.com/linux/linux_signing_key.pub | apt-key add - \
    && echo "deb http://dl.google.com/linux/chrome/deb/ stable main" >> /etc/apt/sources.list.d/google.list \
    && apt-get update && apt-get -y install google-chrome-stable \
    nodejs

ARG CACHEBUST=1
RUN npm install -g lighthouse \
    && pip install --upgrade pip \
    && pip install flask waitress

RUN useradd apps \
    && mkdir -p /home/apps \
    && chown -v -R apps:apps /home/apps

COPY bootstrap.sh /

CMD '/bootstrap.sh'

WORKDIR /python-listener-scripts

COPY listener.py listener.py
COPY SPA_Config.json SPA_Config.json

#ENTRYPOINT ["python", "listener.py"]
