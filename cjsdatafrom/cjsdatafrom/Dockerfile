FROM ${docker.registry.public}/fileserver-base-${spring.profile}:latest
ENV TZ=Asia/Shanghai LANG=C.UTF-8
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone
WORKDIR /
COPY ${project.build.finalName}.jar ${project.artifactId}.jar
ENTRYPOINT ["java", "-Duser.timezone=GMT+08", "-jar", "${project.artifactId}.jar"]