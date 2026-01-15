#!/bin/bash

# Maven Wrapper Script for Spring Boot Demo
# Usage: ./run.sh [command]

# Colors for output
GREEN='\033[0;32m'
BLUE='\033[0;34m'
NC='\033[0m' # No Color

# Make sure mvnw is executable
chmod +x ./mvnw

# Function to display usage
show_usage() {
    echo -e "${BLUE}Usage: ./run.sh [command]${NC}"
    echo ""
    echo "Available commands:"
    echo "  clean       - Clean the project (removes target directory)"
    echo "  install     - Clean, compile, test, and package"
    echo "  test        - Run tests"
    echo "  compile     - Compile the project"
    echo "  run         - Run the Spring Boot application"
    echo "  start       - Clean, install, and run the application"
    echo "  help        - Show this help message"
    echo ""
    echo "Examples:"
    echo "  ./run.sh clean"
    echo "  ./run.sh install"
    echo "  ./run.sh run"
    echo "  ./run.sh start"
}

# Check if command is provided
if [ $# -eq 0 ]; then
    show_usage
    exit 1
fi

COMMAND=$1

case $COMMAND in
    clean)
        echo -e "${GREEN}Cleaning project...${NC}"
        ./mvnw clean
        ;;
    install)
        echo -e "${GREEN}Installing project (clean, compile, test, package)...${NC}"
        ./mvnw clean install
        ;;
    test)
        echo -e "${GREEN}Running tests...${NC}"
        ./mvnw test
        ;;
    compile)
        echo -e "${GREEN}Compiling project...${NC}"
        ./mvnw compile
        ;;
    run)
        echo -e "${GREEN}Starting Spring Boot application...${NC}"
        ./mvnw spring-boot:run
        ;;
    start)
        echo -e "${GREEN}Cleaning, installing, and starting application...${NC}"
        ./mvnw clean install && ./mvnw spring-boot:run
        ;;
    help)
        show_usage
        ;;
    *)
        echo -e "${BLUE}Unknown command: $COMMAND${NC}"
        echo ""
        show_usage
        exit 1
        ;;
esac
