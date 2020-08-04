#!/bin/bash -e


show_help() {
    echo "USAGE: $0 [-v|--verbose] [--resetdb]"
    echo "         [--with-ofbiz] [-b|--background]"
    echo
    echo "This script can run Rooters and its dependencies inside docker containers."
    echo "By default, it only runs Rooters's dependencies, which is optimal for getting"
    echo "started with Rooters development."
    echo
    echo "Options:"
    echo "    --verbose,-v      be extra verbose"
    echo "    --resetdb         clean up and reset the databases/persisted data"
    echo "    --with-rooters     run Rooters as well as its dependencies"
    echo "                      Note: you need to have built Rooters in"
    echo "                      '../rooters'. Just running 'mvn package'"
    echo "                      in that directory should do the job."
    echo "    --background,-b   run docker containers in the background"
    echo "    --stop            stops any running services"
    echo "    --prefix,-p       prefix the running containers with a specific"
    echo "                      string, useful for running multiple instances"
    echo "    --exec,-e         execute the specified docker-compose command"
    echo
    echo "Environment Variables:"
    echo "    DOCKER_COMPOSE_PARAMS   is passed to docker-compose, it can contain"
    echo "                      overriden docker-compose file or other parameters"
    echo "                      Example: -f xyz.yml (to include xyz.yml in configurations)"

}

# Initialize our own variables:
verbose=0
with_rooters=0
run_in_background=0
reset_db=0
stop=0
prefix="docker"
exec=""

while [[ $# > 0 ]]
do
  key="$1"
  shift

  case $key in
    -v|--verbose)
      verbose=1
      set -x
    ;;
    -h|--help)
      show_help
      exit 1
    ;;
    --with-rooters)
      with_rooters=1
    ;;
    --resetdb)
      reset_db=1
    ;;
    -b|--background)
      run_in_background=1
    ;;
    -p|--prefix)
      prefix="$1"
      shift
    ;;
    -e|--exec)
      exec="$1"
      shift
    ;;
    --stop)
      stop=1
    ;;
    *)
      echo "Unknown option $key" >&2
      show_help
      exit 1
    ;;
  esac
done

if [[ $with_rooters == 0 ]]; then
  if [ "$(uname)" == "Darwin" ]; then
    export DOCKERHOST="10.200.10.20"
    if [ "$(ifconfig | grep $DOCKERHOST)" == "" ]
    then
      echo "Binding $DOCKERHOST.  Please enter your password for sudo."
      sudo ifconfig lo0 alias $DOCKERHOST/24
    fi
  fi
  if [ "$(uname)" == "Linux" ]; then
    export DOCKERHOST="$(ip route show | grep docker0 | awk '{print $9}')"
    if [ "$(ifconfig | grep $DOCKERHOST)" == "" ]
    then
      echo "Binding $DOCKERHOST.  Please enter your password for sudo."
      sudo ifconfig lo0 alias $DOCKERHOST/24
    fi
  fi
  DOCKER_CONFIG="-f docker-compose.yml -f docker-compose-devdeps.yml"
else
  DOCKER_CONFIG="-f docker-compose.yml"
fi
echo "Dockert config ----- $DOCKER_CONFIG"
DOCKER_UP_EXTRA="--remove-orphans"
if [[ $run_in_background == 1 ]]; then
  DOCKER_UP_EXTRA="$DOCKER_UP_EXTRA -d"
fi


DOCKER_CONFIG="$DOCKER_COMPOSE_PARAMS $DOCKER_CONFIG"

if [[ $reset_db == 1 ]]; then
  docker-compose $DOCKER_CONFIG down -v
fi

if [[ $stop == 1 ]]; then
  docker-compose $DOCKER_CONFIG stop
  #stop and exit
  exit 0
fi

if [ "$exec" != "" ]; then
  docker-compose $DOCKER_CONFIG $exec
  exit 0
fi

docker-compose $DOCKER_CONFIG build
docker-compose $DOCKER_CONFIG up $DOCKER_UP_EXTRA
