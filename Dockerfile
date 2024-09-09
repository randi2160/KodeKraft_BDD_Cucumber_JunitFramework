# Use an official Maven image
FROM maven:3.8.4-jdk-11

# Set the working directory in the container
WORKDIR /app

# Copy the pom.xml and source code
COPY pom.xml .
COPY src ./src

# Build the application (this will also download dependencies)
RUN mvn clean package -DskipTests

# Set environment variables (these can be overridden in CI/CD pipeline)
ENV BROWSER=chrome
ENV HEADLESS=true
ENV SELENIUM_GRID_URL=http://selenium-hub:4444

# Use shell form to run Maven, which allows variable substitution
CMD mvn clean test -Dbrowser=${BROWSER} -Dheadless=${HEADLESS} -Dselenium.grid.url=${SELENIUM_GRID_URL}
