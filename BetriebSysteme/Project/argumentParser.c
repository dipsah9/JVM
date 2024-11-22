#include "argumentParser.h"
#include <stddef.h>
#include <errno.h>
#include <stdio.h>
#include <string.h>
// TODO: global vars
static int argc_count = 0;
static char *command = NULL;
static char **args = NULL;

// TODO: helpers


int initArgumentParser(int argc, char* argv[]) {
	
	// TODO: implement me
	if(argc <= 1 && argv == NULL && argv[0][1] == '-'){
		errno = EINVAL;
		printf("%c\n",argv[0][1]);
		return -1;
	}

	        command = argv[0];
    	    args = argv + 1;
    	    argc_count = argc - 1;
    return 0;
}

char* getCommand(void) {
	// TODO: implement me
	return command;
}

int getNumberOfArguments(void) {
	// TODO: implement me
	 int count = 0;
	for(int i = 0; i < argc_count; i++){
        if((*args[i]) != '-'){
            count++;
        }
    }
    return count;
}

char* getArgument(int index) {
	// TODO: implement me
	int numberOfArguments = getNumberOfArguments();
    if(index >= numberOfArguments || index < -numberOfArguments ){
        return NULL;
    }
    if(index < 0){
        return &(*args[numberOfArguments + index]);
    }
    return &(*args[index]);
}

char* getValueForOption(char* keyName) {
	// TODO: implement me
	for (int i = 0; i < argc_count; i++) {
        if (args[i][0] == '-') {
            char* equal_sign = strchr(args[i], '=');
            if (equal_sign != NULL) {
                int key_len = equal_sign - args[i] - 1;
                if (strncmp(args[i] + 1, keyName, key_len) == 0 && keyName[key_len] == '\0') {
                    return equal_sign + 1;
                }
            }
        }
    }
    return NULL;
}
