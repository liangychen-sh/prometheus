# prometheus
prometheus demo

start prometheus command
 ./prometheus --config.file=../prometheus.yml --web.listen-address=0.0.0.0:9090 --web.enable-admin-api --web.external-url=http://localhost:9090/prometheus/ &
 
 
 ./prometheus --config.file=../prometheus.yml --web.listen-address=0.0.0.0:9090 --web.enable-admin-api --web.enable-lifecycle --web.external-url=http://localhost:9090/prometheus/ & bg
 
 Start App
 sudo -i
 go to ~/app/prometheus/target folder
 run: 
java -javaagent:../../jmxexport/jmx_prometheus_javaagent-0.13.0.jar=7000:../../jmxexport/jmx_prometheus.yml -jar prometheus-1.0-SNAPSHOT.jar & bg

start node export
sudo -i
go to ~/nodeexport folder
./node_exporter &
