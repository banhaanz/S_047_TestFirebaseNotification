
## Step build .jar and docker image :

* To compile and build the Docker image locally:
    >$ mvn clean install

* To compile, build, and push the image to a remote repo:
    >$ mvn clean deploy -Ddocker.user=<username> -Ddocker.password=<passwd> -Ddocker.url=<docker-registry-url>

==> see more in Dockerfile