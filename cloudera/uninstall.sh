#!/usr/bin/env bash


/usr/share/cmf/uninstall-cloudera-manager.sh

apt-get purge 'cloudera-manager-*'

umount cm_processes
rm -Rf /usr/share/cmf /var/lib/cloudera* /var/cache/yum/cloudera* /var/log/cloudera* /var/run/cloudera*

rm -Rf /var/lib/flume-ng /var/lib/hadoop* /var/lib/hue /var/lib/navigator /var/lib/oozie /var/lib/solr /var/lib/sqoop* /var/lib/zookeeper
