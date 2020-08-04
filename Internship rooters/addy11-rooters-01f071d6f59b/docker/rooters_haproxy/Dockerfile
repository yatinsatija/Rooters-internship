FROM haproxy:1.7.8-alpine
MAINTAINER Rooters R&D

COPY haproxy.cfg /usr/local/etc/haproxy/
COPY cert_and_key.pem /usr/local/etc/haproxy/
COPY maintenance.html /usr/local/etc/haproxy/error/

CMD ["haproxy", "-f", "/usr/local/etc/haproxy/haproxy.cfg"]
