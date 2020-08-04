Install docker >= 1.13

./docker-run.sh

If mysql seems slow on OS X, do the following:

mkdir -p ~/Library/Containers/com.docker.docker/Data/com.docker.driver.amd64-linux/disk   
echo false > ~/Library/Containers/com.docker.docker/Data/com.docker.driver.amd64-linux/disk/full-sync-on-flush   
@see https://github.com/docker/for-mac/issues/668

Some commands:

1. To stop docker compose: sudo docker-compose stop
2. To remove docker compose: sudo docker-compose rm
3. To release system memory used by docker: sudo docker volume prune
4. To run docker,go to docker folder and run: sudo ./docker-run.sh
