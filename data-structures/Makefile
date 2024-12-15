# Variables
SRC_DIR = src
BIN_DIR = bin
MAIN_CLASS = Main

# Compile the Java source files
compile:
	mkdir -p $(BIN_DIR)
	javac -d $(BIN_DIR) $(SRC_DIR)/*.java

# Run the program
run: compile
	java -cp $(BIN_DIR) $(MAIN_CLASS)

# Clean compiled files
clean:
	rm -rf $(BIN_DIR)

# Help
help:
	@echo "Usage:"
	@echo "  make compile  - Compile the Java project"
	@echo "  make run      - Compile and run the project"
	@echo "  make clean    - Remove compiled files"
