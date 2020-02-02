# inspired by https://github.com/hauptmedia/docker-jmeter  and
# https://github.com/hhcordero/docker-jmeter-server/blob/master/Dockerfile
FROM alpine:3.10

MAINTAINER Just van den Broecke<just@justobjects.nl>

ARG JMETER_VERSION="5.1.1"
ENV JMETER_HOME /opt/apache-jmeter-${JMETER_VERSION}
ENV	JMETER_BIN	${JMETER_HOME}/bin
ENV	JMETER_DOWNLOAD_URL  https://archive.apache.org/dist/jmeter/binaries/apache-jmeter-${JMETER_VERSION}.tgz

# Install extra packages
# See https://github.com/gliderlabs/docker-alpine/issues/136#issuecomment-272703023
# Change TimeZone TODO: TZ still is not set!
ARG TZ="Europe/Amsterdam"
RUN    apk update \
 && apk upgrade \
 && apk add ca-certificates \
 && update-ca-certificates \
 && apk add --update openjdk8-jre tzdata curl unzip bash \
 && apk add --no-cache nss \
 && rm -rf /var/cache/apk/* \
 && mkdir -p /tmp/dependencies  \
 && curl -L --silent ${JMETER_DOWNLOAD_URL} >  /tmp/dependencies/apache-jmeter-${JMETER_VERSION}.tgz  \
 && mkdir -p /opt  \
 && tar -xzf /tmp/dependencies/apache-jmeter-${JMETER_VERSION}.tgz -C /opt  \
 && rm -rf /tmp/dependencies \
 && apk add lighttpd openssl openrc

RUN mkdir /etc/lighttpd/ssl/ && \
 openssl req -x509 -newkey rsa:4096 -keyout /tmp/key.pem -out /tmp/cert.pem -days 365 -subj '/CN=localhost' -nodes -sha256 && \
 cat /tmp/key.pem /tmp/cert.pem > /etc/lighttpd/ssl/localhost.pem && \
 rm /tmp/key.pem /tmp/cert.pem && \
 chmod 400 /etc/lighttpd/ssl/localhost.pem

# Copy lighttpd config files. At this point it is all default except
# including a custom ssl.conf in lighttpd.conf.
COPY config/lighttpd/*.conf /etc/lighttpd/
COPY htdocs/index.html /var/www/localhost/htdocs/

# TODO: plugins (later)
# && unzip -oq "/tmp/dependencies/JMeterPlugins-*.zip" -d $JMETER_HOME

# Set global PATH such that "jmeter" command is found
ENV PATH $PATH:$JMETER_BIN

## Copy jmeter test files and execution scripts

RUN mkdir -p /docker-jmeter/tests/results
COPY tests/trivial/test-plan.jmx /docker-jmeter/test-plan.jmx
RUN chmod +x /docker-jmeter/test-plan.jmx

COPY jmeter-tests.sh /docker-jmeter/
RUN chmod +x /docker-jmeter/jmeter-tests.sh

WORKDIR	/docker-jmeter/
CMD ["./jmeter-tests.sh"]
