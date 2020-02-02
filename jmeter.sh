#!/bin/bash

# Basically runs jmeter, assuming the PATH is set to point to JMeter bin-dir (see Dockerfile)
set -e
freeMem=`awk '/MemFree/ { print int($2/1024) }' /proc/meminfo`
s=$(($freeMem/10*8))
x=$(($freeMem/10*8))
n=$(($freeMem/10*2))
export JVM_ARGS="-Xmn${n}m -Xms${s}m -Xmx${x}m"

echo "START Running Jmeter on `date`"
echo "JVM_ARGS=${JVM_ARGS}"
echo "jmeter args=$@"

/bin/rm -rf /docker-jmeter/tests/results > /dev/null 2>&1
mkdir /docker-jmeter/tests/results

jmeter -n -f -t /docker-jmeter/test-plan.jmx -l /docker-jmeter/tests/results/test-plan-results.jtl -j /docker-jmeter/tests/results/test-plan.log -e -o /docker-jmeter/tests/results
echo "END Running Jmeter on `date`"

/usr/sbin/lighttpd -D -f /etc/lighttpd/lighttpd.conf &

# Copy html and its related files to the root folder of web server
cp -Rf /docker-jmeter/tests/results/* /var/www/localhost/htdocs/

## To prevent container from exiting
ls && /bin/bash
